package com.androidproject.netadmin.netadmin.Utils;

import android.util.Log;

import com.androidproject.netadmin.netadmin.model.Computer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by roman on 14.12.16.
 */

public final class NetworkUtils {
    public static boolean ping(String ip) {
        try {
            Process p = Runtime.getRuntime().exec("ping " + ip);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            if (inputStream.readLine() != null) {
                Log.d(TAG, ip + " Successful ping");
                inputStream.close();
                return true;
            } else {
                Log.d(TAG, ip + " Failed ping");
                inputStream.close();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Computer> scanLocalNetwork() {
        String basicIP = "192.168.0.";
        ArrayList<Computer> devices = new ArrayList<>();
        int num = 1;
        for (int i = 1; i < 255; i++) {
            String currIP = basicIP + Integer.toString(i);
            if (ping(currIP)) {
                devices.add(new Computer(num++, currIP, State.ONLINE));
            }
        }
        return devices;
    }

    private NetworkUtils(){}
    private static final String TAG = "Check network state: ";
}
