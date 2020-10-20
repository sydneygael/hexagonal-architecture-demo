DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL
);

CREATE TABLE users (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  money DOUBLE NOT NULL
);

INSERT INTO products (description,price) VALUES
  ('oeuf',2),
  ('lait',2.5),
  ('gateau',5);

INSERT INTO users (name,email,money) VALUES
  ('dangote','dangote@example.com',2000),
  ('sydney','sydney@example.com',10);