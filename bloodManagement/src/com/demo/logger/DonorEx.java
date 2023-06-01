package com.demo.logger;

import org.apache.log4j.Logger;

//import java.util.logging.Logger;

public class DonorEx {

	 static Logger log = Logger.getLogger(DonorEx.class.getName());  
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.debug("Hello this is a debug message");  
	      log.info("Hello this is an info message");  
	}

}
