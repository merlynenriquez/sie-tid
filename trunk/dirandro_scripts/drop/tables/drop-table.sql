/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     10/10/2014 12:14:26 AM                       */
/*==============================================================*/


alter table SIETID.CFG_LISTA
   drop constraint FK_CGF_LISTA_CREADOR;

alter table SIETID.CFG_LISTA
   drop constraint FK_CGF_LISTA_EDITOR;

alter table SIETID.CFG_PARAMETRO
   drop constraint FK_CFG_PARAMETRO_CREADOR;

alter table SIETID.CFG_PARAMETRO
   drop constraint FK_CFG_PARAMETRO_EDITOR;

alter table SIETID.CFG_PARAMETRO
   drop constraint FK_CFG_PARAMETRO_ESTADO;

alter table SIETID.CFG_REGLA
   drop constraint FK_CFG_REGLA_CREADOR;

alter table SIETID.CFG_REGLA
   drop constraint FK_CFG_REGLA_EDITOR;

alter table SIETID.CFG_REGLA
   drop constraint FK_CFG_REGLA_ESTADO;

alter table SIETID.CFG_REGLA
   drop constraint FK_CFG_REGLA_TIPO;

alter table SIETID.CFG_VALOR
   drop constraint FK_CGF_VALOR_CGF_LISTA;

alter table SIETID.CFG_VALOR
   drop constraint FK_CGF_VALOR_CREADOR;

alter table SIETID.CFG_VALOR
   drop constraint FK_CGF_VALOR_EDITOR;

alter table EXP_ABOGADO_PERSONA
   drop constraint FK_EXP_ABOGADO_PER_CREADOR;

alter table EXP_ABOGADO_PERSONA
   drop constraint FK_EXP_ABOGADO_PER_EDITOR;

alter table EXP_ABOGADO_PERSONA
   drop constraint FK_SIIC_EXP_ABOGADO_REPRESENT;

alter table EXP_ABOGADO_PERSONA
   drop constraint FK_EXP_PERSONA_IMPLICADO;

alter table SIETID.EXP_ADJUNTO
   drop constraint FK_DET_REQ_DOC_CREADOR;

alter table SIETID.EXP_ADJUNTO
   drop constraint FK_DET_REQ_DOC_EDITOR;

alter table SIETID.EXP_ADJUNTO
   drop constraint FK_DET_REQ_DOC_TIPO;

alter table SIETID.EXP_ADJUNTO
   drop constraint FK_EXP_ADJUNTO_EXPEDIENTE;

alter table SIETID.EXP_ANEXO
   drop constraint FK_EXP_ANEXO_ADJUNTO;

alter table SIETID.EXP_ANEXO
   drop constraint FK_EXP_ANEXO_CREADOR;

alter table SIETID.EXP_ANEXO
   drop constraint FK_EXP_ANEXO_DOCUMENTO;

alter table SIETID.EXP_ANEXO
   drop constraint FK_EXP_ANEXO_EDITOR;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMAS_CREADOR;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMAS_EDITOR;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMAS_MODELO;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMA_CALIBRE;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMA_CLASIFICACION;

alter table SIETID.EXP_ARMAS
   drop constraint FK_EXP_ARMA_ESTADO_SERIE;

alter table SIETID.EXP_CENTRO_POBLADO
   drop constraint FK_EXP_POBLADO_CATEGORIA;

alter table SIETID.EXP_CENTRO_POBLADO
   drop constraint FK_EXP_POBLADO_CREADOR;

alter table SIETID.EXP_CENTRO_POBLADO
   drop constraint FK_EXP_POBLADO_DISTRITO;

alter table SIETID.EXP_CENTRO_POBLADO
   drop constraint FK_EXP_POBLADO_EDITOR;

alter table SIETID.EXP_CENTRO_POBLADO
   drop constraint FK_EXP_POBLADO_ESTADO;

alter table SIETID.EXP_DELITO
   drop constraint FK_EXP_DELITO_CODIGO_PROCESAL;

alter table SIETID.EXP_DELITO
   drop constraint FK_EXP_DELITO_CREADOR;

alter table SIETID.EXP_DELITO
   drop constraint FK_EXP_DELITO_EDITOR;

alter table SIETID.EXP_DELITO
   drop constraint FK_EXP_DELITO_ESTADO;

alter table SIETID.EXP_DELITO
   drop constraint FK_EXP_DELITO_PADRE;

alter table SIETID.EXP_DEPENDENCIA
   drop constraint FK_EXP_DEPENDENCIA_CREADOR;

alter table SIETID.EXP_DEPENDENCIA
   drop constraint FK_EXP_DEPENDENCIA_EDITOR;

