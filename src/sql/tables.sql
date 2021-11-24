

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
identificacion INT PRIMARY KEY  NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido1 VARCHAR(50) NOT NULL,
apellido2 VARCHAR(50) NOT NULL
);

CREATE TABLE [PACIENTE](
identificacion INT PRIMARY KEY FOREIGN KEY (identificacion) REFERENCES PERSONA(identificacion),
tipoSangre VARCHAR(10) NOT NULL,
fechaNacimiento DATE NOT NULL,
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
identificacion INT PRIMARY KEY FOREIGN KEY (identificacion) REFERENCES FUNCIONARIO(identificacion),
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


CREATE TABLE [USUARIOS](
userCode INT PRIMARY KEY FOREIGN KEY (userCode) REFERENCES PERSONA(identificacion) NOT NULL,
contrasenna VARCHAR(30) NOT NULL,
acceso VARCHAR(50) NOT NULL
);

-------------------------------------------------------------------------------------------
----------------------Citas----------------------------------------------------------------
-------------------------------------------------------------------------------------------
create TABLE [CITAS](
idCita INT PRIMARY KEY NOT NULL,
idPaciente INT FOREIGN KEY(idPaciente) REFERENCES PACIENTE(identificacion) NOT NULL,
area INT  FOREIGN KEY (area) REFERENCES AREA_TRABAJO(id) NOT NULL,
fechaHora SMALLDATETIME NOT NULL,
observacion VARCHAR(500) NOT NULL,
estado VARCHAR(150)
);

create TABLE [CITAS_LOG](
idCita INT FOREIGN KEY (idCita) REFERENCES CITAS(idCita),
fechaHora SMALLDATETIME NOT NULL,
usuario INT FOREIGN KEY (usuario) REFERENCES USUARIOS(userCode) NOT NULL,
estadoAnterior VARCHAR(150) NOT NULL,
estadoActualizado VARCHAR(150) NOT NULL
);

-------------------------------------------------------------------------------------------
----------------------Hospitalizaciones----------------------------------------------------
-------------------------------------------------------------------------------------------

CREATE TABLE [CATALOGO_DIAGNOSTICOS](
id INT IDENTITY(1,1),
nombre VARCHAR(100) not null
primary key(id)
);

CREATE TABLE [TRATAMIENTOS] (
id  INT IDENTITY(1,1),
idDiagnostico INT FOREIGN KEY (idDiagnostico) REFERENCES CATALOGO_DIAGNOSTICOS(id),
nombreTratamiento VARCHAR(200) not null,
cantidadDosis VARCHAR(50) not null,
tipoTratamiento VARCHAR(50) not null
);
