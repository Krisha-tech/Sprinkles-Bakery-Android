package com.example.sprinklebakery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprinklebakery.DBClass.DBHelper;
import com.example.sprinklebakery.Module.UserClass;
import com.example.sprinklebakery.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText EditTextUserId, EditTextPassword;
    Button ButtonLogin;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditTextUserId = findViewById(R.id.txt_I_UserId);
        EditTextPassword = findViewById(R.id.txt_I_Password);
        ButtonLogin = findViewById(R.id.btn_I_Submit);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList <UserClass> userDetails = dbHelper.ValidLogin(EditTextUserId.getText().toString(),
                        EditTextPassword.getText().toString());
                if (userDetails.size() != 0) {
                    UserClass user = userDetails.get(0);
                    String userType = user.getUserType(); // Admin

                    Toast.makeText(getApplicationContext(), "User found: " + userType, Toast.LENGTH_LONG).show();
                    if (userType.equals("Admin")) {
                        Intent intentAdmin = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intentAdmin);
                    } else {
                        Intent intentMember = new Intent(LoginActivity.this, MemberActivity.class);
                        startActivity(intentMember);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
