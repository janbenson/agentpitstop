package com.jbsoft.library;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class Http {
	
		
		static HttpGet request;
		
		static HttpEntity entity;
		static HttpResponse response;
		static HttpPost post;
		static CookieStore cookieStore = new BasicCookieStore();
		static HttpContext localContext = new BasicHttpContext();
		static Object mLock = new Object();
		static CookieStore mCookie = null;
		/**
		 * Builds a new HttpClient with the same CookieStore than the previous one.
		 * This allows to follow the http session, without keeping in memory the
		 * full DefaultHttpClient.
		 * @author Régis Décamps <decamps@users.sf.net>
		 */
		
	
		@SuppressWarnings({ "unused", "null" })
		public static void setContext() throws ClientProtocolException, IOException
		{
			// Create a local instance of cookie store
		    CookieStore cookieStore = new BasicCookieStore();

		    // Create local HTTP context
		    HttpContext localContext = new BasicHttpContext();
		    // Bind custom cookie store to the local context
		    localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		    
		    HttpGet httpget = new HttpGet("http:/api.agentpitstop.com/mobile/"); 

		    System.out.println("executing request " + httpget.getURI());

		    AbstractHttpClient client = null;
			// Pass local context as a parameter
		    HttpResponse response = client.execute(httpget, localContext);
			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		}

		@SuppressWarnings("null")
		public static void getPage(String url) throws Exception
		{
		    request = new HttpGet(url);
		    AbstractHttpClient client = null;
			response = client.execute(request, localContext);
		    JSONParser.preParse(url, response);
		    
		}
		public static HttpClient getHttpClient() {
	        final DefaultHttpClient httpClient = new DefaultHttpClient();
	        synchronized (mLock) {
	                if (mCookie == null) {
	                        mCookie = httpClient.getCookieStore();
	                } else {
	                        httpClient.setCookieStore(mCookie);
	                }
	        }
	   
	        return httpClient;
	}
		@SuppressWarnings("null")
		public static HttpResponse postPage(List<NameValuePair> params, String host, String action) throws Exception {
		
		    post = new HttpPost(host + action);
		    post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		    AbstractHttpClient client = null;
		    response = client.execute(post, localContext);

		    entity = response.getEntity();
		    if(entity != null)
		    {
		        entity.consumeContent();
		    }

		    return response;
		}
		public static DefaultHttpClient getThreadSafeClient() {
		    DefaultHttpClient client = new DefaultHttpClient();
		    ClientConnectionManager mgr = client.getConnectionManager();
		    HttpParams params = client.getParams();

		    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, 
		            mgr.getSchemeRegistry()), params);

		    return client;
		}
		
		@SuppressWarnings("null")
		public void destoyHttp()
		{
			AbstractHttpClient client = null;
		    client.getConnectionManager().shutdown();
		}
		}