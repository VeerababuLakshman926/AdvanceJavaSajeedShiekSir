package com.dl.collection.list;

import java.util.List;

public class Honda {
	
	private String sname;
	private List<String> models;
	public Honda(String sname, List<String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}
	

}
