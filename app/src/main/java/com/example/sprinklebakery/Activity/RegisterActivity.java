package com.example.sprinklebakery.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sprinklebakery.DBClass.DBHelper;
import com.example.sprinklebakery.Module.UserClass;
import com.example.sprinklebakery.R;

public class RegisterActivity extends AppCompatActivity {
    EditText EditTextUserId, EditTextPassword, EditTextConfirmPassword;
    Spinner SpinnerUserType;
    Button ButtonRegister;
    String UserType[] = {"Admin", "Member"};
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditTextUserId=(EditText) findViewById(R.id.txt_U_UserId);
        SpinnerUserType=(Spinner) findViewById(R.id.spn_S_Spinner);
        EditTextPassword=(EditText) findViewById(R.id.txt_P_Password);
        EditTextConfirmPassword=(EditText) findViewById(R.id.txt_P_ComfirtPassword);
        ButtonRegister=(Button) findViewById(R.id.btn_R_register);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUserType.setAdapter(ad);

        ButtonRegister.setOnClickListener(view -> {

            if (EditTextUserId.getText().toString().isEmpty() ||
                    EditTextPassword.getText().toString().isEmpty() ||
                    EditTextConfirmPassword.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "Fields Can't be blank",
                        Toast.LENGTH_LONG).show();
            }
            else if (EditTextPassword.getText().toString().length()<3){
                Toast.makeText(getApplicationContext(),
                        "Password must have more than 3 characters",Toast.LENGTH_LONG).show();

            }
            else if (!EditTextPassword.getText().toString().equals(EditTextConfirmPassword.getText().toString()))
            {
                Toast.makeText(getApplicationContext(),
                        "Password and confirm password should match Login",Toast.LENGTH_LONG).show();
            }
            else {
                UserClass userClass=new UserClass
                        (EditTextUserId.getText().toString(),
                                EditTextPassword.getText().toString(),
                                SpinnerUserType.getSelectedItem().toString());


                if(dbHelper.CreateNewUser(userClass)) {
                    Toast.makeText(getApplicationContext(), "User Created",
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(getApplicationContext(), EditTextUserId.getText().toString() + " has registered as " + SpinnerUserType.getSelectedItem().toString(),
                            Toast.LENGTH_LONG).show();

                }

                else {
                    Toast.makeText(getApplicationContext(), "User Creation Failed",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}