
CREATE TABLE configuracoes (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    email_parceiro_convite character varying(255)
);


ALTER TABLE configuracoes OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 134433)
-- Name: configuracoes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE configuracoes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE configuracoes_id_seq OWNER TO postgres;

--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 174
-- Name: configuracoes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE configuracoes_id_seq OWNED BY configuracoes.id;


--
-- TOC entry 177 (class 1259 OID 134443)
-- Name: lista_tarefas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lista_tarefas (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    descricao character varying(255),
    modelo boolean,
    tipo_lista character varying(255) NOT NULL,
    titulo character varying(255),
    criador_id bigint,
    recompensa_id bigint,
    dias_repeticao bigint
);


ALTER TABLE lista_tarefas OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 134441)
-- Name: lista_tarefas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE lista_tarefas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE lista_tarefas_id_seq OWNER TO postgres;

--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 176
-- Name: lista_tarefas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE lista_tarefas_id_seq OWNED BY lista_tarefas.id;


--
-- TOC entry 179 (class 1259 OID 134454)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pessoa (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    perfil character varying(255) NOT NULL,
    senha character varying(255),
    configuracoes_id bigint NOT NULL,
    parceiro_id bigint
);


ALTER TABLE pessoa OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 134452)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 178
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pessoa_id_seq OWNED BY pessoa.id;


--
-- TOC entry 181 (class 1259 OID 134465)
-- Name: recompensa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recompensa (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    descricao character varying(255),
    icone character varying(255),
    modelo boolean,
    titulo character varying(255)
);


ALTER TABLE recompensa OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 134463)
-- Name: recompensa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recompensa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recompensa_id_seq OWNER TO postgres;

--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 180
-- Name: recompensa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recompensa_id_seq OWNED BY recompensa.id;


--
-- TOC entry 183 (class 1259 OID 134476)
-- Name: recompensa_pessoa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recompensa_pessoa (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    conquistado boolean,
    utilizado boolean,
    pessoa_id bigint,
    recompensa_id bigint
);


ALTER TABLE recompensa_pessoa OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 134474)
-- Name: recompensa_pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recompensa_pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recompensa_pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 182
-- Name: recompensa_pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recompensa_pessoa_id_seq OWNED BY recompensa_pessoa.id;


--
-- TOC entry 185 (class 1259 OID 134484)
-- Name: tarefa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tarefa (
    id bigint NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    data_prevista date,
    detalhes character varying(255),
    finalizado boolean,
    finalizado_confirmado boolean,
    titulo character varying(255) NOT NULL,
    lista_tarefas_id bigint NOT NULL
);


ALTER TABLE tarefa OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 134482)
-- Name: tarefa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarefa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tarefa_id_seq OWNER TO postgres;

--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 184
-- Name: tarefa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarefa_id_seq OWNED BY tarefa.id;


--
-- TOC entry 1913 (class 2604 OID 134438)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY configuracoes ALTER COLUMN id SET DEFAULT nextval('configuracoes_id_seq'::regclass);


--
-- TOC entry 1914 (class 2604 OID 134446)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lista_tarefas ALTER COLUMN id SET DEFAULT nextval('lista_tarefas_id_seq'::regclass);


--
-- TOC entry 1915 (class 2604 OID 134457)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN id SET DEFAULT nextval('pessoa_id_seq'::regclass);


