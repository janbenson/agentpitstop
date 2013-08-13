package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jbsoft.library.JSONParser;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
public class medicareAdvantage extends ListActivity{
    JSONParser jsonParser = new JSONParser();
    ArrayList<HashMap<String, String>> medadv_List = new ArrayList<HashMap<String, String>>(); 
    ArrayList<HashMap<String, String>> medadvantage_List;	
	JSONArray medadv = null;
	
	private static final String TAG_PLAN = "plan";
	private static final String TAG_COMPANY = "company";
	private static final String TAG_TYPE = "type";
	private static final String TAG_PREMIUM = "premium";
	private static final String TAG_DRUGDEDUCTABLE = "drugdeductable";
	private static final String TAG_DRUGBENEFITTYPE = "drugbenefittype";
	private static final String TAG_MOOP = "moop";
	private static final String TAG_RATING= "rating";
	private static final String TAG_GAPCOVERAGE = "gapcoverage";
	private static final String TAG_DRUGBENIFITDETAIL = "drugbenefitdetail";
	private static final String TAG_SNP = "snp";
	private static final String TAG_SNPDETAIL = "snp_details";
	private static final String TAG_COMPANIES= "companies";
	private static final String TAG_YEAR = "year";

		 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
	           
		        setContentView(R.layout.medadv_list);
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
		                medadv = ratejson.getJSONArray("marates");
		                // looping through All messages
		                for (int i = 0; i < medadv.length(); i++) {
		                    JSONObject c = medadv.getJSONObject(i);
		 
		                    // Storing each json item in variable
		                    String plan = c.getString(TAG_PLAN);
		                    String company = c.getString(TAG_COMPANY);
		                    String type = c.getString(TAG_TYPE);
		                    String premium = c.getString(TAG_PREMIUM);
		                    String drugdeductable = c.getString(TAG_DRUGDEDUCTABLE);
		                    String drugbenefittype = c.getString(TAG_DRUGBENEFITTYPE);
		                    String moop = c.getString(TAG_MOOP);
		                    String rating = c.getString(TAG_RATING);
		                    String gapcoverage = c.getString(TAG_GAPCOVERAGE);
		                    String drugbenefitdetail = c.getString(TAG_DRUGBENIFITDETAIL);
		                    String snp = c.getString(TAG_SNP);
		                    String snpdetail = c.getString(TAG_SNPDETAIL);
		                    String companies = c.getString(TAG_COMPANIES);
		                    String year = c.getString(TAG_YEAR);
		                    // creating new HashMap
		                    
		                    HashMap<String, String> map = new HashMap<String, String>();
		 
		                    // adding each child node to HashMap key => value
		                    
		                    
		                    map.put(TAG_PLAN, plan);
		                    map.put(TAG_DRUGBENEFITTYPE,drugbenefittype);
		                    map.put(TAG_GAPCOVERAGE,gapcoverage);
		                    map.put(TAG_PREMIUM, premium);
		                    map.put(TAG_RATING,rating);
		                    map.put(TAG_SNP, snp);
		                    map.put(TAG_YEAR,year);
		                    
		                    
		                    // adding HashList to ArrayList
		                    medadv_List.add(map);
		                }
		 
	            } catch (JSONException e) {
		                e.printStackTrace();
		            }
		        

				

	
		                    /**
		                     * Updating parsed JSON data into ListView
		                     * */
                                    ListAdapter adapter = new SimpleAdapter(
		                            medicareAdvantage.this, medadv_List,
		                            R.layout.medadv_list_item, new String[] { TAG_PLAN, TAG_DRUGBENEFITTYPE, TAG_DRUGDEDUCTABLE,TAG_GAPCOVERAGE,
		                            			TAG_PREMIUM,TAG_RATING,TAG_SNP,TAG_YEAR	},
		                            new int[] { R.id.plan, R.id.drugbenifittype, R.id.drugdeductable,R.id.gapcoverage,R.id.premium,R.id.rating,R.id.snp
		                            		,R.id.year});
		                  
		                    // updating listview
		                   setListAdapter(adapter);
		                   final ListView lv = getListView();
		 }                                            
}
		 
		                   
		                   
		 
		                   
		                   
		                    /*   ListView lv = getListView();
					         
			                // Launching new screen on Selecting Single ListItem
			                lv.setOnItemClickListener(new OnItemClickListener() {
			         
			                    @Override
			                    public void onItemClick(AdapterView<?> parent, View view,
			                            int position, long id) {
			                        // getting values from selected ListItem
			                        String company = ((TextView) view.findViewById(R.id.company)).getText().toString();
			                    	String plan = ((TextView) view.findViewById(R.id.plan)).getText().toString();
			                        String rate = ((TextView) view.findViewById(R.id.rate)).getText().toString();
			                        String payoption = ((TextView) view.findViewById(R.id.rate)).getText().toString();
		
			                        // Starting new intent
			                        Intent in = new Intent(medicareSupplements.this, SingleMenuItemActivityMedSupps.class);

			                        in.putExtra(TAG_COMPANY, company);
			                        in.putExtra(TAG_PLAN, medsupp_List.get(position).get(TAG_PLAN));
			                        in.putExtra(TAG_RATE, rate);
			                        in.putExtra(TAG_PAYOPTION, payoption);
			                        startActivity(in);
			                    }


								
			                });*/
		                    
		            
             
		 
		 
		
		 
		    
	 
	
