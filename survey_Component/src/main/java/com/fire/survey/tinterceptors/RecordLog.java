package com.fire.survey.tinterceptors;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

import com.fire.survey.component.service.i.SLogService;
import com.fire.survey.entities.guest.SLog;
import com.fire.survey.entities.guest.User;
import com.fire.survey.entities.manager.Admin;
import com.fire.survey.utils.RequestBinder;

public class RecordLog {

	@Autowired
	private SLogService sLogService;

	public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		String operator = null;
		String operateTime = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss").format(new Date());
		String methodName = null;
		String typeName = null;
		String paramList = null;
		String returnValue = null;
		String exceptionType = null;
		String exceptionMessage = null;
		try {
			Signature signature = joinPoint.getSignature();
			methodName = signature.getName();
			typeName = signature.getDeclaringTypeName();
			Object[] args = joinPoint.getArgs();
			paramList = Arrays.asList(args).toString();
			result = joinPoint.proceed(args);
			returnValue = result== null ?"":result.toString();
		} catch (Throwable e) {
			e.printStackTrace();
			Throwable cause = e.getCause();
			if (cause != null) {
				exceptionType = cause.getClass().getName();
				exceptionMessage = cause.getMessage();
				cause = cause.getCause();
			}
			throw e;
		} finally {
			HttpSession session = RequestBinder.getRequest().getSession();
			User user = (User) session.getAttribute("loginUser");
			String username = user == null ? "" : user.getName();
			Admin admin = (Admin) session.getAttribute("loginAdmin");
			String adminname = admin == null ? "" : admin.getAdminName();
			operator = username + "/" + adminname;
			SLog sLog = new SLog(null, operator, operateTime, methodName, typeName, paramList, returnValue,
					exceptionType, exceptionMessage);
			sLogService.save(sLog);
		}
		return result;
	}
}
