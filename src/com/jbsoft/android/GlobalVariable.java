/**
 * 
 */
package com.jbsoft.android;

/**
 * @author jan benson
 *
 */
import android.app.Application;

public class GlobalVariable extends Application 
{
      String saveurl;
      String age;
      String nextTabActivity;
  	  String sex;
      String plan;
      String zip;
      String smoker;
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
}//End Class
