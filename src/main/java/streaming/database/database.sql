drop database if exists streaming;
create database if not exists streaming;
use streaming;
-- table for users
create table users
(
    id         int auto_increment
        primary key,
    email      varchar(200)                       null,
    password   varchar(200)                       null,
    birthdate  date                               null,
    created_at datetime default CURRENT_TIMESTAMP null,
    updated_at datetime default CURRENT_TIMESTAMP null,
    rib        varchar(255)                       null,
    constraint users_email_unique
        unique (email),
    constraint users_rib_unique
        unique (rib)
);
--  subscription types tables
create table subscription_types
(
    id         int auto_increment primary key ,
    name       varchar(200),
    created_at datetime default current_timestamp,
    constraint subscription_types_name_unique unique (name)

);
-- subscriptions table
create table subscriptions
(
    id                   int auto_increment primary key,
    user_id              int,
    subscription_type_id int,
    duration             int,
    created_at datetime default current_timestamp,
    constraint subscriptions_user_id_subscription_type_id_unique unique (user_id, subscription_type_id),
    constraint subscriptions_user_id_foreign foreign key (user_id) references users (id) on delete cascade,
    constraint subscriptions_subscription_type_id_foreign foreign key (subscription_type_id) references subscription_types(id) on delete cascade
);
create table profile_types
(
    id          int auto_increment primary key,
    code        varchar(200) ,
    description text null ,
    constraint profile_types_code_unique unique (code)
);

create table profiles
(
    id      int auto_increment primary key,
    user_id int,
    constraint profiles_user_id_foreign foreign key (user_id) references users(id) on delete cascade
);
create table films
(
    id           int auto_increment
        primary key,
    name         varchar(255) not null,
    description  text         null,
    age_min      int          null,
    duration     int          null,
    release_year int          null,
    trailer      varchar(255) null
);

/**
  * Inserting default data
**/

insert into subscription_types(name)
values ('for 1'),
       ('for 2'),
       ('for 4');

