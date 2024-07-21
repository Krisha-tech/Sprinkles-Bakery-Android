package com.example.sprinklebakery.Module;

public class UserClass {
    private String UserId;
    private String Password;
    private String UserType;

    public UserClass() {}

    public UserClass(String userId, String password, String userType) {
        UserId = userId;
        Password = password;
        UserType = userType;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
