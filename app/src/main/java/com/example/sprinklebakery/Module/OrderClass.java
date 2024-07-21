package com.example.sprinklebakery.Module;

public class OrderClass {
    private String OrderId;
    private  String CupcakeId;
    private  int Quantity;
    private  int Total;

    public OrderClass(){}

    public OrderClass(String orderId,String cupcakeId,int quantity, int total){
        OrderId=orderId;
        CupcakeId=cupcakeId;
        Quantity=quantity;
        Total=total;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;

    }

    public String getCupcakeId() {
        return CupcakeId;
    }

    public void setCupcakeId(String cupcakeId) {
        CupcakeId = cupcakeId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
