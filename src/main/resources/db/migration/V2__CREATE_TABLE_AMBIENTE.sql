CREATE TABLE public.ambiente (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	nome varchar NOT NULL,
	descricao varchar NOT NULL,
	CONSTRAINT ambiente_pkey PRIMARY KEY (id)
);
CREATE INDEX ambiente_id_idx ON public.ambiente (id);