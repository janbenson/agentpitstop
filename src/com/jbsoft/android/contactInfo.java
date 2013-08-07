package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.jbsoft.library.Model;


import android.app.Activity;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class contactInfo extends ListActivity {
	private String nameString,extentionString ,phoneString;

	String[] mContactNameArray;
	String[] mContactExtArray;
	String[] mContactPhoneArray;
		ArrayList<HashMap<String, String>> contact_List = new ArrayList<HashMap<String, String>>();
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_EXT = "extention";
	private static final String TAG_PHONE = "phone";
	 
	
	protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.contactslist);	
		    mContactNameArray = getResources().getStringArray(R.array.contactname);    
		    mContactExtArray = getResources().getStringArray(R.array.ext_list);    
		    mContactPhoneArray = getResources().getStringArray(R.array.phone_list);    

		   
			List<Model> list = new ArrayList<Model>();
			for (int row = 0; row < 15; row++) {
				     String id = String.valueOf(row);
					 String name = mContactNameArray[row];
					 String extention = mContactExtArray[row];
					 String phone = mContactPhoneArray[row];
	                 // creating new HashMap
	                 HashMap<String, String> map = new HashMap<String, String>();
	
	                 // adding each child node to HashMap key => value
	                 map.put(TAG_ID,id);
	                 map.put(TAG_NAME, name);
	                 map.put(TAG_EXT, extention);
	                 map.put(TAG_PHONE,phone);
	
	                 // adding HashList to ArrayList
	                 contact_List.add(map);
	                 
	        }
	
	
                        ListAdapter adapter = new SimpleAdapter(
                        contactInfo.this, contact_List,
                        R.layout.contact_list_item, new String[] {TAG_NAME, TAG_EXT, TAG_PHONE},
                        new int[] { R.id.name, R.id.ext, R.id.phonenum });
	                  
	                    // updating listview
	                    setListAdapter(adapter);
	                    final ListView lv = getListView();

		                // Launching new screen on Selecting Single ListItem
		                lv.setOnItemClickListener(new OnItemClickListener() {
		                    @Override
		                    public void onItemClick(AdapterView<?> parent, View view,
		                            int position, long id) {
		                        // getting values from selected ListItem
		                    	TextView v=(TextView) view.findViewById(R.id.phonenum);
		                    	String string = (String) v.getText();
		                    	String number = "tel:" + string;
		                    	Intent dialer = new Intent(Intent.ACTION_CALL,Uri.parse(number));
		                    	startActivity(dialer);
		                    }                    
		                });	 
        
    
	 
}}
