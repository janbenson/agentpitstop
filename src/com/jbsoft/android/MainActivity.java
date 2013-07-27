package com.jbsoft.android;


import android.app.TabActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources resources = getResources(); 
		TabHost tabHost = getTabHost(); 
		tabHost.getTabWidget().setStripEnabled(false);
		
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
		
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(2);
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