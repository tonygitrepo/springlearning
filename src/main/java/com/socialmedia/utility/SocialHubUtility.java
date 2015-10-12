package com.socialmedia.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.server.UID;
import java.util.Properties;

public class SocialHubUtility {

	String httpProxyHost;
	int httpProxyPort;
	String httpProxyUser;
	String httpProxyPassword;
	
	public String getHttpProxyHost() {
		return httpProxyHost;
	}

	public void setHttpProxyHost(String httpProxyHost) {
		this.httpProxyHost = httpProxyHost;
	}

	public int getHttpProxyPort() {
		return httpProxyPort;
	}

	public void setHttpProxyPort(int httpProxyPort) {
		this.httpProxyPort = httpProxyPort;
	}

	public String getHttpProxyUser() {
		return httpProxyUser;
	}

	public void setHttpProxyUser(String httpProxyUser) {
		this.httpProxyUser = httpProxyUser;
	}

	public String getHttpProxyPassword() {
		return httpProxyPassword;
	}

	public void setHttpProxyPassword(String httpProxyPassword) {
		this.httpProxyPassword = httpProxyPassword;
	}
	
	
public static class UIDGenerator{
	
	public static String nextUID(){
	     	return new UID().toString();
	    }
	}

	public  InputStream urlInputStream(String url){
		Properties prop = new Properties();
		InputStream input = null;
		InputStream urlInputStream = null;
		try {
			// Load Properties file
			input = getClass().getResourceAsStream("/twitter4j.properties");
			prop.load(input);
			setHttpProxyHost(prop.getProperty("twitter4j.http.proxyHost"));
			setHttpProxyPort(Integer.parseInt(prop.getProperty("twitter4j.http.proxyPort")));
			setHttpProxyUser(prop.getProperty("twitter4j.http.proxyUser"));
			setHttpProxyPassword(prop.getProperty("twitter4j.http.proxyPassword"));
			//Setting Proxy
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpProxyHost, httpProxyPort));
			Authenticator authenticator = new Authenticator() {

		        public PasswordAuthentication getPasswordAuthentication() {
		            return (new PasswordAuthentication(getHttpProxyUser(),
		                    getHttpProxyPassword().toCharArray()));
		        }
		    };
		    Authenticator.setDefault(authenticator);
		    // Setting URL with authenticated Proxy
			URLConnection conn=new URL(url).openConnection(proxy);
		    urlInputStream=conn.getInputStream();
		
	}catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		return urlInputStream;
	}

}
