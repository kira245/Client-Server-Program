/*
 * IT351
 * This class creates a Server object
 * Methods are created to create files, populate them, and read them
 */
package kiraschwartzit351;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Kira Schwartz
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        createProductFile();//create product file
        createCustomersFile();//create customer file
        ServerSocket server = new ServerSocket(1115);//set up socket
        
        while (true)//leave connection open
        {
            Socket client = server.accept();//accepts connection
            ClientHandler handler = new ClientHandler();
            handler.handleClient(client, getProduct(), getCustomers());
            
            
        }//end while

    }
//Product

    private static Collection<Product> getProduct() {
        Collection<Product> productCollection = new ArrayList<Product>();

        Product p = new Product();
        p.setId("12345");
        p.setPrice(10.95);
        productCollection.add(p);
        
        p = new Product();
        p.setId("98765");
        p.setPrice(26.99);
        productCollection.add(p);
        return productCollection;

    }//A collection is created and items are added to it

    private static void createProductFile() throws IOException {
        FileOutputStream out = new FileOutputStream("product.txt");
        ObjectOutputStream outFile = new ObjectOutputStream(out);
        outFile.writeObject(getProduct());
        outFile.close();
    }//A file is created with the collection written to it

    static Collection<Product> getProductFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("product.txt");
        ObjectInputStream inObject = new ObjectInputStream(in);

        Collection<Product> inProducts = (Collection<Product>) inObject.readObject();

        inObject.close();
        return inProducts;
    }//File is read
//Customers

    private static Collection<Customers> getCustomers() {
        Collection<Customers> customerCollection = new ArrayList<Customers>();

        Customers c = new Customers();
        c.setFirst("Mary");
        c.setLast("White");
        c.setPhone("555-5555");
        customerCollection.add(c);
        
        c = new Customers();
        c.setFirst("Tony");
        c.setLast("Jones");
        c.setPhone("666-6666");
        customerCollection.add(c);
        
        return customerCollection;

    }//A collection is created and items are added to it

    private static void createCustomersFile() throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream("customers.txt");
        ObjectOutputStream outFile = new ObjectOutputStream(out);
        outFile.writeObject(getCustomers());
        outFile.close();
    }//A file is created with the collection written to it
    
    static Collection<Customers> getCustomerFile() throws FileNotFoundException, IOException, ClassNotFoundException{
    FileInputStream in = new FileInputStream("customers.txt");
    ObjectInputStream inObject = new ObjectInputStream(in);
    
    Collection<Customers> inCustomers = (Collection<Customers>) inObject.readObject();
    inObject.close();
    return inCustomers;
            
}//File is read
}//End of Server class
