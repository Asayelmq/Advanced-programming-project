/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makeupstoreapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="cart")
public class cart  implements java.io.Serializable { 
 
     @Id 
     @Column(name="prouductID") 
     private String prouID; 
     @Column(name="userID") 
     private String userid; 
     @Column(name="quantity") 
     private String n_quantity; 
     @Column(name="totalprice") 
     private String t_price; 
     
    public cart(){}
    
     public cart(String productid,String uID,String quant,String price){
     this.prouID=productid;
     this.userid=uID;
     this.n_quantity=quant;
     this.t_price=price;
     }

    public String getProuID() {
        return prouID;
    }

    public void setProuID(String prouID) {
        this.prouID = prouID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

   
     
     
    
 
  
    
}