CREATE TABLE MOTORISTAS (
    id UUID PRIMARY KEY,
    nome TEXT NOT NULL,
    cpfcnpj TEXT NOT NULL,
    setor TEXT,
    ativo BOOLEAN
);