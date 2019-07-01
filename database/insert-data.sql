insert into car_brand(name)
values ('Lada'),
       ('BMW');

insert into car_model(name, brand_id)
values ('XRay', 1),
       ('Vesta', 1),
       ('M1', 2),
       ('M3', 2);

insert into car(number, model_id)
values ('111-AAA', 1),
       ('222-BBB', 2),
       ('333-CCC', 3),
       ('444-DDD', 4);

insert into customer(last_name, first_name, middle_name)
values ('Картошка', 'Иван', 'Иваныч'),
       ('Помидорка', 'Петр', 'Петрович'),
       ('Репка', 'Алексей', 'Алексеевич'),
       ('Морковка', 'Дмитрий', 'Дмитриевич');

insert into car_rental_contract(customer_id, car_id, start_date, end_date)
values (1, 1, '2019-01-01 16:00:00'::timestamp, '2019-01-05 18:00:00'::timestamp),
       (2, 2, '2019-01-04 16:00:00'::timestamp, '2019-01-07 18:00:00'::timestamp),
       (3, 3, '2019-01-03 16:00:00'::timestamp, '2019-01-08 18:00:00'::timestamp),
       (4, 4, '2019-01-06 16:00:00'::timestamp, '2019-01-10 18:00:00'::timestamp);