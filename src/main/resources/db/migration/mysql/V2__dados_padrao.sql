INSERT INTO configuracoes(
            id, data_criacao, email_parceiro_convite)
    VALUES (1, '2017-09-09', 'admin2@admin.com');

INSERT INTO pessoa(
            id, data_criacao, email, nome, perfil, senha, configuracoes_id)
    VALUES (1, '2017-09-05', 'admin@admin.com', 'ADMIN', 'ROLE_ADMIN', '$2a$10$w/qm49iZ/iPGNnyQh8kRUe3gRqTh7k5u6ylexSSpLqxow5acRZkpe', 1);


/* Adicionar lista  LAVAR A LOUÇA 7 DIAS */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (1, '2017-09-08', '', true, 'LOUCA', 'Lavar louça 7 dias', 1, 1);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (1, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (2, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (3, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (4, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (5, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (6, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado, 
            titulo, lista_tarefas_id)
    VALUES (7, '2017-09-08', null, '', false, false, 
            'Lavar louça', 1);



/* Adicionar lista  LAVAR ROUPA 3 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (2, '2017-09-08', '', true, 'LAVAR_ROUPAS', 'Lavar roupas 3 vezes', 1, 7);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (8, '2017-09-08', null, '', false, false,
            'Lavar roupas', 2);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (9, '2017-09-08', null, '', false, false,
            'Lavar roupas', 2);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (10, '2017-09-08', null, '', false, false,
            'Lavar roupas', 2);


/* Adicionar lista  PASSAR ROUPAS 3 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (3, '2017-09-08', '', true, 'PASSAR_ROUPAS', 'Passar roupas 3 vezes', 1, 7);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (11, '2017-09-08', null, '', false, false,
            'Passar roupas', 3);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (12, '2017-09-08', null, '', false, false,
            'Passar roupas', 3);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (13, '2017-09-08', null, '', false, false,
            'Passar roupas', 3);


/* Adicionar lista  TIRAR O LIXO 5 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (4, '2017-09-08', '', true, 'LIXO', 'Tirar o lixo 5 vezes', 1, 4);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (14, '2017-09-08', null, '', false, false,
            'Tirar o lixo', 4);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (15, '2017-09-08', null, '', false, false,
            'Tirar o lixo', 4);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (16, '2017-09-08', null, '', false, false,
            'Tirar o lixo', 4);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (17, '2017-09-08', null, '', false, false,
            'Tirar o lixo', 4);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (18, '2017-09-08', null, '', false, false,
            'Tirar o lixo', 4);


            /* Adicionar lista  VARRER A CASA 5 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (5, '2017-09-08', '', true, 'VARRER_CASA', 'Varrer a casa 5 dias', 1, 3);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (19, '2017-09-08', null, '', false, false,
            'Varrer a casa', 5);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (20, '2017-09-08', null, '', false, false,
            'Varrer a casa', 5);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (21, '2017-09-08', null, '', false, false,
            'Varrer a casa', 5);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (22, '2017-09-08', null, '', false, false,
            'Varrer a casa', 5);

            INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (23, '2017-09-08', null, '', false, false,
            'Varrer a casa', 5);


/* Adicionar lista TIRAR PÓ DOS MÓVEIS 3 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (6, '2017-09-08', '', true, 'CASA', 'Tirar o pó dos móveis 3 vezes', 1, 7);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (24, '2017-09-08', null, '', false, false,
            'Tirar o pó dos móveis', 6);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (25, '2017-09-08', null, '', false, false,
            'Tirar o pó dos móveis', 6);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (26, '2017-09-08', null, '', false, false,
            'Tirar o pó dos móveis', 6);


/* Adicionar lista FAZER ALMOÇO 2 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (7, '2017-09-08', '', true, 'FAZER_COMIDA', 'Fazer almoço', 1, 2);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (27, '2017-09-08', null, '', false, false,
            'Fazer almoço', 7);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (28, '2017-09-08', null, '', false, false,
            'Fazer almoço', 7);



            /* Adicionar lista IR NA PADÁRIA 2 VEZES */
INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id, dias_repeticao)
    VALUES (8, '2017-09-08', '', true, 'ATIVIDADE_EXTERNA', 'Ir na padária 2 vezes', 1, null);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (29, '2017-09-08', null, '', false, false,
            'Ir na padária', 8);

INSERT INTO tarefa(
            id, data_criacao, data_prevista, detalhes, finalizado, finalizado_confirmado,
            titulo, lista_tarefas_id)
    VALUES (30, '2017-09-08', null, '', false, false,
            'Ir na padária', 8);


/* Recompensas modelo*/
INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (1, '2018-09-02', 'Recompense seu(ua) parceiro(a) com 15 minutos de massagem', 'massage.svg', true, 'Massagem - 15 minutos');

    INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (2, '2018-09-02', 'Recompense seu(ua) parceiro(a) levando-o(a) para jantar fora', 'dinner.svg', true, 'Jantar fora');

     INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (3, '2018-09-02', 'Recompense seu(ua) parceiro(a) com doces', 'chocolate.svg', true, 'Doces');

    INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (4, '2018-09-02', 'Recompense seu(ua) parceiro(a) com salgadinhos', 'snacks.svg', true, 'Salgadinhos');

INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (5, '2018-09-02', 'Recompense seu(ua) parceiro(a) com 15 minutos de cafuné', 'treatment.svg', true, 'Cafuné - 15 minutos');

    INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (6, '2018-09-02', 'Recompense seu(ua) parceiro(a) com um belo presente', 'gift.svg', true, 'Presente');

    INSERT INTO recompensa(
            id, data_criacao, descricao, icone, modelo, titulo)
    VALUES (7, '2018-09-02', 'Recompense seu(ua) parceiro(a) deixando-o(a) com o controle da TV', 'television.svg', true, 'Controle da TV');


SELECT setval('tarefa_id_seq', 30, true);
SELECT setval('lista_tarefas_id_seq', 8, true);
SELECT setval('configuracoes_id_seq', 1, true);
SELECT setval('pessoa_id_seq', 1, true);
SELECT setval('recompensa_id_seq', 7, true);








