/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makeupstoreapp;



import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


    @Entity
@Table(name = "products")
public class products {
    
    @Id
    @Column(name = "category")
    private String category;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_price")
    private int product_price;

    @Column(name = "product_quantity")
    private int product_quantity;
    
    
       @Column(name = "product_ID")
    private int product_ID;
       
       @Column(name = "product_color")
    private String product_color;
       
       
       
          public products() {
    }
    }
    
    
