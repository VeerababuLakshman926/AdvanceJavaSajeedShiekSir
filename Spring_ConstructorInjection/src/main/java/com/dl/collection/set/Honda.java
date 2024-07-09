package com.dl.collection.set;


import java.util.Set;

public class Honda {
	
	private String sname;
	private Set<String> models;
	public Honda(String sname, Set<String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}
	
	
	

}
