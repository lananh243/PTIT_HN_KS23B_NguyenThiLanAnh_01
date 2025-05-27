create database Hackathon;
use Hackathon;

create table Category (
    category_id int primary key auto_increment,
    category_name varchar(50),
    description text,
    status bit default 1
);

delimiter //
create procedure create_category(
    category_name_in varchar(50),
    description_in text,
    status_in bit
)
begin
    insert into Category(category_name, description, status)
        values (category_name_in, description_in, status_in);
end ;

create procedure find_all_category()
begin
    select * from Category;
end ;

create procedure update_category(
    category_id_in int,
    category_name_in varchar(50),
    description_in text,
    status_in bit
)
begin
    update Category
        set
            category_name = category_name_in,
            description = description_in,
            status = status_in
    where category_id = category_id_in;
end ;

create procedure find_category_by_id(
    category_id_in int
)
begin
    select * from Category where category_id = category_id_in;
end ;

create procedure search_category_name(
    category_name_in varchar(50)
)
begin
    select * from Category where category_name like concat('%', category_name_in, '%');
end ;

delimiter //

create table Product (
    product_id int primary key auto_increment,
    product_name varchar(100) not null ,
    description text,
    price double not null check ( price > 0 ),
    image_url varchar(255),
    status bit default 1,
    created_at datetime,
    category_id int not null ,
    foreign key (category_id) references Category(category_id)
);

delimiter //
create procedure add_product(
    product_name_in varchar(100),
    description_in text,
    price_in double,
    image_url_in varchar(255),
    status_in bit,
    created_at_in datetime,
    category_id_in int
)
begin
    insert into Product(product_name, description, price, image_url, status, created_at, category_id)
        values (product_name_in, description_in, price_in, image_url_in, status_in, created_at_in, category_id_in);
end //
delimiter //