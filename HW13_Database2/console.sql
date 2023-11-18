/*
 Задание 1
Измените базу данных «Кофейня» таким образом,
чтобы это была сеть кофеен.
Добавьте необходимые таблицы и данные. Обратите
внимание, что ассортимент и цены кофеен могут отличаться друг от друга.
 */

INSERT INTO "CoffeeShops" (coffee_shop_id, coffee_shop_name, location)
VALUES
    (1, 'Central Perk', 'New York'),
    (2, 'Café de Paris', 'Paris'),
    (3, 'Espresso Haven', 'London');

INSERT INTO public."CoffeeStaff" (employee_id, coffee_shop_id)
VALUES
    (101, 1),
    (102, 2),
    (103, 3);

INSERT INTO public."CoffeeMenu" (coffee_menu_id, coffee_shop_id)
VALUES
    (201, 1),
    (202, 2),
    (203, 3);

INSERT INTO public."CoffeePrice" (coffee_price_id, coffee_menu_id, coffee_price, coffee_name)
VALUES
    (301, 201, 3.99, 'House Blend'),
    (302, 202, 4.50, 'French Roast'),
    (303, 203, 4.25, 'London Fog');

update "CoffeePrice"
    set coffee_name='London Fog'
where coffee_price_id=303;

INSERT INTO public."DesertPrice" (desert_price_id, coffee_menu_id, desert_price, desert_name)
VALUES
    (401, 201, 5.99, 'Chocolate Cake'),
    (402, 202, 6.50, 'Cheesecake'),
    (403, 203, 5.75, 'Brownie');

update "DesertPrice"
    set desert_name='Brownie'
where desert_price_id=403;


INSERT INTO public."DrinksPrice" (drinks_price_id, coffee_menu_id, drinks_price, drinks_name)
VALUES
    (504, 201, 2.49, 'Espresso'),
    (505, 202, 2.99, 'Latte'),
    (506, 203, 2.75, 'Cappuccino');

update "DrinksPrice"
    set drinks_name='Cappuccino'
where drinks_price_id=503;

INSERT INTO public."Bartender" (bartender_id, bartender_name)
VALUES
    (101, 'Tom the Bartender'),
    (102, 'Marie the Mixologist'),
    (103, 'Sophia the Shaker');

INSERT INTO public."Waiter" (waiter_id, waiter_name)
VALUES
    (101, 'Rachel Green'),
    (102, 'Michael the Server'),
    (103, 'Joey Tribbiani');


/*
Задание 2
Добавьте к базе данных «Кофейня» следующие триггеры:
■ При удалении напитка вносить информацию о нём
в архивную таблицу;
 */

create or replace function archive_deleted_drink()
returns trigger as $$
    BEGIN
        insert into "Archive" (items)
        values (old.drinks_name);
        return old;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_archive_deleted_drink
    AFTER DELETE ON "DrinksPrice"
    FOR EACH ROW
    WHEN (OLD.drinks_name IS NOT NULL)
EXECUTE procedure archive_deleted_drink();

delete from "DrinksPrice"
where drinks_name='Espresso';

/*
 ■ При удалении десерта вносить информацию о нём
в архивную таблицу;
 */

create or replace function archive_deleted_desert()
returns trigger as $$
    BEGIN
        insert into "Archive"(items)
        values (old.desert_name);
        return old;
    end;
$$ language plpgsql;

create trigger trigger_archive_deleted_desert
    after delete on "DesertPrice"
    for each row
    when ( old.desert_name is not null )
execute procedure archive_deleted_desert();

delete from "DesertPrice"
where desert_name='Brownie';


/*
 ■ При переводе работника из одной кофейни в другую,
заносить информацию о переводе в специальную
таблицу.
 */

create or replace function exchange_staff()
returns trigger as $$
    BEGIN
        insert into "ExchangedStaff"(staff_name)
        values (old.waiter_name+' is exchanged');
        return old;

end;
$$ language plpgsql;

create trigger exchange_staff
after update on "Waiter"
for each row
when ( old.waiter_name is not null )
execute procedure exchange_staff();

update "Waiter"
set waiter_id=105
where waiter_name='Rachel Green';

/*
 Задание 3
Добавьте к базе данных «Кофейня» следующие представления:
■ Показать информацию обо всех кофейнях;
 */

