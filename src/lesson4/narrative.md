# Establishing a Connection

Now that we have verified that our drivers are present and restructured our project into a common design protocol, it is time to make the connection to our database.

The default setup of a SQLite database requires no username and password, therefore to connect to the database all we need to do is point the Java program in the right direction. To get our program to connect to a database we need to start using classes from the JDBC API, specifically the `DriverManager` and `Connection` classes.

The [`DriverManager`](https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html) class is the basic service used to load and manage specific JDBC drivers and to reach out to the database to obtain an initial connection.

The [`Connection`](https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html) interface manages a session with a specific database. All SQL statements and results are returned and handled within the context of a single connection. Along with managing SQL execution, a `Connection` can also provide database schema information such as overall design and specific table layouts.

The `DriverManager` has a static method that attempts to establish the initial connection and return the connection back to the user in the form of a `Connection` object. The `.getConnection()` method can either accept simply a database location such as our SQLite database, or a location, username, and password to access more secure databases. Database connections are costly to both local memory and network bandwidth and it is very important to close this resource as soon as you are finished with it.

Database locations, typically in the form of a URL, follow a generic pattern, especially when using a JDBC connection. For example, the address for our SQLite database is: `jdbc:sqlite:mysteryBusiness.db`.
- The first part refers to the type of service used to connect to the database, in our case `jdbc`.
- The second part is the type or vendor of the database. We are using `sqlite` but if you are using a MySQL database it would be `mysql` or on an Microsoft SQL Server it would be `sqlserver`.
- The last part is the path to the database and any extra parameters such as usernames and passwords. Once again, our SQLite database is fairly barebones and requires only the location in the file system of the database.

Connections are also subject to failure, which can lead to other errors in our program. For this reason, a failed connection will throw a `SQLException` and needs to be wrapped in a `try-catch-finally` block or a `try-with-resources` block, the latter being preferred because it automatically closes any open resources.

```java
try (put resources you want to open here) {
  // Do something with the resources here
  } catch (exceptions here) {
  // Do something when the try block fails, typically alert the user
  }
```

**Note:** _SQLite will create a database with the database name you give it if you request to open a database that doesn't exist. This can make it appear like you are connected to the proper database even though you are not. Using a username/password will help eliminate this problem, as well as double-checking your code._

1. The first thing we are going to do is set up the URL for our database.
   1. Under the comment, declare a new private class variable, `url` of type `String`. Make it `final` as well, that way we can't accidentally change the database in our logic.
   2. Set our `url` variable equal to `"jdbc:sqlite:resources/MYSTERY_BUSINESS.db"`. This will connect to the database to our local database.
      1. HINT: Class variables are `static`:
      ```java
      private static final String stringName = "someString";
      ```
      Don't be alarmed if you don't see the database in the folder right now, we will create it on our first run to demonstrate how SQLite will create a database when it can't find the one you point it to.
2. Next, navigate to the empty `.testDatabaseConnection()` method and add an empty `try-with-resources` block.
   1. HINT: 
   ```java
   try (put resources you want to open here) {
   // Do something with the resources here
   } catch (exceptions here) {
   // Do something when the try block fails, typically alert the user
   // }
   ```
3. Let's work on the `try` part of the `try-with-resources` block:
   1. Inside the parenthesis of the `try` block declare a new `Connection` called `connection` and set it equal to the result of making a call to `DriverManager`'s `.getConnection()` method, passing in the `url` variable to the `.getConnection()` method.
   2. In the `try` block, print out `"The connection to the SQLite database was successful!"`
4. Now to finish the `catch` portion:
   1. Catch a `SQLException` as `e`.
   2. Print `"The connection to the database was unsuccessful!"`
   3. Print the variable, `e`
   4. HINT:
   ```java
   try (Connection connection = DriverManager.getConnection(url)) {
     System.out.println("The connection to the SQLite database was successful!");
    } catch (SQLException e) {
     System.out.println("The connection to the database was unsuccessful!");
     System.out.println(e);
   }
   ```
5. Import the `DriverManager`, `Connection`, and `SQLException` classes from the `java.sql` library.
6. Open **BusinessLogic.java**, inside the main method and below the `.loadDriver()` call, make a call to the new `.testDatabaseConnection()`.
7. Compile and run your program:
   1. Navigate to the `projects` folder in the terminal (use 'cd' to change directories).
   2. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
   3. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`.
   4. You will see the database, `MYSTERY_BUSINESS.db`, appear in the `resources` folder.
   