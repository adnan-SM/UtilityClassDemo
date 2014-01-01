UtilityClassDemo
================

This is a simple Utility class conatining static methods to check the availability of various system services in Android.

<b>Usage :</b>

Just copy the <b>Utility.java</b> in your project and call the appropriate static methods.


Some Examples :

    boolean isGPSEnabled =  Utility.isGPSEnabled(getApplicationContext());
    boolean isWifiEnabled = Utility.isWifiEnabled(getApplicationContext());
    boolean isNFCEnabled =  Utility.isNFCEnabled(getApplicationContext());


I am not a great fan of libraries, so if you feel you don't need something feel free to modify the methods in Utility.java


Each method has a short description of what it does and which permission it requires. This should help you to decide which permissions to include in your Manifest


==========================================================================================================================
