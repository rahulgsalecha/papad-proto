package com.example.papad;


public class DeliveryPopulation {

	
	private String resto_name;
	private String resto_url;
	private String play_app;
	private String ios_app;
	
	
	
	public DeliveryPopulation(
			String resto_name,
			String resto_url,
			String play_app,
			String ios_app) 
	{
		this.resto_name = resto_name;
		this.resto_url = resto_url;
		this.play_app = play_app;
		this.ios_app = ios_app;
	}
	
	
	public String getResto_name() {
		return resto_name;
	}


	public String getResto_url() {
		return resto_url;
	}


	public String getPlay_app() {
		return play_app;
	}


	public String getIos_app() {
		return ios_app;
	}
	
	
}