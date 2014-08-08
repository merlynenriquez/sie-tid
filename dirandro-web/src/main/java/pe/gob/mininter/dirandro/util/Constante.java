package pe.gob.mininter.dirandro.util;

import com.vaadin.terminal.ThemeResource;

public abstract class Constante {

	public static abstract class SCHEMA {
		public static final String TID = "SIETID";
	}

	public static abstract class DESARROLLO {
		public static final String MODO = "0";
		public static final String CORREO = "info@mininter.gob.pe";
		public static final String CORREO_CLAVE = "*******";
	}
	
	public static abstract class SECUENCIA_TABLA {
		public static final String SEQ_EXPEDIENTE = "pe.gob.mininter.dirincri.model.Expediente";
		public static final String SEQ_DIVINHOM = "DIVINHOM";
		
	}
	
	public static abstract class OPERACION {
		public final static String CREAR_REGISTRO = "CREAR";
		public final static String ACTUALIZAR_REGISTRO = "ACTUALIZAR";
	}

	public static abstract class LISTA {
		public static abstract class CODIGO {
			public final static String MARCAS_TIPO = "MARCAS_TIPO";
			public final static String ESTADO = "REGISTRO_ESTADO";
			public final static String TIPO_OPCION = "OPCION_TIPO";
			public final static String MEMBRESIA_TIPO = "MEMBRESIA_TIPO";
			public final static String DOI_TIPO = "DOI_TIPO";
			public final static String TELEFONO_TIPO = "TELEFONO_TIPO";
			public final static String INTERPOS_CANAL = "INTERPOS_CANAL";
			public final static String ADJUNTO_TIPO = "ADJUNTO_TIPO";
			public final static String PRODUCTO_TIPO = "PRODUCTO_TIPO";
			public final static String PERSONA_ORIGEN = "PERSONA_ORIGEN";
			public final static String TIPO_REGLA = "REGLA_CATEGORIA";
			public final static String AGRUPACION_TIPO = "AGRUPACION_TIPO";
			public final static String TAREA_AMBITO = "TAREA_AMBITO";
			public final static String EVENTO = "EVENTO";
			public final static String EVENTO_TIPO = "EVENTO_TIPO";
			public final static String DICTAMEN = "DICTAMEN";
			public final static String FUNDAMENTO = "FUNDAMENTO";
			public final static String DICTAMEN_TIPO = "DICTAMEN_TIPO";
			public final static String OPERACION_FUENTE = "OPER_FUENTE";
			public final static String OPERACION_TIPO = "OPER_TIPO";
			public final static String MONEDA_TIPO = "MONEDA";
			public final static String PROCEDENCIA = "ENTIDAD_TIPO";
			public final static String PERSONA_TIPO = "DOCUMENTO_TIPO";
			public final static String PERSONA_ESTADO_CIVIL = "ESTADO_CIVIL";
			public final static String PERSONA_TIPO_PAISES = "PAISES";
			public final static String COD_PROCESAL = "CODIGO_PROCESAL";
			public final static String PARTICIPACION = "PARTICIPACION";
			public final static String SIT_INVOLUCRADO = "SITUACION_AUTOR";
			public final static String CARGO_TIPO = "CARGO_TIPO";
			public final static String GRADO_TIPO = "GRADO_TIPO";
			public final static String DROGA_TIPO = "DROGA_TIPO";
			public final static String PRIORIDAD = "PRIORIDAD_EXP";
			public final static String FINALIDAD = "FINALIDAD_EXP";
			public final static String DOCUMENTO_TIPO = "DOCUMENTO_EXP";
			public final static String TRANSMISION_TIPO = "TRANSMISION";
			public final static String CILINDRAJE_TIPO = "CILINDRAJE";
			public final static String VEHICULO_TIPO = "TIPO_VEHICULO";
			public final static String VEHICULO_SIT = "VEHICULO_SIT";
			public final static String ESTADO_GENERAL = "ESTADO_OBJETOS";
			public final static String AÑO_VEHICULO = "PERIODO";
			public final static String COLOR_VEHICULO = "COLORES";
			public final static String DIRECCION_TIPO = "TIPO_DIRECCION";
			public final static String CLASIF_ARMA = "ARMA_CLASIF";
			public final static String EST_SERIE = "SERIE_EST";
			public final static String CALIBRE_TIPO = "CALIBRE";
			public final static String FUNCION_TIPO = "TIPO_FUNCION";
			public final static String MEDIDA_TIPO = "TIPO_MEDIDA";
			public final static String ESPECIE_TIPO = "TIPO_ESPECIE";
			public final static String MEDIOS_TIPO = "TIPO_MEDIOS";
			public final static String MOVIL_TIPO = "TIPO_MOVIL";
			public final static String TABLA = "TABLAS";
			public final static String RUTA_PRIORIDAD = "PRIORIDAD_RUTA";
			public final static String ESTADO_ASIGNACION = "ASIGNACION_EST";
			public final static String PER_ORIENT_SEX = "ORIENT_SEX_PER";
			public final static String ESTADO_RUTA = "ESTADO_MOV_EXP";
			
		}
	}

