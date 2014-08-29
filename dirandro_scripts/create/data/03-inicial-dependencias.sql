--Cambios EXP_DEPENDENCIA (Quitar codigo)
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (1, '00001',60,'DIRECCION DE INVESTIGACION CRIMINAL', 'DIRINCRI','', 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (2, '00002',65,'DIVISION DE INVEST. DE HOMICIDIOS', 'DIVINHOM',1, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (3, '00003',65,'DEPARTAMENTO DE INVESTIGACION DE HOMICIDIOS', 'DEPINHOM',2, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (4, '00004',65,'DEPARTAMENTO DE INVESTIGACION DE LESIONES', 'DEPINLES',2, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (5, '00005',65,'DEPARTAMENTO DE INVESTIGACIONES ESPECIALES', 'DEPINESP',2, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (6, '00006',65,'SECRETARIA', 'SECRETARIA',2, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (7, '00007',65,'OFAD', 'OFAD',2, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (8, '00008',65,'SERVICIO DE GUARDIA', 'SERVICIO DE GUARDIA',2, 1,1,SYSDATE);

commit; 
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (20, '00009',83,'DIRECCION DE ANTIDROGAS', 'DIRANDRO','',1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (21, '00010',84,'DIVISION DE PREVENCI�N DE TID', 'DIVINTID',20,1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (22, '00011',85,'DIVISION DE INVESTIGACION CONTRA DESVIO DE INSUMOS QUIMICOS','DIVININS',20, 1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (23, '00012',86,'DIVISION DE INVESTIGACION DEL TID', 'DIVINDR',20,1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (24, '00013',87,'DIVISION DE INVESTIGACION DE LAVADO DE ACTIVOS Y PERDIDA DE DOMINIO', 'DIVINLA',20,1,1,SYSDATE);
INSERT INTO EXP_DEPENDENCIA (ID, CODIGO, SIGLA, NOMBRE, ABREVIATURA, PADRE, ESTADO, CREADOR, CREACION ) VALUES (25, '00014',88,'DIVISION DE INVESTIGACION ESPECIALES', 'DIVINES',20,1,1,SYSDATE);

commit;

-- Insert Equipos DIVINHOM
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (1, 'DEPINHOM E-1','EQUIPO OPERATIVO N� 1', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (2, 'DEPINHOM E-2','EQUIPO OPERATIVO N� 2', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (3, 'DEPINHOM E-3','EQUIPO OPERATIVO N� 3', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (4, 'DEPINHOM E-4','EQUIPO OPERATIVO N� 4', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (5, 'DEPINHOM E-5','EQUIPO OPERATIVO N� 5', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (6, 'DEPINHOM E-6','EQUIPO OPERATIVO N� 6', 180,3, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (7, 'DEPINLES E-1','EQUIPO OPERATIVO N� 1', 180,4, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (8, 'DEPINLES E-2','EQUIPO OPERATIVO N� 2', 180,4, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (9, 'DEPINLES E-3','EQUIPO OPERATIVO N� 3', 180,4, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (10, 'DEPINLES E-4','EQUIPO OPERATIVO N� 4', 180,4, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (11, 'DEPINESP E-1','EQUIPO OPERATIVO N� 1', 180,5, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (12, 'DEPINESP E-2','EQUIPO OPERATIVO N� 2', 180,5, 1, 1,SYSDATE);
INSERT INTO ORG_EQUIPO (ID, CODIGO, NOMBRE, TIPO_AGRUPACION, DEPENDENCIA, ESTADO, CREADOR, CREACION) VALUES (13, 'DEPINESP E-3','EQUIPO OPERATIVO N� 3', 180,5, 1, 1,SYSDATE);

--Integrantes 
INSERT INTO SIETID.ORG_INTEGRANTE(ID, INTEGRANTE, EQUIPO, FUNCION, ES_LIDER, ESTADO, CREADOR, CREACION) VALUES(1,1,1,202,0,1,1, SYSDATE);
INSERT INTO SIETID.ORG_INTEGRANTE(ID, INTEGRANTE, EQUIPO, FUNCION, ES_LIDER, ESTADO, CREADOR, CREACION) VALUES(2,2,1,202,0,1,1, SYSDATE);

 

