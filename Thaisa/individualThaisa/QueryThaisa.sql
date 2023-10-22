CREATE DATABASE if not exists IndividualThaisa;
USE IndividualThaisa;

CREATE TABLE CapturaDeDados(
idCaptura int primary key auto_increment,
MemoriaEmUso varchar(100),
FrequenciaProcessador varchar(100),
UsoProcessador varchar(100),
TamanhoMemoria varchar(100)
);

select * from CapturaDeDados;