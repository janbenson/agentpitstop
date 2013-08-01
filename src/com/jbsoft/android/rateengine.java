package com.jbsoft.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class rateengine extends Activity{
	
	private static final String TAG_SELECT = "Selection";
	private Spinner sex_spinner, smoker_spinner ;
	private Button btnSubmit;
	private String smokerString,sexString ,zipcodeString,ageString;
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
			    	smokerString = (parentView.getItemAtPosition(position).toString()).trim();
			    }}
            );
			sex_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener() 
			{
			    @Override
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
			    {
			    	sexString = (parentView.getItemAtPosition(position).toString()).trim();
			    }}
            );        
             // Login button Click Event
             btnSubmit.setOnClickListener(new View.OnClickListener() {
      
                 @Override
		     public void onClick(View v) {
						zipcodeString = (zipcode.getEditableText().toString()).trim();
						ageString = (age.getEditableText().toString()).trim();
						GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
						  userparm.setSex(sexString);
						  userparm.setAge(ageString);
						  userparm.setZip(zipcodeString);
						  userparm.setSmoker(smokerString);
						  userparm.setNextTabActivity("1");
						  
						  Intent i = new Intent( rateengine.this, reportsActivity.class );
						  i.putExtra(TAG_SELECT, "rateengine"); 
						  startActivity( i );
						  }
                    }); 
                
    }
		}