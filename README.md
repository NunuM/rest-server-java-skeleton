# rest server java skeleton
Rest server in JAVA, using JERSEY and JAX-RS, persistence implemented in JPA

Feel free to use this rest java skeleton. Sometimes is hard to make depencencies right in java world along other litlle frameworks details.

##Important Aspects

- AppSettings class is reponsable to hold your start up settings application.

- In deployment i used Application class that JAX-RS provides, like that i avoid servlet-based deployment. In ApplicationRestConfig you must add the facades that you want display on rest http requests.

- The persistence is decoupled from the database, you can save your data on every database you want, in AppSettings is declarated the Repository factory that PersistenceContext instantiates in runtime using reflection.

##Example

Run the main and use your browser http://localhost:8080/actor you will see the result.
