package com.androidproject.netadmin.netadmin.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.androidproject.netadmin.netadmin.MainActivity;
import com.androidproject.netadmin.netadmin.Utils.NetworkUtils;
import com.androidproject.netadmin.netadmin.Utils.State;
import com.androidproject.netadmin.netadmin.model.Computer;

import java.util.ArrayList;

/**
 * Created by roman on 14.12.16.
 */

public class CheckNetworkStateService extends Service {
    ArrayList<Computer> computers;

    public CheckNetworkStateService() {}

    public CheckNetworkStateService(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new CheckNetworkState()).start();
        return START_STICKY;
    }

    public class CheckNetworkState implements Runnable{

        @Override
        public void run() {
            for (Computer c : computers){
                c.setState(NetworkUtils.ping(c.getIP()) ? State.ONLINE : State.OFFLINE);
                sendBroadcast(new Intent(MainActivity.INTENT_FILTER));
            }
        }
    }

}
