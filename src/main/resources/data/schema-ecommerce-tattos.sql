-- -----------------------------------------------------
-- Table "TIPOS_PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE TIPOS_PRODUCTOS (
  id_tipo_producto  SERIAL, 
  descripcion      varchar(50), 
  PRIMARY KEY (id_tipo_producto));

-- -----------------------------------------------------
-- Table "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE PRODUCTOS (
  id_producto       SERIAL , 
  id_tipo_producto int4 , 
  nombre           varchar(50) , 
  precio_venta     numeric(16, 2) , 
  cantidad_stock   int4 ,
  url_imagen	   varchar(255), 
  PRIMARY KEY (id_producto));

-- -----------------------------------------------------
-- Table "CLIENTES"
-- -----------------------------------------------------

CREATE TABLE CLIENTES (
  id_cliente      SERIAL, 
  nombreCompleto varchar(100), 
  correo         varchar(100), 
  PRIMARY KEY (id_cliente));


-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------

CREATE TABLE COMPRAS (
  id_compra    SERIAL, 
  iid_cliente int4, 
  fecha       date, 
  medio_pago  char(1), 
  PRIMARY KEY (id_compra));

-- -----------------------------------------------------
-- Table "COMPRAS_PRODUCTOS"
-- -----------------------------------------------------

CREATE TABLE COMPRAS_PRODUCTOS (
  id_compra   int4, 
  id_producto int4, 
  cantidad    int4, 
  total       numeric(16, 2), 
  PRIMARY KEY (id_compra, 
  id_producto));
  
  
ALTER TABLE PRODUCTOS ADD CONSTRAINT FKPRODUCTOS650780 FOREIGN KEY (id_tipo_producto) REFERENCES TIPOS_PRODUCTOS (id_tipo_producto);
ALTER TABLE COMPRAS ADD CONSTRAINT FKCOMPRAS895225 FOREIGN KEY (iid_cliente) REFERENCES CLIENTES (id_cliente);
ALTER TABLE COMPRAS_PRODUCTOS ADD CONSTRAINT FKCOMPRAS_PR492922 FOREIGN KEY (id_compra) REFERENCES COMPRAS (id_compra);
ALTER TABLE COMPRAS_PRODUCTOS ADD CONSTRAINT FKCOMPRAS_PR106829 FOREIGN KEY (id_producto) REFERENCES PRODUCTOS (id_producto);
