CREATE TABLE bank.customer (
	customer_id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	dob varchar NOT NULL,
	gender varchar(1) NOT NULL,
	ssn varchar NOT NULL,
	state_id varchar NOT NULL,
	phone varchar(10) NOT NULL,
	email varchar(50) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

CREATE TABLE bank.account (
	account_id int4 NOT NULL,
	customer_id int4 NOT NULL,
	balance int4 NOT NULL,
	CONSTRAINT account_pk PRIMARY KEY (account_id)
);


-- bank.account foreign keys

ALTER TABLE bank.account ADD CONSTRAINT account_fk FOREIGN KEY (customer_id) REFERENCES bank.customer(customer_id);

CREATE TABLE bank."transaction" (
	transaction_id int4 NOT NULL,
	account_id int4 NOT NULL,
	customer_id int4 NOT NULL,
	"date" date NOT NULL,
	description varchar(30) NOT NULL,
	"type" varchar(10) NOT NULL,
	amount int4 NOT NULL,
	balance int4 NOT NULL,
	CONSTRAINT transaction_pk PRIMARY KEY (transaction_id)
);


-- bank."transaction" foreign keys

ALTER TABLE bank."transaction" ADD CONSTRAINT transaction_fk FOREIGN KEY (account_id) REFERENCES bank.account(account_id);

CREATE TABLE bank.login (
	customer_id int4 NOT NULL,
	pin varchar(4) NOT NULL,
	CONSTRAINT login_pk PRIMARY KEY (customer_id)
);

INSERT INTO bank.customer
(customer_id, first_name, last_name, dob, gender, ssn, state_id, phone, email)
VALUES(1, 'Juan', 'Alcantara', '1/2/90', 'M', '000-00-0000', '000 000 000 ', '6265552222', 'juan231f@yahoo.com');
INSERT INTO bank.customer
(customer_id, first_name, last_name, dob, gender, ssn, state_id, phone, email)
VALUES(2, 'Jissela', 'Murillo', '1/30/90', 'F', '000-00-0001', '000 000 001', '9175553333', 'jissela@gmail.com');
INSERT INTO bank.customer
(customer_id, first_name, last_name, dob, gender, ssn, state_id, phone, email)
VALUES(3, 'Fabidaly', 'Valera', '12/4/06', 'F', '111-11-1111', '111 111 111', '342423333', 'fabidaly@yahoo.com');

INSERT INTO bank.account
(account_id, customer_id, balance)
VALUES(200, 2, 10000);
INSERT INTO bank.account
(account_id, customer_id, balance)
VALUES(300, 3, 550);
INSERT INTO bank.account
(account_id, customer_id, balance)
VALUES(100, 1, 2000);
