
ALTER TABLE healthserver.users ADD PRIMARY KEY (id);

CREATE TABLE IF NOT EXISTS healthserver.reading_collection (
    id SERIAL primary key ,
    date DATE,
    user_id int REFERENCES healthserver.users (id)
);

CREATE TABLE IF NOT EXISTS healthserver.readings(
    id SERIAL primary key ,
    result_collection_id INT REFERENCES healthserver.reading_collection (id),
    value DOUBLE PRECISION,
    type VARCHAR (255)
)