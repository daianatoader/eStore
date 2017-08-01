drop schema estore;
create database estore;
use estore;

CREATE table admin (
id int not null auto_increment,
username varchar(50),
PAROLA varchar(500),
PRIMARY KEY (id));

CREATE table brand(
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
payment_method varchar(100),
shipping_method varchar(100),
order_status varchar(100),
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


CREATE TABLE campaign (
id int not null auto_increment,
details varchar(200),
period varchar(100),
discount int,
PRIMARY KEY (id));

CREATE TABLE product_campaign(
id int not null auto_increment,
product_id int,
campaign_id int,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (campaign_id) REFERENCES campaign(id));

    

    




