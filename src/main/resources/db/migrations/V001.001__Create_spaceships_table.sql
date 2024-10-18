CREATE TABLE spaceships
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255),
    captain_name VARCHAR(255),
    length       DOUBLE PRECISION,
    max_speed    INTEGER,
    appears_in   VARCHAR(255)
);