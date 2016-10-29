package com.fire.survey.model.quarz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.fire.survey.component.service.i.SLogService;

public class LogQuartzJobBean extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("***********");
		System.out.println(sLogService);
	}

	private SLogService sLogService;

	public void setsLogService(SLogService sLogService) {
		this.sLogService = sLogService;
	}

}
