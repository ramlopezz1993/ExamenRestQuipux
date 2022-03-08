DROP TABLE IF EXISTS lista;
CREATE TABLE lista
(
    id     INT PRIMARY KEY,
    titulo VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS cancion;
create table cancion
(
    id      INT PRIMARY KEY,
    titulo  VARCHAR(20) not null,
    artista VARCHAR(50) not null,
    album   VARCHAR(30) not null,
    anno    VARCHAR(4)  not null,
    lista_id   INT      not null,
    primary key (id),
    FOREIGN KEY (lista_id) REFERENCES lista(id)
)