package com.fire.survey.model.quarz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.fire.survey.component.service.i.SLogService;
import com.fire.survey.router.MyRoutingDataSource;
import com.fire.survey.router.RouterKeyBinder;
import com.fire.survey.utils.DataProcess;

public class LogListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private SLogService sLogService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext ioc = event.getApplicationContext();
		if(ioc.getParent()==null){
			for (int i = 0; i < 3; i++) {
				String tableName = DataProcess.generateTableName(i);
				RouterKeyBinder.bindKey(MyRoutingDataSource.LOG);
				sLogService.createTable(tableName);
			}
		}
	}

}
