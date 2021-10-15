select p.name, c.name from person p
join company c
on p.company_id = c.id
where c.id != 5;

select c.name as company_name, count(*) as people_count from company c
join person p
on c.id = p.company_id
group by c.name
order by people_count desc
limit 1;