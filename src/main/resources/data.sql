-- Domicilios
INSERT INTO DOMICILIOS(id, calle, numero, localidad, provincia)
VALUES(NEXTVAL('domicilio_seq'), 'LAS HERAS','420','PALERMO','BS AS'), (NEXTVAL('domicilio_seq'), 'CORRIENTES','6787','CABA','BS AS');

-- Pacientes
INSERT INTO PACIENTES (id, nombre, apellido, cedula, fecha_de_ingreso, domicilio_id)
VALUES(NEXTVAL('paciente_seq'), 'FEDERICO','VITALE','123','2023-09-14','1'),(NEXTVAL('paciente_seq'), 'ALEJO', 'CORTI','456', '2023-09-14','2');

-- Odontologos
INSERT INTO ODONTOLOGOS (odontologo_id, numero_matricula, nombre, apellido)
VALUES  (NEXTVAL('odontologo_seq'), '001', 'IGNACIO', 'ARACENA'), (NEXTVAL('odontologo_seq'), '002','LUCAS','GARRONI');

-- Turnos
INSERT INTO TURNOS (turno_id, fecha, odontologo_id, paciente_id)
VALUES(NEXTVAL('turno_seq'), '2023-09-15T16:20:00','1','2');