	public static abstract class VALOR {
		
		public static abstract class CODIGO {
			public final static String ACTIVO = "A";
			public final static String INACTIVO = "I";
			
			public final static int ACTIVO_ID = 1;
			public final static int INACTIVO_ID = 2;
			
			public final static String PENDIENTE = "P";
			public final static String ATENDIDO = "A";

			public final static String MENU = "MEN";
			public final static String SUBMENU = "VEN";
			public final static String ACCION = "ACC";

			public final static String ENTIDAD = "ENTIDAD";
			public final static String DEPENDENCIA = "DEPENDENCIA";
			public final static String EQUIPO = "EQUIPO";

			public final static String REGLA_TRANSICION = "TRAN";
			public final static String REGLA_DERIVACION = "DERI";

			public final static String REGISTRO = "REG";
			public final static String CARGO = "CARG";

			public final static String DNI = "L";
			public final static String TELEFONO_CASA = "H";
			public final static String EMAIL = "MAIL";

			public final static String MIS_TAREAS = "INDI";
			public final static String TAREAS_EQUIPO_SUBORDINADOS = "GRUP";
			public final static String TODAS_TAREAS = "TODO";

			public final static String EVENTO_TIPO_TRANSICION = "TRANS";
			public final static String EVENTO_TIPO_DERIVACION = "DERIV";
			public final static String EVENTO_TIPO_SEGUIMIENTO = "SEGUI";

			public final static String EVENTO_GRABO_REGISTRAR = "GRA_REG";
			public final static String EVENTO_INICIO_COMPLETAR = "INI_COM";
			public final static String EVENTO_GRABO_COMPLETAR = "GRA_COM";
			public final static String EVENTO_INICIO_MODIFICAR = "INI_MOD";
			public final static String EVENTO_GRABO_MODIFICAR = "GRA_MOD";
			public final static String EVENTO_INICIO_ANALIZAR = "INI_ANA";
			public final static String EVENTO_GRABO_ANALIZAR = "GRA_ANA";

			public final static String OPER_FUENTE_ESTADO_CUENTA = "XEDC";
			public final static String OPER_FUENTE_CUENTA = "XCON";
			public final static String TIPO_ARMA = "ARMA";
			public final static String TIPO_VEHI = "VEHI";
			
			public final static String ATESTADO = "ATES";
			public final static String OFICIO = "OFIC";
			
			public final static String PERUANA = "PE";
						
			public final static String DIRECCION = "NIVEL_DIRE";
			public final static String DIVISION = "NIVEL_DIVI";
			public final static String DEPARTAMENTO = "NIVEL_DEPA";
			
			public final static String TIP_EQP = "EQP";
			public final static String TIP_GRP = "GRP";
			
			
			/*public final static String ENTIDAD = "ENTIDAD";
			public final static String DEPENDENCIA = "DEPENDENCIA";*/
			
		}

	}

	public static abstract class PARAMETRO {
		
