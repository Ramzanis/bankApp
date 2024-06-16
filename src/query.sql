CREATE database bank_database;

USE bank_database;

CREATE TABLE `customer` (

 `c_id` int NOT NULL UNIQUE;
 
 `c_firstname` varchar(45) DEFAULT NULL,
 
 `c_lastname` varchar(45) DEFAULT NULL,

 `password` varchar(20) DEFAULT NULL,
 
 `balance` decimal(15,2) DEFAULT NULL,
 
 PRIMARY KEY (`c_id`)

);

