package com.ibk.ltw.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RyuRepository {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
    public void showProducts() {
    	logger.debug(">>>>>>>>>>");
    	RyuRepository2 obj = new RyuRepository2();
    	obj.showProducts();
    	
    	
    }
    
}
