package com.example.ec.exploreCali.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
public class TourPackage implements Serializable{
	@Id
	private String code;
	public TourPackage(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	protected TourPackage() {

	}

	private String name;
	
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCode() +" "+ this.getName();
	}

}
