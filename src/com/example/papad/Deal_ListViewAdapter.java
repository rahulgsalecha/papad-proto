package com.example.papad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Deal_ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<DealPopulation> DealPopulationlist = null;
	private ArrayList<DealPopulation> arraylist;

	public Deal_ListViewAdapter(Context context, List<DealPopulation> DealPopulationlist) {
		mContext = context;
		this.DealPopulationlist = DealPopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<DealPopulation>();
		this.arraylist.addAll(DealPopulationlist);
	}

	public class ViewHolder {
		TextView coup_name;
		ImageView coup_url;
	}

	@Override
	public int getCount() {
		return DealPopulationlist.size();
	}

	@Override
	public DealPopulation getItem(int position) {
		return DealPopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.deal_listview_item, null);
			// Locate the TextViews in listview_item.xml
			
			holder.coup_name = (TextView) view.findViewById(R.id.coup_name);
			holder.coup_url = (ImageView) view.findViewById(R.id.coup_url);
			
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews

		
		
		holder.coup_name.setText(DealPopulationlist.get(position).getCoup_name());
		
		holder.coup_url.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse(DealPopulationlist.get(position).getCoup_url().toString().trim()));   
		        mContext.startActivity(intent);
		    }
		});
	

		return view;
	}



	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		DealPopulationlist.clear();
		if (charText.length() == 0) {
			DealPopulationlist.addAll(arraylist);
		} 
		else 
		{
			for (DealPopulation wp : arraylist) 
			{
				if (wp.getCoup_name().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					DealPopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
