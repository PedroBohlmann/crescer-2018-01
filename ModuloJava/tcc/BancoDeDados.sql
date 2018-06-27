CREATE TABLE USUARIO(
    ID_USUARIO NUMBER(10) NOT NULL,
    NOME_COMPLETO VARCHAR2(255) NOT NULL,
    EMAIL VARCHAR2(255) NOT NULL,
    APELIDO VARCHAR2(50),
    DATA_DE_NASCIMENTO DATE NOT NULL,
    SENHA VARCHAR2(128) NOT NULL,
    IMAGEM_DE_PERFIL VARCHAR2(512)
);

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY(ID_USUARIO);

CREATE SEQUENCE USUARIO_SEQ;

CREATE TABLE POST(
    ID_POST NUMBER(10) NOT NULL,
    ID_USUARIO NUMBER(10) NOT NULL,
    TEXTO VARCHAR2(512) NOT NULL
);
ALTER TABLE POST ADD CONSTRAINT POST_PK PRIMARY KEY(ID_POST);
ALTER TABLE POST ADD CONSTRAINT USUARIO_FK FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);

CREATE SEQUENCE POST_SEQ;

CREATE TABLE CURTIDA(
    ID_CURTIDA NUMBER(10) NOT NULL,
    ID_USUARIO NUMBER(10) NOT NULL,
    ID_POST NUMBER(10) NOT NULL
);

ALTER TABLE CURTIDA ADD CONSTRAINT CURTIDA_PK PRIMARY KEY (ID_CURTIDA);

ALTER TABLE CURTIDA ADD CONSTRAINT USUARIO_FK FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);
ALTER TABLE CURTIDA ADD CONSTRAINT POST_FK FOREIGN KEY (ID_POST) REFERENCES POST(ID_POST);

CREATE SEQUENCE CURTIDA_SEQ;

CREATE TABLE CONTATO(
    ID_CONTATO NUMBER(10) NOT NULL,
    ID_USUARIO NUMBER(10) NOT NULL,
    ID_USUARIO_CONVIDADO NUMBER(10) NOT NULL,
    STATUS_CONTATO VARCHAR2(20)
);

ALTER TABLE CONTATO ADD CONSTRAINT CONTATO_PK PRIMARY KEY (ID_CONTATO);

ALTER TABLE CONTATO ADD CONSTRAINT USUARIO_FK FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);

ALTER TABLE CONTATO ADD CONSTRAINT USUARIO_CONVIDADO_FK FOREIGN KEY(ID_USUARIO_CONVIDADO) REFERENCES USUARIO(ID_USUARIO);

CREATE SEQUENCE CONTATO_SEQ;