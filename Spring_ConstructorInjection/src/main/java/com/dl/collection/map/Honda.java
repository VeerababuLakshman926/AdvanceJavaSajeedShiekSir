package com.dl.collection.map;

import java.util.Map;

public class Honda {
	private Map<Integer, String> models;
	private String sname;
	
	public Honda(String sname, Map<Integer, String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}

}
