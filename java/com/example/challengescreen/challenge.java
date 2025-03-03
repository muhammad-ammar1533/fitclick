package com.example.challengescreen;

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

    public String toString(){
        return desc+"  Progress: "+done+"/"+total;
    }
}
