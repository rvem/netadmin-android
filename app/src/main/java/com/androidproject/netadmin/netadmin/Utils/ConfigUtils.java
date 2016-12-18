package com.androidproject.netadmin.netadmin.Utils;

import android.util.Log;

import com.androidproject.netadmin.netadmin.model.Color;
import com.androidproject.netadmin.netadmin.model.Computer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by roman on 14.12.16.
 *
 * Changed by Anna Kopeliovich on 18.12.16.
 */

public final class ConfigUtils {
    public static ArrayList<Computer> getConfig(File file) {
        ArrayList<Computer> devices = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split(" ");
                devices.add(new Computer(Integer.parseInt(args[0]), args[1], args[2], Color.GOOD));
            }
        } catch (Exception e) {
            Log.e(TAG, "catch exception", e);
        }
        return devices;
    }

    public static void setConfig(ArrayList<Computer> devices, File file) {
        try {
            FileWriter writer = new FileWriter(file);
            for (Computer device : devices) {
                String info = Integer.toString(device.getId()) + " " + device.getIP() + '\n';
                writer.write(info);
            }
        } catch (Exception e) {
            Log.e(TAG, "catch exception", e);
        }
    }

    private ConfigUtils(){}
    private static final String TAG = "File :";
}
