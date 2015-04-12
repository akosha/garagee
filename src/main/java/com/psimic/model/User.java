package com.psimic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/**
 * Created by psimic on 31.03.15.
 */
@Document(collection = "users")
public class User {

    @Id
    private String plates;
    private UserType userType;
    private HashMap<Long, Long> locationInGarage;


    public User(String plates, UserType userType, HashMap<Long, Long> locationInGarage) {
        this.plates = plates;
        this.userType = userType;
        this.locationInGarage = locationInGarage;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public HashMap<Long, Long> getLocationInGarage() {
        return locationInGarage;
    }

    public void setLocationInGarage(HashMap<Long, Long> locationInGarage) {
        this.locationInGarage = locationInGarage;
    }



    @Override
    public String toString() {
        return "User{" +
                "plates='" + plates + '\'' +
                ", userType=" + userType +
                ", locationInGarage=" + locationInGarage +
                '}';
    }
}
