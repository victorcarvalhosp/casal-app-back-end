CREATE TABLE pessoa (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    perfil character varying(255) NOT NULL,
    senha character varying(255) NOT NULL
);

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);