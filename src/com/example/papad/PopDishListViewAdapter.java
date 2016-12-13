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

public class PopDishListViewAdapter extends BaseAdapter {


	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<DishPopulation> DishPopulationlist = null;
	private ArrayList<DishPopulation> arraylist;

	public PopDishListViewAdapter(Context context, List<DishPopulation> DishPopulationlist) {
		mContext = context;
		this.DishPopulationlist = DishPopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<DishPopulation>();
		this.arraylist.addAll(DishPopulationlist);
	}

	public class ViewHolder {
		TextView pop_dish;
	}

	@Override
	public int getCount() {
		return DishPopulationlist.size();
	}

	@Override
	public DishPopulation getItem(int position) {
		return DishPopulationlist.get(position);
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
			view = inflater.inflate(R.layout.popdish_listview_item, parent, false);
			// Locate the TextViews in menu_listview_item.xml
			
			holder.pop_dish = (TextView) view.findViewById(R.id.pop_dish);
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		
		if(DishPopulationlist.get(position).getPopDish() != null){
		
		holder.pop_dish.setText(DishPopulationlist.get(position).getPopDish());
		
		} else {
			holder.pop_dish.setText("No popular dish available at this time !!");
		}
		
		/*
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);
				
				// Pass all resto names
				intent.putExtra("foodie_category",(DishPopulationlist.get(position).getFoodCat()));
				intent.putExtra("foodie_info",(DishPopulationlist.get(position).getFoodInfo()));
				intent.putExtra("foodie_name",(DishPopulationlist.get(position).getFoodName()));
				intent.putExtra("foodie_price",(DishPopulationlist.get(position).getFoodPrice()));
				
				
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
		DishPopulationlist.clear();
		if (charText.length() == 0) {
			DishPopulationlist.addAll(arraylist);
		} 
		else 
		{
			for (DishPopulation wp : arraylist) 
			{
				if (wp.getPopDish().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					DishPopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
