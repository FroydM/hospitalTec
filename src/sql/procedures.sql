-------------------------------------------------------------------------------------------
----------------------Gestion de Centro Atencion-------------------------------------------
-------------------------------------------------------------------------------------------
CREATE PROCEDURE [insertarCentroAtencion]
@nombre VARCHAR(50),
@lugar VARCHAR(50),
@capacidad INT,
@tipo VARCHAR(25)
AS BEGIN
INSERT INTO CENTRO_ATENCION(nombre,lugar,capacidad,tipo) VALUES (@nombre,@lugar,@capacidad,@tipo)
END
GO

CREATE PROCEDURE [allCentroAtencion]

AS BEGIN
SELECT codigo,nombre,lugar,capacidad,tipo FROM CENTRO_ATENCION 
END
GO

-------------------------------------------------------------------------------------------
----------------------Gestion de Area Trabajo----------------------------------------------
-------------------------------------------------------------------------------------------

CREATE PROCEDURE [insertAreaTrabajo]
@nombre VARCHAR(50)

AS BEGIN
INSERT INTO AREA_TRABAJO(nombre) VALUES(@nombre)
END
GO

CREATE PROCEDURE [allAreaTrabajo]

AS BEGIN
SELECT id,nombre FROM AREA_TRABAJO
END
GO

-------------------------------------------------------------------------------------------
----------------------Gestion de Paciente--------------------------------------------------
-------------------------------------------------------------------------------------------

CREATE PROCEDURE [insertPaciente]
@identificacion INT,
@nombre VARCHAR(50),
@apellido1 VARCHAR(50),
@apellido2 VARCHAR(50),
@fechaNacimiento DATE,
@tipoSangre VARCHAR(10),
@nacionalidad VARCHAR(50),
@lugarResidencia VARCHAR(50),
@correo VARCHAR(150)
AS BEGIN

INSERT INTO PERSONA(identificacion,nombre,apellido1,apellido2) VALUES (@identificacion,@nombre,@apellido1,@apellido2)
INSERT INTO PACIENTE(identificacion,fechaNacimiento,tipoSangre,nacionalidad,lugarResidencia,correo) VALUES(@identificacion,@fechaNacimiento,@tipoSangre,@nacionalidad,@lugarResidencia,@correo)
END
GO

CREATE PROCEDURE [allPacientes]

AS BEGIN
SELECT        dbo.PERSONA.identificacion, dbo.PERSONA.nombre, dbo.PERSONA.apellido1, dbo.PERSONA.apellido2,dbo.PACIENTE.fechaNacimiento, dbo.PACIENTE.tipoSangre, dbo.PACIENTE.nacionalidad, dbo.PACIENTE.lugarResidencia, dbo.PACIENTE.correo
FROM            dbo.PACIENTE INNER JOIN
                         dbo.PERSONA ON dbo.PACIENTE.identificacion = dbo.PERSONA.identificacion
END
GO

CREATE PROCEDURE [addTelefono]
@identificacion INT,
@telefono INT
AS BEGIN
INSERT INTO TELEFONO(idPaciente,numeroTelefono) VALUES (@identificacion,@telefono)
END
GO

CREATE PROCEDURE [addVacuna]
@idPaciente INT,
@fechaAplicacion DATE,
@nombre VARCHAR(50),
@farmaceutica VARCHAR(50),
@numeroLote VARCHAR(20)
AS BEGIN
INSERT INTO VACUNACION(idPaciente,fechaAplicacion,nombre,farmaceutica,numeroLote) VALUES (@idPaciente,@fechaAplicacion,@nombre,@farmaceutica,@numeroLote)
END
GO

CREATE PROCEDURE [allTelefonosByIdentificacion]
@idPaciente INT
AS BEGIN
SELECT numeroTelefono FROM TELEFONO where idPaciente = @idPaciente
END
GO

CREATE PROCEDURE [allVacunasByIdentificacion]
@idPaciente INT
AS BEGIN
SELECT fechaAplicacion,nombre,farmaceutica,numeroLote FROM VACUNACION WHERE idPaciente = @idPaciente
END
GO
-------------------------------------------------------------------------------------------
----------------------Gestion de Enfermero-------------------------------------------------
-------------------------------------------------------------------------------------------
CREATE PROCEDURE [insertarEnfermero]
@identificacion INT,
@nombre VARCHAR(50),
@apellido1 VARCHAR(50),
@apellido2 VARCHAR(50),
@tipo VARCHAR(50),
@fechaIngreso DATE,
@areaTrabajo INT,
@isCapacitacionExperiencia BIT,
@isJefeExperiencia BIT
AS BEGIN 
IF (not exists(SELECT identificacion FROM PERSONA WHERE identificacion = @identificacion)) AND 
	(NOT EXISTS (SELECT identificacion FROM FUNCIONARIO WHERE identificacion = @identificacion))

INSERT INTO PERSONA(identificacion,nombre,apellido1,apellido2) VALUES (@identificacion,@nombre,@apellido1,@apellido2)
INSERT INTO FUNCIONARIO(identificacion,tipo,fechaIngreso,areaTrabajo) VALUES (@identificacion,@tipo,@fechaIngreso,@areaTrabajo)
INSERT INTO ENFERMERO(identificacion,isCapacitacionExperiencia,isJefeExperiencia) VALUES (@identificacion,@isCapacitacionExperiencia,@isJefeExperiencia)
return(1)

ELSE

RETURN(0)
END
GO

CREATE PROCEDURE [allEnfermeros] 

