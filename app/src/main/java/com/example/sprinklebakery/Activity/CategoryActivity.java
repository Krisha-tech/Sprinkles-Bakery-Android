package com.example.sprinklebakery.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprinklebakery.DBClass.DBHelper;
import com.example.sprinklebakery.Module.CategoryClass;
import com.example.sprinklebakery.R;

public class CategoryActivity extends AppCompatActivity {
    EditText EditTextCategoryId, EditTextCategoryName;

    Button ButtonAddCategory;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        EditTextCategoryId = (EditText) findViewById(R.id.txt_C_CategoryId);
        EditTextCategoryName = (EditText) findViewById(R.id.txt_C_CategoryName);
        ButtonAddCategory = (Button) findViewById(R.id.btn_C_AddCategory);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        ButtonAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EditTextCategoryId.getText().toString().isEmpty() || EditTextCategoryName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields cannot be blank", Toast.LENGTH_LONG).show();
                }

                else {
                    CategoryClass categoryClass = new CategoryClass(
                            EditTextCategoryId.getText().toString(),
                            EditTextCategoryName.getText().toString());

                    if (dbHelper.CreateNewCategory(categoryClass)) {
                        Toast.makeText(getApplicationContext(), "New Category insert", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Toast.makeText(getApplicationContext(), "Failed inserting category",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}
