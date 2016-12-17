package com.androidproject.netadmin.netadmin.model;

import com.androidproject.netadmin.netadmin.Utils.State;

import java.net.InetAddress;

/**
 * Created by roman on 30.11.16.
 * Changed by Anna Kopeliovich 18.12.16.
 */

public class Computer {
    private int id;
    private String ip;
    private String name;
    private State state;
    private Color color;


    public Computer(int id, String ip, String name, Color color) {
        this(id, ip, name, State.OFFLINE, color);
    }

    public Computer(int id, String ip, String name) {
        this(id, ip, name, State.OFFLINE, Color.BAD);
    }

    public Computer(int id, String ip, String name, State state, Color color) {
        this.id = id;
        this.ip = ip;
        this.name = name;
        this.state = state;
        this.color = color;
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
        this.color = (state == State.ONLINE) ? Color.GOOD : Color.BAD;
    }

    public State getState() {
        return this.state;
    }

}
