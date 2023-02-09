DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  INT      NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled)
values ('admin2','123',1);

INSERT INTO authorities (username, authority)
values ('admin2', 'admin');

CREATE SEQUENCE customer_seq;

CREATE TABLE customer
(
    id INT PRIMARY KEY DEFAULT nextval('customer_seq'),
    email varchar(45) NOT NULL,
    password varchar(200) NOT NULL,
    role varchar(45) NOT NULL
);

INSERT INTO customer (email, password, role)
VALUES ('vitargo@example.com', '12345', 'admin');
