package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
    
            // user is not logged in show login screen
            Intent login = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(login);
        	// user already logged in show databoard
             requestWindowFeature(Window.FEATURE_LEFT_ICON);
        	 setContentView(R.layout.dashboard); 
        	 setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.vb1);
        	 
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
                                 Intent policies = new Intent(DashboardActivity.this, MainActivity.class);
                                 policies.putExtra(TAG_SELECT, "submissions"); 
                                 // Close all views before launching MainActivity
                                 startActivity(policies);
                                 // Close Login Screen
                                 DashboardActivity.isQuit = true;
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
    
   
        
}