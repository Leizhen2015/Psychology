package com.psychology.Entity;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by LeiZhen on 2017/3/29.
 */

public class Doctor{

    private String name;        //姓名
    private int age;            //年龄
    //头像
    private ArrayList<Integer> aTime;      //可预约时间
    private String jieshao;     //自我介绍
    private int xiaoqu;         //校区
    private int xuexiao;        //学校
    private int guanzhu;        //是否被关注

    public Doctor(String name, int age, ArrayList<Integer> aTime, String jieshao, int xiaoqu, int xuexiao, int guanzhu) {
        this.name = name;
        this.age = age;
        this.aTime = aTime;
        this.jieshao = jieshao;
        this.xiaoqu = xiaoqu;
        this.xuexiao = xuexiao;
        this.guanzhu = guanzhu;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", aTime=" + aTime +
                ", jieshao='" + jieshao + '\'' +
                ", xiaoqu=" + xiaoqu +
                ", xuexiao=" + xuexiao +
                ", guanzhu=" + guanzhu +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Integer> getaTime() {
        return aTime;
    }

    public void setaTime(ArrayList<Integer> aTime) {
        this.aTime = aTime;
    }

    public String getJieshao() {
        return jieshao;
    }

    public int getXiaoqu() {
        return xiaoqu;
    }

    public int getXuexiao() {
        return xuexiao;
    }

    public int getGuanzhu() {
        return guanzhu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public void setXiaoqu(int xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public void setXuexiao(int xuexiao) {
        this.xuexiao = xuexiao;
    }

    public void setGuanzhu(int guanzhu) {
        this.guanzhu = guanzhu;
    }
}
