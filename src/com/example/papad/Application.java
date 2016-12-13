package com.example.papad;

import com.parse.Parse;

public class Application extends android.app.Application
{
	public void onCreate()
	{
		Parse.enableLocalDatastore(this);
		Parse.initialize(this, "l8c3iZRen3hZZCld2J5Bf3HOfKIbEAlSOprEHOax", "paOnEeIplPgmFB3GJVFzI9hUorittLwuiql63GBk");	
		
	}
}