CREATE table Product (
    id int primary key,
    name varchar(100),
    price int,
    creation_datetime timestamp default current_date
);

CREATE table Product_category (
    id int primary key,
    name varchar(100),
    product_id int references Product(id)
);