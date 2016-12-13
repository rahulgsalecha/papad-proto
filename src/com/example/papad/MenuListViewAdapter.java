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

public class MenuListViewAdapter extends BaseAdapter {
	boolean menu_available = false;

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<MenuPopulation> MenuPopulationlist = null;
	private ArrayList<MenuPopulation> arraylist;

	public MenuListViewAdapter(Context context, List<MenuPopulation> MenuPopulationlist) {
		mContext = context;
		this.MenuPopulationlist = MenuPopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<MenuPopulation>();
		this.arraylist.addAll(MenuPopulationlist);
	}

	public class ViewHolder {
		TextView foodie_category;
		TextView foodie_info;
		TextView foodie_name;
		TextView foodie_price;	
	}

	@Override
	public int getCount() {
		return MenuPopulationlist.size();
	}

	@Override
	public MenuPopulation getItem(int position) {
		return MenuPopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.menu_listview_item, parent, false);
			// Locate the TextViews in menu_listview_item.xml
			
			holder.foodie_category = (TextView) view.findViewById(R.id.foodie_category);
			holder.foodie_info = (TextView) view.findViewById(R.id.foodie_info);
			holder.foodie_name = (TextView) view.findViewById(R.id.foodie_name);
			holder.foodie_price = (TextView) view.findViewById(R.id.foodie_price);
			
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		
		if(MenuPopulationlist.get(position).getFoodCat() != null){
			menu_available = true;
		
		holder.foodie_category.setText(MenuPopulationlist.get(position).getFoodCat());
		holder.foodie_info.setText(MenuPopulationlist.get(position).getFoodInfo());
		holder.foodie_name.setText(MenuPopulationlist.get(position).getFoodName());
		holder.foodie_price.setText(MenuPopulationlist.get(position).getFoodPrice());
		} else {
			menu_available = false;
			holder.foodie_category.setText("No MENU Available at this time !!");
		}
		
		/*
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);
				
				// Pass all resto names
				intent.putExtra("foodie_category",(MenuPopulationlist.get(position).getFoodCat()));
				intent.putExtra("foodie_info",(MenuPopulationlist.get(position).getFoodInfo()));
				intent.putExtra("foodie_name",(MenuPopulationlist.get(position).getFoodName()));
				intent.putExtra("foodie_price",(MenuPopulationlist.get(position).getFoodPrice()));
				
				
				// Pass all data flag
				// Start SingleItemView Class
				mContext.startActivity(intent);
			}
			
		});*/

		return view;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		MenuPopulationlist.clear();
		if (charText.length() == 0) {
			MenuPopulationlist.addAll(arraylist);
		} 
		else 
		{
			for (MenuPopulation wp : arraylist) 
			{
				if (wp.getFoodName().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					MenuPopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
