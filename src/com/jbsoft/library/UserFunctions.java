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
     

    private static String loginURL = "http://api.agentpitstop.com/mobile/authenticate.php";
    private static String rateengineURL = "http://api.agentpitstop.com/mobile/rates.php"; 
    private static String policiespreloadURL = "http://api.agentpitstop.com/mobile/policies.php?action=status&start=2010-01-01&end=2013-12-31";
    private static String rate_tag = "rates";

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

         JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
         
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
        JSONObject json = jsonParser.getJSONFromUrl(rateengineURL, rateparams);
        
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

        return json;
    }  
     
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