/* Formatted on 12/11/2024 12:01:04 (QP5 v5.360) */
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
/* Formatted on 12/11/2024 12:22:10 (QP5 v5.360) */
CREATE TABLE if not       exists             Taco
(
    id                identity /* PRIMARY KEY*/,
    created_at        TIMESTAMP NOT NULL,
    name              VARCHAR (50) NOT NULL,
    taco_order        bigint NOT NULL REFERENCES Taco_Order (id),
    taco_order_key    bigint NOT NULL
    );

/* Formatted on 12/11/2024 12:07:14 (QP5 v5.360) */
CREATE TABLE if not    exists  Ingredient
(
    id      VARCHAR (4) NOT NULL PRIMARY KEY ,
    name    VARCHAR (25) NOT NULL,
    TYPE    VARCHAR (10) NOT NULL
    );

/* Formatted on 12/11/2024 12:30:51 (QP5 v5.360) */
CREATE TABLE if not    exists       Ref_To_Ingredient
(
    ingredient    VARCHAR (4) NOT NULL REFERENCES Ingredient (id),
    taco          bigint NOT NULL REFERENCES taco (id),
    taco_key      bigint NOT NULL
    );
