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
import com.example.sprinklebakery.Module.CupcakeClass;
import com.example.sprinklebakery.R;
import java.util.Vector;

public class CupcakeActivity extends AppCompatActivity {
    EditText EditTextCupcakeId, EditTextCupcakeName, EditTextCupcakePrice, EditTextCupcakeQuantity;
    Spinner SpinnerCategoryName;
    Button ButtonAddCupcake;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake);

        EditTextCupcakeId=(EditText) findViewById(R.id.txt_C_Cupcake);
        EditTextCupcakeName=(EditText) findViewById(R.id.txt_C_CupcakeName);
        EditTextCupcakePrice=(EditText) findViewById(R.id.txt_C_CupcakePrice );
        EditTextCupcakeQuantity=(EditText) findViewById(R.id.txt_C_CupcakeQuantity);
        SpinnerCategoryName=(Spinner) findViewById(R.id.spn_C_Cupcake);
        ButtonAddCupcake=(Button) findViewById(R.id.btn_C_Cupcake);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        Vector<String> vecCategory=dbHelper.OpenDB().getCategoryName();
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,vecCategory);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerCategoryName.setAdapter(ad);

        ButtonAddCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EditTextCupcakeId.getText().toString().isEmpty() ||
                        EditTextCupcakeName.getText().toString().isEmpty()  ||
                        EditTextCupcakePrice.getText().toString().isEmpty()  ||
                        EditTextCupcakeQuantity.getText().toString().isEmpty() )
                {
                    Toast.makeText(getApplicationContext(),"Fields Can't be blank",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    String CategoryId = dbHelper.getCategoryId(SpinnerCategoryName.getSelectedItem().toString());

                    CupcakeClass cupcakeClass = new CupcakeClass(EditTextCupcakeId.getText().toString(),
                            EditTextCupcakeName.getText().toString(),CategoryId,
                            Integer.parseInt(EditTextCupcakePrice.getText().toString()),
                            Integer.parseInt(EditTextCupcakeQuantity.getText().toString()));

                    if (dbHelper.InsertCupcake (cupcakeClass)) {
                        Toast.makeText(getApplicationContext(), "New Flower inserted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), " Failed",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}