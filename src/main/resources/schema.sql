create schema if not exists "taco_step4";


drop table if exists ingredient;

CREATE TABLE if not exists ingredient
(
    id   VARCHAR(4)  NOT NULL PRIMARY KEY,
    name VARCHAR(25) NOT NULL
);
