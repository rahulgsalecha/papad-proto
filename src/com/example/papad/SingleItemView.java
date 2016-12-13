package com.example.papad;




import com.actionbarsherlock.app.SherlockFragmentActivity;

import TabPagerAdapter.TabPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



public class SingleItemView extends SherlockFragmentActivity{
	
	private FragmentTabHost mTabHost;
    Toolbar toolbar;
    ViewPager pager;
    TabPagerAdapter adapter;
    SlidingTabLayout tabs;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		Intent i = getIntent();
		
		
		// Locate android.R.id.tabhost in main_fragment.xml
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
				
		// Create the tabs in main_fragment.xml
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		
		
		mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Info", null),
                RestoInfo.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Menu", null),
                RestoMenu.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("PopDish", null),
                RestoPopDish.class, null);
			}

 
 /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
 
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
 
        return super.onOptionsItemSelected(item);
    }
    */
}