package com.jbsoft.android;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class rateengine extends Activity {
  	
	private static final String TAG_SELECT = "Selection";
	private static final int defplan = 4;
	Button btnSubmit;
	String smokerString,sexString ,zipcodeString,ageString,planString;
	EditText age,zipcode;
	private CheckBox chkMale, chkFemale,chkSmoker, chkNonSmoker;
	private Spinner plansspinner;

	@Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //final Dialog dialog = new Dialog(this);
        	setContentView(R.layout.rateengine_new);
			age = (EditText) findViewById(R.id.editText1);	
			zipcode = (EditText) findViewById(R.id.editText2);
			chkMale = (CheckBox) findViewById(R.id.checkBox_male);
			chkFemale = (CheckBox) findViewById(R.id.checkBox_female);
			chkSmoker = (CheckBox) findViewById(R.id.checkBox_smoker);
			chkNonSmoker = (CheckBox) findViewById(R.id.checkBox_nonsmoker);
			plansspinner = (Spinner) findViewById(R.id.plansspinner);
			btnSubmit = (Button) findViewById(R.id.btnSubmit);
			plansspinner.setSelection(defplan);
	    	plansspinner.setOnItemSelectedListener(new CustomOnItemSelectedListener()
					{
						@Override

						public void onItemSelected(AdapterView<?> parentview, View selectedView, int position, long id)
						{
							planString = (parentview.getItemAtPosition(position).toString());
						}
						
					}
	     );

			btnSubmit.setOnClickListener(new View.OnClickListener() {
		     public void onClick(View v) {
						zipcodeString = (zipcode.getEditableText().toString()).trim();
						ageString = (age.getEditableText().toString()).trim();
						if (chkMale.isChecked()){
							sexString = "male";
							chkFemale.setChecked(false);}
						if (chkFemale.isChecked()){
							sexString = "female";
							chkMale.setChecked(false);}
						if (chkSmoker.isChecked()){
							smokerString = "Smoker";
							chkNonSmoker.setChecked(false);}
						if (chkNonSmoker.isChecked()){
							smokerString = "Non-Smoker";
							chkSmoker.setChecked(false);}
						
						

						GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
						  userparm.setSex(sexString);
						  userparm.setAge(ageString);
						  userparm.setZip(zipcodeString);
						  userparm.setSmoker(smokerString);
						  userparm.setPlan(planString);
						  userparm.setNextTabActivity("1");
						  
						  Intent i = new Intent( rateengine.this, DashboardActivity.class );
						  startActivity( i );
						  finish();
						  }
                   }); 
}}	 
	  
 