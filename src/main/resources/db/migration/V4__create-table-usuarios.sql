CREATE TABLE USUARIOS (
    id UUID PRIMARY KEY,
    nome TEXT NOT NULL,
    usuario TEXT NOT NULL,
    email TEXT NOT NULL,
    senha TEXT NOT NULL,
    telefone TEXT NOT NULL,
    datainc DATE,
    ativo BOOLEAN
);