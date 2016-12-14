package com.androidproject.netadmin.netadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidproject.netadmin.netadmin.model.Computer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_FILTER = "NETWORK_STATE_CHANGED";

    public static final String FILENAME = "config.cfg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScanClick(View view) {
    }

    public void onGetClick(View view) {
    }
}
