package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
 
import com.jbsoft.library.UserFunctions;
 
public class DashboardActivity extends Activity {
    UserFunctions userFunctions;
    Button btnsubmissions;
    Button btnrateengine;
    String startString = null;
    String endString = null;
    String logged_in = null;
    private static String KEY_POLICY = "policy";
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
    
        /**
         * Dashboard Screen for the application
         * */       
        // Check login status in database
        userFunctions = new UserFunctions();
    
            // user is not logged in show login screen
            Intent login = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(login);
        	// user already logged in show databoard

        	 setContentView(R.layout.dashboard);
        	 // Importing all assets like buttons, text fields
             
        	 btnsubmissions = (Button) findViewById(R.id.btnsubmissions);
             btnrateengine = (Button) findViewById(R.id.btnrateengine);
             
             // Login button Click Event
             btnsubmissions.setOnClickListener(new View.OnClickListener() {
      
                 @Override
				public void onClick(View view) {
                	   TextView dashboardErrorMsg = null;
                     UserFunctions userFunction = new UserFunctions();

      
                     // check for login response
                     
                        
                                 // Launch Dashboard Screen
                                 Intent policies = new Intent(DashboardActivity.this, Policies.class);
                                  
                                 // Close all views before launching MainActivity
                                 startActivity(policies);
                                  
                                 // Close Login Screen
                                 finish();
            
                             
                    
                 }}
            ); 
             btnrateengine.setOnClickListener(new View.OnClickListener() {
                 
                 @Override
				public void onClick(View view) {
                     
                	 Intent rateengine = new Intent(DashboardActivity.this, rateengine.class);
                     
                     startActivity(rateengine);
                     // Closing dashboard screen
                    finish();}}
                     ); 
                
    }
}