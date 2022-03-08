create sequence hibernate_sequence start with 1 increment by 1;
create table cancion (id integer not null, album varchar(255) not null, anno varchar(255) not null, artista varchar(255) not null, titulo varchar(255) not null, cancion_id integer not null, primary key (id));
create table lista (id integer not null, titulo varchar(255) not null, primary key (id));
alter table cancion add constraint FKcyjd96ayksg74hmv6y9x4uqyn foreign key (cancion_id) references lista;
