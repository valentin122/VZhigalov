create table users(
    id serial primary key,
	name text,
	heigth integer,
	sex varchar(50)
);

insert into users(name, heigth, sex)
  values('Valentin', 150, 'male');

update users set heigth = 152 where id = 1;

delete from users where id = 1;