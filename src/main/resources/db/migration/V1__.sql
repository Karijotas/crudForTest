CREATE TABLE meal
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name          VARCHAR(255),
    description   VARCHAR(255),
    price         DECIMAL                                 NOT NULL,
    menu_id       BIGINT,
    order_id      BIGINT,
    amount        BIGINT,
    imageurl      VARCHAR(255),
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    VARCHAR(255),
    modified_by   VARCHAR(255),
    CONSTRAINT pk_meal PRIMARY KEY (id)
);

ALTER TABLE meal
    ADD CONSTRAINT FK_MEAL_ON_MENU FOREIGN KEY (menu_id) REFERENCES menu (id);

ALTER TABLE meal
    ADD CONSTRAINT FK_MEAL_ON_ORDER FOREIGN KEY (order_id) REFERENCES "order" (id);