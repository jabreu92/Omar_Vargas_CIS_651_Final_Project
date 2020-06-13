package com.example.omar_vargas_cis_651_final_project;

import com.google.firebase.database.ServerValue;

public class User {
    public String displayname;
    public String email;
    public String phone;
    public Object timestamp;

    public User(String displayname, String email, String phone) {
        this.displayname=displayname;
        this.email=email; this.phone=phone;
        this.timestamp= ServerValue.TIMESTAMP;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public User() { }
}
