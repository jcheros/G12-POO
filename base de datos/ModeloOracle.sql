/**
 *
 * DBMS           :  ORACLE
 * Esquema        :  GRUPO12
 * Descripción    :  Modelo de Base de Datos para gestión de ATM
 * Script         :  Crea el esquema y sus respectivas tablas
 * Creao por      :  Grupo12
 *
**/

-- =============================================
-- CREACIÓN DEL USUARIO
-- =============================================

DECLARE
	N INT;
	COMMAND VARCHAR2(200);
BEGIN
	COMMAND := 'DROP USER USER12 CASCADE';
	SELECT COUNT(*) INTO N
	FROM DBA_USERS
	WHERE USERNAME = 'USER12';
	IF ( N = 1 ) THEN
		EXECUTE IMMEDIATE COMMAND;
	END IF;
END;
/


ALTER SESSION SET "_ORACLE_SCRIPT"=true; 
CREATE USER USER12 IDENTIFIED BY USER12;
GRANT CONNECT, RESOURCE TO USER12;

ALTER USER USER12 QUOTA UNLIMITED ON USERS;

GRANT CREATE VIEW TO USER12;
GRANT ALTER ANY INDEX TO "USER12";
GRANT CREATE ANY SEQUENCE TO "USER12";
GRANT CREATE ANY TRIGGER TO "USER12";
GRANT CREATE TRIGGER TO USER12;
GRANT ALTER ANY SEQUENCE TO "USER12";


-- =============================================
-- CONECTARSE A LA APLICACIÓN
-- =============================================

CONNECT USER12/USER12


create table CLIENTES
(
    DNI        CHAR(8)      not null
        constraint CLIENTES_PK
            primary key,
    NOMBRES    VARCHAR2(30) not null,
    AP_PATERNO VARCHAR2(30) not null,
    AP_MATERNO VARCHAR2(30) not null,
    EMAIL      VARCHAR2(50),
    TELEFONO   VARCHAR2(20)
)
/

create table CUENTAS
(
    NUMERO_CTA  CHAR(5)      not null
        constraint CUENTAS_PK
            primary key,
    NIP         CHAR(5)      not null,
    MONEDA      VARCHAR2(20) not null,
    SALDO       NUMBER       not null,
    DNI_CLIENTE CHAR(8)      not null
        constraint CUENTAS_CLIENTES_FK
            references CLIENTES
)
/

create table TIPOS_TRANSACCION
(
    CODIGO      NUMBER       not null
        constraint TIPOS_TRANSACCION_PK
            primary key,
    DESCRIPCION VARCHAR2(30) not null
)
/

create table CAJEROS
(
    CODIGO NUMBER not null,
    SALDO  NUMBER
)
/

create unique index CAJEROS_CODIGO_UINDEX
    on CAJEROS (CODIGO)
/

alter table CAJEROS
    add constraint CAJEROS_PK
        primary key (CODIGO)
/

create sequence MOVIMIENTOS_SEQ
/

create table MOVIMIENTOS
(
    NUMERO_OP     NUMBER not null
        constraint MOVIMIENTOS_PK
            primary key,
    FECHA_HORA    TIMESTAMP(6)                                        not null,
    TIPO          NUMBER                                              not null
        constraint MOVIMIENTOS_TIPOS
            references TIPOS_TRANSACCION,
    IMPORTE       NUMBER                                              not null,
    NUMERO_CTA    CHAR(5)                                             not null
        constraint MOVIMIENTOS_CUENTAS_FK
            references CUENTAS,
    CODIGO_CAJERO NUMBER                                              not null
        constraint MOVIMIENTOS_CAJEROS_CODIGO_FK
            references CAJEROS
)
/

-- Disparador para actualizar el saldo del cajero en base a las transacciones sobre la tabla moviemientos
create trigger ACTUALIZAR_SALDO_CAJERO
    after insert
    on MOVIMIENTOS
    for each row
BEGIN

    IF (:NEW.tipo = 1) THEN
        UPDATE CAJEROS
        SET SALDO = SALDO + :NEW.importe
        WHERE CODIGO = :new.codigo_cajero;
    END IF;

    IF (:NEW.tipo = 2) THEN
        UPDATE CAJEROS
        SET SALDO = SALDO - :NEW.importe
        WHERE CODIGO = :new.codigo_cajero;
    end if;
END;
/

-- Inserts
INSERT INTO USER12.CAJEROS (CODIGO, SALDO) VALUES (100000, 10000);

INSERT INTO USER12.TIPOS_TRANSACCION (CODIGO, DESCRIPCION) VALUES (1, 'Depósito');
INSERT INTO USER12.TIPOS_TRANSACCION (CODIGO, DESCRIPCION) VALUES (2, 'Retiro');

INSERT INTO USER12.CLIENTES (DNI, NOMBRES, AP_PATERNO, AP_MATERNO, EMAIL, TELEFONO) VALUES ('46499778', 'José', 'Chero', 'Sojo', 'jchero.sojo@gmail.com', '929230498');
INSERT INTO USER12.CLIENTES (DNI, NOMBRES, AP_PATERNO, AP_MATERNO, EMAIL, TELEFONO) VALUES ('40106279', 'Edward', 'Mercado', 'Guerrero', 'edward@gmail.com', '989098989');
INSERT INTO USER12.CLIENTES (DNI, NOMBRES, AP_PATERNO, AP_MATERNO, EMAIL, TELEFONO) VALUES ('47417543', 'Yuri', 'Escobar', 'Arcaya', 'yuri@gmail.com', '656765643');

INSERT INTO USER12.CUENTAS (NUMERO_CTA, NIP, MONEDA, SALDO, DNI_CLIENTE) VALUES ('11111', '11111', 'Soles', 125, '46499778');
INSERT INTO USER12.CUENTAS (NUMERO_CTA, NIP, MONEDA, SALDO, DNI_CLIENTE) VALUES ('22222', '22222', 'Soles', 1740, '40106279');
INSERT INTO USER12.CUENTAS (NUMERO_CTA, NIP, MONEDA, SALDO, DNI_CLIENTE) VALUES ('33333', '33333', 'Soles', 830, '47417543');

COMMIT;