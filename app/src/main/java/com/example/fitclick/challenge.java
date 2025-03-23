package com.example.fitclick;

import androidx.annotation.NonNull;

public class challenge {
    String desc;
    int done;
    int total;

    public challenge(String desc, int d, int t){
        this.desc = desc;
        done = d;
        total = t;
    }

    public boolean completed(){
        return done==total;
    }

    @NonNull
    public String toString(){
        return desc+"  Progress: "+done+"/"+total;
    }
}
