-- TIPOS PRODUCTOS
INSERT INTO TIPOS_PRODUCTOS (id_tipo_producto, descripcion) VALUES (1, 'Tatuajes');
INSERT INTO TIPOS_PRODUCTOS (id_tipo_producto, descripcion) VALUES (2, 'Joyas');
INSERT INTO TIPOS_PRODUCTOS (id_tipo_producto, descripcion) VALUES (3, 'Camisetas');

-- PRODUCTOS
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (1, 1, 'Tatuaje Dragon', '30000', '10', 'https://i.pinimg.com/564x/e0/11/a4/e011a4972cd7b2922b2af078babaecaa.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (2, 1, 'Tatuaje Tortuga', '1000', '10', 'https://i.pinimg.com/564x/36/e1/c4/36e1c4802ad323d49b0c4acf8cd98947.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (3, 1, 'Tatuaje Leon', '2000', '10', 'https://i.pinimg.com/564x/b9/e3/73/b9e373e8467ae2b7970e1461835bd9f5.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (4, 1, 'Tatuaje Barco', '12000', '10', 'https://i.pinimg.com/564x/84/8a/b1/848ab1e5fa7d24622e4e0b7c5bbf1640.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (5, 1, 'Tatuaje Aves', '5500', '10', 'https://i.pinimg.com/564x/03/6f/51/036f517dd64885aeabf0494fd6bc873f.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (6, 2, 'Joya Dragon oreja', '9000', '10', 'https://i.pinimg.com/564x/d0/94/40/d094409ff155ecbc360b53433dfb907a.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (7, 2, 'Joya Estrella nariz', '8000', '10', 'https://i.pinimg.com/564x/05/89/63/058963fcb5cb21bc380c3a7276bf78a2.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (8, 2, 'Joya Conejo', '7000', '10', 'https://i.pinimg.com/564x/2b/7b/f5/2b7bf5950076a932291e66b2a298d917.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (9, 2, 'Joya Lengua', '6000', '10', 'https://i.pinimg.com/564x/5e/ff/55/5eff558337a2563c61f6ad24b4772db1.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (10, 2, 'Joya Serpiente oreja', '5000', '10', 'https://i.pinimg.com/564x/7c/d4/45/7cd44528a00db95e1b610f211a919b8e.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (11, 3, 'Camiseta GNR', '1000', '10', 'https://i.pinimg.com/564x/1a/11/75/1a1175f5d20f596ac3f3ca910a2b1e5d.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (12, 3, 'Camiseta Nirvana', '2000', '10', 'https://i.pinimg.com/564x/d6/d8/0d/d6d80dcd356cf700428acb0211866b39.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (13, 3, 'Camiseta Metallica', '3000', '10', 'https://i.pinimg.com/564x/41/ea/fb/41eafbd76ce953368aee9677a7a54b3e.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (14, 3, 'Camiseta Slipknot', '4000', '10', 'https://i.pinimg.com/564x/18/26/40/182640e0e4c4faf4eed0947885b4c486.jpg');
INSERT INTO PRODUCTOS (id_producto, id_tipo_producto, nombre, precio_venta, cantidad_stock, url_imagen) VALUES (15, 3, 'Camiseta Ghost', '5000', '10', 'https://i.pinimg.com/564x/e6/e5/b4/e6e5b46592787e349fb3d806abfeeec6.jpg');

-- CLIENTES
INSERT INTO CLIENTES (id_cliente, nombre_completo, correo) VALUES ('2220181027', 'Jean Lozano', 'jean@gmail.com');
INSERT INTO CLIENTES (id_cliente, nombre_completo, correo) VALUES ('2220181022', 'Juan Forero', 'juan@gmail.com');
INSERT INTO CLIENTES (id_cliente, nombre_completo, correo) VALUES ('2220181013', 'Sebastian Hoyos', 'sebastian@gmail.com');
INSERT INTO CLIENTES (id_cliente, nombre_completo, correo) VALUES ('2220181033', 'Duvan Saenz', 'duvan@gmail.com');

-- COMPRAS
INSERT INTO COMPRAS (id_compra, id_cliente, fecha, medio_pago) VALUES (1, '2220181027', TO_TIMESTAMP('10/08/1992 17:30:00','DD/MM/YYYY HH24:MI:SS'), 'E');
INSERT INTO COMPRAS_PRODUCTOS (id_compra, id_producto, cantidad, total) VALUES (1, 1, 10, 3000);
INSERT INTO COMPRAS_PRODUCTOS (id_compra, id_producto, cantidad, total) VALUES (1, 5, 1, 40000);
INSERT INTO COMPRAS_PRODUCTOS (id_compra, id_producto, cantidad, total) VALUES (1, 10, 1, 9000);
INSERT INTO COMPRAS_PRODUCTOS (id_compra, id_producto, cantidad, total) VALUES (1, 15, 2, 16400);
INSERT INTO COMPRAS_PRODUCTOS (id_compra, id_producto, cantidad, total) VALUES (1, 3, 1, 4000);

-- SE REINICIAN LAS SECUENCIAS SEGÚN LOS DATOS INICIALES
SELECT setval('public.productos_id_producto_seq', 15, true);
SELECT setval('public.tipos_productos_id_tipo_producto_seq', 3, true);
SELECT setval('public.compras_id_compra_seq', 1, true);

