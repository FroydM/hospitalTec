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
----------------------Gestion de Pacientes-------------------------------------------------
-------------------------------------------------------------------------------------------