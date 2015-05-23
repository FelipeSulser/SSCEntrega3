--TABLAS

CREATE TABLE ADMINISTRATIVO (ID BIGINT NOT NULL, APELLIDO1 VARCHAR(255) NOT NULL, APELLIDO2 VARCHAR(255), CONTRASENIA VARCHAR(255) NOT NULL, DNI VARCHAR(255) NOT NULL UNIQUE, IMAGE VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, USUARIO VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE CITA (ID BIGINT NOT NULL, COMENTARIOS VARCHAR(255), ESTADO INTEGER NOT NULL, FECHA DATE NOT NULL, TIPO_DE_CITA VARCHAR(255) NOT NULL, CIUDADANO_ID BIGINT NOT NULL, PROFESIONAL_ID BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE CIUDADANO (ID BIGINT NOT NULL, APELLIDO1 VARCHAR(255) NOT NULL, APELLIDO2 VARCHAR(255), DNI VARCHAR(255) NOT NULL UNIQUE, FECHA_NACIMIENTO DATE NOT NULL, IMAGE VARCHAR(255), INGRESO_MEDIO FLOAT, NACIONALIDAD VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE EXPEDIENTE (ID BIGINT NOT NULL, CSS VARCHAR(255) NOT NULL, FECHA_APERTURA DATE NOT NULL, ZONA VARCHAR(255) NOT NULL, CIUDADANO_EXP_ID BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE FAMILIAR (ID BIGINT NOT NULL, APELLIDO1 VARCHAR(255) NOT NULL, APELLIDO2 VARCHAR(255), DNI VARCHAR(255) NOT NULL UNIQUE, FECHA_NACIMIENTO DATE NOT NULL, INGRESO_MEDIO FLOAT, MU VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, PARENTESCO VARCHAR(255) NOT NULL, EXPEDIENTE_FAM_ID BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE INTERVENCIONES (ID BIGINT NOT NULL, ANOTACIONES VARCHAR(255), FECHA DATE NOT NULL, ID_CITA_ID BIGINT NOT NULL, INTERVENCIONES_EXP_ID BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PROFESIONAL (ID BIGINT NOT NULL, APELLIDO1 VARCHAR(255) NOT NULL, APELLIDO2 VARCHAR(255), CONTRASENIA VARCHAR(255) NOT NULL, DNI VARCHAR(255) NOT NULL UNIQUE, IMAGE VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, USUARIO VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE VIVIENDA (ID BIGINT NOT NULL, CALLE VARCHAR(255) NOT NULL, CODIGO_POSTAL VARCHAR(255) NOT NULL, CONDICIONES VARCHAR(255), METROS_CUADRADOS VARCHAR(255), MUNICIPIO VARCHAR(255) NOT NULL, REGIMEN_TENENCIA VARCHAR(255) NOT NULL, TELEFONO VARCHAR(255), PROPIETARIO_ID BIGINT NOT NULL, EXPEDIENTE_RESIDENCIA_ID BIGINT, PRIMARY KEY (ID));
ALTER TABLE CITA ADD CONSTRAINT CITAPROFESIONAL_ID FOREIGN KEY (PROFESIONAL_ID) REFERENCES PROFESIONAL (ID);
ALTER TABLE CITA ADD CONSTRAINT CITA_CIUDADANO_ID FOREIGN KEY (CIUDADANO_ID) REFERENCES CIUDADANO (ID);
ALTER TABLE EXPEDIENTE ADD CONSTRAINT XPDENTECDDANOEXPID FOREIGN KEY (CIUDADANO_EXP_ID) REFERENCES CIUDADANO (ID);
ALTER TABLE FAMILIAR ADD CONSTRAINT FMLARXPDIENTEFAMID FOREIGN KEY (EXPEDIENTE_FAM_ID) REFERENCES EXPEDIENTE (ID);
ALTER TABLE INTERVENCIONES ADD CONSTRAINT NTRVENCIONESDCTAID FOREIGN KEY (ID_CITA_ID) REFERENCES CITA (ID);
ALTER TABLE INTERVENCIONES ADD CONSTRAINT NTRVNCNNTRVNCNSXPD FOREIGN KEY (INTERVENCIONES_EXP_ID) REFERENCES EXPEDIENTE (ID);
ALTER TABLE VIVIENDA ADD CONSTRAINT VVNDXPDNTRSDNCIAID FOREIGN KEY (EXPEDIENTE_RESIDENCIA_ID) REFERENCES EXPEDIENTE (ID);
ALTER TABLE VIVIENDA ADD CONSTRAINT VVENDAPRPIETARIOID FOREIGN KEY (PROPIETARIO_ID) REFERENCES EXPEDIENTE (ID);
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0);

--DATOS

--administrativo
INSERT INTO ADMINISTRATIVO (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (1, 'López', 'García', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '11223344Z', 'profile.png', 'Franchesco', 'usuario66');
INSERT INTO ADMINISTRATIVO (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (2, 'Pérez', 'Larraz', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '11244366Z', 'profile.png', 'Teodobo', 'usuario67');
INSERT INTO ADMINISTRATIVO (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (3, 'Domínguez', 'Laurel', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '11443377A', 'profile.png', 'John', 'usuario68');


--profesional
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (1, 'Vercetti', 'Pérez', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '11223344E', 'profile.png', 'John', 'usuario1');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (3, 'García', 'de Laghetto', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '12243541D', 'profile.png', 'Ron', 'usuario2');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (5, 'Milner', '', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '1234', 'profile.png', 'Sam', 'usuario3');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (2, 'Salvador', 'Solanera', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '31113322G', 'profile.png', 'Saturnino', 'usuario4');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (4, 'Sotomayor', 'Claus', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '664255542K', 'profile.png', 'Eutropia', 'usuario5');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (6, 'Buchubán', '', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '22442342G', 'profile.png', 'Yobitabe', 'usuario6');
INSERT INTO PROFESIONAL (ID, APELLIDO1, APELLIDO2, CONTRASENIA, DNI, IMAGE, NOMBRE, USUARIO) 
	VALUES (7, 'Alfrédez', 'César', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', '99923342E', 'profile.png', 'Natanaela', 'usuario7');



--ciudadano
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (1, 'Sulser', 'Larraz', '78986342', '1992-05-15', 'profile.png', 2000.0, 'Suiza', 'Felipe');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (2, 'Pérez', 'Wohlfeil', '77188642K', '1975-05-15', 'profile.png', 19999.0, 'Española', 'Esteban');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (3, 'Henrik', 'Abel', '11223344C', '1990-04-03', 'profile.png', 1200.0, 'ESPAÑA', 'Niels');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (7, 'Fernández', 'Suárez', '55223344K', '1893-01-12', 'profile.png', 200.0, 'RUSIA', 'Iván');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (9, 'García-Faure', 'Torres', '35243342E', '1994-01-20', 'profile.png', 3000.0, 'ESPAÑA', 'Álvaro');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (4, 'Ónix', 'López', '22553311B', '1962-03-01', 'profile.png', 1222.0, 'ESPAÑA', 'Patrisano');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (6, 'Bab', '', '44553122C', '1992-10-08', 'profile.png', 500.0, 'TAILANDIA', 'Edorrica');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (5, 'Pérez', 'Wohlfeil', '77188676D', '1993-06-04', 'profile.png', 500.0, 'ESPAÑA', 'Esteban');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (11, 'Puerto', 'San Román', '24249942R', '1994-11-20', 'profile.png', 1000.0, 'ESPAÑA', 'Haritz');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (8, 'Gandalfín', 'Ajonjolí', '41552319D', '1955-02-17', 'profile.png', 756.0, 'ESPAÑA', 'Lucrecia');
INSERT INTO CIUDADANO (ID, APELLIDO1, APELLIDO2, DNI, FECHA_NACIMIENTO, IMAGE, INGRESO_MEDIO, NACIONALIDAD, NOMBRE) 
	VALUES (10, 'Vingrede', 'Custodia', '12553771C', '1980-11-09', 'profile.png', 4520.0, 'ESPAÑA', 'Poncio Teobaldo');



--expedientes
insert into EXPEDIENTE values (1, 'RONDA', '11/11/1111', 'RONDA', 1);
insert into EXPEDIENTE values (3, 'TEATINOS', '12/12/1212', 'Louis Pasteur', 3);
insert into EXPEDIENTE values (5, 'RINCON DE LA VICTORIA', '07/15/2000', 'La cala del moral', 5);
insert into EXPEDIENTE values (7, 'CRUZ VERDE', '06/06/1996', 'Virgen de las Flores', 7);
insert into EXPEDIENTE values (9, 'LIMONAR', '01/16/1998', 'CALASOL', 9);
insert into EXPEDIENTE values (11, 'PUERTO RICO', '05/11/1837', 'Santa Romania', 11);
insert into EXPEDIENTE values (2, 'Barruqueña', '02/15/1750', 'Virgen de la Barruqueña', 2);
insert into EXPEDIENTE values (4, 'Yuri Gagarin', '02/13/1999', 'Plaza de Villavacas', 6);
insert into EXPEDIENTE values (6, 'Corrípila', '10/11/1999', 'Torreflauta', 4);
insert into EXPEDIENTE values (8, 'Rey Juan', '12/12/1989', 'Christian Andersen', 8);
insert into EXPEDIENTE values (10, 'La Flauta Mágica', '09/05/1799', 'Aramejín', 10);

--cita
insert into CITA values (3, '',1, '01/03/1990', 'URGENCIA', 3, 1);
insert into CITA values (5, '',3, '08/03/1990', 'SESION INFORMATIVA', 1, 5);
insert into CITA values (7, 'solicitud y tramitación',1, '07/03/1990', 'TELEASISTENCIA', 5, 3);
insert into CITA values (9, 'solicitud de atención',1, '04/11/2015', 'TELEASISTENCIA', 9, 5);
insert into CITA values (11, 'mantenimiento GITHUB',1, '05/11/2015', 'SERVICIO ATENCION', 11, 3);
insert into CITA values (2, '',1, '02/08/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (4, '',1, '03/16/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (6, '',0, '03/21/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (8, '',1, '03/24/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (10, '',2, '04/02/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (12, '',1, '04/05/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (13, '',2, '04/08/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (14, '',2, '04/09/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (15, '',3, '04/11/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (16, '',1, '04/15/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (17, '',2, '04/16/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (18, '',1, '04/19/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (19, '',1, '04/22/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (20, '',0, '04/27/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (21, '',1, '04/29/2015', 'FONTANERÍA', 2, 2);
insert into CITA values (22, '',0, '06/09/2428', 'FONTANERÍA', 2, 2);	
insert into CITA values (23, '',2, '05/12/1993', 'SERVICIOS SANITARIOS', 4, 6);	


--intervenciones
insert into INTERVENCIONES values (1, 'Obturación obstruida', '02/08/2015', 2, 2);
insert into INTERVENCIONES values (2, 'Obturación sigue obstruida y se oyen voces', '03/16/2015', 4, 2);
insert into INTERVENCIONES values (3, 'Persiste problema. Llamada furgoneta de recambio', '03/21/2015', 6, 2);
insert into INTERVENCIONES values (4, 'Problema parecía resuelto pero no. Furgoneta de recambio insiste en que no es de su competencia. Llamada segunda furgoneta de recambio', '03/24/2015', 8, 2);
insert into INTERVENCIONES values (5, 'El musgo verde se ha extendido por las paredes del recibidor. Probados desinfectante y llave inglesa', '04/02/2015', 10, 2);
insert into INTERVENCIONES values (6, 'El desinfectante solo parece alimentar al parásito. La llave inglesa ha tenido algo más de efecto. Las voces hablan ahora sobre la guerra del Golfo', '04/05/2015',12, 2);
insert into INTERVENCIONES values (7, 'Posteriores aplicaciones de la llave inglesa solo resultan en eslóganes ecologistas. Musgo tiene ahora forma de cara de María Magdalena. Segunda furgoneta de recambio deja la vivienda', '04/08/2015',13, 2);
insert into INTERVENCIONES values (8, 'A las tres de la madrugada el musgo comienza a llamar por teléfono. La segunda furgoneta de recambio vuelve pero no consigue acceder a la vivienda. El parásito produce ahora su propio desinfectante. El baño está limpio y resbaladizo', '04/09/2015',14, 2);
insert into INTERVENCIONES values (9, 'No es posible acceder sin suelas antideslizantes. El parásito parece tener consciencia propia; intentos de convencerlo de que deje de producir desinfectante resultan en complicada discusión ontológica. Tercera furgoneta de recambio en camino', '04/11/2015',15, 2);
insert into INTERVENCIONES values (10, 'Musgo abandona la vivienda y se instala en el pasillo. Tercera furgoneta de recambio olvidó las suelas antideslizantes y las máscaras de gas', '04/15/2015', 16, 2);
insert into INTERVENCIONES values (11, 'Parásito accede a filmoteca del inquilino y absorbe DVD de Billy Elliot. Se escucha música de ballet durante toda la noche. Furgoneta de recambio atascada en Alcalá', '04/16/2015', 17, 2);
insert into INTERVENCIONES values (12, 'Tercera furgoneta de recambio irrumpe por fin en baño. Diagnostica problema agravado por llave inglesa. Discusión con parásito sobre claqué y bachata', '04/19/2015',  18, 2);
insert into INTERVENCIONES values (13, 'Musgo es ahora problema de otro vecino. Tercera furgoneta de recambio abandona el domicilio tras tres días de esfuerzo infructuoso. Parásito empecinado en superioridad del Método Vaganova. Muy insistente.', '04/22/2015', 19, 2);
insert into INTERVENCIONES values (14, 'Imposible convencer a parásito de nada. Desde el piso del vecino se oyen cánticos marxistas. Suelas antideslizantes inutilizadas', '04/27/2015',  20, 2);
insert into INTERVENCIONES values (15, 'Cánticos marxistas distraen ahora a todo el edificio. Parásito es un maldito terco y no admite influencias italianas en ballet ruso. Supervivencia del vecindario en peligro', '04/29/2015',  21, 2);
insert into INTERVENCIONES values (16, 'Método Vaganova implantado como obligatorio y universal en el planeta Tierra. Procediendo a la expansión interestelar. Llamada de emergencia A29#24', '06/09/2428', 22, 2);	
insert into INTERVENCIONES values (17, 'Comida para gatos anunciada falsamente como "con alto contenido en hierro". Daños aún por cuantificar', '05/12/1993', 6, 4);	
	





--vivienda

insert into VIVIENDA values (1, 'C/Java', '13000','', '180', 'Puerto de la Torre', 'PROPIO', '666111666', 5, 5);
insert into VIVIENDA values (3, 'C/Malajaula', '13000','DEPLORABLES', '32', 'Santa Teresa', 'PROPIO', '664111666', 1, 1);
insert into VIVIENDA values (5, 'C/Trigonometria II', '23000','PLORABLES', '91', 'Almújar', 'PROPIO', '666311666', 3, 3);
insert into VIVIENDA values (7, 'C/Rinconero', '14000','', '68', 'Virginia', 'CEDIDO', '666191666', 7, 7);
insert into VIVIENDA values (9, 'C/Calculo', '19020','SEMINUEVO', '112', 'Bristol Avenue', 'PROPIO', '266111666', 11, 11);
insert into VIVIENDA values (11, 'C/Capuchinos', '24010','', '48', 'Blancaflor', 'VIVIENDA ESTATAL', '666111667', 9, 9);
insert into VIVIENDA values (2, 'C/Anabeta Maldonado', '70423','PESIMAS', '123', 'Colimar de los Píos', 'PROPIO', '555111333', 2, 2);
insert into VIVIENDA values (4, 'Plaza Eduardo Fotercoten', '25821','EXCELENTES', '96', 'Villavacas', 'ALQUILER', '', 6, 6);
insert into VIVIENDA values (6, 'Vía Apio', '76345','REGULARES', '23', 'Arcocosenaria', 'PROPIO', '123456789', 4, 4);
insert into VIVIENDA values (8, 'Urbanización Trigo Limpio', '23000','EXCELENTES', '100', 'Lisco Máxima', 'PROPIO', '888456123', 8, 8);
insert into VIVIENDA values (10, 'C/Villamari', '99821','PAUPERRIMAS', '66', 'Aramejín', 'ALQUILER', '666666666', 10, 10);
--viviendas vacías
insert into VIVIENDA values (12, 'C/Rosal', '29730','EXCELENTES', '650', 'Rincón de la Victoria', 'PROPIO', '656114661', 3, null);


--familiar
insert into FAMILIAR values (1, 'Henrik', 'Abel', '33221100K', '02/02/1992',900,'','Leonardo','HERMANO', 1);
insert into FAMILIAR values (3, 'García-Faure', 'Torres', '32221110B', '04/02/1995',0,'','Jonatan','HERMANO', 9);
insert into FAMILIAR values (2, 'Filopeña', 'Faríbico', '44663399C', '02/19/1974',600,'','Godofreda','HERMANA', 2);
insert into FAMILIAR values (4, 'Bab', '', '42263249C', '08/05/1967',1000,'','Aristides','PADRE', 4);
