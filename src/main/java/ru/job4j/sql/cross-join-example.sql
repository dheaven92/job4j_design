create table teens (
    id serial primary key,
    name varchar (255),
    gender varchar (10)
);

insert into teens (name, gender) values ('Anna', 'female');
insert into teens (name, gender) values ('Lena', 'female');
insert into teens (name, gender) values ('Maria', 'female');
insert into teens (name, gender) values ('Sam', 'male');
insert into teens (name, gender) values ('Thomas', 'male');

-- with duplicates
select * from teens t1 cross join teens t2 where t1.gender != t2.gender;

-- without duplicates
select females.name as female, males.name as male
from (select * from teens where gender = 'female') as females
cross join (select * from teens where gender = 'male') as males;