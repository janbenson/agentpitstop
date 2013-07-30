package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class SingleMenuItemActivityMedSupps extends Activity{
	@SuppressWarnings("unused")
	private String rate,company,payplan,plan;

	@SuppressWarnings("unused")
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Intent i = getIntent();
	    
	    requestWindowFeature(Window.FEATURE_RIGHT_ICON);
	    this.setContentView(R.layout.medsupp_list_item_detail);
        setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.vb1);
	    company = i.getStringExtra("company");
	    plan = i.getStringExtra("plan");
	    rate = i.getStringExtra("rate");
	    payplan = i.getStringExtra("payplan");


	    TextView rate = (TextView) findViewById(R.id.rate);
	    TextView payplan = (TextView) findViewById(R.id.payoption);
	    TextView comp = (TextView) findViewById(R.id.company);
	    TextView planview = (TextView) findViewById(R.id.plan);
	    
	    // getting attached intent data
	    // displaying selected product name
	    
	    comp.setText(company);
	    planview.setText(plan);
	}
}
