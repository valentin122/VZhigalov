create table cities(
    id serial primary key,
    name varchar(50)
);

create table countries(
    id serial primary key,
    name varchar(50),
    position_id int references cities(id)
);