package com.androidproject.netadmin.netadmin;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import junit.framework.Test;

/**
 * Created by appolinariya on 20.12.16.
 */


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private Button scan, save, get;
    private SwipeRefreshLayout refresh;
    private LinearLayout items;
    private TextView number, name, ip, state;
    private ProgressBar progress;
    public void testCreatedMenu() throws Exception {
        assertNotNull(mainActivity);
        assertNotNull(scan);
        assertNotNull(save);
        assertNotNull(get);
        assertNotNull(refresh);
        assertNotNull(progress);
        ViewAsserts.assertOnScreen(scan.getRootView(), scan);
        ViewAsserts.assertOnScreen(save.getRootView(), save);
        ViewAsserts.assertOnScreen(get.getRootView(), get);
        ViewAsserts.assertOnScreen(refresh.getRootView(), refresh);
    }

    public void testScan() throws Exception {
        TouchUtils.clickView(this, scan);

        //progress = mainActivity.findViewById(R.id.progress);
//        assertNotNull(progress);
    }

/*    public void testSave() throws Exception {

    }

    public void testGet() throws Exception {

    }
*/
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        scan = (Button) mainActivity.findViewById(R.id.scanButton);
        save = (Button) mainActivity.findViewById(R.id.saveButton);
        get = (Button) mainActivity.findViewById(R.id.getButton);
        refresh = (SwipeRefreshLayout) mainActivity.findViewById(R.id.refresh);
        items = (LinearLayout) mainActivity.findViewById(R.id.Items);
        number = (TextView) mainActivity.findViewById(R.id.Number);
        name = (TextView) mainActivity.findViewById(R.id.Name);
        ip = (TextView) mainActivity.findViewById(R.id.IP);
        state = (TextView) mainActivity.findViewById(R.id.State);
        progress = (ProgressBar) mainActivity.findViewById(R.id.progress);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
