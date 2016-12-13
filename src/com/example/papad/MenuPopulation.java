package com.example.papad;

public class MenuPopulation {

	
	private String foodie_category;
	private String foodie_info;
	private String foodie_name;
	private String foodie_price;
	
	
	public MenuPopulation(
			String foodie_category,
			String foodie_info,
			String foodie_name,
			String foodie_price) 
	{
		this.foodie_category = foodie_category;
		this.foodie_info = foodie_info;
		this.foodie_name = foodie_name;
		this.foodie_price = foodie_price;
	}
	
	
	public String getFoodCat() {
		return this.foodie_category;
	}
	
	public String getFoodInfo() {
		return this.foodie_info;
	}
	
	public String getFoodName() {
		return this.foodie_name;
	}
	
	public String getFoodPrice() {
		return this.foodie_price;
	}
	
	
}