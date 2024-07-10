package com.dl.withByName;

public class Honda {
	
	private Models models_byName;

	public Models getModels_byName() {
		return models_byName;
	}

	public void setModels_byName(Models models_byName) {
		this.models_byName = models_byName;
	}

	@Override
	public String toString() {
		return "Honda [models_byName=" + models_byName + "]";
	}

	
	
}
