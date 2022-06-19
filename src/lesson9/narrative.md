# Creating Customers from the ResultSet

A `ResultSet` is all good and dandy but what we really need back into our program is `Customer` objects! In the previous exercise we used the `.getString()` method to pull data from a column and convert it to a string for use in printing. The `ResultSet` class has a wide range of other `get` methods that will return nearly any data from a column, if of course that datatype can be converted to the requested type.

Our `Customer` class stores it's `ID` as an integer and the rest of the properties are strings, making our implementation fairly easy, we'll stick to just two methods: `.getInt()` and `.getString()`. Here are some of the other options available:
- `.getBoolean()`
- `.getArray()`
- `.getTime()`
- `.getDouble()`
- `.getBlob()`

> There is a generic `.getObject()` method as well that returns the default Java object type corresponding to the column's SQL type, following the mapping for built-in types specified in the JDBC specification.

Let's get to creating our `Customer` objects from information stored inside SQL database!

1. We've cleared out the `while` loop from our previous implementation, but we'll keep the shell so we can still iterate over each row. Declare five variables, have their names match the instance variables found in the `Customer` class, don't initialize them to anything yet.
   1. HINT: Our customer class has five instance variables: `ID`, `firstName`, `lastName`, `email`, and `cellNumber`.
   ```java
   int ID;
   String firstName;
   ... etc
   ```
2. Initialize each of the five variables to its applicable column using the appropriate method from the `ResultSet` class. Initalize the variables on the same line as their declaration.
   1. HINT: The two methods needed are `.getInt()` and `.getString()`. If you remember from the last exercise, these methods get passed in a column index as an argument. These columns are 1-based, not 0-based, so be careful and make sure all five columns line up properly.
   ```java
   int ID = results.getInt(1);
   String firstName = results.
   ... etc
   ```
3. Still inside the `while` loop, add a new `Customer` to the local variable, `allCustomers`, do this all in one line.
   1. HINT: 
   ```java
   List<ConiferousTree> needleTrees = new ArrayList<>();
   needleTrees.add(new ConiferousTree("White Pine", "5 Needles per cluster", "Avg height: 65'"));
   ```
4. Head to **BusinessLogic.java**, you'll notice we have taken care of adding the code to the file this time. We've also added some logic to completely clear out our class variable that holds our customers, so that when we load customers back into the list we know they truly came from the database. We've also added a `.toString()` method to our `Customer` class and added some delays in the overall code to slow the console down a bit.
5. Compile and run your program:
    2. Navigate to the `projects` folder in the terminal (use 'cd' to change directories).
    3. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
    4. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`. Voila!!!