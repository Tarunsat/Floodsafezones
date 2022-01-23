package com.example.iothack;

public class Global {
    private static Global instance = new Global();

    // Getter-Setters
    public static Global getInstance() {
        return instance;
    }

    public static void setInstance(Global instance) {
        Global.instance = instance;
    }

    private double notification_index1 = 13.0524309;
    private double notification_index2 = 77.6129534;
    private double notification_index3 = 100;
    private double notification_index4 = 77.6129534;
    private double notification_index5 = 77.6129534;
    private double notification_index6 = 77.6129534;
    private double Currlats = 13.0524309;
    private double Currlongs = 77.6129534;
    private String Email = "";



    private Global() {

    }


    public double getValueLat() {
        return notification_index1;
    }


    public void setValueLat(double notification_index) {
        this.notification_index1 = notification_index;
    }
    public double getValueLong() {
        return notification_index2;
    }


    public void setValueLong(double notification_index) {
        this.notification_index2 = notification_index;
    }
    public double getValueRad() {
        return notification_index3;
    }


    public void setValueRad(double notification_index) {
        this.notification_index3 = notification_index;
    }

    public double getValueLevel() {
        return notification_index4;
    }


    public void setValueLevel(double notification_index) {
        this.notification_index4 = notification_index;
    }

    public double getValueHum() {
        return notification_index5;
    }


    public void setValueHum(double notification_index) {
        this.notification_index5 = notification_index;
    }
    public double getValuePressure() {
        return notification_index6;
    }


    public void setValuePressure(double notification_index) {
        this.notification_index6 = notification_index;
    }

    public double getValueCurrLat() {
        return Currlats;
    }


    public void setValueCurrLat(double notification_index) {
        this.Currlats = notification_index;
    }
    public double getValueCurrLongs() {
        return Currlongs;
    }


    public void setValueCurrLong(double notification_index) {
        this.Currlongs = notification_index;
    }



    public String getValueEmail() {
        return Email;
    }


    public void setValueEmail(String notification_index) {
        this.Email = notification_index;
    }



}

