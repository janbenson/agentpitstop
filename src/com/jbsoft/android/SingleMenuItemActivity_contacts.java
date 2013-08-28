package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SingleMenuItemActivity_contacts extends Activity{
	private String name,fax,tollfree,email,phone;
    private Button backbtn;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Intent i = getIntent();
	    
	     
	    this.setContentView(R.layout.contact_list_item_detail);
         
        
	    name = i.getStringExtra("name");
	    phone = i.getStringExtra("phone");
	    email = i.getStringExtra("email");
	    tollfree = i.getStringExtra("tollfree");
	    fax = i.getStringExtra("fax");
	    
	    TextView namev = (TextView) findViewById(R.id.name);
	    final TextView phonev = (TextView) findViewById(R.id.phone);
	    TextView faxv = (TextView) findViewById(R.id.fax);
	    final TextView emailv = (TextView) findViewById(R.id.email2);
	    final TextView tollfreev = (TextView) findViewById(R.id.tollfree);
	    Button backbtn = (Button) findViewById(R.id.backbtn);
	    //backbtn.setOnClickListener((OnClickListener) this); 
	    
	    // getting attached intent data
	    namev.setText(name);
	    phonev.setText(phone);
	    faxv.setText(fax);
	    emailv.setText(email);
	    tollfreev.setText(tollfree);
	    
	    

	    phonev.setOnClickListener(new OnClickListener() {
	    	@Override
			public void onClick(View v) {

            	
            	String number = "tel:" + phone;
            	Intent dialer = new Intent(Intent.ACTION_CALL,Uri.parse(number));
            	startActivity(dialer);
            }
	    	
			             
        });
        
	    tollfreev.setOnClickListener(new OnClickListener() {
	    	@Override
			public void onClick(View v) {

            	
            	String number = "tel:" + tollfree;
            	Intent dialer = new Intent(Intent.ACTION_CALL,Uri.parse(number));
            	startActivity(dialer);
            }
	    	
			             
        });
       	

	    
	    
	    
	    
	}public void BackBtnHandler(View view) {
	    finish();
	}
	
}
