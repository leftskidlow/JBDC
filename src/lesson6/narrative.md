# Creating a table / Executing a statement

Up to this point we have still been operating strictly in Java within our application. Now that we have firmly established a connection with our database and successfully created a statement manager, it is time to begin blending SQL into our program.

As a reminder, SQL is the language of relational databases. The term "relation" is just a fancy word for a table and how the data across multiple tables can be related to each other. All data in a relational database is stored inside these tables, broken down into columns and rows.

Inside `CustomerDaoService` most of our methods are just waiting on some preliminary data manipulation and then the injection of the actual SQL statements to execute "queries" or commands on the database. While this isn't a SQL focused lesson, we will make sure you walk away with a functional program and the ability to store your application's data into a persistent data source.

As it stands, we currently have an entirely empty database, "MYSTERY_BUSINESS.db", without even a table to its name, just an empty shell, like a variable that has been declared but not initialized. In SQL, we use the command "CREATE TABLE" followed by the table name and then the column names and data types. Let's look at our `Customer` model and how it will translate into a table in SQLite:
![Java to SQLite Datatype Conversion](https://github.com/leftskidlow/images/blob/main/java_to_sqlite_converstion.png?raw=true)

1. Go to the `.createTable()` method in **CustomerDaoService.java**, there is a new String variable, `createTableStatement`, that currently consists of seven lines of empty strings. While we can write SQL all in one line (whitespace doesn't matter to SQL), it is helpful to make it easier for humans to read. In the first empty string, enter the command to create a new table called `CUSTOMERS` followed by an open parenthesis. We've included a sample SQL file, `commands.sql` so you can see a completed create table SQL command.
   1. HINT: Review the `commands.sql` file for the proper syntax, your sql commands should be in all uppercase (some databases are case sensitive). It is also standard convention to use all capitals for table names and column headers.
2. Inside the empty String on the next line:
   1. Enter the column name, "CUST_ID"
   2. Leave a space and enter the data type, "INTEGER"
   3. Leave a space and enter our column constraint, "PRIMARY KEY", followed by a comma.
   4. HINT: The primary key designation means that this column uniquely identifies each row, no two customers can have the same ID.
   ```java
    String createTableStatement = "CREATE TABLE CUSTOMERS ("
      + "CUST_ID INTEGER PRIMARY KEY,"
      + ""
      + ""
      + ""
      + ""
      + "";
   ```
3. Use the graphic from the narrative and fill out the commands to create the rest of the columns:
   1. `CUST_F_NAME`, `CUST_L_NAME`, `CUST_EMAIL`, and `CUST_CELL_NUM`. All the columns should be on their own line in the String.
   2. After the data type, each column will also have the constraint "NOT NULL", meaning that there must be an entry in that column, we don't want to add customers that don't have all their data.
   3. The last line of the String should be a closed parenthesis and a semicolon, ");"
   4. HINT:
   ```java
       String createTableStatement = "CREATE TABLE SOME_TABLE_NAME ("
      + "ID INTEGER PRIMARY KEY,"
      + "COLUMN1_NAME TEXT NOT NULL,"
      + "COLUMN2_NAME TEXT NOT NULL,"
      + "COLUMN3_NAME TEXT NOT NULL,"
      + "COLUMN4_NAME TEXT NOT NULL"
      + ");";
   ```
4. Inside the `try-with-resources` block, before the statement that lets users know the table was created successfully, add a call to the `.executeUpdate()` method of our `statement` object. Pass in the `createTableStatement` String as a variable to the method.
5. Finally, navigate to **BusinessLogic.java**, inside the `.main()` method, add a call to the updated `.createTable()` method of the `CustomerDaoService` class.
6. Compile and run your program:
    1. Navigate to the `projects` folder in the terminal (use 'cd' to change directories).
    2. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
    3. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`.