create or replace view firstView
as select * from "CoffeeShops";

select * from firstView;

/*
 ■ Показать напитки, которые есть во всех кофейнях;
 */
create or replace view drinks
as select drinks_name from "DrinksPrice"
group by drinks_name
having count(distinct drinks_price_id) = (select count(*) from "CoffeeShops");

select * from drinks;

/*
■ Показать десерты, которые есть во всех кофейнях;
 */

create or replace view deserts
as select desert_name from "DesertPrice"
   group by desert_name
   having count(distinct desert_price_id) = (select count(*) from "CoffeeShops");

/*
 ■ Показать информацию о бариста во всех кофейнях;
 */

create or replace view bartenders
as select
       cs.coffee_shop_id,
       br.bartender_name
from "Bartender" as br
    join "CoffeeShops" as cs on cs.coffee_shop_id=br.bartender_id;

/*
 ■ Показать информацию об официантах во всех кофейнях.
 */

create or replace view waiters
as select
       cs.coffee_shop_id,
       wr.waiter_name
       from "Waiter" as wr
join "CoffeeShops" as cs on wr.waiter_id=cs.coffee_shop_id;


/*
 Задание 4
Добавьте к базе данных «Кофейня» следующие хранимые процедуры:
■ Показать самый популярный напиток во всей сети
кофеен;
 */

create or replace function most_popular_drink()
    returns table (popular_drink varchar(255)) as $$
DECLARE
    max_price DECIMAL(10, 2);
BEGIN
    select max(drinks_price) into max_price from "DrinksPrice";

    return query
    select drinks_name
    from "DrinksPrice"
    where drinks_price = max_price;

end
$$ language plpgsql;

select most_popular_drink();



/*
■ Показать самый популярный десерт во всей сети
кофеен;
 */

create or replace function most_popular_desert()
    returns table (popular_desert varchar(255)) as $$
    declare
        max_price decimal(10, 2);
    BEGIN
        select max(desert_price) into max_price from "DesertPrice";

        return query
        select desert_name
        from "DesertPrice"
        where desert_price = max_price;
    end
$$ language plpgsql;

select most_popular_desert();


/*
 ■ Показать ТОП-3 напитков во всей сети кофеен;
 */

create or replace function get_three_popular_drink()
    returns table (drinks varchar(255), total bigint) as $$
    begin
        RETURN QUERY
        select drinks_name, count(*) as total
        from "DrinksPrice"
        group by drinks_name
        order by total desc
        limit 3;

    end;
    $$ language plpgsql;

drop function get_three_popular_drink();

select get_three_popular_drink();

/*
 ■ Показать ТОП-3 десертов во всей сети кофеен;
 */
create or replace function get_three_popular_desert()
returns table(desert varchar(255), total bigint) as
    $$
    begin
        return query
        select desert_name, count(*) as total
        from "DesertPrice"
        group by desert_name
        order by total
        limit 3;
    end;
    $$ language plpgsql;

select get_three_popular_desert();

/*
 ■ Показать бариста, который работал во всех точках сети;
 */
create or replace function get_bartender()
returns table(barista_name varchar(255)) as
    $$
    begin
        return query
        select bartender_name
        from "Bartender" as br
        join "CoffeeStaff" as cf on br.bartender_id = cf.employee_id
        join "CoffeeShops" as sc on cf.coffee_shop_id = sc.coffee_shop_id;
    end;
$$ language plpgsql;

select get_bartender();

/*
 ■ Реализуйте механизм «черного списка». В «черный
список» могут быть помещены сотрудники сети, которых необходимо уволить и ни в коем случае не брать
на работу в любую точку сети.
 */

create or replace function add_to_black_list(
in staff_name_param varchar(255),
in reason_param varchar(255)
)
    returns void
    as $$
    BEGIN
        insert into "BlackList"(staff_name, reason)
        values (staff_name_param, reason_param);
    end;
    $$ language plpgsql;


create or replace function is_in_black_list(
in staff_name_param varchar(255)
) returns boolean as
    $$
    declare
        is_in boolean;
    BEGIN
        select true into is_in
        from "BlackList"
        where staff_name=staff_name_param;

        return is_in;
    end;
    $$ language plpgsql;

select is_in_black_list('john barbie');

select add_to_black_list('john barbie', 'chertkoi');


