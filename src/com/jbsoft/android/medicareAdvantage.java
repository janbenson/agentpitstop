package com.jbsoft.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class medicareAdvantage extends Activity{

		 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);

		        TextView textview = new TextView(this);
		        textview.setText("This is where the future medicare advantage report will display ");
		        setContentView(textview);
		    }
		}
