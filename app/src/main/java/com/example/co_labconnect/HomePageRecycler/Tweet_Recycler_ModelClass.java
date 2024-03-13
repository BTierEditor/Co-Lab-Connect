package com.example.co_labconnect.HomePageRecycler;

public class Tweet_Recycler_ModelClass {
    String Time,Date,Name,Thoughts;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getThoughts() {
        return Thoughts;
    }

    public void setThoughts(String thoughts) {
        Thoughts = thoughts;
    }

    public Tweet_Recycler_ModelClass(String date,String name,String thoughts) {
        Date = date;
        Name = name;
        Thoughts = thoughts;
    }
}
