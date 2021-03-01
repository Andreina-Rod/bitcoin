DROP TABLE IF EXISTS bitcoin;

CREATE TABLE bitcoin (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  last_price FLOAT DEFAULT  NULL,
  currency1 VARCHAR(250) DEFAULT NULL,
  currency2 VARCHAR(250) DEFAULT NULL,
  modified_date TIMESTAMP
);

/*INSERT INTO bitcoin (last_price, currency1, currency2, modified_date) VALUES
  (43906.4, 'BTC', 'USD', CURRENT_TIMESTAMP),
  (44520.6, 'BTC', 'USD', CURRENT_TIMESTAMP),
  (44520.5, 'BTC', 'USD', CURRENT_TIMESTAMP);*/