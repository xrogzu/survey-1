package com.fire.survey.base.i;

import java.util.List;

public interface BaseDao<T> {

	List<?> getLimitedListBySql(String sql, int pageNo, int pageSize, Object... params);

	List<T> getLimitedListByHql(String hql, int pageNo, int pageSize, Object... params);

	/**
	 * 查询总记录数
	 */
	int getCountBySql(String sql, Object... params);

	/**
	 * 查询总记录数
	 */
	int getCountByHql(String hql, Object... params);

	/**
	 * 返回结果通常为数组
	 */
	List<?> getListBySql(String sql, Object... params);

	List<T> getListByHql(String hql, Object... params);

	void batchUpdate(String sql, Object[]... params);

	void updateEntityByHql(String hql, Object... params);

	void updateEntityBySql(String sql, Object... params);

	void updateEntity(T t);

	/**
	 * 级联删除
	 */
	void removeEntity(T t);

	/**
	 * 普通删除
	 */
	void removeEntityById(Integer id);

	void saveEntity(T t);
	
	T getEntityById(Integer entityId);
	
	T getEntityByHql(String hql, Object... params);
}
