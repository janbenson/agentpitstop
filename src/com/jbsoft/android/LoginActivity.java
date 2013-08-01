package com.jbsoft.android;


import org.json.JSONException;
import org.json.JSONObject;

import com.jbsoft.library.UserFunctions;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class LoginActivity extends Activity {
    Button btnLogin;
    Button btnLinkToRegister;
    EditText inputUsername;
    EditText inputPassword;
    TextView loginErrorMsg;
    private static String loginURL = "http://api.agentpitstop.com/mobile/authenticate.php";
 
    // JSON Response node names
    private static String KEY_SUCCESS = "success";
    
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.apslogin);
        setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.vb1);
 
        // Importing all assets like buttons, text fields
        inputUsername = (EditText) findViewById(R.id.loginUsername);
        inputPassword = (EditText) findViewById(R.id.loginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);
 
        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
 
            @Override
			public void onClick(View view) {
            	
                String username = (inputUsername.getText().toString()).trim();
                String password = inputPassword.getText().toString();
             	String temp = username;
        		temp = temp.replaceAll(" ", "%20");
        		username = temp;
                String parmaction = "?action=login";
                String parmusername = "&username=";
                parmusername = parmusername + username;
                String parmpassword = "&password=";
                parmpassword = parmpassword + password;
                String parms = parmaction + parmusername + parmpassword;
                loginURL = loginURL + parms;
                GlobalVariable apploginurl = ((GlobalVariable)getApplicationContext());
                apploginurl.setState(loginURL);
                
                
                
                UserFunctions userFunction = new UserFunctions();
                JSONObject json = userFunction.loginUser(username, password);
 
                // check for login response
                try {
                      if (json.getString(KEY_SUCCESS) != null) {
                                 finish();

                        }else{
                            // Error in login
                            loginErrorMsg.setText("Incorrect username/password");
                        }
                
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
 
   /*     btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });*/
    }
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        if(DashboardActivity.isQuit)
            finish();
    }

}