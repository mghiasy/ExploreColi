package com.example.ec.exploreCali.domain;

import java.util.List;

public class TourPackage {
	private String code;
	private String name;
	private List<Tour> tours;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Tour> getTours() {
		return tours;
	}
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
	
	

}
