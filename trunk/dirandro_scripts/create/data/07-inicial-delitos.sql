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
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (9, null, 'DELITOS CONTRA EL ORDEN ECONÓMICO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (10, null, 'DELITOS CONTRA EL ORDEN FINANCIERO Y MONETARIO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (11, null, 'DELITOS TRIBUTARIOS', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (12, null, 'DELITOS CONTRA LA SEGURIDAD PÚBLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (13, null, 'DELITOS AMBIENTALES', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (14, null, 'DELITOS CONTRA LA TRANQUILIDAD PÚBLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (15, null, 'DELITOS CONTRA LA HUMANIDAD', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (16, null, 'DELITOS CONTRA EL ESTADO Y LA DEFENSA NACIONAL', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (17, null, 'DELITOS CONTRA LOS PODERES DEL ESTADO Y EL ORDEN CONSTITUCIONAL', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (18, null, 'DELITOS CONTRA LA VOLUNTAD POPULAR', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (19, null, 'DELITOS CONTRA LA ADMINISTRACIÓN PÚBLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (20, null, 'DELITOS CONTRA LA FE PÚBLICA', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (21, null, 'DESAPARECIDOS', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (22, null, 'FALTAS', 1,155, 1,SYSDATE);

INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (23, 1, 'HOMICIDIO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (24, 1, 'ABORTO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (25, 1, 'LESIONES', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION) VALUES (26, 1, 'EXPOSICIÓN A PELIGRO O ABANDONO DE PERSONAS EN PELIGRO', 1,155, 1,SYSDATE);
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (27, 23, 'HOMICIDIO SIMPLE', 1,155, 1,SYSDATE,  'Artículo 106.- Homicidio Simple 
El que mata a otro será reprimido con pena privativa de libertad no menor de seis ni mayor de 
veinte años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (28, 23, 'PARRICIDIO', 1,155, 1,SYSDATE,  'Artículo 107.- Parricidio 
El que, a sabiendas, mata a su ascendiente, descendiente, natural o adoptivo, o a su cónyuge o concubino, será reprimido con pena privativa de libertad no menor de quince años.
Artículo 108.- Homicidio calificado. Asesinato
Será reprimido con pena privativa de libertad no menor de quince años, el que mata a otro concurriendo cualquiera de las circunstancias siguientes:
1. Por ferocidad o por lucro.
2. Para facilitar u ocultar otro delito.
3. Con gran crueldad, alevosía o veneno.
4. Por fuego, explosión u otro medio capaz de poner en peligro la vida o salud de otras personas.(*)
(*) Artículo modificado por el Artículo 1 del Decreto Legislativo N° 896, publicado el 24-05-98, expedido con arreglo a la Ley N° 26950, que otorga al Poder Ejecutivo facultades para legislar en materia de seguridad nacional, cuyo texto es el siguiente:
 Homicidio Calificado - Asesinato
Artículo 108.- Será reprimido con pena privativa de libertad no menor de veinticinco años el que mate a otro concurriendo cualquiera de las circunstancias siguientes:
1.- Por ferocidad, por lucro o por placer;
2.- Para facilitar u ocultar otro delito;
3.- Con gran crueldad o alevosía;
4.- Por fuego, explosión, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas.  (*)
(1) Artículo modificado por el Artículo 1 de la Ley Nº 27472, publicada el 05-06-2001, cuyo texto es el siguiente:  Artículo 108.- Homicidio calificado. Asesinato
 
Será reprimido con pena privativa de libertad no menor de quince años el que mata a otro concurriendo cualquiera de las circunstancias siguientes:
Por ferocidad, por lucro o por placer;
Para facilitar u ocultar otro delito;
Con gran crueldad o alevosía;
Por fuego, explosión, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas.  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (29, 23, 'ASESINATO', 1,155, 1,SYSDATE,  'Artículo 108.- Homicidio Calificado - Asesinato 
Será reprimido con pena privativa de libertad no menor de quince años el que mate a otro concurriendo cualquiera de las circunstancias siguientes:
1. Por ferocidad, por lucro o por placer;
2. Para facilitar u ocultar otro delito;
3. Con gran crueldad o alevosía;
4. Por fuego, explosión, veneno o por cualquier otro medio capaz de poner en peligro la vida o salud de otras personas;
5. Si la víctima es miembro de la Policía Nacional del Perú o de las Fuerzas Armadas, Magistrado del Poder Judicial o del Ministerio Público, en el cumplimiento de sus funciones.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (30, 23, 'HOMICIDIO POR EMOCIÓN VIOLENTA', 1,155, 1,SYSDATE,  'Artículo 109.- Homicidio por emoción violenta 
El que mata a otro bajo el imperio de una emoción violenta que las circunstancias hacen excusable, será reprimido con pena privativa de libertad, no menor de tres ni mayor de cinco años.
Si concurre algunas de las circunstancias previstas en el artículo 107, la pena será no menor de cinco ni mayor de diez años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (31, 23, 'INFANTICIDIO', 1,155, 1,SYSDATE,  'Artículo 110.- Infanticidio 
La madre que mata a su hijo durante el parto o bajo la influencia del estado puerperal, será reprimida con pena privativa de libertad no menor de uno ni mayor de cuatro años, o con prestación de servicio comunitario de cincuentidós a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (32, 23, 'HOMICIDIO CULPOSO', 1,155, 1,SYSDATE,  'Artículo 111.- Homicidio Culposo 
El que, por culpa, ocasiona la muerte de una persona, será reprimido con pena privativa de libertad no mayor de dos años o con prestación de servicios comunitarios de cincuenta y dos a ciento cuatro jornadas.
La pena privativa de la libertad será no menor de cuatro años ni mayor de ocho años e inhabilitación, según corresponda, conforme al Artículo 36 incisos 4), 6) y 7), cuando el agente haya estado conduciendo un vehículo motorizado bajo el efecto de estupefacientes o en estado de ebriedad, con presencia de alcohol en la sangre en proporción mayor de 0.5 gramos-litro, o
cuando sean varias las víctimas del mismo hecho o el delito resulte de la inobservancia de reglas técnicas de tránsito. (*)
(*) Párrafo modificado por el Artículo 1 de la Ley N° 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad será no menor de un año ni mayor de cuatro años si el delito resulta de la inobservancia de reglas de profesión, de ocupación o industria y no menor de un año ni mayor de seis años cuando sean varias las víctimas del mismo hecho. 
La pena será no mayor de cuatro años si el delito resulta de la inobservancia de reglas de profesión, de ocupación o industria y cuando sean varias las víctimas del mismo hecho, la pena será no mayor de seis años.  (*)
(*) Párrafo modificado por el Artículo 1 de la Ley N° 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad será no menor de cuatro años ni mayor de ocho años e inhabilitación, según corresponda, conforme al artículo 36 -incisos 4), 6) y 7)-, si la muerte se comete utilizando vehículo motorizado o arma de fuego, estando el agente bajo el efecto de drogas tóxicas, estupefacientes, sustancias psicotrópicas o sintéticas, o con presencia de alcohol en la sangre en proporción mayor de 0.5 gramos-litro, en el caso de transporte particular, o mayor de 0.25 gramoslitro en el caso de transporte público de pasajeros, mercancías o carga en general, o cuando el delito resulte de la inobservancia de reglas técnicas de tránsito. 
CONCORDANCIAS: Ley N° 27753, Art. 3, 4 y Anexo');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (33, 23, 'HOMICIDIO PIADOSO', 1,155, 1,SYSDATE,  'Artículo 112.- Homicidio piadoso 
El que, por piedad, mata a un enfermo incurable que le solicita de manera expresa y consciente para poner fin a sus intolerables dolores, será reprimido con pena privativa de libertad no mayor de tres años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (34, 23, 'INSTIGACIÓN O AYUDA AL SUICIDIO', 1,155, 1,SYSDATE,  'Artículo 113.- Instigación o ayuda al suicidio 
El que instiga a otro al suicidio o lo ayuda a cometerlo, será reprimido, si el suicidio se ha consumado o intentado, con pena privativa de libertad no menor de uno ni mayor de cuatro años.
La pena será no menor de dos ni mayor de cinco años, si el agente actuó por un móvil egoísta.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (35, 24, 'AUTOABORTO', 1,155, 1,SYSDATE,  'Artículo 114.- Autoaborto 
La mujer que causa su aborto, o consiente que otro le practique, será reprimida con pena privativa de libertad no mayor de dos años o con prestación de servicio comunitario de cincuentidós a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (36, 24, 'ABORTO CONSENTIDO', 1,155, 1,SYSDATE,  'Artículo 115.- Aborto consentido 
El que causa el aborto con el consentimiento de la gestante, será reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro años.
Si sobreviene la muerte de la mujer y el agente pudo prever este resultado, la pena será no menor de dos ni mayor de cinco años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (37, 24, 'ABORTO NO CONSENTIDO', 1,155, 1,SYSDATE,  'Artículo 116.- Aborto sin consentimiento 
El que hace abortar a una mujer sin su consentimiento, será reprimido con pena privativa de libertad no menor de tres ni mayor de cinco años.
Si sobreviene la muerte de la mujer y el agente pudo prever este resultado, la pena será no menor de cinco ni mayor de diez años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (38, 24, 'ABORTO AGRAVADO POR LA CUALIFICACIÓN DEL SUJETO ACTIVO', 1,155, 1,SYSDATE,  'Artículo 117.- Agravación de la pena por la calidad del sujeto 
El médico, obstetra, farmacéutico, o cualquier profesional sanitario, que abusa de su ciencia o arte para causar el aborto, será reprimido con la pena de los artículos 115 y 116 e inhabilitación conforme al artículo 36, incisos 4 y 8.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (39, 24, 'ABORTO PRETERINTENCIONAL', 1,155, 1,SYSDATE,  'Artículo 118.- Aborto preterintencional 
El que, con violencia, ocasiona un aborto, sin haber tenido el propósito de causarlo, siendo notorio o constándole el embarazo, será reprimido con pena privativa de libertad no mayor de dos años, o con prestación de servicio comunitario de cincuentidós a ciento cuatro jornadas.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (40, 24, 'ABORTO TERAPÉUTICO IMPUNE', 1,155, 1,SYSDATE,  'Artículo 119.- Aborto terapeútico 
No es punible el aborto practicado por un médico con el consentimiento de la mujer embarazada o de su representante legal, si lo tuviere, cuando es el único medio para salvar la vida de la gestante o para evitar en su salud un mal grave y permanente.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (41, 24, 'ABORTO SENTIMENTAL Y EUGENÉSICO', 1,155, 1,SYSDATE,  'Artículo 120.- Aborto sentimental y eugenésico 
El aborto será reprimido con pena privativa de libertad no mayor de tres meses:
1.Cuando el embarazo sea consecuencia de violación sexual fuera de matrimonio o inseminación artificial no consentida y ocurrida fuera de matrimonio, siempre que los hechos hubieren sido denunciados o investigados, cuando menos policialmente; o
2. Cuando es probable que el ser en formación conlleve al nacimiento graves taras físicas o psíquicas, siempre que exista diagnóstico médico.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (42, 25, 'LESIONES GRAVES', 1,155, 1,SYSDATE,  'Artículo 121.- Lesiones graves 
El que causa a otro daño grave en el cuerpo o en la salud, será reprimido con pena privativa de libertad no menor de cuatro ni mayor de ocho años. Se consideran lesiones graves:
Las que ponen en peligro inminente la vida de la víctima.
Las que mutilan un miembro u órgano principal del cuerpo o lo hacen impropio para su función, causan a una persona incapacidad para el trabajo, invalidez o anomalía psíquica permanente o la desfiguran de manera grave y permanente.
Las que infieren cualquier otro daño a la integridad corporal, o a la salud física o mental de una persona que requiera treinta o más días de asistencia o descanso, según prescripción facultativa.
Cuando la víctima muere a consecuencia de la lesión y si el agente pudo prever este resultado, la pena será no menor de cinco ni mayor de diez años.
Cuando la víctima es miembro de la Policía Nacional del Perú o de las Fuerzas Armadas, Magistrado del Poder Judicial o del Ministerio Público, en el cumplimiento de sus funciones, se aplicará pena privativa de libertad no menor de cinco años ni mayor de doce años.  
CONCORDANCIAS: D.S. Nº 016-2009-MTC, Décima Primera Disp. Complem. y Trans. (TUO del Reglamento Nacional
de Tránsito - Código de Tránsito)
Formas agravadas. El menor como víctima
 Artículo 121- A.- En los casos previstos en la primera parte del artículo anterior, cuando la víctima sea menor de catorce años y el agente sea el padre, madre, tutor, guardador o responsable de aquel, la pena será privativa de libertad no menor de cinco ni mayor de diez años, suspensión de la patria potestad según el literal b) del Artículo 83 del Código de los Niños y Adolescentes e inhabilitación a que se refiere el Artículo 36 inciso 5.
 
Cuando la víctima muera a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de seis ni mayor de quince años.  (1)(2)
CONCORDANCIA: Ley Nº 27337, Art. 75 (Código de los Niños y Adolescentes)
Artículo incorporado por el Artículo 1 de la Ley N° 26788, publicada el 16-05-97.
Artículo modificado por el Artículo 9 de la Ley N° 29282, publicada el 27 noviembre 2008, cuyo texto es el siguiente:
“Formas agravadas. El menor como víctima
Artículo 121-A.- En los casos previstos en la primera parte del artículo 121, cuando la víctima sea menor de catorce años y el agente sea el tutor, guardador o responsable de aquel, la pena será privativa de libertad no menor de cinco ni mayor de ocho años, remoción del cargo según el numeral 2 del artículo 554 del Código Civil e inhabilitación a que se refiere el artículo 36 inciso 5.
Artículo 121.- Lesiones graves  Cuando la víctima muere a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de seis ni mayor de doce años.”
“Formas agravadas. Lesiones graves por violencia familiar
Artículo 121-B.- El que causa a otro daño grave en el cuerpo o en la salud por violencia familiar será reprimido con pena privativa de libertad no menor de cinco ni mayor de diez años y suspensión de la patria potestad según el literal e) del artículo 75 del Código de los Niños y Adolescentes.
Cuando la víctima muere a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de seis ni mayor de quince años.” (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (44, 25, 'LESIONES LEVES', 1,155, 1,SYSDATE,  'Artículo 122.- Lesiones leves 
El que causa a otro un daño en el cuerpo o en la salud que requiera más de diez y menos de treinta días de asistencia o descanso, según prescripción facultativa, será reprimido con pena privativa de libertad no mayor de dos años y con sesenta a ciento cincuenta días-multa.
Cuando la víctima muere a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de tres ni mayor de seis años.
CONCORDANCIAS: D.S. Nº 016-2009-MTC, Décima Primera Disp. Complem. y Trans. (TUO del Reglamento Nacional
de Tránsito - Código de Tránsito)
Formas agravadas. El menor como víctima
 Artículo 122 A.- En el caso previsto en la primera parte del artículo anterior, cuando la víctima sea menor de catorce años y el agente sea el padre, madre, tutor, guardador o responsable de aquel, la pena será privativa de libertad no menor de tres ni mayor de seis años, suspensión de la patria potestad según el literal b) del Artículo 83 del Código de los Niños y Adolescentes e inhabilitación a que se refiere el Artículo 36 inciso 5.
 
Cuando la víctima muera a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de cuatro ni mayor de ocho años.  (1)(2)
CONCORDANCIA: Ley Nº 27337, Art. 75 (Código de los Niños y Adolescentes)
(1) Artículo incorporado por el Artículo 1 de la Ley N° 26788, publicada el 16-05-97.
(2) Artículo modificado por el Artículo 11 de la Ley N° 29282, publicada el 27 noviembre 2008, cuyo texto es el siguiente:
“Formas agravadas. El menor como víctima
Artículo 122-A.- En el caso previsto en la primera parte del artículo 122, cuando la víctima sea menor de catorce años y el agente sea el tutor, guardador o responsable de aquel, la pena será privativa de libertad no menor de tres ni mayor de seis años, remoción del cargo según el numeral 2 del artículo 554 del Código Civil e inhabilitación a que se refiere el artículo 36 inciso 5.
Cuando la víctima muere a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de cinco ni mayor de nueve años.”
“Formas agravadas. Lesiones leves por violencia familiar
Artículo 122-B.- El que causa a otro daño en el cuerpo o en la salud por violencia familiar que requiera más de diez y menos de treinta días de asistencia o descanso, según prescripción facultativa, será reprimido con pena privativa de libertad no menor de tres ni mayor de seis años y suspensión de la patria potestad según el literal e) del artículo 75 del Código de los Niños y Adolescentes.
Cuando la víctima muere a consecuencia de la lesión y el agente pudo prever este resultado, la pena será no menor de seis ni mayor de doce años.” (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (46, 25, 'LESIONES CON RESULTADO FORTUITO', 1,155, 1,SYSDATE,  'Artículo 123.- Lesiones preterintencionales con resultado fortuito 
Cuando el agente produzca un resultado grave que no quiso causar, ni pudo prever, la pena será disminuida prudencialmente hasta la que corresponda a la lesión que quiso inferir.
Lesiones culposas
Artículo 124.- El que, por culpa causa a otro un daño en el cuerpo o en la salud, será reprimido, por acción privada, con pena privativa de libertad no mayor de un año, o con sesenta a ciento veinte días-multa.
La acción penal se promoverá de oficio y la pena será privativa de libertad no menor de uno ni mayor de dos años y de sesenta a ciento veinte días-multa, si la lesión es grave.
El Juez podrá acumular la multa con la pena privativa de libertad. (*)
(*) Artículo modificado por el Artículo Unico de la Ley Nº 27054, publicada el 23-01-99, cuyo texto es el siguiente: Lesiones culposas 
 Artículo 124.- El que por culpa causa a otro un daño en el cuerpo o en la salud, será reprimido, por acción privada, con pena privativa de libertad no mayor de un año y con sesenta a ciento veinte días-multa.
 
La acción penal se promoverá de oficio y la pena será privativa de libertad no menor de uno ni mayor de dos años y de sesenta a ciento veinte días-multa, si la lesión es grave.
Cuando son varias las víctimas del mismo hecho o el delito resulte de la inobservancia de reglas técnicas, de profesión, de ocupación o de industria, la pena privativa de libertad será no menor de dos ni mayor de cuatro años e inhabilitación conforme al
Artículo 36 incisos 4), 6) y 7).  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (47, 25, 'LESIONES CULPOSAS', 1,155, 1,SYSDATE,  'Artículo 124.- Lesiones Culposas El que por culpa causa a otro un daño en el cuerpo o en la salud, será reprimido, por acción privada, con pena privativa de libertad no mayor de un año y con sesenta a ciento veinte días-multa.
La acción penal se promoverá de oficio y la pena será privativa de libertad no menor de uno ni mayor de dos años y de sesenta a ciento veinte días-multa, si la lesión es grave. (*)
(*) Párrafo modificado por el Artículo 1 de la Ley N° 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena será privativa de libertad no menor de uno ni mayor de dos años y de sesenta a ciento veinte días-multa, si la lesión es grave, de conformidad a los presupuestos establecidos en el artículo 121.  
La pena privativa de la libertad será no menor de tres años ni mayor de cinco años e inhabilitación, según corresponda, conforme al Artículo 36 incisos 4), 6) y 7), cuando el agente haya estado conduciendo un vehículo motorizado bajo el efecto de estupefacientes o en estado de ebriedad, con presencia de alcohol en la sangre en proporción mayor de 0.5 gramos-litro, o
cuando sean varias las víctimas del mismo hecho o el delito resulte de la inobservancia de reglas técnicas de tránsito.(*)
(*) Párrafo modificado por el Artículo 1 de la Ley N° 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de libertad será no menor de uno ni mayor de tres años si el delito resulta de la inobservancia de reglas de profesión, ocupación o industria y no menor de un año ni mayor de cuatro años cuando sean varias las víctimas del mismo hecho. 
La pena será no mayor de tres años si el delito resulta de la inobservancia de reglas de profesión, de ocupación o industria y cuando sean varias las víctimas del mismo hecho, la pena será no mayor de cuatro años.  (*)
(*) Párrafo modificado por el Artículo 1 de la Ley N° 29439, publicada el 19 noviembre 2009, cuyo texto es el siguiente:
 La pena privativa de la libertad será no menor de cuatro años ni mayor de seis años e inhabilitación, según corresponda, conforme al artículo 36 -incisos 4), 6) y 7)-, si la lesión se comete utilizando vehículo motorizado o arma de fuego, estando el agente bajo el efecto de drogas tóxicas, estupefacientes, sustancias psicotrópicas o sintéticas, o con presencia de alcohol en la sangre en proporción mayor de 0.5 gramos-litro, en el caso de transporte particular, o mayor de 0.25 gramoslitro en el caso de transporte público de pasajeros, mercancías o carga en general, o cuando el delito resulte de la inobservancia de reglas técnicas de tránsito. 
CONCORDANCIA: Ley N° 27753, Art. 3, 4 y Anexo
Daños al Concebido
 
 Artículo 124-A.- El que causa daño en el cuerpo o en la salud del concebido, será reprimido con pena privativa de la libertad no menor de un año ni mayor de tres  (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (48, 26, 'EXPOSICIÓN O ABANDONO A PERSONAS INCAPACES', 1,155, 1,SYSDATE,  'Artículo 125.- Exposición o abandono peligrosos El que expone a peligro de muerte o de grave e inminente daño a la salud o abandona en iguales circunstancias a un menor de edad o a una persona incapaz de valerse por sí misma que estén legalmente bajo su protección o que se hallen de hecho bajo su cuidado, será reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (49, 26, 'OMISIÓN DE SOCORRO Y EXPOSICIÓN AL PELIGRO', 1,155, 1,SYSDATE,  'Artículo 126.- Omisión de socorro y exposición a peligro 
El que omite prestar socorro a una persona que ha herido o incapacitado, poniendo en peligro su vida o su salud, será reprimido con pena privativa de libertad no mayor de tres años.');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (50, 26, 'OMISIÓN DE AUXILIO A PERSONA EN PELIGRO O AVISO A LA AUTORIDAD', 1,155, 1,SYSDATE,  'Artículo 127.- Omisión de auxilio o aviso a la autoridad 
El que encuentra a un herido o a cualquier otra persona en estado de grave e inminente peligro y omite prestarle auxilio inmediato pudiendo hacerlo sin riesgo propio o de tercero o se abstiene de dar aviso a la autoridad, será reprimido con pena privativa de libertad no mayor de un año o con treinta a ciento veinte días-multa.
Artículo 128.- Exposición a peligro de persona dependiente
El que expone a peligro la vida o la salud de una persona colocada bajo su autoridad, dependencia, tutela, curatela o vigilancia, sea privándola de alimentos o cuidados indispensables, sea sometiéndola a trabajos excesivos o inadecuados o abusando de los medios de corrección o disciplina, será reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro años.
Si resulta lesión grave o muerte y éstas pudieran ser previstas, la pena será no menor de tres ni mayor de seis años en caso de lesión grave y no menor de cuatro ni mayor de ocho años en caso de muerte. (*)');
INSERT INTO EXP_DELITO (ID, PADRE, NOMBRE, ESTADO, TIPO_CODIGO, CREADOR, CREACION, OBSERVACION) VALUES (51, 26, 'EXPOSICIÓN A PELIGRO DE PERSONA DEPENDIENTE', 1,155, 1,SYSDATE,  'Artículo 128.- Exposición a peligro de persona dependiente El que expone a peligro la vida o la salud de una persona colocada bajo su autoridad, dependencia, tutela, curatela o vigilancia, sea privándola de alimentos o cuidados indispensables, sea sometiéndola a trabajos excesivos, inadecuados, sea abusando de los medios de corrección o disciplina, sea obligándola o induciéndola a mendigar en lugares públicos, será reprimido con pena privativa de libertad no menor de uno ni mayor de cuatro años.
En los casos en que el agente tenga vínculo de parentesco consanguíneo o la víctima fuere menor de doce años de edad, la pena será privativa de libertad no menor de dos ni mayor de cuatro años.
En los casos en que el agente obligue o induzca a mendigar a dos o más personas colocadas bajo su autoridad, dependencia, tutela, curatela o vigilancia, la pena privativa de libertad será no menor de dos ni mayor de cinco años.');



commit;
