package com.example.pwin.lab5;
/*
//Peng Xie 40328958
Entry Class used to hold Day and Energy of Day
 */
public class Entry {
    private String day;
    private String energy;

    public Entry(){
        day = "NA";
        energy = "NA";
    }
    public Entry(String d, String e){
        this.day = d;
        this.energy = e;
    }
    public String getDay(){return this.day;}

    public String getEnergy(){return this.energy;}
}
