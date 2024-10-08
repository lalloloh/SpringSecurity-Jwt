CREATE TABLE user(
    id bigint unsigned not null auto_increment primary key,
    uuid varchar(40) not null,
    username varchar(100) not null,
    password varchar(255) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,
    deleted_at timestamp
);