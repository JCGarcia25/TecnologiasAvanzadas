CREATE TABLE usuarios (
    id serial PRIMARY KEY,
    usuario varchar,
    contrasena varchar
);

CREATE TABLE facturas (
    id serial PRIMARY KEY,
    codigo_factura varchar,
    detalles varchar(20),
    fecha varchar
);

CREATE TABLE empresas (
    id serial PRIMARY KEY,
    nombre varchar,
    direccion varchar,
    max_empleados int,
    actual_empleados int,
);

CREATE TABLE vitrina (
    id serial PRIMARY KEY,
    valor FLOAT,
    nombre varchar,
    cantidad int
);

CREATE TABLE bodega (
    id serial PRIMARY KEY,
    valor FLOAT,
    nombre varchar,
    cantidad int
);