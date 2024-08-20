// TestyResty

Approach
The intention is to keep each part of the flow as loosely coupled as possible. It uses a coordinator class to delegate specific tasks to each individual component. 

Each element is designed to be able to be swapped out for something new with little effort or impact on the overall system. 

Generics are used to type the customer data, meaning that we only get ESGCustomer specific data into the DB. 
Interfaces are used where possible to ensure that swapping new implementations in has little effect on the other parts of the application. 

The application leverages the Spring framework, particularly the RestController annotation which provides the REST API functionality. Under the hood, this manages the calls using JSON so there's no need for another parser. However, we could abstract that away if we wanted finer control and use JAX or GSON for example.


Assumptions
It is assumed for this project that the input file is from a trusted source and not likely to be corrupted or in error. 
Also assumed that the csv file does not have headers. 


Further improvement
I'd look to implement more data integrity when reading from the CSV file. Perhaps call external API to verify postcode and address.
More data integrity around each cell, also checking for headers.

In this example I have used the JPA repository approach to bind the customer data to a DB entity. 
In the real world I’d likely look to use an alternative such as Mongo DB. However, this solution hopefully demonstrates that the approach used means that we could use any suitable technology simply by creating new implementations of each interface/abstract class. 

I have used Spring Boot as it was the quickest way to get an app created in my home dev environment. 
I’ve not used Spring Boot before so this is a bit of a crash course for me. 

The REST annotation is not something I'm familiar with at this level, I've not used it for a while so would look to learn more on how this fits together in a working application.

With more time, I'd look to write more Unit tests and particularly an end to end integration test that fires up the application context and checks multiple flows through the system.