package com.jbsoft.android;


import android.app.TabActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	String Selects = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_RIGHT_ICON);
		setContentView(R.layout.main);
        setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.vb1);

		Intent i = getIntent();
	    

        Selects= i.getStringExtra("Selection");
        Resources resources = getResources(); 
		TabHost tabHost = getTabHost(); 
		tabHost.getTabWidget().setStripEnabled(false);
        if (Selects.contentEquals("submissions")) {
        	// Medicare Supplements
    		Intent intentPolicies = new Intent().setClass(this, Policies.class);
    		TabSpec tabSpecPolicies = tabHost
    			.newTabSpec("Policy Submissions")
    			.setIndicator("", resources.getDrawable(R.drawable.icon_policysubmit_config))
    			.setContent(intentPolicies);

    		// Change Date Selection
    		Intent intentSubmit = new Intent().setClass(this, submissionfilter.class);
    		TabSpec tabSpecSubmit = tabHost
    			.newTabSpec("Select Date Range")
    			.setIndicator("", resources.getDrawable(R.drawable.icon_medadv_config))
    			.setContent(intentSubmit);
    		
    		// RateEngine tab
			Intent intentRate = new Intent().setClass(this, rateengine.class);
			TabSpec tabSpecRateengine = tabHost
				.newTabSpec("Change Rate")
				.setIndicator("", resources.getDrawable(R.drawable.icon_rateengine_config))
				.setContent(intentRate);
    		
    		// RateEngine tab
					Intent intentExit= new Intent().setClass(this, DashboardActivity.class);
					
    				TabSpec tabSpecExit = tabHost
    					.newTabSpec("Exit")
    					.setIndicator("", resources.getDrawable(R.drawable.icon_rateengine_config))
    					.setContent(intentExit);
    				     
    		// add all tabs 
    		tabHost.addTab(tabSpecPolicies);
    		tabHost.addTab(tabSpecExit);
    		tabHost.addTab(tabSpecSubmit);
    		tabHost.addTab(tabSpecRateengine);
            }		
          else{
		// Medicare Supplements
		Intent intentSupps = new Intent().setClass(this, medicareSupplements.class);
		TabSpec tabSpecSupps = tabHost
			.newTabSpec("Medicare Supplements")
			.setIndicator("", resources.getDrawable(R.drawable.icon_android_config))
			.setContent(intentSupps);

		// Medicare Advantage tab
		Intent intentAdv = new Intent().setClass(this, medicareAdvantage.class);
		TabSpec tabSpecAdv = tabHost
			.newTabSpec("Medicare Advantage")
			.setIndicator("", resources.getDrawable(R.drawable.icon_medadv_config))
			.setContent(intentAdv);
		
		// Perscription Drug Plan tab
		Intent intentPerscrip = new Intent().setClass(this, perscriptionDrugplan.class);
		TabSpec tabSpecPdp = tabHost
			.newTabSpec("Perscription Drug Plan")
			.setIndicator("", resources.getDrawable(R.drawable.icon_perscriptiondrugplan_config))
			.setContent(intentPerscrip);
		
		// RateEngine tab
				Intent intentRate = new Intent().setClass(this, rateengine.class);
				TabSpec tabSpecRateengine = tabHost
					.newTabSpec("Change Rate")
					.setIndicator("", resources.getDrawable(R.drawable.icon_rateengine_config))
					.setContent(intentRate);
		// add all tabs 
		tabHost.addTab(tabSpecSupps);
		tabHost.addTab(tabSpecAdv);
		tabHost.addTab(tabSpecPdp);
		tabHost.addTab(tabSpecRateengine);
        }		
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}
	
	 @Override
	    protected void onStart() {
	        super.onStart();
	    }

	    @Override
	    protected void onRestart() {
	        super.onRestart();
	    }

	    @Override
	    protected void onResume() {
	        super.onResume();
	    }


}