package com.invoice.application.dto;

public class InvoivceitemDTO {

    private String productName ;
    private Integer quantity ; 
    private double  unitprice;
    
    public InvoivceitemDTO (){}

    public InvoivceitemDTO(String productName, Integer quantity , double unitprice ){
        this.productName = productName;
        this .quantity = quantity;
        this.unitprice = unitprice;
    }

    public String getProductname() {
        return productName;
    }

    public void setProductname(String productname) {
        this.productName = productname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getUnitprice() {
        return unitprice;
    }

    @Override
    public String toString() {
        return "InvoivceitemDTO [productname=" + productName + ", quantity=" + quantity + ", unitprice=" + unitprice
                + "]";
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }
    
}
