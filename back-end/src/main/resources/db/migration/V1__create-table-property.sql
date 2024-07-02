create table property(

    id bigint not null auto_increment,
    property_type varchar(100) not null,
    price varchar(100) not null,
    square_meter varchar(20) not null,
    bedrooms varchar(100) not null,
    bathrooms varchar(100) not null,
    contract_type varchar(100) not null,
    state varchar(100) not null,
    user_registration varchar(100) not null unique,
    property_image varchar(100) not null,
    registration_date varchar(100) not null,
    registration_time varchar(100) not null,
    name varchar(100) not null,
    description varchar(100) not null,
    street varchar(100) not null,
    number varchar(20),
    complement varchar(100),
    province varchar(100) not null,
    city varchar(100) not null,
    location_lat varchar(20) not null,
    location_len varchar(20) not null,

    primary key(id)

);