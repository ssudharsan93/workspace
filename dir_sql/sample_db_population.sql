/*

db_fiddle.com

Sample Queries

        SELECT product, FirstName, LastName FROM orders INNER JOIN customers ON customers.customer_id = orders.customer_id;
        SELECT FirstName, LastName FROM customers WHERE customer_id IN (
            SELECT customer_id FROM orders
        );
        
        SELECT product FROM customers RIGHT JOIN orders ON customers.customer_id = orders.order_id
        SELECT product, FirstName, LastName FROM customers LEFT JOIN orders ON customers.customer_id = orders.order_id
        SELECT FirstName, LastName FROM customers LEFT JOIN orders ON customers.customer_id = orders.order_id
        
        SELECT * FROM customers LEFT OUTER JOIN orders ON customers.customer_id = orders.order_id 
        UNION
        SELECT * FROM customers RIGHT OUTER JOIN orders ON customers.customer_id = orders.order_id;
        
        SELECT product, FirstName, LastName FROM customers, orders WHERE customers.customer_id = orders.customer_id;
        
*/

CREATE TABLE customers (
  id INT,
  FirstName varchar(255),
  LastName varchar(255),
  customer_id varchar(255)
);

CREATE TABLE orders (
  product varchar(255),
  order_id varchar(255),
  customer_id varchar(255)
 );

INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Shabaz', 'Thorpe', 'QrXVdaT3qK');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Susanna', 'Sanderson', 'lAZNvFNYi-');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Mysha', 'Wormald', 'E0Kt6wQ-YS');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Nylah', 'Plummer', 'WsSwLkY7l-');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'John-James', 'Shea', 'UQYSesRbH2');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Anniyah', 'Swanson', '6i7o2r952N');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Fatima', 'Hayes', '-dR58gNYhE');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Vincent', 'Rooney', 'oIgsQTxcRb');
INSERT INTO customers (id, FirstName, LastName, customer_id) VALUES (1, 'Rory', 'Cotton', 'G2WDR1Comb');


INSERT INTO orders (product, order_id, customer_id) VALUES ('Sofa', '1stqVl6cnt', 'QrXVdaT3qK');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Sofa', '1stqVl6cnt', 'E0Kt6wQ-YS');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Sofa', '1stqVl6cnt', 'UQYSesRbH2');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Sofa', '1stqVl6cnt', '-dR58gNYhE');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Computer', 'adfHz3R-_T', 'WsSwLkY7l-');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Computer', 'adfHz3R-_T', 'UQYSesRbH2');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Keyboard', 'RcCY2hSJne', 'WsSwLkY7l-');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Keyboard', 'RcCY2hSJne', 'UQYSesRbH2');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Desk', 'Gnuq0RjiUL', 'WsSwLkY7l-');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Desk', 'Gnuq0RjiUL', 'UQYSesRbH2');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Desk', 'Gnuq0RjiUL', 'G2WDR1Comb');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Desk', 'Gnuq0RjiUL', 'E0Kt6wQ-YS');
INSERT INTO orders (product, order_id, customer_id) VALUES ('Desk', 'Gnuq0RjiUL', 'oIgsQTxcRb');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', 'oIgsQTxcRb');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', 'E0Kt6wQ-YS');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', 'G2WDR1Comb');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', '6i7o2r952N');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', '-dR58gNYhE');
INSERT INTO orders (product, order_id, customer_id) VALUES ('TV', 'sGlUVgzyl0', 'lAZNvFNYi-');
