--liquibase formatted sql
--changeset anita:v.0.1.0-ddl

CREATE TABLE pizza_data
(
    id    varchar(36) PRIMARY KEY,
    pizza_name  varchar(30),
    size        varchar(20),
    price       float,
    description varchar(300),
    created_at  timestamp
);

CREATE TABLE cafe_data
(
    id    varchar(36) PRIMARY KEY,
    cafe_name  varchar(30),
    location   varchar(100),
    phone      varchar(20),
    created_at timestamp,
    pizza_id varchar(36),
    foreign key (pizza_id) references pizza_data (id)
);
CREATE TABLE customer_data
(
    id varchar(36) PRIMARY KEY,
    fullname    varchar(40),
    phone       varchar(20),
    email       varchar(20),
    location    varchar(100),
    password    varchar(8),
    created_at  timestamp
);
CREATE TABLE order_data
(
    id varchar(36) PRIMARY KEY,
    created_at  timestamp,
    customer_id varchar(36),
    foreign key (customer_id) references customer_data (id)
);
CREATE TABLE order_data_pizzas
(
    pizza_id varchar(36),
     foreign key (pizza_id) references pizza_data (id),
    order_id varchar(36),
    foreign key (order_id) references order_data (id)
);

