package com.example.pwin.lab5;
//Peng Xie 40328958
public class Food {
    private String name;
    private String energy;
    private String key;
    public Food(){
        name ="NA";
        energy ="NA";
//        key = "NA";
    }
    public Food(String name, String energy){
        this.name = name;
        this.energy = energy;
//        this.key = key;
    }
    public String getName(){
        return this.name;
    }
    public String getEnergy(){
        return this.energy;
    }
//    public String getKey(){return this.key;}
}
