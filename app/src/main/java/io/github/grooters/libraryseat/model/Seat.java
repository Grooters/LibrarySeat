package io.github.grooters.libraryseat.model;

import org.litepal.crud.LitePalSupport;

public class Seat extends LitePalSupport{
    private int id,floor,number,idle;
    private String user_number;
    private int starttime,time;


    public Seat(int id, int floor, int number, int idle, int time, String user_number, int startTime) {
        this.id = id;
        this.floor = floor;
        this.number = number;
        this.idle = idle;
        this.time = time;
        this.user_number = user_number;
        this.starttime = startTime;
    }

    public int getTime() {
        return time;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdle() {
        return idle;
    }

    public void setIdle(int idle) {
        this.idle = idle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }
}
