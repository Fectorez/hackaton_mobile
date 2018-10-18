package com.example.chewbs.alloheroproject.model;

public class User {

    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String phone_number;
    private String presentation;
    private String birthdate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public static boolean isIsOnline() {
        return IS_ONLINE;
    }

    public static void setIsOnline(boolean isOnline) {
        IS_ONLINE = isOnline;
    }

    public static boolean IS_ONLINE;
}

