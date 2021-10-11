-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product where type_id = (select id from type where name = 'СЫР');

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product where name like '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select * from product where expired_date < now();

-- 4. Написать запрос, который выводит самый дорогой продукт.
select * from product order by price desc limit 1;

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
-- В виде имя_типа, количество
select t.name as имя_типа, count(*) as количество from product as p
join type as t
on p.type_id = t.id
group by t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.* from product as p
join type as t
on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
-- Под количеством подразумевается количество продуктов определенного типа.
-- Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
-- которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
select t.name as type from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(*) < 10;

-- 8. Вывести все продукты и их тип.
select p.*, t.name as type from product as p
join type as t
on p.type_id = t.id