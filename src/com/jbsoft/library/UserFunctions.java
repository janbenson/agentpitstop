package com.jbsoft.library;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

 
import android.content.Context;
 
public class UserFunctions {
     
    private JSONParser jsonParser;
     
    // Testing in localhost using wamp or xampp 
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    private static String loginpreloadURL = "http://api.agentpitstop.com/mobile/authenticate.php?action=login&username=Janet%20B%20Benson&password=jb54password";
    private static String loginURL = "http://api.agentpitstop.com/mobile/authenticate.php";
    private static String registerURL = "http://api.agentpitstop.com/mobile/authenticate.php";
    private static String rateengineURL = "http://api.agentpitstop.com/mobile/rates.php"; 
    private static String rateenginepreloadURL = "http://api.agentpitstop.com/mobile/rates.php?action=rates&age=76&zip=94561&sex=male&plan=F"; 
    private static String rateenginepreloadURLSmoker ="http://api.agentpitstop.com/mobile/rates.php?action=rates&age=76&zip=94518&sex=male&plan=F&tobacco=Smoker";
    private static String policiesURL = "http://api.agentpitstop.com/mobile/policies.php?action=status&start=2010-01-01&end=2013-12-31";
    private static String policiespreloadURL = "http://api.agentpitstop.com/mobile/policies.php?action=status&start=2010-01-01&end=2013-12-31";
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String rate_tag = "rates";
    private static String policies_tag = "policies"; 
    
    

    // contacts JSONArray
    JSONArray contacts = null;
    
    
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
     
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
    public JSONObject loginUser(String username, String password){
    	String temp = username;
    		temp = temp.replaceAll(" ", "%20");
    		username = temp;
         List<NameValuePair> params = new ArrayList<NameValuePair>();
         // Building Parameters
         String parmaction = "?action=login";
         String parmusername = "&username=";
         parmusername = parmusername + username;
         String parmpassword = "&password=";
         parmpassword = parmpassword + password;
         String parms = parmaction + parmusername + parmpassword;
         loginURL = loginURL + parms;

        /*params.add(new BasicNameValuePair("action", login_tag));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);*/
         JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
         
         //JSONObject json = jsonParser.getJSONFromUrl(loginpreloadURL, params);
          // return json
        // Log.e("JSON", json.toString());
         
        return json;
    }
    public JSONObject getRates(String ageString, String zipString,String sexString,String planString, String smokerString){
    	String parmaction = "?action=rates";
        String parmage = "&age=";
        parmage = parmage + ageString;
        String parmzip = "&zip=";
        parmzip = parmzip + zipString;
        String parmsex = "&sex=";
        parmage = parmsex + sexString;
        String parmplan = "&plan=";
        parmzip = parmplan + planString;
        String parmsmoker = "&smoker=";
        parmzip = parmsmoker + smokerString;
        String parms = parmaction + parmage + parmzip + parmsex + parmplan + parmsmoker;
        rateengineURL = rateengineURL + parms;
    	
    	
    	
        // Building Parameters
        List<NameValuePair> rateparams = new ArrayList<NameValuePair>();
       /* rateparams.add(new BasicNameValuePair("action", rate_tag));
        rateparams.add(new BasicNameValuePair("age", ageString));
        rateparams.add(new BasicNameValuePair("zip", zipString));
        rateparams.add(new BasicNameValuePair("plan", "F"));*/
        JSONObject json = jsonParser.getJSONFromUrl(rateengineURL, rateparams);
        
          // return json
        // Log.e("JSON", json.toString());
        return json;
    }  
    public JSONObject getSubmissions(String startString, String endString){
        // Building Parameters
        List<NameValuePair> submissionparams = new ArrayList<NameValuePair>();
        submissionparams.add(new BasicNameValuePair("action", rate_tag));
        submissionparams.add(new BasicNameValuePair("start", startString));
        submissionparams.add(new BasicNameValuePair("end", endString));
        submissionparams.add(new BasicNameValuePair("plan", "F"));
        JSONObject json = jsonParser.getJSONFromUrl(policiespreloadURL, submissionparams);

          // return json
        // Log.e("JSON", json.toString());
        return json;
    }  
    /**
     * function make Login Request
     * @param name
     * @param email
     * @param password
     * */
   /* public JSONObject registerUser(String name, String email, String password){
        // Building Parameters
    	String parmaction = "?action=register";
        String parmusername = "&name=";
        parmusername = parmusername + name;
        String parmemail = "&email=";
        parmusername = parmemail + email;
        String parmpassword = "&password=";
        parmpassword = parmpassword + password;
        String parms = parmaction + parmusername + parmemail + parmpassword;
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, parms);
         
        // getting JSON Object
        
        // return json
        return json;
    }*/
     
    /**
     * Function get Login status
     * */
    public String isUserLoggedIn(String logged_in){
         if( logged_in == "TRUE" ){
            return logged_in;
        }
        if( logged_in == "FALSE" ){
            
        return logged_in;
    }
		return logged_in;
	
    }
     
    /**
     * Function to logout user
     * Reset Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
     
}