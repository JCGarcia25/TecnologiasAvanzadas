CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(255),
    contrasena VARCHAR(255)
);

CREATE TABLE facturas (
    id SERIAL PRIMARY KEY,
    codigo_factura VARCHAR(255),
    detalles VARCHAR(20),
    fecha VARCHAR(255)
);

CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    max_empleados INT,
    actual_empleados INT
);

CREATE TABLE vitrina (
    id SERIAL PRIMARY KEY,
    valor FLOAT,
    nombre VARCHAR(255),
    cantidad INT
);

CREATE TABLE bodega (
    id SERIAL PRIMARY KEY,
    valor FLOAT,
    nombre VARCHAR(255),
    cantidad INT
);

CREATE TABLE servicios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255)
);
