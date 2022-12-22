drop table if exists users cascade;

create table if not exists users (
    id              serial primary key,
    email          varchar(70) not null,
    first_name     varchar(70) not null,
    last_name      varchar(70) not null,
    phone_number   varchar(11) not null,
    password       varchar(70) not null
    );

select * from users;