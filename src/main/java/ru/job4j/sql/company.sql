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

-- to get all possible companies with the same max people count
with _ranked_groups as (
    with _groups as (
        select c.name as company_name, count(*) as people_count
        from company c
                 join person p
                      on c.id = p.company_id
        group by c.name
    )
    select company_name,
           people_count,
           rank() over (order by people_count desc) as rank
    from _groups
)
select company_name, people_count
from _ranked_groups
where rank = 1;