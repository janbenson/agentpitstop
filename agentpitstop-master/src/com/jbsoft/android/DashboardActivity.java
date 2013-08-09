package com.jbsoft.android;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


 
import com.jbsoft.library.UserFunctions;
 
public class DashboardActivity extends TabActivity {
    UserFunctions userFunctions;
    Button btnsubmissions;
    Button btnrateengine;
    String startString = null;
    String endString = null;
    String logged_in = null;
    String exit = "";
    private static final String TAG_SELECT = "Selection";
    public static boolean isQuit = false;

        @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        /**
	         * Dashboard Screen for the application
	         * */       
	        // Check login status in database
	            userFunctions = new UserFunctions();
	            
	            String logged_in = userFunctions.isUserLoggedIn( );
	            
	            if (logged_in == "FALSE") {
	            // user is not logged in show login screen
	              Intent login = new Intent(DashboardActivity.this, LoginActivity.class);
	              startActivity(login);
	            }
	            else
	            {
	            	 GlobalVariable apploginurl = ((GlobalVariable)getApplicationContext());
	                 apploginurl.setState(logged_in);
	            }
	            String Selects = null;
	    	    requestWindowFeature(Window.FEATURE_RIGHT_ICON);
	    		setContentView(R.layout.main);
	            setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.vb1);
	    		Intent i = getIntent();
	            Selects= i.getStringExtra("Selection");
	            Resources resources = getResources(); 
	    		TabHost tabHost = getTabHost(); 
	    		
	    		Integer selectedtab = 0;
	
	        		GlobalVariable nextGlobalVariable = ((GlobalVariable)getApplicationContext());
	        		try {
	        		     selectedtab = Integer.parseInt(nextGlobalVariable.getNextTabActivity());
	    		    	     } catch(NumberFormatException nfe) {
	    		    	        System.out.println("Could not parse " + nfe);
	    		    	     } 
	
	    		
	    		
	            
				Intent intentRate = new Intent().setClass(this, rateengine.class);
				TabSpec tabSpecRateengine = tabHost
					.newTabSpec("Change Rate")
					.setIndicator("", resources.getDrawable(R.drawable.icon_rateengine_config))
					.setContent(intentRate);	 
				
			// Medicare Supplements
			Intent intentSupps = new Intent().setClass(this, medicareSupplements.class);
			TabSpec tabSpecSupps = tabHost
				.newTabSpec("Medicare Supplements")
				.setIndicator("", resources.getDrawable(R.drawable.icon_android_config))
				.setContent(intentSupps);
	
			// Medicare Advantage tab
			Intent intentAdv = new Intent().setClass(this, medicareAdvantage.class);
			TabSpec tabSpecAdv = tabHost
				.newTabSpec("Medicare Advantage")
				.setIndicator("", resources.getDrawable(R.drawable.icon_medadv_config))
				.setContent(intentAdv);
			
			// Perscription Drug Plan tab
			Intent intentPerscrip = new Intent().setClass(this, perscriptionDrugplan.class);
			TabSpec tabSpecPdp = tabHost
				.newTabSpec("Perscription Drug Plan")
				.setIndicator("", resources.getDrawable(R.drawable.icon_perscriptiondrugplan_config))
				.setContent(intentPerscrip);
	            
	    		Intent intentSubmit = new Intent().setClass(this, submissionfilter.class);
	    		TabSpec tabSpecSubmit = tabHost
	    			.newTabSpec("Select Date Range")
	    			.setIndicator("", resources.getDrawable(R.drawable.icon_submitfilter_config))
	    			.setContent(intentSubmit);
	    		
	        	// Policy Submission
	    		Intent intentPolicies = new Intent().setClass(this, Policies.class);
	    		TabSpec tabSpecPolicies = tabHost
	    			.newTabSpec("Policy Submissions")
	    			.setIndicator("", resources.getDrawable(R.drawable.icon_policysubmit_config))
	    			.setContent(intentPolicies);
	    		
	    		// Policy Submission
	    		Intent intentContacts = new Intent().setClass(this, contactInfo.class);
	    		TabSpec tabSpecContacts = tabHost
	    			.newTabSpec("Contact Info")
	    			.setIndicator("", resources.getDrawable(R.drawable.icon_policysubmit_config))
	    			.setContent(intentContacts);
	
	    		
	    		// Exit tab
	    		
	    		Intent Exitintent = new Intent(Intent.ACTION_MAIN);
	    		Exitintent.addCategory(Intent.CATEGORY_HOME);
	    		Exitintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	      		TabSpec tabSpecExit = tabHost
				.newTabSpec("Exit")
	    		.setIndicator("", resources.getDrawable(R.drawable.icon_exit_config))
	    		.setContent(Exitintent);
				// add all tabs 
				tabHost.addTab(tabSpecRateengine);	
				tabHost.addTab(tabSpecSupps);
				tabHost.addTab(tabSpecAdv);
				tabHost.addTab(tabSpecPdp);
				tabHost.addTab(tabSpecPolicies);
				tabHost.addTab(tabSpecSubmit);
				tabHost.addTab(tabSpecExit);
				tabHost.addTab(tabSpecContacts);
	    		tabHost.setCurrentTab(selectedtab);
	            
	            
	            
	            
	            
	            
	        	// user already logged in show databoard
	         /*    requestWindowFeature(Window.FEATURE_LEFT_ICON);
	        	 setContentView(R.layout.dashboard); 
	        	 setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.vb1);
	        	 
	        	 // Importing all assets like buttons, text fields
	             
	        	 btnsubmissions = (Button) findViewById(R.id.btnsubmissions);
	             btnrateengine = (Button) findViewById(R.id.btnrateengine);
	             
	             // Login button Click Event
	             btnsubmissions.setOnClickListener(new View.OnClickListener() {
	      
	                 @Override
					public void onClick(View view) {
	                
	      
	                     // check for login response
	
	                                 // Launch Dashboard Screen
	                                 Intent policies = new Intent(DashboardActivity.this, MainActivity.class);
	                                 policies.putExtra(TAG_SELECT, "submissions"); 
	                                 // Close all views before launching MainActivity
	                                 startActivity(policies);
	                                 // Close Login Screen
	                                 DashboardActivity.isQuit = true;
	                                 finish();
	                 }}
	            ); 
	             btnrateengine.setOnClickListener(new View.OnClickListener() {
	                 
	                 @Override
					public void onClick(View view) {
	                     
	                	 Intent rateengine = new Intent(DashboardActivity.this, MainActivity.class);
	                	 rateengine.putExtra(TAG_SELECT, "rateengine");
	                     startActivity(rateengine);
	                     // Closing dashboard screen
	                     DashboardActivity.isQuit = true;
	                     finish();
	}}
	             
	                     ); 
	                
	    }
	    
	   */
	        
	    }
         
    // add this line for Removing Force Close 
 //   @Override
   //     protected void onDestroy() {
    // closing Entire Application
    //        android.os.Process.killProcess(android.os.Process.myPid());
    //        super.onDestroy();
    //    }

 	
 	 @Override
 	    protected void onStart() {
 	        super.onStart();
 	    }

 	  @Override
 	    protected void onRestart() {
 	        // TODO Auto-generated method stub
 	        super.onRestart();
 	      
 	    }

 	    @Override
 	    protected void onResume() {
 	        super.onResume();
 	    }


 }