INSERT INTO roles (nombrerol) VALUES ('Administrador');
INSERT INTO roles (nombrerol) VALUES ('Paciente');
INSERT INTO roles (nombrerol) VALUES ('Doctor');

INSERT INTO usuarios (idrol, clave, identificacion, nombreusuario, direccion, telefono, correo) VALUES (1, 'KA%B323$hg', 1123454, 'Martin Navarro', 'Cl 23 #4-56', 6563265,'marna@gmail.com');
INSERT INTO usuarios (idrol, clave, identificacion, nombreusuario, direccion, telefono, correo) VALUES (2, 'Blk5C%ks&m', 5467859, 'Edilma Ruiz', 'Cr 65 #43-89', 31245356,'eru@gmail.com');
INSERT INTO usuarios (idrol, clave, identificacion, nombreusuario, direccion, telefono, correo) VALUES (2, 'A&RLl345fF', 3232345, 'Orlando Chaparro', 'Cl 2N #7-03', 3234435,'ocha@outlook.com');
INSERT INTO usuarios (idrol, clave, identificacion, nombreusuario, direccion, telefono, correo) VALUES (3, 'mFdk984Ks%', 2253456, 'María Carvajal', 'Diagonal 2 #45-65', 31456544,'maca@hotmail.com');
INSERT INTO usuarios (idrol, clave, identificacion, nombreusuario, direccion, telefono, correo) VALUES (3, 'xyS34J&ldM', 1234344, 'Luis Benitez', 'cra 34 #78-70', 32093847,'lube@gmail.com');

INSERT INTO medicos (idusuario, especialidad, jornada) VALUES (4, 'Pediatría', 'M');
INSERT INTO medicos (idusuario, especialidad, jornada) VALUES (5, 'Medicina General', 'T');

