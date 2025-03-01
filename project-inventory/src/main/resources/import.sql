
INSERT INTO Categorias (catId, catDescripcion, catNombre) VALUES (1, 'Led', 'Televisores')
INSERT INTO Categorias (catId, catDescripcion, catNombre) VALUES (2, 'multimetros, tester, destornilladores', 'Herramienta')

-- Insertar el producto (suponiendo que la categoría con ID = 1 ya existe)

INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('L50-2', 'L32-2', 'Tiras LED 32" TV LG', 7, 32000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('L32-1', 'L32-1', 'Tiras LED 32" TV LG', 12, 29000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('L42-1', 'L42-1', 'Tiras LED 42" TV LG', 4, 35000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('H24-2', 'H24-2', 'Tiras LED 24" TV CHINO', 8, 21000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('H24-3', 'H24-3', 'Tiras LED 24" TV CHINO', 5, 22000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('H32-1', 'H32-1', 'Tiras LED 32" TV LG', 10, 30000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('H32-2', 'H32-2', 'Tiras LED 32" TV CHINO', 6, 31000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('H24-1', 'H24-1', 'Tiras LED 24" TV Chino', 10, 20000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('L32-2', 'L32-2', 'Tiras LED 32" TV LG', 7, 32000, 1, 1)
INSERT INTO Producto (proCodigo, proModelo, proDescripcion, proCantidad, proPrecioUnitario, proEstado, catId) VALUES ('L50-1', 'L32-2', 'Tiras LED 32" TV LG', 7, 32000, 1, 1)

/* -- Supongamos que el producto recién insertado tiene proCodigo = 10
INSERT INTO Producto_Imagenes (Producto_proCodigo, proImagenes) VALUES (10, 'https://cloudinary.com/laptop1.jpg');
INSERT INTO Producto_Imagenes (Producto_proCodigo, proImagenes) VALUES (10, 'https://cloudinary.com/laptop2.jpg');
INSERT INTO Producto_Imagenes (Producto_proCodigo, proImagenes) VALUES (10, 'https://cloudinary.com/laptop3.jpg');
 */

/* INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica')
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica') 
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica') 
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa')
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia') 
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa')
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía') 
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida') 
INSERT INTO clientes (region_id, nombre, apellido, email, createAt) VALUES (1, 'Richard', 'Paz', 'richard@unicauca.edu.co' , '2024-01-01') 
INSERT INTO clientes (region_id, nombre, apellido, email, createAt) VALUES (2, 'Steve', 'Jobs', 'sjobs@unicauca.edu.co', '2024-01-01') 
INSERT INTO clientes (region_id, nombre, apellido, email, createAt) VALUES (4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.co', '2024-01-01')
 */