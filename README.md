# SignInProject
Basic framework for app sign in. Includes storing passwords as hash in DB. 

Table in DB is called "users" with 4 fields:
fullname
username
password
salt

CREATE TABLE users (fullname varchar(45) NOT NULL, username varchar(45) NOT NULL, password varchar(345) NOT NULL, salt varchar(345) NOT NULL, PRIMARY KEY (username)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

