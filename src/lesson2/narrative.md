# JDBC Drivers

The first layer we will set to tackle is the bottom most, the JDBC Drivers. These are third-party provided files that allow a specific database to extend JDBC classes and interfaces so that they work with that database. While SQL is the industry standard for relational database communication, its implementation is not standardized across all databases. Some databases only support certain SQL statements, some format their SQL differently, and some still may rely on SQL and some other programming language to implement their features. This variation among database providers means that each database product will have its own drivers, similar to each printer manufacturer each having its own drivers. If a database manufacturer hasn't provided the JDBC Drivers you can search common package managers like [Maven](https://mvnrepository.com/open-source) to see if an open-source variant is available.

These drivers, depending on the database vendor, can be quite large in size, anywhere from a few kilobytes of class files to a few megabytes, so if you are working on an embedded platform with limited resources, this is another consideration. Once downloaded, the driver needs to be added to the [classpath](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html) of your program, that is, the location that the JVM looks for `.class` files for your application. Many IDEs have a process to do this automatically, but we will stick to adding the classpath variable through the command line interface manually.

We’ll be using SQLite and the [SQLite JDBC Driver](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc). Once it is downloaded, the next step is to register the driver with the `DriverManager` class. This class is responsible for managing all the connected JDBC drivers and ensuring the necessary files are available for a successful connection. Since the 2006 release of JDBC 4.0, any driver that is placed as a classpath variable is automatically registered but since we are adding the classpath manually, it will be good practice to run through the steps to verify the driver was loaded properly. We do this by checking to see if the class exists in the program build (this occurs at runtime, not compile time) using the `Class.forName("Class Name")` method.

Let's get started! In the IDE on the right, you will see that we have already uploaded a copy of the latest SQLite driver (the `.jar` file) and have created a `project` folder that contains the file `ConnectionTest.java`.

1. Inside **ConnectionTest.java** you will see an empty class, and, if you open the file navigator, you can also see the `.jar` file of the SQLite Driver. Inside `ConnectionTest`, create an empty main method.
   1. HINT: None
2. Inside the `main` method, call the static method, `.forName()`, of the `Class` class. This method takes a String argument, the name of the class we are looking for. In this case, we are looking for a class inside the `.jar` called `"org.sqlite.JDBC"`.
   1. HINT: Why does this "register" the driver? When you make a call to the `.forName()` method it actually returns an instance of the class, causing it to be initialized. We can technically write the syntax like this and make calls to the class using the variable name, we don't because we don't have any reason to in this case.
```java 
Class driver = Class.forName("org.sqlite.JDBC");
```
3. Since there is a chance this method doesn't find the class, it throws a `ClassNotFoundException`, for this reason, wrap the method in a `try-catch` block:
   1. Put the `.forName()` method call in the `try` block.
   2. Catch the `ClassNotFoundException` as `e` in the `catch` block.
      1. Inside the `catch` block, call the `.printStackTrace()` method of the error.
   3. HINT: 
   ```java
   try {
     // Try something here
   } catch (SomeExceptionClass e) {
     // Do something to handle error
     e.printStackTrace();
   }
   ```
4. Inside the `try` block, after the `.forName()` method, add a print statement that says, `"The driver was successfully loaded."`. In the `catch` block, before the stack trace, add a print statement for when the driver isn't located, `"The driver class was not found in the program files at runtime."`. This will execute when we have either forgotten to include the classpath variable or accidentally pointed it to the wrong location.
5. After the stack trace, make a call to `System.exit(1)`. There is no point in continuing the program if it can't connect to the database.
6. Compile and run your program. Remember, you will need to pass in the classpath variable through the command line that points to your driver. You also need to point it to your current folder. We'll provide the syntax since this is new, but you can read more in the [Java Documentation](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html).
   1. Navigate, using the terminal, to the `project` folder. Use the command `cd` to change directories in the terminal.
   2. `javac ConnectionTest.java`
   3. `java -classpath .:../sqlite-jdbc-3.36.0.3.jar ConnectionTest`
   4. HINT: Let's look at the syntax here, it starts with a call to the JVM with `java`, then we add the `-classpath` variables which tells our program where to look for all the class files that will be used in the program. We separate the locations with a colon, `:`, `.` represents the current folder you are in, which is where the `ConnectionTest` class lives. The driver lives in the folder above the `project` folder and just like when using the CLI to navigate the file system, we use two periods to go up a folder, `../`, followed by the name of the `.jar` that the driver lives in. After the `-classpath` variables are entered, we point the JVM to the location of the class that contains the `main()` method, in this case, `ConnectionTest`.