-- bank.customer definition

-- Drop table

-- DROP TABLE bank.customer;

CREATE TABLE bank.customer (
	customer_id serial NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	gender varchar NOT NULL,
	address varchar NOT NULL,
	phone int8 NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (customer_id),
	CONSTRAINT customer_un UNIQUE (email)
);

CREATE TABLE bank.employee (
	employee_id serial NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (employee_id),
	CONSTRAINT employee_un UNIQUE (email)
);

CREATE TABLE bank.account (
	account_id int4 NOT NULL,
	customer_id int4 NOT NULL,
	account_type varchar NULL,
	balance float8 NULL,
	CONSTRAINT account_pk PRIMARY KEY (account_id)
);


-- bank.account foreign keys

ALTER TABLE bank.account ADD CONSTRAINT account_fk FOREIGN KEY (customer_id) REFERENCES bank.customer(customer_id);

CREATE TABLE bank."transaction" (
	transaction_id serial NOT NULL,
	account_id int4 NOT NULL,
	customer_id int4 NOT NULL,
	"date" date NOT NULL,
	description varchar NOT NULL,
	"type" varchar NOT NULL,
	amount float8 NOT NULL,
	balance float8 NOT NULL,
	CONSTRAINT transaction_pk PRIMARY KEY (transaction_id)
);


-- bank."transaction" foreign keys

ALTER TABLE bank."transaction" ADD CONSTRAINT transaction_fk FOREIGN KEY (account_id) REFERENCES bank.account(account_id);
