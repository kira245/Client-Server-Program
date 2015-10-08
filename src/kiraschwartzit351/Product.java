/*
 * This class creates instance variables for Products 
 * Getters and setters are created to manipulate variables and retrieve them
 * 
 */
package kiraschwartzit351;

import java.io.Serializable;

/**
 *
 * @author Kira Schwartz
 */
public class Product implements Serializable
{
 private String id;
 private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
 
}
