CREATE TABLE public.cliente (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	nome varchar NOT NULL,
	url varchar NOT NULL,
	parametrizado boolean NOT NULL,
	health_endpoint varchar NOT NULL,
	ambienteid int8 NOT NULL,
	servico varchar NOT NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id),
	CONSTRAINT cliente_fkey FOREIGN KEY (ambienteid) REFERENCES public.ambiente(id)
);
CREATE INDEX cliente_id_idx ON public.cliente (id);