alter table SIETID.EXP_DEPENDENCIA
   drop constraint FK_EXP_DEPENDENCIA_ESTADO;

alter table SIETID.EXP_DEPENDENCIA
   drop constraint FK_EXP_DEPENDENCIA_PADRE;

alter table SIETID.EXP_DEPENDENCIA
   drop constraint FK_EXP_DEPENDENCIA_SIGLA;

alter table SIETID.EXP_DET_CRIMEN
   drop constraint FK_EXP_DET_CRIMEN_CREADOR;

alter table SIETID.EXP_DET_CRIMEN
   drop constraint FK_EXP_DET_CRIMEN_EDITOR;

alter table SIETID.EXP_DET_CRIMEN
   drop constraint FK_EXP_DET_CRI_PRIORIDAD;

alter table SIETID.EXP_DET_CRIMEN
   drop constraint FK_EXP_DET_DEL_CRIMEN;

alter table SIETID.EXP_DET_CRIMEN
   drop constraint FK_EXP_DET_PER_CRIMEN;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_CREADOR;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_DROGA;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_ESTADO_PART;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_LOGO;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_PARTICIP;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGAS_PERSONA;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGA_EDITOR;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGA_MODALIDAD;

alter table EXP_DET_DROGAS
   drop constraint FK_EXP_DET_DROGA_TRANSPORTE;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER_CREADOR;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER_EMPRESA;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER_EXPEDIENTE;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER_PARTICIP;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER_SITUACION;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_DET_EXP_PER__PERSONA;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_PER_EDITOR;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop constraint FK_EXP_PER_ORGANIZACION;

alter table SIETID.EXP_DET_LLAMADAS
   drop constraint FK_EXP_DET_LLAMADAS_CREADOR;

alter table SIETID.EXP_DET_LLAMADAS
   drop constraint FK_EXP_DET_LLAMADAS_EDITOR;

alter table SIETID.EXP_DET_LLAMADAS
   drop constraint FK_EXP_DET_LLAMADAS_TIPO;

alter table SIETID.EXP_DET_LLAMADAS
   drop constraint FK_EXP_DET_PER_TEL_LLAMADAS;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARMA_SITUACION;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_ARMAS;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_CREADOR;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_EDITOR;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_EXPEDIENTE;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_PERSONA;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_DET_PER_ARM_EXP_PROPIETARIO;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_EXP_DET_ARM_ESTADO;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop constraint FK_EXP_DET_PER_ARM_EMPRESA;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_INM_EXP_PROPIETARIO;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_PER_INM_EXP_CREADOR;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_PER_INM_EXP_EDITOR;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_PER_INM_EXP_EXPEDIENTE;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_PER_INM_EXP_INMUEBLE;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop constraint FK_DET_PER_INM_SITUACION;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_DET_PER_TEL_EXP_CREADOR;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_DET_PER_TEL_EXP_EDITOR;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_DET_PER_TEL_EXP_EXPEDIENTE;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_DET_PER_TEL_EXP_NUMERO;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_DET_PER_TEL_EXP_TELEFONO;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_EXP_DET_PER_TEL_EXP_DUENO;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_EXP_DET_PER_TEL_IMPLICADO;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_EXP_DET_PER_TEL_OPERADORA;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_EXP_DET_PER_TEL_SITUACION;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop constraint FK_EXP_DET_TEL_ESTADO;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_CREADOR;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_EDITOR;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_EXP_EXPEDIENTE;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_EXP_PERSONA;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_EXP_VEHICULO;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_DET_PER_VEH_PROPIETARIO;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_EXP_DET_PER_VEH_CHASIS;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_EXP_DET_PER_VEH_MOTOR;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_EXP_DET_PER_VEH_SIT_LEGAL;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop constraint FK_EXP_DET_VEH_ESTADO;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_ADJUNTO;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_CREADOR;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_EDITOR;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_PRIORIDAD;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_PROCEDENCIA;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCUMENTO_TIPO;

alter table SIETID.EXP_DOCUMENTO
   drop constraint FK_EXP_DOCU_EXPEDIENTE;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_CREADOR;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_DESTINO;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_EDITOR;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_EXPEDIENTE;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_PROCEDENCIA;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGAS_SITUACION;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGA_TIPO;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGA_TIPO_MEDIDA;

alter table SIETID.EXP_DROGAS
   drop constraint FK_EXP_DROGA_TIPO_MUESTRA;

alter table SIETID.EXP_ENTIDAD
   drop constraint FK_CFG_ENTIDAD_CREADOR;

alter table SIETID.EXP_ENTIDAD
   drop constraint FK_CFG_ENTIDAD_EDITOR;

alter table SIETID.EXP_ENTIDAD
   drop constraint FK_EXP_ENTIDAD_DISTRITO;

