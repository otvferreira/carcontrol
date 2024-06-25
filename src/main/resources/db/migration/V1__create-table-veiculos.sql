CREATE TABLE VEICULOS (
    id UUID PRIMARY KEY,
    modelo TEXT NOT NULL,
    marca TEXT NOT NULL,
    placa TEXT NOT NULL,
    km_inicial TEXT,
    km_atual TEXT,
    data_inc DATE,
    ativo BOOLEAN,
    ocupado BOOLEAN
);
