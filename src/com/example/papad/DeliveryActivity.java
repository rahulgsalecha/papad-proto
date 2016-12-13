package com.example.papad;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

public class DeliveryActivity extends Activity {

		// Declare Variables
		ListView list;
		Deliver_ListViewAdapter adapter;
		
		/*
		 * resto_name
		 * resto_url
		 * play_app
		 * ios_app
		 */
		ArrayList<DeliveryPopulation> arraylist = new ArrayList<DeliveryPopulation>();
		
		static ArrayList<String> namesParsed = new ArrayList<String>();
		static ArrayList<String> urlParsed = new ArrayList<String>();
		static ArrayList<String> playParsed = new ArrayList<String>();
		static ArrayList<String> iosParsed = new ArrayList<String>();
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.deliver_listview_main);

			// Locate the ListView in listview_main.xml
			list = (ListView) findViewById(R.id.listview);
			
			getAllDeliveryInfo();
			
			for (int i = 0; i < namesParsed.size(); i++) 
			{					
				
				//System.out.println(namesParsed.get(i).toString());
				
				DeliveryPopulation dp = new DeliveryPopulation(namesParsed.get(i).toString(),
						urlParsed.get(i).toString(),
						playParsed.get(i).toString(),
						iosParsed.get(i).toString());
				arraylist.add(dp);
			}
			// Pass results to ListViewAdapter Class
			adapter = new Deliver_ListViewAdapter(this, arraylist);

			// Binds the Adapter to the ListView
			list.setAdapter(adapter);
		}
		
		// Not using options menu in this tutorial
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.activity_main, menu);
			return true;
		}
		
		public void getAllDeliveryInfo() {

			ParseQuery<ParseObject> query = ParseQuery.getQuery("FoodDelivery");
			
			final ArrayList<String> resto_name_list = new ArrayList<String>();
			final ArrayList<String> resto_url_list = new ArrayList<String>();
			final ArrayList<String> play_app_list = new ArrayList<String>();
			final ArrayList<String> ios_app_list = new ArrayList<String>();

			
			query.findInBackground(new FindCallback<ParseObject>() {
				@Override
				public void done(List<ParseObject> RestoDeliverList, ParseException e) {
					if (e == null && RestoDeliverList != null)
					{	
						if(!(RestoDeliverList.isEmpty()))
						{
							int size = RestoDeliverList.size();						
							int i=0;
							while (i < size) 
							{	        		
								resto_name_list.add(RestoDeliverList.get(i).getString("resto_name"));
								resto_url_list.add(RestoDeliverList.get(i).getString("resto_url"));
								play_app_list.add(RestoDeliverList.get(i).getString("play_app"));
								ios_app_list.add(RestoDeliverList.get(i).getString("ios_app"));
								
								
								i++;
							}
						}
						
					}
					
					saveParsedUserData(1,resto_name_list);
					saveParsedUserData(2,resto_url_list);
					saveParsedUserData(3,play_app_list);
					saveParsedUserData(4,ios_app_list);

				}	
			});
		}
		
		public static void saveParsedUserData(int type,ArrayList<String> parsed_movers){
			
			
			
			switch (type) {
	        case 1:  namesParsed.clear();
				for(int i=0;i<parsed_movers.size();i++){
					if(parsed_movers.get(i) != null){
					namesParsed.add(i,parsed_movers.get(i));
					} else {
					namesParsed.add(i,"No Data");
					}
				} 	
				break;
	                 
	        case 2:  urlParsed.clear();
			 for(int i=0;i<parsed_movers.size();i++){
				 if(parsed_movers.get(i) != null){
				 urlParsed.add(i,parsed_movers.get(i));
				 } else {
					 urlParsed.add(i,"No Data"); 
				 }
			 } 	
	        break;
	        
	        case 3:  playParsed.clear();
			 for(int i=0;i<parsed_movers.size();i++){
				 if(parsed_movers.get(i) != null){
				 playParsed.add(i,parsed_movers.get(i));
				 } else {
					 playParsed.add(i,"No Data");
				 }
			 } 	
	        break;
	        
	        case 4:  iosParsed.clear();
			 for(int i=0;i<parsed_movers.size();i++){
				 if(parsed_movers.get(i) != null){
				 iosParsed.add(i,parsed_movers.get(i));
				 } else {
					 iosParsed.add(i,"No Data");
				 }
			 } 	
	        break;
	        
	      
	        default: 
	                 break;
	    }
			
			
		}

}
