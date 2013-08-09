package com.jbsoft.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class perscriptionDrugplan extends Activity {

	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        TextView textview = new TextView(this);
	        textview.setText("This is where the Prescription Drug Plan info will display");
	        setContentView(textview);
	    }
 
}