package com.ezops.ezopsDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author mundlamuri
 *
 */
@SpringBootApplication
public class EzopsDemoApplication {
	private static Logger logger = LogManager.getLogger(EzopsDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting EZOPS Demo application..");
		 SpringApplication.run(EzopsDemoApplication.class, args);
	}

}
