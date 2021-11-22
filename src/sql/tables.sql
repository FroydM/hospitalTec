CREATE DATABASE dbHospitalTec
USE dbHospitalTec

CREATE TABLE [CENTRO_ATENCION](
codigo INT IDENTITY(1,1) NOT NULL,
nombre VARCHAR(50)NOT NULL,
lugar VARCHAR(50) NOT NULL,
capacidad INT NOT NULL,
tipo VARCHAR(25) NOT NULL
);

CREATE TABLE [AREA_TRABAJO](
id INT IDENTITY(1,1) PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
);

CREATE TABLE [PERSONA](
identificacion INT PRIMARY KEY NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellidos VARCHAR(50) NOT NULL
):

CREATE TABLE [PACIENTE](
identificacion INT PRIMARY KEY FOREIGN KEY (identificacion) REFERENCES PERSONA(identificacion),
tipoSangre VARCHAR(10) NOT NULL,
nacionalidad VARCHAR(50) NOT NULL,
lugarResidencia VARCHAR(50) NOT NULL,
correo VARCHAR(150) NOT NULL
);

CREATE TABLE TELEFONO(
idPaciente INT FOREIGN KEY (idPaciente) REFERENCES PERSONA(identificacion),
numeroTelefono INT
PRIMARY KEY(idPaciente,numeroTelefono)
);

CREATE TABLE VACUNACION(
idPaciente INT FOREIGN KEY (idPaciente) REFERENCES PERSONA(identificacion),
fechaAplicacion DATE NOT NULL,
nombre VARCHAR(50),
farmaceutica VARCHAR(50),
numeroLote VARCHAR(20)
PRIMARY KEY (farmaceutica,numeroLote)
);

CREATE TABLE [FUNCIONARIO](
identificacion INT PRIMARY KEY FOREIGN KEY (identificacion) REFERENCES PERSONA(identificacion),
tipo VARCHAR(50) NOT NULL,
fechaIngreso DATE NOT NULL,
areaTrabajo INT  FOREIGN KEY (areaTrabajo) REFERENCES AREA_TRABAJO(id)
);

CREATE TABLE [ENFERMERO](
identificacion INT FOREIGN KEY (identificacion) REFERENCES FUNCIONARIO(identificacion),
isCapacitacionExperiencia BIT NOT NULL,
isJefeExperiencia BIT NOT NULL,
);

CREATE TABLE [DOCTOR](
identificacion INT FOREIGN KEY (identificacion) REFERENCES FUNCIONARIO(identificacion),
codigoMedico INT PRIMARY KEY NOT NULL,
);

CREATE TABLE [ESPECIALIDADES](
codigoMedico INT FOREIGN KEY (codigoMedico) REFERENCES DOCTOR(codigoMedico),
nombreEspecialidad VARCHAR(100) NOT NULL,
PRIMARY KEY(nombreEspecialidad,codigoMedico)
);