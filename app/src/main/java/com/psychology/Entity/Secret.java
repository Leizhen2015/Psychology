package com.psychology.Entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by LeiZhen on 2017/4/4.
 */

public class Secret implements Serializable{

    private String neirong;
    private int zan;
    private String[] pinglun;
    private String description;

    public Secret(String neirong, int zan, String[] pinglun, String description) {
        this.neirong = neirong;
        this.zan = zan;
        this.pinglun = pinglun;
        this.description = description;
    }

    public String getDescription(){return description; };

    public void setDescription(String description){this.description = description; };

    public String getNeirong() {
        return neirong;
    }

    public int getZan() {
        return zan;
    }

    public String[] getPinglun() {
        return pinglun;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public void setPinglun(String[] pinglun) {
        this.pinglun = pinglun;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "neirong='" + neirong + '\'' +
                ", zan=" + zan +
                ", pinglun=" + Arrays.toString(pinglun) +
                '}';
    }
}
