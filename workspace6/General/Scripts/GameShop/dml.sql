insert into gameshops values (1, 'Gamestop', 'Plaistow', 'NH');
insert into gameshops values (2, 'Gamestop', 'Salem', 'NH');
insert into gameshops values (3, 'Amazon', 'Seattle', 'WA');
insert into gameshops values (4, 'JList', 'Isesaki, Gunma', 'Japan');


insert into reviews values (1, 3, 'Good location', 1);
insert into reviews values (2, 2, 'Staff was a bit rude', 2);
insert into reviews values (3, 4, 'Fast delivery, good service', 3);
insert into reviews values (4, 5, 'Great service, a lot of personality', 4);


insert into products values (1, 'PS5', 'Never In Stock', '500', 0, 1, 'Hi.', 'Hello,');
insert into products values (2, 'Xbox One', 'In Stock', '600', 10, 2,  'Hi.', 'Hello,');
insert into products values (3, 'Nintendo Switch', 'In Stock', '300', 20, 1,  'Hi.', 'Hello,');
insert into products values (4, 'Elden Ring', 'In Stock', '60', 10, 3,  'Hi.', 'Hello,');

insert into users values (1,'John', 'Smith', '$mokey200', 'Halenora', 'hello', 'goodbye', 'who', 'what', 'where', false);

INSERT INTO carts (product_id, user_id) values (1, 1);

insert into pastorders (id, name, price, quantity, product_id, users_id, datetime) values (3, 'Elden Ring', 0, 10, 4, 1, '04-12-2022 15:26');

