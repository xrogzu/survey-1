package com.fire.survey.base.m;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import com.fire.survey.base.i.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sesssionFactory;

	private Class<T> entityType;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityType = (Class<T>) type.getActualTypeArguments()[0];

	}

	public Session getSession() {
		return sesssionFactory.openSession();
		// return sesssionFactory.getCurrentSession();
	}

	@Override
	public List<?> getLimitedListByql(String sql, int pageNo, int pageSize, Object... params) {
		int start = (pageNo - 1) * pageSize;
		return getSqlQuery(sql, params).setFirstResult(start).setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getLimitedListByHql(String hql, int pageNo, int pageSize, Object... params) {
		int start = (pageNo - 1) * pageSize;
		return getQuery(hql, params).setFirstResult(start).setMaxResults(pageSize).list();
	}

	@Override
	public int getCountBySql(String sql, Object... params) {
		BigInteger big = (BigInteger) getSqlQuery(sql, params).uniqueResult();
		return big.intValue();
	}

	@Override
	public int getCountByHql(String hql, Object... params) {
		long count = (long) getQuery(hql, params).uniqueResult();
		return (int) count;
	}

	@Override
	public List<?> getListBySql(String sql, Object... params) {
		return getSqlQuery(sql, params).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListByHql(String hql, Object... params) {
		return getQuery(hql, params).list();
	}

	@Override
	public void batchUpdate(String sql, Object[]... params) {
		getSession().doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					Object[] param = params[i];
					for (int j = 0; j < param.length; j++) {
						prepareStatement.setObject(j + 1, param[j]);
					}
					prepareStatement.addBatch();
				}
				prepareStatement.executeBatch();
			}
		});
	}

	@Override
	public void updateEntityByHql(String hql, Object... params) {
		getQuery(hql, params).executeUpdate();
	}

	@Override
	public void updateEntityBySql(String sql, Object... params) {
		getSqlQuery(sql, params).executeUpdate();
	}

	@Override
	public void updateEntity(T t) {
		getSession().update(t);
	}

	@Override
	public void removeEntity(T t) {
		getSession().delete(t);
	}

	@Override
	public void removeEntityById(Integer id) {
		ClassMetadata metadata = sesssionFactory.getClassMetadata(entityType);
		String oid = metadata.getIdentifierPropertyName();
		String sql = "DELETE From " + entityType.getSimpleName() + " alias where alias." + oid + " = ?";
		getQuery(sql, id).executeUpdate();
	}

	@Override
	public void saveEntity(T t) {
		getSession().save(t);
	}

	public Query getQuery(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;
	}

	public SQLQuery getSqlQuery(String sql, Object... params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(Integer entityId) {
		return (T) getSession().get(entityType, entityId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityByHql(String hql, Object... params) {
		return (T) getQuery(hql, params).uniqueResult();
	}
}
