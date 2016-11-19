package com.AhmedOpeyemiEhealthnigeriaOrg.EhaBeaconNotifier826;

import android.app.Application;

import com.AhmedOpeyemiEhealthnigeriaOrg.EhaBeaconNotifier826.estimote.BeaconID;
import com.AhmedOpeyemiEhealthnigeriaOrg.EhaBeaconNotifier826.estimote.BeaconNotificationsManager;
import com.estimote.sdk.EstimoteSDK;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MyApplication extends Application {

    private boolean beaconNotificationsEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        EstimoteSDK.initialize(getApplicationContext(), "eha-beacon-notifier-826", "255bc803bbf5232af822559b00aba5f6");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) { return; }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 36986, 39975),
                "Hello, world.",
                "Goodbye, world.");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }
}
