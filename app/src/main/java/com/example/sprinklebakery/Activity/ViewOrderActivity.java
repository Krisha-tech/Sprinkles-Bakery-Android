package com.example.sprinklebakery.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sprinklebakery.DBClass.DBHelper;
import com.example.sprinklebakery.R;
import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {
    ListView Lst_I_Orders;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();
        Lst_I_Orders = (ListView) findViewById(R.id.Lst_I_Orders);
        ArrayList<String> theList = new ArrayList<>();
        Cursor cursor = dbHelper.SearchAllOrders();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Orders Found", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                theList.add(cursor.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                Lst_I_Orders.setAdapter(listAdapter);
            }
        }
    }
}
