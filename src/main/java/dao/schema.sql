/**
 * Author:  Zac Seales - 6687905
 * Created: 26/08/2022
 */

CREATE TABLE IF NOT EXISTS CUSTOMER (
	Customer_ID INTEGER AUTO_INCREMENT (1000),
	FirstName varchar(50) not null,
        Surname varchar(50) not null,
        Username varchar(50) not null unique,
        Password varchar(50) not null,
        Email_Address varchar(50),
	Shipping_Address varchar(100)
);

CREATE TABLE IF NOT EXISTS PRODUCT (
	Product_ID varchar(20) unique,
	Name varchar(50) not null,
        Description varchar(200),
        Category varchar(20) not null,
        ListPrice FLOAT not null,
        Quantity_In_Stock INTEGER not null
);
