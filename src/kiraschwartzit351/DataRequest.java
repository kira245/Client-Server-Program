/*
 * This class is a data request for products and customers.
 * It contains setters and getters.
 * 
 */
package kiraschwartzit351;

import java.io.Serializable;

/**
 *
 * @author Kira Schwartz
 */
public class DataRequest implements Serializable
{

    private boolean retrieveProducts;
    private boolean retrieveCustomers;

    public boolean isRetrieveCustomers() {
        return retrieveCustomers;
    }

    public void setRetrieveCustomers(boolean retrieveCustomers) {
        this.retrieveCustomers = retrieveCustomers;
    }

    public boolean isRetrieveProducts() {
        return retrieveProducts;
    }

    public void setRetrieveProducts(boolean retrieveProducts) {
        this.retrieveProducts = retrieveProducts;
    }
}
