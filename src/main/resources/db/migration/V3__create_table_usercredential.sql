create table if not exists user_credential(
                                              id bigserial not null
                                                  primary key,
                                              user_name  varchar(255),
                                              password varchar(255),
                                              user_type int
);
alter table user_credential add CONSTRAINT "user_type_id_creden" FOREIGN KEY(user_type) references user_type(user_type_id);