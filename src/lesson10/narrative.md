# Review

Congratulations! You now know how to successfully implement the Java Database Connectivity framework. This API provides you with a strong dive into the connection between the front and back ends of software engineering, now you're truly a full stack developer!

You'll find that many of the popular and more robust data storage solutions are just as easy to use as SQLite with JDBC, and we encourage you to test your skills across many options. The conformance requirements to JDBC standards ensures all connections follow similar syntax and work flow!

Let's go over a few of the key features you implemented throughout this lesson:
- The five-layered structure of JDBC implementation
- Downloading third-party JDBC drivers
- Specifying multiple classpaths for our program to include at runtime
- Building code to in line with a design principles: MVVM and Data Access Objects
- Verifying and Registering JDBC drivers with the `DriverManager`
- Establishing a `Connection` to a database and managing the opening and closing of reources in a responsible way
- Creating a `Statement` in JDBC to manage our SQL injections to the database
- Converting Java data types to SQL and vice versa in order to save objects to a database and then retrieve them out of the same database
- Creating a `ResultSet` from a SQL query and how to iterate through the rows and columns of the `ResultSet`

We truly only scraped the surface capabilities of the JDBC API, and we encourage you to expand your knowledge by diving into the documentation and practicing on your own time. Here is an example of where you can take your new-found skills and practice on your own programs:

> Take a look at the `Blob` data type in SQL, which is a large binary object data type, essentially a stream of binary data. This powerful data type, when combined with your I/O skills from Beginning Java and Serialization skills from Intermediate Java can be used to create a simple and powerful full stack solution for applications with a small to medium-sized user base.