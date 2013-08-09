package com.jbsoft.android;


import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


public class submissionfilter extends Activity{

	private static final String TAG_SELECT = "Selection";

	private static final int START_DATE_DIALOG_ID = 0;
	private static final int END_DATE_DIALOG_ID = 1;

	private DatePicker startDate,endDate;
	private String startdate,enddate;
	private Button btnSubmit;
	
	private TextView tvDisplayStartDate,tvDisplayEndDate;
	private String   StartDate_sav, EndDate_sav;
	private DatePicker dpStartResult,dpEndResult;
	private Button btnChangeStartDate,btnChangeEndDate;
 
	private int year;
	private int month;
	private int day;
 
	@Override
	  public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
			setContentView(R.layout.dateselections);
			startDate = (DatePicker) findViewById(R.id.dpStartResult);		
			endDate = (DatePicker) findViewById(R.id.dpEndResult);
			
			setCurrentDatesOnView();
			addListenerOnStartButton();
			addListenerOnEndButton();
		}
			
	// display current date
		public void setCurrentDatesOnView() {
			tvDisplayStartDate = (TextView) findViewById(R.id.tvStartDate);
			tvDisplayEndDate = (TextView) findViewById(R.id.tvEndDate);

			dpStartResult = (DatePicker) findViewById(R.id.dpStartResult);
			dpEndResult = (DatePicker) findViewById(R.id.dpEndResult);
	 
			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);
	 
			// set current date into textview
			tvDisplayStartDate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));
	 
			// set current date into datepicker
			dpStartResult.init(year, month, day, null);
			
			tvDisplayEndDate.setText(new StringBuilder()
			// Month is 0 based, just add 1
			.append(month + 1).append("-").append(day).append("-")
			.append(year).append(" "));
 
			// set current date into datepicker
			dpEndResult.init(year, month, day, null);
		}
			  public void addListenerOnStartButton() {
				 
				  btnChangeStartDate = (Button) findViewById(R.id.btnChangeStartDate);
				  btnChangeStartDate.setOnClickListener(new OnClickListener() {
			 
						@Override
						public void onClick(View v) {
			 
							showDialog(START_DATE_DIALOG_ID);
							
							
						}
			 
					});
		}
			  public void addListenerOnEndButton() {

				  btnChangeEndDate = (Button) findViewById(R.id.btnChangeEndDate);
				  btnChangeEndDate.setOnClickListener(new OnClickListener() {
			 
						@Override
						public void onClick(View v) {
			 
							showDialog(END_DATE_DIALOG_ID);
						 
						}
					});
					
			}
			  @Override
				protected Dialog onCreateDialog(int id) {
					switch (id) {
					case START_DATE_DIALOG_ID:
					   // set date picker as current date
					   return new DatePickerDialog(this, StartdatePickerListener, 
			                         year, month,day);
					case END_DATE_DIALOG_ID:
						   // set date picker as current date
						   return new DatePickerDialog(this, EnddatePickerListener, 
				                         year, month,day);   
					}
					return null;
				}
			 
				private DatePickerDialog.OnDateSetListener StartdatePickerListener 
			                = new DatePickerDialog.OnDateSetListener() {
			 
					// when dialog box is closed, below method will be called.
					public void onDateSet(DatePicker view, int selectedYear,
							int selectedMonth, int selectedDay) {
						year = selectedYear;
						month = selectedMonth;
						day = selectedDay;
			 
						// set selected date into textview
						tvDisplayStartDate.setText(new StringBuilder().append(month )
						   .append("-").append(day).append("-").append(year)
						   .append(" "));
						
						String month_string="", day_string="";

						if (selectedMonth < 1){
							month_string = "01" ;
						}
						else
						if (selectedMonth < 10){
							month_string = "0" + String.valueOf(selectedMonth);
						}
						else
						if (selectedMonth > 9){
							month_string =  String.valueOf(selectedMonth);
						}
						if (selectedDay < 1){
							day_string = "01" ;
						}
						else
						if (selectedDay < 10){
							day_string = "0" + String.valueOf(selectedDay);
						}
						else
						if (selectedDay > 9){
							day_string =  String.valueOf(selectedDay);
						}
						StartDate_sav = String.valueOf(year) + "-" + month_string + "-" + day_string;
						GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
						userparm.setStartDate(StartDate_sav);
						// set selected date into datepicker also
						dpStartResult.init(year, month, day, null);
			 
					}
				};
				private DatePickerDialog.OnDateSetListener EnddatePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
 
			// set selected date into textview
			tvDisplayEndDate.setText(new StringBuilder().append(month + 1)
			   .append("-").append(day).append("-").append(year)
			   .append(" "));
			String month_string="", day_string="";

			if (selectedMonth < 1){
				month_string = "01" ;
			}
			else
			if (selectedMonth < 10){
				month_string = "0" + String.valueOf(selectedMonth);
			}
			else
			if (selectedMonth > 9){
				month_string =  String.valueOf(selectedMonth);
			}
			if (selectedDay < 1){
				day_string = "01" ;
			}
			else
			if (selectedDay < 10){
				day_string = "0" + String.valueOf(selectedDay);
			}
			else
			if (selectedDay > 9){
				day_string =  String.valueOf(selectedDay);
			}
			EndDate_sav = String.valueOf(year) + "-" + month_string + "-" + day_string;
			GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
			userparm.setEndDate(EndDate_sav);
			// set selected date into datepicker also
			dpEndResult.init(year, month, day, null);
 
		}
	};
		}