package com.example.papad;


public class DealPopulation {

	
	private String coup_name;
	private String coup_url;
	private String coup_category;

	
	public DealPopulation(
			String coup_name,
			String coup_url,
			String coup_category) 
	{
		this.coup_name = coup_name;
		this.coup_url = coup_url;
		this.coup_category = coup_category;
		
	}
	
	
	public String getCoup_name() {
		return coup_name;
	}


	public String getCoup_url() {
		return coup_url;
	}


	public String getCoup_category() {
		return coup_category;
	}

	
	
}