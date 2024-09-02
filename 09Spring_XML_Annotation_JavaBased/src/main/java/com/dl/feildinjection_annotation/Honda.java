package com.dl.feildinjection_annotation;

import org.springframework.beans.factory.annotation.Autowired;

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
