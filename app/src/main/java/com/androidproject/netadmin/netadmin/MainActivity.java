package com.androidproject.netadmin.netadmin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidproject.netadmin.netadmin.Utils.ConfigUtils;
import com.androidproject.netadmin.netadmin.model.Computer;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;

import static com.androidproject.netadmin.netadmin.Utils.NetworkUtils.ping;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_FILTER = "NETWORK_STATE_CHANGED";

    public static final String FILENAME = "config.cfg";

    public ArrayList<Computer> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        devices = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScanClick(View view) {
        class Scan implements Runnable {

            private Scan(){};

            @Override
            public void run() {
                String basicIP = "192.168.0.";
                ArrayList<Computer> scannedDevices = new ArrayList<>();
                int num = 1;
                for (int i = 1; i < 256; i++) {
                    if (ping(basicIP + Integer.toString(i))) {
                        scannedDevices.add(new Computer(num, basicIP + Integer.toString(i), "basic name"));
                    }
                }
                devices = scannedDevices;
            }
        }
        final String TAG = "On scan click ";
        new Thread(new Scan()).start();
    }

    public void onGetClick(View view) {
        final String TAG = "On get click ";
        File configFile = new File(getFilesDir(), FILENAME);
        if (configFile.exists()) {
            devices = ConfigUtils.getConfig(configFile);
        } else {
            Log.d(TAG, "Config file not found");
            String text = "Config file not found";
            int duration = Toast.LENGTH_SHORT;
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void onSaveClick(View view) {
        final String TAG = "On save click ";
        File configFile = new File(getFilesDir(), FILENAME);
        if (devices.isEmpty()) {
            Log.d(TAG, "Nothing to save");
            String text = "Nothing to save";
            int duration = Toast.LENGTH_SHORT;
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}