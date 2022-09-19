---getuserinventorybyid
select * from User_inventory where User_id  = ?;
----remaining payments list
select * from User_inventory where remaining_payments > 0;
-------createoffer
insert into Offers (Offer_amount, Product_id,Offer_username) values (?,?,?) returning Offer_id;
-----retrievependingoffers
select * from Offers where Offer_status = 'pending';
----desicionoffer
update Offers set offer_status = ? where offer_id = ?;
-----createproduct
insert into Product (Product_name, Product_description) values (?,?) returning Product_id;
----retrieveproducts
select * from Product;
-----retrieveproductbyid
select * from Product where Product_Id = ?;
----deleteproductbyid
delete from Product where Product_id = ?;
-----getuser
select * from User_inventory where User_id  = ?;
-----createuser
insert into users (username, password) values (?,?) returning id;
----retrieveuserbyid
select * from users where id = ?;
----list retrieve users
select * from users;
----retrieveuserbyusername
select * from users where username  = ?;
----retrieveauth
select * from users;
