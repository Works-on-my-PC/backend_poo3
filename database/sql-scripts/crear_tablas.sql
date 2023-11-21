DROP TABLE IF EXISTS cotizaciones;
DROP TABLE IF EXISTS plazos_fijos;
DROP TYPE IF EXISTS tipo_pf;

CREATE TABLE cotizaciones (
    id serial NOT NULL,
	cod_moneda char(3) NOT NULL,
	cotizacion varchar(30) NOT NULL,
	valor_en_ars numeric(8, 2) NOT NULL,
    fecha_de_registro timestamp with time zone
);
ALTER TABLE cotizaciones ADD CONSTRAINT pk_cotizaciones PRIMARY KEY(id);

-- T: Tradicional / C: Precancelable
CREATE TYPE tipo_pf AS ENUM ('T', 'C', 'UVA');
CREATE TABLE plazos_fijos (
	id serial NOT NULL,
	tipo tipo_pf NOT NULL,
	tna numeric(6, 2) NOT NULL,
	tea numeric(7, 3) GENERATED ALWAYS AS ((POWER((1+(tna/1200)), 12)-1)*100) STORED,
	banco varchar(100) NOT NULL,
	fecha_de_registro timestamp with time zone
);
ALTER TABLE plazos_fijos ADD CONSTRAINT pk_plazos_fijos PRIMARY KEY(id);
