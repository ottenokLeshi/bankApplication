CREATE TABLE client (
  id         SERIAL NOT NULL PRIMARY KEY,
  first_name VARCHAR,
  last_name  VARCHAR DEFAULT NULL,
  email      VARCHAR DEFAULT NULL
);

CREATE TABLE account (
  id        SERIAL NOT NULL PRIMARY KEY,
  client_id BIGINT REFERENCES client(id) ON DELETE CASCADE,
  balance   BIGINT
);

CREATE TABLE transaction (
  id        SERIAL NOT NULL PRIMARY KEY,
  type SMALLINT,
  account_id BIGINT REFERENCES account(id) ON DELETE CASCADE,
  summ BIGINT,
  time TIMESTAMP,
  target_account_id BIGINT REFERENCES account(id) ON DELETE CASCADE
);