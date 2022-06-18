package lesson7.initial.services;

import lesson7.initial.models.Customer;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoService {
  private static final String url = "jdbc:sqlite:/Users/timmiller/Desktop/Programming/JavaStuff/InterviewFiles/project/resources/MYSTERY_BUSINESS.db";

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
    try (Connection connection = DriverManager.getConnection(url)) {
      System.out.println("The connection to the SQLite database was successful!");
    } catch (SQLException e) {
      System.out.println("The connection to the database was unsuccessful!");
      System.out.println(e);
    }
  }

  /*
  Method to reset the database
   */
  public static void resetDatabase() {
    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      statement.executeUpdate("DROP TABLE CUSTOMERS");
      System.out.println("The database hsa been reset!!");
    } catch (SQLException e) {
      System.out.println("The database was not reset.");
      System.out.println(e);
    }
  }

  /*
  Method to create the CUSTOMER table in the database
   */
  public static void createTable() {
    String createTableStatement = "CREATE TABLE CUSTOMERS ("
      + "CUST_ID INTEGER PRIMARY KEY,"
      + "CUST_F_NAME TEXT NOT NULL,"
      + "CUST_L_NAME TEXT NOT NULL,"
      + "CUST_EMAIL TEXT NOT NULL,"
      + "CUST_CELL_NUM TEXT NOT NULL"
      + ");";

    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      statement.executeUpdate(createTableStatement);
      System.out.println("The CUSTOMER table has been created.");
    } catch (SQLException e) {
      System.out.println("There was an error with your request.");
      System.out.println(e);
    }
  }

  /*
  Method to save a list of customers to the CUSTOMER table
   */
  public static void saveCustomers(List<Customer> customers) {
    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      for (Customer customer : customers) {
        // Add Customer properties here:
//        String insertIntoCustomer = "INSERT INTO CUSTOMERS VALUES ("
//          + "CAST('" + HERE + "' AS INTEGER),\""
//          + HERE + "\",\""
//          + HERE + "\",\""
//          + HERE + "\",\""
//          + HERE
//          + "\");";
        // Add .executeUpdate method call here:

      }
      System.out.println("The customers have been saved to the CUSTOMER table.");
    } catch (SQLException e) {
      System.out.println("There was an error with your request.");
      System.out.println(e);
    }
  }

  /*
  Method to load all customers from the CUSTOMER table
   */
  public static List<Customer> loadAllCustomers() {
    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      System.out.println("All customers we loaded from the database.");
    } catch (SQLException e) {
      System.out.println("There was an error with your request.");
      System.out.println(e);
    }

    return new ArrayList<>();
  }

  /*
  Method to load a single customer, by ID, from the CUSTOMER table
   */
  public static Customer loadCustomerByID() {
    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      System.out.println("The requested customer has been loaded from the database.");
    } catch (SQLException e) {
      System.out.println("There was an error with your request.");
      System.out.println(e);
    }

    return new Customer(999, "No", "Name", "no@email.com", "n/a");
  }

  /*
  Method to update a single customer in the database, by ID.
   */
  public static Customer updateCustomerByID() {
    try (
      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
    ) {
      System.out.println("The requested changes have been made to the customer.");
    } catch (SQLException e) {
      System.out.println("There was an error with your request.");
      System.out.println(e);
    }

    return new Customer(999, "No", "Name", "no@email.com", "n/a");
  }
}
