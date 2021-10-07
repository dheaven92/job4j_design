create table dogs (
	id serial primary key,
	breed varchar(255),
	is_allergic boolean,
	average_life_expectancy int,
	short_description text
);

insert into dogs (breed, is_allergic, average_life_expectancy, short_description)
values ('Poodle', false, 14, 'Poodles are extremely intelligent and are easily trained.');

update dogs set average_life_expectancy = 15;

delete from dogs;
