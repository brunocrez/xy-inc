CREATE TABLE public.pois
(
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(50) NOT NULL,
    X INTEGER NOT NULL,
	Y INTEGER NOT NULL 
    
);
ALTER TABLE public.pois
    OWNER to postgres;
    

INSERT INTO pois (NOME, X, Y) VALUES ('Lanchonete', 27, 12);
INSERT INTO pois (NOME, X, Y) VALUES ('Posto', 31, 18);
INSERT INTO pois (NOME, X, Y) VALUES ('Joalheria', 15, 12);
INSERT INTO pois (NOME, X, Y) VALUES ('Floricultura', 19, 21);
INSERT INTO pois (NOME, X, Y) VALUES ('Pub', 12, 8);
INSERT INTO pois (NOME, X, Y) VALUES ('Supermercado', 23, 6);
INSERT INTO pois (NOME, X, Y) VALUES ('Churrascaria', 28, 2);
