CREATE TABLE cars
(
    id BIGSERIAL PRIMARY KEY,
    manufacturer VARCHAR(255),
    year VARCHAR(255),
    model VARCHAR(255),
    price integer,
    kmtraveled integer,
    info VARCHAR(255)
);