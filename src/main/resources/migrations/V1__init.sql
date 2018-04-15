CREATE TABLE client (
  id         SERIAL  NOT NULL PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name  VARCHAR DEFAULT NULL,
  email      VARCHAR DEFAULT NULL
);

CREATE TABLE account (
  id        SERIAL NOT NULL PRIMARY KEY,
  client_id BIGINT NOT NULL REFERENCES client(id),
  balance   BIGINT NOT NULL
);

CREATE TABLE transaction (
  id        SERIAL NOT NULL PRIMARY KEY,
  type SMALLINT NOT NULL,
  account_id BIGINT NOT NULL REFERENCES account(id),
  summ BIGINT NOT NULL,
  time TIMESTAMP,
  target_account_id BIGINT REFERENCES account(id)
);