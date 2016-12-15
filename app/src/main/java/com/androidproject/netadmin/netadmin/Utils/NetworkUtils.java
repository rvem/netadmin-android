package com.androidproject.netadmin.netadmin.Utils;

import android.util.Log;

import com.androidproject.netadmin.netadmin.model.Computer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Created by roman on 14.12.16.
 */

public final class NetworkUtils {
    public static boolean ping(String ip) {
        try {

            if (InetAddress.getByName(ip).isReachable(100)) {
                Log.d(TAG, ip + " Successful ping");
            } else {
                Log.d(TAG, ip + " Failed ping");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private NetworkUtils() {
    }

    private static final String TAG = "Check network state: ";
}
