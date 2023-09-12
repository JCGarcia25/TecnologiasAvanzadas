CREATE TABLE usuarios {
	id serial PRIMARY KEY,
	usuario varchar,
	contraseña varchar
};

CREATE TABLE facturas {
	id serial PRIMARY KEY,
	codigo_factura varchar,
	detalles varchas,
	fecha varchar,
};

CREATE TABLE productos {
	id serial PRIMARY KEY,
	codigo_producto varchar,
	nombre varchar,
	precio float,
};

CREATE TABLE factura_producto (
    id serial PRIMARY KEY,
    id_factura integer REFERENCES facturas (id),
    id_producto integer REFERENCES productos (id)
);
