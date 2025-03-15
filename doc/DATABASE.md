### This file records the database information of this project
##### Created by Toothless7788

### Database
1. ```springdocker_db```
    ```
    CREATE DATABASE springdocker_db;

    CREATE USER 'user_springdocker'@'localhost' IDENTIFIED BY 'Springdocker123456?xyz';
    GRANT ALL PRIVILEGES ON springdocker_db.* TO 'user_springdocker'@'localhost';
    ```
    ```
    CREATE TABLE IF NOT EXISTS SpringDocker_User (
        user_id INT AUTO_INCREMENT, 
        name VARCHAR(255) NOT NULL, 
        email VARCHAR(255) NULL, 
        CONSTRAINT PK_User PRIMARY KEY (user_id)
    );
    ```