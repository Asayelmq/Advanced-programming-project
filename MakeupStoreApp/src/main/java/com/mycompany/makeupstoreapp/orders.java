
package com.mycompany.makeupstoreapp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orders")

public class orders implements java.io.Serializable{
 @Id
 @Column(name="order_number")
 private int order_number;
 
 @Column(name="user_id")
 private String user_id;
 
 @Column(name="order_date")
 private String order_date;
 
  @Column(name="total_price")
 private String total_price;
  
 @Column(name="city")
 private String city;
 
  @Column(name="street")
 private String street;
 
  @Column(name="zip_code")
 private String zip_code;
 
  
  @Column(name="contact_user")
 private String contact_user;
 
 public orders(){
 }

    public orders(int order_number, String user_id, String order_date, String total_price, String city, String street, String zip_code, String contact_user) {
        this.order_number = order_number;
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
        this.contact_user = contact_user;
    }

   
    

    public int getOrder_number() {
        return order_number;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getContact_user() {
        return contact_user;
    }

    public void setContact_user(String contact_user) {
        this.contact_user = contact_user;
    }
  
}