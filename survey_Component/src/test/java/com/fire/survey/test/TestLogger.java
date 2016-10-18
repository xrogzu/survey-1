package com.fire.survey.test;

import org.jboss.logging.Logger;

public class TestLogger {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestLogger.class);
		logger.debug("aaaaaa");
		logger.warn("bbbbbb");
		logger.info("ccccccc");
		logger.error("dddddd");
		logger.fatal("eeeeeee");
	}
}
