create database estore;
use estore;

CREATE table admin (
id int not null auto_increment,
username varchar(50), 
parola varchar(500),
PRIMARY KEY (id));

CREATE table brand (
id int not null auto_increment, 
brand_name varchar(100), 
description varchar(500),
PRIMARY KEY (id));

CREATE table client(
id int not null auto_increment,
username varchar(100),
parola varchar(100),
first_name varchar(100),
last_name varchar(100),
email varchar(100),
phone long,
adress varchar(100),
card_number int,
PRIMARY KEY (id));

CREATE TABLE orders(
id int not null auto_increment, 
price float, 
payment_method ENUM('cash','card'), 
shipping_method ENUM('normal','fast'), 
order_status ENUM('delivered','shipped','waiting'),
client_id int,  
PRIMARY KEY (id),
FOREIGN KEY (client_id) REFERENCES client(id));

CREATE TABLE section (
id int not null auto_increment,
section_name varchar(100),
PRIMARY KEY (id));

CREATE TABLE product
(id int not null auto_increment, 
product_name varchar(500),
details varchar(500),
price float, 
section_id int, 
brand_id int,  
PRIMARY KEY (id),
FOREIGN KEY (section_id) REFERENCES section(id),
FOREIGN KEY (brand_id) REFERENCES brand(id));


CREATE TABLE order_products
(id int not NULL auto_increment, 
product_id int, 
order_id int,  
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (order_id) REFERENCES orders(id));

    
CREATE TABLE sale_products (
 id int NOT NULL auto_increment,
 discount float,
 duration int,
 product_id int,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES  product(id));
 

CREATE TABLE campaign (
id int not null auto_increment,
details varchar(200),
period varchar(100),
sale_id int,
product_id int,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (sale_id) REFERENCES sale_products(id));
    

    




