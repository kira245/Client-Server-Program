/*
 * This class creates instance variables for Customers 
 * Getters and setters are created to manipulate variables and retrieve them
 * 
 */
package kiraschwartzit351;

import java.io.Serializable;

/**
 *
 * @author Kira Schwartz
 */
public class Customers implements Serializable
{
 private String first;
 private String last;
 private String phone;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
 
}
