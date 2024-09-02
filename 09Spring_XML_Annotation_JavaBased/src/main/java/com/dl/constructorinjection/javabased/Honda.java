package com.dl.constructorinjection.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Honda {
	
	private Models models;

	
	@Autowired
	public Honda(Models models) {
		this.models = models;
	}



	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
}
