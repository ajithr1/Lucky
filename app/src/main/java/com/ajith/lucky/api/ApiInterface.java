package com.ajith.lucky.api;

import com.ajith.lucky.POJO.SendOTP;
import com.ajith.lucky.POJO.VerifyOTP;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Content-Type: application/json",
            "Content-Length: 31",
            "X-DeviceId: T5511BJ31671401367",
            "X-ProtocolVersion: 3.0",
    })
    @POST("otp/create")
    Call<JsonElement> sendOTP(@Body SendOTP sendOTP);

    @Headers({
            "Content-Type: application/json",
            "Content-Length: 87",
            "X-DeviceId: T5511BJ31671401367",
            "X-ProtocolVersion: 3.0",
    })
    @POST("otp/verify")
    Call<JsonElement> verifyOTP(@Body VerifyOTP verifyOTP);

    @GET("states_daily.json")
    Call<JsonElement> getDataStateDaily();

    @GET("v2/state_district_wise.json")
    Call<JsonElement> getDataDistricts();
}
