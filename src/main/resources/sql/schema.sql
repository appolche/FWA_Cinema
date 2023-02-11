drop table if exists users, images cascade;

create table if not exists users (
    id             serial primary key,
    email          varchar(70) not null,
    first_name     varchar(70) not null,
    last_name      varchar(70) not null,
    phone_number   varchar(11) not null,
    password       varchar(70) not null
    );

create table if not exists images (
     id             serial,
     uuid           uuid not null unique,
     original_name  varchar(255) not null,
     size           bigint not null,
     mime           varchar(255) not null,
     user_id        bigint not null,
     date           TIMESTAMP without time zone NOT NULL,

     PRIMARY KEY (id),
     FOREIGN KEY(user_id) REFERENCES users(id)
);

select * from users;
select * from images;