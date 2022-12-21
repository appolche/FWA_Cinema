drop table if exists users cascade;

create table if not exists users (
    id              serial primary key,
    email          varchar(50) not null,
    first_name     varchar(25) not null,
    last_name      varchar(25) not null,
    phone_number   varchar(11) not null,
    password       varchar(50) not null
    );
