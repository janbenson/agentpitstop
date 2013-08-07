package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jbsoft.library.JSONParser;
import com.jbsoft.library.UserFunctions;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter; 
public class medicareSupplements extends ListActivity{
	// Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    JSONParser jsonParser = new JSONParser();
    UserFunctions uf = new UserFunctions();
    ArrayList<HashMap<String, String>> medsupps_List = new ArrayList<HashMap<String, String>>(); 
    ArrayList<HashMap<String, String>> medsupp_List;
 
    // products JSONArray
    JSONArray medsupps = null;	 
    // url to make request
    
    
    private static String RATES_URL = "http://api.agentpitstop.com/mobile/rates.php";
    
	// JSON Node names
	private static final String TAG_ID = "id";
	private static final String TAG_COMPANY = "company";
	private static final String TAG_PLAN = "plan";
	private static final String TAG_PAYOPTION = "payoption";
	private static final String TAG_ZIP = "zip";
	private static final String TAG_COUNTY = "county";
	private static final String TAG_STATE = "state";
	private static final String TAG_SEX = "sex";
	private static final String TAG_AGE = "age";
	private static final String TAG_PARTB = "partb";
	private static final String TAG_SMOKER = "smoker";
	private static final String TAG_RATE = "rate";
	private static final String TAG_DATE= "date";
	private static final String TAG_RECRUIT= "recruit";
		
	// contacts JSONArray
	JSONArray rates = null;
	String Sex = null;
	String Age = null;
	String Zip = null;
	String Smoker = null;
	String Plan = null;
		 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
	            Sex = userparm.getSex(); 
		    	if (Sex == null){ Sex = "male";};
		        Age = userparm.getAge();
		        if (Age.length() == 0){ 
		        	Age = "65";
		            userparm.setAge(Age);
		        };
		        Zip= userparm.getZip();
		        if (Zip.length() == 0){ 
		        	Zip = "94518";
		        	userparm.setZip(Zip);
		        	};
		        Smoker= userparm.getSmoker();
		        if (Smoker == null){ Smoker = "Non-Smoker";};
		        
		        
		        String parmaction = "?action=rates";
	            String parmage = "&age=";
	            parmage = parmage + Age;
	            String parmzip = "&zip=";
	            parmzip = parmzip + Zip;
	            String parmsex = "&sex=";
	            parmsex = parmsex + Sex;
	            String parmplan = "&plan=";
	            parmplan = parmplan + "F";
	            String parmsmoker = "&tobacco=";
	            parmsmoker = parmsmoker + Smoker;
	          
	            RATES_URL = RATES_URL + parmaction + parmage + parmzip + parmsex + parmplan + parmsmoker;
		        
		        
		        
		        
		        setContentView(R.layout.medsupp_list);
		        // Hashmap for ListView
		        //medsupp_List = new ArrayList<HashMap<String, String>>();	  
		     // Hashmap for ListView
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
		            GlobalVariable apploginurl = ((GlobalVariable)getApplicationContext());
	                apploginurl.getState();
	                Age = apploginurl.getAge();
	                Sex = apploginurl.getSex();
	                Zip = apploginurl.getZip();
	                //Plan = apploginurl.getPlan();
	                Plan = "F";
	                Smoker = apploginurl.getSmoker();
		            // getting JSON string from URL
		            @SuppressWarnings("unused")
					JSONObject json1 = jsonParser.getJSONFromUrl(apploginurl.saveurl, params);
		            
		            JSONObject json2 =uf.getRates(Age, Zip, Sex, Plan, Smoker);
		             String temp;
		 
		            // Check your log cat for JSON reponse
		            Log.d("medicareSupplements JSON: ", json2.toString());
		 
		            try {
		                medsupps = json2.getJSONArray("rates");
		                // looping through All messages
		                for (int i = 0; i < medsupps.length(); i++) {
		                    JSONObject c = medsupps.getJSONObject(i);
		 
		                    // Storing each json item in variable
		                    String id = c.getString(TAG_ID);
		                    String company = c.getString(TAG_COMPANY);
		                    String plan = c.getString(TAG_PLAN);
		                    String payoption = c.getString(TAG_PAYOPTION);
		                    String zip = c.getString(TAG_ZIP);
		                    temp = zip.replaceAll("", "all");
		                    zip = temp;
		                    temp="";
		                    String county = c.getString(TAG_COUNTY);
		                    temp = county.replaceAll("", "all");
		                    county = temp;
		                    temp="";
		                    String sex = c.getString(TAG_SEX);
		                    temp = sex.replaceAll("", "none");
		                    sex = temp;
		                    temp="";
		                    String age = c.getString(TAG_AGE);
		                    temp = age.replaceAll("", "none");
		                    age = temp;
		                    temp="";
		                    String partb = c.getString(TAG_PARTB);
		                    temp = partb.replaceAll("", "none");
		                    partb = temp;
		                    temp="";
		                    String smoker = c.getString(TAG_SMOKER);
		                    temp = smoker.replaceAll("", "none");
		                    smoker = temp;
		                    temp="";
		                    String rate = c.getString(TAG_RATE);
		                    String date = c.getString(TAG_DATE);
		                    String recruit = c.getString(TAG_RECRUIT);
		                    temp = recruit.replaceAll("", "none");
		                    recruit = temp;
		                    temp="";
		                    // creating new HashMap
		                    HashMap<String, String> map = new HashMap<String, String>();
		 
		                    // adding each child node to HashMap key => value
		                    map.put(TAG_ID,id);
		                    map.put(TAG_COMPANY,company);
		                    map.put(TAG_PLAN, plan);
		                    map.put(TAG_PAYOPTION ,payoption);
		                    map.put(TAG_ZIP,zip);
		                    map.put(TAG_COUNTY, county);
		                    map.put(TAG_STATE ,payoption);
		                    map.put(TAG_SEX,company);
		                    map.put(TAG_AGE, age);
		                    map.put(TAG_PARTB ,partb);
		                    map.put(TAG_SMOKER,smoker);
		                    map.put(TAG_RATE,rate);
		                    map.put(TAG_DATE, date);
		                    map.put(TAG_RECRUIT ,recruit);
		                    
		                    // adding HashList to ArrayList
		                    medsupps_List.add(map);
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
		                            medicareSupplements.this, medsupps_List,
		                            R.layout.medsupp_list_item, new String[] { TAG_COMPANY, TAG_PLAN, TAG_RATE,TAG_PAYOPTION},
		                            new int[] { R.id.company, R.id.plan, R.id.rate,R.id.payoption });
		                  
		                    // updating listview
		                    setListAdapter(adapter);
		                    
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
		                    
		                }
		            }
                  );
		 
		        }
		
		    }
		    
		}
	
