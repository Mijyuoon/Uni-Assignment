create table area (
  id                            integer not null,
  owner_id                      integer,
  number                        integer,
  area                          integer,
  cadastre_number               integer,
  water_supply                  integer(1),
  constraint pk_area primary key (id),
  foreign key (owner_id) references person (id) on delete restrict on update restrict
);

create table building (
  id                            integer not null,
  type_id                       integer,
  area_id                       integer,
  addintional_info              varchar(255),
  constraint pk_building primary key (id),
  foreign key (type_id) references building_type (id) on delete restrict on update restrict,
  foreign key (area_id) references area (id) on delete restrict on update restrict
);

create table building_type (
  id                            integer not null,
  building_type_name            varchar(255),
  constraint pk_building_type primary key (id)
);

create table counter_data (
  id                            integer not null,
  date                          date,
  data                          double,
  area_id                       integer,
  constraint pk_counter_data primary key (id),
  foreign key (area_id) references area (id) on delete restrict on update restrict
);

create table electricity_rate (
  id                            integer not null,
  begin                         date,
  finish                        date,
  rate                          double,
  constraint pk_electricity_rate primary key (id)
);

create table payment_data (
  id                            integer not null,
  area_id                       integer,
  date                          date,
  total                         double,
  constraint pk_payment_data primary key (id),
  foreign key (area_id) references area (id) on delete restrict on update restrict
);

create table person (
  id                            integer not null,
  first_name                    varchar(255),
  middle_name                   varchar(255),
  last_name                     varchar(255),
  city                          varchar(255),
  birthday                      date,
  ident_code                    varchar(255),
  address                       varchar(255),
  telephone                     varchar(255),
  persone_role_id               integer,
  constraint pk_person primary key (id),
  foreign key (persone_role_id) references role (id) on delete restrict on update restrict
);

create table role (
  id                            integer not null,
  role_name                     varchar(255),
  constraint pk_role primary key (id)
);

