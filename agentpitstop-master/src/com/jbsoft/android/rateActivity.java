package com.jbsoft.android;




import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
 

public class rateActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateactivity);
    
        TextView textview = new TextView(this);
        textview.setText("This is Rate Activity Holder Get to work on the API from Agent Pit Stop Site");
        setContentView(textview);
        
 }	
    }