AS BEGIN
SELECT        dbo.PERSONA.identificacion, dbo.PERSONA.nombre, dbo.PERSONA.apellido1, dbo.PERSONA.apellido2, dbo.FUNCIONARIO.tipo, dbo.FUNCIONARIO.fechaIngreso, dbo.AREA_TRABAJO.id as 'idArea', dbo.AREA_TRABAJO.nombre AS 'nombreArea', 
                         dbo.ENFERMERO.isCapacitacionExperiencia, dbo.ENFERMERO.isJefeExperiencia
FROM            dbo.ENFERMERO INNER JOIN
                         dbo.FUNCIONARIO ON dbo.ENFERMERO.identificacion = dbo.FUNCIONARIO.identificacion INNER JOIN
                         dbo.PERSONA ON dbo.FUNCIONARIO.identificacion = dbo.PERSONA.identificacion INNER JOIN
                         dbo.AREA_TRABAJO ON dbo.FUNCIONARIO.areaTrabajo = dbo.AREA_TRABAJO.id
END
GO
-------------------------------------------------------------------------------------------
----------------------Gestion de Doctor----------------------------------------------------
-------------------------------------------------------------------------------------------
CREATE PROCEDURE [insertarDoctor]
@identificacion INT,
@nombre VARCHAR(50),
@apellido1 VARCHAR(50),
@apellido2 VARCHAR(50),
@tipo VARCHAR(50),
@fechaIngreso DATE,
@areaTrabajo INT,
@codigoMedico INT
AS BEGIN 
IF ((not exists(SELECT identificacion FROM PERSONA WHERE identificacion = @identificacion)) AND 
	(NOT EXISTS (SELECT identificacion FROM FUNCIONARIO WHERE identificacion = @identificacion)))
	BEGIN
	INSERT INTO PERSONA(identificacion,nombre,apellido1,apellido2) VALUES (@identificacion,@nombre,@apellido1,@apellido2)
	INSERT INTO FUNCIONARIO(identificacion,tipo,fechaIngreso,areaTrabajo) VALUES (@identificacion,@tipo,@fechaIngreso,@areaTrabajo)
	INSERT INTO DOCTOR VALUES (@identificacion,@codigoMedico)
	return(1)
	END
ELSE
	BEGIN
		RETURN(0)
	END
END
GO

CREATE PROCEDURE [allDoctores]

AS BEGIN 
SELECT        dbo.PERSONA.identificacion, dbo.PERSONA.nombre, dbo.PERSONA.apellido1, dbo.PERSONA.apellido2, dbo.FUNCIONARIO.tipo, dbo.FUNCIONARIO.fechaIngreso, dbo.AREA_TRABAJO.id as 'idArea', dbo.AREA_TRABAJO.nombre AS 'nombreArea', 
                         dbo.DOCTOR.codigoMedico
FROM            dbo.AREA_TRABAJO INNER JOIN
                         dbo.FUNCIONARIO ON dbo.AREA_TRABAJO.id = dbo.FUNCIONARIO.areaTrabajo INNER JOIN
                         dbo.DOCTOR ON dbo.FUNCIONARIO.identificacion = dbo.DOCTOR.identificacion INNER JOIN
                         dbo.PERSONA ON dbo.FUNCIONARIO.identificacion = dbo.PERSONA.identificacion
END
GO

CREATE PROCEDURE [addEspecialidadDoctor]
@codigoMedico INT,
@nombreEspecialidad VARCHAR(100)
AS BEGIN
INSERT INTO ESPECIALIDADES(codigoMedico,nombreEspecialidad) VALUES (@codigoMedico,@nombreEspecialidad) 
END
GO

CREATE PROCEDURE [allEspecialidadesByCodigoMedico]
@codigoMedico INT
AS BEGIN
SELECT nombreEspecialidad FROM ESPECIALIDADES WHERE codigoMedico = @codigoMedico
END
GO

-------------------------------------------------------------------------------------------
----------------------Gestion de Secretario------------------------------------------------
-------------------------------------------------------------------------------------------
CREATE PROCEDURE [insertarSecretario]
@identificacion INT,
@nombre VARCHAR(50),
@apellido1 VARCHAR(50),
@apellido2 VARCHAR(50),
@tipo VARCHAR(50),
@fechaIngreso DATE,
@areaTrabajo INT
AS BEGIN 
IF ((not exists(SELECT identificacion FROM PERSONA WHERE identificacion = @identificacion)) AND 
	(NOT EXISTS (SELECT identificacion FROM FUNCIONARIO WHERE identificacion = @identificacion)))
	BEGIN
	INSERT INTO PERSONA(identificacion,nombre,apellido1,apellido2) VALUES (@identificacion,@nombre,@apellido1,@apellido2)
	INSERT INTO FUNCIONARIO(identificacion,tipo,fechaIngreso,areaTrabajo) VALUES (@identificacion,@tipo,@fechaIngreso,@areaTrabajo)
	
	return(1)
	END
ELSE
	BEGIN
		RETURN(0)
	END
END
GO

CREATE PROCEDURE [allSecretarios]

AS BEGIN
SELECT        dbo.PERSONA.identificacion, dbo.PERSONA.nombre, dbo.PERSONA.apellido1, dbo.PERSONA.apellido2, dbo.FUNCIONARIO.tipo, dbo.FUNCIONARIO.fechaIngreso, dbo.AREA_TRABAJO.id as 'idArea', 
                         dbo.AREA_TRABAJO.nombre AS 'nombreArea'
FROM            dbo.FUNCIONARIO INNER JOIN
                         dbo.PERSONA ON dbo.FUNCIONARIO.identificacion = dbo.PERSONA.identificacion INNER JOIN
                         dbo.AREA_TRABAJO ON dbo.FUNCIONARIO.areaTrabajo = dbo.AREA_TRABAJO.id WHERE dbo.FUNCIONARIO.tipo = 'Secretario' 
END 
GO