		public final static String ESTADO_LOV = "LOV_ESTADO";
		public final static String HOSTNAME_SERV = "CORREO_SERVIDOR";
		public final static String PUERTO_SERV = "CORREO_PUERTO";
		public final static String ENV_CORREO = "CORREO_BUZON";
		public final static String PLANTILLAS_PATH = "PLANTILLAS_PATH";
		public final static String ADJUNTOS_PATH = "ADJUNTOS_PATH";
		public final static String ADJUNTOS_SIZE = "ADJUNTOS_SIZE";
		public final static String FECHA_ALERTA = "FECHA_ALERTA";
	}
	
	public static abstract class CODIGO_MENSAJE {
		
		public final static String ERROR_GENERICO = "error.generico";
		public final static String VALIDAR_ELIMINAR_GENERICO= "validar.eliminar.generico";
		
		public final static String VALIDAR_TEXTBOX = "validar.textbox";
		public final static String VALIDAR_COMBOBOX = "validar.combobox";
		public final static String VALIDAR_MAX_TAMANHO = "validar.textbox.maxtamanho";
		public final static String VALIDAR_PARAMETRO_EXISTENTE = "validar.parametro.existente";
		public final static String VALIDAR_TELEFONO_EXISTENTE = "validar.telefono.existente";
		public final static String VALIDAR_LISTA_EXISTENTE = "validar.lista.existente";
		public final static String VALIDAR_VALOR_EXISTENTE = "validar.valor.existente";
		public final static String VALIDAR_ROL_EXISTENTE = "validar.rol.existente";
		public final static String VALIDAR_ENTIDAD_EXISTENTE = "validar.entidad.existente";
		public final static String VALIDAR_ESPECIE_EXISTENTE = "validar.especie.existente";
		public final static String VALIDAR_ROL_PADRE_IGUAL = "validar.rol_padre.igual";
		public final static String VALIDAR_ROL_ES_PADRE = "validar.rol.es_padre";
		public final static String VALIDAR_MEMBRESIA_EXISTENTE = "validar.membresia.existente";
		public final static String VALIDAR_OPCION_EXISTENTE = "validar.opcion.existente";
		public final static String VALIDAR_OPCION_PADRE_IGUAL = "validar.opcion_padre.igual";
		public final static String VALIDAR_ADJUNTO = "validar.adjunto";
		public final static String VALIDAR_DESCARGA = "validar.descarga";
		public final static String VALIDAR_FOLDER_EXISTE = "validar.folder.existe";
		public final static String VALIDAR_DIRECCION_CORREO = "validar.direccion.correo";
		public final static String VALIDAR_REGLA = "validar.regla";
		public static final String VALIDAR_CODIGO_NO_ENCONTRADO = "validar.codigo_no_encontrado";
		public static final String ERROR_CARGAR_CLASES = "error.cargar_clase";
		public static final String ERROR_VALIDACION = "error.drools.validar";
		public static final String BLOQUEO_REQUERIMIENTO = "validar.req.bloqueo";
		public static final String ASIGNADO_REQUERIMIENTO = "validar.req.asignado";
		public static final String VALIDAR_TAXONIMIA = "validar.taxonomia";
		public final static String VALIDAR_INTEGRANTE_EXISTENTE = "validar.integrante.existe";
		public final static String VALIDAR_EQUIPO_LIDER = "validar.equipo.lider";
		public final static String VALIDAR_EQUIPO_ELIMINAR = "validar.equipo.eliminar";
		public final static String VALIDAR_REGLA_ELIMINAR = "validar.regla.dependencia";
		public final static String VALIDAR_REGISTRO_REPETIDO = "validar.registro.repetido";
		public final static String VALIDAR_REGISTRO_DEPENDENCIA = "validar.registro.dependencia";
		public final static String VALIDAR_REITERATIVO = "validar.req.reiterativo";
		public final static String VALIDAR_PERSONA_EXISTENTE = "validar.persona.existente";
		public final static String VALIDAR_ESTADO_EXISTENTE = "validar.estado.existente";
		public final static String VALIDAR_PREDECESOR_EXISTENTE = "validar.predecesor.existente";
		public static final String VALIDAR_RUC_DUPLICADO = "validar.ruc_duplicado";
		public static final String VALIDAR_LOGIN = "validar.login";
		public static final String VALIDAR_DEPENDENCIA = "validar.dependencia";
		
	}

