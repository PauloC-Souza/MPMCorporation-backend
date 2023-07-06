CREATE TABLE users (
    id SERIAL integer NOT NULL PRIMARY KEY,
    login TEXT NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    name TEXT NOT NULL,
);