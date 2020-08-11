package com.example.ec.exploreCali.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Tour implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private String blurb;
	private double price;
	private String duration;
	private String bullets;
	private String keywords;
	private Region region;
	private Difficulty difficulty;
	@ManyToOne
	private TourPackage tourPackage;
	
	//protected => consumers of this class are only able to use fully initialized java obj
	protected Tour() {

	}
	public Tour(String title, String description, String blurb, double price, String duration, String bullets,
			String keywords, Region region, Difficulty difficulty, TourPackage tourPackage) {
		super();
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
		this.region = region;
		this.difficulty = difficulty;
		this.tourPackage = tourPackage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getBullets() {
		return bullets;
	}
	public void setBullets(String bullets) {
		this.bullets = bullets;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	

}
