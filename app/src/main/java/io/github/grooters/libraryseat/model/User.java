package io.github.grooters.libraryseat.model;

import org.litepal.crud.LitePalSupport;

public class User  extends LitePalSupport{

    private String name;
    private String nickName;
    private String pass;
    private String signature;
    private String sex;
    private String department;
    private int seat_id;
    private String number;
    private int time;
    private int seatNumber;
    private String major;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public User(String name, String nickName, String pass, String signature, String sex, String department, int seat_id, String number, int time, int seatNumber, String major) {
        this.name = name;
        this.nickName = nickName;
        this.pass = pass;
        this.signature = signature;
        this.sex = sex;
        this.department = department;
        this.seat_id = seat_id;
        this.number = number;
        this.time = time;
        this.seatNumber = seatNumber;
        this.major = major;
    }

    public User(){

    }

}