--
-- TOC entry 1916 (class 2604 OID 134468)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recompensa ALTER COLUMN id SET DEFAULT nextval('recompensa_id_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 134479)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recompensa_pessoa ALTER COLUMN id SET DEFAULT nextval('recompensa_pessoa_id_seq'::regclass);


--
-- TOC entry 1918 (class 2604 OID 134487)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarefa ALTER COLUMN id SET DEFAULT nextval('tarefa_id_seq'::regclass);


--
-- TOC entry 2048 (class 0 OID 134435)
-- Dependencies: 175
-- Data for Name: configuracoes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 174
-- Name: configuracoes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('configuracoes_id_seq', 1, false);


--
-- TOC entry 2050 (class 0 OID 134443)
-- Dependencies: 177
-- Data for Name: lista_tarefas; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 176
-- Name: lista_tarefas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('lista_tarefas_id_seq', 1, false);


--
-- TOC entry 2052 (class 0 OID 134454)
-- Dependencies: 179
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 178
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pessoa_id_seq', 1, false);


--
-- TOC entry 2054 (class 0 OID 134465)
-- Dependencies: 181
-- Data for Name: recompensa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 180
-- Name: recompensa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recompensa_id_seq', 1, false);


--
-- TOC entry 2056 (class 0 OID 134476)
-- Dependencies: 183
-- Data for Name: recompensa_pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 182
-- Name: recompensa_pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recompensa_pessoa_id_seq', 1, false);


--
-- TOC entry 2058 (class 0 OID 134484)
-- Dependencies: 185
-- Data for Name: tarefa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 184
-- Name: tarefa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarefa_id_seq', 1, false);


--
-- TOC entry 1920 (class 2606 OID 134440)
-- Name: configuracoes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY configuracoes
    ADD CONSTRAINT configuracoes_pkey PRIMARY KEY (id);


--
-- TOC entry 1922 (class 2606 OID 134451)
-- Name: lista_tarefas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lista_tarefas
    ADD CONSTRAINT lista_tarefas_pkey PRIMARY KEY (id);


--
-- TOC entry 1924 (class 2606 OID 134462)
-- Name: pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 1928 (class 2606 OID 134481)
-- Name: recompensa_pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recompensa_pessoa
    ADD CONSTRAINT recompensa_pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 1926 (class 2606 OID 134473)
-- Name: recompensa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recompensa
    ADD CONSTRAINT recompensa_pkey PRIMARY KEY (id);


--
-- TOC entry 1930 (class 2606 OID 134492)
-- Name: tarefa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarefa
    ADD CONSTRAINT tarefa_pkey PRIMARY KEY (id);


--
-- TOC entry 1934 (class 2606 OID 134508)
-- Name: fk9rcewi4ajn2ctjfghestufpgy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT fk9rcewi4ajn2ctjfghestufpgy FOREIGN KEY (parceiro_id) REFERENCES pessoa(id);


--
-- TOC entry 1935 (class 2606 OID 134513)
-- Name: fkcuqlvl5t3c0w9013cnay59r18; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recompensa_pessoa
    ADD CONSTRAINT fkcuqlvl5t3c0w9013cnay59r18 FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 1936 (class 2606 OID 134518)
-- Name: fke5vgn6a2kdxhqdft1qbos9s36; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recompensa_pessoa
    ADD CONSTRAINT fke5vgn6a2kdxhqdft1qbos9s36 FOREIGN KEY (recompensa_id) REFERENCES recompensa(id);


--
-- TOC entry 1931 (class 2606 OID 134493)
-- Name: fkiljct6208yh6d54s8d4fanj8b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lista_tarefas
    ADD CONSTRAINT fkiljct6208yh6d54s8d4fanj8b FOREIGN KEY (criador_id) REFERENCES pessoa(id);


--
-- TOC entry 1937 (class 2606 OID 134523)
-- Name: fkpi91yf3b2twt1blmva6pfq64c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarefa
    ADD CONSTRAINT fkpi91yf3b2twt1blmva6pfq64c FOREIGN KEY (lista_tarefas_id) REFERENCES lista_tarefas(id);


--
-- TOC entry 1933 (class 2606 OID 134503)
-- Name: fkpr7k2p0f2erayjcyo1t1a6776; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT fkpr7k2p0f2erayjcyo1t1a6776 FOREIGN KEY (configuracoes_id) REFERENCES configuracoes(id);


--
-- TOC entry 1932 (class 2606 OID 134498)
-- Name: fkrrrxmf1aw8odaxh3oysix8sal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lista_tarefas
    ADD CONSTRAINT fkrrrxmf1aw8odaxh3oysix8sal FOREIGN KEY (recompensa_id) REFERENCES recompensa(id);


-- Completed on 2017-09-10 13:01:14

--
-- PostgreSQL database dump complete
--