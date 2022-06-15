import java.sql.*;

public class CodeExamples {
  public static void main(String[] args) {
    String url = "jdbc:sqlite:/Users/timmiller/JDBC_TEST.db";
    String userName = "admin";
    String password = "adminPassword";

    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("The driver has been successfully loaded.");
    } catch (ClassNotFoundException e1) {
      System.err.println("Couldn't located the driver.");
      System.err.println(e1);
      System.exit(1);
    }

    /*
    Try - Catch - Finally syntax. The resources are declared outside of the try block
    and then closed in the finally block. If this finally block is forgotten, the resources
    are left open.
     */
    Connection conn = null;
    Statement statement = null;
    ResultSet results = null;

    try {
      conn = DriverManager.getConnection(url);
      statement = conn.createStatement();
      results = statement.executeQuery("SELECT * FROM SOMETABLE");
      // Do something with results
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      try { results.close(); } catch (Exception e) { /* Ignored */ }
      try { statement.close(); } catch (Exception e) { /* Ignored */ }
      try { conn.close(); } catch (Exception e) { /* Ignored */ }
    }

    /*
    Try With Resources block, the resources are now a part of the try block itself
    and the closing of the resources is handled automatically at the end of the execution.
     */
    try (Connection conn1 = DriverManager.getConnection(url, userName, password);
         Statement statement1 = conn.createStatement();
         ResultSet results1 = statement.executeQuery("SELECT * FROM SOMETABLE")
    ) {
      // Do something with results
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
