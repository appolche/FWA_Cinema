drop table if exists users cascade;

-- create schema if not exists cinema;

create table if not exists users (
    id              serial primary key,
    first_name     varchar(20) not null,
    last_name      varchar(20) not null,
    phonenumber    varchar(20) not null,
    password       varchar(20) not null
    );
