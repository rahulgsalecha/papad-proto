package com.example.papad;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class RestoPopDish extends Fragment {
 
	// Declare Variables
		String resto_name;
		String resto_reco;
		
		TextView txtrestoname;	
		TextView txtrestonreco;	    
	    
	    ListView list;
		PopDishListViewAdapter adapter;
		ArrayList<String> PopList;
		
		ArrayList<DishPopulation> arraylist = new ArrayList<DishPopulation>();
		View v;

		
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    	v =inflater.inflate(R.layout.popdish_frag,container,false);
        return v;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        arraylist.clear();
        
        //getActivity().setContentView(R.layout.popdish_frag);
        // Retrieve data from FoodActivity on item click event

        Intent i = getActivity().getIntent();
        
        // Hummus,Fruit Punch,Mediterranean,Mousse Cake,Grilled Veggies,Mustard Fish,
     	
 		// Get the results
 		resto_name = i.getStringExtra("resto_name");	
 		resto_reco = i.getStringExtra("resto_reco");
 		
 		
 		PopList = new ArrayList(Arrays.asList(resto_reco.split(",")));
 		
 		for(int j=0; j < PopList.size(); j++ ) {
 			DishPopulation dp = new DishPopulation(PopList.get(j).toString());
 			arraylist.add(dp);
 		}
 		
 		// Locate the ListView in fragmenttab2.xml
		list = (ListView) v.findViewById(R.id.listView1);
 
		// Pass results to ListViewAdapter Class
		adapter = new PopDishListViewAdapter(getActivity(), arraylist);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
 		
 		// Locate the TextViews in singleitemview.xml
 		//txtrestoname = (TextView) getActivity().findViewById(R.id.resto_name);
 		//txtrestonreco = (TextView) getActivity().findViewById(R.id.resto_reco);
 		
 		// Load the results into the TextViews
 		//txtrestoname.setText(resto_name);
 		//txtrestonreco.setText(resto_reco);
       
        
        }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                Log.d("Pop Dish", "Not visible anymore");
                
            }
        }
    }
   
}