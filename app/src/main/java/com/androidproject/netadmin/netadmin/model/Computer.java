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

    public Computer(int id, String ip, String name) {
        this(id, ip, name, State.OFFLINE);
    }

    public Computer(int id, String ip, String name, State state) {
        this.id = id;
        this.ip = ip;
        this.name = name;
        this.state = state;
    }

    public String getIP() {
        return ip;
    }

    public String getName() {
        return name;
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
