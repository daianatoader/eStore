create database estore;
use estore;

CREATE table admin (
ID int not null auto_increment,
username varchar(50), 
PAROLA varchar(500),
PRIMARY KEY (ID));

CREATE table brand (
ID int not null auto_increment, 
brand_name varchar(100), 
description varchar(500),
PRIMARY KEY (ID));

CREATE table client(
ID int not null auto_increment,
username varchar(100),
parola varchar(100),
first_name varchar(100),
last_name varchar(100),
email varchar(100),
phone long,
adress varchar(100),
card_number int,
PRIMARY KEY (ID));

CREATE TABLE orders(
ID int not null auto_increment, 
price float, 
payment_method ENUM('cash','card'), 
shipping_method ENUM('normal','fast'), 
order_status ENUM('delivered','shipped','waiting'),
client_id int,  
PRIMARY KEY (ID),
FOREIGN KEY (client_id) REFERENCES client(ID));

CREATE TABLE section (
ID int not null auto_increment,
section_name varchar(100),
PRIMARY KEY (ID));

CREATE TABLE product
(ID int not null auto_increment, 
product_name varchar(500),
details varchar(500),
price float, 
section_id int, 
brand_id int,  
PRIMARY KEY (ID),
FOREIGN KEY (section_id) REFERENCES section(ID),
FOREIGN KEY (brand_id) REFERENCES brand(ID));


CREATE TABLE order_products
(ID int not NULL auto_increment, 
product_id int, 
order_id int,  
PRIMARY KEY (ID),
FOREIGN KEY (product_id) REFERENCES product(ID),
FOREIGN KEY (order_id) REFERENCES orders(ID));

    
CREATE TABLE sale_products (
 ID int NOT NULL auto_increment,
 discount float,
 duration int,
 product_id int,
PRIMARY KEY (ID),
FOREIGN KEY (product_id) REFERENCES  product(ID));
 

CREATE TABLE campaign (
ID int not null auto_increment,
details varchar(200),
period varchar(100),
sale_id int,
product_id int,
PRIMARY KEY (ID),
FOREIGN KEY (product_id) REFERENCES product(ID),
FOREIGN KEY (sale_id) REFERENCES sale_products(ID));
    

    