alter table SIETID.EXP_ENTIDAD
   drop constraint FK_EXP_ENTIDAD_ESTADO;

alter table SIETID.EXP_ENTIDAD
   drop constraint FK_EXP_ENTIDAD_TIPO_ENTIDAD;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPECIE_CREADOR;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPECIE_EDITOR;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPECIE_MEDIDA;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPECIE_SITUACION;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPECIE_TIPO_ESP;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_ESPE_ESTADO;

alter table SIETID.EXP_ESPECIE
   drop constraint FK_EXP_EXPEDIENTE_ESPECIE;

alter table SIETID.EXP_ESTADO
   drop constraint FK_ESTADO_TIPO_ESTADO;

alter table SIETID.EXP_ESTADO
   drop constraint FK_EST_REQ_CREADOR;

alter table SIETID.EXP_ESTADO
   drop constraint FK_EST_REQ_EDITOR;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_AMPLIACION;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_CREADOR;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_CUENCA;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_DEPENDENCIA;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_DISTRITO;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_EDITOR;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_ESTADO_EXP;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_FINALIDAD;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_INTEGRANTE;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_JURISDICCION;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_POBLADO;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_TABLA;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_TIPO_DIREC;

alter table SIETID.EXP_EXPEDIENTE
   drop constraint FK_EXP_EXPEDIENTE_TIPO_HECHO;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop constraint FK_EXP_DET_EXP_DEL_DELITOS;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop constraint FK_EXP_EXPEDIENTE_DELITO;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop constraint FK_EXP_EXP_DELITO_CREADOR;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop constraint FK_EXP_EXP_DELITO_EDITOR;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop constraint FK_EXP_EXP_DEL_PRIORIDAD;

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   drop constraint FK_EXP_DET_CRIMEN_MED_MOV;

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   drop constraint FK_EXP_DET_MEDIO_MOVIL;

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   drop constraint FK_EXP_EXP_MED_MOV_CREADOR;

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   drop constraint FK_EXP_EXP_MED_MOV_EDITOR;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVOS_PERSONA;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVOS_TIPO_MEDIDA;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVO_EMPRESA;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVO_ESTADO;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVO_EXPEDIENTE;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVO_MARCA;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPLOSIVO_SITUACION;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPL_CREADOR;

alter table SIETID.EXP_EXPLOSIVOS
   drop constraint FK_EXP_EXPL_EDITOR;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTES_CREADOR;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTES_EDITOR;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTES_EXPEDIENTE;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTES_PRESENTACION;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTES_TIP_MODEDA;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTE_BANCO;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTE_ESTADO;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTE_SITUACION;

alter table SIETID.EXP_IMPORTES
   drop constraint FK_EXP_IMPORTE_TIPO_CUENTA;

alter table SIETID.EXP_INMUEBLE
   drop constraint FK_EXP_INMUEBLE_CREADOR;

alter table SIETID.EXP_INMUEBLE
   drop constraint FK_EXP_INMUEBLE_DISTRITO;

alter table SIETID.EXP_INMUEBLE
   drop constraint FK_EXP_INMUEBLE_EDITOR;

alter table SIETID.EXP_INMUEBLE
   drop constraint FK_EXP_INMUEBLE_TIPO_DIRECC;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_CREADOR;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_DISTRITO;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_EDITOR;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_EXPEDIENTE;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_ORG;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_POBLADO;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_SITUACION;

alter table SIETID.EXP_INSTALACION
   drop constraint FK_EXP_INSTALACION_TIPO;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNICIONES_MARCA;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNICION_CALIBRE;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNICION_EMPRESA;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNICION_EXPEDIENTE;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNICION_SITUACION;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNION_TIPO_MEDIDA;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNI_CREADOR;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNI_EDITOR;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNI_ESTADO;

alter table SIETID.EXP_MUNICIONES
   drop constraint FK_EXP_MUNI_PERSONA;

alter table SIETID.EXP_NUMERO
   drop constraint FK_EXP_NUMERO_CREADOR;

alter table SIETID.EXP_NUMERO
   drop constraint FK_EXP_NUMERO_EDITOR;

alter table SIETID.EXP_ORGANIZACION
   drop constraint FK_EXP_BANDAS_CREADOR;

alter table SIETID.EXP_ORGANIZACION
   drop constraint FK_EXP_BANDAS_EDITOR;

alter table SIETID.EXP_PREDECESOR
   drop constraint FK_EXP_PREDECESOR_CREADOR;

alter table SIETID.EXP_PREDECESOR
   drop constraint FK_EXP_PREDECESOR_DEPENDENCIA;

alter table SIETID.EXP_PREDECESOR
   drop constraint FK_EXP_PREDECESOR_EDITOR;

