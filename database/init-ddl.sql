create sequence car_brand_seq;
create table car_brand
(
    id   int primary key default nextval('car_brand_seq'),
    name varchar(1000) not null
);
comment on table car_brand is 'Марка автомобиля';
comment on column car_brand.id is 'Идентификатор марки';
comment on column car_brand.name is 'Наименование марки';
------------------------------------------------------------
create sequence car_model_seq;
create table car_model
(
    id       int primary key default nextval('car_model_seq'),
    name     varchar(1000) not null,
    brand_id int           not null references car_brand (id)
);
comment on table car_model is 'Модель автомобиля';
comment on column car_model.id is 'Идентификатор модели';
comment on column car_model.name is 'Наименование модели';
comment on column car_model.brand_id is 'Марка модели';
------------------------------------------------------------
create sequence car_seq;
create table car
(
    id       int primary key default nextval('car_seq'),
    number   varchar(100) not null,
    model_id int          not null references car_model (id)
);
comment on table car is 'Автомобиль';
comment on column car.id is 'Идентификатор автомобиля';
comment on column car.number is 'Номер автомобиля';
comment on column car.model_id is 'Модель автомобиля';
------------------------------------------------------------
create sequence customer_seq;
create table customer
(
    id          int primary key default nextval('customer_seq'),
    last_name   varchar(100) not null,
    first_name  varchar(100) not null,
    middle_name varchar(100) not null
);
comment on table customer is 'Клиент';
comment on column customer.id is 'Идентификатор клиента';
comment on column customer.first_name is 'Имя';
comment on column customer.last_name is 'Фамилия';
comment on column customer.middle_name is 'Отчество';
------------------------------------------------------------
create sequence car_rental_contract_seq;
create table car_rental_contract
(
    id          int primary key default nextval('car_rental_contract_seq'),
    customer_id int       not null references customer (id),
    car_id      int       not null references car (id),
    start_date  timestamp not null,
    end_date    timestamp not null,
    check (start_date < end_date)
);
comment on table car_rental_contract is 'Договор на прокат автомобиля';
comment on column car_rental_contract.id is 'Идентификатор договора';
comment on column car_rental_contract.customer_id is 'Клиент';
comment on column car_rental_contract.car_id is 'Автомобиль';
comment on column car_rental_contract.start_date is 'Дата взятия автомобиля в прокат';
comment on column car_rental_contract.end_date is 'Дата возврата автомобиля';
------------------------------------------------------------
