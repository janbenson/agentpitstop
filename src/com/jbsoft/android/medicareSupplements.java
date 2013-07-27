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
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;;
public class medicareSupplements extends ListActivity{
	// Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    JSONParser jsonParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> medsupp_List;
 
    // products JSONArray
    JSONArray medsupps = null;	 
    // url to make request
    private static String loginpreloadURL = "http://api.agentpitstop.com/mobile/authenticate.php?action=login&username=Janet%20B%20Benson&password=jb54password";
    
    private static String RATES_URL = "http://api.agentpitstop.com/mobile/rates.php?action=rates&age=76&zip=94561&sex=male&plan=F";

	// JSON Node names
	private static final String TAG_ID = "id";
	private static final String TAG_COMPANY = "company";
	private static final String TAG_PLAN = "plan";
	private static final String TAG_PAYOPTION = "payoption";
	private static final String TAG_STATE = "state";
	private static final String TAG_SEX = "sex";
	private static final String TAG_AGE = "age";
	private static final String TAG_SMOKER = "tobacco";
	private static final String TAG_RATE = "rate";
	private static final String TAG_DATE= "date";
	
	// contacts JSONArray
	JSONArray rates = null;

		 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.medsupp_list);
		        // Hashmap for ListView
		        //medsupp_List = new ArrayList<HashMap<String, String>>();	  
		     // Hashmap for ListView
		       ArrayList<HashMap<String, String>> medsupp_List = new ArrayList<HashMap<String, String>>();
		     // Loading INBOX in Background Thread
		        new Loadmedicaresupps().execute();
		 }
		 /**
		     * Background Async Task to Load medicare supplement rates selected on rate engine and then 
		     *  by making HTTP Request
		     * */
		    class Loadmedicaresupps extends AsyncTask<String, String, String> {
		 
		        /**
		         * Before starting background thread Show Progress Dialog
		         * */
		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		            pDialog = new ProgressDialog(medicareSupplements.this);
		            pDialog.setMessage("Loading Medicare Supplement Rates ...");
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
		             
		            // getting JSON string from URL
		            JSONObject json1 = jsonParser.getJSONFromUrl(loginpreloadURL, params);
		            JSONObject json2 =jsonParser.getafterloggedinJSONFromUrl(RATES_URL, params);
		 
		            // Check your log cat for JSON reponse
		            Log.d("medicareSupplements JSON: ", json2.toString());
		 
		            try {
		                medsupps = json2.getJSONArray("id");
		                // looping through All messages
		                for (int i = 0; i < medsupps.length(); i++) {
		                    JSONObject c = medsupps.getJSONObject(i);
		 
		                    // Storing each json item in variable
		                    String id = c.getString(TAG_ID);
		                    String company = c.getString(TAG_COMPANY);
		                    String rate = c.getString(TAG_RATE);
		                    String plan = c.getString(TAG_PLAN);
		                    String age = c.getString(TAG_AGE);
		                    String sex = c.getString(TAG_SEX);
		                    String tobacco = c.getString(TAG_SMOKER);
		                    String state = c.getString(TAG_STATE);
		                    String payoption = c.getString(TAG_PAYOPTION);
		                    String date = c.getString(TAG_DATE);
		 
		                    // creating new HashMap
		                    HashMap<String, String> map = new HashMap<String, String>();
		 
		                    // adding each child node to HashMap key => value
		                    map.put(TAG_ID, id);
		                    map.put(TAG_COMPANY,company);
		                    map.put(TAG_PLAN, plan);
		                    map.put(TAG_RATE,rate);
		                    map.put(TAG_PAYOPTION ,payoption);

		 
		                    // adding HashList to ArrayList
		                    medsupp_List.add(map);
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
		                            medicareSupplements.this, medsupp_List,
		                            R.layout.medsupp_list_item, new String[] { TAG_COMPANY, TAG_PLAN, TAG_RATE,TAG_PAYOPTION},
		                            new int[] { R.id.company, R.id.plan, R.id.rate,R.id.payoption });
		                    // updating listview
		                    setListAdapter(adapter);
		                }
		            });
		 
		        }
		 
		    }
		}