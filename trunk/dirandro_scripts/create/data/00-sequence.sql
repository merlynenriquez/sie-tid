/** Creacion de Secuencias **/

DROP SEQUENCE SEQ_VALOR ;
CREATE SEQUENCE SEQ_VALOR INCREMENT BY 1 START WITH 500 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_LISTA ;
CREATE SEQUENCE SEQ_LISTA INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PERSONA ;
CREATE SEQUENCE SEQ_PERSONA INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ESTADO ;
CREATE SEQUENCE SEQ_ESTADO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CORREO ;
CREATE SEQUENCE SEQ_CORREO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DIRECCION ;
CREATE SEQUENCE SEQ_DIRECCION INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DETALLE ;
CREATE SEQUENCE SEQ_DETALLE INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PARENTESCO ;
CREATE SEQUENCE SEQ_PARENTESCO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_IDENTIFICACION ;
CREATE SEQUENCE SEQ_IDENTIFICACION INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ADJUNTO ;
CREATE SEQUENCE SEQ_ADJUNTO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_IMAGEN ;
CREATE SEQUENCE SEQ_IMAGEN INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_POLICIA ;
create sequence SEQ_POLICIA increment by 1 start with 100 maxvalue 999999999 minvalue 1 nocache;

DROP SEQUENCE SEQ_LETRADO ;
CREATE SEQUENCE SEQ_LETRADO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ORGANIZACION ;
CREATE SEQUENCE SEQ_ORGANIZACION INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EMPRESA ;
CREATE SEQUENCE SEQ_EMPRESA INCREMENT BY 1 START WITH 5600 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_USUARIO ;
CREATE SEQUENCE SEQ_USUARIO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DEPENDENCIA ;
CREATE SEQUENCE SEQ_DEPENDENCIA INCREMENT BY 1 START WITH 200 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ENTIDAD ;
CREATE SEQUENCE SEQ_ENTIDAD INCREMENT BY 1 START WITH 499 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EQUIPO ;
CREATE SEQUENCE SEQ_EQUIPO INCREMENT BY 1 START WITH 499 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_MODELO_MARCA ;
CREATE SEQUENCE SEQ_MODELO_MARCA INCREMENT BY 1 START WITH 1200 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INTEGRANTE ;
CREATE SEQUENCE SEQ_INTEGRANTE INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXPEDIENTE ;
CREATE SEQUENCE SEQ_EXPEDIENTE INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DOCUMENTO ;
CREATE SEQUENCE SEQ_DOCUMENTO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_TIPO_HECHO ;
CREATE SEQUENCE SEQ_TIPO_HECHO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DELITO ;
CREATE SEQUENCE SEQ_DELITO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PAIS ;
CREATE SEQUENCE SEQ_PAIS INCREMENT BY 1 START WITH 2000 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_TIPO_ESPECIE;
CREATE SEQUENCE SEQ_TIPO_ESPECIE INCREMENT BY 1 START WITH 200 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CENTRO_POBLADO;
CREATE SEQUENCE SEQ_CENTRO_POBLADO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INSTALACION;
CREATE SEQUENCE SEQ_INSTALACION INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_DELITO;
CREATE SEQUENCE SEQ_EXP_DELITO INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CRIMEN;
CREATE SEQUENCE SEQ_CRIMEN INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_RUTA;
CREATE SEQUENCE SEQ_RUTA INCREMENT BY 1 START WITH 100 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_INMUEBLE;
CREATE SEQUENCE SEQ_EXP_INMUEBLE INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INMUEBLE;
CREATE SEQUENCE SEQ_INMUEBLE INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_MUNICION;
CREATE SEQUENCE SEQ_MUNICION INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_ESPECIE;
CREATE SEQUENCE SEQ_EXP_ESPECIE INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_VEHICULO;
CREATE SEQUENCE SEQ_VEHICULO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_VEHICULO;
CREATE SEQUENCE SEQ_EXP_VEHICULO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DROGA;
CREATE SEQUENCE SEQ_DROGA INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXPLOSIVO;
CREATE SEQUENCE SEQ_EXPLOSIVO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_TELEFONO;
CREATE SEQUENCE SEQ_EXP_TELEFONO INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DETALLE_ARMA;
CREATE SEQUENCE SEQ_DETALLE_ARMA INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ARMA;
CREATE SEQUENCE SEQ_ARMA INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXPEDIENTE_PERSONA;
CREATE SEQUENCE SEQ_EXPEDIENTE_PERSONA INCREMENT BY 1 START WITH 5 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_NO_IDENTIFICADO;
CREATE SEQUENCE SEQ_NO_IDENTIFICADO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_TELEFONO;
CREATE SEQUENCE SEQ_TELEFONO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_NUMERO;
CREATE SEQUENCE SEQ_NUMERO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_IMPORTE;
CREATE SEQUENCE SEQ_IMPORTE INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_HOJAREMISION;
CREATE SEQUENCE SEQ_HOJAREMISION INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_HOJAREMISION_MUESTRA;
CREATE SEQUENCE SEQ_HOJAREMISION_MUESTRA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_ABOGADO_PERSONA;
CREATE SEQUENCE SEQ_ABOGADO_PERSONA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PERMISO;
CREATE SEQUENCE SEQ_PERMISO INCREMENT BY 1 START WITH 69 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_DET_DROGA;
CREATE SEQUENCE SEQ_DET_DROGA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PERICIA;
CREATE SEQUENCE SEQ_PERICIA INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_NOTA_INFORMATIVA;
CREATE SEQUENCE SEQ_EXP_NOTA_INFORMATIVA INCREMENT BY 1 START WITH 10 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_OFICIO_SOLICITADO;
CREATE SEQUENCE SEQ_OFICIO_SOLICITADO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_OFICIO_SOLICITADO_ADJUNTO;
CREATE SEQUENCE SEQ_OFICIO_SOLICITADO_ADJUNTO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO;
CREATE SEQUENCE SEQ_CASO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO_AGENTE;
CREATE SEQUENCE SEQ_CASO_AGENTE INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO_DIRECCION;
CREATE SEQUENCE SEQ_CASO_DIRECCION INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO_IMAGEN;
CREATE SEQUENCE SEQ_CASO_IMAGEN INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO_PERSONA;
CREATE SEQUENCE SEQ_CASO_PERSONA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_CASO_VEHICULO;
CREATE SEQUENCE SEQ_CASO_VEHICULO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_INTELIGENCIA;
CREATE SEQUENCE SEQ_INT_INTELIGENCIA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_RUTA;
CREATE SEQUENCE SEQ_INT_RUTA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_GREMIO_COCALERO;
CREATE SEQUENCE SEQ_INT_GREMIO_COCALERO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_DET_INT_RUTA;
CREATE SEQUENCE SEQ_INT_DET_INT_RUTA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_AERODROMO;
CREATE SEQUENCE SEQ_INT_AERODROMO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_PER_SITUACION_PROCESO;
CREATE SEQUENCE SEQ_PER_SITUACION_PROCESO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_DET_AERODROMO;
CREATE SEQUENCE SEQ_INT_DET_AERODROMO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_DET_ORGANIZACION;
CREATE SEQUENCE SEQ_INT_DET_ORGANIZACION INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_DET_GREMIO_COCALERO;
CREATE SEQUENCE SEQ_INT_DET_GREMIO_COCALERO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_INFORME;
CREATE SEQUENCE SEQ_INF_INFORME INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_TITULO_REGISTRAL;
CREATE SEQUENCE SEQ_INF_TITULO_REGISTRAL INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_DET_ZONA_CULTIVO;
CREATE SEQUENCE SEQ_INT_DET_ZONA_CULTIVO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_SEGUIMIENTO_NOT;
CREATE SEQUENCE SEQ_INF_SEGUIMIENTO_NOT INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_NOTIFICACION;
CREATE SEQUENCE SEQ_INF_NOTIFICACION INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_AGENDA;
CREATE SEQUENCE SEQ_INF_AGENDA INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_EXP_AGENDA_ACTORES;
CREATE SEQUENCE SEQ_EXP_AGENDA_ACTORES INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INT_ZONA_CULTIVO;
CREATE SEQUENCE SEQ_INT_ZONA_CULTIVO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

DROP SEQUENCE SEQ_INF_ORG_EXHORTO;
CREATE SEQUENCE SEQ_INF_ORG_EXHORTO INCREMENT BY 1 START WITH 1 MAXVALUE 999999999 MINVALUE 1 NOCACHE;

quit;