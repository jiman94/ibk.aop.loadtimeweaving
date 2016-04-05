package com.ibk.ltw.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibk.ltw.repository.RyuRepository;

public class RyuService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
    public void showProducts() {
    	logger.debug(">>>>>>>>>>");
    	RyuRepository obj = new RyuRepository();
    	obj.showProducts();
    	
    }

}
