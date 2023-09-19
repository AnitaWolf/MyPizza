**School/College:**   Tel-Ran.de Gmbh 

**Study Group:**  43_45m

**Student:**  Anita Wolf

1. Project Description and Objectives:
   The "Pizza Cafes" project is being developed to create an application that allows users to find pizzerias and order pizza. Users will be able to search for pizzas by name, view the cafe menu, and place orders within the application.

The main goal of the project is to develop a software solution that optimizes operational processes and provides convenience for users in pizza search.
![DiagrammDB.png](DiagrammDB.png)
1. Pizza_data

**Schema**

| Field   | Type                   |NotNull| Properties   | Description        |     
|---------|------------------------| --- |--------------|--------------------| 
| ID      | varchar                | +   | PK,AUTO-INCR | Pizza ID           |     
| pizza_name | varchar(30)            | +   |              | Pizza name         |       
| price   | numeric                | +   |              | Pizza price        |     
| size    | varchar (10)           | +   |              | Pizza Size         |  
| description | varchar(300)           | +   |              | Pizza description  |  
| created_at | timestamp w/o timezone |+|              |   time of data entry into the database.                 |


2.1.Get a list of all pizzas

2.2.Get a pizza by its name

2.3.Create a new pizza

2.4.Delete a pizza by its ID

2.5.Update a pizza by its ID



2. Cafe_data

**Schema**

| Field     | Type                   | NotNull | Properties | Description   |
|-----------|------------------------| ------- |------------|---------------|
| ID        | varchar                | +       | PK,AUTO-INCR | Cafe ID       |
| cafe_name | varchar(30)            |+|            | Cafe name     |
| location  | varchar(100)           |+|            | Cafe location |
| phone     | varchar(20)            |+|            | Cafe phone    |
| created_at | timestamp w/o timezone |+|            |time of data entry into the database.            |
| pizza_data_id | varchar                |+| FK pizza_data =>id |               |
	 
1.1. Get a list of all cafes.

1.2. Get cafe information by ID.

1.3. Create a new cafe.

1.4. Delete a cafe by ID

1.5. Update cafe information by ID.

	
4. Customer_data

**Schema**

| Field           | Type                   |NotNull| Properties   | Description       |     
|-----------------|------------------------| --- |--------------|-------------------| 
| ID              | varchar                | +   | PK,AUTO-INCR | Customer ID       |     
| fullname        | varchar(40)            | +   |              | Customer name     |       
| phone           | varchar(20)            | +   |              | Customer phone    |     
| email           | varchar(20)            | +   |              | Customer email    |  
| location        | varchar(100)           | +   |              | Customer address  |
| password | varchar(8)             | +   |              | customer password |
| created_at      | timestamp w/o timezone |+|              | time of data entry into the database.                  |


4.1. Get a list of all customers

4.2. Get a customer by their name

4.3. Create a new customer

4.4. Delete a customer by their ID

4.5. Update a customer by their ID


5. Order_data

**Schema**

| Field            | Type              |NotNull| Properties   | Description |     
|------------------|-------------------| --- |--------------|--| 
| ID               | varchar           | +   | PK,AUTO-INCR | Order ID |     
| customer_data_id | varchar           | +   | FK customer_data=>id |  |       
| created_at       | timestamp w/o timezone | +   |              |time of data entry into the database.  |     

6. 
   5.1 Create a new order.

   5.2 Delete an order by its ID.

   5.3 Get an order by its ID.

   5.4 Get a list of all orders.


Operations/Functions:

1. Selecting a café and viewing pizzas
2. Selecting a pizza




