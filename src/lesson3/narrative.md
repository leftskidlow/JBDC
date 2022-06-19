# Following a Design Principle

In order to keep our project organized we are going to spend some time reorganizing and refactoring our project. As we start expanding the scope of our program to bring in outside resources and communicate across a variety of networks and mediums, a little organization can go a long way.

Let's assume, for this lesson's purposes, that we are an independent developer that has been asked to create a simple Java application that will be able to process customer data for a yet to be named business and also store that customer information into permanent storage via a SQLite database.

For this project, we are going to follow the MVVM, or Model-View-ViewModel, architecture. Essentially we are going to organize all of our objects (called models) into one package, our views (the user interface) into another package, and the ViewModels (the business logic that interacts with models, UI, and services) into another. We will also have a separate package for our data access classes, called `services`, where our data access object (the class that accesses the database) lives.

Let's review our project environment:
 - `project` -top level package
   - `models` - holds object representations (customers)
   - `views` - holds user interface files (we don't have UI yet)
   - `viewmodels` - holds business logic that uses models and interacts with other parts of the program such as UI and external resources
   - `services` - provides the `viewmodels` with a mode of communicating with external resources
   
1. Navigate to the `models` folder and open **Customer.java**. You can see that this is a simple class definition that establishes the structure of our `Customer` objects. Getters, setters, and other class and instance methods can also be added here.
2. Navigate to **CustomerDaoService.java** in the `services` folder and see how it is organized. You will see one method, `loadDriver()` that is very similar to the one we made in the previous exercise. There are four more methods that we will work through as we finish connecting our `Customers` to our SQLite database with JDBC.
3. Finally, navigate to the `viewmodels` folder and open **BusinessLogic.java**. Here you will find a simple class that contains a `List` of `Customers` and a few simple methods. In the `main()` method we created an instance of our class as `mysteryBusiness` and added a few mock customers to the instance that we will use to test the other capabilities we will build later.
4. At the bottom of the main method, under the comment, make a call to the static method, `.loadDriver()` of `CustomerDaoService` to make sure that the drivers are loaded at runtime.
5. Since `CustomerDaoService` comes from a class in a different folder (package), you need to import the Class.
   1. HINT: `import services.CustomerDaoService;`
6. To compile and run your program:
   1. Navigate to the `projects` folder in the terminal.
   2. Use the command `javac $(find . -name '*.java'` to compile all `.java` files in all subdirectories of the `project` folder.
   3. Run your program with the classpath variables like before: `java -classpath .:../sqlite-jdbc-3.36.0.3.jar viewmodels.BusinessLogic`.
7. If you would like, try messing up the classpath variable or modifying the `loadDriver()` method to look for a class that doesn't exist, so you can test the catch block of the method.
   1. HINT:
   ```java
   // Add a spelling mistake to the class name: 'JBDC' instead of 'JDBC'
   // To trigger the catch block execution
   Class.forName(org.sqlite.JBDC);
   ```