alter table SIETID.EXP_PREDECESOR
   drop constraint FK_EXP_PREDECESOR_PREDECESORES;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_CREADOR;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_EDITOR;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_ESTADO_DOC;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_EXPEDIENTE;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_INTEGRANTE;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_TIPO_TABLA_DESTINO;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_TIPO_TABLA_ORIGEN;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_USUARIO_ORIGEN;

alter table SIETID.EXP_RUTA
   drop constraint FK_EXP_RUTA_USUARIO_RECEPCION;

alter table SIETID.EXP_SITUACION_GENERAL
   drop constraint FK_EXP_SITUACION_CREADOR;

alter table SIETID.EXP_SITUACION_GENERAL
   drop constraint FK_EXP_SITUACION_EDITOR;

alter table SIETID.EXP_SITUACION_GENERAL
   drop constraint FK_EXP_SITUACION_ESTADO_SIT;

alter table SIETID.EXP_SITUACION_GENERAL
   drop constraint FK_EXP_SITUACION_SITUACION;

alter table SIETID.EXP_TIPO_HECHO
   drop constraint FK_EXP_TIPO_HECHO_CREADOR;

alter table SIETID.EXP_TIPO_HECHO
   drop constraint FK_EXP_TIPO_HECHO_EDITOR;

alter table SIETID.EXP_TIPO_HECHO
   drop constraint FK_EXP_TIPO_HECHO_ESTADO;

alter table SIETID.EXP_TIPO_HECHO
   drop constraint FK_EXP_TIPO_HECHO_PADRE;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_ANHO;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_CILINDRAJE;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_COLOR;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_CREADOR;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_EDITOR;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_MODELO;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_TIPO;

alter table SIETID.EXP_VEHICULO
   drop constraint FK_EXP_VEHICULO_TRANSMISION;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAREM_CUSTODIO;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAREM_MARCA;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_CREADOR;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_DEPEND_DESTINO;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_DEPEND_REMITE;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_EDITOR;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_EXPEDIENTE;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_PERSONA;

alter table SIETID.HR_HOJAREMISION
   drop constraint FK_HR_HOJAR_TIPO_HR;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HOJA_REMISION_TIPO_MEDIDA;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HR_DROGA_MUESTRA;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HR_HOJAR_ESPECIE;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HR_HOJAR_MUESTRA;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HR_MUESTRA_CREADOR;

alter table HR_HOJAREMISION_MUESTRA
   drop constraint FK_HR_MUESTRA_EDITOR;

alter table SIETID.MNT_MODELO_MARCA
   drop constraint FK_MODELO_CREADOR;

alter table SIETID.MNT_MODELO_MARCA
   drop constraint FK_MODELO_EDITOR;

alter table SIETID.MNT_MODELO_MARCA
   drop constraint FK_MODELO_MARCA_PADRE;

alter table MNT_PAISES
   drop constraint FK_MNT_PAIS_CREADOR;

alter table MNT_PAISES
   drop constraint FK_MNT_PAIS_EDITOR;

alter table MNT_PAISES
   drop constraint FK_MNT_PAIS_ESTADO;

alter table MNT_PAISES
   drop constraint FK_MNT_PAIS_PADRE;

alter table SIETID.MNT_TIPO_ESPECIE
   drop constraint FK_EXP_TIPO_ESPECIE_CREADOR;

alter table SIETID.MNT_TIPO_ESPECIE
   drop constraint FK_EXP_TIPO_ESPECIE_EDITOR;

alter table SIETID.MNT_TIPO_ESPECIE
   drop constraint FK_EXP_TIPO_ESPECIE_PADRE;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_INTEGRANTE_CREADOR;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_INTEGRANTE_EDITOR;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_INTEGRANTE_ESTADO;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_ORG_INTEGRANTE_FUNCION;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_ORG_INTEGRANTE_DEPENDENCIA;

alter table SIETID.ORG_INTEGRANTE
   drop constraint FK_ORG_INTEGRANTE_POLICIA;

alter table SIETID.PER_CORREO
   drop constraint FK_CORREO_CREADOR;

alter table SIETID.PER_CORREO
   drop constraint FK_CORREO_EDITOR;

alter table SIETID.PER_CORREO
   drop constraint FK_CORREO_PERSONA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PERSONA_DETALLE;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_COLOR_CABELLO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_COLOR_OJO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_COLOR_PIEL;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_CONTEXTURA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_CORTE_CABELLO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_CREADOR;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_EDITOR;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_FORMA_BOCA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_FORMA_CARA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_NO_IDENT;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_PROFESION;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_CABELLO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_CEJA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_LABIO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_NARIZ;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_OJO;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_OREJA;

