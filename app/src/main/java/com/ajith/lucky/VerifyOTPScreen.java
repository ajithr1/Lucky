package com.ajith.lucky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajith.lucky.POJO.VerifyOTP;
import com.ajith.lucky.api.ApiInterface;
import com.ajith.lucky.api.TronX;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyOTPScreen extends AppCompatActivity {

    private EditText otp;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p_screen);

        otp = findViewById(R.id.verifyText);
        button = findViewById(R.id.verifyButton);
    }

    public void verifyOTP(View view) {
        String otp = this.otp.getText().toString();

        final ApiInterface apiInterface = TronX.getRetrofit().create(ApiInterface.class);

        apiInterface.verifyOTP(new VerifyOTP(All.email, All.phoneNumber, otp))
                .enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        if (response.code() == 200){
                            Toast.makeText(getApplicationContext(),
                                    "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}