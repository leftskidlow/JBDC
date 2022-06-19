# Retrieving / Viewing the ResultSet

Everything we've done so far has revolved around pushing data to our database, an important skill, but only half of the story.

Let's take a look at a very common data persistence scenario, loading a user's previous data when an app is closed and reopened at a later date. Just prior to a user exiting an app and the process is killed, the application executes a save function that pushes the user's current state to a database.

When the application is reopened in the future, a splash screen is shown, along with a loading bar, that is sending a request back to the database to load that user's saved state so that when the splash screen disappears it appears to the user that the app never even forgot where the user left it. Through our JDBC implementation, we can produce similar results, but we need to now learn how to retrieve information back from the database.

In JDBC, the data that is sent back to the Java application from a database comes in the form of a `ResultSet` and is returned by a query on the database from a `Statement` object. This `ResultSet` object, just like `Connection` and `Statement` needs to be closed when finished, meaning it belongs with the other resources in our `try-with-resources` block.

A `ResultSet` object is a collection of rows and columns that represent a table from the database. There is a "cursor" that points to the current row, from which we can access columns by the column's index (which, unlike other Java data structures, begins with index 1).

```java
Statement statement = connection.createStatement();
ResultSet results = statement.executeQuery("SQL QUERY");
```

You may have noticed in the code example that we are now calling the `.executeQuery()` method instead of the `.executeUpdate()` method, the difference being that a query returns a `ResultSet`.

Once we have injected the SQL to the database and received the result as a `ResultSet`, we can use regular ol' Java code to work through the results and present them to the user.

Let's see how this looks inside Mystery Business!

1. The first step is to generate the `ResultSet`. Inside the `.loadAllCustomers()` method, after we've created the `Statement`, declare a new `ResultSet`, called `results`, and set it equal `statement.executeQuery("SELECT * FROM CUSTOMERS;")`. You'll also need to import `java.sql.ResultSet`.
   1. HINT: `SELECT * FROM CUSTOMERS` is the SQL expression to select all the rows and columns from a given table, in this case, `CUSTOMERS`.
2. Inside the `try` block, under the comment "Add logic to print the ResultSet here:", add an empty `while` loop. It will iterate while `results.next()`.
   1. HINT: The `.next()` method of the `ResultSet` class moves the current row cursor down by one each time, returning a boolean if the row it moved to exists or not. The nice thing about `.next()` is that it begins with the cursor pointing `before the first row` so that its first call with move the cursor to the first row in the `ResultSet`. The query you executed may not have returned any rows of data, so this technique is very useful when moving through a data set of unknown size.
3. Inside the `while` loop:
   1. Add a print (not a `println()`) statement that prints `"Current Customer: "`
   2. Add an empty `for` loop that begins at `1` and runs until `i < 6`.
   3. After the `for` loop, at a `.println()` statement that say `"moving to the next customer..."`
      1. HINT:
      ```java
      while (results.next()) {
        System.out.print("");
        for (int i = 1; i < 6; i++) {
      
        }
        System.out.println("");
      }
      ```
4. Inside the `for` loop, use a `.print()` statement to print out the current column value (indexed by `i`) using the `.getString()` method of `ResultSet`. Follow this with a space and a comma. Remember the pass the column index, `i`, to the `.getString()` method.
   1. HINT: `System.out.print(results.getString(i);` is the syntax that will make this work. Since the `.next()` method moves us down a row each time, this `for` loop will iterate over all the columns in the current row. Since we built the table, we know that there are exactly five columns, indexed 1 through 5. The `.getString(int columnIndex)` method takes a column index and converts the value in the column to a String object for use in Java.
5. Navigate to **BusinessLogic.java**, inside the `.main()` method, add a call to the updated `.loadAllCustomers()` method of the `CustomerDaoService` class under the applicable comment.
6. Compile and run your program:
   1. Navigate to the `projects` folder in the terminal (use 'cd' to change directories).
   2. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
   3. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`. Voila!!!