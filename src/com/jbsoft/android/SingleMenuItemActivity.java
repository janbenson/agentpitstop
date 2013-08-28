package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SingleMenuItemActivity extends Activity{
	private String firstname,lastname,company,submitted,effective,status,plan,email,phone;
    private Button backbtn;
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
	    phone = i.getStringExtra("phone");
	    email = i.getStringExtra("email");

	    
	    TextView first = (TextView) findViewById(R.id.first);
	    TextView last = (TextView) findViewById(R.id.last);
	    TextView comp = (TextView) findViewById(R.id.company);
	    TextView planview = (TextView) findViewById(R.id.plan);
	    TextView statusview = (TextView) findViewById(R.id.status);
	    TextView submittedview = (TextView) findViewById(R.id.submitted);
	    TextView effectiveview = (TextView) findViewById(R.id.effective);
	    TextView emailview = (TextView) findViewById(R.id.email);
	    TextView phoneview = (TextView) findViewById(R.id.phone);
	    Button backbtn = (Button) findViewById(R.id.backbtn);
	    //backbtn.setOnClickListener((OnClickListener) this); 
	    String formattednumber = PhoneNumberUtils.formatNumber(phone);
	    // getting attached intent data
	    first.setText(firstname);
	    last.setText(lastname);
	    comp.setText(company);
	    planview.setText(plan);
	    submittedview.setText(submitted);
	    effectiveview.setText(effective);
	    statusview.setText(status);
	    phoneview.setText(formattednumber);
	    emailview.setText(email);
	    

	    phoneview.setOnClickListener(new OnClickListener() {
	    	@Override
			public void onClick(View v) {

            	
            	String number = "tel:" + phone;
            	Intent dialer = new Intent(Intent.ACTION_CALL,Uri.parse(number));
            	startActivity(dialer);
            }
	    	
		    
	    	
			
			             
        }) ;
        
       	

	    
	    
	    
	    
	}public void BackBtnHandler(View view) {
	    finish();
	}
	
}
