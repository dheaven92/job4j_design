create table imdb_pages (
	id serial primary key,
	url text
);

create table actors_imdb_pages (
	id serial primary key,
	actor_id int references actors (id) unique,
	imdb_page_id int references imdb_pages (id) unique
);