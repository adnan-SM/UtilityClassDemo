package com.example.utilityclassdemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.util.Log;

public class Utility {



public static String ERROR_LOG_TAG = "Error";
public static String TEST_URL ="http://www.google.com";

	/**
	* Check if user has Internet Connection available
	* Permissions : android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE
	*/
	public static boolean hasActiveInternetConnection(Context context)
	{
		if (isNetworkConnected(context))
		{
			try
			{
				HttpURLConnection urlConnection = (HttpURLConnection) (new URL(TEST_URL).openConnection());
				urlConnection.setRequestProperty("User-Agent", "Test");
				urlConnection.setRequestProperty("Connection", "close");
				urlConnection.setConnectTimeout(1000);
				urlConnection.connect();
				return (urlConnection.getResponseCode() == 200);
			}
			catch (IOException e)
			{
				Log.e(ERROR_LOG_TAG, "Error checking internet connection", e);
			}
		}
		else
		{
			Log.d("LOG_TAG", "No network available!");
		}

		return false;
	}

	/**
	* Check if user is connected to a Wifi/Mobile Network
	* Permissions : android.permission.ACCESS_NETWORK_STATE
	*/	
	public static boolean isNetworkConnected(Context context)
	{
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null)
		{
			return false;
		}
		else
			return true;
	}

	/**
	* Check if Wifi is enabled
	* Permissions : android.permission.ACCESS_WIFI_STATE
	*/	
	public static boolean isWifiEnabled(Context context)
	{
		WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

		return wm.isWifiEnabled();
	}


	/**
	* Enable/Disable Wifi
	* Permissions : android.permission.ACCESS_WIFI_STATE, android.permission.UPDATE_DEVICE_STATS, android.permission.CHANGE_WIFI_STATE
	*/	
	public static void toggleWifi(Context context, boolean state)
	{
		WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if(state)
		{
			wm.setWifiEnabled(true);
		}
		else
		{
			wm.setWifiEnabled(false);
		}
	}

	/**
	* Check if GPS is enabled
	* Permissions : android.permission.ACCESS_FINE_LOCATION
	*/	
	public static boolean isGPSEnabled(Context context)
	{
		LocationManager locManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);;
    	return (locManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
	}


	/**
	* Check if Bluetooth is enabled
	* Permissions : android.permission.BLUETOOTH
	*/
	public static boolean isBluetoothEnabled(Context context)
	{
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if(bluetoothAdapter == null)
		{
			Log.e(ERROR_LOG_TAG, "No Bluetooth device found !");
			return false;
		}
		else
		{
			return (bluetoothAdapter.isEnabled());
		}
	}


	/**
	* Check if NFC is enabled
	* Permissions : android.permission.NFC
	*/
	public static boolean isNFCEnabled(Context context)
	{
		NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(context);
		if(nfcAdapter == null)
		{
			Log.e(ERROR_LOG_TAG, "No NFC found !");
			return false;
		}
		else
		{
			return (nfcAdapter.isEnabled());
		}
	}


}
