package com.example.sprinklebakery.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprinklebakery.DBClass.DBHelper;
import com.example.sprinklebakery.Module.CupcakeClass;
import com.example.sprinklebakery.Module.OrderClass;
import com.example.sprinklebakery.R;

import java.util.ArrayList;

public class AddOrderActivity extends AppCompatActivity {
    EditText EditTextCupcakeId, EditTextCupcakeName, EditTextCategoryName, EditTextPrice, EditTextQuantity, EditTextOrderId,
            EditTextBuyQuantity;
    Button ButtonSearchCupcake, ButtonBuyCupcake;
    private DBHelper dbHelper;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextCupcakeId = findViewById(R.id.txt_O_Cupcake);
        EditTextCupcakeName = findViewById(R.id.txt_O_CupcakeName);
        EditTextCategoryName = findViewById(R.id.txt_O_CategoryName);
        EditTextPrice = findViewById(R.id.txt_O_Price);
        EditTextQuantity = findViewById(R.id.txt_O_Quantity);
        EditTextOrderId = findViewById(R.id.txt_O_InvoiceId);
        EditTextBuyQuantity = findViewById(R.id.txt_O_BuyingQuantity);

        ButtonSearchCupcake = findViewById(R.id.btn_Search_Cupcake);
        ButtonBuyCupcake = findViewById(R.id.Btn_O_BuyCupcake);

        ButtonSearchCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cid = EditTextCupcakeId.getText().toString();
                ArrayList <CupcakeClass> cupcakeList = dbHelper.SearchCupcake(Cid);
                if (cupcakeList.size() != 0) {
                    CupcakeClass product = cupcakeList.get(0);
                    EditTextCupcakeName.setText(product.getCupcakeName());
                    EditTextCategoryName.setText(product.getCategoryId());
                    EditTextPrice.setText(String.valueOf(product.getPrice()));
                    EditTextQuantity.setText(String.valueOf(product.getQuantity()));

                    Toast.makeText(getApplicationContext(), "Cupcake Found", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "No cupcakes found under that Id", Toast.LENGTH_LONG).show();
                }
            }
        });
        ButtonBuyCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.BuyCupcake(EditTextCupcakeId.getText().toString(), Integer.parseInt(EditTextBuyQuantity.getText().toString()));

                int Total = Integer.parseInt(EditTextBuyQuantity.getText().toString()) *
                        Integer.parseInt(EditTextPrice.getText().toString());

                int Quantity = Integer.parseInt(EditTextBuyQuantity.getText().toString());
                OrderClass order = new OrderClass(EditTextOrderId.getText().toString(), EditTextCupcakeId.getText().toString(),
                        Quantity, Total);

                if (dbHelper.InsertOrder(order)) {
                    Toast.makeText(getApplicationContext(), "Buy: " +
                            EditTextCupcakeId.getText().toString() +
                            " Total: " + Total, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
