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

      public String getState()
      {
        return saveurl;
      }//End method

      public void setState(String s)
      {
    	  saveurl = s;
      }//End method
}//End Class
