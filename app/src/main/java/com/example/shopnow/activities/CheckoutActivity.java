package com.example.shopnow.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shopnow.R;
import com.example.shopnow.databinding.ActivityCheckoutBinding;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}