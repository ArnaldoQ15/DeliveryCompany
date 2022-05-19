CREATE TABLE occurrences (
    id SERIAL PRIMARY KEY,
    delivery_id SERIAL NOT NULL,
    description text NOT NULL,
    register_date timestamp NOT NULL
);

ALTER TABLE occurrences
    ADD CONSTRAINT fk_occurrence_delivery
        FOREIGN KEY (delivery_id)
            REFERENCES delivery (id);