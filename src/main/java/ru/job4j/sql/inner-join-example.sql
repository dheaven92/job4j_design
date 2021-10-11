create table statuses (
    id serial primary key,
    name varchar (255)
);

create table tickets (
    id serial primary key,
    created timestamp default now(),
    title varchar (255),
    status_id int references statuses (id)
);

insert into statuses (name) values ('open');
insert into statuses (name) values ('closed');

insert into tickets (title, status_id) values ('stop spamming me', 1);
insert into tickets (title, created, status_id) values ('delete my account', '2021-10-10', 1);
insert into tickets (title, status_id) values ('pls make a reservation copy of my messages in the last month', 2);

select t.title as ticket_title from tickets as t
join statuses as s
on t.status_id = s.id
where s.name = 'open';

select t.title as ticket_title from tickets as t
join statuses as s
on t.status_id = s.id
where s.name = 'closed';

select t.title as ticket_title, s.name as current_status from tickets as t
join statuses as s
on t.status_id = s.id
where t.created <= '2021-10-10';