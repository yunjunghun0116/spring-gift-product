drop table if exists product;

create table product(
    id bigint auto_increment not null,
    name varchar(255),
    price int,
    image_url varchar(255),
    primary key (id)
)