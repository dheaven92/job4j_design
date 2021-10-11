create table departments (
    id serial primary key,
    name varchar (255)
);

create table employees (
    id serial primary key,
    name varchar (255),
    department_id int references departments (id)
);

insert into departments (name) values ('development');
insert into departments (name) values ('support');
insert into departments (name) values ('accounting');
insert into departments (name) values ('cleaning');

insert into employees (name, department_id) values ('Sammy', 1);
insert into employees (name, department_id) values ('Anna', 1);
insert into employees (name, department_id) values ('Joe', 2);
insert into employees (name, department_id) values ('Jason', 2);
insert into employees (name, department_id) values ('Sam', 2);
insert into employees (name, department_id) values ('Lex', 3);

select * from departments as d
left join employees as e
on d.id = e.department_id
where e.department_id is null;

select e.id as employee_id,
       e.name as employee_name,
       d.id as department_id,
       d.name as department_name
from departments as d
left join employees as e
on d.id = e.department_id;

select e.id as employee_id,
       e.name as employee_name,
       d.id as department_id,
       d.name as department_name
from employees as e
right join departments as d
on e.department_id = d.id;