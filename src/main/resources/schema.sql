drop table  if  exists INGREDIENT_COLLECTION;
drop table  if  exists INGREDIENT;
drop table  if  exists TACO;
drop table  if  exists TACO_ORDER;


drop sequence if  exists TACO_ORDER_SEQ;
drop sequence if  exists TACO_SEQ;


create sequence TACO_ORDER_SEQ  iNCREMENT BY 50;
create sequence TACO_SEQ iNCREMENT BY 50;

CREATE TABLE if not    exists       Taco_Order
(
    id                 identity/* PRIMARY KEY*/,
    cc_cvv             VARCHAR (3) NOT NULL,
    cc_expiration      VARCHAR (5) NOT NULL,
    cc_number          VARCHAR (16) NOT NULL,
    delivery_City      VARCHAR (50) NOT NULL,
    delivery_Name      VARCHAR (50) NOT NULL,
    delivery_State     VARCHAR (2) NOT NULL,
    delivery_Street    VARCHAR (50) NOT NULL,
    delivery_Zip       VARCHAR (10) NOT NULL,
    placed_at          TIMESTAMP NOT NULL
);

CREATE TABLE if not       exists             Taco
(
    id                identity /* PRIMARY KEY*/,
    created_at        TIMESTAMP NOT NULL,
    name              VARCHAR (50) NOT NULL,
    ref_to_taco_order    bigint NOT NULL REFERENCES Taco_Order (id) /* Используется за счет  @JoinColumn(name = "REF_TO_TACO_ORDER")*/
);

CREATE TABLE if not    exists  Ingredient
(
    id      VARCHAR (4) NOT NULL PRIMARY KEY ,
    name    VARCHAR (25) NOT NULL,
    TYPE    VARCHAR (10) NOT NULL
);

CREATE TABLE if not    exists       ingredient_collection
(
    ref_to_ingredient   VARCHAR (4) NOT NULL REFERENCES Ingredient (id), /* defaut ingredient*/
    ref_to_taco         bigint NOT NULL REFERENCES taco (id) /*defaut taco*/
);
