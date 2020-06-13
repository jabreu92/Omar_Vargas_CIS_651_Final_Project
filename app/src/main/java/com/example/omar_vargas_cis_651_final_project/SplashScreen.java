package com.example.omar_vargas_cis_651_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if (currentUser == null) {
                    Toast.makeText(SplashScreen.this, "No user found", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SplashScreen.this, SignupLogin.class));
                    finish();
                } else {
                    if (currentUser.isEmailVerified()) {
                        //Toast.makeText(MainActivity.this, "User already signed in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(SplashScreen.this, "Please verify your email and login.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SplashScreen.this, SignupLogin.class));
                        finish();
                    }
                }
            }
        }.start();
    }
}
