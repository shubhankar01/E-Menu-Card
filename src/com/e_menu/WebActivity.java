package com.e_menu;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity
{
	WebView browser;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		browser = (WebView) findViewById(R.id.wvBrowser);
		browser.loadUrl("http://airtelmoney.in/wps/wcm/connect/airtelmoney/airtelmoney/home");
	}

}
