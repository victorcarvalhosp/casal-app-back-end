INSERT INTO configuracoes(
            id, data_criacao, email_parceiro_convite)
    VALUES (1, '2017-09-09', 'admin2@admin.com');

INSERT INTO pessoa(
            id, data_criacao, email, nome, perfil, senha, configuracoes_id)
    VALUES (1, '2017-09-05', 'admin@admin.com', 'ADMIN', 'ROLE_ADMIN', '$2a$10$w/qm49iZ/iPGNnyQh8kRUe3gRqTh7k5u6ylexSSpLqxow5acRZkpe', 1);

INSERT INTO lista_tarefas(
            id, data_criacao, descricao, modelo, tipo_lista, titulo, criador_id)
    VALUES (1, '2017-09-08', '', true, 'LOUCA', 'Lavar louça 7 dias', 1);


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

