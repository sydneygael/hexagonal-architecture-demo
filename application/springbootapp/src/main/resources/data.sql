DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL
);

INSERT INTO products (description) VALUES
  ('oeuf'),
  ('lait'),
  ('gateau');