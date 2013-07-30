package com.jbsoft.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.jbsoft.library.UserFunctions;

public class rateengine extends Activity{

	private Spinner sex_spinner, smoker_spinner ;
	private Button btnSubmit;
	private String smokerString,sexString ,zipcodeString,ageString;
	private static final String TAG_SEX = "sex";
	private static final String TAG_AGE = "age";
	private static final String TAG_SMOKER = "smoker";
	private static final String TAG_ZIP = "zip";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
			setContentView(R.layout.rateengine);
			final EditText age = (EditText) findViewById(R.id.editText2);		
			smoker_spinner = (Spinner) findViewById(R.id.spinner2);
			sex_spinner = (Spinner) findViewById(R.id.spinner3);
			final EditText zipcode = (EditText) findViewById(R.id.editText1);
			btnSubmit = (Button) findViewById(R.id.btnSubmit);
			
			smoker_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener() 
			{
			    @Override
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
			    {
			    	smokerString = parentView.getItemAtPosition(position).toString();
			    }}
			
				 
            );
            
			sex_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener() 
			{
			    @Override
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
			    {
			    	sexString = parentView.getItemAtPosition(position).toString();
			    }}
			
				 
            );        
            
            
            
			
             // Login button Click Event
             btnSubmit.setOnClickListener(new View.OnClickListener() {
      
                 @Override
		     public void onClick(View v) {
						zipcodeString = zipcode.getEditableText().toString();
						ageString = age.getEditableText().toString();
						UserFunctions userFunction = new UserFunctions();
						  Intent i = new Intent( rateengine.this, medicareSupplements.class );
						  i.putExtra(TAG_SEX, sexString);
						  i.putExtra(TAG_AGE, ageString);
						  i.putExtra(TAG_ZIP, zipcodeString);
						  i.putExtra(TAG_SMOKER, smokerString);
						  startActivity( i );
					}
                    }); 
                
    }
		}