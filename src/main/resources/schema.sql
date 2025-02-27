drop table if exists ingredient_collection;
drop table if exists ingredient;
drop table if exists taco;
drop table if exists taco_order;
drop table if exists users;


drop sequence if exists TACO_ORDER_SEQ;
drop sequence if exists TACO_SEQ;
drop sequence if exists USERS_SEQ;

create sequence TACO_ORDER_SEQ iNCREMENT BY 50;
create sequence TACO_SEQ iNCREMENT BY 50;
create sequence USERS_SEQ START WITH 1 INCREMENT BY 50;

CREATE TABLE if not exists taco_order
(
    id              SERIAL PRIMARY KEY,
    cc_cvv          VARCHAR(3)  NOT NULL,
    cc_expiration   VARCHAR(5)  NOT NULL,
    cc_number       VARCHAR(16) NOT NULL,
    delivery_City   VARCHAR(50) NOT NULL,
    delivery_Name   VARCHAR(50) NOT NULL,
    delivery_State  VARCHAR(2)  NOT NULL,
    delivery_Street VARCHAR(50) NOT NULL,
    delivery_Zip    VARCHAR(10) NOT NULL,
    placed_at       TIMESTAMP   NOT NULL
);

CREATE TABLE if not exists taco
(
    id                  SERIAL PRIMARY KEY,
    created_at          TIMESTAMP   NOT NULL,
    name                VARCHAR(50) NOT NULL,
    ref_to_taco_order   bigint      NOT NULL REFERENCES Taco_Order (id),
    taco_order_by_order bigint      NOT NULL
);

CREATE TABLE if not exists ingredient
(
    id   VARCHAR(4)  NOT NULL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    TYPE VARCHAR(10) NOT NULL
);

CREATE TABLE if not exists ingredient_collection
(
    ref_to_ingredient VARCHAR(4) NOT NULL REFERENCES Ingredient (id), /* defaut ingredient*/
    ref_to_taco       bigint     NOT NULL REFERENCES taco (id), /*defaut taco*/
    taco_by_order     bigint     NOT NULL /* defaut taco_key*/
);


CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR,
    password     VARCHAR,
    fullname     VARCHAR,
    street       VARCHAR,
    city         VARCHAR,
    state        VARCHAR,
    zip          VARCHAR,
    phone_number VARCHAR
);