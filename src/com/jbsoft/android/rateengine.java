package com.jbsoft.android;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class rateengine extends Activity {
  	
	private static final String TAG_SELECT = "Selection";
	Button btnSubmit;
	String smokerString,sexString ,zipcodeString,ageString;
	EditText age,zipcode;
	private CheckBox chkMale, chkFemale,chkSmoker, chkNonSmoker;
	@Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            final Dialog dialog = new Dialog(this);
        	dialog.setContentView(R.layout.dlg_rateengine);
			age = (EditText) dialog.findViewById(R.id.editText1);	
			zipcode = (EditText) dialog.findViewById(R.id.editText2);
			chkMale = (CheckBox) dialog.findViewById(R.id.checkBox_male);
			chkFemale = (CheckBox) dialog.findViewById(R.id.checkBox_female);
			chkSmoker = (CheckBox) dialog.findViewById(R.id.checkBox_smoker);
			chkNonSmoker = (CheckBox) dialog.findViewById(R.id.checkBox_nonsmoker);
			btnSubmit = (Button) dialog.findViewById(R.id.btnSubmit);
			dialog.show();
			
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
						  userparm.setNextTabActivity("1");
						  
						  Intent i = new Intent( rateengine.this, DashboardActivity.class );
						  startActivity( i );
						  dialog.dismiss();
						  finish();
						  }
                   }); 
				
	
			 
	}  
}