	public static abstract class SESION {
		public final static String USUARIO = "SESION_USUARIO";
		public final static String USUARIO_ADMIN_ROL = "ADMIN";
	}

	public static abstract class OPCION {

		public final static String KEY_PADRE = "padre";

		// Menu Nro 1 (Mantenimientos)
		public final static String CODIGO_MNT_DELITO = "MANT_DELITO";
		public final static String CODIGO_ADMIN_PARM = "ADMIN_PARM";
		
		public final static String CODIGO_ADMIN_ROL_MEMB = "ADMIN_ROL_MEMB";
		public final static String CODIGO_ADMIN_OPCION = "ADMIN_OPCION";
		public final static String CODIGO_ADMIN_PERM = "ADMIN_PERM";
		public final static String CODIGO_CORREO = "COD_CORREO";// FIXME
		public final static String CODIGO_ORG_EQUIPO = "ORG_EQUIPO";
		public final static String CODIGO_SEG_OPCION = "SEG_OPCION";
		public final static String CODIGO_CFG_REGLA = "CFG_REGLA";
		public final static String CODIGO_ESTADO_EXP = "ESTADO_EXP";
		public final static String CODIGO_CFG_EMPRESA = "CFG_EMPRESA";
		public final static String CODIGO_EXP_DELITO = "EXP_DELITO";
		public final static String CODIGO_CFG_ENTIDAD = "CFG_ENTIDAD";
		public final static String CODIGO_ADMIN_PERSONA = "ADMIN_PERSONA";
		public final static String CODIGO_EXP_BANDA = "EXP_BANDA";
		public final static String CODIGO_EXP_INMUEBLE = "EXP_INMUEBLE";
		public final static String CODIGO_EXP_ARMA = "EXP_ARMA";
		public final static String CODIGO_EXP_TELEFONO = "EXP_TELEFONO";
		public final static String CODIGO_ADMIN_DROGA = "ADMIN_DROGA";
		public final static String CODIGO_ADMIN_MARCA = "ADMIN_MARCA";
		public final static String CODIGO_ADMIN_USUARIO = "ADMIN_USUARIO";
		public final static String CODIGO_ADMIN_DEPENDENCIA = "ADMIN_DEPENDEN";
		public final static String CODIGO_ADMIN_POLICIA = "ADMIN_POLICIA";
		public final static String CODIGO_ADMIN_VEHICULO = "ADMIN_VEHICULO";

		// Menu Nro 2
		public final static String CODIGO_EXP_REG = "EXP_REG";
		public final static String CODIGO_EXP_BND = "EXP_BND";

		// Menu Nro 3
		public final static String CODIGO_BSQ_PERSONA = "BSQ_PERSONA";
		
		// Menu Nro 5
		public final static String CODIGO_CFG_LOV = "CFG_LISTA";

		// Opciones de Acciones
		public static abstract class ACCION {
			public static final String REGISTRA_REQUERIMIENTO = "REQ_REG_GRABAR";
		}
	}

	public static abstract class UBIGEO {
		public final static Long ID_DISTRITO_DEFECTO = 1350L;
	}

	public static abstract class RENIEC {
		public static final int TTL = 0;
		public static final int LONG_CABECERA = 128;
		public static final int LONG_SUB_TRAMA_CONSULTA = 15;
		public static final String FRAGMENTACION = "                      ";
		public static final String RESERVADO_CHAR5 = "     ";
		public static final String RESERVADO_CHAR10 = "          ";
		public static final String CARACTER_VERIFICACION = " ";
		public static final String TIPO_SERVICIO = "000";
		public static final String TIPO_CONSULTA = "7";
		public static final String TIPO_DOCUMENTO = " ";
		public static final String VERSION = "0001";
		public static final String CARACTERES_VERIFICACION = "RENIECPERURENIEC";
		public static final String COD_INST_SOLICITANTE = "LD2019"; 
		public static final String COD_SERVIDOR_RENIEC = "RENIEC001";
		public static final String HOST_INST_SOLICITANTE = "BBVA";
		// public static final String FORMATO_FIRMA = "1"; //1:Imagen JPG,
		// default(Espacion en blanco): TIF
		public static final String EXITO = "0000";
		public static final String NO_EXISTE = "5200";

