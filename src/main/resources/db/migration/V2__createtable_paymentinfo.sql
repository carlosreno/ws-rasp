create table if not exists user_paymente_info(
                                                 id bigserial not null
                                                     primary key,
                                                 card_expiration_month bigint,
                                                 card_expiration_year  bigint,
                                                 card_number           varchar(255),
                                                 card_security_code    varchar(255),
                                                 dt_payment            date,
                                                 price                 numeric(38, 2),
                                                 user_id               bigint
                                                     constraint  fkqxrbl4a9890d2n19l08668f5q
                                                         references users
);

