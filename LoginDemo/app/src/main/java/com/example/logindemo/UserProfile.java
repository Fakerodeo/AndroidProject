package com.example.logindemo;

public class UserProfile {

    public String userAge;
    public String userClass;
    public String userName;

    public UserProfile() {

    }

    public UserProfile(String userAge, String userClass, String userName) {
        this.userAge = userAge;
        this.userClass = userClass;
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
