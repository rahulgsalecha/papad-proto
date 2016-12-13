package com.example.papad;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	

	private static String logtag = "Papad Main Activity";

public void addListenerOnButton() {
		
		ImageButton button_food = (ImageButton)findViewById(R.id.Button02);       
		ImageButton button_deal = (ImageButton)findViewById(R.id.Button01);       
		ImageButton button_delivery = (ImageButton)findViewById(R.id.button2);       
		ImageButton button_hot = (ImageButton)findViewById(R.id.button1);       
	  	
	
		button_food.setOnClickListener(new OnClickListener() {
	      	public void onClick(View v){
	      		Intent intent = new Intent(getBaseContext(), FoodActivity.class);
	              startActivity(intent);
	              //startActivityForResult(intent, 0);
	      	}
	      });
	    
		button_deal.setOnClickListener(new OnClickListener() {
	      	public void onClick(View v){
	      		Intent intent = new Intent(getBaseContext(), DealActivity.class);
	              //startActivity(intent);   
	              startActivityForResult(intent, 0);
	      	}
	      });
		
		button_delivery.setOnClickListener(new OnClickListener() {
	      	public void onClick(View v){
	      		Intent intent = new Intent(getBaseContext(), DeliveryActivity.class);
	              //startActivity(intent);   
	              startActivityForResult(intent, 0);
	      	}
	      });
		/*
		button_hot.setOnClickListener(new OnClickListener() {
	      	public void onClick(View v){
	      		Intent intent = new Intent(getBaseContext(), HotActivity.class);
	              //startActivity(intent);   
	              startActivityForResult(intent, 0);
	      	}
	      });
	      */
	  }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
}
