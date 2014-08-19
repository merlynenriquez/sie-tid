/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     19/08/2014 10:41:05 a.m.                     */
/*==============================================================*/
/* Table: CFG_LISTA                                             */
/*==============================================================*/
create table SIETID.CFG_LISTA 
(
   ID                   NUMBER(8)            not null,
   CODIGO               NVARCHAR2(15)        not null,
   NOMBRE               NVARCHAR2(50)        not null,
   DESCRIPCION          NVARCHAR2(250),
   ESTADO               NCHAR(1)             not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.CFG_LISTA
   add constraint PK_CFG_LISTA primary key (ID);

/*==============================================================*/
/* Index: UNQ_CODIGO_LISTA                                      */
/*==============================================================*/
create unique index SIETID.UNQ_CODIGO_LISTA on SIETID.CFG_LISTA (
   CODIGO ASC
);

/*==============================================================*/
/* Table: CFG_PARAMETRO                                         */
/*==============================================================*/
create table SIETID.CFG_PARAMETRO 
(
   CODIGO               NVARCHAR2(15)        not null,
   NOMBRE               NVARCHAR2(50)        not null,
   DESCRIPCION          NVARCHAR2(250),
   VALOR                NVARCHAR2(500)       not null,
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.CFG_PARAMETRO
   add constraint PK_CFG_PARAMETRO primary key (CODIGO);

/*==============================================================*/
/* Table: CFG_REGLA                                             */
/*==============================================================*/
create table SIETID.CFG_REGLA 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(10)        not null,
   NOMBRE               NVARCHAR2(100)       not null,
   REGLA                VARCHAR2(4000)       not null,
   TIPO_REGLA           NUMBER(16)           not null,
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.CFG_REGLA
   add constraint PK_CFG_REGLA primary key (ID);

/*==============================================================*/
/* Table: CFG_VALOR                                             */
/*==============================================================*/
create table SIETID.CFG_VALOR 
(
   ID                   NUMBER(16)           not null,
   LISTA                NUMBER(8)            not null,
   CODIGO               NVARCHAR2(15)        not null,
   NOMBRE               NVARCHAR2(50)        not null,
   ORDEN                NUMBER(8),
   DESCRIPCION          NVARCHAR2(250),
   ESTADO               NCHAR(1),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.CFG_VALOR
   add constraint PK_CFG_VALOR primary key (ID);

/*==============================================================*/
/* Index: UNQ_CODIGO_VALOR                                      */
/*==============================================================*/
create unique index SIETID.UNQ_CODIGO_VALOR on SIETID.CFG_VALOR (
   CODIGO ASC,
   LISTA ASC
);

/*==============================================================*/
/* Table: EXP_ABOGADO_PERSONA                                   */
/*==============================================================*/
create table EXP_ABOGADO_PERSONA 
(
   ID                   NUMBER(16)           not null,
   ABOGADO              NUMBER(16),
   PERSONA              NUMBER(16)           not null,
   ESTADO               NUMBER(16),
   FEC_INI_REPRESENTACION DATE,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table EXP_ABOGADO_PERSONA is
'Indica que abogado representa a que implicado';

comment on column EXP_ABOGADO_PERSONA.ID is
'pk';

comment on column EXP_ABOGADO_PERSONA.ABOGADO is
'tabla de autoridades';

comment on column EXP_ABOGADO_PERSONA.PERSONA is
'personas';

comment on column EXP_ABOGADO_PERSONA.ESTADO is
'para indiccar actividad o inactividad';

comment on column EXP_ABOGADO_PERSONA.FEC_INI_REPRESENTACION is
'fecha en que se conoce empieza a representarlo';

comment on column EXP_ABOGADO_PERSONA.CREADOR is
'Usuario de creaci�n';

comment on column EXP_ABOGADO_PERSONA.CREACION is
'Fecha de creaci�n';

comment on column EXP_ABOGADO_PERSONA.EDITOR is
'Usuario que modifica';

comment on column EXP_ABOGADO_PERSONA.EDICION is
'Fecha de modificaci�n';

alter table EXP_ABOGADO_PERSONA
   add constraint PK_EXP_ABOGADO_PERSONA primary key (ID);

/*==============================================================*/
/* Table: EXP_ADJUNTO                                           */
/*==============================================================*/
create table SIETID.EXP_ADJUNTO 
(
   ID                   NUMBER(16)           not null,
   TIPO                 NUMBER(16)           not null,
   RUTA                 NVARCHAR2(200),
   NOMBRE               NVARCHAR2(100)       not null,
   EXPEDIENTE           NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ADJUNTO is
'Adjunto del Expediente';

alter table SIETID.EXP_ADJUNTO
   add constraint PK_EXP_ADJUNTO primary key (ID);

/*==============================================================*/
/* Table: EXP_ANEXO                                             */
/*==============================================================*/
create table SIETID.EXP_ANEXO 
(
   ID                   NUMBER(16)           not null,
   DOCUMENTO            NUMBER(16),
   ADJUNTO              NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ANEXO is
'Este son los anexos que pueden ir cuando se entrega la informacion inicial de un documento. 
Por ejemplo: El documento tiene anexos como parte adjunto, oficios, notas informativas, etc.';

alter table SIETID.EXP_ANEXO
   add constraint PK_EXP_ANEXO primary key (ID);

/*==============================================================*/
/* Table: EXP_ARMAS                                             */
/*==============================================================*/
create table SIETID.EXP_ARMAS 
(
   ID                   NUMBER(16)           not null,
   MARCA                NUMBER(16),
   MODELO               NUMBER(16),
   CLASIFICACION        NUMBER(16),
   EST_SERIE            NUMBER(16),
   NRO_SERIE            NVARCHAR2(50),
   NRO_LICENCIA         NVARCHAR2(10),
   CALIBRE              NUMBER(16),
   INTERNAMIENTO        NVARCHAR2(50),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ARMAS is
'Tabla que guarda la informaci�n de las armas incautadas y registradas en un expediente							
';

comment on column SIETID.EXP_ARMAS.ID is
'Identificador de la tabla EXP_ARMA (c�digo autogenerado)
';

comment on column SIETID.EXP_ARMAS.MARCA is
'Identificador de la marca del arma
';

comment on column SIETID.EXP_ARMAS.MODELO is
'Identificador del modelo del arma
';

comment on column SIETID.EXP_ARMAS.CLASIFICACION is
'Identificador de la clasificaci�n: escopeta, fusil, revolver
';

comment on column SIETID.EXP_ARMAS.EST_SERIE is
'Identificador del estado de la serie del arma';

comment on column SIETID.EXP_ARMAS.NRO_SERIE is
'N�mero del serie del arma';

comment on column SIETID.EXP_ARMAS.NRO_LICENCIA is
'N�mero de licencia del arma';

comment on column SIETID.EXP_ARMAS.CALIBRE is
'N�mero de calibre del arma';

comment on column SIETID.EXP_ARMAS.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_ARMAS.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_ARMAS.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_ARMAS.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_ARMAS
   add constraint PK_EXP_ARMAS primary key (ID);

/*==============================================================*/
/* Table: EXP_CENTRO_POBLADO                                    */
/*==============================================================*/
create table SIETID.EXP_CENTRO_POBLADO 
(
   ID                   NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(200)       not null,
   CATEGORIA            NUMBER(16),
   DISTRITO             NUMBER(16),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint PK_EXP_CENTRO_POBLADO primary key (ID);

/*==============================================================*/
/* Table: EXP_DELITO                                            */
/*==============================================================*/
create table SIETID.EXP_DELITO 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(100),
   PADRE                NUMBER(16),
   NOMBRE               NVARCHAR2(200),
   ESTADO               NUMBER(16),
   TIPO_CODIGO          NUMBER(16),
   OBSERVACION          VARCHAR2(4000),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_DELITO
   add constraint PK_EXP_DELITO primary key (ID);

/*==============================================================*/
/* Table: EXP_DEPENDENCIA                                       */
/*==============================================================*/
create table SIETID.EXP_DEPENDENCIA 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(15),
   SIGLA                NUMBER(16),
   NOMBRE               NVARCHAR2(1000),
   ABREVIATURA          NVARCHAR2(1000),
   PADRE                NUMBER(16),
   ESTADO               NUMBER(16),
   DIRECCION            NVARCHAR2(300),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DEPENDENCIA is
'Tabla de Dependencias o unidades org�nicas';

comment on column SIETID.EXP_DEPENDENCIA.ID is
'Identificador';

comment on column SIETID.EXP_DEPENDENCIA.CODIGO is
'C�digo';

comment on column SIETID.EXP_DEPENDENCIA.SIGLA is
'Sigla';

comment on column SIETID.EXP_DEPENDENCIA.NOMBRE is
'Nombre de la dependencia';

comment on column SIETID.EXP_DEPENDENCIA.ABREVIATURA is
'Abreviatura';

comment on column SIETID.EXP_DEPENDENCIA.ESTADO is
'Estado activo o inactivo';

comment on column SIETID.EXP_DEPENDENCIA.DIRECCION is
'Direcci�n de la dependencia';

comment on column SIETID.EXP_DEPENDENCIA.CREADOR is
'Usuario creador';

comment on column SIETID.EXP_DEPENDENCIA.CREACION is
'Fecha creador';

comment on column SIETID.EXP_DEPENDENCIA.EDITOR is
'Usuario que edita';

comment on column SIETID.EXP_DEPENDENCIA.EDICION is
'Fecha de edici�n';

alter table SIETID.EXP_DEPENDENCIA
   add constraint PK_EXP_DEPENDENCIA primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_CRIMEN                                        */
/*==============================================================*/
create table SIETID.EXP_DET_CRIMEN 
(
   ID                   NUMBER(16)           not null,
   EXP_PER              NUMBER(16),
   EXP_DEL              NUMBER(16),
   PRIORIDAD            NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_DET_CRIMEN
   add constraint PK_EXP_DET_CRIMEN primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_DROGAS                                        */
/*==============================================================*/
create table EXP_DET_DROGAS 
(
   ID                   NUMBER(16)           not null,
   MODALIDAD            NUMBER(16),
   TRANSPORTE           NUMBER(16),
   DROGA                NUMBER(16),
   PERSONA              NUMBER(16),
   PARTICIPACION        NUMBER(16),
   ESTADO_PARTICIPACION NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table EXP_DET_DROGAS is
'Cada persona puede estar relacionada de diferentes formas con una droga incautada ( referencia DOC_TIPO_HECHO)';

comment on column EXP_DET_DROGAS.MODALIDAD is
'pastillas, momia';

comment on column EXP_DET_DROGAS.TRANSPORTE is
'aereo, terrestre';

comment on column EXP_DET_DROGAS.DROGA is
'FK con la droga incautada';

comment on column EXP_DET_DROGAS.PERSONA is
'id de persona a la que se le realciona directamente con esta droga';

comment on column EXP_DET_DROGAS.PARTICIPACION is
'Participaci�n Ejem: propietario, intermediario, vendedor, etc';

comment on column EXP_DET_DROGAS.ESTADO_PARTICIPACION is
'Estado por confirmar de la persona';

comment on column EXP_DET_DROGAS.CREADOR is
'Usuario Creador';

comment on column EXP_DET_DROGAS.CREACION is
'Fecha creaci�n';

alter table EXP_DET_DROGAS
   add constraint PK_EXP_DET_DROGAS primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_EXPEDIENTE_PERSONA                            */
/*==============================================================*/
create table SIETID.EXP_DET_EXPEDIENTE_PERSONA 
(
   ID                   NUMBER(16)           not null,
   INVOLUCRADO          NUMBER(16),
   EMPRESA              NUMBER(16),
   PARTICIPACION        NUMBER(16),
   TIPO_PARTICIPACION   NUMBER(16),
   ESTADO_DATO          NUMBER(16),
   EXPEDIENTE           NUMBER(16)           not null,
   REQUISITORIA         NUMBER(1),
   ORGANIZACION         NUMBER(16),
   OCUPACION            NUMBER(16),
   INTERVENCION         TIMESTAMP,
   SITUACION            NUMBER(16),
   ALIAS                NVARCHAR2(200),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_EXPEDIENTE_PERSONA is
'El tipo de participacion se refiere al papel que desempe�a en la banda o la organizacion.
Se esta pensando romper en una tabla detallle la posiblidad de relacionar de las personas que estan siendo represnetadas.';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.ID is
'Identificador';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.INVOLUCRADO is
'Identificador de la persona';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.EMPRESA is
'Identificador de la empresa';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.PARTICIPACION is
'Participaci�n ejem: delincuente, acusado, testigo';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.TIPO_PARTICIPACION is
'Tipo de participaci�n: la tabla de donde tomar� el dato para determinar la participaci�n';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.ESTADO_DATO is
'Estado del dato:Confirmado, Por confirmar (si la persona se ha confirmado su participacion)';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.EXPEDIENTE is
'Identificador del expediente';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.REQUISITORIA is
'Requisitoriado si/no';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.ORGANIZACION is
'Identificador de la organizaci�n';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.OCUPACION is
'Ocupaci�n';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.INTERVENCION is
'fecha de cuando se intervino';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.SITUACION is
'situacion del procesado';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.ALIAS is
'Alias';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.CREADOR is
'Usuario creador';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.CREACION is
'Fecha creaci�n';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.EDITOR is
'Usuario edita';

comment on column SIETID.EXP_DET_EXPEDIENTE_PERSONA.EDICION is
'Fecha edici�n';

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint PK_EXP_DET_EXPEDIENTE_PERSONA primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_LLAMADAS                                      */
/*==============================================================*/
create table SIETID.EXP_DET_LLAMADAS 
(
   ID                   NUMBER(16)           not null,
   EXP_PER_TEL          NUMBER(16),
   FECHA_HORA           TIMESTAMP,
   DURACION             NUMBER(10),
   NUMERO_MARCADO       VARCHAR2(50),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_LLAMADAS is
'Tabla que guarda la informaci�n del registro de llamadas del tel�fono (CDR) incautado y registrado en un expediente							
';

comment on column SIETID.EXP_DET_LLAMADAS.ID is
'Identificador de la tabla EXP_DET_PER_TEL_LLAMADAS (c�digo autogenerado)
';

comment on column SIETID.EXP_DET_LLAMADAS.EXP_PER_TEL is
'Identificador de la tabla del expediente - telefono incautado
';

comment on column SIETID.EXP_DET_LLAMADAS.FECHA_HORA is
'Fecha y hora de inicio de la llamada
';

comment on column SIETID.EXP_DET_LLAMADAS.DURACION is
'Duraci�n de la llamada (en segundos)
';

comment on column SIETID.EXP_DET_LLAMADAS.NUMERO_MARCADO is
'N�mero marcado
';

comment on column SIETID.EXP_DET_LLAMADAS.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_DET_LLAMADAS.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_DET_LLAMADAS.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_DET_LLAMADAS.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_DET_LLAMADAS
   add constraint PK_EXP_DET_LLAMADAS primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_PER_ARM_EXP                                   */
/*==============================================================*/
create table SIETID.EXP_DET_PER_ARM_EXP 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   ARMA                 NUMBER(16),
   EXPEDIENTE           NUMBER(16)           not null,
   PROPIETARIO          NUMBER(16),
   EMPRESA_PROPIETARIA  NUMBER(16),
   OBSERVACION          NVARCHAR2(400),
   SITUACION            NUMBER(16),
   CANTIDAD_MUNICION    NUMBER(10),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_PER_ARM_EXP is
'Tabla que guarda la informaci�n del arma incautada y registrada en un expediente							
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.ID is
'Identificador de la tabla EXP_DET_PER_ARM_EXP (c�digo autogenerado)
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.PERSONA is
'Identificador de la persona a la que le fue incautada el arma
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.ARMA is
'Identificador del arma
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.EXPEDIENTE is
'Identificador del expediente asociado a la incautaci�n
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.PROPIETARIO is
'Identificador del propietario del arma en la incautaci�n
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.EMPRESA_PROPIETARIA is
'Identificador de la empresa propietaria del arma en la incautaci�n
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.OBSERVACION is
'Observaciones';

comment on column SIETID.EXP_DET_PER_ARM_EXP.SITUACION is
'Identificador de la situaci�n del arma';

comment on column SIETID.EXP_DET_PER_ARM_EXP.CANTIDAD_MUNICION is
'Cantidad de munici�n encontrada cargada en el arma';

comment on column SIETID.EXP_DET_PER_ARM_EXP.ESTADO is
'Estado del arma incautada (operativo: si / no)
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_DET_PER_ARM_EXP.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint PK_EXP_DET_PER_ARM_EXP primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_PER_INM_EXP                                   */
/*==============================================================*/
create table SIETID.EXP_DET_PER_INM_EXP 
(
   ID                   NUMBER(16)           not null,
   INMUEBLE             NUMBER(16),
   EXPEDIENTE           NUMBER(16)           not null,
   PROPIETARIO          NUMBER(16),
   NUMERO_PISOS         NUMBER(10),
   TIPO_USO             NVARCHAR2(200),
   SITUACION            NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_PER_INM_EXP is
'Tabla que guarda la informaci�n del inmueble intervenido asociado a un expediente							
';

comment on column SIETID.EXP_DET_PER_INM_EXP.ID is
'Identificador de la tabla inmuebles-expediente (c�digo autogenerado)
';

comment on column SIETID.EXP_DET_PER_INM_EXP.INMUEBLE is
'Identificador del inmueble a relacionar con el expediente
';

comment on column SIETID.EXP_DET_PER_INM_EXP.EXPEDIENTE is
'Identificador del expediente al que se relaciona el inmueble
';

comment on column SIETID.EXP_DET_PER_INM_EXP.PROPIETARIO is
'Identificador del propietario  del inmueble en la intervenci�n 
';

comment on column SIETID.EXP_DET_PER_INM_EXP.NUMERO_PISOS is
'N�mero de pisos del inmueble en la intervenci�n 
';

comment on column SIETID.EXP_DET_PER_INM_EXP.TIPO_USO is
'Tipo de uso del inmueble  en la intervenci�n para el expediente
';

comment on column SIETID.EXP_DET_PER_INM_EXP.SITUACION is
'Situaci�n del inmueble en la intervenci�n para el expediente
';

comment on column SIETID.EXP_DET_PER_INM_EXP.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_DET_PER_INM_EXP.CREACION is
'Fecha y hora del sistema en que se relaiz� el registro.
';

comment on column SIETID.EXP_DET_PER_INM_EXP.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_DET_PER_INM_EXP.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_DET_PER_INM_EXP
   add constraint PK_EXP_DET_PER_INM_EXP primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_PER_TEL_EXP                                   */
/*==============================================================*/
create table SIETID.EXP_DET_PER_TEL_EXP 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   TELEFONO             NUMBER(16),
   EXPEDIENTE           NUMBER(16)           not null,
   IMEI                 NVARCHAR2(20),
   DUENO                NUMBER(16),
   SITUACION            NUMBER(16),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_PER_TEL_EXP is
'Tabla que guarda la informaci�n del telefono incautado asociado a un expediente';

comment on column SIETID.EXP_DET_PER_TEL_EXP.ID is
'Identificador de la tabla EXP_DET_PER_TEL_EXP (c�digo autogenerado)
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.PERSONA is
'Identificador de la persona asociada al tel�fono incautado
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.TELEFONO is
'Identificador del tel�fono incautado
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.EXPEDIENTE is
'Identificador del expediente
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.IMEI is
'Identificador internacional de identidad del equipo m�vil
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.DUENO is
'Identificador del due�o registrado del tel�fono incautado
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.SITUACION is
'Identificador de la situaci�n del tel�fono
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.ESTADO is
'Estado del tel�fono incautado (operativo: si / no)
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_DET_PER_TEL_EXP.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint PK_EXP_DET_PER_TEL_EXP primary key (ID);

/*==============================================================*/
/* Table: EXP_DET_PER_VEH_EXP                                   */
/*==============================================================*/
create table SIETID.EXP_DET_PER_VEH_EXP 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   PROPIETARIO          NUMBER(16),
   VEHICULO             NUMBER(16),
   EXPEDIENTE           NUMBER(16)           not null,
   SITUACION_LEGAL      NUMBER(16),
   ESTADO_MOTOR         NUMBER(16),
   ESTADO_CHASIS        NUMBER(16)           not null,
   TIPO_USO             VARCHAR(100),
   PLACA_MONTADA        VARCHAR2(100),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DET_PER_VEH_EXP is
'Tabla que guarda la informaci�n del veh�culo incautado y registrado en un expediente							
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.ID is
'Identificador de la tabla EXP_DET_PER_VEH_EXP (c�digo autogenerado)
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.PERSONA is
'Identificador de la persona a la que le fue incautado el veh�culo
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.PROPIETARIO is
'Propietario del vehiculo';

comment on column SIETID.EXP_DET_PER_VEH_EXP.VEHICULO is
'Identificador del veh�culo';

comment on column SIETID.EXP_DET_PER_VEH_EXP.EXPEDIENTE is
'Identificador del expediente asociado a la incautaci�n del veh�culo
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.SITUACION_LEGAL is
'Identificador de la situaci�n legal del veh�culo
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.ESTADO_MOTOR is
'Identificador del estado del motor del veh�culo';

comment on column SIETID.EXP_DET_PER_VEH_EXP.ESTADO_CHASIS is
'Identificador del estado del chasis del veh�culo';

comment on column SIETID.EXP_DET_PER_VEH_EXP.TIPO_USO is
'Descripci�n del uso del veh�culo';

comment on column SIETID.EXP_DET_PER_VEH_EXP.PLACA_MONTADA is
'Descripci�n de la placa montada del veh�culo (en caso fuera ese el caso)';

comment on column SIETID.EXP_DET_PER_VEH_EXP.ESTADO is
'Identificador del estado del veh�culo
condicion en que se encuentra. buen estado, usado, malogrado. etc';

comment on column SIETID.EXP_DET_PER_VEH_EXP.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_DET_PER_VEH_EXP.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint PK_EXP_DET_PER_VEH_EXP primary key (ID);

/*==============================================================*/
/* Table: EXP_DOCUMENTO                                         */
/*==============================================================*/
create table SIETID.EXP_DOCUMENTO 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16),
   TIPO_DOCUMENTO       NUMBER(16),
   NRO_DOCUMENTO        NVARCHAR2(80),
   ASUNTO               NVARCHAR2(500),
   DIAS_ATENCION        NUMBER(4),
   FECHA_RECEPCION      TIMESTAMP,
   FECHA_DOCUMENTO      TIMESTAMP,
   FOLIOS               NUMBER(4),
   ADJUNTO              NUMBER(16),
   PRIORIDAD            NUMBER(16),
   ES_INICIAL           CHAR(1),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DOCUMENTO is
'Para el registro de adjuntos y anexos
Todos los documentos "importantes" como informes, pruebas, etc, se registran en esta tabla. Los documentos pequenos van a ser tratados como adjuntos.';

comment on column SIETID.EXP_DOCUMENTO.ID is
'Identificador';

comment on column SIETID.EXP_DOCUMENTO.EXPEDIENTE is
'Identificador de expediente';

comment on column SIETID.EXP_DOCUMENTO.TIPO_DOCUMENTO is
'Tipo de documento';

comment on column SIETID.EXP_DOCUMENTO.NRO_DOCUMENTO is
'N�mero de documento';

comment on column SIETID.EXP_DOCUMENTO.ASUNTO is
'Asunto';

comment on column SIETID.EXP_DOCUMENTO.DIAS_ATENCION is
'Dias de atenci�n';

comment on column SIETID.EXP_DOCUMENTO.FECHA_RECEPCION is
'Fecha de recepci�n';

comment on column SIETID.EXP_DOCUMENTO.FECHA_DOCUMENTO is
'Fecha de documento';

comment on column SIETID.EXP_DOCUMENTO.FOLIOS is
'Foliod';

comment on column SIETID.EXP_DOCUMENTO.ADJUNTO is
'Id de la tabla adjunto';

comment on column SIETID.EXP_DOCUMENTO.PRIORIDAD is
'Prioridad';

comment on column SIETID.EXP_DOCUMENTO.ES_INICIAL is
'Indica si este documento es el primero y que da inicio al expediente';

comment on column SIETID.EXP_DOCUMENTO.CREADOR is
'Usuario creador';

comment on column SIETID.EXP_DOCUMENTO.CREACION is
'Fecha creaci�n';

comment on column SIETID.EXP_DOCUMENTO.EDITOR is
'Usuario que edita';

comment on column SIETID.EXP_DOCUMENTO.EDICION is
'Fecha edici�n';

alter table SIETID.EXP_DOCUMENTO
   add constraint PK_EXP_DOCUMENTO primary key (ID);

/*==============================================================*/
/* Table: EXP_DROGAS                                            */
/*==============================================================*/
create table SIETID.EXP_DROGAS 
(
   ID                   NUMBER(16)           not null,
   TIPO_DROGA           NUMBER(16),
   TIPO_MEDIDA          NUMBER(16),
   PESO_BRUTO           NUMBER(10,2),
   PESO_NETO            NUMBER(10,2),
   EXPEDIENTE           NUMBER(16),
   PROCENDECIA          NUMBER(16),
   DESTINO              NUMBER(16),
   SITUACION            NUMBER(16),
   TIPO_MEDIDA_MUESTRA  NUMBER(16),
   PESO_MUESTRA         NUMBER(10,2),
   VALOR_SOLES          NUMBER(10,2),
   VALOR_DOLARES        NUMBER(10,2),
   TIPO_CAMBIO          NUMBER(10,2),
   OBSERVACION          NVARCHAR2(800),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_DROGAS is
'Tipo de Droga (Ref. a la tabla GEN_DECOMISO_INCAUTACION) marihuana,pbc, cocaina';

alter table SIETID.EXP_DROGAS
   add constraint PK_EXP_DROGAS primary key (ID);

/*==============================================================*/
/* Table: EXP_ENTIDAD                                           */
/*==============================================================*/
create table SIETID.EXP_ENTIDAD 
(
   ID                   NUMBER(16)           not null,
   TIPO                 NUMBER(16),
   NOMBRE               NVARCHAR2(500),
   DESCRIPCION          NVARCHAR2(1000),
   DIRECCION            NVARCHAR2(300),
   DISTRITO             NUMBER(16),
   TELEFONO             NVARCHAR2(200),
   DIRTEPOL             NUMBER(6),
   CORREO               NVARCHAR2(200),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ENTIDAD is
'Tabla que guarda la informaci�n de las entidades intervinientes (juzgados, fiscalias, letrados, OJ)							
';

comment on column SIETID.EXP_ENTIDAD.ID is
'Identificador de la tabla EXP_ENTIDAD (c�digo autogenerado)
';

comment on column SIETID.EXP_ENTIDAD.TIPO is
'Identificador del tipo de entidad: juzgados, comisarias
';

comment on column SIETID.EXP_ENTIDAD.NOMBRE is
'Nombre de la entidad';

comment on column SIETID.EXP_ENTIDAD.DESCRIPCION is
'Descripci�n de la entidad';

comment on column SIETID.EXP_ENTIDAD.DIRECCION is
'Direcci�n de la entidad';

comment on column SIETID.EXP_ENTIDAD.DISTRITO is
'Identificador del distrito';

comment on column SIETID.EXP_ENTIDAD.TELEFONO is
'N�mero de tel�fono';

comment on column SIETID.EXP_ENTIDAD.CORREO is
'Correo electr�nico';

comment on column SIETID.EXP_ENTIDAD.ESTADO is
'Identificador del estado de la entidad';

comment on column SIETID.EXP_ENTIDAD.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_ENTIDAD.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_ENTIDAD.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_ENTIDAD.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_ENTIDAD
   add constraint PK_EXP_ENTIDAD primary key (ID);

/*==============================================================*/
/* Table: EXP_ESPECIE                                           */
/*==============================================================*/
create table SIETID.EXP_ESPECIE 
(
   ID                   NUMBER(16)           not null,
   TIPO_ESPECIE         NUMBER(16),
   TIPO_MEDIDA          NUMBER(16),
   MEDIDA               NUMBER(10,4),
   NOMBRE               NVARCHAR2(200),
   EXPEDIENTE           NUMBER(16),
   SITUACION            NUMBER(16),
   ESTADO               NUMBER(16),
   SERIE                VARCHAR2(50),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ESPECIE is
'Tabla que almacena la informaci�n de las especies incautadas y registradas en un expediente, se considera una especie a todo objeto incautado que no sea (droga, arma, veh�culo o  explosivo)							
';

comment on column SIETID.EXP_ESPECIE.ID is
'Identificador de la tabla especie (c�digo autogenerado)
';

comment on column SIETID.EXP_ESPECIE.TIPO_ESPECIE is
'Id del tipo de especie el cual define el tipo/familia: "electrodom�sticos, ropa, v�veres, etc"
';

comment on column SIETID.EXP_ESPECIE.TIPO_MEDIDA is
'Id del valor de la unidad de medida de la especie (kg, ml, unidad)
';

comment on column SIETID.EXP_ESPECIE.MEDIDA is
'Valor de la medida de la especie en base al tipo de medida establecido

';

comment on column SIETID.EXP_ESPECIE.NOMBRE is
'Nombre de la especie
';

comment on column SIETID.EXP_ESPECIE.EXPEDIENTE is
'Identificador del expediente al que pertenece la especie registrada
';

comment on column SIETID.EXP_ESPECIE.SITUACION is
'"Identificador de la situaci�n de la especie: incautada / devuelta
"

';

comment on column SIETID.EXP_ESPECIE.ESTADO is
'Estado de la especie incautada (operativo: si / no)
';

comment on column SIETID.EXP_ESPECIE.SERIE is
'N�mero de serie de la especie
';

comment on column SIETID.EXP_ESPECIE.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_ESPECIE.CREACION is
'Fecha y hora del sistema en que se relaiz� el registro.
';

comment on column SIETID.EXP_ESPECIE.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_ESPECIE.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_ESPECIE
   add constraint PK_EXP_ESPECIE primary key (ID);

/*==============================================================*/
/* Table: EXP_ESTADO                                            */
/*==============================================================*/
create table SIETID.EXP_ESTADO 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(15),
   NOMBRE               NVARCHAR2(50)        not null,
   DESCRIPCION          NVARCHAR2(200),
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ESTADO is
'movimientos que hace el expediente.
cREADO, EN PROCECSO, FINALIZADO, ELIMINADO, DERIVADO, DEVUELTO';

alter table SIETID.EXP_ESTADO
   add constraint PK_EXP_ESTADO primary key (ID);

/*==============================================================*/
/* Table: EXP_EXPEDIENTE                                        */
/*==============================================================*/
create table SIETID.EXP_EXPEDIENTE 
(
   ID                   NUMBER(16)           not null,
   AUTOGENERADO         NVARCHAR2(50),
   PADRE                NUMBER(16),
   NOMBRE_CASO          NVARCHAR2(200),
   TIPO_HECHO           NUMBER(16),
   DESCRIPCION          NVARCHAR2(200),
   DEPENDENCIA          NUMBER(16),
   TIPO_FINALIDAD       NUMBER(16),
   INTEGRANTE           NUMBER(16),
   ASUNTO               VARCHAR2(500 BYTE),
   FECHA_REGISTRO       TIMESTAMP,
   DIAS_ATENCION        NUMBER(4),
   ESTADO_EXP           NUMBER(16)           not null,
   LUGAR_HECHO          NUMBER(16),
   HORA_HECHO           TIMESTAMP,
   TIPO_DIRECCION       NUMBER(16),
   DIRECCION_HECHO      VARCHAR2(200 BYTE),
   REFERENCIA_HECHO     VARCHAR2(300 BYTE),
   JURISDICCION_HECHO   NUMBER(16),
   CODIGO_INTERVINIENTE NUMBER(16),
   TABLA_INTERVINIENTE  NUMBER(16),
   CENTRO_POBLADO       NUMBER(16),
   CUENCA               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_EXPEDIENTE is
'PARTE POLICIAL';

comment on column SIETID.EXP_EXPEDIENTE.ID is
'Identificador';

comment on column SIETID.EXP_EXPEDIENTE.AUTOGENERADO is
'Autgenerado';

comment on column SIETID.EXP_EXPEDIENTE.PADRE is
'Identificador del c�digo del expediente padre';

comment on column SIETID.EXP_EXPEDIENTE.NOMBRE_CASO is
'Nombre como le llaman al caso (Caso Thalia Paquete)';

comment on column SIETID.EXP_EXPEDIENTE.TIPO_HECHO is
'Tipo del Hecho';

comment on column SIETID.EXP_EXPEDIENTE.DESCRIPCION is
'Descripci�n del expediente';

comment on column SIETID.EXP_EXPEDIENTE.DEPENDENCIA is
'Unidad org�nica (que unidad de investigacion lo va a revisar)';

comment on column SIETID.EXP_EXPEDIENTE.TIPO_FINALIDAD is
'Tipo de finalidad (Investigacion, amplicacion)';

comment on column SIETID.EXP_EXPEDIENTE.INTEGRANTE is
'instructor a cargo';

comment on column SIETID.EXP_EXPEDIENTE.ASUNTO is
'Asunto';

comment on column SIETID.EXP_EXPEDIENTE.FECHA_REGISTRO is
'Fecha de registro';

comment on column SIETID.EXP_EXPEDIENTE.DIAS_ATENCION is
'Dias de atenci�n';

comment on column SIETID.EXP_EXPEDIENTE.ESTADO_EXP is
'Estado o movimientos del expediente';

comment on column SIETID.EXP_EXPEDIENTE.LUGAR_HECHO is
'Lugar del hecho (Distrito)';

comment on column SIETID.EXP_EXPEDIENTE.DIRECCION_HECHO is
'La direccion completa del hecho ';

comment on column SIETID.EXP_EXPEDIENTE.REFERENCIA_HECHO is
'Referencia';

comment on column SIETID.EXP_EXPEDIENTE.CODIGO_INTERVINIENTE is
'Interviniente es diferente a la procedencia o apertura del documento';

comment on column SIETID.EXP_EXPEDIENTE.CUENCA is
'dato de la tabla valor';

alter table SIETID.EXP_EXPEDIENTE
   add constraint PK_EXP_EXPEDIENTE primary key (ID);

/*==============================================================*/
/* Table: EXP_EXPEDIENTE_DELITO                                 */
/*==============================================================*/
create table SIETID.EXP_EXPEDIENTE_DELITO 
(
   ID                   NUMBER(16)           not null,
   DELITO               NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16)           not null,
   PRIORIDAD            NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint AK_UNIQUE_EXP_DELITO_EXP_EXPE unique (DELITO, EXPEDIENTE, PRIORIDAD);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint PK_EXP_EXPEDIENTE_DELITO primary key (ID);

/*==============================================================*/
/* Table: EXP_EXPEDIENTE_MEDIOS_MOVIL                           */
/*==============================================================*/
create table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL 
(
   ID                   NUMBER(16)           not null,
   MEDIO_MOVIL          NUMBER(16),
   CRIMEN               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   add constraint PK_EXP_EXPEDIENTE_MEDIOS_MOVIL primary key (ID);

/*==============================================================*/
/* Table: EXP_EXPLOSIVOS                                        */
/*==============================================================*/
create table SIETID.EXP_EXPLOSIVOS 
(
   ID                   NUMBER(16)           not null,
   TIPO                 NUMBER(10),
   PERSONA              number(16)           not null,
   EXPEDIENTE           NUMBER(16),
   PROPIETARIO          NUMBER(16),
   EMPRESA_PROPIETARIA  NUMBER(16),
   TIPO_DESCRIPCION     NUMBER(10),
   DESCRIPCION          VARCHAR2(50),
   MARCA                NUMBER(16),
   SERIE                VARCHAR2(50),
   OBSERVACION          VARCHAR2(100),
   TIPO_MEDIDA          NUMBER(16),
   MEDIDA               NUMBER(10,4),
   ESTADO               NUMBER(16),
   SITUACION            NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_EXPLOSIVOS is
'Tabla que guarda la informaci�n del explosivo incautado y registrado en un expediente							
';

comment on column SIETID.EXP_EXPLOSIVOS.ID is
'Identificador de la tabla EXP_EXPLOSIVOS (c�digo autogenerado)
';

comment on column SIETID.EXP_EXPLOSIVOS.TIPO is
'Identificador del tipo de explosivo (familia): alto orden / bajo orden
';

comment on column SIETID.EXP_EXPLOSIVOS.PERSONA is
'Identificador de la persona a la que le fue incautada el explosivo
';

comment on column SIETID.EXP_EXPLOSIVOS.EXPEDIENTE is
'Identificador del expediente asociado a la incautaci�n
';

comment on column SIETID.EXP_EXPLOSIVOS.PROPIETARIO is
'Identificador del propietario del explosivo en la incautaci�n
';

comment on column SIETID.EXP_EXPLOSIVOS.EMPRESA_PROPIETARIA is
'Identificador de la empresa propietaria del explosivo en la incautaci�n
';

comment on column SIETID.EXP_EXPLOSIVOS.TIPO_DESCRIPCION is
'Identificador del tipo de descripci�n del explosivo: Explosivo pl�stico, TNT
';

comment on column SIETID.EXP_EXPLOSIVOS.DESCRIPCION is
'"Descripci�n del explosivo
"
';

comment on column SIETID.EXP_EXPLOSIVOS.MARCA is
'Marca del explosivo';

comment on column SIETID.EXP_EXPLOSIVOS.SERIE is
'Serie del explosivo';

comment on column SIETID.EXP_EXPLOSIVOS.OBSERVACION is
'Observaci�n del explosivo

';

comment on column SIETID.EXP_EXPLOSIVOS.TIPO_MEDIDA is
'cartuchos, kg, unidades';

comment on column SIETID.EXP_EXPLOSIVOS.MEDIDA is
'valor del explosivo incautado en base a su tipo de medida';

comment on column SIETID.EXP_EXPLOSIVOS.ESTADO is
'estado de conservaci�n (operativo: si / no)
';

comment on column SIETID.EXP_EXPLOSIVOS.SITUACION is
'Estado del explosivo incautado 
';

comment on column SIETID.EXP_EXPLOSIVOS.CREADOR is
'Id del usuario del sistema que ha realizado el registro.
';

comment on column SIETID.EXP_EXPLOSIVOS.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_EXPLOSIVOS.EDITOR is
'Id del usuario del sistema que ha realizado la modificaci�n del registro.
';

comment on column SIETID.EXP_EXPLOSIVOS.EDICION is
'Fecha y hora del sistema en que se realiz� la modificaci�n del registro.
';

alter table SIETID.EXP_EXPLOSIVOS
   add constraint PK_EXP_EXPLOSIVOS primary key (ID);

/*==============================================================*/
/* Table: EXP_IMPORTES                                          */
/*==============================================================*/
create table SIETID.EXP_IMPORTES 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16),
   TIPO_MONEDA          NUMBER(16),
   MONEDA               NUMBER(10,2),
   TIPO_CUENTA          NUMBER(16),
   NRO_CUENTA           NVARCHAR2(20),
   NRO_TARJETA          NVARCHAR2(24),
   BANCO                NUMBER(16),
   SITUACION            NUMBER(16),
   ESTADO_MONEDA        NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_IMPORTES
   add constraint PK_EXP_IMPORTES primary key (ID);

/*==============================================================*/
/* Table: EXP_INMUEBLE                                          */
/*==============================================================*/
create table SIETID.EXP_INMUEBLE 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(15),
   DESCRIPCION          NVARCHAR2(200),
   TIPO_DIRECCION       NUMBER(16),
   DIRECCION            NVARCHAR2(200),
   URBANIZACION         NVARCHAR2(200),
   UBICACION            NUMBER(16),
   NRO_INSCRIPCION      NVARCHAR2(50),
   OFICINA_REGISTRAL    NVARCHAR2(50),
   RESOLUCION           NVARCHAR2(50),
   VALOR_BIEN           NUMBER(10,2),
   VALOR_TERRENO        NUMBER(10,2),
   OBSERVACIONES        NVARCHAR2(400),
   LONGITUD             NVARCHAR2(50),
   LATITUD              NVARCHAR2(50),
   DIMENSION            NUMBER(10,2),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_INMUEBLE is
'Tabla que almacena la informaci�n del inmueble							
';

comment on column SIETID.EXP_INMUEBLE.ID is
'Identificador de la tabla inmuebles (c�digo autogenerado)
';

comment on column SIETID.EXP_INMUEBLE.CODIGO is
'C�digo del inmueble
';

comment on column SIETID.EXP_INMUEBLE.DESCRIPCION is
'Descripci�n del inmueble';

comment on column SIETID.EXP_INMUEBLE.TIPO_DIRECCION is
'Identificador del tipo de direcci�n clasificaci�n: Jr., Av., Calle, Mz, Lt
';

comment on column SIETID.EXP_INMUEBLE.DIRECCION is
'Descripci�n de la direcci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.URBANIZACION is
'Descripci�n de la urbanizaci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.UBICACION is
'Identificador de la ubicaci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.NRO_INSCRIPCION is
'N�mero de inscripci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.OFICINA_REGISTRAL is
'Oficina registral del inmueble (SUNARP)';

comment on column SIETID.EXP_INMUEBLE.RESOLUCION is
'N�mero de resoluci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.VALOR_BIEN is
'Valor del inmueble en soles
';

comment on column SIETID.EXP_INMUEBLE.VALOR_TERRENO is
'Valor del terreno en soles
';

comment on column SIETID.EXP_INMUEBLE.OBSERVACIONES is
'Observaci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.LONGITUD is
'Longitud: georeferenciaci�n del inmueble
';

comment on column SIETID.EXP_INMUEBLE.LATITUD is
'Latitud : georeferenciaci�n del inmueble';

comment on column SIETID.EXP_INMUEBLE.DIMENSION is
'Dimensi�n en m2 del inmueble';

comment on column SIETID.EXP_INMUEBLE.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_INMUEBLE.CREACION is
'Fecha y hora del sistema en que se relaiz� el registro.
';

comment on column SIETID.EXP_INMUEBLE.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_INMUEBLE.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_INMUEBLE
   add constraint PK_EXP_INMUEBLE primary key (ID);

/*==============================================================*/
/* Table: EXP_INSTALACION                                       */
/*==============================================================*/
create table SIETID.EXP_INSTALACION 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16),
   TIPO                 NUMBER(16),
   ORGANIZACION         NUMBER(16),
   NOMBRE               NVARCHAR2(200),
   DESCRIPCION          NVARCHAR2(2000),
   CENTRO_POBLADO       NUMBER(16),
   SITUACION            NUMBER(16),
   LONGITUD             NVARCHAR2(20),
   LATITUD              NVARCHAR2(20),
   LARGO_MT             NUMBER(4),
   ANCHO_MT             NUMBER(4),
   ALTURA_MT            NUMBER(4),
   UBICACION            NUMBER(16),
   ZONA_PRODUCCION      NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_INSTALACION
   add constraint PK_EXP_INSTALACION primary key (ID);

/*==============================================================*/
/* Table: EXP_MUNICIONES                                        */
/*==============================================================*/
create table SIETID.EXP_MUNICIONES 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16),
   PERSONA              NUMBER(16),
   PROPIETARIO          NUMBER(16),
   EMPRESA_PROPIETARIA  NUMBER(16),
   CALIBRE              NUMBER(10),
   TIPO                 NUMBER(16),
   DESCRIPCION          VARCHAR2(50),
   MARCA                NUMBER(16),
   OBSERVACION          VARCHAR2(100),
   TIPO_MEDIDA          NUMBER(16),
   MEDIDA               NUMBER(10,4),
   ESTADO               NUMBER(16),
   SITUACION            NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_MUNICIONES is
'Tabla que guarda la informaci�n de las municiones incautadas y registradas en un expediente							
';

comment on column SIETID.EXP_MUNICIONES.ID is
'Identificador de la tabla EXP_MUNICIONES (c�digo autogenerado)
';

comment on column SIETID.EXP_MUNICIONES.EXPEDIENTE is
'Identificador del expediente asociado a la munici�n incautada
';

comment on column SIETID.EXP_MUNICIONES.PERSONA is
'Identificador de la persona a la que le fue incautada la munici�n
';

comment on column SIETID.EXP_MUNICIONES.PROPIETARIO is
'Persona propietaria de la munici�n en la incautaci�n
';

comment on column SIETID.EXP_MUNICIONES.EMPRESA_PROPIETARIA is
'Empresa propietaria de la munici�n en la incautaci�n
';

comment on column SIETID.EXP_MUNICIONES.CALIBRE is
'Calibre de la munici�n incautada
';

comment on column SIETID.EXP_MUNICIONES.TIPO is
'Identificador del tipo de munici�n
';

comment on column SIETID.EXP_MUNICIONES.DESCRIPCION is
'Descripci�n de la munici�n
';

comment on column SIETID.EXP_MUNICIONES.MARCA is
'Identificador de la marca de la municion';

comment on column SIETID.EXP_MUNICIONES.OBSERVACION is
'Activo o Inactivo
';

comment on column SIETID.EXP_MUNICIONES.TIPO_MEDIDA is
'Tipo de medida de la munici�n (unidades, caserinas, rafagas)
';

comment on column SIETID.EXP_MUNICIONES.MEDIDA is
'Valor del tipo de medida de la munici�n
';

comment on column SIETID.EXP_MUNICIONES.ESTADO is
'Estado de la munici�n incautada (operativo: si / no)
';

comment on column SIETID.EXP_MUNICIONES.SITUACION is
'situacion de la tabla general de situaciones
';

comment on column SIETID.EXP_MUNICIONES.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_MUNICIONES.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_MUNICIONES.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_MUNICIONES.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_MUNICIONES
   add constraint PK_EXP_MUNICIONES primary key (ID);

/*==============================================================*/
/* Table: EXP_ORGANIZACION                                      */
/*==============================================================*/
create table SIETID.EXP_ORGANIZACION 
(
   ID                   NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(150),
   DESCRIPCION          NVARCHAR2(150),
   CAMPO                NVARCHAR2(350),
   NRO_INTEGRANTES      NUMBER(5),
   ZONA_OPERACION       NVARCHAR2(250),
   UBICACION_ACTIVOS    NVARCHAR2(250),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_ORGANIZACION is
'Banda u/o Organizacion delictiva';

comment on column SIETID.EXP_ORGANIZACION.ID is
'Identificador';

comment on column SIETID.EXP_ORGANIZACION.NOMBRE is
'Nombre de la banda';

comment on column SIETID.EXP_ORGANIZACION.DESCRIPCION is
'Descripci�n de la banda';

comment on column SIETID.EXP_ORGANIZACION.NRO_INTEGRANTES is
'N�mero de integrantes';

comment on column SIETID.EXP_ORGANIZACION.ZONA_OPERACION is
'Zona de operaci�n';

comment on column SIETID.EXP_ORGANIZACION.UBICACION_ACTIVOS is
'Ubicaci�n de activos';

comment on column SIETID.EXP_ORGANIZACION.CREADOR is
'Usuario creaci�n';

comment on column SIETID.EXP_ORGANIZACION.CREACION is
'Fecha creaci�n';

comment on column SIETID.EXP_ORGANIZACION.EDITOR is
'Usuario edici�n';

comment on column SIETID.EXP_ORGANIZACION.EDICION is
'Fecha edici�n';

alter table SIETID.EXP_ORGANIZACION
   add constraint PK_EXP_ORGANIZACION primary key (ID);

/*==============================================================*/
/* Table: EXP_PREDECESOR                                        */
/*==============================================================*/
create table SIETID.EXP_PREDECESOR 
(
   ID                   NUMBER(16)           not null,
   DEPENDENCIA          NUMBER(16),
   PREDECESOR           NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.EXP_PREDECESOR
   add constraint PK_EXP_PREDECESOR primary key (ID);

/*==============================================================*/
/* Table: EXP_RUTA                                              */
/*==============================================================*/
create table SIETID.EXP_RUTA 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16)           not null,
   TABLA_ORIGEN         NUMBER(16),
   CODIGO_ORIGEN        NUMBER(16),
   TABLA_DESTINO        NUMBER(16),
   CODIGO_DESTINO       NUMBER(16),
   INTEGRANTE           NUMBER(16),
   FECHA_ENVIO          TIMESTAMP,
   USUARIO_ORIGEN       NUMBER(16),
   USUARIO_RECEPCION    NUMBER(16),
   FECHA_RECEPCION      TIMESTAMP,
   OBSERVACION          NVARCHAR2(1000),
   ESTADO_RUTA          NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_RUTA is
'tabla origen: biene de la policia, tabla destino: va a una fiscalia
tabla origen: oficina A, tabla destino: Oficina B
';

comment on column SIETID.EXP_RUTA.TABLA_ORIGEN is
'Oficina A/ policia';

comment on column SIETID.EXP_RUTA.TABLA_DESTINO is
'oficina B / entidad X';

comment on column SIETID.EXP_RUTA.USUARIO_ORIGEN is
'cuando es movimiento interno';

comment on column SIETID.EXP_RUTA.USUARIO_RECEPCION is
'usuario que esta con la session activa. null si es un derivo a entidad externa';

comment on column SIETID.EXP_RUTA.OBSERVACION is
'en caso sea hacia una entidad externa, el detalle de quien lo ha recepcionado se deberia registrar aqui';

comment on column SIETID.EXP_RUTA.ESTADO_RUTA is
'estado del registro: atendido, pendiente';

alter table SIETID.EXP_RUTA
   add constraint PK_EXP_RUTA primary key (ID);

/*==============================================================*/
/* Table: EXP_SITUACION_GENERAL                                 */
/*==============================================================*/
create table SIETID.EXP_SITUACION_GENERAL 
(
   ID                   NUMBER(16)           not null,
   ID_REGISTRO          NUMBER(16),
   TABLA                NUMBER(16),
   SITUACION            NUMBER(16),
   FECHA                TIMESTAMP,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_SITUACION_GENERAL is
'para registrar el cambio de estado en la situacion de explosivos, vehiculos, especies. Esta tabla no tendra interfaz grafica, solo se usara para conservar el detalle y generar  mejores reportes
EXP_MUNICIONES
EXP_DET_PER_TEL_EXP
EXP_DROGAS
EXP_EXPLOSIVOS
EXP_IMPORTES
EXP_DET_PER_VEH_EXP
EXP_DET_PER_ARM_EXP
EXP_ESPECIE';

comment on column SIETID.EXP_SITUACION_GENERAL.ID is
'id autogenerado';

comment on column SIETID.EXP_SITUACION_GENERAL.ID_REGISTRO is
'id del registro referenciado';

comment on column SIETID.EXP_SITUACION_GENERAL.TABLA is
'tabla en la cual esta el registro';

comment on column SIETID.EXP_SITUACION_GENERAL.SITUACION is
'tipo de accion realizada o tipo de movimiento';

comment on column SIETID.EXP_SITUACION_GENERAL.FECHA is
'fecha en que se realizo la accion';

alter table SIETID.EXP_SITUACION_GENERAL
   add constraint PK_EXP_SITUACION_GENERAL primary key (ID);

/*==============================================================*/
/* Table: EXP_TIPO_HECHO                                        */
/*==============================================================*/
create table SIETID.EXP_TIPO_HECHO 
(
   ID                   NUMBER(16)           not null,
   PADRE                NUMBER(16),
   NOMBRE               NVARCHAR2(200)       not null,
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on column SIETID.EXP_TIPO_HECHO.ESTADO is
'activo/ inactivo';

alter table SIETID.EXP_TIPO_HECHO
   add constraint PK_EXP_TIPO_HECHO primary key (ID);

/*==============================================================*/
/* Table: EXP_VEHICULO                                          */
/*==============================================================*/
create table SIETID.EXP_VEHICULO 
(
   ID                   NUMBER(16)           not null,
   TIPO_TAMANO          NUMBER(16),
   TRANSMISION          NUMBER(16),
   CILINDROS            NUMBER(16)           not null,
   SERIE_MOTOR          NVARCHAR2(50),
   SERIE_CHASIS         NVARCHAR2(50),
   PLACA                NVARCHAR2(100),
   MODELO               NUMBER(16),
   ANO                  NUMBER(16),
   COLOR                NUMBER(16),
   OBSERVACIONES        NVARCHAR2(400),
   PROPIETARIO          NUMBER(16),
   MODELO_ESPECIFICO    VARCHAR2(50),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.EXP_VEHICULO is
'Tabla que almacena la informaci�n del veh�culo							
';

comment on column SIETID.EXP_VEHICULO.ID is
'Identificador de la tabla EXP_VEHICULO (c�digo autogenerado)
';

comment on column SIETID.EXP_VEHICULO.TIPO_TAMANO is
'Identificador del tipo de tama�o del veh�culo
';

comment on column SIETID.EXP_VEHICULO.TRANSMISION is
'Identificador del tipo de transmisi�n del veh�culo
';

comment on column SIETID.EXP_VEHICULO.CILINDROS is
'Identificador de la cilindrada del veh�culo
';

comment on column SIETID.EXP_VEHICULO.SERIE_MOTOR is
'N�mero de serie del motor del veh�culo';

comment on column SIETID.EXP_VEHICULO.SERIE_CHASIS is
'N�mero de serie de la chasis del veh�culo';

comment on column SIETID.EXP_VEHICULO.PLACA is
'N�mero de placa del veh�culo';

comment on column SIETID.EXP_VEHICULO.MODELO is
'Identificador del modelo del veh�culo';

comment on column SIETID.EXP_VEHICULO.ANO is
'A�o de fabricaci�n del veh�culo';

comment on column SIETID.EXP_VEHICULO.COLOR is
'Color del veh�culo';

comment on column SIETID.EXP_VEHICULO.OBSERVACIONES is
'Observaci�n acerca del veh�culo';

comment on column SIETID.EXP_VEHICULO.PROPIETARIO is
'Identificador del propietario del veh�culo';

comment on column SIETID.EXP_VEHICULO.MODELO_ESPECIFICO is
'Descripci�n del modelo espec�fico del veh�culo';

comment on column SIETID.EXP_VEHICULO.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.EXP_VEHICULO.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.EXP_VEHICULO.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.EXP_VEHICULO.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.EXP_VEHICULO
   add constraint PK_EXP_VEHICULO primary key (ID);

/*==============================================================*/
/* Table: HR_HOJAREMISION                                       */
/*==============================================================*/
create table SIETID.HR_HOJAREMISION 
(
   ID                   NUMBER(16)           not null,
   NUMERO               INTEGER,
   TIPO_HR              NUMBER(16),
   EXPEDIENTE           NUMBER(16),
   DEPENDENCIA_REMITE   NUMBER(16),
   DEPENDENCIA_DESTINO  NUMBER(16),
   FECHA_EMISION        TIMESTAMP,
   FECHA_TRASLADO       TIMESTAMP,
   PERSONA              NUMBER(16),
   NRO_LICENCIA         NVARCHAR2(50),
   OFICIO               NVARCHAR2(200),
   VEHICULO_MARCA       NUMBER(16)           not null,
   VEHICULO_PLACA       NVARCHAR2(50),
   MOTIVO_TRASLADO      NVARCHAR2(400),
   FECHA_RECEPCION      TIMESTAMP,
   COSTO_TRASLADO       NUMBER(10,2),
   OBSERVACION          NVARCHAR2(200),
   CREADOR              NUMBER(16),
   CREACION             TIMESTAMP,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on column SIETID.HR_HOJAREMISION.TIPO_HR is
'Lavado activo/drogas';

comment on column SIETID.HR_HOJAREMISION.PERSONA is
'Conductor';

alter table SIETID.HR_HOJAREMISION
   add constraint PK_HR_HOJAREMISION primary key (ID);

/*==============================================================*/
/* Table: HR_HOJAREMISION_MUESTRA                               */
/*==============================================================*/
create table HR_HOJAREMISION_MUESTRA 
(
   ID                   NUMBER(16)           not null,
   HOJAREMISION         NUMBER(16),
   ESPECIE              NUMBER(16),
   DROGAS               NUMBER(16),
   DESCRIPCION          NVARCHAR2(200),
   UNIDAD_MEDIDA        NUMBER(16),
   CAN_PESO_BRUTO       NUMBER(10,2),
   CAN_PESO_NETO        NUMBER(10,2),
   CAN_PESO_ANALISIS    NUMBER(10,2),
   CAN_PESO_DEVUELTO    NUMBER(10,2),
   CANTIDAD             NUMBER(5,0),
   CREADOR              NUMBER(16),
   CREACION             TIMESTAMP,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on column HR_HOJAREMISION_MUESTRA.ESPECIE is
'Traslado de Documentos';

comment on column HR_HOJAREMISION_MUESTRA.CANTIDAD is
'Cantidad en lavado de activos';

alter table HR_HOJAREMISION_MUESTRA
   add constraint PK_HR_HOJAREMISION_MUESTRA primary key (ID);

/*==============================================================*/
/* Table: MNT_MODELO_MARCA                                      */
/*==============================================================*/
create table SIETID.MNT_MODELO_MARCA 
(
   ID                   NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(100),
   TIPO                 NUMBER(16),
   PADRE                NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.MNT_MODELO_MARCA is
'Tabla que guarda la informaci�n de marcas / modelos							
';

comment on column SIETID.MNT_MODELO_MARCA.ID is
'Identificador de la tabla EXP_MOD_MARCA (c�digo autogenerado)
';

comment on column SIETID.MNT_MODELO_MARCA.NOMBRE is
'Nombre o descripci�n del modelo / marca
';

comment on column SIETID.MNT_MODELO_MARCA.TIPO is
'Identificador del tipo de marca/modelo
';

comment on column SIETID.MNT_MODELO_MARCA.PADRE is
'Identificador de referencia circular a un identificador padre
';

comment on column SIETID.MNT_MODELO_MARCA.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.MNT_MODELO_MARCA.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.MNT_MODELO_MARCA.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.MNT_MODELO_MARCA.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.MNT_MODELO_MARCA
   add constraint PK_MNT_MODELO_MARCA primary key (ID);

/*==============================================================*/
/* Table: MNT_PAISES                                            */
/*==============================================================*/
create table MNT_PAISES 
(
   ID                   NUMBER(16)           not null,
   PADRE                NUMBER(16),
   NOMBRE               NVARCHAR2(200)       not null,
   NACIONALIDAD         NVARCHAR2(200),
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table MNT_PAISES is
'tabla recursiva que contiene la mayor parte de paises y cuidades principales para ser tomadas en cuentra como destino o procedencia de la droga ';

alter table MNT_PAISES
   add constraint PK_MNT_PAISES primary key (ID);

/*==============================================================*/
/* Table: MNT_TIPO_ESPECIE                                      */
/*==============================================================*/
create table SIETID.MNT_TIPO_ESPECIE 
(
   ID                   NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(200),
   PADRE                NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.MNT_TIPO_ESPECIE is
'Tabla que almacena la clasificaci�n de tipo de especies							
';

comment on column SIETID.MNT_TIPO_ESPECIE.ID is
'Identificador de la tabla tipos de especie (c�digo autogenerado)
';

comment on column SIETID.MNT_TIPO_ESPECIE.NOMBRE is
'Nombre o descripci�n del tipo de especie
';

comment on column SIETID.MNT_TIPO_ESPECIE.PADRE is
'Referencia circular de pertenencia a un grupo o padre
';

comment on column SIETID.MNT_TIPO_ESPECIE.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.MNT_TIPO_ESPECIE.CREACION is
'Fecha y hora del sistema en que se relaiz� el registro.
';

comment on column SIETID.MNT_TIPO_ESPECIE.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.MNT_TIPO_ESPECIE.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.MNT_TIPO_ESPECIE
   add constraint PK_MNT_TIPO_ESPECIE primary key (ID);

/*==============================================================*/
/* Table: ORG_EQUIPO                                            */
/*==============================================================*/
create table SIETID.ORG_EQUIPO 
(
   ID                   NUMBER(16)           not null,
   CODIGO               NVARCHAR2(20)        not null,
   NOMBRE               NVARCHAR2(200)       not null,
   TIPO_AGRUPACION      NUMBER(16),
   PADRE                NUMBER(16),
   DEPENDENCIA          NUMBER(16),
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.ORG_EQUIPO
   add constraint PK_ORG_EQUIPO primary key (ID);

/*==============================================================*/
/* Table: ORG_INTEGRANTE                                        */
/*==============================================================*/
create table SIETID.ORG_INTEGRANTE 
(
   ID                   NUMBER(16)           not null,
   INTEGRANTE           NUMBER(16)           not null,
   EQUIPO               NUMBER(16)           not null,
   FUNCION              NUMBER(16),
   ES_LIDER             SMALLINT             not null,
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.ORG_INTEGRANTE
   add constraint PK_ORG_INTEGRANTE primary key (ID);

/*==============================================================*/
/* Table: PER_CORREO                                            */
/*==============================================================*/
create table SIETID.PER_CORREO 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16)           not null,
   CORREO               NVARCHAR2(100)       not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_CORREO is
'Tabla de correos';

comment on column SIETID.PER_CORREO.ID is
'Identificador';

comment on column SIETID.PER_CORREO.PERSONA is
'Identificador de persona';

comment on column SIETID.PER_CORREO.CORREO is
'Correo de la persona';

comment on column SIETID.PER_CORREO.CREADOR is
'Usuario que registra ';

comment on column SIETID.PER_CORREO.CREACION is
'Fecha de registro';

comment on column SIETID.PER_CORREO.EDITOR is
'Usuario que modifica registro';

comment on column SIETID.PER_CORREO.EDICION is
'Fecha de modificaci�n';

alter table SIETID.PER_CORREO
   add constraint PK_PER_CORREO primary key (ID);

/*==============================================================*/
/* Table: PER_DETALLE                                           */
/*==============================================================*/
create table SIETID.PER_DETALLE 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   TALLA                NUMBER(3, 2),
   PESO                 NUMBER(3, 2),
   CONTEXTURA           NUMBER(16),
   TIPO_CABELLO         NUMBER(16),
   COLOR_CABELLO        NUMBER(16),
   TIPO_OJO             NUMBER(16),
   COLOR_OJO            NUMBER(16),
   TIPO_NARIZ           NUMBER(16),
   FORMA_CARA           NUMBER(16),
   TIPO_LABIO           NUMBER(16),
   FORMA_BOCA           NUMBER(16),
   TIPO_CEJA            NUMBER(16),
   TIPO_OREJA           NUMBER(16),
   COLOR_PIEL           NUMBER(16),
   TIPO_RAZA            NUMBER(16),
   SENAS                NVARCHAR2(1000),
   RASGO_FACIAL         NVARCHAR2(2000),
   CALZADO              NVARCHAR2(10),
   PROFESION            NUMBER(16),
   CORTE_CABELLO        NUMBER(16),
   VESTIMENTA           NVARCHAR2(1000),
   FECHALUGAR_ULTVEZ    NVARCHAR2(1000),
   PERSONA_NA           NUMBER(16),
   CREADOR              NUMBER(16),
   CREACION             TIMESTAMP,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_DETALLE is
'Tabla donde se guardab los razgos de la persona';

comment on column SIETID.PER_DETALLE.ID is
'Identificador';

comment on column SIETID.PER_DETALLE.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_DETALLE.TALLA is
'Talla';

comment on column SIETID.PER_DETALLE.PESO is
'Peso';

comment on column SIETID.PER_DETALLE.CONTEXTURA is
'Conextura: delgado, gordo';

comment on column SIETID.PER_DETALLE.TIPO_CABELLO is
'Tipo de cabello: ondulado, lacio, crespo';

comment on column SIETID.PER_DETALLE.COLOR_CABELLO is
'Color de cabello';

comment on column SIETID.PER_DETALLE.TIPO_OJO is
'Tipo de ojo';

comment on column SIETID.PER_DETALLE.COLOR_OJO is
'Color de ojo: pardo, negro, verde, azul, plomo';

comment on column SIETID.PER_DETALLE.TIPO_NARIZ is
'tipo de nariz';

comment on column SIETID.PER_DETALLE.FORMA_CARA is
'forma de la cara: redonda, ovalada';

comment on column SIETID.PER_DETALLE.TIPO_LABIO is
'tipo de labio';

comment on column SIETID.PER_DETALLE.FORMA_BOCA is
'forma de la boca';

comment on column SIETID.PER_DETALLE.TIPO_CEJA is
'Tipo de ceja';

comment on column SIETID.PER_DETALLE.TIPO_OREJA is
'Tipo de oreja';

comment on column SIETID.PER_DETALLE.COLOR_PIEL is
'color de piel: trigue�o,blanco, colorado';

comment on column SIETID.PER_DETALLE.TIPO_RAZA is
'tipo de raza: negro, mestizo, blanco, cholo';

comment on column SIETID.PER_DETALLE.SENAS is
'se�as, marcas, tatuajes';

comment on column SIETID.PER_DETALLE.RASGO_FACIAL is
'Rasgo facial';

comment on column SIETID.PER_DETALLE.CALZADO is
'Calzado';

comment on column SIETID.PER_DETALLE.PROFESION is
'Profesi�n';

comment on column SIETID.PER_DETALLE.CORTE_CABELLO is
'Corte de cabello';

comment on column SIETID.PER_DETALLE.VESTIMENTA is
'Vestimenta';

comment on column SIETID.PER_DETALLE.FECHALUGAR_ULTVEZ is
'Fecha y lugar que fue visto por ultima vez';

comment on column SIETID.PER_DETALLE.PERSONA_NA is
'Usado para la tabla de personas no identificadas';

comment on column SIETID.PER_DETALLE.CREADOR is
'Usuario creador';

comment on column SIETID.PER_DETALLE.CREACION is
'Fecha de creaci�n del registro';

comment on column SIETID.PER_DETALLE.EDITOR is
'Usuario que modifica el registro';

comment on column SIETID.PER_DETALLE.EDICION is
'Fecha que modifica el registro';

alter table SIETID.PER_DETALLE
   add constraint PK_PER_DETALLE primary key (ID);

/*==============================================================*/
/* Table: PER_DIRECCION                                         */
/*==============================================================*/
create table SIETID.PER_DIRECCION 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16)           not null,
   DISTRITO             NUMBER(16),
   DIRECCION            NVARCHAR2(100)       not null,
   REFERENCIA           NVARCHAR2(500),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_DIRECCION is
'Tabla de direcciones';

comment on column SIETID.PER_DIRECCION.ID is
'Identificador';

comment on column SIETID.PER_DIRECCION.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_DIRECCION.DISTRITO is
'C�digo del Distrito';

comment on column SIETID.PER_DIRECCION.DIRECCION is
'Direcci�n';

comment on column SIETID.PER_DIRECCION.REFERENCIA is
'Referencia de la direcci�n';

comment on column SIETID.PER_DIRECCION.CREADOR is
'Usuario de creaci�n del registro';

comment on column SIETID.PER_DIRECCION.CREACION is
'Fecha de creaci�n del registro';

comment on column SIETID.PER_DIRECCION.EDITOR is
'Usuario que modifica registro';

comment on column SIETID.PER_DIRECCION.EDICION is
'Fecha que se modifica el registro';

alter table SIETID.PER_DIRECCION
   add constraint PK_PER_DIRECCION primary key (ID);

/*==============================================================*/
/* Table: PER_EMPRESA                                           */
/*==============================================================*/
create table SIETID.PER_EMPRESA 
(
   ID                   NUMBER(16)           not null,
   RAZON_SOCIAL         NVARCHAR2(400)       not null,
   DIRECCION            NVARCHAR2(500)       not null,
   PARTIDA_REGISTRAL    NVARCHAR2(50),
   RUC                  NVARCHAR2(11),
   REPRESENTANTE        NUMBER(16),
   TELEFONO             NVARCHAR2(30),
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_EMPRESA is
'Se registran las empresas o persona juridicas';

comment on column SIETID.PER_EMPRESA.ID is
'Identificador';

comment on column SIETID.PER_EMPRESA.RAZON_SOCIAL is
'Raz�n social o nombre de la empresa';

comment on column SIETID.PER_EMPRESA.DIRECCION is
'Direcci�n de la empresa';

comment on column SIETID.PER_EMPRESA.PARTIDA_REGISTRAL is
'Partida registral';

comment on column SIETID.PER_EMPRESA.RUC is
'RUC de la empresa';

comment on column SIETID.PER_EMPRESA.REPRESENTANTE is
'Representante legal de la empresa';

comment on column SIETID.PER_EMPRESA.TELEFONO is
'Tel�fono de la empresa';

comment on column SIETID.PER_EMPRESA.ESTADO is
'Estado activo o inactivo';

comment on column SIETID.PER_EMPRESA.CREADOR is
'Usuario creador del registro';

comment on column SIETID.PER_EMPRESA.CREACION is
'Fecha de creaci�n del registro';

comment on column SIETID.PER_EMPRESA.EDITOR is
'Usuario que modifica el registro';

comment on column SIETID.PER_EMPRESA.EDICION is
'Fecha de modificaci�n del registro';

alter table SIETID.PER_EMPRESA
   add constraint PK_PER_EMPRESA primary key (ID);

/*==============================================================*/
/* Table: PER_IDENTIFICACION                                    */
/*==============================================================*/
create table SIETID.PER_IDENTIFICACION 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   TIPO                 NUMBER(16),
   NUMERO               NVARCHAR2(20),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_IDENTIFICACION is
'Tabla de identificaci�n';

comment on column SIETID.PER_IDENTIFICACION.ID is
'Identificador';

comment on column SIETID.PER_IDENTIFICACION.PERSONA is
'Identificador de persona';

comment on column SIETID.PER_IDENTIFICACION.TIPO is
'Tipo de documento';

comment on column SIETID.PER_IDENTIFICACION.NUMERO is
'N�mero de documento';

comment on column SIETID.PER_IDENTIFICACION.CREADOR is
'Usuario creaci�n';

comment on column SIETID.PER_IDENTIFICACION.CREACION is
'Fecha creaci�n';

comment on column SIETID.PER_IDENTIFICACION.EDITOR is
'Usuario edici�n';

comment on column SIETID.PER_IDENTIFICACION.EDICION is
'Fecha edici�n';

alter table SIETID.PER_IDENTIFICACION
   add constraint PK_PER_IDENTIFICACION primary key (ID);

/*==============================================================*/
/* Table: PER_IMAGEN                                            */
/*==============================================================*/
create table SIETID.PER_IMAGEN 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   IMAGEN               BLOB,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16)           not null,
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_IMAGEN is
'Tabal que registra las imagenes de la persona';

comment on column SIETID.PER_IMAGEN.ID is
'Identificador';

comment on column SIETID.PER_IMAGEN.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_IMAGEN.IMAGEN is
'Archivo de la imagen ';

comment on column SIETID.PER_IMAGEN.CREADOR is
'Usuario creaci�n';

comment on column SIETID.PER_IMAGEN.CREACION is
'Fecha creaci�n';

comment on column SIETID.PER_IMAGEN.EDITOR is
'Usuario edici�n';

comment on column SIETID.PER_IMAGEN.EDICION is
'Fecha edici�n';

alter table SIETID.PER_IMAGEN
   add constraint PK_PER_IMAGEN primary key (ID);

/*==============================================================*/
/* Table: PER_LETRADO                                           */
/*==============================================================*/
create table SIETID.PER_LETRADO 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   TIPO                 NUMBER(16),
   NRO_COLEGIATURA      NVARCHAR2(10),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_LETRADO is
'Tabla de los abogados Fiscales Juces ETC';

comment on column SIETID.PER_LETRADO.ID is
'Identificador';

comment on column SIETID.PER_LETRADO.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_LETRADO.TIPO is
'juez, abogado, fiscal';

comment on column SIETID.PER_LETRADO.NRO_COLEGIATURA is
'N�mero de colegiatura';

comment on column SIETID.PER_LETRADO.CREADOR is
'Usuario de creaci�n';

comment on column SIETID.PER_LETRADO.CREACION is
'Fecha de creaci�n';

comment on column SIETID.PER_LETRADO.EDITOR is
'Usuario que modifica';

comment on column SIETID.PER_LETRADO.EDICION is
'Fecha de modificaci�n';

alter table SIETID.PER_LETRADO
   add constraint PK_PER_LETRADO primary key (ID);

/*==============================================================*/
/* Table: PER_NO_IDENTIFICADOS                                  */
/*==============================================================*/
create table SIETID.PER_NO_IDENTIFICADOS 
(
   ID                   NUMBER(16)           not null,
   EXPEDIENTE           NUMBER(16),
   PERSONA              NUMBER(16),
   ALIAS                NVARCHAR2(100),
   NOMBRES              NVARCHAR2(100),
   APELLIDOS            NVARCHAR2(100),
   ORIENT_SEXUAL        NUMBER(16),
   EDAD_APROX           INTEGER,
   CREADOR              NUMBER(16),
   CREACION             TIMESTAMP,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint PK_PER_NO_IDENTIFICADOS primary key (ID);

/*==============================================================*/
/* Table: PER_PARENTESCO                                        */
/*==============================================================*/
create table SIETID.PER_PARENTESCO 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   PERSONA_PARIENTE     NUMBER(16),
   TIPO_RELACION        NUMBER(16),
   OBSERVACION          NVARCHAR2(200),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_PARENTESCO is
'Tabla de parentesco';

comment on column SIETID.PER_PARENTESCO.ID is
'Identificador';

comment on column SIETID.PER_PARENTESCO.PERSONA is
'Identificador de persona';

comment on column SIETID.PER_PARENTESCO.PERSONA_PARIENTE is
'Identificador del pariente con el que se tiene v�nculo de consanguinidad o afinidad';

comment on column SIETID.PER_PARENTESCO.TIPO_RELACION is
'Tipo de relaci�n o parentesco';

comment on column SIETID.PER_PARENTESCO.OBSERVACION is
'Observaci�n';

comment on column SIETID.PER_PARENTESCO.CREADOR is
'Usuario creador';

comment on column SIETID.PER_PARENTESCO.CREACION is
'Fecha creaci�n';

comment on column SIETID.PER_PARENTESCO.EDITOR is
'Usuario Editor';

comment on column SIETID.PER_PARENTESCO.EDICION is
'Fecha edici�n';

alter table SIETID.PER_PARENTESCO
   add constraint PK_PER_PARENTESCO primary key (ID);

/*==============================================================*/
/* Table: PER_PERSONA                                           */
/*==============================================================*/
create table SIETID.PER_PERSONA 
(
   ID                   NUMBER(16)           not null,
   TIPO_DOCUMENTO       NUMBER(16),
   NRO_DOCUMENTO        NVARCHAR2(20),
   NOMBRES              NVARCHAR2(150),
   APE_PATERNO          NVARCHAR2(100),
   APE_MATERNO          NVARCHAR2(100),
   SEXO                 NCHAR(1),
   FEC_NACIMIENTO       DATE,
   ESTADO_CIVIL         NUMBER(16),
   LUGAR_NACIMIENTO     NUMBER(16),
   NACIONALIDAD         NUMBER(16),
   PERSONA              NUMBER(16),
   ORIENTACION_SEXUAL   NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_PERSONA is
'sera recursiva porque una persona puede dar nombres falsos en expedientes diferentes. Cuando se detecte casos de nobres falsos se actualiza a CADA PERSNOA FALSA y se le indica a que persona real corresponde, el ID de la persona real estara en cada persona falsa';

comment on column SIETID.PER_PERSONA.ID is
'Identificador';

comment on column SIETID.PER_PERSONA.TIPO_DOCUMENTO is
'Identificador de tipo de documento';

comment on column SIETID.PER_PERSONA.NRO_DOCUMENTO is
'N�mero de documento';

comment on column SIETID.PER_PERSONA.NOMBRES is
'Nombre de la persona';

comment on column SIETID.PER_PERSONA.APE_PATERNO is
'Apellido paterno de la persona';

comment on column SIETID.PER_PERSONA.APE_MATERNO is
'Apellido materno de la persona';

comment on column SIETID.PER_PERSONA.SEXO is
'masculino: M/femenino:F';

comment on column SIETID.PER_PERSONA.FEC_NACIMIENTO is
'Fecha de nacimiento';

comment on column SIETID.PER_PERSONA.ESTADO_CIVIL is
'Estado civil';

comment on column SIETID.PER_PERSONA.LUGAR_NACIMIENTO is
'Lugar de nacimiento de la persona';

comment on column SIETID.PER_PERSONA.NACIONALIDAD is
'Nacionalidad de la persona';

comment on column SIETID.PER_PERSONA.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_PERSONA.ORIENTACION_SEXUAL is
'Orientaci�n sexual';

comment on column SIETID.PER_PERSONA.CREADOR is
'Usuario de creaci�n de registro';

comment on column SIETID.PER_PERSONA.CREACION is
'Fecha de creaci�n de registro';

comment on column SIETID.PER_PERSONA.EDITOR is
'Usuario de modificaci�n de registro';

comment on column SIETID.PER_PERSONA.EDICION is
'Fecha de modificaci�n de registro';

alter table SIETID.PER_PERSONA
   add constraint PK_PER_PERSONA primary key (ID);

/*==============================================================*/
/* Table: PER_POLICIA                                           */
/*==============================================================*/
create table SIETID.PER_POLICIA 
(
   ID                   NUMBER(16)           not null,
   PERSONA              NUMBER(16),
   GRADO                NUMBER(16),
   UNIDAD               NVARCHAR2(2000),
   CARGO                NUMBER(16),
   CAMPO                NVARCHAR2(100),
   CIP                  NVARCHAR2(12),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_POLICIA is
'Se guarda la infomaci�n del personal policial';

comment on column SIETID.PER_POLICIA.ID is
'Identificador';

comment on column SIETID.PER_POLICIA.PERSONA is
'Identificador de la persona';

comment on column SIETID.PER_POLICIA.GRADO is
'Grado del personal policial';

comment on column SIETID.PER_POLICIA.UNIDAD is
'Unidad a la que pertenece el personal policial';

comment on column SIETID.PER_POLICIA.CARGO is
'Cargo del personal policial';

comment on column SIETID.PER_POLICIA.CIP is
'Codigo identificador policial';

comment on column SIETID.PER_POLICIA.CREADOR is
'Usuario creador del registro';

comment on column SIETID.PER_POLICIA.CREACION is
'Fecha de creaci�n del registro';

comment on column SIETID.PER_POLICIA.EDITOR is
'Usuario que modifica el registro';

comment on column SIETID.PER_POLICIA.EDICION is
'Fecha que se modifica el registro';

alter table SIETID.PER_POLICIA
   add constraint PK_PER_POLICIA primary key (ID);

/*==============================================================*/
/* Table: PER_TELEFONO                                          */
/*==============================================================*/
create table SIETID.PER_TELEFONO 
(
   ID                   NUMBER(16)           not null,
   TIPO                 NUMBER(16)           not null,
   NUMERO               NVARCHAR2(50)        not null,
   ESTADO               NUMBER(16),
   SERIE                VARCHAR2(50),
   MARCA                NUMBER(16),
   ALCANCE              VARCHAR2(50),
   FRECUENCIA           NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.PER_TELEFONO is
'Tabla que almacena la informaci�n de los n�meros telef�nicos';

comment on column SIETID.PER_TELEFONO.ID is
'Identificador de la tabla telefonos (c�digo autogenerado)
';

comment on column SIETID.PER_TELEFONO.TIPO is
'Identificador del tipo de tel�fono: fijo / m�vil
';

comment on column SIETID.PER_TELEFONO.NUMERO is
'N�mero de tel�fono
';

comment on column SIETID.PER_TELEFONO.ESTADO is
'Valor del estado de tel�fono (fisico, malogrado, usado)
';

comment on column SIETID.PER_TELEFONO.SERIE is
'N�mero de serie del equipo telef�nico
';

comment on column SIETID.PER_TELEFONO.MARCA is
'Marca del equipo
';

comment on column SIETID.PER_TELEFONO.ALCANCE is
'Radio o distancia de alcance
';

comment on column SIETID.PER_TELEFONO.FRECUENCIA is
'tipo de frecuencia';

comment on column SIETID.PER_TELEFONO.CREADOR is
'Id del usuario del sistema que harealizado el registro.
';

comment on column SIETID.PER_TELEFONO.CREACION is
'Fecha y hora del sistema en que se realiz� el registro.
';

comment on column SIETID.PER_TELEFONO.EDITOR is
'Id del usuario del sistema que harealizado la modificacion del registro.
';

comment on column SIETID.PER_TELEFONO.EDICION is
'Fecha y hora del sistema en que se relaiz� la modificacion del registro.
';

alter table SIETID.PER_TELEFONO
   add constraint PK_PER_TELEFONO primary key (ID);

/*==============================================================*/
/* Table: SEG_OPCION                                            */
/*==============================================================*/
create table SIETID.SEG_OPCION 
(
   ID                   NUMBER(8)            not null,
   PADRE                NUMBER(8),
   CODIGO               NVARCHAR2(15)        not null,
   NOMBRE               NVARCHAR2(50)        not null,
   DESCRIPCION          NVARCHAR2(250),
   ORDEN                NUMBER(8),
   TIPO                 NUMBER(16)           not null,
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.SEG_OPCION
   add constraint PK_SEG_OPCION primary key (ID);

/*==============================================================*/
/* Index: UNQ_CODIGO_OPCION                                     */
/*==============================================================*/
create unique index SIETID.UNQ_CODIGO_OPCION on SIETID.SEG_OPCION (
   CODIGO ASC
);

/*==============================================================*/
/* Table: SEG_PERMISO                                           */
/*==============================================================*/
create table SIETID.SEG_PERMISO 
(
   ID                   NUMBER(16)           not null,
   OPCION               NUMBER(8)            not null,
   ROL                  NUMBER(8)            not null,
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.SEG_PERMISO
   add constraint PK_SEG_PERMISO primary key (ID);

/*==============================================================*/
/* Table: SEG_PREFERENCIA                                       */
/*==============================================================*/
create table SIETID.SEG_PREFERENCIA 
(
   ID                   NUMBER(16)           not null,
   USUARIO              NUMBER(16),
   TABLA                NVARCHAR2(50)        not null,
   COLUMNA              NVARCHAR2(350),
   ANCHO                NVARCHAR2(250),
   COLAPSO              NVARCHAR2(250)
);

alter table SIETID.SEG_PREFERENCIA
   add constraint PK_SEG_PREFERENCIA primary key (ID);

/*==============================================================*/
/* Table: SEG_ROL                                               */
/*==============================================================*/
create table SIETID.SEG_ROL 
(
   ID                   NUMBER(8)            not null,
   PADRE                NUMBER(8),
   CODIGO               NVARCHAR2(10),
   NOMBRE               NVARCHAR2(50),
   DESCRIPCION          NVARCHAR2(250),
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.SEG_ROL
   add constraint PK_SEG_ROL primary key (ID);

/*==============================================================*/
/* Index: UNQ_CODIGO_ROL                                        */
/*==============================================================*/
create index SIETID.UNQ_CODIGO_ROL on SIETID.SEG_ROL (
   CODIGO ASC
);

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SIETID.SEG_USUARIO 
(
   ID                   NUMBER(16)           not null,
   NOMBRES              NVARCHAR2(200),
   APE_PAT              NVARCHAR2(200),
   APE_MAT              NVARCHAR2(200),
   USUARIO              NVARCHAR2(10)        not null,
   CLAVE                NVARCHAR2(256)       not null,
   ROL                  NUMBER(8),
   CARGO                NVARCHAR2(50),
   DESC_CARGO           NVARCHAR2(50),
   OFICINA              NUMBER(16),
   POLICIA              NUMBER(16),
   CREADOR              NUMBER(16),
   CREACION             TIMESTAMP,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

comment on table SIETID.SEG_USUARIO is
'Tabla de usuarios';

comment on column SIETID.SEG_USUARIO.ID is
'Identificador';

comment on column SIETID.SEG_USUARIO.NOMBRES is
'Nombre del usuario';

comment on column SIETID.SEG_USUARIO.APE_PAT is
'Apellido paterno del usuario';

comment on column SIETID.SEG_USUARIO.APE_MAT is
'Apellido Materno del usuario';

comment on column SIETID.SEG_USUARIO.USUARIO is
'Login';

comment on column SIETID.SEG_USUARIO.CLAVE is
'Clave de acceso al sistema';

comment on column SIETID.SEG_USUARIO.ROL is
'Rol del usuario';

comment on column SIETID.SEG_USUARIO.CARGO is
'Cargo del usuario';

comment on column SIETID.SEG_USUARIO.DESC_CARGO is
'Descripici�n del cargo';

comment on column SIETID.SEG_USUARIO.OFICINA is
'Oficina del usuario';

comment on column SIETID.SEG_USUARIO.POLICIA is
'Identificador de personal policial';

comment on column SIETID.SEG_USUARIO.CREADOR is
'Usuario creador del registro';

comment on column SIETID.SEG_USUARIO.CREACION is
'Fecha de creaci�n del registro';

comment on column SIETID.SEG_USUARIO.EDITOR is
'Usuario que modifica el registro';

comment on column SIETID.SEG_USUARIO.EDICION is
'Fecha de modificaci�n del registro';

alter table SIETID.SEG_USUARIO
   add constraint PK_SEG_USUARIO primary key (ID);

alter table SIETID.SEG_USUARIO
   add constraint USUARIO_UNICO_UK unique (USUARIO);

/*==============================================================*/
/* Table: SEQ_TABLA                                             */
/*==============================================================*/
create table SIETID.SEQ_TABLA 
(
   TABLA                NVARCHAR2(250)       not null,
   ULTIMO_ID            NUMBER(16)
);

alter table SIETID.SEQ_TABLA
   add constraint PK_SEQ_TABLA primary key (TABLA);

/*==============================================================*/
/* Table: UBG_DEPARTAMENTO                                      */
/*==============================================================*/
create table SIETID.UBG_DEPARTAMENTO 
(
   ID                   NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(50)        not null,
   ESTADO               NUMBER(16)           not null,
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.UBG_DEPARTAMENTO
   add constraint PK_UBG_DEPARTAMENTO primary key (ID);

/*==============================================================*/
/* Table: UBG_DISTRITO                                          */
/*==============================================================*/
create table SIETID.UBG_DISTRITO 
(
   ID                   NUMBER(16)           not null,
   PROVINCIA            NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(50)        not null,
   ESTADO               NUMBER(16),
   CODIGO_HOST          NVARCHAR2(7),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.UBG_DISTRITO
   add constraint PK_UBG_DISTRITO primary key (ID);

/*==============================================================*/
/* Table: UBG_PROVINCIA                                         */
/*==============================================================*/
create table SIETID.UBG_PROVINCIA 
(
   ID                   NUMBER(16)           not null,
   DEPARTAMENTO         NUMBER(16)           not null,
   NOMBRE               NVARCHAR2(50)        not null,
   ESTADO               NUMBER(16),
   CREADOR              NUMBER(16)           not null,
   CREACION             TIMESTAMP            not null,
   EDITOR               NUMBER(16),
   EDICION              TIMESTAMP
);

alter table SIETID.UBG_PROVINCIA
   add constraint PK_UBG_PROVINCIA primary key (ID);

alter table SIETID.CFG_LISTA
   add constraint FK_CGF_LISTA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_LISTA
   add constraint FK_CGF_LISTA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_PARAMETRO
   add constraint FK_CFG_PARAMETRO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_PARAMETRO
   add constraint FK_CFG_PARAMETRO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_PARAMETRO
   add constraint FK_CFG_PARAMETRO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.CFG_REGLA
   add constraint FK_CFG_REGLA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_REGLA
   add constraint FK_CFG_REGLA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_REGLA
   add constraint FK_CFG_REGLA_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.CFG_REGLA
   add constraint FK_CFG_REGLA_TIPO foreign key (TIPO_REGLA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.CFG_VALOR
   add constraint FK_CGF_VALOR_CGF_LISTA foreign key (LISTA)
      references SIETID.CFG_LISTA (ID);

alter table SIETID.CFG_VALOR
   add constraint FK_CGF_VALOR_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.CFG_VALOR
   add constraint FK_CGF_VALOR_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table EXP_ABOGADO_PERSONA
   add constraint FK_EXP_ABOGADO_PER_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table EXP_ABOGADO_PERSONA
   add constraint FK_EXP_ABOGADO_PER_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table EXP_ABOGADO_PERSONA
   add constraint FK_SIIC_EXP_ABOGADO_REPRESENT foreign key (ABOGADO)
      references SIETID.PER_LETRADO (ID);

alter table EXP_ABOGADO_PERSONA
   add constraint FK_EXP_PERSONA_IMPLICADO foreign key (PERSONA)
      references SIETID.EXP_DET_EXPEDIENTE_PERSONA (ID);

alter table SIETID.EXP_ADJUNTO
   add constraint FK_DET_REQ_DOC_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ADJUNTO
   add constraint FK_DET_REQ_DOC_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ADJUNTO
   add constraint FK_DET_REQ_DOC_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ADJUNTO
   add constraint FK_EXP_ADJUNTO_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_ANEXO
   add constraint FK_EXP_ANEXO_ADJUNTO foreign key (ADJUNTO)
      references SIETID.EXP_ADJUNTO (ID);

alter table SIETID.EXP_ANEXO
   add constraint FK_EXP_ANEXO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ANEXO
   add constraint FK_EXP_ANEXO_DOCUMENTO foreign key (DOCUMENTO)
      references SIETID.EXP_DOCUMENTO (ID);

alter table SIETID.EXP_ANEXO
   add constraint FK_EXP_ANEXO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMAS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMAS_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMA_CALIBRE foreign key (CALIBRE)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMA_CLASIFICACION foreign key (CLASIFICACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMA_ESTADO_SERIE foreign key (EST_SERIE)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_ARMA_MODELO foreign key (MARCA)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.EXP_ARMAS
   add constraint FK_EXP_EXPLOSIVO_MODELO foreign key (MODELO)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint FK_EXP_POBLADO_CATEGORIA foreign key (CATEGORIA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint FK_EXP_POBLADO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint FK_EXP_POBLADO_DISTRITO foreign key (DISTRITO)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint FK_EXP_POBLADO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_CENTRO_POBLADO
   add constraint FK_EXP_POBLADO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DELITO
   add constraint FK_EXP_DELITO_CODIGO_PROCESAL foreign key (TIPO_CODIGO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DELITO
   add constraint FK_EXP_DELITO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DELITO
   add constraint FK_EXP_DELITO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DELITO
   add constraint FK_EXP_DELITO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DELITO
   add constraint FK_EXP_DELITO_PADRE foreign key (PADRE)
      references SIETID.EXP_DELITO (ID);

alter table SIETID.EXP_DEPENDENCIA
   add constraint FK_EXP_DEPENDENCIA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DEPENDENCIA
   add constraint FK_EXP_DEPENDENCIA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DEPENDENCIA
   add constraint FK_EXP_DEPENDENCIA_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DEPENDENCIA
   add constraint FK_EXP_DEPENDENCIA_PADRE foreign key (PADRE)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.EXP_DEPENDENCIA
   add constraint FK_EXP_DEPENDENCIA_SIGLA foreign key (SIGLA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_CRIMEN
   add constraint FK_EXP_DET_CRIMEN_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_CRIMEN
   add constraint FK_EXP_DET_CRIMEN_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_CRIMEN
   add constraint FK_EXP_DET_CRI_PRIORIDAD foreign key (PRIORIDAD)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_CRIMEN
   add constraint FK_EXP_DET_DEL_CRIMEN foreign key (EXP_DEL)
      references SIETID.EXP_EXPEDIENTE_DELITO (ID);

alter table SIETID.EXP_DET_CRIMEN
   add constraint FK_EXP_DET_PER_CRIMEN foreign key (EXP_PER)
      references SIETID.EXP_DET_EXPEDIENTE_PERSONA (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGAS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGAS_DROGA foreign key (DROGA)
      references SIETID.EXP_DROGAS (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGAS_ESTADO_PART foreign key (ESTADO_PARTICIPACION)
      references SIETID.CFG_VALOR (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGAS_PARTICIP foreign key (PARTICIPACION)
      references SIETID.CFG_VALOR (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGAS_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table EXP_DET_DROGAS
   add constraint FK_EXP_DET_DROGA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER_EMPRESA foreign key (EMPRESA)
      references SIETID.PER_EMPRESA (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER_PARTICIP foreign key (PARTICIPACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_DET_EXP_PER__PERSONA foreign key (INVOLUCRADO)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_PER_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   add constraint FK_EXP_PER_ORGANIZACION foreign key (ORGANIZACION)
      references SIETID.EXP_ORGANIZACION (ID);

alter table SIETID.EXP_DET_LLAMADAS
   add constraint FK_EXP_DET_LLAMADAS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_LLAMADAS
   add constraint FK_EXP_DET_LLAMADAS_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_LLAMADAS
   add constraint FK_EXP_DET_PER_TEL_LLAMADAS foreign key (EXP_PER_TEL)
      references SIETID.EXP_DET_PER_TEL_EXP (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_ARMAS foreign key (ARMA)
      references SIETID.EXP_ARMAS (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_DET_PER_ARM_EXP_PROPIETARIO foreign key (PROPIETARIO)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_EXP_DET_ARM_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_EXP_DET_PER_ARM_EMPRESA foreign key (EMPRESA_PROPIETARIA)
      references SIETID.PER_EMPRESA (ID);

alter table SIETID.EXP_DET_PER_ARM_EXP
   add constraint FK_EXP_DET_PER_ARM_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_INM_EXP
   add constraint FK_DET_PER_INM_EXP_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_INM_EXP
   add constraint FK_DET_PER_INM_EXP_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_INM_EXP
   add constraint FK_DET_PER_INM_EXP_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DET_PER_INM_EXP
   add constraint FK_DET_PER_INM_EXP_INMUEBLE foreign key (INMUEBLE)
      references SIETID.EXP_INMUEBLE (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_DET_PER_TEL_EXP_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_DET_PER_TEL_EXP_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_DET_PER_TEL_EXP_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_DET_PER_TEL_EXP_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_DET_PER_TEL_EXP_TELEFONO foreign key (TELEFONO)
      references SIETID.PER_TELEFONO (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_EXP_DET_PER_TEL_EXP_DUENO foreign key (DUENO)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_EXP_DET_PER_TEL_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_TEL_EXP
   add constraint FK_EXP_DET_TEL_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_DET_PER_VEH_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_DET_PER_VEH_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_DET_PER_VEH_EXP_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_DET_PER_VEH_EXP_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_DET_PER_VEH_EXP_VEHICULO foreign key (VEHICULO)
      references SIETID.EXP_VEHICULO (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_EXP_DET_PER_VEH_CHASIS foreign key (ESTADO_CHASIS)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_EXP_DET_PER_VEH_MOTOR foreign key (ESTADO_MOTOR)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_EXP_DET_PER_VEH_SIT_LEGAL foreign key (SITUACION_LEGAL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DET_PER_VEH_EXP
   add constraint FK_EXP_DET_VEH_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCUMENTO_ADJUNTO foreign key (ADJUNTO)
      references SIETID.EXP_ADJUNTO (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCUMENTO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCUMENTO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCUMENTO_PRIORIDAD foreign key (PRIORIDAD)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCUMENTO_TIPO foreign key (TIPO_DOCUMENTO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DOCUMENTO
   add constraint FK_EXP_DOCU_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_DESTINO foreign key (DESTINO)
      references MNT_PAISES (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_PROCEDENCIA foreign key (PROCENDECIA)
      references MNT_PAISES (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_TIPO_DROGA foreign key (TIPO_DROGA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGAS_TMEDIDA_MUESTRA foreign key (TIPO_MEDIDA_MUESTRA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_DROGAS
   add constraint FK_EXP_DROGA_TIPO_MEDIDA foreign key (TIPO_MEDIDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ENTIDAD
   add constraint FK_CFG_ENTIDAD_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ENTIDAD
   add constraint FK_CFG_ENTIDAD_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ENTIDAD
   add constraint FK_EXP_ENTIDAD_DISTRITO foreign key (DISTRITO)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.EXP_ENTIDAD
   add constraint FK_EXP_ENTIDAD_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ENTIDAD
   add constraint FK_EXP_ENTIDAD_TIPO_ENTIDAD foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPECIE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPECIE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPECIE_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPECIE_TIPO_ESP foreign key (TIPO_ESPECIE)
      references SIETID.MNT_TIPO_ESPECIE (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPECIE_TIPO_MEDIDA foreign key (TIPO_MEDIDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_ESPE_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ESPECIE
   add constraint FK_EXP_EXPEDIENTE_ESPECIE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_ESTADO
   add constraint FK_ESTADO_TIPO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ESTADO
   add constraint FK_EST_REQ_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ESTADO
   add constraint FK_EST_REQ_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_AMPLIACION foreign key (PADRE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_CUENCA foreign key (CUENCA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_DEPENDENCIA foreign key (DEPENDENCIA)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_DISTRITO foreign key (LUGAR_HECHO)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_ESTADO_EXP foreign key (ESTADO_EXP)
      references SIETID.EXP_ESTADO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_FINALIDAD foreign key (TIPO_FINALIDAD)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_INTEGRANTE foreign key (INTEGRANTE)
      references SIETID.ORG_INTEGRANTE (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_JURISDICCION foreign key (JURISDICCION_HECHO)
      references SIETID.EXP_ENTIDAD (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_POBLADO foreign key (CENTRO_POBLADO)
      references SIETID.EXP_CENTRO_POBLADO (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_TABLA foreign key (TABLA_INTERVINIENTE)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_TIPO_DIREC foreign key (TIPO_DIRECCION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE
   add constraint FK_EXP_EXPEDIENTE_TIPO_HECHO foreign key (TIPO_HECHO)
      references SIETID.EXP_TIPO_HECHO (ID);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint FK_EXP_DET_EXP_DEL_DELITOS foreign key (DELITO)
      references SIETID.EXP_DELITO (ID);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint FK_EXP_EXPEDIENTE_DELITO foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint FK_EXP_EXP_DELITO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint FK_EXP_EXP_DELITO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE_DELITO
   add constraint FK_EXP_EXP_DEL_PRIORIDAD foreign key (PRIORIDAD)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   add constraint FK_EXP_DET_CRIMEN_MED_MOV foreign key (CRIMEN)
      references SIETID.EXP_DET_CRIMEN (ID);

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   add constraint FK_EXP_DET_MEDIO_MOVIL foreign key (MEDIO_MOVIL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   add constraint FK_EXP_EXP_MED_MOV_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   add constraint FK_EXP_EXP_MED_MOV_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVOS_PER foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVO_EMPRESA foreign key (EMPRESA_PROPIETARIA)
      references SIETID.PER_EMPRESA (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVO_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVO_MARCA foreign key (MARCA)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPLOSIVO_PERSONA foreign key (PROPIETARIO)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPL_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPL_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_EXPLOSIVOS
   add constraint FK_EXP_EXPL_TIPO_MEDIDA foreign key (TIPO_MEDIDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTES_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTES_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTES_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTES_TIP_MODEDA foreign key (TIPO_MONEDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTE_BANCO foreign key (BANCO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTE_ESTADO foreign key (ESTADO_MONEDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTE_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_IMPORTES
   add constraint FK_EXP_IMPORTE_TIPO_CUENTA foreign key (TIPO_CUENTA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_INMUEBLE
   add constraint FK_EXP_INMUEBLE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_INMUEBLE
   add constraint FK_EXP_INMUEBLE_DISTRITO foreign key (UBICACION)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.EXP_INMUEBLE
   add constraint FK_EXP_INMUEBLE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_INMUEBLE
   add constraint FK_EXP_INMUEBLE_TIPO_DIRECC foreign key (TIPO_DIRECCION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_DISTRITO foreign key (UBICACION)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_ORG foreign key (ORGANIZACION)
      references SIETID.EXP_ORGANIZACION (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_POBLADO foreign key (CENTRO_POBLADO)
      references SIETID.EXP_CENTRO_POBLADO (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_SITUACION foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_INSTALACION
   add constraint FK_EXP_INSTALACION_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNICIONES_MARCA foreign key (ID)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNICION_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_MUNICIONES
   add constraint FK_EXP_MUNI_TIPO_MEDIDA foreign key (TIPO_MEDIDA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_ORGANIZACION
   add constraint FK_EXP_BANDAS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_ORGANIZACION
   add constraint FK_EXP_BANDAS_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_PREDECESOR
   add constraint FK_EXP_PREDECESOR_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_PREDECESOR
   add constraint FK_EXP_PREDECESOR_DEPENDENCIA foreign key (DEPENDENCIA)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.EXP_PREDECESOR
   add constraint FK_EXP_PREDECESOR_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_PREDECESOR
   add constraint FK_EXP_PREDECESOR_PREDECESORES foreign key (PREDECESOR)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_ESTADO_DOC foreign key (ESTADO_RUTA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_INTEGRANTE foreign key (INTEGRANTE)
      references SIETID.ORG_INTEGRANTE (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_TIPO_TABLA_DESTINO foreign key (TABLA_DESTINO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_TIPO_TABLA_ORIGEN foreign key (TABLA_ORIGEN)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_USUARIO_ORIGEN foreign key (USUARIO_ORIGEN)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_RUTA
   add constraint FK_EXP_RUTA_USUARIO_RECEPCION foreign key (USUARIO_RECEPCION)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_SITUACION_GENERAL
   add constraint FK_EXP_SITUACION_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_SITUACION_GENERAL
   add constraint FK_EXP_SITUACION_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_SITUACION_GENERAL
   add constraint FK_EXP_SITUACION_ESTADO_SIT foreign key (SITUACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_SITUACION_GENERAL
   add constraint FK_EXP_SITUACION_SITUACION foreign key (TABLA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_TIPO_HECHO
   add constraint FK_EXP_TIPO_HECHO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_TIPO_HECHO
   add constraint FK_EXP_TIPO_HECHO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_TIPO_HECHO
   add constraint FK_EXP_TIPO_HECHO_PADRE foreign key (PADRE)
      references SIETID.EXP_TIPO_HECHO (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_ANHO foreign key (ANO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_CILINDRAJE foreign key (CILINDROS)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_COLOR foreign key (COLOR)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_MODELO foreign key (MODELO)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_TIPO foreign key (TIPO_TAMANO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.EXP_VEHICULO
   add constraint FK_EXP_VEHICULO_TRANSMISION foreign key (TRANSMISION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAREM_MARCA foreign key (VEHICULO_MARCA)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_DEPEND_DESTINO foreign key (DEPENDENCIA_DESTINO)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_DEPEND_REMITE foreign key (DEPENDENCIA_REMITE)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_EXPEDIENTE foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.HR_HOJAREMISION
   add constraint FK_HR_HOJAR_TIPO_HR foreign key (TIPO_HR)
      references SIETID.CFG_VALOR (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_DROGA_MUESTRA foreign key (DROGAS)
      references SIETID.EXP_DROGAS (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_HOJAREM_UNIDMEDIDA foreign key (UNIDAD_MEDIDA)
      references SIETID.CFG_VALOR (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_HOJAR_ESPECIE foreign key (ESPECIE)
      references SIETID.EXP_ESPECIE (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_HOJAR_MUESTRA foreign key (HOJAREMISION)
      references SIETID.HR_HOJAREMISION (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_MUESTRA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table HR_HOJAREMISION_MUESTRA
   add constraint FK_HR_MUESTRA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.MNT_MODELO_MARCA
   add constraint FK_EXP_MODELO_MARCA_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.MNT_MODELO_MARCA
   add constraint FK_MODELO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.MNT_MODELO_MARCA
   add constraint FK_MODELO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.MNT_MODELO_MARCA
   add constraint FK_MODELO_MARCA_PADRE foreign key (PADRE)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table MNT_PAISES
   add constraint FK_MNT_PAIS_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table MNT_PAISES
   add constraint FK_MNT_PAIS_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table MNT_PAISES
   add constraint FK_MNT_PAIS_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table MNT_PAISES
   add constraint FK_MNT_PAIS_PADRE foreign key (PADRE)
      references MNT_PAISES (ID);

alter table SIETID.MNT_TIPO_ESPECIE
   add constraint FK_EXP_TIPO_ESPECIE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.MNT_TIPO_ESPECIE
   add constraint FK_EXP_TIPO_ESPECIE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.MNT_TIPO_ESPECIE
   add constraint FK_EXP_TIPO_ESPECIE_PADRE foreign key (PADRE)
      references SIETID.MNT_TIPO_ESPECIE (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_EQUIPO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_EQUIPO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_EQUIPO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_EQUIPO_PADRE foreign key (PADRE)
      references SIETID.ORG_EQUIPO (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_ORG_EQUIPO_AGRUPACION foreign key (TIPO_AGRUPACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.ORG_EQUIPO
   add constraint FK_ORG_EQUIPO_DEPENDENCIA foreign key (DEPENDENCIA)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_EQUIPO_INTEGRANTE foreign key (EQUIPO)
      references SIETID.ORG_EQUIPO (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_INTEGRANTE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_INTEGRANTE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_INTEGRANTE_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_INTEGRANTE_USUARIO foreign key (INTEGRANTE)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.ORG_INTEGRANTE
   add constraint FK_ORG_INTEGRANTE_FUNCION foreign key (FUNCION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_CORREO
   add constraint FK_CORREO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_CORREO
   add constraint FK_CORREO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_CORREO
   add constraint FK_CORREO_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PERSONA_DETALLE foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_COLOR_CABELLO foreign key (COLOR_CABELLO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_COLOR_OJO foreign key (COLOR_OJO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_COLOR_PIEL foreign key (COLOR_PIEL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_CONTEXTURA foreign key (CONTEXTURA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_CORTE_CABELLO foreign key (CORTE_CABELLO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_FORMA_BOCA foreign key (FORMA_BOCA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_FORMA_CARA foreign key (FORMA_CARA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_NO_IDENT foreign key (PERSONA_NA)
      references SIETID.PER_NO_IDENTIFICADOS (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_PROFESION foreign key (PROFESION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_CABELLO foreign key (TIPO_CABELLO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_CEJA foreign key (TIPO_CEJA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_LABIO foreign key (TIPO_LABIO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_NARIZ foreign key (TIPO_NARIZ)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_OJO foreign key (TIPO_OJO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_OREJA foreign key (TIPO_OREJA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DETALLE
   add constraint FK_PER_DETALLE_TIPO_RAZA foreign key (TIPO_RAZA)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_DIRECCION
   add constraint FK_PER_DIRECCION_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_DIRECCION
   add constraint FK_PER_DIRECCION_DISTRITO foreign key (DISTRITO)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.PER_DIRECCION
   add constraint FK_PER_DIRECCION_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_DIRECCION
   add constraint FK_PER_DIRECCION_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_EMPRESA
   add constraint FK_CFG_EMPRESA_PERSONA foreign key (REPRESENTANTE)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_EMPRESA
   add constraint FK_EMPRESA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_EMPRESA
   add constraint FK_EMPRESA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_EMPRESA
   add constraint FK_EMPRESA_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_IDENTIFICACION
   add constraint FK_PER_IDENTIFICACION_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_IDENTIFICACION
   add constraint FK_PER_IDENTIFICACION_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_IDENTIFICACION
   add constraint FK_PER_IDENTIFICACION_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_IDENTIFICACION
   add constraint FK_PER_IDENTIFICACION_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_IMAGEN
   add constraint FK_PER_IMAGEN_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_IMAGEN
   add constraint FK_PER_IMAGEN_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_IMAGEN
   add constraint FK_PER_IMAGEN_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_LETRADO
   add constraint FK_PER_ABOGADO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_LETRADO
   add constraint FK_PER_ABOGADO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_LETRADO
   add constraint FK_PER_ABOGADO_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint FK_PER_NO_IDENTIFICADOS_EXP foreign key (EXPEDIENTE)
      references SIETID.EXP_EXPEDIENTE (ID);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint FK_PER_NO_IDENTIFICADO_PERSONA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint FK_PER_NO_IDENT_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint FK_PER_NO_IDENT_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_NO_IDENTIFICADOS
   add constraint FK_PER_NO_IDENT_ORIENT foreign key (ORIENT_SEXUAL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_PARENTESCO
   add constraint FK_PERSONA_PARENTESCO foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_PARENTESCO
   add constraint FK_PER_PARENTESCO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_PARENTESCO
   add constraint FK_PER_PARENTESTCO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_PARENTESCO
   add constraint FK_PER_PARENTEZCO_RELACION foreign key (TIPO_RELACION)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_PARENTESCO
   add constraint FK_PER_PARIENTE foreign key (PERSONA_PARIENTE)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PERSONA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PERSONA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PERSONA_TIPO_DOCUMENTO foreign key (TIPO_DOCUMENTO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PER_PERSONA_ESTADO_CIVIL foreign key (ESTADO_CIVIL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PER_PERSONA_NACIMIENTO foreign key (LUGAR_NACIMIENTO)
      references SIETID.UBG_DISTRITO (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PER_PERSONA_NACIONALIDAD foreign key (NACIONALIDAD)
      references MNT_PAISES (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PER_PERSONA_ORIENTACION foreign key (ORIENTACION_SEXUAL)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_PERSONA
   add constraint FK_PER_PERSONA_PADRE foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_POLICIA
   add constraint FK_PER_PERSONA_POLICIA foreign key (PERSONA)
      references SIETID.PER_PERSONA (ID);

alter table SIETID.PER_POLICIA
   add constraint FK_PER_POLICIA_CARGO foreign key (CARGO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_POLICIA
   add constraint FK_PER_POLICIA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_POLICIA
   add constraint FK_PER_POLICIA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_POLICIA
   add constraint FK_PER_POLICIA_GRADO foreign key (GRADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_TELEFONO
   add constraint FK_PER_TELEFONO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_TELEFONO
   add constraint FK_PER_TELEFONO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.PER_TELEFONO
   add constraint FK_PER_TELEFONO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.PER_TELEFONO
   add constraint FK_PER_TELEFONO_MARCA foreign key (MARCA)
      references SIETID.MNT_MODELO_MARCA (ID);

alter table SIETID.PER_TELEFONO
   add constraint FK_PER_TELEFONO_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.SEG_OPCION
   add constraint FK_SEG_OPCION_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_OPCION
   add constraint FK_SEG_OPCION_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_OPCION
   add constraint FK_SEG_OPCION_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.SEG_OPCION
   add constraint FK_SEG_OPCION_PADRE foreign key (PADRE)
      references SIETID.SEG_OPCION (ID);

alter table SIETID.SEG_OPCION
   add constraint FK_SEG_OPCION_TIPO foreign key (TIPO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.SEG_PERMISO
   add constraint FK_SEG_PERMISO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_PERMISO
   add constraint FK_SEG_PERMISO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_PERMISO
   add constraint FK_SEG_PERM_FK_SEG_PE_CFG_VALO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.SEG_PERMISO
   add constraint FK_SEG_PERMISO_SEG_OPCION foreign key (OPCION)
      references SIETID.SEG_OPCION (ID);

alter table SIETID.SEG_PERMISO
   add constraint FK_SEG_PERMISO_SEG_ROL foreign key (ROL)
      references SIETID.SEG_ROL (ID);

alter table SIETID.SEG_PREFERENCIA
   add constraint FK_SEG_PREFERENCIA_USUARIO foreign key (USUARIO)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_ROL
   add constraint FK_SEG_ROL_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_ROL
   add constraint FK_SEG_ROL_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_ROL
   add constraint FK_SEG_ROL_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.SEG_ROL
   add constraint FK_SEG_ROL_PADRE foreign key (PADRE)
      references SIETID.SEG_ROL (ID);

alter table SIETID.SEG_USUARIO
   add constraint FK_SEG_USUARIO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_USUARIO
   add constraint FK_SEG_USUARIO_DEPENDENCIA foreign key (OFICINA)
      references SIETID.EXP_DEPENDENCIA (ID);

alter table SIETID.SEG_USUARIO
   add constraint FK_SEG_USUARIO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.SEG_USUARIO
   add constraint FK_SEG_USUARIO_POLICIA foreign key (POLICIA)
      references SIETID.PER_POLICIA (ID);

alter table SIETID.SEG_USUARIO
   add constraint FK_SEG_USUA_SEG_ROL foreign key (ROL)
      references SIETID.SEG_ROL (ID);

alter table SIETID.UBG_DEPARTAMENTO
   add constraint FK_UBG_DEPARTAMENTO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_DEPARTAMENTO
   add constraint FK_UBG_DEPARTAMENTO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_DEPARTAMENTO
   add constraint FK_UBG_DEPARTAMENTO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.UBG_DISTRITO
   add constraint FK_UBG_DISTRITO_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_DISTRITO
   add constraint FK_UBG_DISTRITO_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_DISTRITO
   add constraint FK_UBG_DISTRITO_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);

alter table SIETID.UBG_DISTRITO
   add constraint FK_UBG_DISTRITO_PROVINCIA foreign key (PROVINCIA)
      references SIETID.UBG_PROVINCIA (ID);

alter table SIETID.UBG_PROVINCIA
   add constraint FK_UBG_PROVINCIA_CREADOR foreign key (CREADOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_PROVINCIA
   add constraint FK_UBG_PROVINCIA_DEPARTAMENTO foreign key (DEPARTAMENTO)
      references SIETID.UBG_DEPARTAMENTO (ID);

alter table SIETID.UBG_PROVINCIA
   add constraint FK_UBG_PROVINCIA_EDITOR foreign key (EDITOR)
      references SIETID.SEG_USUARIO (ID);

alter table SIETID.UBG_PROVINCIA
   add constraint FK_UBG_PROVINCIA_ESTADO foreign key (ESTADO)
      references SIETID.CFG_VALOR (ID);