alter table SIETID.PER_DETALLE
   drop constraint FK_PER_DETALLE_TIPO_RAZA;

alter table SIETID.PER_DIRECCION
   drop constraint FK_PER_DIRECCION_CREADOR;

alter table SIETID.PER_DIRECCION
   drop constraint FK_PER_DIRECCION_DISTRITO;

alter table SIETID.PER_DIRECCION
   drop constraint FK_PER_DIRECCION_EDITOR;

alter table SIETID.PER_DIRECCION
   drop constraint FK_PER_DIRECCION_PERSONA;

alter table SIETID.PER_EMPRESA
   drop constraint FK_CFG_EMPRESA_PERSONA;

alter table SIETID.PER_EMPRESA
   drop constraint FK_EMPRESA_CREADOR;

alter table SIETID.PER_EMPRESA
   drop constraint FK_EMPRESA_EDITOR;

alter table SIETID.PER_EMPRESA
   drop constraint FK_EMPRESA_ESTADO;

alter table SIETID.PER_IDENTIFICACION
   drop constraint FK_PER_IDENTIFICACION_CREADOR;

alter table SIETID.PER_IDENTIFICACION
   drop constraint FK_PER_IDENTIFICACION_EDITOR;

alter table SIETID.PER_IDENTIFICACION
   drop constraint FK_PER_IDENTIFICACION_PERSONA;

alter table SIETID.PER_IDENTIFICACION
   drop constraint FK_PER_IDENTIFICACION_TIPO;

alter table SIETID.PER_IMAGEN
   drop constraint FK_PER_IMAGEN_ADJUNTO;

alter table SIETID.PER_IMAGEN
   drop constraint FK_PER_IMAGEN_CREADOR;

alter table SIETID.PER_IMAGEN
   drop constraint FK_PER_IMAGEN_EDITOR;

alter table SIETID.PER_IMAGEN
   drop constraint FK_PER_IMAGEN_PERSONA;

alter table SIETID.PER_LETRADO
   drop constraint FK_PER_ABOGADO_CREADOR;

alter table SIETID.PER_LETRADO
   drop constraint FK_PER_ABOGADO_EDITOR;

alter table SIETID.PER_LETRADO
   drop constraint FK_PER_ABOGADO_PERSONA;

alter table SIETID.PER_LETRADO
   drop constraint FK_PER_LETRADO_TIPO;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop constraint FK_PER_NO_IDENTIFICADOS_EXP;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop constraint FK_PER_NO_IDENTIFICADO_PERSONA;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop constraint FK_PER_NO_IDENT_CREADOR;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop constraint FK_PER_NO_IDENT_EDITOR;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop constraint FK_PER_NO_IDENT_ORIENT;

alter table SIETID.PER_PARENTESCO
   drop constraint FK_PERSONA_PARENTESCO;

alter table SIETID.PER_PARENTESCO
   drop constraint FK_PER_PARENTESCO_CREADOR;

alter table SIETID.PER_PARENTESCO
   drop constraint FK_PER_PARENTESTCO_EDITOR;

alter table SIETID.PER_PARENTESCO
   drop constraint FK_PER_PARENTEZCO_RELACION;

alter table SIETID.PER_PARENTESCO
   drop constraint FK_PER_PARIENTE;

alter table SIETID.PER_PERSONA
   drop constraint FK_PERSONA_CREADOR;

alter table SIETID.PER_PERSONA
   drop constraint FK_PERSONA_EDITOR;

alter table SIETID.PER_PERSONA
   drop constraint FK_PERSONA_TIPO_DOCUMENTO;

alter table SIETID.PER_PERSONA
   drop constraint FK_PER_PERSONA_ESTADO_CIVIL;

alter table SIETID.PER_PERSONA
   drop constraint FK_PER_PERSONA_NACIMIENTO;

alter table SIETID.PER_PERSONA
   drop constraint FK_PER_PERSONA_NACIONALIDAD;

alter table SIETID.PER_PERSONA
   drop constraint FK_PER_PERSONA_ORIENTACION;

alter table SIETID.PER_PERSONA
   drop constraint FK_PER_PERSONA_PADRE;

alter table SIETID.PER_POLICIA
   drop constraint FK_PER_PERSONA_POLICIA;

alter table SIETID.PER_POLICIA
   drop constraint FK_PER_POLICIA_CARGO;

alter table SIETID.PER_POLICIA
   drop constraint FK_PER_POLICIA_CREADOR;

alter table SIETID.PER_POLICIA
   drop constraint FK_PER_POLICIA_EDITOR;

alter table SIETID.PER_POLICIA
   drop constraint FK_PER_POLICIA_GRADO;

alter table SIETID.PER_TELEFONO
   drop constraint FK_PER_TELEFONO_CREADOR;

