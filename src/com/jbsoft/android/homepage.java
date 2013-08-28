package com.jbsoft.android;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class homepage extends Activity{
	private WebView webView;

	 @Override
		public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		 }
	 
	 
	 public void onResume(Bundle savedInstanceState){
		 super.onResume();
		 setContentView(R.layout.homepage);
			GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
			String tab_bank =  userparm.getNextTabActivity();
			  userparm.setNextTabActivity("2");
			  
	 }
	 @Override
	    protected void onStart() {
	     super.onStart();
	   	 setContentView(R.layout.homepage);
	   	 GlobalVariable userparm = ((GlobalVariable)getApplicationContext());
	   	 String tab_bank =  userparm.getNextTabActivity();
		 userparm.setNextTabActivity("2");
		 
		 webView = (WebView) findViewById(R.id.webkit);
         webView.setWebViewClient(new myWebViewClient());
		 webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setUseWideViewPort(true);
		 webView.setInitialScale(1);
		 webView.loadUrl("http://agentpitstop.com");
			
		 }
	 public class myWebViewClient extends WebViewClient
	 {
		 @Override 
		 public void onPageStarted(WebView webView,String Url,Bitmap favicon){
			 super.onPageStarted(webView,Url,favicon);
		 }
		 
		 public boolean shouldOverrideUrlLoading(WebView webView,String url) {
			 webView.loadUrl(url);
		     return true;
		 }
	 }
		 public boolean onKeyDown(int keyCode,KeyEvent event){
			 if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
				 webView.goBack();
			     return true;
		 }
		 return super.onKeyDown(keyCode,event);
		 }
	 }

