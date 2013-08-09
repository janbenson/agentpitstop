package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SingleMenuItemActivityMedSupps extends Activity{
	@SuppressWarnings("unused")
	private String rate,company,payplan,plan,phone,email;

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
	    phone = i.getStringExtra("phone");
	    email = i.getStringExtra("email");


	    TextView rate = (TextView) findViewById(R.id.rate);
	    TextView payplan = (TextView) findViewById(R.id.payoption);
	    TextView comp = (TextView) findViewById(R.id.company);
	    TextView planview = (TextView) findViewById(R.id.plan);
	    TextView phone = (TextView) findViewById(R.id.phone);
	    TextView email = (TextView) findViewById(R.id.email);
	    
	    // getting attached intent data
	    // displaying selected product name
	    
	    comp.setText(company);
	    planview.setText(plan);
	    
	    // Launching new screen on Selecting Single ListItem
   /*     lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
            	TextView v=(TextView) view.findViewById(R.id.phonenum);
            	String string = (String) v.getText();
            	String number = "tel:" + string;
            	Intent dialer = new Intent(Intent.ACTION_CALL,Uri.parse(number));
            	startActivity(dialer);
            }      */ 
	}
	
}
