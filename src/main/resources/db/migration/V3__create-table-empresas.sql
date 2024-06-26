CREATE TABLE EMPRESAS (
    id UUID PRIMARY KEY,
    nome TEXT NOT NULL,
    razao TEXT NOT NULL,
    cnpj TEXT NOT NULL,
    telefone TEXT NOT NULL,
    email TEXT NOT NULL,
    endereco TEXT NOT NULL,
    site TEXT,
    ativo BOOLEAN
);