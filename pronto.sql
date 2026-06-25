CREATE TABLE competicao (
    cnpj VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE equipe (
    cnpj VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100)
);

CREATE TABLE partidas (
    id SERIAL PRIMARY KEY,

    cnpj_equipe_casa VARCHAR(20),
    cnpj_equipe_visitante VARCHAR(20),
    cnpj_competicao VARCHAR(20),

    data DATE,
    horario TIME,
    local VARCHAR(100),

    placar_casa INT,
    placar_visitante INT,

    FOREIGN KEY (cnpj_equipe_casa) REFERENCES equipe(cnpj),
    FOREIGN KEY (cnpj_equipe_visitante) REFERENCES equipe(cnpj),
    FOREIGN KEY (cnpj_competicao) REFERENCES competicao(cnpj),

    CHECK (cnpj_equipe_casa <> cnpj_equipe_visitante)
);

INSERT INTO competicao VALUES ('1', 'Copa');
INSERT INTO equipe VALUES ('10', 'Time A', 'SP');
INSERT INTO equipe VALUES ('20', 'Time B', 'RJ');

INSERT INTO partidas (
    cnpj_equipe_casa,
    cnpj_equipe_visitante,
    cnpj_competicao,
    placar_casa,
    placar_visitante
) VALUES ('10', '20', '1', 2, 1);