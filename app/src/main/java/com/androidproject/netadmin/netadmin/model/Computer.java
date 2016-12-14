package com.androidproject.netadmin.netadmin.model;

import com.androidproject.netadmin.netadmin.Utils.State;

import java.net.InetAddress;

/**
 * Created by roman on 30.11.16.
 */

public class Computer {
    private int id;
    private String ip;
    private String name;
    private State state;

    public Computer(int id, String ip) {
        this(id, ip, State.OFFLINE);
    }

    public Computer(int id, String ip, State state) {
        this.id = id;
        this.ip = ip;
        this.state = state;
    }

    public String getIP() {
        return ip;
    }

    public int getId() {
        return id;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}
