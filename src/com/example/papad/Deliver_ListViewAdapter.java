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

public class Deliver_ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<DeliveryPopulation> DeliveryPopulationlist = null;
	private ArrayList<DeliveryPopulation> arraylist;

	public Deliver_ListViewAdapter(Context context, List<DeliveryPopulation> DeliveryPopulationlist) {
		mContext = context;
		this.DeliveryPopulationlist = DeliveryPopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<DeliveryPopulation>();
		this.arraylist.addAll(DeliveryPopulationlist);
	}

	public class ViewHolder {
		TextView resto_name;
		ImageView resto_url;
		ImageView play_app;
		ImageView ios_app;
	}

	@Override
	public int getCount() {
		return DeliveryPopulationlist.size();
	}

	@Override
	public DeliveryPopulation getItem(int position) {
		return DeliveryPopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.deliver_listview_item, null);
			// Locate the TextViews in listview_item.xml
			
			holder.resto_name = (TextView) view.findViewById(R.id.resto_name);
			holder.resto_url = (ImageView) view.findViewById(R.id.resto_url);
			holder.play_app = (ImageView) view.findViewById(R.id.play_app);
			holder.ios_app = (ImageView) view.findViewById(R.id.ios_app);
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		
		holder.resto_name.setText(DeliveryPopulationlist.get(position).getResto_name());
		//holder.resto_url.setText(DeliveryPopulationlist.get(position).getResto_url());
		//holder.play_app.setText(DeliveryPopulationlist.get(position).getPlay_app());
		//holder.ios_app.setText(DeliveryPopulationlist.get(position).getIos_app());	
		
		holder.resto_url.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse(DeliveryPopulationlist.get(position).getResto_url()));
		        mContext.startActivity(intent);
		    }
		});
		
		holder.play_app.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse(DeliveryPopulationlist.get(position).getPlay_app()));
		        mContext.startActivity(intent);
		    }
		});
		
		holder.ios_app.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse(DeliveryPopulationlist.get(position).getIos_app()));
		        mContext.startActivity(intent);
		    }
		});
		
		/*
		// Listen for ListView Item Click
		holder.resto_url.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View arg0) {

						          
						Intent intent = new Intent(mContext);
						intent.setAction(Intent.ACTION_VIEW);
				        intent.addCategory(Intent.CATEGORY_BROWSABLE);
				        intent.setData(Uri.parse(DeliveryPopulationlist.get(position).getResto_url()));	
						mContext.startActivity(intent);
					}
		});
*/
		
																											

		return view;
	}



	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		DeliveryPopulationlist.clear();
		if (charText.length() == 0) {
			DeliveryPopulationlist.addAll(arraylist);
		} 
		else 
		{
			for (DeliveryPopulation wp : arraylist) 
			{
				if (wp.getResto_name().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					DeliveryPopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
