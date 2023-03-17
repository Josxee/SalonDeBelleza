CREATE DATABASE SalonDeBelleza;
use SalonDeBelleza;

CREATE TABLE Administradores (
    ID_administrador INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_administrador VARCHAR(50),
    Email_administrador VARCHAR(50),
    Password_administrador VARCHAR(50)
);

CREATE TABLE Usuarios (
    ID_usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_usuario VARCHAR(50),
    Email_usuario VARCHAR(50),
    Password_usuario VARCHAR(50)
);

CREATE TABLE Servicios (
    ID_servicio INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_servicio VARCHAR(50),
    Precio_servicio DECIMAL(10,2),
    Descripcion_servicio VARCHAR(100),
    ID_administrador INT,
    ID_usuario INT,
    FOREIGN KEY (ID_administrador) REFERENCES Administradores(ID_administrador),
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Productos (
    ID_producto INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_producto VARCHAR(50),
    Precio_producto DECIMAL(10,2),
    Descripcion_producto VARCHAR(100),
    ID_administrador INT,
    ID_usuario INT,
    FOREIGN KEY (ID_administrador) REFERENCES Administradores(ID_administrador),
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Compras_de_Servicios (
    ID_compra_servicio INT PRIMARY KEY,
    Fecha_compra DATE,
    ID_usuario INT,
    ID_servicio INT,
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario),
    FOREIGN KEY (ID_servicio) REFERENCES Servicios(ID_servicio)
);

CREATE TABLE Compras_de_Productos (
    ID_compra_producto INT PRIMARY KEY,
    Fecha_compra DATE,
    ID_usuario INT,
    ID_producto INT,
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario),
    FOREIGN KEY (ID_producto) REFERENCES Productos(ID_producto)
);
