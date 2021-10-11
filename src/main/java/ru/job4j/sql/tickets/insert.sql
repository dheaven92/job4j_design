insert into roles (name) values ('ADMIN');
insert into roles (name) values ('MANAGER');
insert into roles (name) values ('USER');

insert into rules (name) values ('CREATE');
insert into rules (name) values ('UPDATE');
insert into rules (name) values ('DELETE');
insert into rules (name) values ('VIEW');
insert into rules (name) values ('COMMENT');
insert into rules (name) values ('ATTACH');

insert into roles_rules (role_id, rule_id) values (1, 1);
insert into roles_rules (role_id, rule_id) values (1, 2);
insert into roles_rules (role_id, rule_id) values (1, 3);
insert into roles_rules (role_id, rule_id) values (1, 4);
insert into roles_rules (role_id, rule_id) values (1, 5);
insert into roles_rules (role_id, rule_id) values (1, 6);
insert into roles_rules (role_id, rule_id) values (2, 2);
insert into roles_rules (role_id, rule_id) values (2, 4);
insert into roles_rules (role_id, rule_id) values (2, 5);
insert into roles_rules (role_id, rule_id) values (2, 6);
insert into roles_rules (role_id, rule_id) values (3, 4);
insert into roles_rules (role_id, rule_id) values (3, 5);
insert into roles_rules (role_id, rule_id) values (3, 6);

insert into users (name, email, role_id) values ('Alex', 'alex@mail.com', 1);
insert into users (name, email, role_id) values ('Daniel', 'danny91@mail.com', 1);
insert into users (name, email, role_id) values ('Samuel Wilson', 'sam.wilson@mail.com', 2);
insert into users (name, email, role_id) values ('Agent007', 'agent007@mail.com', 2);
insert into users (name, email, role_id) values ('CatLover', 'ilovecats@mail.com', 3);
insert into users (name, email, role_id) values ('John K.', 'johnny.keylow@mail.com', 3);
insert into users (name, email, role_id) values ('Leo Di', 'leo.craft@mail.com', 3);

insert into categories (name) values ('accessing posts');
insert into categories (name) values ('commenting posts');
insert into categories (name) values ('spam');

insert into states (name) values ('ISSUE');
insert into states (name) values ('POSTPONED');
insert into states (name) values ('DONE');

insert into items (title, description, user_id, category_id, state_id)
values ('Can''t access my own post!', 'I published my post 2 hrs ago, and can''t access it now. Fix it ASAP!!!', 5, 1, 1);
insert into items (title, description, user_id, category_id, state_id)
values ('I get spam from your site to my email', 'I get spam from your site to my email, see scr. in attaches', 7, 3, 3);

insert into attaches (path, item_id) values ('/users/screens/issue_item_id_2_at_11.10.2021:12:59.png', 2);

insert into comments (body, item_id)
values ('Thank you for reaching out our support. We will answer you shortly. Have a nice day!', 1);