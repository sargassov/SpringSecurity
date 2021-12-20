create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table authorities (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_authorities (
  user_id               bigint not null,
  authorities_id        int not null,
  primary key (user_id, authorities_id),
  foreign key (user_id) references users (id),
  foreign key (authorities_id) references authorities (id)
);

insert into authorities (name)
values
('ENTER_TO_ADMIN'), ('LOOK_USER_INFO'), ('LOOK_HOME_PAGE');

insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('user2', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user2@gmail.com');

insert into users_authorities (user_id, authorities_id)
values
(1, 2), (1, 3), (2, 1), (2, 2), (2, 3);