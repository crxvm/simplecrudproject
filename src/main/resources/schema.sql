CREATE TABLE IF NOT EXISTS Item
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER     NOT NULL,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR (500),
    price       DOUBLE,
    is_Available BOOLEAN

);
