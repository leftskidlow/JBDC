# Storing a List<Customer> to the database

- Database Created... ✅
- Table Created... ✅
- ~~Alderaan System targeted~~... ✅
- List of Customers Saved to Table... ❌

As you can see our ~~death star~~, database, is not quite fully operational yet. Let's keep working toward making this ~~weapon system~~ JDBC connection perform some useful work. Creating databases and tables is all good and well but our core functionality is actually turning our Java data into data that we can store into our tables.

This is done with the SQL `INSERT INTO` statement. We `INSERT` a set of values, in the same order as the columns of our table, `INTO` our table. We will continue to use the `Statement` interface to implement this SQL command, although we challenge you to browse the [PreparedStatement Documentation](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html) to see how you can implement a more efficient solution on your own.

Let's take a look at a sample insert statement in SQLite:

```sql
INSERT INTO CUSTOMERS
  VALUES (1010, "Jack", "Delangey", "jack@mysterybusiness.com", "555-867-5309");
```
We don't want to hardcode values into our SQL expression though, we want  our `CustomerDaoService` to contain the logic to substitute each of these values for the properties of our `Customer` class. The whole command will be concatenated together into a String that we can execute on our database using our `Statement` object.

1. Inside the `.saveCustomers()` method and inside the `try` block, we've created a `for-each` loop that iterates over each `customer` in `customers`. Inside the loop is our SQL String, `insertIntoCustomer` with five locations, marked by "HERE" that need to be changed to the five instance properties of the current iteration of `customer`. Change each "HERE" to its corresponding `customer` property.
   1. HINT: Each of the five "HERE"'s corresponds to one instance variable. You may have noticed that the first variable, `customer.ID` is wrapped in the SQL function `CAST()`, which will convert it from the String format back to an `INTEGER` in the database. 
   
   These variables  also have to be in the same order of the columns in our table, here is how our implementation turned out:
   ```java
   String insertIntoCustomer = "INSERT INTO CUSTOMERS VALUES ("
          + "CAST('" + customer.ID + "' AS INTEGER),\""
          + customer.firstName + "\",\""
          + customer.lastName + "\",\""
          + customer.email + "\",\""
          + customer.cellNumber
          + "\");";
   ```
2. Outside the `for-each` loop, call the `executeUpdate()` on the `Statement` instance, pass in the `insertIntoCustomer` to the method.
   1. HINT:
   ```java
   Statement someStatement = someConnection.createStatement();
   someStatement.executeUpdate("THIS IS A SQL EXPRESISON;");
   ```
3. Navigate to **BusinessLogic.java**, inside the `.main()` method, add a call to the updated `.saveCustomers()` method of the `CustomerDaoService` class, pass in the `customerList` variable.
4. Compile and run your program:
    1. Navigate to the `projects` folder in the terminal (use 'cd' to change directories).
    2. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
    3. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`.
    4. HINT: You will notice we have added a helper method to the `CustomerDaoService` class, `.resetDatabase()`. This helper method deletes the `CUSTOMER` table so that you can start with a fresh table each time, helping eliminate some errors as we run these setup methods over and over again.