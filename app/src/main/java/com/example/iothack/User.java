package com.example.iothack;

public class User {

    public Double Lat;
    public String email;
    public Double Long;
    public Double Rad;
    public Double Lev;




    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String email,Double Lat,Double Long, Double Rad,Double Level) {
        this.Lat = Lat;
        this.Long= Long;
        this.Rad = Rad;
        this.email = email;
        this.Lev = Level;

    }
}


