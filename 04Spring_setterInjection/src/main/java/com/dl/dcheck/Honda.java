package com.dl.dcheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Honda {
	
	private int vno;
	private List<String> models;
	public int getVno() {
		return vno;
	}
	
	@Required
	public void setVno(int vno) {
		this.vno = vno;
	}
	public List<String> getModels() {
		return models;
	}
	
	@Required
	public void setModels(List<String> models) {
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", models=" + models + "]";
	}
	
	
}
