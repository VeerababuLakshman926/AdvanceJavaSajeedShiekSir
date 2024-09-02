package com.dl.setterinjection.ml;

public class Models {
	
	private String models;
	private String type;
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Models [models=" + models + ", type=" + type + "]";
	}
	
}
