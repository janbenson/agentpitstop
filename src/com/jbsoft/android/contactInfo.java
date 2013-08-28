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
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class contactInfo extends ListActivity {
	private String nameString,extentionString ,phoneString,toll_free,fax,email;

	String[] mContactNameArray;
	String[] mContactExtArray;
	String[] mContactPhoneArray;
	String[] mContactTollFreeArray;
	String[] mContactFaxArray;
	String[] mContactEmailArray;
		ArrayList<HashMap<String, String>> contact_List = new ArrayList<HashMap<String, String>>();
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";

	private static final String TAG_PHONE = "phone";
	private static final String TAG_TOLLFREE = "tollfree";
	private static final String TAG_FAX = "fax";
	private static final String TAG_EMAIL = "email";

	
	
	protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.contactslist);	
		    mContactNameArray = getResources().getStringArray(R.array.contactname);    
		    mContactPhoneArray = getResources().getStringArray(R.array.phone_list);  
		    mContactTollFreeArray = getResources().getStringArray(R.array.tollfree);
		    mContactFaxArray = getResources().getStringArray(R.array.fax);
		    mContactEmailArray = getResources().getStringArray(R.array.email);

		   
			List<Model> list = new ArrayList<Model>();
			for (int row = 0; row < 17; row++) {
				     String id = String.valueOf(row);
					 String name = mContactNameArray[row];
					 String toll_free = mContactTollFreeArray[row];
					 String fax = mContactFaxArray[row];
					 String phone = mContactPhoneArray[row];
					 String email = mContactEmailArray[row];
	                 // creating new HashMap
	                 HashMap<String, String> map = new HashMap<String, String>();
	
	                 // adding each child node to HashMap key => value
	                 map.put(TAG_ID,id);
	                 map.put(TAG_NAME, name);
	                 map.put(TAG_PHONE,phone);
	                 map.put(TAG_TOLLFREE, toll_free);
	                 map.put(TAG_FAX, fax);
	                 map.put(TAG_EMAIL,email);
	
	                 // adding HashList to ArrayList
	                 contact_List.add(map);
	                 
	        }
	
	
                        ListAdapter adapter = new SimpleAdapter(
                        contactInfo.this, contact_List,
                        R.layout.contact_list_item, new String[] {TAG_NAME},
                        new int[] { R.id.name});
	                  
	                    // updating listview
	                    setListAdapter(adapter);
	                    final ListView lv = getListView();

		                // Launching new screen on Selecting Single ListItem
		                lv.setOnItemClickListener(new OnItemClickListener() {
		                    @Override
		                    public void onItemClick(AdapterView<?> parent, View view,
		                            int position, long id) {
		                        // getting values from selected ListItem
		                        String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
		                        @SuppressWarnings("unused")
		                        // Starting new intent
		                        Intent in = new Intent(contactInfo.this, SingleMenuItemActivity_contacts.class);
		                        in.putExtra(TAG_NAME, name);
		                        in.putExtra(TAG_TOLLFREE, contact_List.get(position).get(TAG_TOLLFREE));
		                        in.putExtra(TAG_FAX, contact_List.get(position).get(TAG_FAX));
		                        in.putExtra(TAG_PHONE, contact_List.get(position).get(TAG_PHONE));
		                        in.putExtra(TAG_EMAIL, contact_List.get(position).get(TAG_EMAIL));
		                        startActivity(in);
		                    }
		                });	 
        
    
	 
}}
