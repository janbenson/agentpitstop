package com.jbsoft.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jbsoft.library.JSONParser;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class perscriptionDrugplan  extends ListActivity{
    JSONParser jsonParser = new JSONParser();
    ArrayList<HashMap<String, String>> pdp_List = new ArrayList<HashMap<String, String>>(); 
    ArrayList<HashMap<String, String>> pdpantage_List;	
	JSONArray pdp = null;

	private static final String TAG_PLAN = "plan";
	private static final String TAG_COMPANY = "company";
	private static final String TAG_LIS = "lis";
	private static final String TAG_PREMIUM = "premium";
	private static final String TAG_DRUGDEDUCTABLE = "drugdeductable";
	private static final String TAG_DRUGBENEFITTYPE = "drugbenefittype";
	private static final String TAG_RATING= "rating";
	private static final String TAG_GAPCOVERAGE = "gapcoverage";
	private static final String TAG_YEAR = "year";

		 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
	           
		        setContentView(R.layout.pdp_list);
		        // Hashmap for ListView
		        //medsupp_List = new ArrayList<HashMap<String, String>>();	  
		     // Hashmap for ListView
		      // Loading INBOX in Background Thread
		        

		            // Building Parameters
		          
					JSONObject ratejson = userparm.getRatejson();
					  userparm.setNextTabActivity("2");
		          
		            // Check your log cat for JSON reponse
		           //Log.d("medicareSupplements JSON: ", rate.toString());
		 
		            try {
		                pdp = ratejson.getJSONArray("pdprates");
		                // looping through All messages
		                for (int i = 0; i < pdp.length(); i++) {
		                    JSONObject c = pdp.getJSONObject(i);
		 
		                    // Storing each json item in variable
		                    String plan = c.getString(TAG_PLAN);
		                    String company = c.getString(TAG_COMPANY);
		                    String lis = c.getString(TAG_LIS);
		                    String premium = c.getString(TAG_PREMIUM);
		                    String drugdeductable = c.getString(TAG_DRUGDEDUCTABLE);
		                    String drugbenefittype = c.getString(TAG_DRUGBENEFITTYPE);
		                    String rating = c.getString(TAG_RATING);
		                    String gapcoverage = c.getString(TAG_GAPCOVERAGE);
		                    String year = c.getString(TAG_YEAR);
		                    // creating new HashMap
		                    
		                    HashMap<String, String> map = new HashMap<String, String>();
		 
		                    // adding each child node to HashMap key => value
		                    
		                    
		                    map.put(TAG_PLAN, plan);
		                    map.put(TAG_DRUGBENEFITTYPE,drugbenefittype);
		                    map.put(TAG_GAPCOVERAGE,gapcoverage);
		                    map.put(TAG_PREMIUM, premium);
		                    map.put(TAG_RATING,rating);
		                    map.put(TAG_LIS,lis);
		                    map.put(TAG_YEAR,year);
		                    
		                    
		                    // adding HashList to ArrayList
		                    pdp_List.add(map);
		                }
		 
	            } catch (JSONException e) {
		                e.printStackTrace();
		            }
		            
		            Collections.sort(pdp_List, new Comparator<HashMap<String, String>>() {
                	    public int compare(HashMap<String, String> mapping1,
                	                       HashMap<String, String> mapping2) {
                	        String valueOne = mapping1.get("premium");
                	        String valueTwo = mapping2.get("premium");
                	        try {
                	            return Integer.valueOf(valueOne).compareTo(Integer.valueOf(valueTwo));
                	        } catch(NumberFormatException e) {
                	            return valueOne.compareTo(valueTwo);
                	        }
                	    }
                	});	
				

	
		                    /**
		                     * Updating parsed JSON data into ListView
		                     * */
                                    ListAdapter adapter = new SimpleAdapter(
		                            perscriptionDrugplan.this, pdp_List,
		                            R.layout.pdp_list_item, new String[] { TAG_PLAN, TAG_DRUGBENEFITTYPE, TAG_DRUGDEDUCTABLE,TAG_GAPCOVERAGE,
		                            			TAG_PREMIUM,TAG_RATING,TAG_LIS,TAG_YEAR	},
		                            new int[] { R.id.plan, R.id.drugbenifittype, R.id.drugdeductable,R.id.gapcoverage,R.id.premium,R.id.rating,R.id.lis
		                            		,R.id.year});
		                  
		                    // updating listview
		                   setListAdapter(adapter);
		                   final ListView lv = getListView();
		 }                                            
}
		 
		                   
		                   
		 
		       
		                    
		            
             
		 
		 
		
		 
		    
	 
	
