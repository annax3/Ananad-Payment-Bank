mysql> CREATE DATABASE Bank;
Query OK, 1 row affected (0.13 sec)

mysql> USE Bank;
Database changed
mysql> show tables;
Empty set (0.00 sec)

mysql> CREATE TABLE `customer` (
    ->
    ->  `ac_no` int NOT NULL AUTO_INCREMENT,
    ->
    ->  `cname` varchar(45) DEFAULT NULL,
    ->
    ->  `balance` varchar(45) DEFAULT NULL,
    ->
    ->  `pass_code` int DEFAULT NULL,
    ->
    ->  PRIMARY KEY (`ac_no`),
    ->
    ->  UNIQUE KEY `cname_UNIQUE` (`cname`)
    ->
    -> ) ;
Query OK, 0 rows affected (0.25 sec)

mysql> show tables;
+----------------+
| Tables_in_bank |
+----------------+
| customer       |
+----------------+
1 row in set (0.00 sec)

mysql> DESC customer;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| ac_no     | int         | NO   | PRI | NULL    | auto_increment |
| cname     | varchar(45) | YES  | UNI | NULL    |                |
| balance   | varchar(45) | YES  |     | NULL    |                |
| pass_code | int         | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
4 rows in set (0.09 sec)



