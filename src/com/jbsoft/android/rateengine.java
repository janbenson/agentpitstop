package com.jbsoft.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.jbsoft.library.UserFunctions;

public class rateengine extends Activity{

	private Spinner sex_spinner, smoker_spinner;
	private EditText zipcode,age;
	private Button btnSubmit;
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
					public void onClick(View v) {
						String zipcodeString = zipcode.getEditableText().toString();
						String smokerString = smoker_spinner.toString();
						String sexString = sex_spinner.toString();
						String ageString = age.getEditableText().toString();
						UserFunctions userFunction = new UserFunctions();
						  Intent i = new Intent( rateengine.this, medicareSupplements.class );
						  startActivity( i );
					}
				});
				
		}
		}