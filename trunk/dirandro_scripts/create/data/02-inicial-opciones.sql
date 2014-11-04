--Roles
INSERT INTO SIETID.SEG_ROL (ID, CODIGO, NOMBRE, ESTADO, CREADOR, CREACION) VALUES (1, 'ADMIN', 'ADMINISTRADOR',1,1,SYSDATE);

--Actualizacion del Rol de Usuario
UPDATE SIETID.SEG_USUARIO SET ROL = 1;

--Opciones
--Menu 1
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (1,NULL,'MANTEN','Administraci�n',1,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (2,1,'MANT_DELITO','Delitos',1,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (3,1,'MANT_HECHOS','Tipo de Hechos',2,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (4,1,'MANT_PERSONA','Personas',3,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (5,1,'MANT_LETRADO','Letrados',4,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (6,1,'MANT_POLICIA','Policias',5,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (7,1,'MANT_EMPRESA','Empresas',6,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (8,1,'MANT_ENTIDAD','Entidades',7,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (9,1,'MANT_DEPENDEN','Dependencias',8,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (10,1,'MANT_POBLADO','Centro Poblados',9,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (11,1,'MANT_ESTADO','Estados',10,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (12,1,'MANT_PAIS','Paises',11,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (13,1,'MANT_MODELO','Gen�ricos',12,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (14,1,'MANT_ESPECIE','Tipos Especies',13,4,1,1,SYSDATE);

--Menu 2
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (17,null,'EXP','Parte Policial',2,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (18,17,'EXP_REG_PP','Registro Parte Policial',1,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (19,17,'EXP_REG_HR','Registrar Hoja Remision',2,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (20,17,'EXP_BAN_PP','Bandeja del Parte Policial',3,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (52,17,'EXP_BAN_HR','Bandeja Hoja de Remision',4,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (53,17,'EXP_BAN_PR','Bandeja de Pericias',5,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (54,17,'EXP_REG_NI','Registro de Nota Informativa',6,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (55,17,'EXP_BAN_NI','Bandeja de Nota Informativa',7,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (56,17,'EXP_REG_CA','Registro de Caso',8,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (57,17,'EXP_REG_DI','Registro de Documento de Inteligencia',9,4,1,1,SYSDATE);
--Menu 3
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (24,null,'BSQ','Busqueda',3,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (25,24,'BSQ_VEHICULO','Buscar Vehiculos',1,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (26,24,'BSQ_INMUEBLE','Buscar Inmuebles',2,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (27,24,'BSQ_PERSONA','Buscar Personas',3,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (28,24,'BSQ_TELEFONO','Buscar Telefonos',4,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (29,24,'BSQ_ARMA','Buscar Armas',5,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (30,24,'BSQ_ORGANIZAC','Buscar Organizaciones',6,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (31,24,'BSQ_NA','Buscar No Identificados',7,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (32,24,'BSQ_DOCUMENTO','Buscar Documentos',8,4,1,1,SYSDATE);
 
--Menu 4
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (36,null,'SEG','Seguridad',4,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (37,36,'SEG_PERMISO','Permisos',1,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (38,36,'SEG_USUARIO','Usuarios',2,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (39,36,'SEG_OPCION','Opciones',3,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (40,36,'SEG_EQUIPO','Equipos',4,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (41,36,'SEG_ROL','Roles',5,4,1,1,SYSDATE);

--Menu 5
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (45,null,'CFG','Configuraci�n',5,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (46,45,'CFG_PARAM','Parametros',1,4,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (47,45,'CFG_LISTA','Lista y Valores',2,4,1,1,SYSDATE);

--Menu 6
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (50,NULL,'RPT','Reportes',6,3,1,1,SYSDATE);
INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (51,50,'RPT_ATESTADO','Reporte de Atestado',1,4,1,1,SYSDATE);

INSERT INTO SIETID.SEG_OPCION (ID, PADRE, CODIGO, NOMBRE, ORDEN, TIPO, ESTADO, CREADOR, CREACION) VALUES (56,26,'BTN_BUS_IN','Boton Buscar Inmueble',1,5,1,1,SYSDATE);

--Permisos
--Menu 1
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (1,1,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (2,2,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (3,3,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (4,4,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (5,5,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (6,6,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (7,7,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (8,8,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (9,9,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (10,10,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (11,11,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (12,12,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (13,13,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (14,14,1,1,1,SYSDATE);
--Menu 2
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (17,17,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (18,18,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (19,19,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (20,20,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (52,52,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (53,53,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (54,54,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (55,55,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (56,56,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (57,57,1,1,1,SYSDATE);
--Menu 3
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (24,24,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (25,25,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (26,26,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (27,27,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (28,28,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (29,29,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (30,30,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (31,31,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (32,32,1,1,1,SYSDATE);
--Menu 4
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (36,36,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (37,37,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (38,38,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (39,39,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (40,40,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (41,41,1,1,1,SYSDATE);
--Menu 5
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (45,45,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (46,46,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (47,47,1,1,1,SYSDATE);
--Menu 6
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (50,50,1,1,1,SYSDATE);
INSERT INTO SIETID.SEG_PERMISO (ID, OPCION, ROL, ESTADO, CREADOR, CREACION) VALUES (51,51,1,1,1,SYSDATE);

-- Parametros
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('ADJUNTOS_PATH','Directorio para adjuntos','Ruta (con / al final) del directorio que almacena adjuntos','/datos/',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('CORREO_BUZON','Remitente SMTP','Buz�n remitente de correos enviados automoticamente','info@mininter.gob.pe',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('CORREO_PUERTO','Puerto SMTP','N�mero de puerto del servidor de correos','25',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('CORREO_SERVIDOR','Host SMTP','Nombre o direccion IP de servidor de correos','correo.mininter.gob.pe',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('PLANTILLAS_PATH','Directorio para plantillas','Ruta (con / al final) del directorio que almacena plantillas','/datos/reportes/',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('LOV_ESTADO','Estados para LOV','Estados base para registros en CFG_LISTA y CFG_VALOR (LOVs: List of Values)','A,I',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('ADJUNTOS_SIZE','Tama�o del Archivo Adjunto','Tama�o maximo permitido de 5mb','5242880',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('FECHA_ALERTA','Fecha de Alerta del Expediente','TPorcentaje de la Fecha de Alerta del Expediente','70',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('PATH_WINDOW','Parametro de Window','Ruta de Windows que va ser usado para test en window','D:/Compartido/',1,1,SYSDATE);
INSERT INTO SIETID.CFG_PARAMETRO (CODIGO,NOMBRE,DESCRIPCION,VALOR,ESTADO,CREADOR,CREACION) values ('PATH_DOCUMENTO','Directorio Documento','Directorio para almacenar los documentos del expediente','D:\temp\dirandro\',1,1,SYSDATE);

--Carga de Estados Expediente
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (1,'REG','Registrado','Registrado (se grab� y no se se registro todo el proceso)',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (2,'X_ADJ','Por adjuntar','Por adjuntar documentaci�n',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (3,'X_AUT_ASIG','Por autorizar asignacion','Por autorizar asignacion',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (4,'X_COM','Por completar datos','Por completar datos',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (5,'X_DIC','Por dictaminar','Dictaminar',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (6,'OBS','Observado','Observado',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (7,'X_DEV','Por devolver','Por devolver',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (8,'X_RES','Por enviar respuesta','Por enviar respuesta',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (9,'PEND','Pendiente','Pendiente',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (10,'TER','Terminado','Expediente terminado',1,1,SYSDATE);
INSERT INTO SIETID.EXP_ESTADO (id,codigo,nombre,descripcion,estado,creador,creacion) values (11,'ANU','Anulado','Anulado',1,1,sysdate);


commit;
quit;