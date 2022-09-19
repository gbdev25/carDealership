
drop table if exists Users cascade
create table if not exists Users (
id serial primary key,
username varchar(30) unique,
password varchar (30),
auth boolean default false
);

insert into Users (username, password, auth) values ('employee', 'employee1', true)
insert into Users (username, password, auth) values ('username', 'password', default)
delete from Users where auth = false;

drop table if exists Product cascade	
create table if not exists Product(
Product_id serial primary key,
Product_name varchar(25) unique,
Product_description text,
Product_owner integer default 1 references Users(id)
);

insert into Product(Product_name, Product_description) values('Chevrolet Chevelle SS', 'The 1970 Chevrolet Chevelle SS helped to herald the ascent of the age muscle cars which peaked in the early 1970s');
insert into Product(Product_name, Product_description) values('Lamborghini Miura','Considered by some to be one of the best looking cars ever built, the Miura debuted in 1966 as a sleek mid-engine speedster.');
insert into Product(Product_name, Product_description) values(' Rolls-Royce Phantom','A full-sized luxury saloon, V-12 engine,fully decked out interior and its bulletproof. It doesnt get more over the top then this!');



drop table if exists Offers
create table if not exists Offers(
Offer_id serial primary key,
Offer_amount numeric,
Product_id int references Product(Product_id),
Offer_username varchar(30),
Offer_status varchar(30) default 'pending'
);

insert into Offers (Offer_amount, Product_id,offer_username,offer_status) values (5000, 1 , 'username', 'pending'  );
insert into Offers (offer_amount,Product_id,offer_username,offer_status) values(4000, 2 , 'username', 'pending');
insert into Offers (Offer_amount, Product_id,offer_username,offer_status) values (8000, 3, 'username', 'pending'  );
insert into Offers (Offer_amount, Product_id,offer_username,offer_status) values (9000, 1, 'username', 'pending'  );
delete from Offers where offer_amount > 1;

drop table if exists User_inventory
create table if not exists User_inventory(
Inventory_id serial primary key,
Item_name varchar(30),
remaining_payments int default 10,
User_id varchar(30) references Users(username)
);

insert into user_inventory(item_name, user_id, remaining_payments) values('Toyota Corolla', 'username', 6) 
insert into user_inventory(item_name, user_id, remaining_payments) values('Bentley', 'username', 8)
 
drop table if exists User_offer_list
create table if not exists User_offer_list(
Offer_list_id serial primary key,
Offer_status varchar(25) references Offers(Offer_status),
Offer_name varchar(30) references Users(username)
);