package com.example.chewbs.alloheroproject.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;


public class Demand implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("nom")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("dateCreation")
    private Date creationDate;

    @SerializedName("dateDemande")
    private Date demandDate;

    @SerializedName("adresse")
    private String adress;

    @SerializedName("codePostal")
    private String postal;

    @SerializedName("ville")
    private String city;

    @SerializedName("nbPersonnes")
    private int userNumber;

    @SerializedName("nbPersonnesAccept")
    private int acceptedUserNumber;

    @SerializedName("association")
    private Association association;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getAcceptedUserNumber() {
        return acceptedUserNumber;
    }

    public void setAcceptedUserNumber(int acceptedUserNumber) {
        this.acceptedUserNumber = acceptedUserNumber;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
