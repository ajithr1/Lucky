package com.ajith.lucky.POJO;

public class VerifyOTP {

    private String email;
    private String mobile_auth;
    private String otp;

    public VerifyOTP(String email, String mobile_auth, String otp) {
        this.email = email;
        this.mobile_auth = mobile_auth;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_auth() {
        return mobile_auth;
    }

    public void setMobile_auth(String mobile_auth) {
        this.mobile_auth = mobile_auth;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
