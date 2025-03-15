CREATE TABLE IF NOT EXISTS SpringDocker_User (
        user_id INT AUTO_INCREMENT, 
        name VARCHAR(255) NOT NULL, 
        email VARCHAR(255) NULL, 
        CONSTRAINT PK_User PRIMARY KEY (user_id)
    );