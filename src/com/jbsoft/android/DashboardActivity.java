package com.jbsoft.android;

import android.app.TabActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.jbsoft.library.UserFunctions;
import com.jbsoft.android.GlobalVariable;

public class DashboardActivity extends TabActivity {
    UserFunctions userFunctions;
    Button btnsubmissions;
    Button btnrateengine;
    String startString = null;
    String endString = null;
    String logged_in = null;
    String exit = "";
    public static boolean isQuit = false;

        @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        /**
	         * Dashboard Screen for the application
	         * */
	        GlobalVariable apploginurl = ((GlobalVariable)getApplicationContext());
            
	        if (!apploginurl.isOnline()){
	        	 Toast.makeText(DashboardActivity.this, "You have no internet connectivity In order for Agentpitstop Mobile to work make sure you are in range of an internet connection",Toast.LENGTH_LONG).show();
	        	 finish();
	        }
	        // Check login status in database
	            userFunctions = new UserFunctions();
	            
	            String logged_in = userFunctions.isUserLoggedIn( );
	            
	            if (logged_in == "FALSE") {
	            // user is not logged in show login screen
	              Intent login = new Intent(DashboardActivity.this, LoginActivity.class);
	              startActivity(login);
	              if (apploginurl.isBaduser()){
	            	  Toast.makeText(DashboardActivity.this, "Invalid Login",Toast.LENGTH_LONG).show();
	            	  finish();
	              }
	            }
	            else
	            {
	            	 apploginurl.setState(logged_in);
	            }
	           
	            setContentView(R.layout.main);
	    	
        		GlobalVariable nextGlobalVariable = ((GlobalVariable)getApplicationContext());
        		try {
        		     Integer.parseInt(nextGlobalVariable.getNextTabActivity());
    		    	     } catch(NumberFormatException nfe) {
    		    	        System.out.println("Could not parse " + nfe);
    		    	     } 
        		
        	  if (nextGlobalVariable.nextTabActivity == null) {
        		  TabHost tabHost = getTabHost();
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
        		setTabs() ;
        	  }else
        	  if (nextGlobalVariable.nextTabActivity == "1") {
        		  TabHost tabHost = getTabHost();
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
          		  setRateTabs() ;
          	  }else
        	  if (nextGlobalVariable.nextTabActivity == "2") {
        		  TabHost tabHost = getTabHost();
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
        		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
            		setTabs() ;
            	  }
        		 
    	}
    	private void setTabs()
    	{
    		addTab("Home",  R.drawable.contacts, homepage.class);	
	        addTab("Rates", R.drawable.rates, rateengine.class);
	        addTab("Policies", R.drawable.policies, Policies.class);
       		addTab("Contacts", R.drawable.contacts, contactInfo.class);	
    	}		
    	private void setRateTabs()
    	{
    			
	        addTab("Supplements", R.drawable.rates, medicareSupplements.class);
	        addTab("Advantage", R.drawable.policies, medicareAdvantage.class);
       		addTab("PDP", R.drawable.contacts, perscriptionDrugplan.class);
       		addTab("Home",  R.drawable.contacts, homepage.class);
    	}  
     
 	

 	   private void addTab(String labelId, int drawableId, Class<?> c)
 		{
 			TabHost tabHost = getTabHost();
 			tabHost.setBackgroundColor(000000);
 			Intent intent = new Intent(this, c);
 			TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	

 			View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(),false);
 			TextView title = (TextView) tabIndicator.findViewById(R.id.title);
 			title.setText(labelId);
 		    
 			spec.setIndicator(tabIndicator);
 			spec.setContent(intent);
 			tabHost.addTab(spec);
 		}
 	  
 	  public void onStart(Bundle savedInstanceState) {
 		 GlobalVariable nextGlobalVariable = ((GlobalVariable)getApplicationContext());
 		try {
 		     Integer.parseInt(nextGlobalVariable.getNextTabActivity());
		    	     } catch(NumberFormatException nfe) {
		    	        System.out.println("Could not parse " + nfe);
		    	     } 
 		 if (nextGlobalVariable.nextTabActivity == null) {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
   		setTabs() ;
   	  }else
   	  if (nextGlobalVariable.nextTabActivity == "1") {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
     		  setRateTabs() ;
     	  }else
   	  if (nextGlobalVariable.nextTabActivity == "2") {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
       		setTabs() ;
       	  }
 	  }
 	 public void onResume(Bundle savedInstanceState) {
 		 GlobalVariable nextGlobalVariable = ((GlobalVariable)getApplicationContext());
 		try {
 		     Integer.parseInt(nextGlobalVariable.getNextTabActivity());
		    	     } catch(NumberFormatException nfe) {
		    	        System.out.println("Could not parse " + nfe);
		    	     } 
 		 if (nextGlobalVariable.nextTabActivity == null) {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
   		setTabs() ;
   	  }else
   	  if (nextGlobalVariable.nextTabActivity == "1") {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
     		  setRateTabs() ;
     	  }else
   	  if (nextGlobalVariable.nextTabActivity == "2") {
   		  TabHost tabHost = getTabHost();
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(0));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(1));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(2));
   		  tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
       		setTabs() ;
       	  }
 	  }
 }