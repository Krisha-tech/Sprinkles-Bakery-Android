package com.example.sprinklebakery.DBClass;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {
    public DBConnector(Context context){
        super(context, "DB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table userInfo(UserID VARCHAR PRIMARY KEY NOT NULL,password VARCHAR,UserType VARCHAR)");
        sqLiteDatabase.execSQL("create table Category(CategoryID VARCHAR PRIMARY KEY NOT NULL,CategoryName VARCHAR)");
        sqLiteDatabase.execSQL("create table Product(productID VARCHAR PRIMARY KEY NOT NULL,ProductName VARCHAR,CategoryID VARCHAR,Price INTEGER,Quantity INTEGER,FOREIGN KEY(CategoryID)REFERENCES Category(CategoryID) )");
        sqLiteDatabase.execSQL("create table Invoice(Orderid VARCHAR PRIMARY KEY NOT NULL,ProductID VARCHAR,Quantity INTEGER,Total INTEGER,FOREIGN KEY(ProductID)REFERENCES Product(ProductID))");
        sqLiteDatabase.execSQL("create table cupcakeinfo(UserID VARCHAR PRIMARY KEY NOT NULL,CupcakeId VARCHAR,CupcakeName VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