alter table SIETID.PER_TELEFONO
   drop constraint FK_PER_TELEFONO_EDITOR;

alter table SIETID.PER_TELEFONO
   drop constraint FK_PER_TELEFONO_ESTADO;

alter table SIETID.PER_TELEFONO
   drop constraint FK_PER_TELEFONO_FRECUENCIA;

alter table SIETID.PER_TELEFONO
   drop constraint FK_PER_TELEFONO_MARCA;

alter table SIETID.SEG_OPCION
   drop constraint FK_SEG_OPCION_CREADOR;

alter table SIETID.SEG_OPCION
   drop constraint FK_SEG_OPCION_EDITOR;

alter table SIETID.SEG_OPCION
   drop constraint FK_SEG_OPCION_ESTADO;

alter table SIETID.SEG_OPCION
   drop constraint FK_SEG_OPCION_PADRE;

alter table SIETID.SEG_OPCION
   drop constraint FK_SEG_OPCION_TIPO;

alter table SIETID.SEG_PERMISO
   drop constraint FK_SEG_PERMISO_CREADOR;

alter table SIETID.SEG_PERMISO
   drop constraint FK_SEG_PERMISO_EDITOR;

alter table SIETID.SEG_PERMISO
   drop constraint FK_SEG_PERM_FK_SEG_PE_CFG_VALO;

alter table SIETID.SEG_PERMISO
   drop constraint FK_SEG_PERMISO_SEG_OPCION;

alter table SIETID.SEG_PERMISO
   drop constraint FK_SEG_PERMISO_SEG_ROL;

alter table SIETID.SEG_PREFERENCIA
   drop constraint FK_SEG_PREFERENCIA_USUARIO;

alter table SIETID.SEG_ROL
   drop constraint FK_SEG_ROL_CREADOR;

alter table SIETID.SEG_ROL
   drop constraint FK_SEG_ROL_EDITOR;

alter table SIETID.SEG_ROL
   drop constraint FK_SEG_ROL_ESTADO;

alter table SIETID.SEG_ROL
   drop constraint FK_SEG_ROL_PADRE;

alter table SIETID.SEG_USUARIO
   drop constraint FK_SEG_USUARIO_CREADOR;

alter table SIETID.SEG_USUARIO
   drop constraint FK_SEG_USUARIO_DEPENDENCIA;

alter table SIETID.SEG_USUARIO
   drop constraint FK_SEG_USUARIO_EDITOR;

alter table SIETID.SEG_USUARIO
   drop constraint FK_SEG_USUARIO_POLICIA;

alter table SIETID.SEG_USUARIO
   drop constraint FK_SEG_USUA_SEG_ROL;

alter table SIETID.UBG_DEPARTAMENTO
   drop constraint FK_UBG_DEPARTAMENTO_CREADOR;

alter table SIETID.UBG_DEPARTAMENTO
   drop constraint FK_UBG_DEPARTAMENTO_EDITOR;

alter table SIETID.UBG_DEPARTAMENTO
   drop constraint FK_UBG_DEPARTAMENTO_ESTADO;

alter table SIETID.UBG_DISTRITO
   drop constraint FK_UBG_DISTRITO_CREADOR;

alter table SIETID.UBG_DISTRITO
   drop constraint FK_UBG_DISTRITO_EDITOR;

alter table SIETID.UBG_DISTRITO
   drop constraint FK_UBG_DISTRITO_ESTADO;

alter table SIETID.UBG_DISTRITO
   drop constraint FK_UBG_DISTRITO_PROVINCIA;

alter table SIETID.UBG_PROVINCIA
   drop constraint FK_UBG_PROVINCIA_CREADOR;

alter table SIETID.UBG_PROVINCIA
   drop constraint FK_UBG_PROVINCIA_DEPARTAMENTO;

alter table SIETID.UBG_PROVINCIA
   drop constraint FK_UBG_PROVINCIA_EDITOR;

alter table SIETID.UBG_PROVINCIA
   drop constraint FK_UBG_PROVINCIA_ESTADO;

drop index SIETID.UNQ_CODIGO_LISTA;

alter table SIETID.CFG_LISTA
   drop primary key cascade;

drop table SIETID.CFG_LISTA cascade constraints;

alter table SIETID.CFG_PARAMETRO
   drop primary key cascade;

drop table SIETID.CFG_PARAMETRO cascade constraints;

alter table SIETID.CFG_REGLA
   drop primary key cascade;

drop table SIETID.CFG_REGLA cascade constraints;

drop index SIETID.UNQ_CODIGO_VALOR;

alter table SIETID.CFG_VALOR
   drop primary key cascade;

drop table SIETID.CFG_VALOR cascade constraints;

