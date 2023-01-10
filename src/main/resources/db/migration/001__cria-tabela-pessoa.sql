create table pessoa (
	id bigint not null auto_increment,
    nome varchar(100) not null,
    data_nascimento varchar(10) not null,
    endereço varchar(300),
    endereço_principal bit not null,
    
    primary key (id)
);