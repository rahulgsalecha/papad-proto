package com.example.papad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<WorldPopulation> worldpopulationlist = null;
	private ArrayList<WorldPopulation> arraylist;

	public ListViewAdapter(Context context, List<WorldPopulation> worldpopulationlist) {
		mContext = context;
		this.worldpopulationlist = worldpopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<WorldPopulation>();
		this.arraylist.addAll(worldpopulationlist);
	}

	public class ViewHolder {
		TextView resto_name;
		TextView resto_address;
		TextView resto_category;
		TextView resto_cuisines;
		TextView resto_features;
		TextView resto_locality;
		TextView resto_phone;
		TextView resto_rating;
		TextView resto_reco;
		TextView resto_services;
	}

	@Override
	public int getCount() {
		return worldpopulationlist.size();
	}

	@Override
	public WorldPopulation getItem(int position) {
		return worldpopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml
			
			holder.resto_name = (TextView) view.findViewById(R.id.resto_name);
			holder.resto_address = (TextView) view.findViewById(R.id.resto_address);
			holder.resto_category = (TextView) view.findViewById(R.id.resto_category);
			holder.resto_cuisines = (TextView) view.findViewById(R.id.resto_cuisines);
			holder.resto_features = (TextView) view.findViewById(R.id.resto_features);
			holder.resto_locality = (TextView) view.findViewById(R.id.resto_locality);
			holder.resto_phone = (TextView) view.findViewById(R.id.resto_phone);
			holder.resto_rating = (TextView) view.findViewById(R.id.resto_rating);
			holder.resto_reco = (TextView) view.findViewById(R.id.resto_reco);
			holder.resto_services = (TextView) view.findViewById(R.id.resto_services);
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		
		holder.resto_name.setText(worldpopulationlist.get(position).getRestoName());
		/*
		holder.resto_address.setText(worldpopulationlist.get(position).getRestoAddress());;
		holder.resto_category.setText(worldpopulationlist.get(position).getRestoCategory());;
		holder.resto_cuisines.setText(worldpopulationlist.get(position).getRestoCuisines());;
		holder.resto_features.setText(worldpopulationlist.get(position).getRestoFeatures());;
		*/
		holder.resto_locality.setText(worldpopulationlist.get(position).getRestoLocality());
		/*
		holder.resto_phone.setText(worldpopulationlist.get(position).getRestoPhone());;
		holder.resto_rating.setText(worldpopulationlist.get(position).getRestoRating());;
		holder.resto_reco.setText(worldpopulationlist.get(position).getRestoReco());;
		holder.resto_services.setText(worldpopulationlist.get(position).getRestoServices());;
		*/
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);
				
				// Pass all resto names
				intent.putExtra("resto_name",(worldpopulationlist.get(position).getRestoName()));
				intent.putExtra("resto_address",(worldpopulationlist.get(position).getRestoAddress()));
				intent.putExtra("resto_category",(worldpopulationlist.get(position).getRestoCategory()));
				intent.putExtra("resto_cuisines",(worldpopulationlist.get(position).getRestoCuisines()));
				intent.putExtra("resto_features",(worldpopulationlist.get(position).getRestoFeatures()));
				intent.putExtra("resto_locality",(worldpopulationlist.get(position).getRestoLocality()));
				intent.putExtra("resto_phone",(worldpopulationlist.get(position).getRestoPhone()));
				intent.putExtra("resto_rating",(worldpopulationlist.get(position).getRestoRating()));
				intent.putExtra("resto_reco",(worldpopulationlist.get(position).getRestoReco()));
				intent.putExtra("resto_services",(worldpopulationlist.get(position).getRestoServices()));
				intent.putExtra("resto_id",(worldpopulationlist.get(position).getRestoId()));
				
				// Pass all data flag
				// Start SingleItemView Class
				mContext.startActivity(intent);
			}
		});

		return view;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		worldpopulationlist.clear();
		if (charText.length() == 0) {
			worldpopulationlist.addAll(arraylist);
		} 
		else 
		{
			for (WorldPopulation wp : arraylist) 
			{
				if (wp.getRestoName().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					worldpopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
