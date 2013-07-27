package com.jbsoft.android;

import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 

import com.jbsoft.library.UserFunctions;
 
public class LoginActivity extends Activity {
    Button btnLogin;
    Button btnLinkToRegister;
    EditText inputUsername;
    EditText inputPassword;
    TextView loginErrorMsg;
 
    // JSON Response node names
    private static String KEY_SUCCESS = "success";
    
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apslogin);
 
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
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                UserFunctions userFunction = new UserFunctions();
                JSONObject json = userFunction.loginUser(username, password);
 
                // check for login response
                try {
                      if (json.getString(KEY_SUCCESS) != null) {
                            String logged_in = null;  
                            // Launch Dashboard Screen
                            
                             
                            // Close Login Screen
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
}