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

public class ViewCupcakeActivity extends AppCompatActivity {
    ListView lst_Vf_VievCupcake;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cupcake);
        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        lst_Vf_VievCupcake = (ListView) findViewById(R.id.lst_Vf_VievCupcake);

        ArrayList<String> theList =new ArrayList<>();
        Cursor cursor = dbHelper.SearchAllCupcake();
            if (cursor.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "No Cupcake Found", Toast.LENGTH_LONG).show();
            } else {
                while (cursor.moveToNext()) {
                    theList.add(cursor.getString(0));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                    lst_Vf_VievCupcake.setAdapter(listAdapter);
                }
            }
        }

    }
