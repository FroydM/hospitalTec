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