create table carcases (
    id serial primary key,
    type varchar (255)
);

create table engines (
    id serial primary key,
    type varchar (255)
);

create table transmissions (
    id serial primary key,
    type varchar (255)
);

create table cars (
    id serial primary key,
    name varchar (255) not null,
    carcase_id int references carcases (id) not null,
    engine_id int references engines (id) not null,
    transmission_id int references transmissions (id) not null
);

insert into carcases (type) values ('sedan');
insert into carcases (type) values ('hatchback');
insert into carcases (type) values ('minivan');
insert into carcases (type) values ('van');
insert into carcases (type) values ('suv');
insert into carcases (type) values ('pickup');
insert into carcases (type) values ('sport');

insert into engines (type) values ('gasoline');
insert into engines (type) values ('gas');
insert into engines (type) values ('diesel');

insert into transmissions (type) values ('manual');
insert into transmissions (type) values ('automatic');

insert into cars (name, carcase_id, engine_id, transmission_id) values ('Citroen Berlingo', 3, 1, 1);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Volkswagen Transporter', 3, 1, 1);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Ford Transit Connect', 3, 1, 2);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Hyundai Solaris', 1, 2, 2);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Volkswagen Polo', 1, 1, 2);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Lada Vesta', 1, 1, 1);
insert into cars (name, carcase_id, engine_id, transmission_id) values ('Ford F-150', 6, 3, 1);

select cars.name as name,
       c.type as carcase,
       e.type as engine,
       t.type as transmission
from cars
join carcases c on cars.carcase_id = c.id
join engines e on cars.engine_id = e.id
join transmissions t on t.id = cars.transmission_id;

select type as carcase_type from carcases
left join cars on carcases.id = cars.carcase_id
where name is null;

select type as engine_type from engines
left join cars on engines.id = cars.engine_id
where name is null;

select type as transmission_type from transmissions
left join cars on transmissions.id = cars.transmission_id
where name is null;