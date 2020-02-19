-- using the Database
use MLP173;


DROP TABLE IF EXISTS ORDER_DETAIL;

CREATE TABLE ORDER_DETAIL
(ORDER_ID int auto_increment primary key,
ORD_TIME date,
ORD_AMOUNT numeric(9,2),
ORD_LOCATION varchar(100),
ORD_STATUS Enum('ACCEPTED','REJECTED','PENDING','CANCELLED'),
QTY_ORDER int,
CUS_ID int references customer(id),
FOOD_ID int references FOOD_ITEM(FOOD_ID),
VEN_ID int references VENDOR(VEN_ID),
Wal_Type varchar(20),
ORD_COMMENTS VARCHAR(50)
);


DROP TABLE IF EXISTS WALLET;
CREATE TABLE WALLET
(CUS_ID int references customer(CUS_ID),
WAL_ID Int auto_increment,
WAL_AMOUNT numeric(9,2),
WAL_TYPE Enum('CREDITCARD','DEBITCARD','PAYTM'),
PRIMARY KEY(WAL_ID,WAL_TYPE)
);

DROP TABLE IF EXISTS FOOD_ITEM;
CREATE TABLE FOOD_ITEM
(FOOD_ID int auto_increment PRIMARY KEY,
FOOD_NAME varchar(30),
FOOD_DETAIL varchar(100),
FOOD_PRICE DOUBLE,
FOOD_STATUS enum('AVAILABLE','NOTAVAILABLE'),
FOOD_RATING varchar(75));

DROP TABLE IF EXISTS VENDOR;
CREATE TABLE VENDOR
(VEN_ID int primary key auto_increment,
VEN_NAME varchar(30),
VEN_PASSWORD varchar(30),
VEN_EMAIL varchar(30),
VEN_MOBILE numeric,
VEN_ADDRESS varchar(100)); 

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER
(CUS_ID int primary key auto_increment,
CUS_NAME varchar(30),
CUS_PASSWORD varchar(30), 
CUS_EMAIL varchar(30),
CUS_MOBILE varchar(11),
CUS_DOB date,
CUS_ADDRESS varchar(100)
);                      
