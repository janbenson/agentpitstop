package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class SingleMenuItemActivity extends Activity{
	private String firstname,lastname,company,submitted,effective,status,plan;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Intent i = getIntent();
	    
	    requestWindowFeature(Window.FEATURE_RIGHT_ICON);
	    this.setContentView(R.layout.policies_list_item_detail);
        setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.vb1);
	    firstname = i.getStringExtra("firstname");
	    lastname = i.getStringExtra("lastname");
	    company = i.getStringExtra("company");
	    plan = i.getStringExtra("company");
	    submitted = i.getStringExtra("submitted");
	    effective = i.getStringExtra("effective");
	    status = i.getStringExtra("status");

	    TextView first = (TextView) findViewById(R.id.first);
	    TextView last = (TextView) findViewById(R.id.last);
	    TextView comp = (TextView) findViewById(R.id.company);
	    TextView planview = (TextView) findViewById(R.id.plan);
	    TextView statusview = (TextView) findViewById(R.id.status);
	    TextView submittedview = (TextView) findViewById(R.id.submitted);
	    TextView effectiveview = (TextView) findViewById(R.id.effective);
	    
	    // getting attached intent data
	    // displaying selected product name
	    first.setText(firstname);
	    last.setText(lastname);
	    comp.setText(company);
	    planview.setText(plan);
	    submittedview.setText(submitted);
	    effectiveview.setText(effective);
	    statusview.setText(status);
	    
	}
}
