package com.example.sprinklebakery.DBClass;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sprinklebakery.Module.CategoryClass;
import com.example.sprinklebakery.Module.CupcakeClass;
import com.example.sprinklebakery.Module.OrderClass;
import com.example.sprinklebakery.Module.UserClass;

import java.util.ArrayList;
import java.util.Vector;

public class DBHelper {
    private Context con;
    private SQLiteDatabase db;

    public DBHelper(Context con) {
        this.con = con;
    }

    public DBHelper OpenDB() {
        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return this;
    }

    public boolean CreateNewUser(UserClass userClass) {
        try {
            db.execSQL("insert into UserInfo values('" + userClass.getUserId() + "','" + userClass.getPassword() + "','" + userClass.getUserType() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean CreateNewCategory(CategoryClass categoryClass) {
        try
        {
            db.execSQL("insert into categoryinfo values('"+categoryClass.getCategoryId()+ "','"+ categoryClass.getCategoryName()+"')");
            return  true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<UserClass> ValidLogin(String UserId, String Password)//U001 111
    {

        ArrayList<UserClass> userList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery("Select * from UserInfo where UserID='" + UserId + "' and Password='" + Password + "' ", null);
            if (cursor.moveToFirst())//T
            {
                do {
                    UserClass user = new UserClass();
                    user.setUserId(cursor.getString(0));// U001
                    user.setPassword(cursor.getString(1));// 111
                    user.setUserType(cursor.getString(2));// Admin
                    userList.add(user);
                } while (cursor.moveToNext());// F
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    public Vector<String> getCategoryName()
    {
        Vector<String> vecCategory= new Vector<String>();
        try
        {
            Cursor cursor=db.rawQuery("Select categoryname from categoryinfo ",null);
            if(cursor.moveToFirst()) //T
            {
                do{
                    vecCategory.add(cursor.getString(0));//
                }while (cursor.moveToNext());// F
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return vecCategory;
    }
    public String getCategoryId(String CategoryName)
    {
        String CategoryId=null;
        try
        {
            Cursor cursor=db.rawQuery("Select categoryid from categoryinfo where categoryname='"+CategoryName+"'",null);
            if(cursor.moveToFirst())
            {
                CategoryId=cursor.getString(0);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return CategoryId;
    }

    public boolean InsertCupcake(CupcakeClass cupcakeClass) {
        try {
            db.execSQL("Insert into cupCake values('"+cupcakeClass.getCupcakeId()+"'," +
                    " '"+cupcakeClass.getCupcakeName()+"'," +
                    " '"+cupcakeClass.getCategoryId()+"', " +
                    "'"+cupcakeClass.getPrice()+"','"+cupcakeClass.getQuantity()+"' )");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Cursor SearchAllCupcake()
    {
        Cursor cursor = null;
        try
        {
            cursor=db.rawQuery("Select CupCakeName, Price from cupCake ",null);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cursor;
    }

    public ArrayList<CupcakeClass> SearchCupcake (String CupcakeId)
    {
        ArrayList<CupcakeClass> cupcakeClassArrayList =new ArrayList<CupcakeClass>();
        try
        {
            Cursor cursor=db.rawQuery("Select * from cupcakeinfo where cupcakeid='"+CupcakeId+"'",null);
            if(cursor.moveToFirst())//T
            {
                do {
                    CupcakeClass Cupcake = new CupcakeClass();
                    Cupcake.setCupcakeId(cursor.getString(0));//P001
                    Cupcake.setCupcakeName(cursor.getString(1));//Book1
                    Cupcake.setCategoryId(cursor.getString(2));////C001
                    Cupcake.setPrice(cursor.getInt(3));//100
                    Cupcake.setQuantity(cursor.getInt(4));//100
                    cupcakeClassArrayList.add(Cupcake);
                }while (cursor.moveToNext());//F
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return cupcakeClassArrayList;
    }

    public void BuyCupcake(String CupcakeId,int Quantity)
    {
        try
        {
            db.execSQL("update cupcakeinfo set Quantity=Quantity-"+ Quantity +" where cupcakeid='" +CupcakeId+"'");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean InsertOrder(OrderClass order)
    {
        try
        {
            db.execSQL("Insert into orderinfo values('"+
                    order.getOrderId()+"','"+
                    order.getCupcakeId()+"',"+
                    order.getTotal()+","+
                    order.getQuantity()+")");
            return true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<OrderClass> SearchOrder (String OrderId)
    {
        ArrayList<OrderClass> orderList =new ArrayList<OrderClass>();
        try
        {
            Cursor cursor=db.rawQuery("Select * from orderinfo where orderid='"+OrderId+"'",null);
            if(cursor.moveToFirst())//T
            {
                do {
                    OrderClass order = new OrderClass();
                    order.setOrderId(cursor.getString(0));//P001
                    order.setCupcakeId(cursor.getString(1));//Book1
                    order.setTotal(cursor.getInt(2));//100
                    order.setQuantity(cursor.getInt(3));//100
                    orderList.add(order);
                }while (cursor.moveToNext());//F
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return orderList;
    }

    public Cursor SearchAllOrders()
    {
        Cursor cursor = null;
        try
        {
            cursor=db.rawQuery("Select orderid,CupCakeID,Quantity from orderinfo ",null);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cursor;
    }




}