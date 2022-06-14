package com.example.shopnow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.shopnow.R;
import com.example.shopnow.adapters.CategoryAdapter;
import com.example.shopnow.databinding.ActivityMainBinding;
import com.example.shopnow.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categories =new ArrayList<>();
        categories.add(new Category("Sports & Outdoor", "https://cdn-icons.flaticon.com/png/512/3311/premium/3311567.png?token=exp=1655182283~hmac=b5231247ed03814c68c1e05d17cd4b99", "#D1E2FF", "Here you will get all kind of sports related items", 1));
        categories.add(new Category("Consumer & Electronics", "https://cdn-icons.flaticon.com/png/512/536/premium/536255.png?token=exp=1655182344~hmac=2fabe80fbeff6d7938fa20d1f0a8bf26", "#D1E2FF", "Here you will get all kind of electronics related items", 1));
        categories.add(new Category("Food & Groceries", "https://cdn-icons.flaticon.com/png/512/3514/premium/3514242.png?token=exp=1655182243~hmac=842decd012bcd99e67fefe596eb38a67", "#D1E2FF", "Here you will get all kind of sports related items", 1));
        categories.add(new Category("Home & Lifestyle", "https://cdn-icons.flaticon.com/png/512/874/premium/874720.png?token=exp=1655182180~hmac=f8066d11837809dc2c20b3ab12c6d888", "#D1E2FF", "Here you will get all kind of sports related items", 1));
        categories.add(new Category("Men's Clothing", "https://cdn-icons-png.flaticon.com/512/892/892458.png", "#D1E2FF", "Here you will get all kind of sports related items", 1));
        categories.add(new Category("Women's Fashion", "https://cdn-icons-png.flaticon.com/512/3534/3534312.png", "#D1E2FF", "Here you will get all kind of sports related items", 1));

        categoryAdapter = new CategoryAdapter(this, categories);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);

    }
}