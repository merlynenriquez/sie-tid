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
		public final static String CREAR_REGISTRO = "creado";
		public final static String ACTUALIZAR_REGISTRO = "actualizado";
	}

	public static abstract class LISTA {
		public static abstract class CODIGO {
			public final static String MARCAS_TIPO = "MARCAS_TIPO";
			public final static String DOCUMENTO_TIPO = "DOCUMENTO_TIPO";
			public final static String ESTADO = "REGISTRO_ESTADO";
			public final static String OPCION_TIPO = "OPCION_TIPO";
			public final static String TELEFONO_TIPO = "TELEFONO_TIPO";
			public final static String ADJUNTO_TIPO = "ADJUNTO_TIPO";
			public final static String MONEDA = "MONEDA";
			public final static String TABLAS = "TABLAS";
			public final static String ENTIDAD_TIPO = "ENTIDAD_TIPO";
			public final static String SIGLAS_DOC = "SIGLAS_DOC";
			public final static String ESTADO_CIVIL = "ESTADO_CIVIL";
			public final static String TIPO_CEJA = "TIPO_CEJA";
			public final static String TIPO_OREJA = "TIPO_OREJA";
			public final static String COLOR_PIEL = "COLOR_PIEL";
			public final static String CONTEXTURA = "CONTEXTURA";
			public final static String TIPO_CABELLO = "TIPO_CABELLO";
			public final static String TIPO_RAZA = "TIPO_RAZA";
			public final static String COLOR_CABELLO = "COLOR_CABELLO";
			public final static String CORTE_CABELLO = "CORTE_CABELLO";
			public final static String TIPO_OJO = "TIPO_OJO";
			public final static String COLOR_OJO = "COLOR_OJO";
			public final static String TIPO_NARIZ = "TIPO_NARIZ";
			public final static String FORMA_CARA = "FORMA_CARA";
			public final static String TIPO_LABIO = "TIPO_LABIO";
			public final static String FORMA_BOCA = "FORMA_BOCA";
			public final static String PROFESION = "PROFESION";
			public final static String PARENTESCO = "PARENTESCO";
			public final static String GRADO = "GRADO";
			public final static String CARGO = "CARGO";
			public final static String TIPO_LETRADO = "TIPO_LETRADO";
			public static final String PRIORIDAD = "PRIORIDAD";
			public static final String FINALIDAD = "FINALIDAD";
			public static final String CUENCA = "CUENCA";
			public static final String TIPO_INTERVINIENTE = "TIPO_INTER";
			public static final String DIRECCION_TIPO = "DIRECCION_TIPO";
			public static final String TIPO_HECHO = "TIPO_HECHO";
			//public static final String TIPO_AGRUPACION = "AGRUPACION_TIPO";
			public static final String TIPO_FUNCION = "TIPO_FUNCION";
			public static final String COD_PROCESAL = "CODIGO_PROCESAL";
			public static final String CENTRO_POBLADO_CATEGORIA = "CP_CATEGORIA";
			public static final String CENTRO_POBLADO_ESTADO = "CP_ESTADO";
			public static final String TIPO_CALIBRE = "TIPO_CALIBRE";
			public static final String TIPO_INSTALACION = "TP_INSTALACION";
			public static final String SITUACION_GENERAL = "SITUACION_GRL";
			public static final String PRIORIDAD_DELITO = "PRIORIDAD_DEL";
			public static final String TIPO_VEHICULO = "TIPO_VEHICULO";
			public static final String TRANSMISION = "TRANSMISION";
			public static final String CILINDRAJE = "CILINDRAJE";
			public static final String COLOR = "COLORES";
			public static final String PERIODO = "PERIODOS";
			public static final String TIPO_DROGA = "TIPO_DROGA";
			public static final String ESTADO_OBJETOS = "ESTADO_OBJETOS";
			public static final String OPERADORA = "OPERADORA";
			public static final String TIPO_PARTICIPAC = "TIPO_PARTICIPAC";
			public static final String TIPO_EST_DATO = "TIPO_EST_DATO";	
			public static final String SIT_PROCESADO = "SIT_PROCESADO";	
			public static final String OCUP_INTERV = "OCUP_INTERV";
			public static final String ORIENTACION_SEXUAL = "ORIENT_SEX_PER";
			public static final String ARMA_ESTADO_SERIE = "ARMA_EST_SERIE";			
			public static final String TIPO_HR = "TIPO_HR";
			public static final String FRECUENCIA = "FRECUENCIA";
			public static final String BANCO = "BANCOS";
			public static final String TIPO_CUENTA = "TIPO_CUENTA";
			public static final String TIPO_DOC_EXP = "DOCUMENTO_EXP";
			public static final String MODALIDAD_DROGA = "MODALIDAD_DRG";
			public static final String TRANSPORTE_DROGA = "TRANSPORTE_DRG";
			public static final String ESTADO_PARTICIPACION = "ESTADO_PARTIC";
			public static final String PARTICIPACION = "PARTICIPACION";
			
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

			public final static String ENTIDAD = "ENTI";
			public final static String DEPENDENCIA = "DEPE";
			public final static String PERSONA = "PERS";
			public final static String EMPRESA = "EMPR";

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
			
			public final static String COMI = "COMI";
			public static final String RUC = "R";
			
			public final static String ABO = "ABO";
			
			public final static String HR_1 = "TP_HR01";
			public final static String HR_2 = "TP_HR01";
		}

	}

	public static abstract class MODELO_MARCA{

		public static class ARMAS{
			public final static Long TIPOS = 2l;
		}
		
		public static class MEDIDA{
			public final static Long COD_MEDIDA = 3L;
		}

		public static class TRANSPORTE{
			public final static Long AUTO = 8l;
			public final static Long MOTOCICLETA = 9l;
		}
		
		public static class MUNICIONES{
			public final static Long AUTO = 5l;
			public final static Long PRESENTACIONES = 4004l;
		}
		
		public static class EXPLOSIVOS{
			public final static Long TIPOS = 6l;
			public final static Long PRESENTACIONES = 4004l;
		}
		
		public static class DROGAS{
			public final static Long TIPOS = 7l;
		}
		
		public static class COMUNICACIONES{
			public final static Long COD_COMUNICACION = 4l;
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
		public final static String PATH_WINDOW = "PATH_WINDOW";
		public static final String PATH_DOCUMENTO = "PATH_DOCUMENTO";
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
		public static final String VALIDAR_BUCLE_PADRE = "validar.bucle.padre";
		
		public final static String VALIDAR_PARAMETRO_EXISTENTE_CODIGO = "validar.parametro.existente.codigo";
		public final static String VALIDAR_PARAMETRO_EXISTENTE_NOMBRE = "validar.parametro.existente.nombre";
		
		/**
		 * @@author mhurtado
		 */
		public static final String VALIDAR_VEHICULO_EXISTENTE= "validar.vehiculo.existente";
		public static final String VALIDAR_INMUEBLE_EXISTENTE= "validar.inmueble.existente";
		
		public static final String VALIDAR_CARGA_ARCHIVO= "validar.cargar.documento";
		
	}

	public static abstract class SESION {
		public final static String USUARIO = "SESION_USUARIO";
		public final static String USUARIO_ADMIN_ROL = "ADMIN";
	}

	public static abstract class OPCION {

		public final static String KEY_PADRE = "padre";

		public final static String CODIGO_SEG_CLAVE = "SEG_CLAVE";
		// Menu Nro 1 (Mantenimientos)
		public final static String CODIGO_MNT_DELITO = "MANT_DELITO";
		public final static String CODIGO_MNT_EMPRESA = "MANT_EMPRESA";
		public final static String CODIGO_MNT_LETRADO = "MANT_LETRADO";
		public final static String CODIGO_MNT_HECHOS = "MANT_HECHOS";
		public final static String CODIGO_MNT_DEPENDEN = "MANT_DEPENDEN";
		public final static String CODIGO_MNT_POBLADO = "MANT_POBLADO";
		public final static String CODIGO_MNT_ESPECIE = "MANT_ESPECIE";
		public final static String CODIGO_MNT_ESTADO = "MANT_ESTADO";
		public final static String CODIGO_MNT_PAIS = "MANT_PAIS";
		public final static String CODIGO_MNT_MODELO = "MANT_MODELO";
		public final static String CODIGO_MNT_ENTIDAD = "MANT_ENTIDAD";
		public final static String CODIGO_MNT_POLICIA = "MANT_POLICIA";
		public final static String CODIGO_MNT_PERSONA = "MANT_PERSONA";
		
		// Menu Nro 2 (Registro Principal)
		public final static String CODIGO_EXP_REG_PP = "EXP_REG_PP";
		public final static String CODIGO_EXP_REG_HR = "EXP_REG_HR";
		public static final String CODIGO_EXP_BAN_PP = "EXP_BAN_PP";
		public static final String CODIGO_EXP_BAN_HR = "EXP_BAN_HR";

		// Menu Nro 3 (Busqueda de Tablas)
		public final static String CODIGO_BSQ_VEHICULO = "BSQ_VEHICULO";
		public final static String CODIGO_BSQ_INMUEBLE = "BSQ_INMUEBLE";
		public final static String CODIGO_BSQ_PERSONA = "BSQ_PERSONA";
		public final static String CODIGO_BSQ_TELEFONO = "BSQ_TELEFONO";
		public final static String CODIGO_BSQ_ARMA = "BSQ_ARMA";
		public final static String CODIGO_BSQ_ORGANIZAC = "BSQ_ORGANIZAC";
		public final static String CODIGO_BSQ_NA = "BSQ_NA";
		public final static String CODIGO_BSQ_DOCUMENTO = "BSQ_DOCUMENTO";
		public final static String CODIGO_BSQ_HOJADEREMISION = "BSQ_HR";
				
		// Menu Nro 4 (Seguridad de Usuarios)
		public final static String CODIGO_SEG_USUARIO = "SEG_USUARIO";
		public final static String CODIGO_SEG_PERMISO = "SEG_PERMISO";
		public final static String CODIGO_SEG_OPCION = "SEG_OPCION";
		public final static String CODIGO_SEG_EQUIPO = "SEG_EQUIPO";
		public final static String CODIGO_SEG_ROL = "SEG_ROL";
				
		// Menu Nro 5 (Configuracion)
		public final static String CODIGO_CFG_LOV = "CFG_LISTA";
		public final static String CODIGO_CFG_PARAMETRO = "CFG_PARAM";
		
		// Menu Nro 6 (Configuracion)
		public final static String CODIGO_RPT_ATESTADO = "RPT_ATESTADO";
		
		// Opciones de Acciones de los Botones
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
		public static final ThemeResource CREATE = new ThemeResource("img/create.png");
		
		public static final ThemeResource PASSWORD = new ThemeResource("img/password.png");
		public static final ThemeResource LOGOUT = new ThemeResource("img/logout.png");
		
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
