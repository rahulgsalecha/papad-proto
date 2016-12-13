package com.example.papad;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

public class FoodActivity extends Activity {

	// Declare Variables
	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;
	
	/*
	 * Resto Name
	 * Resto Address
	 * Resto Category
	 * Resto Cuisines
	 * Resto Features
	 * Resto Locality
	 * Resto Phone
	 * Resto Rating
	 * Resto Reco
	 * Resto Services
	 * Resto Timings
	 * Resto id
	 * 
	 */
	
	ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();
	
	static ArrayList<String> namesParsed = new ArrayList<String>();
	static ArrayList<String> addressParsed = new ArrayList<String>();
	static ArrayList<String> categoryParsed = new ArrayList<String>();
	static ArrayList<String> cuisinesParsed = new ArrayList<String>();
	static ArrayList<String> featuresParsed = new ArrayList<String>();
	static ArrayList<String> localityParsed = new ArrayList<String>();
	static ArrayList<String> phoneParsed = new ArrayList<String>();
	static ArrayList<String> ratingParsed = new ArrayList<String>();
	static ArrayList<String> recoParsed = new ArrayList<String>();
	static ArrayList<String> servicesParsed = new ArrayList<String>();
	static ArrayList<Integer> idParsed = new ArrayList<Integer>();
	//static ArrayList<String> timingsParsed = new ArrayList<String>();
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);

		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listview);
		
		getAllRestoInfo();
		
		for (int i = 0; i < namesParsed.size(); i++) 
		{					
			//System.out.println(namesParsed.get(i).toString());
			
			WorldPopulation wp = new WorldPopulation(namesParsed.get(i).toString(),
					addressParsed.get(i).toString().replace("GET DIRECTIONS", ""),
					categoryParsed.get(i).toString(),
					cuisinesParsed.get(i).toString(),
					featuresParsed.get(i).toString(),
					localityParsed.get(i).toString(),
					phoneParsed.get(i).toString(),
					ratingParsed.get(i).toString(),
					recoParsed.get(i).toString(),
					servicesParsed.get(i).toString(),
					idParsed.get(i));
			arraylist.add(wp);
		}
		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter(this, arraylist);

		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
/*
		// Locate the EditText in listview_main.xml
		editsearch = (EditText) findViewById(R.id.search);

		// Capture Text in EditText
		editsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
				adapter.filter(text);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
			}
		});
		*/
	}

	// Not using options menu in this tutorial
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void getAllRestoInfo() {

		ParseQuery<ParseObject> query = ParseQuery.getQuery("ZootFinALL_1");
		
		final ArrayList<String> resto_name_list = new ArrayList<String>();
		final ArrayList<String> resto_address_list = new ArrayList<String>();
		final ArrayList<String> resto_category_list = new ArrayList<String>();
		final ArrayList<String> resto_cuisine_list = new ArrayList<String>();
		final ArrayList<String> resto_feature_list = new ArrayList<String>();
		final ArrayList<String> resto_local_list = new ArrayList<String>();
		final ArrayList<String> resto_phone_list = new ArrayList<String>();
		final ArrayList<String> resto_rating_list = new ArrayList<String>();
		final ArrayList<String> resto_reco_list = new ArrayList<String>();
		final ArrayList<String> resto_services_list = new ArrayList<String>();
		final ArrayList<Integer> resto_id_list = new ArrayList<Integer>();
		//final ArrayList<String> resto_timings_list = new ArrayList<String>();
		
		
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> RestoNameList, ParseException e) {
				if (e == null && RestoNameList != null)
				{	
					if(!(RestoNameList.isEmpty()))
					{
						int size = RestoNameList.size();						
						int i=0;
						while (i < size) 
						{	        		
							resto_name_list.add(RestoNameList.get(i).getString("resto_name"));
							resto_address_list.add(RestoNameList.get(i).getString("resto_address"));
							resto_category_list.add(RestoNameList.get(i).getString("resto_category"));
							resto_cuisine_list.add(RestoNameList.get(i).getString("resto_cuisines"));
							resto_feature_list.add(RestoNameList.get(i).getString("resto_features"));
							resto_local_list.add(RestoNameList.get(i).getString("resto_locality"));
							resto_phone_list.add(RestoNameList.get(i).getString("resto_phone"));
							resto_rating_list.add(RestoNameList.get(i).getString("resto_rating"));
							resto_reco_list.add(RestoNameList.get(i).getString("resto_reco"));
							resto_services_list.add(RestoNameList.get(i).getString("resto_services"));
							resto_id_list.add(RestoNameList.get(i).getInt("resto_id"));
							//resto_timings_list.add(RestoNameList.get(i).getString("resto_timings"));
							
							i++;
						}
					}
					
				}
				
				saveParsedUserData(1,resto_name_list);
				saveParsedUserData(2,resto_address_list);
				saveParsedUserData(3,resto_category_list);
				saveParsedUserData(4,resto_cuisine_list);
				saveParsedUserData(5,resto_feature_list);
				saveParsedUserData(6,resto_local_list);
				saveParsedUserData(7,resto_phone_list);
				saveParsedUserData(8,resto_rating_list);
				saveParsedUserData(9,resto_reco_list);
				saveParsedUserData(10,resto_services_list);
				saveParsedUserDataInt(11,resto_id_list);
				
				
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
                 
        case 2:  addressParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 addressParsed.add(i,parsed_movers.get(i));
			 } else {
				 addressParsed.add(i,"No Data"); 
			 }
		 } 	
        break;
        
        case 3:  categoryParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 categoryParsed.add(i,parsed_movers.get(i));
			 } else {
				 categoryParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 4:  cuisinesParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 cuisinesParsed.add(i,parsed_movers.get(i));
			 } else {
				 cuisinesParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 5:  featuresParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
				 featuresParsed.add(i,parsed_movers.get(i));
			 } else {
				 featuresParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 6:  localityParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 localityParsed.add(i,parsed_movers.get(i));
			 } else {
				 localityParsed.add(i,"No Data"); 
			 }
		 } 	
        break;
        
        case 7:  phoneParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 phoneParsed.add(i,parsed_movers.get(i));
			 } else {
				 phoneParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 8:  ratingParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 ratingParsed.add(i,parsed_movers.get(i));
		 } 	
        break;
        
        case 9:  recoParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 recoParsed.add(i,parsed_movers.get(i));
			 } else {
				 recoParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 10:  servicesParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 servicesParsed.add(i,parsed_movers.get(i));
			 } else {
				 servicesParsed.add(i,"No Data");
			 }
		 } 	
        break; 
    
       
        default: 
                 break;
    }
		
		
	}
	
	public static void saveParsedUserDataInt(int type,ArrayList<Integer> parsed_movers){
		
		switch (type) {
		 case 11:  idParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
			 idParsed.add(parsed_movers.get(i));
			 } else {
				 idParsed.add(i,0);
			 }
		 } 	
       break;
       
        default: 
                 break;
	}
	}

	
}
