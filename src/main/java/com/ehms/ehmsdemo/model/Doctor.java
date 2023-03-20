package com.ehms.ehmsdemo.model;

import java.util.Arrays;

public class Doctor {
    private String fname;
    private String lname;
    private String profile;
    private String email;
    private String mobile[];

    public Doctor() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getMobile() {
        return mobile;
    }

    public void setMobile(String[] mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + Arrays.toString(mobile) +
                '}';
    }
}

