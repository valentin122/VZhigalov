create table bank(
    id serial primary key,
    name varchar(50)
);

create table countries(
    id serial primary key,
    bank_id int references bank(id),
    people_id int references people(id)
);

create table people(
    id serial primary key,
    name varchar(50)
);