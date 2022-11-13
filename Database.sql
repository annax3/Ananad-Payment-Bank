mysql> create database AnandPaymentBank;
Query OK, 1 row affected (0.09 sec)

mysql> use anandpaymentbank;
Database changed

mysql> CREATE TABLE `customers` (
    ->         `firstName` Varchar(15),
    ->     `lastName` Varchar(15),
    ->     `gender` Varchar(6),
    ->     `mobileNo` Varchar(12),
    ->     `email` Varchar(15),
    ->     `username` Varchar(15),
    ->     `password` Varchar(15),
    ->     `accountType` Varchar(15),
    ->     `accountBalance` Varchar(25),
    ->     `accountNumber` int );
Query OK, 0 rows affected (0.14 sec)
    


mysql> DESC customers;
+----------------+-------------+------+-----+---------+-------+
| Field          | Type        | Null | Key | Default | Extra |
+----------------+-------------+------+-----+---------+-------+
| firstName      | varchar(15) | YES  |     | NULL    |       |
| lastName       | varchar(15) | YES  |     | NULL    |       |
| gender         | varchar(6)  | YES  |     | NULL    |       |
| mobileNo       | varchar(12) | YES  |     | NULL    |       |
| email          | varchar(15) | YES  |     | NULL    |       |
| username       | varchar(15) | YES  |     | NULL    |       |
| password       | varchar(15) | YES  |     | NULL    |       |
| accountType    | varchar(15) | YES  |     | NULL    |       |
| accountBalance | varchar(25) | YES  |     | NULL    |       |
| accountNumber  | int         | YES  |     | NULL    |       |
+----------------+-------------+------+-----+---------+-------+
10 rows in set (0.01 sec)

mysql> create table Accountant(
    -> `Accname` varchar(15) DEFAULT NULL,
    -> `Accgender` varchar(12),
    -> `AccUserName` varchar(15),
    -> `AccPassword` varchar(15)
    -> );

mysql> DESC Accountant;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| Accname     | varchar(15) | YES  |     | NULL    |       |
| Accgender   | varchar(12) | YES  |     | NULL    |       |
| AccUserName | varchar(15) | YES  |     | NULL    |       |
| AccPassword | varchar(15) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
