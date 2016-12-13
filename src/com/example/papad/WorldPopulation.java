package com.example.papad;

public class WorldPopulation {

	
	private String resto_name;
	private String resto_address;
	private String resto_category;
	private String resto_cuisines;
	private String resto_features;
	private String resto_locality;
	private String resto_phone;
	private String resto_rating;
	private String resto_reco;
	private String resto_services;
	private Integer resto_id;
	
	public WorldPopulation(String resto_name,
			String resto_address,
			String resto_category,
			String resto_cuisines,
			String resto_features,
			String resto_locality,
			String resto_phone,
			String resto_rating,
			String resto_reco,
			String resto_services,
			Integer resto_id) 
	{
		this.resto_name = resto_name;
		this.resto_address = resto_address;
		this.resto_category = resto_category;
		this.resto_cuisines = resto_cuisines;
		this.resto_features = resto_features;
		this.resto_locality = resto_locality;
		this.resto_phone = resto_phone;
		this.resto_rating = resto_rating;
		this.resto_reco = resto_reco;
		this.resto_services = resto_services;
		this.resto_id = resto_id;
	}
	
	
	public String getRestoName() {
		return this.resto_name;
	}
	
	public String getRestoAddress() {
		return this.resto_address;
	}
	
	public String getRestoCategory() {
		return this.resto_category;
	}
	
	public String getRestoCuisines() {
		return this.resto_cuisines;
	}
	
	public String getRestoFeatures() {
		return this.resto_features;
	}
	
	public String getRestoLocality() {
		return this.resto_locality;
	}
	
	public String getRestoPhone() {
		return this.resto_phone;
	}
	
	public String getRestoRating() {
		return this.resto_rating;
	}
	
	public String getRestoReco() {
		return this.resto_reco;
	}
	
	public String getRestoServices() {
		return this.resto_services;
	}
	
	public Integer getRestoId() {
		return this.resto_id;
	}
}