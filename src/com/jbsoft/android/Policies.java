package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.jbsoft.library.UserFunctions;
import com.jbsoft.library.JSONParser;

public class Policies  extends ListActivity{
	// Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    JSONParser jsonParser = new JSONParser();

 
   
 
    // products JSONArray
    JSONArray policylist = null;	
    ArrayList<HashMap<String, String>> policies_List = new ArrayList<HashMap<String, String>>(); 
    ArrayList<String> policy_list = new ArrayList<String>();
    // url to make request
    private static String loginpreloadURL = "http://api.agentpitstop.com/mobile/authenticate.php?action=login&username=Janet%20B%20Benson&password=jb54password";
    
    private static String policiespreloadURL = "http://api.agentpitstop.com/mobile/policies.php?action=status&start=2010-01-01&end=2013-12-31";
	// JSON Node names
	private static final String TAG_POLICIES = "policies";
	private static final String TAG_FIRST = "firstname";
	private static final String TAG_LAST = "lastname";
	private static final String TAG_PRODUCERID = "producerid";
	private static final String TAG_COMPANY = "company";
	private static final String TAG_PLAN = "plan";
	private static final String TAG_POLICYID = "policyid";
	private static final String TAG_POLICYNUMBER = "policynumber";
	private static final String TAG_STATUS = "status";
	private static final String TAG_SUBMITTED= "submitted";
	private static final String TAG_EFFECTIVE= "effective";
	private static final String TAG_ADDED= "added";
	private static final String TAG_CHANGED= "changed";
	private static final String TAG_TERMINATION= "termination";
	private static final String TAG_GUID= "guid";
	private static final String TAG_CLIENTID= "clientid";
	private static final String TAG_POLICYTYPE= "policytype";
	private static final String TAG_POLICYPRODUCER= "policyproducer";
	private static final String TAG_PRIMARYAGENT= "primaryagent";
		// contacts JSONArray
	JSONArray policies = null;
	
	 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_LEFT_ICON);
		        setContentView(R.layout.policies_list);
		        setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.vb1);
		        // Hashmap for ListView
		        //medsupp_List = new ArrayList<HashMap<String, String>>();	  
		   
		     // Loading INBOX in Background Thread
		        new LoadPolicies().execute();
		 }
		 /**
		     * Background Async Task to Load medicare supplement rates selected on rate engine and then ies
		     *  by making HTTP Request
		     * */
		    class LoadPolicies extends AsyncTask<String, String, String> {
		 
		        /**
		         * Before starting background thread Show Progress Dialog
		         * */
		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		            pDialog = new ProgressDialog(Policies.this);
		            pDialog.setMessage("Loading Submitted Policies");
		            pDialog.setIndeterminate(false);
		            pDialog.setCancelable(false);
		            pDialog.show();
		        }

				@Override
				/**
		         * getting Inbox JSON
		         * */
		        protected String doInBackground(String... args) {
		            // Building Parameters
		            List<NameValuePair> params = new ArrayList<NameValuePair>();
		            // Hashmap for ListView
				    
		            // getting JSON string from URL
		            
	                GlobalVariable apploginurl = ((GlobalVariable)getApplicationContext());
	                apploginurl.getState();
	                
	                
		            JSONObject json1 = jsonParser.getJSONFromUrl(apploginurl.saveurl, params);
		            JSONObject json2 =jsonParser.getafterloggedinJSONFromUrl(policiespreloadURL, params);
		 
		            // Check your log cat for JSON response  // Hashmap for ListView
				
		            Log.d("submitted policies JSON: ", json2.toString());
		 
		            try {
		                policies = json2.getJSONArray(TAG_POLICIES);
		                // looping through All messages
		                for (int i = 0; i < policies.length(); i++) {
		                    JSONObject c = policies.getJSONObject(i);
	
		                    // Storing each json item in variable
		                    String firstname = c.getString(TAG_FIRST);
		                    String last = c.getString(TAG_LAST);
		                    String producerid = c.getString(TAG_PRODUCERID);
		                    String company = c.getString(TAG_COMPANY);
		                    String plan = c.getString(TAG_PLAN);
		                    String policyid = c.getString(TAG_POLICYID);
		                    String policynumber = c.getString(TAG_POLICYNUMBER);
		                    String status = c.getString(TAG_STATUS);
		                    String submitted = c.getString(TAG_SUBMITTED);
		                    String effective = c.getString( TAG_EFFECTIVE);
		                    String added = c.getString(TAG_ADDED);
		                    String changed = c.getString(TAG_CHANGED);
		                    String termination = c.getString(TAG_TERMINATION);
		                    String guid = c.getString(TAG_GUID);
		                    String clientid = c.getString(TAG_CLIENTID);
		                    String policytype = c.getString(TAG_POLICYTYPE);
		                    String policyproducer = c.getString(TAG_POLICYPRODUCER);
		                    String primaryagent = c.getString( TAG_PRIMARYAGENT);
		                    // creating new HashMap
		                    HashMap<String, String> map = new HashMap<String, String>();
		 
		                    // adding each child node to HashMap key => value
		                    map.put(TAG_FIRST, firstname);
		                   
		                    map.put(TAG_LAST, last);
		                    map.put(TAG_COMPANY,company);
		                    map.put(TAG_PRODUCERID, producerid);
		                    map.put(TAG_PLAN, plan);
		                    map.put(TAG_POLICYID,policyid);
		                    map.put(TAG_POLICYNUMBER, policynumber);
		                    map.put(TAG_STATUS, status);
		                    map.put(TAG_SUBMITTED,submitted);
		                    map.put(TAG_EFFECTIVE, effective);
		                    map.put(TAG_ADDED, added);
		                    map.put(TAG_TERMINATION,termination);
		                    map.put(TAG_GUID, guid);
		                    map.put(TAG_CLIENTID, clientid);
		                    map.put(TAG_POLICYTYPE, policytype);
		                    map.put(TAG_PRIMARYAGENT, primaryagent);
		                    map.put(TAG_POLICYPRODUCER, policyproducer);
		  
		                    // adding HashList to ArrayList
		                    policies_List.add(map);
		                    
		                }
		 
	            } catch (JSONException e) {
		                e.printStackTrace();
		            }
		 
		            return null;
		        }
		 
		        /**
		         * After completing background task Dismiss the progress dialog
		         * **/
		        @Override
				protected void onPostExecute(String file_url) {
		            // dismiss the dialog after getting all products
		            pDialog.dismiss();
		            // updating UI from Background Thread
		            runOnUiThread(new Runnable() {
		                @Override
						public void run() {
		                    /**
		                     * Updating parsed JSON data into ListView
		                     * */
		                    ListAdapter adapter = new SimpleAdapter(
		                            Policies.this, policies_List,
		                            R.layout.policies_list_item, new String[] { TAG_FIRST, TAG_LAST, 
		                            		TAG_COMPANY},
		                            new int[] {R.id.first,R.id.last, R.id.company});
		                    // updating listview
		                    setListAdapter(adapter);
		                    
		                    // selecting single ListView item
			                ListView lv = getListView();
					         
			                // Launching new screen on Selecting Single ListItem
			                lv.setOnItemClickListener(new OnItemClickListener() {
			         
			                    @Override
			                    public void onItemClick(AdapterView<?> parent, View view,
			                            int position, long id) {
			                        // getting values from selected ListItem
			                        String first = ((TextView) view.findViewById(R.id.first)).getText().toString();
			                        String last = ((TextView) view.findViewById(R.id.last)).getText().toString();
			                        String company = ((TextView) view.findViewById(R.id.company)).getText().toString();
			                        String plan = policies_List.get(position).get(TAG_PLAN);
			                        // Starting new intent
			                        Intent in = new Intent(Policies.this, SingleMenuItemActivity.class);
			                        in.putExtra(TAG_FIRST, first);
			                        in.putExtra(TAG_LAST, last);
			                        in.putExtra(TAG_COMPANY, company);
			                        in.putExtra(TAG_PLAN, policies_List.get(position).get(TAG_PLAN));
			                        in.putExtra(TAG_SUBMITTED, policies_List.get(position).get(TAG_SUBMITTED));
			                        in.putExtra(TAG_STATUS, policies_List.get(position).get(TAG_STATUS));
			                        in.putExtra(TAG_EFFECTIVE, policies_List.get(position).get(TAG_EFFECTIVE));
			                        startActivity(in);
			                    }

								
			                });
		                    
		                }
		            }
                  );
		 
		        }
		
		    }
		    
		}
	
