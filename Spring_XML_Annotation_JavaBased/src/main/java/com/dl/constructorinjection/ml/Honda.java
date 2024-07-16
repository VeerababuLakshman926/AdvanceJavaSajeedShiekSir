package com.dl.constructorinjection.ml;

import org.springframework.beans.factory.annotation.Autowired;


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
