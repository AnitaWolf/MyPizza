--liquibase formatted sql
--changeset anita:v.0.1.0-test-data


INSERT INTO pizza_data (id, created_at, `description`, pizza_name, size, price)
VALUES ('88857ae2-22d4-4725-b27d-c3c9943a5aab', timestamp('2023-09-15 10:30:00'), 'Classic tomato and mozzarella',
        'Margherita', 'Small', 10.99);
INSERT INTO pizza_data (id, created_at, `description`, pizza_name, size, price)
VALUES ('7a1ec8f9-56b7-4b99-8e9e-fab8dd27f6c2', timestamp('2023-09-15 10:30:00'), 'Spicy pepperoni and cheese',
        'Pepperoni', 'Large', 12.99);
INSERT INTO pizza_data (id, created_at, `description`, pizza_name, size, price)
VALUES ('a5d4f83c-8fa2-43c6-bec8-015187d4853e', timestamp('2023-09-15 10:30:00'), 'Assorted veggies and cheese',
        'Vegetarian', 'Medium', 11.99);


INSERT INTO cafe_data(id, cafe_name, phone, location, created_at, pizza_id)
values ('98857ae2-22d4-4725-b27d-c3c9943a5aab', 'Domino', '+4912345678901', 'Munchen, Leopoldstr. 123, 80802',
        timestamp('2023-09-15 10:30:00'), '88857ae2-22d4-4725-b27d-c3c9943a5aab');
INSERT INTO cafe_data(id, cafe_name, phone, location, created_at, pizza_id)
values ('8a1ec8f9-56b7-4b99-8e9e-fab8dd27f6c2', 'Café Central', '+4987654321002', 'Munchen, Sendlinger Str. 25, 80331',
        timestamp('2023-09-15 10:30:00'), '88857ae2-22d4-4725-b27d-c3c9943a5aab');
INSERT INTO cafe_data(id, cafe_name, phone, location, created_at, pizza_id)
values ('a6d4f83c-8fa2-43c6-bec8-015187d4853e', 'Bavarian Brews', '+4976123456789',
        'Munchen, Schwanthalerstr. 8, 80336', timestamp('2023-09-15 10:30:00'),
        'a5d4f83c-8fa2-43c6-bec8-015187d4853e');
# INSERT INTO cafe_data(id, cafe_name, phone, location, created_at, pizza_id)
# values ('98857ae2-22d4-4725-b27d-c3c9943a5aab', 'Domino', '+4912345678901', 'Munchen, Leopoldstr. 123, 80802',
#         timestamp('2023-09-15 10:30:00'), 'a5d4f83c-8fa2-43c6-bec8-015187d4853e');




insert into customer_data (id, email, created_at, location, fullname, password, phone)
values ('3f44675f-6fe7-4db4-833e-32733016da1f', 'ma@vv.de', timestamp('2023-09-15 10:30:00'),
        'Munchen, Goethestr. 33, 80336', 'Mark Ekkert', '1234',
        '0157536249846');
insert into customer_data (id, email, created_at, location, fullname, password, phone)
values ('4a994eaa-9339-4d70-9d60-7984884decbc', 'al@vv.de', timestamp('2023-09-15 10:30:00'),
        'Munchen, Leopoldstr. 73, 80336', 'Alex Mayer', '23456',
        '0157586244633');

insert into order_data (id, created_at, customer_id)
values ('aac493d6-2a12-4a92-aa17-26d0eef2ff79', '2023-09-23 19:02:30',  '4a994eaa-9339-4d70-9d60-7984884decbc');
insert into order_data (id, created_at, customer_id)
values ('aac493d6-2a12-4a92-aa17-26d0eef2ff88', '2023-09-23 19:03:30',  '3f44675f-6fe7-4db4-833e-32733016da1f');
insert into order_data (id, created_at, customer_id)
values ('aac493d6-2a12-4a92-aa17-26d0eef2ff89', '2023-09-23 19:03:30',  '3f44675f-6fe7-4db4-833e-32733016da1f');

insert into order_data_pizzas (pizza_id,order_id)
values ('88857ae2-22d4-4725-b27d-c3c9943a5aab','aac493d6-2a12-4a92-aa17-26d0eef2ff79');

insert into order_data_pizzas (pizza_id,order_id)
values ('88857ae2-22d4-4725-b27d-c3c9943a5aab','aac493d6-2a12-4a92-aa17-26d0eef2ff88');


insert into order_data_pizzas (pizza_id,order_id)
values ('88857ae2-22d4-4725-b27d-c3c9943a5aab','aac493d6-2a12-4a92-aa17-26d0eef2ff79');

insert into order_data_pizzas (pizza_id,order_id)
values ('7a1ec8f9-56b7-4b99-8e9e-fab8dd27f6c2','aac493d6-2a12-4a92-aa17-26d0eef2ff88');













