package com.example.sprinklebakery.Module;

public class CupcakeClass {
    private String CupcakeId;
    private String CupcakeName;
    private String CategoryId;
    private int Price;
    private int Quantity;

    public CupcakeClass(){}

    public CupcakeClass(String cupcakeId,String cupcakeName,String categoryId,int price,int quantity){
        CupcakeId=cupcakeId;
        CupcakeName=cupcakeName;
        CategoryId=categoryId;
        Price=price;
        Quantity=quantity;
    }

    public String getCupcakeId() {
        return CupcakeId;
    }

    public void setCupcakeId(String cupcakeId) {
        CupcakeId = cupcakeId;
    }

    public String getCupcakeName() {
        return CupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        CupcakeName = cupcakeName;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
