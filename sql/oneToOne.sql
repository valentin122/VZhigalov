create table car(
    id serial primary key,
    model varchar(50)
);

create table tech_passport(
    id serial primary key,
    number int,
    car_id int references car(id)
);