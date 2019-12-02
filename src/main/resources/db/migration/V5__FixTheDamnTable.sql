DROP TABLE healthserver.users;


CREATE TABLE IF NOT EXISTS healthserver.users (
    id SERIAL,
    email VARCHAR(255) NOT NULL UNIQUE,
    passkey varchar(255) NOT NULL
);