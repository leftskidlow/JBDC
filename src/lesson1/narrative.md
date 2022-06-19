# Introduction to JDBC

The **Java Database Connectivity** (JDBC) framework is an API provided by Oracle, the parent company of the Java Programming language, and is included in the JDK when you install it on your computer. This API provides a simple and consistent way to connect our Java applications to a relational database in order to persist our data.

**Persistence**, or _the ability of your data to live outside your application_, is a crucial part of software development, especially as your programs grow in size and number of users. 

There are a number of different storage solutions available to a developer and JDBC provides a standard way to connect and interface with many of these options. This lesson, if you are following along both here and on your personal machine, will make exclusive reference to the SQLite database, a small and portable database available free of charge at [SQLite.org](https://www.sqlite.org). If you would like more information on installing this database on your computer, see our article about it here: [What is SQLite](https://www.codecademy.com/article/what-is-sqlite).

JDBC allows programmers to operate directly on the database by allowing the language of databases, Structured Query Language (SQL), to be written directly into your Java files. If this is your first time hearing of SQL, we strongly suggest you review our [Basic SQL for JDBC](TODO:LINK_TO_ARTICLE_WHEN_COMPLETE) article, as this lesson will assume a basic understanding of the necessary SQL commands for table creation and data manipulation.

All in all, between your application and the database, five layers exist in the JDBC environment:
1. Your Application
   - All the logic, user interface, and data contained in your Java files.
2. JDBC API
    - This is a set of classes and supporting files that provide the framework for the connection to a database.
3. JDBC Driver Manager
    - The JDBC driver manager, normally referenced by importing and calling the class `DriverManager` class acts as the interface between you the programmer, and the actual drivers for the database.
4. JDBC Drivers
    - This is the specific code that translates the commands sent via the JDBC into the language and syntax that the designated database works with. Most database applications, MySQL, SQLite, and Postgres for example, each provide JDBC drivers that can be downloaded from their websites.
5. Databases
    - These are the data storage objects used to persist data throughout your application.

As we progress through the next few exercises we will navigate and implement JDBC solutions to link all five layers together into a useable data storage solution that you can add to your toolkit as a professional software engineer.
    

1. Continue to begin implementing the JDBC API!