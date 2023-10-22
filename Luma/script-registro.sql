create database if not exists mindbridge_individual;
use mindbridge_individual;

CREATE TABLE if not exists registroMaquina(
idRegistroMaquina INT PRIMARY KEY AUTO_INCREMENT,
usoRam DOUBLE,
usoProcessador DOUBLE,
tempProc DOUBLE,
totalDisco DOUBLE,
dispositivosUSB INTEGER,
dtHora TIMESTAMP NOT NULL default current_timestamp
);

-- select * from registroMaquina;