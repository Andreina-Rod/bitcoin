DROP TABLE IF EXISTS bitcoin;

CREATE TABLE bitcoin (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  last_price FLOAT DEFAULT  NULL,
  currency1 VARCHAR(250) DEFAULT NULL,
  currency2 VARCHAR(250) DEFAULT NULL,
  modified_date TIMESTAMP
);
