
create table tb_user (id bigserial not null, login varchar(255) not null, password varchar(255) not null, primary key (id));

INSERT INTO tb_user (login, password) VALUES ('user1', 'pass1');