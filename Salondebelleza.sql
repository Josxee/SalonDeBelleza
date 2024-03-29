drop database salondebelleza;
CREATE DATABASE SalonDeBelleza;
use SalonDeBelleza;


CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
	email VARCHAR(100),
	telefono VARCHAR(100),
	sexo VARCHAR(100),
	salario decimal(30)
);


CREATE TABLE Citas (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    cliente_cita VARCHAR(100),
    fecha_cita VARCHAR(100),
	servicio_cita VARCHAR(100),
	costo_cita VARCHAR(100)
);

CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
	email VARCHAR(100)
);

CREATE TABLE faq(
	ID_faq INT AUTO_INCREMENT PRIMARY KEY,
    pregunta VARCHAR(500) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL
);

CREATE TABLE Administradores (
    ID_administrador INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_administrador VARCHAR(50),
    Email_administrador VARCHAR(50),
    Password_administrador VARCHAR(50)
);

CREATE TABLE Usuarios (
    ID_usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_usuario VARCHAR(50),
    correo VARCHAR(255),
    contra VARCHAR(255),
	rol VARCHAR(255)
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
    Descripcion_producto VARCHAR(580),
	stock INT NOT NULL,
	imagen_producto VARCHAR(100) NOT NULL
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

CREATE TABLE Comentarios (
	ID_comentario INT AUTO_INCREMENT KEY,
    ID_usuario INT,
    Fecha_comentario VARCHAR(100),
    Titulo_comentario VARCHAR(100),
    Descripcion_comentario VARCHAR(250),
    Calificacion_comentario INT,
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

INSERT INTO Administradores(ID_administrador, Nombre_administrador, Email_administrador, Password_administrador) 
VALUES (1, 'Juan Perez', 'juanperez@gmail.com', 'contraseña1'),
       (2, 'María Rodriguez', 'mariarodriguez@gmail.com', 'contraseña2'),
       (3, 'Pedro Gómez', 'pedrogomez@gmail.com', 'contraseña3');
       
INSERT INTO Usuarios(ID_usuario, Nombre_usuario, correo, contra, rol) 
VALUES (1, 'admin', 'a@a.com', '$2a$12$pF936XyaXSYBSzrXg1BRMOMnuTvPG9ZA4EzhDUxU0it53Q41xavvS', 'ADMIN');

INSERT INTO Comentarios (ID_comentario, ID_usuario, Fecha_comentario, Titulo_comentario, Descripcion_comentario, Calificacion_comentario)
VALUES(1, 1, '2023-03-01', "Titulo", "Descripcion", 5);

INSERT INTO Productos (ID_producto, Nombre_producto, Precio_producto, Descripcion_producto, stock, imagen_producto)
VALUES (1, 'Acondicionador',13500,'Acondicionador de la marca TRESemmé para cabello liso, contiene keratina, controla el frizz e intensifica el brillo',10,'images/producto/acondicionador.jpg'),
	   (2, 'Ampolla btx',6000,'Ampolla de la marca btx, tratamiento recomendado para cabellos procesados quimicamente',20,'images/producto/ampolla.jpg'),
	   (3, 'Aceite L´OREAL',9000,'Aceite de la marca L´OREAL de la linea ELVIVE, ayuda a dar luminosidad',7,'images/producto/gota.jpg'),
	   (4, 'Shampoo Recamier',11500,'Shampoo sin sal de la marca Recamier de la linea vitane ADVANCE, accion anticaida',6,'images/producto/vitane.jpg');
 
INSERT INTO faq (ID_faq,pregunta,descripcion)
VALUES (1,' ¿Cada cuanto debo cortarme el cabello?','Nosotros recomendamos cortarse el cabello cada 3 meses'),
       (2,' ¿Qué shampoo debo utilizar?','Nosotros recomendamos utilizar shampoo sin sal'),
	   (3,' ¿Qué puedo hacer con mis primeras canas?','Nosotros recomendamos cortarse el cabello cada 3 meses');
       
INSERT INTO Citas(id_cita, cliente_cita, fecha_cita,servicio_cita,costo_cita) 
VALUES (1, 'Alejandra Valverde', '2023-03-11', 'Nanoplastia','70500'),
	   (2, 'Gabriela Torres', '2023-06-23', 'Color','35000'),
       (3, 'Marta Jimenez', '2023-07-17', 'Keratina','60000');
	
INSERT INTO estudiantes(id, nombre, apellido,email) 
VALUES (1, 'framesi', '89103230', 'framesi@gmail.com');
	   
INSERT INTO empleados(id, nombre, apellido, email, telefono, sexo, salario) 
VALUES (1, 'Alejandra', 'Sanchez','alejandra.framesi@gmail.com','+506 8915 3254','Femenino','750000'),
       (2, 'Jefry', 'Valverde','Jefry.morrocanoil@gmail.com','+1 345 215 3254','masculino','980000'),
       (3, 'Kevin', 'Mora','Kevin.tecitaly@gmail.com','+34 8915 3254','masculino','680000');
	 
