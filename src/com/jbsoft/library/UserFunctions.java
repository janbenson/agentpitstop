package com.jbsoft.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jbsoft.android.GlobalVariable;

 
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
public class UserFunctions {
     
    private JSONParser jsonParser;
    private GlobalVariable gb;
    private String  url ;
     

    private static String loginURL = "http://api.agentpitstop.com/mobile/authenticate.php";
    private static String rateengineURL = "http://api.agentpitstop.com/mobile/rates.php"; 
    private static String policiesURL = "http://api.agentpitstop.com/mobile/policies.php";
    private static String root = Environment.getExternalStorageDirectory().toString();
    
    private static File newfile,apsDir;
    private static File sdcard; 


    // contacts JSONArray
    JSONArray contacts = null;
	private char[] buf;
    
    
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
    	String cleanURL = ""; 
    	String parmaction = "?action=rates";
        String parmage = "&age=";
        parmage = parmage + ageString;
        String parmzip = "&zip=";
        parmzip = parmzip + zipString;
        String parmsex = "&sex=";
        parmsex = parmsex + sexString;
        String parmplan = "&plan=";
        parmplan = parmplan + planString;
        String parmsmoker = "&tobacco=";
        parmsmoker = parmsmoker + smokerString;
        String parms = parmaction + parmage + parmzip + parmsex + parmplan + parmsmoker;
        cleanURL = rateengineURL + parms;
        //rateengineURL = rateengineURL + parms;
    	
        // Building Parameters
        List<NameValuePair> rateparams = new ArrayList<NameValuePair>();
        JSONObject json = jsonParser.getJSONFromUrl(cleanURL, rateparams);
        
        return json;
    }  
    public JSONObject getSubmissions(String startString, String endString){
    	String cleanURL = "";
        String parmaction = "?action=status";
        String parmstart = "&start=";
        if (startString==null){startString = "2010-01-01";}
        if (endString==null){endString = "2013-12-31";}
        parmstart = parmstart + startString;
        String parmend = "&end=";
        parmend = parmend + endString;
        
        String parms = parmaction + parmstart + parmend ;
       // policiesURL = policiesURL + parms;
        cleanURL = policiesURL + parms;
    	
        List<NameValuePair> submissionparams = new ArrayList<NameValuePair>();
       
        JSONObject json = jsonParser.getafterloggedinJSONFromUrl(cleanURL, submissionparams);

        return json;
    }  
     
    /**
     * Function get Login status
     * */
    public String isUserLoggedIn(){
    	String result = "TRUE";
    	
    	{result =  "FALSE";}

    	
		if (isthereafileFile()=="FALSE")
     	   {result = "FALSE";}
     	else{
     		
     	
     	url = readconfig();	
     	result = url;
     	}
		return result;
    }
     
    private String readconfig() {
    	String ret ="";
    
    	//Get the text file
        File apscfg = new File(root +"/apsdata/","apscfg.txt");

    	//Read text from file
    	StringBuilder text = new StringBuilder();

    	try {
    	    BufferedReader br = new BufferedReader(new FileReader(apscfg));
    	    String line;

    	  
    	    while ((line = br.readLine()) != null) {
    	    	ret =  line;
    	    }
    	}
    	catch (IOException e) {
    	    //You'll need to add proper error handling here
    	}

       
		return ret;
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
   
    
    
    public void writeToFile(String data) {
        try {
        File apscfg = new File(root +"/apsdata/","apscfg.txt");
        if (data.length() > 0){
        try {
            	FileWriter filewriter = new FileWriter(apscfg,true);
            	BufferedWriter out = new BufferedWriter(filewriter);
            	     out.write(data);
                 out.close();
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        finally{
     	   
        }   
        }
        }
   finally{
	   
   }   
    }


  

	private String isthereafileFile() {
		String result = "TRUE";

	    
	    File checkdir = new File (root + "/apsdata") ;    
		
		if (!checkdir.exists()){
		    checkdir.mkdirs();
		    result = "FALSE";
		}
           return result;		
	}
	
        

	private InputStream openFileInput(File newfile2) {
		// TODO Auto-generated method stub
		return null;
	}
	private String readFromFile() {

	    String ret = "";

	    try {
	        InputStream inputStream = openFileInput(newfile);

	        if ( inputStream != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString);
	            }

	            inputStream.close();
	            ret = stringBuilder.toString();
	        }
	        else
	        {InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	    }
	        }
	    catch (FileNotFoundException e) {
	        Log.e("login activity", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("login activity", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	
	 
}