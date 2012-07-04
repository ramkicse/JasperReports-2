/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ramki.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ramki
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String itemName;
    private float price;
    private int noOfUnits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }
    
}
