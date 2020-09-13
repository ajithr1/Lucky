package com.ajith.lucky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajith.lucky.POJO.SendOTP;
import com.ajith.lucky.api.ApiInterface;
import com.ajith.lucky.api.TronX;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editTextPhone);
        button = findViewById(R.id.sendButton);
    }

    public void sendOTP(View view) {

        String phone = text.getText().toString();
        All.phoneNumber = "+91"+phone;

        final ApiInterface apiInterface = TronX.getRetrofit().create(ApiInterface.class);

        apiInterface.sendOTP(new SendOTP(All.phoneNumber)).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.code() == 200){
                    Toast.makeText(getApplicationContext(), "OTP sent", Toast.LENGTH_SHORT).show();

                    Log.d(All.TAG, "onResponse: "+response.body());

                    assert response.body() != null;
                    JsonObject object = response.body().getAsJsonObject();

                    All.email = object.get("email").getAsString();

                    startActivity(new Intent(getApplicationContext(), VerifyOTPScreen.class));
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}