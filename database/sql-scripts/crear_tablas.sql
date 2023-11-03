DROP TABLE IF EXISTS cotizaciones;
DROP TABLE IF EXISTS plazos_fijos;
DROP TYPE IF EXISTS tipo_pf;

CREATE TABLE cotizaciones (
    id serial NOT NULL,
	cod_moneda char(3) NOT NULL,
	cotizacion varchar(30) NOT NULL,
	valor_en_ars money NOT NULL,
    fecha_de_registro timestamp with time zone,
    PRIMARY KEY (id)
);

-- T: Tradicional / C: Precancelable
CREATE TYPE tipo_pf AS ENUM ('T', 'C', 'UVA');
CREATE TABLE plazos_fijos (
	id serial NOT NULL,
	tipo tipo_pf NOT NULL,
	tna numeric(4, 2) NOT NULL,
	tea numeric(4, 2) NOT NULL,
	banco varchar(50) NOT NULL,
	PRIMARY KEY (id)
);