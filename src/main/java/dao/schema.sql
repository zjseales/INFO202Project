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
	Shipping_Address varchar(100),
        constraint Customer_PK primary key (Customer_ID)
);

CREATE TABLE IF NOT EXISTS PRODUCT (
	Product_ID varchar(20) unique,
	Name varchar(50) not null,
        Description varchar(200),
        Category varchar(20) not null,
        ListPrice FLOAT not null,
        Quantity_In_Stock INTEGER not null,
        constraint Product_PK primary key (Product_ID)
);

CREATE TABLE SALE (
    Sale_ID INTEGER AUTO_INCREMENT (1000),
    Sale_Date date not null,
    Customer_ID INTEGER not null,
    Status varchar(20) not null,
    constraint Sale_PK primary key (Sale_ID),
    constraint Sale_Customer_FK foreign key (Customer_ID) references Customer
);

CREATE TABLE SALE_ITEM (
    Sale_ID INTEGER not null,
    Product_ID varchar(20) not null,
    Quantity INTEGER not null,
    Price FLOAT not null,
    constraint SaleItem_PK primary key (Sale_ID, Product_ID),
    constraint SaleItem_Sale_FK foreign key (Sale_ID) references Sale,
    constraint SaleItem_Product_FK foreign key (Product_ID) references Product
);
