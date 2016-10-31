package com.fire.survey.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
	public static final String LOG = "log";
	public static final String COMMON = "common";

	@Override
	protected Object determineCurrentLookupKey() {
		String key = RouterKeyBinder.getKey();
		RouterKeyBinder.removeKey();
		return key;
	}

}
