package com.example.papad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class RestoMenu extends Fragment {
	
	static ArrayList<String> menucatParsed = new ArrayList<String>();
	static ArrayList<String> menuinfoParsed = new ArrayList<String>();
	static ArrayList<String> menunameParsed = new ArrayList<String>();
	static ArrayList<String> menupriceParsed = new ArrayList<String>();
	
	Integer resto_id;
	String resto_name;
	String resto_locality;
	
	ListView list;
	MenuListViewAdapter adapter;
	EditText editsearch;
	ArrayList<MenuPopulation> arraylist = new ArrayList<MenuPopulation>();
	View v;

 
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.menu_frag,container,false);
        arraylist.clear();
        
        Intent gintent = getActivity().getIntent();
        //resto_id = i.getStringExtra("resto_id");
        resto_name = gintent.getStringExtra("resto_name");
        resto_locality = gintent.getStringExtra("resto_locality");
        
        getAllMenuInfo(resto_name,resto_locality);
        
        return v;
    }
   
    public void getAllMenuInfo(String resto_name, String resto_locality) {
    	System.out.println("Phase 1: resto_name : "+ resto_name);
		ParseQuery<ParseObject> query = ParseQuery.getQuery("FullMenu");
		
		final ArrayList<String> food_category_list = new ArrayList<String>();
		final ArrayList<String> food_info_list = new ArrayList<String>();
		final ArrayList<String> food_name_list = new ArrayList<String>();
		final ArrayList<String> food_price_list = new ArrayList<String>();
		
		
		
		query.whereStartsWith("resto_name", resto_name.substring(0, 5));
		//query.whereStartsWith("resto_locality", resto_locality.substring(0, 3));
		
		query.findInBackground(new FindCallback<ParseObject>() {
			
			@Override
			public void done(List<ParseObject> RestoMenuList, ParseException e) {
				if (e == null && RestoMenuList != null)
				{	
					
					if(!(RestoMenuList.isEmpty()))
					{
						
						int size = RestoMenuList.size();						
						int i=0;
						while (i < size) 
						{	        		
							
							food_category_list.add(RestoMenuList.get(i).getString("foodie_category"));
							food_info_list.add(RestoMenuList.get(i).getString("foodie_info"));
							food_name_list.add(RestoMenuList.get(i).getString("foodie_name"));
							food_price_list.add(RestoMenuList.get(i).getString("foodie_price"));
							
							i++;
						}
						
					}
					
				}
				
				saveParsedUserData(1,food_category_list);
				saveParsedUserData(2,food_info_list);
				saveParsedUserData(3,food_name_list);
				saveParsedUserData(4,food_price_list);
				
				
				for (int i = 0; i < menunameParsed.size(); i++) 
				{					
					MenuPopulation mp = new MenuPopulation(menucatParsed.get(i).toString(),
							menuinfoParsed.get(i).toString(),
							menunameParsed.get(i).toString(),
							menupriceParsed.get(i).toString());
					arraylist.add(mp);
					
				}
				
				
				// Locate the ListView in fragmenttab2.xml
				list = (ListView) v.findViewById(R.id.listview1);
		 
				// Pass results to ListViewAdapter Class
				adapter = new MenuListViewAdapter(getActivity(), arraylist);
				// Binds the Adapter to the ListView
				list.setAdapter(adapter);
			}	
			
		});
		
	}
    
    
public static void saveParsedUserData(int type,ArrayList<String> parsed_movers){

		switch (type) {
        case 1:  menucatParsed.clear();
			for(int i=0;i<parsed_movers.size();i++){
				if(parsed_movers.get(i) != null){
					menucatParsed.add(i,parsed_movers.get(i));
				} else {
					menucatParsed.add(i,"No Data");
				}
			} 	
			break;
                 
        case 2:  menuinfoParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
				 menuinfoParsed.add(i,parsed_movers.get(i));
			 } else {
				 menuinfoParsed.add(i,"No Data"); 
			 }
		 } 	
        break;
        
        case 3:  menunameParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
				 menunameParsed.add(i,parsed_movers.get(i));
			 } else {
				 menunameParsed.add(i,"No Data");
			 }
		 } 	
        break;
        
        case 4:  menupriceParsed.clear();
		 for(int i=0;i<parsed_movers.size();i++){
			 if(parsed_movers.get(i) != null){
				 menupriceParsed.add(i,parsed_movers.get(i));
			 } else {
				 menupriceParsed.add(i,"No Data");
			 }
		 } 	
        break;
        default: 
            break;
		}

}

@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);

    // Make sure that we are currently visible
    if (this.isVisible()) {
        // If we are becoming invisible, then...
        if (!isVisibleToUser) {
            Log.d("Menu", "Not visible anymore");
            
        } 
        
        	
        
    }
}
}
