--Usuarios
INSERT INTO SIETID.SEG_USUARIO (ID, NOMBRES, APE_PAT, APE_MAT, USUARIO, CLAVE, CARGO, DESC_CARGO) VALUES (1, 'Merlyn', 'Enriquez', 'Ordo�ez', 'menriquez', '1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75', 'Admimistrador', 'Administrador del Sistema');
INSERT INTO SIETID.SEG_USUARIO (ID, NOMBRES, APE_PAT, APE_MAT, USUARIO, CLAVE, CARGO, DESC_CARGO) VALUES (2, 'Elvis', 'Campos', 'Mori', 'ecampos', '1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75', 'Admimistrador', 'Administrador del Sistema');

--Preferencias de la Bandeja
INSERT INTO SIETID.SEG_PREFERENCIA (ID,USUARIO,TABLA,COLUMNA,ANCHO,COLAPSO) values ('1','1','requerimiento','ans|id|autogenerado|dependencia|tipoFinalidad|equipo|asunto|fechaRegistro|diasAtencion|estado|lugarHecho|horaHecho|direccionHecho|jurisdiccion|','60|60|100|100|100|100|100|100|100|100|100|100|100|100|','0|0|0|0|1|0|1|0|0|1|0|0|1|0|');

--Listas
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (1,'REGISTRO_ESTADO','Estado de registro','Estado de registro','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (2,'OPCION_TIPO','Tipo de opci�n','Tipo de opci�n','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (3,'DOCUMENTO_TIPO','Tipo de DOC','Tipo de documento de identidad','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (4,'TELEFONO_TIPO','Tipo de tel�fono','Tipo de telefono','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (5,'ADJUNTO_TIPO','Tipo de adjunto','Tipo de adjunto','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (6,'MONEDA','Tipo de Moneda','Tipo de Moneda','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (7,'TABLAS','Tipo de Tablas Ruta','Tipo de Tablas Ruta','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (8,'ENTIDAD_TIPO','Tipo de Entidad','Tipo de Entidad','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (9,'SIGLAS_DOC','Sigla del Documento por Dependencia','Sigla del Documento','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (10,'ESTADO_CIVIL','Tipo de Estado Civil','Tipo de Estado Civil','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (11,'CONTINENTE','Tipos de Continentes','Continentes a nivel geogr�fico','A',1,SYSDATE);

INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (12,'TIPO_CEJA','Tipos de Cejas','Tipos de cejas','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (13,'TIPO_OREJA','Tipos de Orejas','Tipos de Orejas','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (14,'COLOR_PIEL','Colores de Piel','Colores de Piel','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (15,'CONTEXTURA','Tipos de Contextura','Tipos de Contextura','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (16,'TIPO_CABELLO','Tipos de Cabellos','Tipos de Cabello','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (17,'TIPO_RAZA','Tipos de Raza','Tipos de Raza','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (18,'COLOR_CABELLO','Colores de Cabellos','Colores de Cabellos','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (19,'CORTE_CABELLO','Cortes de Cabello','Cortes de Cabello','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (20,'TIPO_OJO','Tipos de Ojos','Tipos de ojos','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (21,'COLOR_OJO','Colores de Ojos','Colores de Ojos','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (22,'TIPO_NARIZ','Tipos de Nariz','Tipos de Nariz','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (23,'FORMA_CARA','Formas de Cara','Forma de Cara','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (24,'TIPO_LABIO','Tipos de Labio','Tipos de Labio','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (25,'FORMA_BOCA','Formas de Boca','Formas de Boca','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (26,'PROFESION','Profesiones','Profesiones','A',1,SYSDATE);

INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (27,'PARENTESCO','Parentesco','Tipos de Parentescos','A',1,SYSDATE);

INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (28,'GRADO','Lista de Grados','Lista de Grados','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (29,'UNIDAD','Lista de Unidades','Lista de Unidades','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (30,'CARGO','Lista de Cargos','Lista de Cargos','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) VALUES (31,'TIPO_LETRADO','Lista de Tipo de Letrado','Lista de Tipo de Letrado','A',1,SYSDATE);

INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (32,'PRIORIDAD','Prioridad','Lista de Prioridad','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (33,'FINALIDAD','Finalidad','Lista de Finalidades','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (34,'CUENCA','Cuenca','Lista de Cuencas','A',1,SYSDATE);
INSERT INTO SIETID.CFG_LISTA (ID,CODIGO,NOMBRE,DESCRIPCION,ESTADO,CREADOR,CREACION) values (35,'TIPO_INTER','Tipo Interviniente','Tipos de Intervinientes','A',1,SYSDATE);

--Valores
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (1,1,'A','Activo','Activo',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (2,1,'I','Inactivo','Inactivo',2,'A',1,SYSDATE);

-- Valores Tipo de Opcion
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (3,2,'MEN','Men�','Opci�n que sirve para construir el men� de la aplicaci�n',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (4,2,'VEN','Ventana','Opci�n que sirve para controlar permisos sobre ventanas (que no se abren desde men�)',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (5,2,'ACC','Acci�n','Opci�n que permite controlar comportamiento sobre los botones de opciones de men� o ventanas',3,'A',1,SYSDATE);

-- Valores Tipo Documento
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (6,3,'L','DNI','DNI o libreta electoral',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (7,3,'E','Carn� de extranjer�a','Carn� de extranjer�a',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (8,3,'P','Pasaporte','Pasaporte',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (9,3,'T','Carn� policia','Carn� de fuerzas policiales',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (10,3,'D','Carn� diplomatico','Carn� diplomatico',5,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (11,3,'R','RUC','RUC',6,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (12,3,'J','Menor de edad','Menor de edad',7,'I',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (13,3,'M','Carn� militar','Carn� de identificacian militar',8,'I',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (14,3,'N','RUC antiguo','RUC antiguo de 8 posiciones',9,'I',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (15,3,'X','DOC extranjero','DOC extranjero',10,'I',1,SYSDATE);

-- Valores Tipo Telefono
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (16,4,'C','Celular','movistar.pe',0,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (17,4,'R','Radios','claro.pe',0,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (18,4,'F','Fijo','N�mero de telefono de casa',1,'A',1,SYSDATE);

--Listado de Tipos de Documentos Adjuntos
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (19,5,'COP_DNI','Copia DNI','Copia DNI',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (20,5,'DOC_DEN','Documento del Denunciante','Documento del Denunciante',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (21,5,'DEN_COM','Denuncia de la Comisar�a','Denuncia de la Comisar�a',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (22,5,'COP_POL','Copia P�liza','Copia P�liza',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (23,5,'COP_VOU','Copia Voucher','Copia Voucher',5,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (24,5,'COP_SOL','Solicitud Copia','Solicitud Copia',6,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (25,5,'COP_DEN','Constancia de la Denuncia','Constancia de la Denuncia',7,'I',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (26,5,'OTR_DOC','Otros documentos','Otros Documentos',8,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (27,5,'FOT_PER','Foto Personal','Fotos de la persona',7,'A',1,SYSDATE);

--Monedas
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (28,6,'PEN','PEN','Nuevo sol',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (29,6,'USD','USD','D�lar estadounidense',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (30,6,'EUR','EUR','Euro',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (31,6,'OTR','OTR','Otros',4,'A',1,SYSDATE);

--Tablas Relacionadas
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (34,7,'DEPE','EXP_DEPENDENCIA','Divisiones Especializadas',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (35,7,'ENTI','EXP_ENTIDAD','Entidades Varias',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (36,7,'EQUI','EXP_EQUIPO','Equipos de Trabajo',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (37,7,'MUNI','EXP_MUNICIONES','Munciones',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (38,7,'DTEL','EXP_DET_PER_TEL_EXP','Detalle de Telefonos',5,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (39,7,'DROG','EXP_DROGAS','Drogas',6,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (40,7,'EXPL','EXP_EXPLOSIVOS','Explosivos',7,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (41,7,'IMPO','EXP_IMPORTES','Importes',8,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (42,7,'DVEH','EXP_DET_PER_VEH_EXP','Detalle Vehiculos',9,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (43,7,'DARM','EXP_DET_PER_ARM_EXP','Detalle Armas ',10,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (44,7,'ESPE','EXP_ESPECIE','Especies Valoradas',11,'A',1,SYSDATE);

--Entidades 
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (50,8,'JUZG','Juzgado','Juzgados',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (51,8,'FISC','Fiscal�a','Fiscalias',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (52,8,'COMI','Comisar�a','Comisarias',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (54,8,'DIRE','Directa','Comisarias',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (55,8,'PENI','Penitenciar�a','Establecimiento Penitenciario',5,'A',1,sysdate);

-- Siglas de Documento
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (60,9,'DIRINCRI','DIRINCRI','DIRECCION DE INVESTIGACION CRIMINAL',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (61,9,'EM','DIRINCRI-EM','DIRINCRI - ESTADO MAYOR',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (62,9,'IN','DIRINCRI-IN','DIRINCRI - OFICINA DE INTELIGENCIA',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (63,9,'OFITEL','DIRINCRI-OFITEL','DIRINCRI - OFICINA DE TELEMATICA',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (64,9,'OFICRI','DIRINCRI-OFICRI','DIRINCRI - OFICINA DE CRIMINALISTICA',5,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (65,9,'DIVINHOM','DIRINCRI-DIVINHOM','DIRINCRI - DIVISION DE INVEST. DE HOMICIDIOS',6,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (66,9,'DIVINSEC','DIRINCRI-DIVINSEC','DIRINCRI - DIVISION DE INVEST. DE SECUESTROS',7,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (67,9,'DIVINROB','DIRINCRI-DIVINROB','DIRINCRI - DIVISION DE INVEST. DE ROBOS',8,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (68,9,'DIVIEOD','DIRINCRI-DIVIEOD','DIRINCRI - DIVISION DE INVEST. DE ESTAFAS Y OTRAS DEFRAUDACIONES',9,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (69,9,'DIVIBPD','DIRINCRI-DIVIBPD','DIRINCRI - DIVISION DE INVEST. DE BUSQUEDA DE PERSONAS DESAPARECIDAS',10,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (70,9,'DIPOLJUD','DIRINCRI-DIPOLJUD','DIRINCRI - DIVISION DE POLICIA JUDICIAL',11,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (71,9,'RQ','DIRINCRI-RQ','DIRINCRI - DIVISION DE REQUISITORIAS',12,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (72,9,'DIVIPDDMP','DIRINCRI-DIVIPDDMP','DIRINCRI - DIVISION POLICIAL DE INVEST. DE DEN. DERIVADAS POR EL MIN. PUB.',13,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (73,9,'DIVINDAT','DIRINCRI-DIVINDAT','DIRINCRI - DIVISION DE INVESTIGACION DE DELITOS DE ALTA TECNOLOGIA',14,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (74,9,'DIVINTRAP','DIRINCRI-DIVINTRAP','DIRINCRI - DIVISION DE INVESTIGACION DE DELITOS CONTRA LA TRATA DE PERSONAS ',15,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (75,9,'DIVINCRI','DIRINCRI-DIVINCRI','DIRINCRI - JEFATURA DE AREA DE INVESTIGACION CRIMINAL',16,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (76,9,'DIVINCRI ESTE','DIRINCRI-DIVINCRI ESTE','DIRINCRI-DIVINCRI ESTE',17,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (77,9,'DIVINCRI CENTRO','DIRINCRI-DIVINCRI CENTRO','DIRINCRI-DIVINCRI CENTRO',18,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (78,9,'DIVINCRI SUR','DIRINCRI-DIVINCRI SUR','DIRINCRI-DIVINCRI SUR',19,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (79,9,'DIVINCRI NORTE','DIRINCRI-DIVINCRI NORTE','DIRINCRI-DIVINCRI NORTE',20,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (80,9,'DIVINCRI CALLAO','DIRINCRI-DIVINCRI CALLAO','DIRINCRI-DIVINCRI CALLAO',21,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (81,9,'DIROVE','DIROVE','DIROVE- DIVISION DE INVEST. DE ROBOS DE VEHICULOS',22,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (82,9,'DIVILA','DIRINCRI-DIVILA','DIRECCION DE INVESTIGACION DE LAVADO DE ACTIVOS',23,'A',1,SYSDATE);
--DIRANDRO
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (83,9,'DIRANDRO','DIRANDRO','DIRECCION DE ANTIDROGAS',24,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (84,9,'DIRAPRE','DIRANDRO-PREVENCION','DIRANDRO - DIVISION DE PREVENCI�N DE TID',25,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (85,9,'DIRAINS','DIRANDRO-INSUMOS','DIRANDRO - DIVISION DE INVESTIGACION CONTRA DESVIO DE INSUMOS QUIMICOS',26,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (86,9,'DIRAINVE','DIRANDRO-INVESTIGACION','DIRANDRO - DIVISION DE INVESTIGACION DEL TID',27,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (87,9,'DIRALAV','DIRANDRO-LAVADO','DIRANDRO - DIVISION DE INVESTIGACION DE LAVADO DE ACTIVOS Y PERDIDA DE DOMINIO',28,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (88,9,'DIRAESP','DIRANDRO-ESPECIALES','DIRANDRO - DIVISION DE INVESTIGACION ESPECIALES',29,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (89,9,'DIRAPORT','DIRANDRO-PORTUARIA','DIRANDRO - DIVISION PORTUARIA ANTIDROGAS',30,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (90,9,'DIRAOPER','DIRANDRO-OPERACIONES','DIRANDRO - DIVISION EJECUTIVA DE OPERACIONES ESPECIALES ANTIDROGAS',31,'A',1,SYSDATE);

--Estado Civil
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (100,10,'S','Soltero','Soletro',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (101,10,'C','Casado','Casado',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (102,10,'D','Divorciado','Divorciado',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (103,10,'V','Viudo','Viudo',4,'A',1,SYSDATE);

--Continentes 
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (105,11,'AM','America','America',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (106,11,'EU','Europa','Europa',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (107,11,'AF','�frica','�frica',3,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (108,11,'AS','Asia','Asia',4,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (109,11,'OC','Ocean�a','Ocean�a',5,'A',1,SYSDATE);

---Razgos
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (110,12,'CEJA_POB','Cejas Pobladas','Cejas Pobladas',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (111,13,'OREJA_PT','Orejas Punteagudas','Orejas Punteagudas',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (112,14,'PIEL_CL','Piel Clara','Piel Clara',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (113,15,'CONTEX_GR','Contextura Gruesa','Contextura Gruesa',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (114,16,'CABELLO_LZ','Cabello Lazio','Cabello Lazio',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (115,17,'RAZA_MZ','Raza Mestiza','Raza Mestiza',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (116,18,'CABELLO_RB','Cabello Rubio','Cabello Rubio',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (117,19,'CORTE_ML','Corte Militar','Corte Militar',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (118,20,'OJO_RD','Ojos Redondos','Ojos Redondos',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (119,21,'OJO_PR','Pardos','Pardos',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (120,22,'NARIZ_AG','Nariz Aguile�a','Nariz Aguile�a',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (121,23,'CARA_RD','Cara Redonda','Cara Redonda',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (122,24,'LABIO_GR','Labio Grueso','Labio Grueso',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (123,25,'BOCA_NR','Boca Normal','Boca Normal',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (124,26,'PROF_ADM','Administrados','Administrador',1,'A',1,SYSDATE);

--Tipo de Parentesco
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (130,27,'PAR_HER','Hermano','Hermano',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (131,27,'PAR_PRI','Primo','Primo',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (132,27,'PAR_TIO','Tio','Tio',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (133,27,'PAR_SOB','Sobrino','Sobrino',1,'A',1,SYSDATE);


--Listado de Tipos de Documentos Adjuntos
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (140,6,'COP_DNI','Copia DNI','Copia DNI',1,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (141,6,'DOC_DEN','Documento del Denunciante','Documento del Denunciante',2,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (142,6,'DEN_COM','Denuncia de la Comisar�a','Denuncia de la Comisar�a',3,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (143,6,'COP_SOL','Solicitud Copia','Solicitud Copia',4,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (144,6,'COP_DEN','Constancia de la Denuncia','Constancia de la Denuncia',5,'I',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (145,6,'OTR_DOC','Otros documentos','Otros Documentos',6,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (146,6,'FOT_PER','Foto Personal','Fotos de la persona',7,'A',1,SYSDATE);

--Grados
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (147,28,'GR1','Grado 1','Grado 1',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (148,28,'GR2','Grado 2','Grado 2',2,'A',1,SYSDATE);

--Unidades
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (149,29,'UN1','Unidad 1','Unidad 1',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (150,29,'UN2','Unidad 2','Unidad 2',2,'A',1,SYSDATE);

--Cargos
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (151,30,'CR1','Cargo 1','Cargo 1',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (152,30,'CR2','Cargo 2','Cargo 2',2,'A',1,SYSDATE);

--Tipos de Letrado
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (153,31,'FIS','Fiscal','Fiscal',1,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (154,31,'JUE','Juez','Juez',2,'A',1,SYSDATE);
INSERT INTO SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) VALUES (155,31,'ABO','Abogado','Abogado',3,'A',1,SYSDATE);

INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (156,32,'NORM','Normal','Prioridad Normal',1,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (157,32,'URGT','Urgente','Prioridad Urgente',2,'A',1,SYSDATE);

--FIXME
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (158,33,'FIN_1','Finalidad 1','Finalidad 1',1,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (159,34,'CUENCA_1','Cuenca 1','Cuenca 1',1,'A',1,SYSDATE);
INSERT into SIETID.CFG_VALOR (ID,LISTA,CODIGO,NOMBRE,DESCRIPCION,ORDEN,ESTADO,CREADOR,CREACION) values (160,35,'INTER_1','Intervenido 1','Intervenido 1',1,'A',1,SYSDATE);
--END FIXME

commit;
