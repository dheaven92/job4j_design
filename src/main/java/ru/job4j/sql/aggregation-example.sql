select avg(price) from devices;

select p.name, avg(d.price) as avg_device_price from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price) as avg_device_price from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;