package com.androidproject.netadmin.netadmin.model;

import com.androidproject.netadmin.netadmin.Utils.State;

import java.net.InetAddress;

/**
 * Created by roman on 30.11.16.
 */

public class Computer {
    private int id;
    private String ip;
    private State state;
    public Computer(int id, String ip) {
        this.id = id;
        this.ip = ip;
        this.state = State.OFFLINE;
    }
    public String getIP() {
        return ip;
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return this.state;
    }
}
