--Testing for Windows
--drop tablespace SIIC_DATA incluind contents;
--Creacion del tablespace y el datafile (Solo se crea una vez)
create tablespace SIETID_DATA 
datafile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\BDPRUEBA\SIETID_DATA_01.dbf'
size 100m 
autoextend on next 100m;

--drop user SIETID cascade;
--Creacion del Usuario definiendo mi tablespace
create user "SIETID" profile "DEFAULT" identified by "sietid" 
default tablespace "SIETID_DATA" 
temporary tablespace "TEMP" account unlock;




--Testing for Linux
--drop tablespace SIIC_DATA incluind contents;
--Creacion del tablespace y el datafile (Solo se crea una vez)
create tablespace SIETID_DATA 
datafile '/u01/app/oracle/oradata/BDTRAMITE/SIETID_DATA_01.dbf'
size 100m 
autoextend on next 100m;

--drop user SIETID cascade;
--Creacion del Usuario definiendo mi tablespace
create user "SIETID" profile "DEFAULT" identified by "sietid" 
default tablespace "SIETID_DATA" 
temporary tablespace "TEMP" account unlock;