alter table EXP_ABOGADO_PERSONA
   drop primary key cascade;

drop table EXP_ABOGADO_PERSONA cascade constraints;

alter table SIETID.EXP_ADJUNTO
   drop primary key cascade;

drop table SIETID.EXP_ADJUNTO cascade constraints;

alter table SIETID.EXP_ANEXO
   drop primary key cascade;

drop table SIETID.EXP_ANEXO cascade constraints;

alter table SIETID.EXP_ARMAS
   drop primary key cascade;

drop table SIETID.EXP_ARMAS cascade constraints;

alter table SIETID.EXP_CENTRO_POBLADO
   drop primary key cascade;

drop table SIETID.EXP_CENTRO_POBLADO cascade constraints;

alter table SIETID.EXP_DELITO
   drop primary key cascade;

drop table SIETID.EXP_DELITO cascade constraints;

alter table SIETID.EXP_DEPENDENCIA
   drop primary key cascade;

drop table SIETID.EXP_DEPENDENCIA cascade constraints;

alter table SIETID.EXP_DET_CRIMEN
   drop primary key cascade;

drop table SIETID.EXP_DET_CRIMEN cascade constraints;

alter table EXP_DET_DROGAS
   drop primary key cascade;

drop table EXP_DET_DROGAS cascade constraints;

alter table SIETID.EXP_DET_EXPEDIENTE_PERSONA
   drop primary key cascade;

drop table SIETID.EXP_DET_EXPEDIENTE_PERSONA cascade constraints;

alter table SIETID.EXP_DET_LLAMADAS
   drop primary key cascade;

drop table SIETID.EXP_DET_LLAMADAS cascade constraints;

alter table SIETID.EXP_DET_PER_ARM_EXP
   drop primary key cascade;

drop table SIETID.EXP_DET_PER_ARM_EXP cascade constraints;

alter table SIETID.EXP_DET_PER_INM_EXP
   drop primary key cascade;

drop table SIETID.EXP_DET_PER_INM_EXP cascade constraints;

alter table SIETID.EXP_DET_PER_TEL_EXP
   drop primary key cascade;

drop table SIETID.EXP_DET_PER_TEL_EXP cascade constraints;

alter table SIETID.EXP_DET_PER_VEH_EXP
   drop primary key cascade;

drop table SIETID.EXP_DET_PER_VEH_EXP cascade constraints;

alter table SIETID.EXP_DOCUMENTO
   drop primary key cascade;

drop table SIETID.EXP_DOCUMENTO cascade constraints;

alter table SIETID.EXP_DROGAS
   drop primary key cascade;

drop table SIETID.EXP_DROGAS cascade constraints;

alter table SIETID.EXP_ENTIDAD
   drop primary key cascade;

drop table SIETID.EXP_ENTIDAD cascade constraints;

alter table SIETID.EXP_ESPECIE
   drop primary key cascade;

drop table SIETID.EXP_ESPECIE cascade constraints;

alter table SIETID.EXP_ESTADO
   drop primary key cascade;

drop table SIETID.EXP_ESTADO cascade constraints;

alter table SIETID.EXP_EXPEDIENTE
   drop primary key cascade;

drop table SIETID.EXP_EXPEDIENTE cascade constraints;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop primary key cascade;

alter table SIETID.EXP_EXPEDIENTE_DELITO
   drop unique (DELITO, EXPEDIENTE, PRIORIDAD) cascade;

drop table SIETID.EXP_EXPEDIENTE_DELITO cascade constraints;

alter table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL
   drop primary key cascade;

drop table SIETID.EXP_EXPEDIENTE_MEDIOS_MOVIL cascade constraints;

alter table SIETID.EXP_EXPLOSIVOS
   drop primary key cascade;

drop table SIETID.EXP_EXPLOSIVOS cascade constraints;

alter table SIETID.EXP_IMPORTES
   drop primary key cascade;

drop table SIETID.EXP_IMPORTES cascade constraints;

alter table SIETID.EXP_INMUEBLE
   drop primary key cascade;

drop table SIETID.EXP_INMUEBLE cascade constraints;

alter table SIETID.EXP_INSTALACION
   drop primary key cascade;

drop table SIETID.EXP_INSTALACION cascade constraints;

alter table SIETID.EXP_MUNICIONES
   drop primary key cascade;

drop table SIETID.EXP_MUNICIONES cascade constraints;

alter table SIETID.EXP_NUMERO
   drop primary key cascade;

drop table SIETID.EXP_NUMERO cascade constraints;

alter table SIETID.EXP_ORGANIZACION
   drop primary key cascade;

drop table SIETID.EXP_ORGANIZACION cascade constraints;

alter table SIETID.EXP_PREDECESOR
   drop primary key cascade;