		public static final String HTTP_PROXYSET = "http.proxySet";
		public static final String HTTP_PROXYHOST = "http.proxyHost";
		public static final String PROXYHOST = "proxyHost";

	}

	public static abstract class TIPOREQUERIMIENTO {
		
		public static abstract class CODIGO {
			public final static String RECLAMO = "REC";
			public final static String SOLICITUD = "SOL";
			public final static String QUEJA = "QUE";
		}
	}

	public static abstract class TIPOPRODUCTO {
		public final static String ES_PRODUCTO = "Producto";
		public final static String ES_SERVICIO = "Servicio";
	}

	public static abstract class ESTADO_EXPEDIENTE {
		public static abstract class CODIGO {
			public final static Long REGISTRADO = 1L;
			public final static String TERMINADO = "TER";
			public final static String POR_CONF_ENT = "X_CON_ENT";
		}
	}

	public static abstract class ENTIDAD {
		public static abstract class CODIGO {
			public final static Long COMISARIA = 35L;
		}
	}
	public static abstract class SEGMENTO {
		public static abstract class CODIGO {
			public final static String NO_PERSONALIZADO = "NP";
		}
	}

	public static abstract class EQUIPO {
		public static final String ASIGNACION_MANUAL = "MAN";
		public static final String ASIGNACION_BALANCEO = "BAL";
		public static final String AMBITO_TAREA_TODOS = "TODO";
		public static final String AMBITO_MIA_EQUIPOS = "GRUP";
		public static final String CASO_A = "A";
		public static final String CASO_B = "B";
	}

	public static abstract class BITACORA {
		public static final int MAX_LENGHT_COMENTARIO = 500;
	}

	public static abstract class MODO_REQUERIMIENTO {
		public final static String VER = "VER";
		public final static String COMPLETAR = "COMPLETAR";
		public final static String ANALIZAR = "ANALIZAR";
		public final static String MODIFICAR = "MODIFICAR";
	}

	public static abstract class ICONOS {
		public static final ThemeResource DELETE = new ThemeResource("img/delete.png");
		public static final ThemeResource DELETE_FILE = new ThemeResource("img/deleteFile.png");
		public static final ThemeResource SAVE = new ThemeResource("img/save.png");
		public static final ThemeResource ADD = new ThemeResource("img/add.png");
		public static final ThemeResource ADD_FILE = new ThemeResource("img/add-folder.png");
		public static final ThemeResource SELECT = new ThemeResource("img/success.png");
		public static final ThemeResource SEARCH = new ThemeResource("img/search.png");
		public static final ThemeResource SEND = new ThemeResource("img/send.png");
		public static final ThemeResource RECEIVE = new ThemeResource("img/receive.png");
		public static final ThemeResource COPY = new ThemeResource("img/copy.png");
		public static final ThemeResource RELOAD = new ThemeResource("img/reload.png");
		
		public static final ThemeResource DELITO = new ThemeResource("img/delito.png");
		public static final ThemeResource INVOLUCRADO = new ThemeResource("img/involucrado.png");
		public static final ThemeResource MONTO = new ThemeResource("img/monto.png");
		public static final ThemeResource DROGA = new ThemeResource("img/droga.png");
		public static final ThemeResource ARMA = new ThemeResource("img/arma.png");
		public static final ThemeResource VEHICULO = new ThemeResource("img/vehiculo.png");
		public static final ThemeResource PERITAJE = new ThemeResource("img/peritaje.png");
		public static final ThemeResource ESPECIE = new ThemeResource("img/especie.png");
		public static final ThemeResource ADJUNTO = new ThemeResource("img/adjunto.png");
	}
	
	public static abstract class EXCEPTION {
		public final static String FOREING_KEY = "ORA-02292";
	}

	public static final String NUEVA_LINEA = System.getProperty("line.separator");

}
