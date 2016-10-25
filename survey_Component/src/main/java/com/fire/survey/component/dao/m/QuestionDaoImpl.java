package com.fire.survey.component.dao.m;

import org.springframework.stereotype.Repository;

import com.fire.survey.base.m.BaseDaoImpl;
import com.fire.survey.component.dao.i.QuestionDao;
import com.fire.survey.entities.guest.Question;

@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao {

}
