
insert into coffee_house(coffee, desert, work_schedule, type_of_coffee)
values ('coffee1', 'desert1', 'some work schedule1', 'kapuchino1');

insert into coffee_house(coffee, desert, work_schedule, type_of_coffee)
values ('coffee2', 'desert2', 'some work schedule2', 'kapuchino2');

insert into coffee_house(coffee, desert, work_schedule, type_of_coffee)
values ('coffee3', 'desert3', 'some work schedule3', 'kapuchino3');

update coffee_house
set work_schedule = 'some schedule for Tuesday'
where coffee = 'coffee1';

update coffee_house
set type_of_coffee='kapuchino33'
where coffee='coffee3';

update coffee_house
set coffee='salemCoffee'
where work_schedule='some schedule for Tuesday';

update coffee_house
set desert='desertpromax'
where type_of_coffee='kapuchino33';

delete from coffee_house
where coffee='coffee1';

delete from coffee_house
where desert='desert1';

delete from coffee_house
where work_schedule='some work schedule2';

delete from coffee_house
where type_of_coffee='kapuchino2';

select * from coffee_house
where coffee='coffee1';

select * from coffee_house
where desert='desert1';

select * from coffee_house
where work_schedule='some work schedule2';

select * from coffee_house
where type_of_coffee='kapuchino2';

insert into coffee_house(coffee, desert, work_schedule, type_of_coffee)
values ('top-coffee', 'desert-top', 'some top-work schedules', 'top-type-coffee');

delete from coffee_house
where coffee='top-coffee';

update coffee_house
set coffee='top-pro-max-coffee'
where desert='desert-top';


