package com.example.sprinklebakery.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprinklebakery.R;

public class AdminActivity extends AppCompatActivity {
    Button ButtonAddCategory;
    Button ButtonAddCupcake;
    Button ButtonViewOrders;
    Button ButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ButtonAddCategory=(Button) findViewById(R.id.btn_A_NewCategory);
        ButtonAddCupcake=(Button) findViewById(R.id.btn_A_AddnewCupcake);
        ButtonViewOrders=(Button) findViewById(R.id.btn_A_AllOrders);
        ButtonBack=(Button) findViewById(R.id.btn_A_Back);

        ButtonAddCategory.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this, CategoryActivity.class);
            startActivity(intentCategory);
        });
        ButtonAddCupcake.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this, CupcakeActivity.class);
            startActivity(intentCategory);

        });
        ButtonViewOrders.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this, ViewOrderActivity.class);
            startActivity(intentCategory);
        });
        ButtonBack.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this, MainActivity.class);
            startActivity(intentCategory);
        });
    }
}