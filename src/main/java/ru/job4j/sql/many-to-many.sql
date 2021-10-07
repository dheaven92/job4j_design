create table actors (
	id serial primary key,
	name varchar (255),
	age int
);

create table movies_actors (
	id serial primary key,
	movie_id int references movies (id),
	actor_id int references actors (id)
);