create table if not exists subcription_type
(
    id bigserial
        primary key,
    acess_month bigint,
    name        varchar(255),
    price       numeric(38, 2),
    prud_key    varchar(255)
        constraint uk_e74ipp0y9r12cfvrrhu5mnkvf
            unique
);
create table if not exists user_type
(
    user_type_id bigserial not null
        primary key,
    description  varchar(255),
    name         varchar(255)
);

create table if not exists users(
    user_id              bigserial
        primary key,
    cpf                  varchar(255)
        constraint uk_7kqluf7wl0oxs7n90fpya03ss
            unique,
    dt_expiration        date,
    dt_subcription       date,
    email                varchar(255),
    name                 varchar(255),
    phone                varchar(255),
    subscription_type_id bigint
        constraint fkry9mmnp0kyyl05475oy16cn6r
            references subcription_type,
    user_type_id         bigint
        constraint fk4xtohlhi44dbeapdfdn3xah6k
            references user_type
);

