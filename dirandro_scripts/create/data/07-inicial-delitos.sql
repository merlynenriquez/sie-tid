-- Tabla de Delitos segun el Codigo Procesal Penal --

--Tabla de Padres
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (1, null, 'DELITOS CONTRA LA VIDA EL CUERPO Y LA SALUD', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (2, null, 'DELITOS CONTRA EL HONOR', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (3, null, 'DELITO CONTRA LA FAMILIA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (4, null, 'DELITOS CONTRA LA LIBERTAD', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (5, null, 'DELITOS CONTRA EL PATRIMONIO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (6, null, 'DELITOS CONTRA LA CONFIANZA Y LA BUENA FE EN LOS NEGOCIOS', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (7, null, 'DELITOS CONTRA LOS DERECHOS INTELECTUALES', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (8, null, 'DELITOS CONTRA EL PATRIMONIO CULTURAL', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (9, null, 'DELITOS CONTRA EL ORDEN ECON�MICO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (10, null, 'DELITOS CONTRA EL ORDEN FINANCIERO Y MONETARIO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (11, null, 'DELITOS TRIBUTARIOS', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (12, null, 'DELITOS CONTRA LA SEGURIDAD P�BLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (13, null, 'DELITOS AMBIENTALES', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (14, null, 'DELITOS CONTRA LA TRANQUILIDAD P�BLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (15, null, 'DELITOS CONTRA LA HUMANIDAD', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (16, null, 'DELITOS CONTRA EL ESTADO Y LA DEFENSA NACIONAL', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (17, null, 'DELITOS CONTRA LOS PODERES DEL ESTADO Y EL ORDEN CONSTITUCIONAL', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (18, null, 'DELITOS CONTRA LA VOLUNTAD POPULAR', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (19, null, 'DELITOS CONTRA LA ADMINISTRACI�N P�BLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (20, null, 'DELITOS CONTRA LA FE P�BLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (21, null, 'DESAPARECIDOS', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (22, null, 'FALTAS', 1,155, 1,SYSDATE);

INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (23, 1, 'HOMICIDIO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (24, 1, 'ABORTO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (25, 1, 'LESIONES', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (26, 1, 'EXPOSICI�N A PELIGRO O ABANDONO DE PERSONAS EN PELIGRO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (27, 23, 'HOMICIDIO SIMPLE', 1,155, 1,SYSDATE,  'Art�culo 106.- Homicidio Simple 
El que mata a otro ser� reprimido con pena privativa de libertad no menor de seis ni mayor de 
veinte a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (28, 23, 'PARRICIDIO', 1,155, 1,SYSDATE,  'Art�culo 107.- Parricidio 
El que, a sabiendas, mata a su ascendiente, descendiente, natural o adoptivo, o a su c�nyuge o concubino, ser� reprimido con pena privativa de libertad no menor de quince a�os.
Art�culo 108.- Homicidio calificado. Asesinato
Ser� reprimido con pena privativa de libertad no menor de quince a�os, el que mata a otro concurriendo cualquiera de las circunstancias siguientes:
1. Por ferocidad o por lucro.
2. Para facilitar u ocultar otro delito.
3. Con gran crueldad, alevos�a o veneno.
4. Por fuego, explosi�n u otro medio capaz de poner en peligro la vida o salud de otras personas.(*)
(*) Art�culo modificado por el Art�culo 1 del Decreto Legislativo N� 896, publicado el 24-05-98, expedido con arreglo a la Ley N� 26950, que otorga al Poder Ejecutivo facultades para legislar en materia de seguridad nacional, cuyo texto es el siguiente:
 Homicidio Calificado - Asesinato
Art�culo 108.- Ser� reprimido con pena privativa de libertad no menor de veinticinco a�os el que mate a otro concurriendo cualquiera de las circunstancias siguientes:
1.- Por ferocidad, por lucro o por placer;
2.- Para facilitar u ocultar otro delito;
3.- Con gran crueldad o alevos�a;
4.- Por fuego, explosi�n, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas.  (*)
(1) Art�culo modificado por el Art�culo 1 de la Ley N� 27472, publicada el 05-06-2001, cuyo texto es el siguiente:  Art�culo 108.- Homicidio calificado. Asesinato
 
Ser� reprimido con pena privativa de libertad no menor de quince a�os el que mata a otro concurriendo cualquiera de las circunstancias siguientes:
Por ferocidad, por lucro o por placer;
Para facilitar u ocultar otro delito;
Con gran crueldad o alevos�a;
Por fuego, explosi�n, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas.  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (29, 23, 'ASESINATO', 1,155, 1,SYSDATE,  'Art�culo 108.- Homicidio Calificado - Asesinato 
Ser� reprimido con pena privativa de libertad no menor de quince a�os el que mate a otro concurriendo cualquiera de las circunstancias siguientes:
1. Por ferocidad, por lucro o por placer;
2. Para facilitar u ocultar otro delito;
3. Con gran crueldad o alevos�a;
4. Por fuego, explosi�n, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas;
5. Si la v�ctima es miembro de la Polic�a Nacional del Per� o de las Fuerzas Armadas, Magistrado del Poder Judicial o del Ministerio P�blico, en el cumplimiento de sus funciones.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (30, 23, 'HOMICIDIO POR EMOCI�N VIOLENTA', 1,155, 1,SYSDATE,  'Art�culo 109.- Homicidio por emoci�n violenta 
El que mata a otro bajo el imperio de una emoci�n violenta que las circunstancias hacen excusable, ser� reprimido con pena privativa de libertad, no menor de tres ni mayor de cinco a�os.
Si concurre algunas de las circunstancias previstas en el art�culo 107, la pena ser� no menor de cinco ni mayor de diez a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (31, 23, 'INFANTICIDIO', 1,155, 1,SYSDATE,  'Art�culo 110.- Infanticidio 
La madre que mata a su hijo durante el parto o bajo la influencia del estado puerperal, ser� reprimida con pena privativa de libertad no menor de uno ni mayor de cuatro a�os, o con prestaci�n de servicio comunitario de cincuentid�s a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (32, 23, 'HOMICIDIO CULPOSO', 1,155, 1,SYSDATE,  'Art�culo 111.- Homicidio Culposo 
El que, por culpa, ocasiona la muerte de una persona, ser� reprimido con pena privativa de libertad no mayor de dos a�os o con prestaci�n de servicios comunitarios de cincuenta y dos a ciento cuatro jornadas.
La pena privativa de la libertad ser� no menor de cuatro a�os ni mayor de ocho a�os e inhabilitaci�n, seg�n corresponda, conforme al Art�culo 36 incisos 4), 6) y 7), cuando el agente haya estado conduciendo un veh�culo motorizado bajo el efecto de estupefacientes o en estado de ebriedad, con presencia de alcohol en la sangre en proporci�n mayor de 0.5 gramos-litro, o
cuando sean varias las v�ctimas del mismo hecho o el delito resulte de la inobservancia de reglas t�cnicas de tr�nsito. (*)
(*) P�rrafo modificado por el Art�culo 1 de la Ley N� 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad ser� no menor de un a�o ni mayor de cuatro a�os si el delito resulta de la inobservancia de reglas de profesi�n, de ocupaci�n o industria y no menor de un a�o ni mayor de seis a�os cuando sean varias las v�ctimas del mismo hecho. 
La pena ser� no mayor de cuatro a�os si el delito resulta de la inobservancia de reglas de profesi�n, de ocupaci�n o industria y cuando sean varias las v�ctimas del mismo hecho, la pena ser� no mayor de seis a�os.  (*)
(*) P�rrafo modificado por el Art�culo 1 de la Ley N� 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad ser� no menor de cuatro a�os ni mayor de ocho a�os e inhabilitaci�n, seg�n corresponda, conforme al art�culo 36 -incisos 4), 6) y 7)-, si la muerte se comete utilizando veh�culo motorizado o arma de fuego, estando el agente bajo el efecto de drogas t�xicas, estupefacientes, sustancias psicotr�picas o sint�ticas, o con presencia de alcohol en la sangre en proporci�n mayor de 0.5 gramos-litro, en el caso de transporte particular, o mayor de 0.25 gramoslitro en el caso de transporte p�blico de pasajeros, mercanc�as o carga en general, o cuando el delito resulte de la inobservancia de reglas t�cnicas de tr�nsito. 
CONCORDANCIAS: Ley N� 27753, Art. 3, 4 y Anexo');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (33, 23, 'HOMICIDIO PIADOSO', 1,155, 1,SYSDATE,  'Art�culo 112.- Homicidio piadoso 
El que, por piedad, mata a un enfermo incurable que le solicita de manera expresa y consciente para poner fin a sus intolerables dolores, ser� reprimido con pena privativa de libertad no mayor de tres a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (34, 23, 'INSTIGACI�N O AYUDA AL SUICIDIO', 1,155, 1,SYSDATE,  'Art�culo 113.- Instigaci�n o ayuda al suicidio 
El que instiga a otro al suicidio o lo ayuda a cometerlo, ser� reprimido, si el suicidio se ha consumado o intentado, con pena privativa de libertad no menor de uno ni mayor de cuatro a�os.
La pena ser� no menor de dos ni mayor de cinco a�os, si el agente actu� por un m�vil ego�sta.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (35, 24, 'AUTOABORTO', 1,155, 1,SYSDATE,  'Art�culo 114.- Autoaborto 
La mujer que causa su aborto, o consiente que otro le practique, ser� reprimida con pena privativa de libertad no mayor de dos a�os o con prestaci�n de servicio comunitario de cincuentid�s a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (36, 24, 'ABORTO CONSENTIDO', 1,155, 1,SYSDATE,  'Art�culo 115.- Aborto consentido 
El que causa el aborto con el consentimiento de la gestante, ser� reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro a�os.
Si sobreviene la muerte de la mujer y el agente pudo prever este resultado, la pena ser� no menor de dos ni mayor de cinco a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (37, 24, 'ABORTO NO CONSENTIDO', 1,155, 1,SYSDATE,  'Art�culo 116.- Aborto sin consentimiento 
El que hace abortar a una mujer sin su consentimiento, ser� reprimido con pena privativa de libertad no menor de tres ni mayor de cinco a�os.
Si sobreviene la muerte de la mujer y el agente pudo prever este resultado, la pena ser� no menor de cinco ni mayor de diez a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (38, 24, 'ABORTO AGRAVADO POR LA CUALIFICACI�N DEL SUJETO ACTIVO', 1,155, 1,SYSDATE,  'Art�culo 117.- Agravaci�n de la pena por la calidad del sujeto 
El m�dico, obstetra, farmac�utico, o cualquier profesional sanitario, que abusa de su ciencia o arte para causar el aborto, ser� reprimido con la pena de los art�culos 115 y 116 e inhabilitaci�n conforme al art�culo 36, incisos 4 y 8.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (39, 24, 'ABORTO PRETERINTENCIONAL', 1,155, 1,SYSDATE,  'Art�culo 118.- Aborto preterintencional 
El que, con violencia, ocasiona un aborto, sin haber tenido el prop�sito de causarlo, siendo notorio o const�ndole el embarazo, ser� reprimido con pena privativa de libertad no mayor de dos a�os, o con prestaci�n de servicio comunitario de cincuentid�s a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (40, 24, 'ABORTO TERAP�UTICO IMPUNE', 1,155, 1,SYSDATE,  'Art�culo 119.- Aborto terape�tico 
No es punible el aborto practicado por un m�dico con el consentimiento de la mujer embarazada o de su representante legal, si lo tuviere, cuando es el �nico medio para salvar la vida de la gestante o para evitar en su salud un mal grave y permanente.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (41, 24, 'ABORTO SENTIMENTAL Y EUGEN�SICO', 1,155, 1,SYSDATE,  'Art�culo 120.- Aborto sentimental y eugen�sico 
El aborto ser� reprimido con pena privativa de libertad no mayor de tres meses:
1.Cuando el embarazo sea consecuencia de violaci�n sexual fuera de matrimonio o inseminaci�n artificial no consentida y ocurrida fuera de matrimonio, siempre que los hechos hubieren sido denunciados o investigados, cuando menos policialmente; o
2. Cuando es probable que el ser en formaci�n conlleve al nacimiento graves taras f�sicas o ps�quicas, siempre que exista diagn�stico m�dico.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (42, 25, 'LESIONES GRAVES', 1,155, 1,SYSDATE,  'Art�culo 121.- Lesiones graves 
El que causa a otro da�o grave en el cuerpo o en la salud, ser� reprimido con pena privativa de libertad no menor de cuatro ni mayor de ocho a�os. Se consideran lesiones graves:
Las que ponen en peligro inminente la vida de la v�ctima.
Las que mutilan un miembro u �rgano principal del cuerpo o lo hacen impropio para su funci�n, causan a una persona incapacidad para el trabajo, invalidez o anomal�a ps�quica permanente o la desfiguran de manera grave y permanente.
Las que infieren cualquier otro da�o a la integridad corporal, o a la salud f�sica o mental de una persona que requiera treinta o m�s d�as de asistencia o descanso, seg�n prescripci�n facultativa.
Cuando la v�ctima muere a consecuencia de la lesi�n y si el agente pudo prever este resultado, la pena ser� no menor de cinco ni mayor de diez a�os.
Cuando la v�ctima es miembro de la Polic�a Nacional del Per� o de las Fuerzas Armadas, Magistrado del Poder Judicial o del Ministerio P�blico, en el cumplimiento de sus funciones, se aplicar� pena privativa de libertad no menor de cinco a�os ni mayor de doce a�os.  
CONCORDANCIAS: D.S. N� 016-2009-MTC, D�cima Primera Disp. Complem. y Trans. (TUO del Reglamento Nacional
de Tr�nsito - C�digo de Tr�nsito)
Formas agravadas. El menor como v�ctima
 Art�culo 121- A.- En los casos previstos en la primera parte del art�culo anterior, cuando la v�ctima sea menor de catorce a�os y el agente sea el padre, madre, tutor, guardador o responsable de aquel, la pena ser� privativa de libertad no menor de cinco ni mayor de diez a�os, suspensi�n de la patria potestad seg�n el literal b) del Art�culo 83 del C�digo de los Ni�os y Adolescentes e inhabilitaci�n a que se refiere el Art�culo 36 inciso 5.
 
Cuando la v�ctima muera a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de seis ni mayor de quince a�os.  (1)(2)
CONCORDANCIA: Ley N� 27337, Art. 75 (C�digo de los Ni�os y Adolescentes)
Art�culo incorporado por el Art�culo 1 de la Ley N� 26788, publicada el 16-05-97.
Art�culo modificado por el Art�culo 9 de la Ley N� 29282, publicada el 27 noviembre 2008, cuyo texto es el siguiente:
�Formas agravadas. El menor como v�ctima
Art�culo 121-A.- En los casos previstos en la primera parte del art�culo 121, cuando la v�ctima sea menor de catorce a�os y el agente sea el tutor, guardador o responsable de aquel, la pena ser� privativa de libertad no menor de cinco ni mayor de ocho a�os, remoci�n del cargo seg�n el numeral 2 del art�culo 554 del C�digo Civil e inhabilitaci�n a que se refiere el art�culo 36 inciso 5.
Art�culo 121.- Lesiones graves  Cuando la v�ctima muere a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de seis ni mayor de doce a�os.�
�Formas agravadas. Lesiones graves por violencia familiar
Art�culo 121-B.- El que causa a otro da�o grave en el cuerpo o en la salud por violencia familiar ser� reprimido con pena privativa de libertad no menor de cinco ni mayor de diez a�os y suspensi�n de la patria potestad seg�n el literal e) del art�culo 75 del C�digo de los Ni�os y Adolescentes.
Cuando la v�ctima muere a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de seis ni mayor de quince a�os.� (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (44, 25, 'LESIONES LEVES', 1,155, 1,SYSDATE,  'Art�culo 122.- Lesiones leves 
El que causa a otro un da�o en el cuerpo o en la salud que requiera m�s de diez y menos de treinta d�as de asistencia o descanso, seg�n prescripci�n facultativa, ser� reprimido con pena privativa de libertad no mayor de dos a�os y con sesenta a ciento cincuenta d�as-multa.
Cuando la v�ctima muere a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de tres ni mayor de seis a�os.
CONCORDANCIAS: D.S. N� 016-2009-MTC, D�cima Primera Disp. Complem. y Trans. (TUO del Reglamento Nacional
de Tr�nsito - C�digo de Tr�nsito)
Formas agravadas. El menor como v�ctima
 Art�culo 122 A.- En el caso previsto en la primera parte del art�culo anterior, cuando la v�ctima sea menor de catorce a�os y el agente sea el padre, madre, tutor, guardador o responsable de aquel, la pena ser� privativa de libertad no menor de tres ni mayor de seis a�os, suspensi�n de la patria potestad seg�n el literal b) del Art�culo 83 del C�digo de los Ni�os y Adolescentes e inhabilitaci�n a que se refiere el Art�culo 36 inciso 5.
 
Cuando la v�ctima muera a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de cuatro ni mayor de ocho a�os.  (1)(2)
CONCORDANCIA: Ley N� 27337, Art. 75 (C�digo de los Ni�os y Adolescentes)
(1) Art�culo incorporado por el Art�culo 1 de la Ley N� 26788, publicada el 16-05-97.
(2) Art�culo modificado por el Art�culo 11 de la Ley N� 29282, publicada el 27 noviembre 2008, cuyo texto es el siguiente:
�Formas agravadas. El menor como v�ctima
Art�culo 122-A.- En el caso previsto en la primera parte del art�culo 122, cuando la v�ctima sea menor de catorce a�os y el agente sea el tutor, guardador o responsable de aquel, la pena ser� privativa de libertad no menor de tres ni mayor de seis a�os, remoci�n del cargo seg�n el numeral 2 del art�culo 554 del C�digo Civil e inhabilitaci�n a que se refiere el art�culo 36 inciso 5.
Cuando la v�ctima muere a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de cinco ni mayor de nueve a�os.�
�Formas agravadas. Lesiones leves por violencia familiar
Art�culo 122-B.- El que causa a otro da�o en el cuerpo o en la salud por violencia familiar que requiera m�s de diez y menos de treinta d�as de asistencia o descanso, seg�n prescripci�n facultativa, ser� reprimido con pena privativa de libertad no menor de tres ni mayor de seis a�os y suspensi�n de la patria potestad seg�n el literal e) del art�culo 75 del C�digo de los Ni�os y Adolescentes.
Cuando la v�ctima muere a consecuencia de la lesi�n y el agente pudo prever este resultado, la pena ser� no menor de seis ni mayor de doce a�os.� (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (46, 25, 'LESIONES CON RESULTADO FORTUITO', 1,155, 1,SYSDATE,  'Art�culo 123.- Lesiones preterintencionales con resultado fortuito 
Cuando el agente produzca un resultado grave que no quiso causar, ni pudo prever, la pena ser� disminuida prudencialmente hasta la que corresponda a la lesi�n que quiso inferir.
Lesiones culposas
Art�culo 124.- El que, por culpa causa a otro un da�o en el cuerpo o en la salud, ser� reprimido, por acci�n privada, con pena privativa de libertad no mayor de un a�o, o con sesenta a ciento veinte d�as-multa.
La acci�n penal se promover� de oficio y la pena ser� privativa de libertad no menor de uno ni mayor de dos a�os y de sesenta a ciento veinte d�as-multa, si la lesi�n es grave.
El Juez podr� acumular la multa con la pena privativa de libertad. (*)
(*) Art�culo modificado por el Art�culo Unico de la Ley N� 27054, publicada el 23-01-99, cuyo texto es el siguiente: Lesiones culposas 
 Art�culo 124.- El que por culpa causa a otro un da�o en el cuerpo o en la salud, ser� reprimido, por acci�n privada, con pena privativa de libertad no mayor de un a�o y con sesenta a ciento veinte d�as-multa.
 
La acci�n penal se promover� de oficio y la pena ser� privativa de libertad no menor de uno ni mayor de dos a�os y de sesenta a ciento veinte d�as-multa, si la lesi�n es grave.
Cuando son varias las v�ctimas del mismo hecho o el delito resulte de la inobservancia de reglas t�cnicas, de profesi�n, de ocupaci�n o de industria, la pena privativa de libertad ser� no menor de dos ni mayor de cuatro a�os e inhabilitaci�n conforme al
Art�culo 36 incisos 4), 6) y 7).  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (47, 25, 'LESIONES CULPOSAS', 1,155, 1,SYSDATE,  'Art�culo 124.- Lesiones Culposas El que por culpa causa a otro un da�o en el cuerpo o en la salud, ser� reprimido, por acci�n privada, con pena privativa de libertad no mayor de un a�o y con sesenta a ciento veinte d�as-multa.
La acci�n penal se promover� de oficio y la pena ser� privativa de libertad no menor de uno ni mayor de dos a�os y de sesenta a ciento veinte d�as-multa, si la lesi�n es grave. (*)
(*) P�rrafo modificado por el Art�culo 1 de la Ley N� 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena ser� privativa de libertad no menor de uno ni mayor de dos a�os y de sesenta a ciento veinte d�as-multa, si la lesi�n es grave, de conformidad a los presupuestos establecidos en el art�culo 121.  
La pena privativa de la libertad ser� no menor de tres a�os ni mayor de cinco a�os e inhabilitaci�n, seg�n corresponda, conforme al Art�culo 36 incisos 4), 6) y 7), cuando el agente haya estado conduciendo un veh�culo motorizado bajo el efecto de estupefacientes o en estado de ebriedad, con presencia de alcohol en la sangre en proporci�n mayor de 0.5 gramos-litro, o
cuando sean varias las v�ctimas del mismo hecho o el delito resulte de la inobservancia de reglas t�cnicas de tr�nsito.(*)
(*) P�rrafo modificado por el Art�culo 1 de la Ley N� 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de libertad ser� no menor de uno ni mayor de tres a�os si el delito resulta de la inobservancia de reglas de profesi�n, ocupaci�n o industria y no menor de un a�o ni mayor de cuatro a�os cuando sean varias las v�ctimas del mismo hecho. 
La pena ser� no mayor de tres a�os si el delito resulta de la inobservancia de reglas de profesi�n, de ocupaci�n o industria y cuando sean varias las v�ctimas del mismo hecho, la pena ser� no mayor de cuatro a�os.  (*)
(*) P�rrafo modificado por el Art�culo 1 de la Ley N� 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad ser� no menor de cuatro a�os ni mayor de seis a�os e inhabilitaci�n, seg�n corresponda, conforme al art�culo 36 -incisos 4), 6) y 7)-, si la lesi�n se comete utilizando veh�culo motorizado o arma de fuego, estando el agente bajo el efecto de drogas t�xicas, estupefacientes, sustancias psicotr�picas o sint�ticas, o con presencia de alcohol en la sangre en proporci�n mayor de 0.5 gramos-litro, en el caso de transporte particular, o mayor de 0.25 gramoslitro en el caso de transporte p�blico de pasajeros, mercanc�as o carga en general, o cuando el delito resulte de la inobservancia de reglas t�cnicas de tr�nsito. 
CONCORDANCIA: Ley N� 27753, Art. 3, 4 y Anexo
Da�os al Concebido
 
 Art�culo 124-A.- El que causa da�o en el cuerpo o en la salud del concebido, ser� reprimido con pena privativa de la libertad no menor de un a�o ni mayor de tres  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (48, 26, 'EXPOSICI�N O ABANDONO A PERSONAS INCAPACES', 1,155, 1,SYSDATE,  'Art�culo 125.- Exposici�n o abandono peligrosos El que expone a peligro de muerte o de grave e inminente da�o a la salud o abandona en iguales circunstancias a un menor de edad o a una persona incapaz de valerse por s� misma que est�n legalmente bajo su protecci�n o que se hallen de hecho bajo su cuidado, ser� reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (49, 26, 'OMISI�N DE SOCORRO Y EXPOSICI�N AL PELIGRO', 1,155, 1,SYSDATE,  'Art�culo 126.- Omisi�n de socorro y exposici�n a peligro 
El que omite prestar socorro a una persona que ha herido o incapacitado, poniendo en peligro su vida o su salud, ser� reprimido con pena privativa de libertad no mayor de tres a�os.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (50, 26, 'OMISI�N DE AUXILIO A PERSONA EN PELIGRO O AVISO A LA AUTORIDAD', 1,155, 1,SYSDATE,  'Art�culo 127.- Omisi�n de auxilio o aviso a la autoridad 
El que encuentra a un herido o a cualquier otra persona en estado de grave e inminente peligro y omite prestarle auxilio inmediato pudiendo hacerlo sin riesgo propio o de tercero o se abstiene de dar aviso a la autoridad, ser� reprimido con pena privativa de libertad no mayor de un a�o o con treinta a ciento veinte d�as-multa.
Art�culo 128.- Exposici�n a peligro de persona dependiente
El que expone a peligro la vida o la salud de una persona colocada bajo su autoridad, dependencia, tutela, curatela o vigilancia, sea priv�ndola de alimentos o cuidados indispensables, sea someti�ndola a trabajos excesivos o inadecuados o abusando de los medios de correcci�n o disciplina, ser� reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro a�os.
Si resulta lesi�n grave o muerte y �stas pudieran ser previstas, la pena ser� no menor de tres ni mayor de seis a�os en caso de lesi�n grave y no menor de cuatro ni mayor de ocho a�os en caso de muerte. (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (51, 26, 'EXPOSICI�N A PELIGRO DE PERSONA DEPENDIENTE', 1,155, 1,SYSDATE,  'Art�culo 128.- Exposici�n a peligro de persona dependiente El que expone a peligro la vida o la salud de una persona colocada bajo su autoridad, dependencia, tutela, curatela o vigilancia, sea priv�ndola de alimentos o cuidados indispensables, sea someti�ndola a trabajos excesivos, inadecuados, sea abusando de los medios de correcci�n o disciplina, sea oblig�ndola o induci�ndola a mendigar en lugares p�blicos, ser� reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro a�os.
En los casos en que el agente tenga v�nculo de parentesco consangu�neo o la v�ctima fuere menor de doce a�os de edad, la pena ser� privativa de libertad no menor de dos ni mayor de cuatro a�os.
En los casos en que el agente obligue o induzca a mendigar a dos o m�s personas colocadas bajo su autoridad, dependencia, tutela, curatela o vigilancia, la pena privativa de libertad ser� no menor de dos ni mayor de cinco a�os.');



commit;
