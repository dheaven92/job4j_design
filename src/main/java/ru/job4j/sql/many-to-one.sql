create table genres (
	id serial primary key,
	name varchar (255)
);

create table movies (
	id serial primary key,
	name varchar (255),
	genre_id int references genres (id)
);
