package lesson4.initial.services;

import lesson4.initial.models.Customer;

// Add import statements here:

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoService {
  // Add database url here:

  /*
  Method to test the drivers are found in the classpath
   */
  public static void loadDriver() {
    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("The driver was successfully loaded.");
    } catch (ClassNotFoundException e) {
      System.out.println("The driver class was not found in the program files at runtime.");
      System.out.println(e);
      System.exit(1);
    }
  }

  /*
  Method to test the connection to the database
   */
  public static void testDatabaseConnection() {

  }

  /*
  Method to create the CUSTOMER table in the database
   */
  public static void createTable() { }

  /*
  Method to save a list of customers to the CUSTOMER table
   */
  public static void saveCustomers(List<Customer> customers) { }

  /*
  Method to load all customers from the CUSTOMER table
   */
  public static List<Customer> loadAllCustomers() { return new ArrayList<>(); }

  /*
  Method to load a single customer, by ID, from the CUSTOMER table
   */
  public static Customer loadCustomerByID() { return new Customer(999, "No", "Name", "no@email.com", "n/a"); }

  /*
  Method to update a single customer in the database, by ID.
   */
  public static Customer updateCustomerByID() { return new Customer(999, "No", "Name", "no@email.com", "n/a"); }
}

