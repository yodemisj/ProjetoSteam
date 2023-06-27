
CREATE TABLE steamSede(
    nome VARCHAR2(50) NOT NULL,
    cidade VARCHAR2(50) NOT NULL,
    estado VARCHAR2(2) NOT NULL,
    pais VARCHAR2(100) NOT NULL,

    CONSTRAINT PK_STEAMSEDE PRIMARY KEY (nome)
);

CREATE TABLE steamControleEmpresa(
    nomeEmpresa VARCHAR2(50) NOT NULL,
    atribuicao VARCHAR2(20) NOT NULL,
    nomeSede VARCHAR2(50),
    
    CONSTRAINT PK_STEAMCONTROLEEMPRESA PRIMARY KEY (nomeEmpresa),
    CONSTRAINT CHK_ATRIBUICAOCONTROLEEMPRESA CHECK (atribuicao IN('Distribuidor', 'Desenvolvedor'))
);

CREATE TABLE steamDesenvolvedor(
    nome VARCHAR2(50) NOT NULL,
    presidente VARCHAR2(50) NOT NULL,
    dataFundacao DATE,
    fundador VARCHAR2(50),
    website VARCHAR2(150),
    
    CONSTRAINT PK_STEAMDESENVOLVEDOR PRIMARY KEY (nome),
    CONSTRAINT CHK_WEBSITEDEV CHECK (website LIKE 'www.%'),
    CONSTRAINT FK_STEAMDESENVOLVEDOR FOREIGN KEY (nome)
    REFERENCES steamControleEmpresa(nomeEmpresa)
    ON DELETE CASCADE
);

CREATE TABLE steamDistribuidor(
    nome VARCHAR2(50) NOT NULL,
    presidente VARCHAR2(50) NOT NULL,
    dataFundacao DATE,
    fundador VARCHAR2(50),
    website VARCHAR2(150),
    
    CONSTRAINT PK_STEAMDISTRIBUIDOR PRIMARY KEY (nome),
    CONSTRAINT CHK_WEBSITEDIST CHECK (website LIKE 'www.%'),
    CONSTRAINT FK_STEAMDISTRIBUIDOR FOREIGN KEY (nome)
    REFERENCES steamControleEmpresa(nomeEmpresa)
    ON DELETE CASCADE
);

CREATE TABLE steamJogo(
    nome VARCHAR2(50) NOT NULL,
    edicao VARCHAR2(20) NOT NULL,
    classificacao VARCHAR2(2) NOT NULL,
    genero VARCHAR2(20) NOT NULL,
    sinopse VARCHAR2(400) NOT NULL,
    preco DECIMAL(5,2) NOT NULL,
    nomeDesenvolvedor VARCHAR2(50),
    
    CONSTRAINT PK_STEAMJOGO PRIMARY KEY (nome),
    CONSTRAINT FK_STEAMJOGO FOREIGN KEY (nomeDesenvolvedor)
    REFERENCES steamDesenvolvedor(nome)
    ON DELETE SET NULL,
    CONSTRAINT CHK_GENEROJOGO CHECK (genero IN ('10', '12', '14', '16', '18', 'L'))
);

CREATE TABLE steamLinguagensJogo(
    nomeJogo VARCHAR2(50) NOT NULL,
    linguagem VARCHAR2(15) NOT NULL,
    
    CONSTRAINT PK_LINGUAGENS PRIMARY KEY (nomeJogo, linguagem),
    CONSTRAINT FK_LINGUAGENS FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome) 
    ON DELETE CASCADE
);

CREATE TABLE steamLegendasJogo(
    nomeJogo VARCHAR2(50) NOT NULL,
    legenda VARCHAR2(15) NOT NULL,
    
    CONSTRAINT PK_LEGENDAS PRIMARY KEY (nomeJogo, legenda),
    CONSTRAINT FK_LEGENDAS FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE
);


CREATE TABLE steamDistribuiJogo (
    nomeDistribuidor VARCHAR2(50) NOT NULL,
    nomeJogo VARCHAR2(50) NOT NULL,
    
    CONSTRAINT PK_STEAMDISTRIBUIJOGO PRIMARY KEY (nomeDistribuidor, nomeJogo),
    CONSTRAINT FK1_STEAMDISTRIBUIJOGO FOREIGN KEY (nomeDistribuidor)
    REFERENCES steamDistribuidor(nome)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMDISTRIBUIJOGO FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE
);