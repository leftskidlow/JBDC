# Creating the Statement Manager

Now that we have connected to the database, it is time to begin communicating with it.

JDBC provides a very straightforward class to take care of executing static SQL queries, the `Statement` interface. A `Statement` is generated from a call to the `Connection` method, `.createStatement()`.

```java
Connection connection = DriverManager.getConnection(url);
Statement statement = connection.createStatement();
```

Once a `Statement` object is created it can be used to execute SQL queries and return a `ResultSet` object, which is essentially a Java representation of a table from the database. The `ResultSet` can then be used in the logic of your program. 

These `Statement` objects, just like `Connection` objects, also need to be closed when you are finished using them and are best included inside the same `try-with-resources` block that a `Connection` is opened in.

There is also an extension of `Statement` called `PreparedStatement` that is used to execute a precompiled SQL statement multiple times and with greater efficiency. As your program interacts more and more with the database you may find that a `PreparedStatement` improves your performance.

For now, let's set up our `Statement` objects that we will use in each of our remaining `CustomerDaoService` methods.

1. Inside **CustomerDaoService.java** you will see that we have added the `try-with-resources` stubs to each of the remaining methods. We've added some whitespace to increase readability as well. Declare a new `Statement`, called `statement` and set it equal to the return of calling the `.createStatement()`  method on the `connection` object, do this for each of the following:
   1. `.createTable()` method
   2. `.saveCustomers()` method
   3. `.loadAllCustomers()` method
   4. `.loadCustomerByID()` method
   5. `.updateCustomerByID()` method
   6. HINT: Inside the resources you are opening in the `try-with-resources` block you can add multiple items to open. Each standard line of code is separated by a `;` like normal, except the last item, the semicolon is redundant there as the trailing parenthesis signifies the end of the block.
   ```java
   try (
     // Multiple Resources in the same 'resources' block
     FileReader fr = new FileReader("someFile.txt");
     BufferedReader br = new BufferedReader(fr)
   ) {
     // Do something with the BufferedReader (ie. read the file)
   } catch (Exception e) {
     System.out.println(e);
   }
   ```
2. Add an import statement to `CustomerDaoService` for the `Statement` interface, it comes from the `java.sql` as well.