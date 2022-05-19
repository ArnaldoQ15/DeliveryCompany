CREATE TABLE delivery (
        id SERIAL PRIMARY KEY,
        client_id SERIAL NOT NULL,
        tax decimal(10,2) not null,
        status VARCHAR(20) NOT NULL,
        request_date date NOT NULL,
        request_date_finished date,

        recipient_name varchar(60) NOT NULL,
        recipient_street varchar(255) NOT NULL,
        recipient_number varchar(30) NOT NULL,
        recipient_complement varchar(60),
        recipient_district varchar(40) NOT NULL
);

ALTER TABLE delivery
        ADD CONSTRAINT fk_delivery_client
        FOREIGN KEY (client_id)
        REFERENCES clients (id)
;