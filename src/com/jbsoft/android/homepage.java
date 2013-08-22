package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;

import com.jbsoft.android.Policies.LoadPolicies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;


public class homepage extends Activity{

	 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);

		        
		 }
	 
	 
	 public void onResume(Bundle savedInstanceState){
		 super.onResume();
		 setContentView(R.layout.homepage);
			GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
			String tab_bank =  userparm.getNextTabActivity();
			  userparm.setNextTabActivity("2");
			  
	 }
	 @Override
	    protected void onStart() {
	        super.onStart();
	   	 setContentView(R.layout.homepage);
	   	GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
	   	String tab_bank =  userparm.getNextTabActivity();
		  userparm.setNextTabActivity("2");
		 }
}
