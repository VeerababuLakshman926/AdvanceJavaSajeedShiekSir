package com.dl.setterinjection.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Honda {
	
	private Models models;

	public Models getModels() {
		return models;
	}

	@Autowired
	public void setModels(Models models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
}
