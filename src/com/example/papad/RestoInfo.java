package com.example.papad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RestoInfo extends Fragment {
 
	// Declare Variables
		String resto_name;
		String resto_address;
		String resto_category;
		String resto_cuisines;
		String resto_features;
		String resto_locality;
		String resto_phone;
		String resto_rating;
		String resto_reco;
		String resto_services;
		Integer resto_id;

		
		TextView txtrestoname;
		TextView txtrestoaddr;
		TextView txtrestocat;
		TextView txtrestoncuis;
		TextView txtrestofeat;
		TextView txtrestolocal;
		TextView txtrestophone;
		TextView txtrestoeating;
		TextView txtrestonreco;
		TextView txtrestoserv;
		
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.info_frag,container,false);
        setRetainInstance(false);
   	
        return v;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Retrieve data from FoodActivity on item click event
        
        Intent i = getActivity().getIntent();
     	
 		// Get the results
 		resto_name = i.getStringExtra("resto_name");
 		resto_address = i.getStringExtra("resto_address");
 		resto_category = i.getStringExtra("resto_category");
 		resto_cuisines = i.getStringExtra("resto_cuisines");
 		resto_features = i.getStringExtra("resto_features");
 		resto_locality = i.getStringExtra("resto_locality");
 		resto_phone = i.getStringExtra("resto_phone");
 		resto_rating = i.getStringExtra("resto_rating");
 		resto_reco = i.getStringExtra("resto_reco");
 		resto_services = i.getStringExtra("resto_services");
 		resto_id = i.getIntExtra("resto_id", 0);
 		
 		// Locate the TextViews in singleitemview.xml
 		txtrestoname = (TextView) getActivity().findViewById(R.id.resto_name);
 		txtrestoaddr = (TextView) getActivity().findViewById(R.id.resto_address);
 		txtrestocat = (TextView) getActivity().findViewById(R.id.resto_category);
 		txtrestoncuis = (TextView) getActivity().findViewById(R.id.resto_cuisines);
 		txtrestofeat = (TextView) getActivity().findViewById(R.id.resto_features);
 		txtrestolocal = (TextView) getActivity().findViewById(R.id.resto_locality);
 		txtrestophone = (TextView) getActivity().findViewById(R.id.resto_phone);
 		txtrestoeating = (TextView) getActivity().findViewById(R.id.resto_rating);
 		txtrestonreco = (TextView) getActivity().findViewById(R.id.resto_reco);
 		txtrestoserv = (TextView) getActivity().findViewById(R.id.resto_services);
 		
 		// Load the results into the TextViews
 		txtrestoname.setText(resto_name);
 		txtrestoaddr.setText(resto_address);
 		txtrestocat.setText(resto_category);
 		txtrestoncuis.setText(resto_cuisines);
 		txtrestofeat.setText(resto_features);
 		txtrestolocal.setText(resto_locality);
 		txtrestophone.setText(resto_phone);
 		txtrestoeating.setText(resto_rating);
 		txtrestonreco.setText(resto_reco);
 		txtrestoserv.setText(resto_services);
 		
        
        }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                Log.d("Info", "Not visible anymore");
                
            }
        }
    }
   
}