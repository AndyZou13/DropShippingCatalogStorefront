/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  student
 * Created: Mar 8, 2023
 */

 CREATE TABLE PERSON (
    USERNAME VARCHAR(20),
    PASSWORD VARCHAR(20),
    FIRSTNAME VARCHAR(20),
    LASTNAME VARCHAR(20),
    ISADMIN BIT,
    ADDRESS VARCHAR(50),
    PHONE VARCHAR(10),
    CONTINENT VARCHAR(2),
    PRIMARY KEY(USERNAME)
);

CREATE TABLE PRODUCT(
    UPC VARCHAR(20),
    PRODUCTNAME VARCHAR(20),
    PRICE FLOAT,
    QUANTITY INT NOT NULL,
    LOCATION VARCHAR(2),
    TAGS VARCHAR(100),
    PRIMARY KEY (UPC)
);

CREATE TABLE CART(
    USERNAME VARCHAR(20),
    UPC VARCHAR(20),
    PRICE FLOAT,
    QUANTITY INT NOT NULL,
    FOREIGN KEY (USERNAME) REFERENCES PERSON(USERNAME),
    FOREIGN KEY (UPC) REFERENCES PRODUCT(UPC),
    PRIMARY KEY (USERNAME, UPC)
);

INSERT INTO PERSON (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ISADMIN, ADDRESS, PHONE, CONTINENT)
VALUES ("andyadmin", "123456", "Andy", "Zou", 1, "301 Gould Street", "1234567890", "NA");
INSERT INTO PERSON (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ISADMIN, ADDRESS, PHONE, CONTINENT)
VALUES ("andyuser", "123456", "Andy", "Zou", 0, "301 Gould Street", "1234567890", "NA");
INSERT INTO PERSON (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ISADMIN, ADDRESS, PHONE, CONTINENT)
VALUES ("aaronadmin", "123456", "Aaron", "Lee", 1, "301 Gould Street", "1234567890", "NA");
INSERT INTO PERSON (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ISADMIN, ADDRESS, PHONE, CONTINENT)
VALUES ("aaronuser", "123456", "Aaron", "Lee", 0, "301 Gould Street", "1234567890", "NA");

INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("1234512345", 12.34, 100, "NA", "HOUSEWARE, CLEANING", "Dish soap");
INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("5432154321", 12.34, 100, "AF", "HOUSEWARE, CLEANING", "Sponge");
INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("1029384756", 312.12, 50, "EU", "SPORTING, SOCCER, VOLLEYBALL", "KNEE GUARDS");
INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("5238472391", 420,58, 69, "AS", "ELECTRONICS, ACCESSORIES", "PHONE CHARGER");
INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("1238479`232", 17.38, 420, "AU", "OFFICE, SUPPLIES", "BALLPOINT PEN");
INSERT INTO PRODUCT (UPC, PRICE, QUANTITY, LOCATION, TAGS, PRODUCTNAME)
VALUES ("2385712389", 7.21, 137, "SA", "FOOD, CANDY", "SOUR PATCH KIDS");

INSERT INTO CART (USERNAME, UPC)
VALUES("aaronadmin", "1234512345");