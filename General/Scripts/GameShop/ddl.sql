drop table if exists reviews cascade;
drop table if exists products cascade;
drop table if exists gameshops cascade;
drop table if exists shippingaddress cascade;
drop table if exists carts;
drop table if exists pastorders cascade;

drop table if exists users cascade;
drop table if exists authorities;

create table gameshops(
	id serial,
	name varchar,
	city varchar, 
	state varchar,

	constraint pk_gameshops_id
	primary key(id)
);

create table reviews(
	id serial,
	rating varchar,
	message varchar,
	username varchar,
	gameshop_id int,
	user_id int,
	
	constraint pk_reviews_id
	primary key(id),
	
	constraint fk_gameshops_id
	foreign key (gameshop_id) references gameshops(id),
	
	constraint fk_users_id
	foreign key (user_id) references users(id)
);

create table products(
	id serial,
	name varchar,
	instock varchar,
	price int,
	quantity int,
	gameshop_id int,
	description varchar,
	manufacturer varchar,
	
	constraint pk_products_id
	primary key(id),
	
	constraint fk_gameshops_id
	foreign key (gameshop_id) references gameshops(id)
);

create table carts(
	id serial,
	product_id int,
	user_id int,
	name varchar,
	quantity int,
	

	constraint pk_cart_id 
	primary key(id),
	
	constraint fk_product_id
	foreign key (product_id) references products(id),
		
	constraint fk_users_id
	foreign key (user_id) references users(id)

);

create table pastorders(
	id serial,
	name varchar,
	price int,
	quantity int,
	product_id int,
	users_id int,
	datetime varchar not null,

	
	constraint pk_pastorders_id
	primary key(id),
	
	constraint fk_product_id
	foreign key (product_id) references products(id),
	
	constraint users_id_fk
	foreign key (users_id) references users(id)
);

create table users(
	id serial,
	firstname varchar,
	lastname varchar,
	password varchar,
	username varchar,
	street varchar,
	city varchar,
	state varchar,
	zipcode varchar,
	country varchar,
	adminis boolean,
	---pastorders_id int,
		
	
	constraint pk_users_id
	primary key(id)
	
	---constraint fk_history_id
	---foreign key (pastorders_id) references pastorders(id)
);


create table authorities(
	id serial,
	
	primary key(id)

);

alter table cart
add foreign key (users_id) references users(id);

   
   
   



