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
@Table(name="userinfo")
public class userinfo implements java.io.Serializable{
  @Id
@Column(name="userID")
private String userID;
  
@Column(name="Name")
private String name;
    
@Column(name="Email")
private String email;
 
@Column(name="Phone")
private String phone;
 
@Column(name="Pass")
private String pass;

    public userinfo() {
    }

    public userinfo(String userID, String name, String email, String phone, String pass) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




}