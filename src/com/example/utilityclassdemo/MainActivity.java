package com.example.utilityclassdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    StrictMode.ThreadPolicy policy = 
	    	    new StrictMode.ThreadPolicy.Builder().permitAll().build();      
	    	        StrictMode.setThreadPolicy(policy);
	    	        
		boolean isInternetConnected = Utility.hasActiveInternetConnection(getApplicationContext());
		boolean isGPSEnabled = Utility.isGPSEnabled(getApplicationContext());
		boolean isWifiEnabled = Utility.isWifiEnabled(getApplicationContext());
		boolean isBluetoothEnabled = Utility.isBluetoothEnabled(getApplicationContext());
		boolean isNFCEnabled = Utility.isNFCEnabled(getApplicationContext());
		Toast.makeText(getApplicationContext(), "Internet:"+isNFCEnabled, 500).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
