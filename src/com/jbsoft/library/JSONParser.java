package com.jbsoft.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;
import com.jbsoft.library.Http;
 
import android.util.Log;
 
public class JSONParser {
 
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    // defaultHttpClient
    DefaultHttpClient httpClient = new DefaultHttpClient();
    // constructor
    
       public JSONObject getJSONFromUrl(String url, List<? extends NameValuePair> params) {
	        // Create a local instance of cookie store
    	   
	        CookieStore cookieStore = new BasicCookieStore();
	        HttpContext localContext = new BasicHttpContext();
	        // Bind custom cookie store to the local context
	        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
	        HttpClient client = Http.getHttpClient();
	      
	        // Making HTTP request
	        try {
	           HttpPost httpPost = new HttpPost(url);
	          // httpPost.setEntity(new UrlEncodedFormEntity(params));
	           HttpResponse httpResponse = client.execute(httpPost);
	           //HttpResponse httpResponse = Http.getThreadSafeClient().execute(httpPost);
	           HttpEntity httpEntity = httpResponse.getEntity();
	            is = httpEntity.getContent();
	            HttpGet httpget = new HttpGet(url); 
	
	            System.out.println("executing request " + httpget.getURI());
	
	            Http.getThreadSafeClient().execute(httpget, localContext);
	           // httpResponse.getEntity().consumeContent();
	            
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    is, "iso-8859-1"), 8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
	            is.close();
	            json = sb.toString();
	            Log.e("JSON", json);
	        } catch (Exception e) {
	            Log.e("Buffer Error", "Error converting result " + e.toString());
	        }
	 
	        // try parse the string to a JSON object
	        try {
	            jObj = new JSONObject(json);            
	        } catch (JSONException e) {
	            Log.e("JSON Parser", "Error parsing data " + e.toString());
	        }
	 
	        // return JSON String
	        
	        return jObj;
	 
	    }

       public JSONObject getafterloggedinJSONFromUrl(String url, List<? extends NameValuePair> params) {
    	   // Create a local instance of cookie store
	        CookieStore cookieStore = Http.cookieStore;
	        HttpContext localContext = Http.localContext;
	        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
	        HttpClient client = Http.getHttpClient();
	        		// Bind custom cookie store to the local context
	  
	       
	        try {  	
	         
	           HttpGet httpGet = new HttpGet(url);
	          // httpPost.setEntity(new UrlEncodedFormEntity(params));
	           HttpResponse httpResponse = client.execute(httpGet);
	          // HttpResponse httpResponse = client.execute(httpGet);
	          // HttpResponse httpResponse =client.execute(httpPost);
	          
	           HttpEntity httpEntity = httpResponse.getEntity();
	            is = httpEntity.getContent();
	            HttpGet httpget = new HttpGet(url); 
	
	            System.out.println("executing request " + httpget.getURI());
	
	            Http.getThreadSafeClient().execute(httpget, localContext);
	           // 
	 
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();;
	        }
	 
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    is, "iso-8859-1"), 8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	            	 sb.append(line + "\n");
	            	 Log.i("JSON",line);	 
	            }
	            is.close();
	            json = sb.toString();
	            Log.e("JSON", json);
	        } catch (Exception e) {
	            Log.e("Buffer Error", "Error converting result " + e.toString());
	        }
	 
	        // try parse the string to a JSON object
	        try {
	            jObj = new JSONObject(json);            
	        } catch (JSONException e) {
	            Log.e("JSON Parser", "Error parsing data " + e.toString());
	        }
	 
	        // return JSON String
	        return jObj;
	 
	    }



	public static void preParse(String url, HttpResponse response) {
		// TODO Auto-generated method stub
		
	}
}