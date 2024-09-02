package com.dl.map;

import java.util.Map;


//Pojo class
public class Honda {

	private int vno;
	private Map<Integer, String> models;
	
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public Map<Integer, String> getModels() {
		return models;
	}

	public void setModels(Map<Integer, String> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", models=" + models + "]";
	}

	

	

	
	
}
