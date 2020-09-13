package com.ajith.lucky.POJO;

public class SendOTP {

    private String mobile_auth;

    public SendOTP(String mobile_auth) {
        this.mobile_auth = mobile_auth;
    }

    public String getMobile_auth() {
        return mobile_auth;
    }

    public void setMobile_auth(String mobile_auth) {
        this.mobile_auth = mobile_auth;
    }
}
