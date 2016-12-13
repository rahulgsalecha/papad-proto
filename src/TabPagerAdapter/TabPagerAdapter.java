package TabPagerAdapter;

import com.example.papad.RestoDeals;
import com.example.papad.RestoInfo;
import com.example.papad.RestoMenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
 

public class TabPagerAdapter extends FragmentStatePagerAdapter {
 
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
 
 
    // Build a Constructor and assign the passed Values to appropriate values in the class
    public TabPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
 
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
 
    }
 
    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
 
        if(position == 0) 
        {
            RestoInfo resto_info = new RestoInfo();
            return resto_info;
        }
        else if (position == 1)          
        {
        	 RestoMenu resto_menu = new RestoMenu();
             return resto_menu;
        }
        else
        {
        	 RestoDeals resto_deals = new RestoDeals();
             return resto_deals;
        } 
 
 
    }
 
    // This method return the titles for the Tabs in the Tab Strip
 
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }
 
    // This method return the Number of tabs for the tabs Strip
 
    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}