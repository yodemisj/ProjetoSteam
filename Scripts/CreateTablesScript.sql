
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
    CONSTRAINT CHK_CLASSIFICACAO CHECK (classificacao IN ('10', '12', '14', '16', '18', 'L'))
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


CREATE TABLE steamDistribuiJogo(
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

CREATE TABLE steamUsuario(
    cpf VARCHAR2(11) NOT NULL,
    nome VARCHAR2(100) NOT NULL,
    email VARCHAR2(150),
    pais VARCHAR2(80),
    
    CONSTRAINT PK_STEAMUSUARIO PRIMARY KEY (cpf),
    CONSTRAINT CHK_EMAIL CHECK (email LIKE '%@mail.com')
);

CREATE TABLE steamControleConta(
    login VARCHAR2(150) NOT NULL,
    tipo VARCHAR2(15) NOT NULL,
    
    CONSTRAINT PK_STEAMCONTROLECONTA PRIMARY KEY (login),
    CONSTRAINT CHK_LOGIN CHECK (login LIKE '%@mail.com'),
    CONSTRAINT CHK_TIPO CHECK (tipo IN ('ContaPrincipal', 'SubConta'))
);

CREATE TABLE steamPergunta(
    pergunta VARCHAR2(200) NOT NULL,
    resposta VARCHAR2(200) NOT NULL,
    
    CONSTRAINT FP_STEAMPERGUNTA PRIMARY KEY (pergunta)
);

CREATE TABLE steamContaPrincipal(
    login VARCHAR2(150) NOT NULL,
    nickname VARCHAR2(50) NOT NULL,
    senha VARCHAR2(50) NOT NULL,
    pergunta VARCHAR2(200) NOT NULL,
    cpfUsuario VARCHAR2(11) NOT NULL,
    
    CONSTRAINT PK_STEAMCONTAPRINCIPAL PRIMARY KEY (login),
    CONSTRAINT FK1_STEAMCONTAPRINCIPAL FOREIGN KEY (login)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONTAPRINCIPAL FOREIGN KEY (pergunta)
    REFERENCES steamPergunta(pergunta)
    ON DELETE CASCADE,
    CONSTRAINT FK3_STEAMCONTAPRINCIPAL FOREIGN KEY (cpfUsuario)
    REFERENCES steamUsuario(cpf)
    ON DELETE CASCADE
);

CREATE TABLE steamPerguntaSubConta(
    pergunta VARCHAR2(200) NOT NULL,
    resposta VARCHAR2(200) NOT NULL,
    
    CONSTRAINT FP_STEAMPERGUNTASUBCONTA PRIMARY KEY (pergunta)
);

CREATE TABLE steamSubConta(
    login VARCHAR2(150) NOT NULL,
    nickname VARCHAR2(50) NOT NULL,
    senha VARCHAR2(50) NOT NULL,
    pergunta VARCHAR2(200) NOT NULL,
        
    CONSTRAINT PK_STEAMSUBCONTA PRIMARY KEY(login),
    CONSTRAINT FK1_STEAMSUBCONTA FOREIGN KEY (login)
    REFERENCES steamContaPrincipal(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMSUBCONTA FOREIGN KEY (pergunta)
    REFERENCES steamPerguntaSubConta(pergunta)
    ON DELETE CASCADE
);

CREATE TABLE steamSubContaPermissoes(
    login VARCHAR2(150) NOT NULL,
    acessaConteudoImproprio NUMBER,
    compraConteudoImproprio NUMBER,
    acessaJogos NUMBER,
    compraJogos NUMBER,
    
    CONSTRAINT PK_STEAMSUBCONTAPERMISSOES PRIMARY KEY (login),
    CONSTRAINT FK_STEAMSUBCONTAPERMISSOES FOREIGN KEY (login)
    REFERENCES steamSubConta(login)
    ON DELETE CASCADE,
    CONSTRAINT CHK_BOOL_CONTEUDOIMPROPRIO CHECK (acessaConteudoImproprio IN (1, 0)),
    CONSTRAINT CHK_BOOL_COMPRACONTEUDOIMPROPRIO CHECK (compraConteudoImproprio IN (1, 0)),
    CONSTRAINT CHK_BOOL_ACESSAJOGOS CHECK (acessaJogos IN (1, 0)),
    CONSTRAINT CHK_BOOL_COMPRAJOGOS CHECK (compraJogos IN (1, 0))
);

CREATE TABLE steamAmizade(
    loginContaSolicita VARCHAR2(150) NOT NULL,
    loginContaRecebe VARCHAR2(150) NOT NULL,
    dataSolicitacao TIMESTAMP,
    dataAceite TIMESTAMP,
    dataDesfaz TIMESTAMP,
    
    CONSTRAINT PK_STEAMAMIZADE PRIMARY KEY (loginContaSolicita, loginContaRecebe),
    CONSTRAINT FK1_STEAMAMIZADE FOREIGN KEY (loginContaSolicita)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMAMIZADE FOREIGN KEY (loginContaRecebe)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE
);

CREATE TABLE steamCartaoDeCredito(
    numero NUMBER (16) NOT NULL,
    bandeira VARCHAR2(20) NOT NULL,
    dataVenc DATE NOT NULL,
    nomeCartao VARCHAR2(100),
    loginContaPrincipal VARCHAR2(150),
    
    CONSTRAINT PK_STEAMCARTAODECREDITO PRIMARY KEY (numero),
    CONSTRAINT FK_STEAMCARTAODECREDITO FOREIGN KEY (loginContaPrincipal)
    REFERENCES steamContaPrincipal(login)
    ON DELETE CASCADE
);

CREATE TABLE steamPlataforma(
    id INTEGER NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    versao VARCHAR2(20) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    
    CONSTRAINT PK_STEAMPLATAFORMA PRIMARY KEY (id)
);

CREATE TABLE steamConsoleUsuario (
    numeroSerie NUMBER(8) NOT NULL,
    cpfUsuario VARCHAR(11) NOT NULL,
    idPlataforma INTEGER NOT NULL,
    
    CONSTRAINT PK_STEAMCONSOLEUSUARIO PRIMARY KEY (numeroSerie),
    CONSTRAINT FK1_STEAMCONSOLEUSUARIO FOREIGN KEY (cpfUsuario)
    REFERENCES steamUsuario(cpf)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONSOLEUSUARIO FOREIGN KEY (idPlataforma)
    REFERENCES steamPlataforma(id)   
);

CREATE TABLE steamContaUsaConsole (
    loginConta VARCHAR2(150) NOT NULL,
    numeroSerieConsole NUMBER(8) NOT NULL,
    
    CONSTRAINT PK_STEAMCONTAUSACONSOLE PRIMARY KEY (loginConta, numeroSerieConsole),
    CONSTRAINT FK_1STEAMCONTAUSACONSOLE FOREIGN KEY (loginConta)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONTAUSACONSOLE FOREIGN KEY (numeroSerieConsole)
    REFERENCES steamConsoleUsuario(numeroSerie)
    ON DELETE CASCADE
);

CREATE TABLE steamJogoLancadoPlataforma(
    nomeJogo VARCHAR2(50) NOT NULL,
    idPlataforma INTEGER NOT NULL,
    dataLancamento TIMESTAMP,
    
    CONSTRAINT PK_STEAMJOGOLANCADOPLATAFORMA PRIMARY KEY (nomeJogo, idPlataforma),
    CONSTRAINT FK1_STEAMJOGOLANCADOPLATAFORMA FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMJOGOLANCADOPLATAFORMA FOREIGN KEY (idPlataforma)
    REFERENCES steamPlataforma(id)
    ON DELETE CASCADE
);

CREATE TABLE steamContaCompraJogo(
    id INTEGER NOT NULL,
    data TIMESTAMP NOT NULL,
    licenca VARCHAR2(12) NOT NULL,
    loginContaPrincipal VARCHAR2(150) NOT NULL,
    nomeJogo VARCHAR2(50) NOT NULL,
    
    CONSTRAINT PK_STEAMCONTACOMPRAJOGO PRIMARY KEY (id),
    CONSTRAINT FK1_STEAMCONTACOMPRAJOGO FOREIGN KEY (loginContaPrincipal)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONTACOMPRAjOGO FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE
);


CREATE TABLE steamConteudos(
    nome VARCHAR2(50) NOT NULL,
    preco DECIMAL(5, 2) NOT NULL,
    nomeJogo VARCHAR2(50) NOT NULL,
    informacao VARCHAR2(100),
    
    CONSTRAINT PK_STEAMCONTEUDOS PRIMARY KEY (nome, nomeJogo),
    CONSTRAINT FK_STEAMCONTEUDOS FOREIGN KEY (nomejogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE
);

CREATE TABLE steamContaCompraConteudo(
    data TIMESTAMP NOT NULL,
    loginConta VARCHAR2(150) NOT NULL,
    nomeConteudo VARCHAR2(50) NOT NULL,
    nomeJogo VARCHAR2(50) NOT NULL,
    quantidade INTEGER NOT NULL,
    precoTotal DECIMAL(5, 2) NOT NULL,
    
    CONSTRAINT PK_CONTACOMPRAJOGO PRIMARY KEY (data, loginConta, nomeConteudo, nomeJogo),
    CONSTRAINT FK1_CONTACOMPRAJOGO FOREIGN KEY (loginConta)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_CONTACOMPRAJOGO FOREIGN KEY (nomeConteudo, nomeJogo)
    REFERENCES steamConteudos(nome, nomeJogo)
    ON DELETE CASCADE
);

--CREATE TABLE steamConsoleInstalaCompraJogo(
--   id INTEGER NOT NULL,
--   data TIMESTAMP NOT NULL,
--   numeroSerieConsole NUMBER(8),
--   idCompra INTEGER NOT NULL,
--   
--   CONSTRAINT PK_CONSOLEINSTALACOMPRAJOGO PRIMARY KEY (id),
--   CONSTRAINT FK1_CONSOLEINSTALACOMPRAJOGO FOREIGN KEY (numeroSerieConsole)
--   REFERENCES steamConsoleUsuario(numeroSerie)
--   ON DELETE CASCADE,
--   CONSTRAINT FK2_CONSOLEINSTALACOMPRAJOGO FOREIGN KEY (idCompra)
--   REFERENCES steamContaCompraJogo(id)
--   ON DELETE CASCADE
--);


CREATE TABLE steamConsoleInstalaCompra(
   id INTEGER NOT NULL,
   data TIMESTAMP NOT NULL,
   numeroSerieConsole NUMBER(8) NOT NULL,
   idCompra INTEGER NOT NULL,
   
   CONSTRAINT PK_STEAMCONSOLEINSTALACOMPRA PRIMARY KEY (id),
   CONSTRAINT UK_STEAMCONSOLEINSTALACOMPRA UNIQUE (numeroSerieConsole, idCompra)
);


CREATE TABLE steamContaJogaInstala(
    loginContaControle VARCHAR2(150) NOT NULL,
    idConsoleInstalaCompra INTEGER NOT NULL,
    
    CONSTRAINT FK_STEAMCONTAJOGAINSTALA PRIMARY KEY (loginContaControle, idConsoleInstalaCompra),
    CONSTRAINT FK1_STEAMCONTAJOGAINSTALA FOREIGN KEY (loginContaControle)
    REFERENCES steamControleConta(login)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONTAJOGAINSTALA FOREIGN KEY (idConsoleInstalaCompra)
    REFERENCES steamConsoleInstalaCompra(id)
    ON DELETE CASCADE
);


CREATE TABLE steamTrofeu(
    tipo VARCHAR2(50) NOT NULL,
    nomeJogo VARCHAR(50) NOT NULL,
    descricao VARCHAR2(200) NOT NULL,
    
    CONSTRAINT PK_STEAMTROFEU PRIMARY KEY (tipo, nomeJogo),
    CONSTRAINT FK_STEAMTROFEU FOREIGN KEY (nomeJogo)
    REFERENCES steamJogo(nome)
    ON DELETE CASCADE
);


CREATE TABLE steamContaConquista(
    loginContaControle VARCHAR2(150) NOT NULL,
    idConsoleInstalaCompra INTEGER NOT NULL,
    data TIMESTAMP NOT NULL,
    tipoTrofeu VARCHAR(50) NOT NULL,
    nomeJogoTrofeu VARCHAR(50) NOT NULL,
    
    CONSTRAINT PK_STEAMCONTACONQUISTA PRIMARY KEY (loginContaControle, idConsoleInstalaCompra, data, tipoTrofeu, nomeJogoTrofeu),
    CONSTRAINT FK1_STEAMCONTACONQUISTA FOREIGN KEY (loginContaControle, idConsoleInstalaCompra)
    REFERENCES steamContaJogaInstala(loginContaControle, idConsoleInstalaCompra)
    ON DELETE CASCADE,
    CONSTRAINT FK2_STEAMCONTACONQUISTA FOREIGN KEY (tipoTrofeu, nomeJogoTrofeu)
    REFERENCES steamTrofeu(tipo, nomeJogo)
    ON DELETE CASCADE
);
