package com.example.papad;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class DealActivity extends Activity {

	// Declare Variables
	ListView list;
	Deal_ListViewAdapter adapter;
	
	/*
	 * coup_name
	 * coup_url
	 * coup_category
	 */
	ArrayList<DealPopulation> arraylist = new ArrayList<DealPopulation>();
	
	static ArrayList<String> namesParsed = new ArrayList<String>();
	static ArrayList<String> urlParsed = new ArrayList<String>();
	static ArrayList<String> catParsed = new ArrayList<String>();
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deal_listview_main);

		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listview);
		
		getAllDealInfo();
		
		for (int i = 0; i < namesParsed.size(); i++) 
		{					
			
			//System.out.println(namesParsed.get(i).toString());
			
			DealPopulation dp = new DealPopulation(namesParsed.get(i).toString(),
					urlParsed.get(i).toString(),
					catParsed.get(i).toString());
			arraylist.add(dp);
		}
		// Pass results to ListViewAdapter Class
		adapter = new Deal_ListViewAdapter(this, arraylist);

		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
	}
	
	// Not using options menu in this tutorial
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void getAllDealInfo() {

		ParseQuery<ParseObject> query = ParseQuery.getQuery("CouponDeals");
		
		final ArrayList<String> coup_name_list = new ArrayList<String>();
		final ArrayList<String> coup_url_list = new ArrayList<String>();
		final ArrayList<String> coup_cat_list = new ArrayList<String>();
		

		
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
							coup_name_list.add(RestoDeliverList.get(i).getString("coup_name"));
							coup_url_list.add(RestoDeliverList.get(i).getString("coup_url"));
							coup_cat_list.add(RestoDeliverList.get(i).getString("coup_category"));	
							i++;
						}
					}
					
				}
				
				saveParsedUserData(1,coup_name_list);
				saveParsedUserData(2,coup_url_list);
				saveParsedUserData(3,coup_cat_list);

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
        
        case 3:  catParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
				 catParsed.add(i,parsed_movers.get(i));
			 } else {
				 catParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
      
        default: 
                 break;
    }
		
		
	}

}
