/*
 * This class handles the clients using threads
 * 
 * 
 */
package kiraschwartzit351;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;

/**
 *
 * @author Kira Schwartz
 */
public class ClientHandler implements Runnable {
    //intialize instance variables
    private Socket client;
    private Collection<Product> products;
    private Collection<Customers> customers;
    
    //override run method of Runnable interface
    @Override
    public void run() {
        try {
            Server server = new Server();
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            //allow objects to pass back and forth
            DataRequest request = (DataRequest) in.readObject();
            if (request.isRetrieveProducts()) {
                out.writeObject(server.getProductFile());
            } else if (request.isRetrieveCustomers()) {
                out.writeObject(server.getCustomerFile());
            } else {

            }
            //opens files for what was choosen
            client.close();//close connection
        } catch (Exception e) {
            e.printStackTrace();
        }//prints all errors
    }//end run method

    public void handleClient(Socket client, Collection<Product> products, Collection<Customers> customers) {
        this.client = client;
        this.products = products;
        this.customers = customers;
        Thread t = new Thread(this);
        t.start();

    }//this method creates a new thread for client, products, and customers
    //it starts the new thread

}//end of class
