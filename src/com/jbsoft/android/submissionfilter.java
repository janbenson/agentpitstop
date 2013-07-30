package com.jbsoft.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class submissionfilter extends Activity{

	private Spinner sex_spinner, smoker_spinner;
	@SuppressWarnings("unused")
	private EditText zipcode,age;
	private Button btnSubmit;
	 @SuppressWarnings("unused")
	@Override
	  public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
			setContentView(R.layout.rateengine);
			EditText age = (EditText) findViewById(R.id.editText1);		
			smoker_spinner = (Spinner) findViewById(R.id.spinner2);
			sex_spinner = (Spinner) findViewById(R.id.spinner3);
			EditText zipcode = (EditText) findViewById(R.id.editText2);
			btnSubmit = (Button) findViewById(R.id.btnSubmit);
			
 	 }
	          
		public void addListenerOnSpinnerItemSelection() {
				
			smoker_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			sex_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			  }
		
			  public void addListenerOnButton() {

				btnSubmit.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						
						  Intent i = new Intent( submissionfilter.this, medicareSupplements.class );
						  startActivity( i );
					}
				});
				
		}
		}