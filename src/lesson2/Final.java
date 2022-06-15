package lesson2;

public class Final {
  public static void main(String[] args) {
    try {
      Class.forName("org.sqlite.JDBC");
      System.out.println("The driver was successfully loaded.");
    } catch (ClassNotFoundException e) {
      System.out.println("The driver class was not found in the program files at runtime.");
      e.printStackTrace();
      System.exit(1);
    }
  }
}
