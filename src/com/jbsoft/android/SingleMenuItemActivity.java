package com.jbsoft.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.setContentView(R.layout.policies_list_item_detail);

	    TextView txtProduct = (TextView) findViewById(R.id.company);

	    Intent i = getIntent();
	    // getting attached intent data
	    String product = i.getStringExtra("number");
	    CharSequence number = null;
		// displaying selected product name
	    txtProduct.setText(number);

	}
}
