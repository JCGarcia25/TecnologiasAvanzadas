CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255),
    contrasena VARCHAR(255)
);

CREATE TABLE facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_factura VARCHAR(255),
    detalles VARCHAR(20),
    fecha VARCHAR(255)
);

CREATE TABLE empresas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    max_empleados INT,
    actual_empleados INT
);