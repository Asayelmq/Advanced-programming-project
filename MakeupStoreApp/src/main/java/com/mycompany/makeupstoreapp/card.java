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
@Table(name="card")
public class card implements java.io.Serializable {
    
    @Id
 @Column(name="cardNumber")
    private String cardNumber;
    
 @Column(name="userID")
    private String userID;
 
  @Column(name="cardHolderName")
    private String cardHolderName;
  
  @Column(name="cardDate")
    private String cardDate;
    
    @Column(name="ccv")

    private String ccv;

    public card() {
    }

    public card(String cardNumber, String userID, String cardHolderName, String cardDate, String ccv) {
        this.cardNumber = cardNumber;
        this.userID = userID;
        this.cardHolderName = cardHolderName;
        this.cardDate = cardDate;
        this.ccv = ccv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }


    
}
