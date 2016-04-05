package com.ibk.ltw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibk.ltw.service.RyuService;

public class RyuController {

	
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    public void showProducts() {
    	logger.debug(">>>>>>>>>>");
    	RyuService obj = new RyuService();
    	obj.showProducts();
    	
    	
    }
}
