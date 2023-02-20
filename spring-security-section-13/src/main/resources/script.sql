drop table users ;
drop table authorities ;
drop table customer ;

CREATE SEQUENCE customer_seq;
CREATE TABLE  customer  (
                            customer_id  INT PRIMARY KEY DEFAULT nextval('customer_seq'),
                            name  varchar(100) NOT NULL,
                            email  varchar(100) NOT NULL,
                            mobile_number  varchar(20) NOT NULL,
                            password  varchar(500) NOT NULL,
                            role  varchar(100) NOT NULL,
                            create_dt  date DEFAULT NULL
);

INSERT INTO  customer  ( name , email , mobile_number ,  password ,  role , create_dt )
VALUES ('Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',now());

CREATE SEQUENCE accounts_seq;
CREATE TABLE  accounts  (
                            customer_id  int NOT NULL,
                            account_number  BIGINT PRIMARY KEY DEFAULT nextval('accounts_seq'),
                            account_type  varchar(100) NOT NULL,
                            branch_address  varchar(200) NOT NULL,
                            create_dt  date DEFAULT NULL,
--                             PRIMARY KEY ( account_number ),
--                             KEY customer_id  ( customer_id ),
                            CONSTRAINT  customer_ibfk_1  FOREIGN KEY ( customer_id ) REFERENCES  customer  ( customer_id ) ON DELETE CASCADE
);

INSERT INTO  accounts  ( customer_id ,  account_number ,  account_type ,  branch_address ,  create_dt )
VALUES (1, 186576453434, 'Savings', '123 Main Street, New York', now());

CREATE TABLE  account_transactions  (
                                        transaction_id  uuid DEFAULT gen_random_uuid() PRIMARY KEY,
                                        account_number  bigint NOT NULL,
                                        customer_id  int NOT NULL,
                                        transaction_dt  date NOT NULL,
                                        transaction_summary  varchar(200) NOT NULL,
                                        transaction_type  varchar(100) NOT NULL,
                                        transaction_amt  int NOT NULL,
                                        closing_balance  int NOT NULL,
                                        create_dt  date DEFAULT NULL,
--                                         KEY  customer_id  ( customer_id ),
--                                         KEY  account_number  ( account_number ),
                                        CONSTRAINT  accounts_ibfk_2  FOREIGN KEY ( account_number ) REFERENCES  accounts  ( account_number ) ON DELETE CASCADE,
                                        CONSTRAINT  acct_user_ibfk_1  FOREIGN KEY ( customer_id ) REFERENCES  customer  ( customer_id ) ON DELETE CASCADE
);



INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '7 day', 'Coffee Shop', 'Withdrawal', 30,34500, current_date - INTERVAL '7 day');

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '6 day', 'Uber', 'Withdrawal', 100,34400, current_date - INTERVAL '6 day');

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '5 day', 'Self Deposit', 'Deposit', 500,34900, current_date - INTERVAL '5 day');

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '4 day', 'Ebay', 'Withdrawal', 600,34300, current_date - INTERVAL '4 day');

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '2 day', 'OnlineTransfer', 'Deposit', 700,35000, current_date - INTERVAL '2 day');

INSERT INTO  account_transactions  ( transaction_id ,  account_number ,  customer_id ,  transaction_dt ,  transaction_summary ,  transaction_type , transaction_amt ,
                                     closing_balance ,  create_dt )  VALUES (gen_random_uuid(), 186576453434, 1, current_date - INTERVAL '1 day', 'Amazon.com', 'Withdrawal', 100,34900, current_date - INTERVAL '1 day');

CREATE SEQUENCE loans_seq;
CREATE TABLE  loans  (
                          loan_number  INT PRIMARY KEY DEFAULT nextval('loans_seq'),
                          customer_id  int NOT NULL,
                          start_dt  date NOT NULL,
                          loan_type  varchar(100) NOT NULL,
                          total_loan  int NOT NULL,
                          amount_paid  int NOT NULL,
                          outstanding_amount  int NOT NULL,
                          create_dt  date DEFAULT NULL,
--                          PRIMARY KEY ( loan_number ),
--                          KEY  customer_id  ( customer_id ),
                         CONSTRAINT  loan_customer_ibfk_1  FOREIGN KEY ( customer_id ) REFERENCES  customer  ( customer_id ) ON DELETE CASCADE
);

INSERT INTO  loans  (  customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO  loans  (  customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO  loans  (  customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
VALUES ( 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO  loans  (  customer_id ,  start_dt ,  loan_type ,  total_loan ,  amount_paid ,  outstanding_amount ,  create_dt )
VALUES ( 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

CREATE SEQUENCE cards_seq;
CREATE TABLE  cards  (
                          card_id  INT PRIMARY KEY DEFAULT nextval('cards_seq'),
                          card_number  varchar(100) NOT NULL,
                          customer_id  int NOT NULL,
                          card_type  varchar(100) NOT NULL,
                          total_limit  int NOT NULL,
                          amount_used  int NOT NULL,
                          available_amount  int NOT NULL,
                          create_dt  date DEFAULT NULL,
--                          PRIMARY KEY ( card_id ),
--                          KEY  customer_id  ( customer_id ),
                         CONSTRAINT  card_customer_ibfk_1  FOREIGN KEY ( customer_id ) REFERENCES  customer  ( customer_id ) ON DELETE CASCADE
);

INSERT INTO  cards  ( card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, now());

INSERT INTO  cards  ( card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, now());

INSERT INTO  cards  ( card_number ,  customer_id ,  card_type ,  total_limit ,  amount_used ,  available_amount ,  create_dt )
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, now());

CREATE SEQUENCE notice_details_seq;
CREATE TABLE  notice_details  (
                                notice_id  INT PRIMARY KEY DEFAULT nextval('notice_details_seq'),
                                notice_summary  varchar(200) NOT NULL,
                                notice_details  varchar(500) NOT NULL,
                                notic_beg_dt  date NOT NULL,
                                notic_end_dt  date DEFAULT NULL,
                                create_dt  date DEFAULT NULL,
                                update_dt  date DEFAULT NULL
--                                 PRIMARY KEY ( notice_id )
);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);

INSERT INTO  notice_details  (  notice_summary ,  notice_details ,  notic_beg_dt ,  notic_end_dt ,  create_dt ,  update_dt )
VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        current_date - INTERVAL '30 day', current_date + INTERVAL '30 day', now(), null);


CREATE TABLE  contact_messages  (
                                    contact_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
                                    contact_name  varchar(50) NOT NULL,
                                    contact_email  varchar(100) NOT NULL,
                                    subject  varchar(500) NOT NULL,
                                    message  varchar(2000) NOT NULL,
                                    create_dt  date DEFAULT NULL
--                                     PRIMARY KEY ( contact_id )
);

DROP TABLE contact_messages;
DROP TABLE notice_details;
DROP TABLE cards;
DROP TABLE loans;
DROP TABLE account_transactions;
DROP TABLE accounts;
DROP TABLE customer;

CREATE SEQUENCE authorities_seq;
CREATE TABLE authorities (
                               id INT PRIMARY KEY DEFAULT nextval('authorities_seq'),
                               customer_id int NOT NULL,
                               name varchar(50) NOT NULL,
                               CONSTRAINT authorities_ibfk_1
                                   FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWACCOUNT');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWCARDS');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWLOANS');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWBALANCE');

DELETE FROM authorities;

INSERT INTO authorities (customer_id, name)
VALUES (1, 'ROLE_USER');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'ROLE_ADMIN');