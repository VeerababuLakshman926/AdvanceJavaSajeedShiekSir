package com.dl.feildinjection.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Honda {
	
	@Autowired
	private Models models;

	public Models getModels() {
		return models;
	}

	
	public void setModels(Models models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
}
