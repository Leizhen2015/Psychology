package com.psychology.Entity;

import java.text.Format;
import java.util.Date;

/**
 * Created by xiaoqiang on 2017/4/6.
 */

public class Passage {
    private String type;
    private String title;
    private String content;
    private String author;
    private Date date;

    public Passage(String type,String title,String content,String author,Date date){
        this.author=author;
        this.content=content;
        this.date=date;
        this.title=title;
        this.type=type;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String DateToString(Date date){
        String a=String.format("%tF",date);
        return a;
    }
}
