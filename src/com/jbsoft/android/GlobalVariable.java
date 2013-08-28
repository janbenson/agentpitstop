/**
 * 
 */
package com.jbsoft.android;

import org.json.JSONObject;

/**
 * @author jan benson
 *
 */
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class GlobalVariable extends Application 
{
      String saveurl;
      String age;
      String nextTabActivity;
  	  String sex;
      String plan;
      String zip;
      String smoker;
      String startDate;
      JSONObject ratejson;
      /**
	 * @return the baduser
	 */
	public boolean isBaduser() {
		return baduser;
	}

	/**
	 * @param baduser the baduser to set
	 */
	public void setBaduser(boolean baduser) {
		this.baduser = baduser;
	}

	boolean baduser;
      /**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	String endDate;
      
      /**
	 * @return the nextTabActivity
	 */
	public String getNextTabActivity() {
		return nextTabActivity;
	}

	/**
	 * @param nextTabActivity the nextTabActivity to set
	 */
	public void setNextTabActivity(String nextTabActivity) {
		this.nextTabActivity = nextTabActivity;
	}

	/**
	 * @return the saveurl
	 */
	public String getSaveurl() {
		return saveurl;
	}

	/**
	 * @param saveurl the saveurl to set
	 */
	public void setSaveurl(String saveurl) {
		this.saveurl = saveurl;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * @param plan the plan to set
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the smoker
	 */
	public String getSmoker() {
		return smoker;
	}

	/**
	 * @param smoker the smoker to set
	 */
	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}



      public String getState()
      {
        return saveurl;
      }//End method

      public void setState(String s)
      {
    	  saveurl = s;
      }//End method

	/**
	 * @return the ratejson
	 */
	public JSONObject getRatejson() {
		return ratejson;
	}

	/**
	 * @param ratejson the ratejson to set
	 */
	public void setRatejson(JSONObject ratejson) {
		this.ratejson = ratejson;
	}
	//Check for Internet connectivity 
    public boolean isOnline(){
    	ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo netInfo = cm.getActiveNetworkInfo();
    	if (netInfo != null&& netInfo.isConnected()) {
    		return true;}
    	else {
    		return false;}
    		
    	}

    		
    	
    }
//End Class
