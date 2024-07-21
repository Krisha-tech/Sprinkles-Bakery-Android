package com.example.sprinklebakery.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprinklebakery.R;

public class MemberActivity extends AppCompatActivity {
    Button ButtonOrderCupcake;
    Button ButtonViewAllCupcake;
    Button ButtonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        ButtonOrderCupcake=(Button) findViewById(R.id.btn_M_AddOrder);
        ButtonViewAllCupcake=(Button) findViewById(R.id.btn_M_ViewAllCupcake);
        ButtonBack=(Button) findViewById(R.id.btn_M_Back);

        ButtonOrderCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCategory = new Intent(MemberActivity.this, AddOrderActivity.class);
                startActivity(intentCategory);
            }
        });

        ButtonViewAllCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCategory = new Intent(MemberActivity.this, ViewCupcakeActivity.class);
                startActivity(intentCategory);
            }
        });
    }
}