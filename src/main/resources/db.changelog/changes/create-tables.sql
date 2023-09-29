--liquibase formatted sql
--changeset anita:v.0.1.0-ddl
CREATE TABLE if not exists mypizza1.cafe_data
(
    id    varchar(36) PRIMARY KEY,
    cafe_name  varchar(30) not null ,
    location   varchar(100) not null ,
    phone      varchar(20) not null ,
    created_at timestamp  DEFAULT CURRENT_TIMESTAMP,
    pizza_id varchar(36)

);
CREATE TABLE if not exists mypizza1.pizza_data
(
    id    varchar(36) PRIMARY KEY,
    pizza_name  varchar(30) not null ,
    size        varchar(10) not null ,
    price       numeric,
    description varchar(300) not null ,
    created_at  timestamp DEFAULT CURRENT_TIMESTAMP,
    cafe_id varchar(36) not null ,
        foreign key (cafe_id) references cafe_data (id)

);


CREATE TABLE if not exists mypizza1.customer_data
(
    id varchar(36) PRIMARY KEY,
    fullname    varchar(40) not null ,
    phone       varchar(20) not null ,
    email       varchar(20) not null ,
    location    varchar(100) not null ,
    password    varchar(8) not null ,
    created_at  timestamp DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE if not exists mypizza1.order_data
(
    id varchar(36) PRIMARY KEY,
    created_at  timestamp DEFAULT CURRENT_TIMESTAMP,
    customer_id varchar(36) not null ,
    foreign key (customer_id) references customer_data (id)
);
CREATE TABLE if not exists mypizza1.order_data_pizzas
(
    pizza_id varchar(36),
     foreign key (pizza_id) references pizza_data (id),
    order_id varchar(36),
    foreign key (order_id) references order_data (id)
);

