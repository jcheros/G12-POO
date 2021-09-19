CREATE TABLESPACE "GRUPO12"
DATAFILE '/opt/oracle/GRUPO12.dbf' SIZE 50M
EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT AUTO;

--ALTER SESSION SET "_oracle_script" = TRUE;
CREATE USER "USER12" PROFILE "DEFAULT" IDENTIFIED BY "USER12"
DEFAULT TABLESPACE "GRUPO12" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK;

GRANT "CONNECT" TO "USER12";
GRANT "RESOURCE" TO "USER12";
GRANT "DBA" TO "USER12";
GRANT ALTER ANY INDEX TO "USER12";
GRANT ALTER ANY SEQUENCE TO "USER12";
GRANT ALTER ANY TABLE TO "USER12";
GRANT ALTER ANY TRIGGER TO "USER12";
GRANT CREATE ANY INDEX TO "USER12";
GRANT CREATE ANY SEQUENCE TO "USER12";
GRANT CREATE ANY SYNONYM TO "USER12";
GRANT CREATE ANY TABLE TO "USER12";
GRANT CREATE ANY TRIGGER TO "USER12";
GRANT CREATE ANY VIEW TO "USER12";
GRANT CREATE PROCEDURE TO "USER12";
GRANT CREATE PUBLIC SYNONYM TO "USER12";
GRANT CREATE TRIGGER TO "USER12";
GRANT CREATE VIEW TO "USER12";
GRANT DELETE ANY TABLE TO "USER12";
GRANT CREATE SESSION TO USER12;