drop table SIETID.EXP_PREDECESOR cascade constraints;

alter table SIETID.EXP_RUTA
   drop primary key cascade;

drop table SIETID.EXP_RUTA cascade constraints;

alter table SIETID.EXP_SITUACION_GENERAL
   drop primary key cascade;

drop table SIETID.EXP_SITUACION_GENERAL cascade constraints;

alter table SIETID.EXP_TIPO_HECHO
   drop primary key cascade;

drop table SIETID.EXP_TIPO_HECHO cascade constraints;

alter table SIETID.EXP_VEHICULO
   drop primary key cascade;

drop table SIETID.EXP_VEHICULO cascade constraints;

alter table SIETID.HR_HOJAREMISION
   drop primary key cascade;

drop table SIETID.HR_HOJAREMISION cascade constraints;

alter table HR_HOJAREMISION_MUESTRA
   drop primary key cascade;

drop table HR_HOJAREMISION_MUESTRA cascade constraints;

alter table SIETID.MNT_MODELO_MARCA
   drop primary key cascade;

drop table SIETID.MNT_MODELO_MARCA cascade constraints;

alter table MNT_PAISES
   drop primary key cascade;

drop table MNT_PAISES cascade constraints;

alter table SIETID.MNT_TIPO_ESPECIE
   drop primary key cascade;

drop table SIETID.MNT_TIPO_ESPECIE cascade constraints;

alter table SIETID.ORG_INTEGRANTE
   drop primary key cascade;

drop table SIETID.ORG_INTEGRANTE cascade constraints;

alter table SIETID.PER_CORREO
   drop primary key cascade;

drop table SIETID.PER_CORREO cascade constraints;

alter table SIETID.PER_DETALLE
   drop primary key cascade;

drop table SIETID.PER_DETALLE cascade constraints;

alter table SIETID.PER_DIRECCION
   drop primary key cascade;

drop table SIETID.PER_DIRECCION cascade constraints;

alter table SIETID.PER_EMPRESA
   drop primary key cascade;

drop table SIETID.PER_EMPRESA cascade constraints;

alter table SIETID.PER_IDENTIFICACION
   drop primary key cascade;

drop table SIETID.PER_IDENTIFICACION cascade constraints;

alter table SIETID.PER_IMAGEN
   drop primary key cascade;

drop table SIETID.PER_IMAGEN cascade constraints;

alter table SIETID.PER_LETRADO
   drop primary key cascade;

drop table SIETID.PER_LETRADO cascade constraints;

alter table SIETID.PER_NO_IDENTIFICADOS
   drop primary key cascade;

drop table SIETID.PER_NO_IDENTIFICADOS cascade constraints;

alter table SIETID.PER_PARENTESCO
   drop primary key cascade;

drop table SIETID.PER_PARENTESCO cascade constraints;

alter table SIETID.PER_PERSONA
   drop primary key cascade;

drop table SIETID.PER_PERSONA cascade constraints;

alter table SIETID.PER_POLICIA
   drop primary key cascade;

drop table SIETID.PER_POLICIA cascade constraints;

alter table SIETID.PER_TELEFONO
   drop primary key cascade;

drop table SIETID.PER_TELEFONO cascade constraints;

drop index SIETID.UNQ_CODIGO_OPCION;

alter table SIETID.SEG_OPCION
   drop primary key cascade;

drop table SIETID.SEG_OPCION cascade constraints;

alter table SIETID.SEG_PERMISO
   drop primary key cascade;

drop table SIETID.SEG_PERMISO cascade constraints;

alter table SIETID.SEG_PREFERENCIA
   drop primary key cascade;

drop table SIETID.SEG_PREFERENCIA cascade constraints;

drop index SIETID.UNQ_CODIGO_ROL;

alter table SIETID.SEG_ROL
   drop primary key cascade;

drop table SIETID.SEG_ROL cascade constraints;

alter table SIETID.SEG_USUARIO
   drop unique (USUARIO) cascade;

alter table SIETID.SEG_USUARIO
   drop primary key cascade;

drop table SIETID.SEG_USUARIO cascade constraints;

alter table SIETID.SEQ_TABLA
   drop primary key cascade;

drop table SIETID.SEQ_TABLA cascade constraints;

alter table SIETID.UBG_DEPARTAMENTO
   drop primary key cascade;

drop table SIETID.UBG_DEPARTAMENTO cascade constraints;

alter table SIETID.UBG_DISTRITO
   drop primary key cascade;

drop table SIETID.UBG_DISTRITO cascade constraints;

alter table SIETID.UBG_PROVINCIA
   drop primary key cascade;

drop table SIETID.UBG_PROVINCIA cascade constraints;

quit;