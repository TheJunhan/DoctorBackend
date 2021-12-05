
create table if not exists `tuple`(
    id int unsigned auto_increment primary key,
    userId int,
    fixedId int,
    MutationLocation varchar(128),
    illType varchar(128),
    MutationType varchar(128),
    Genotype varchar(128),
    Region varchar(128),
    Nucleotide varchar(128),
    aminoAcid varchar(128),
    Aptt varchar(128),
    VWFAg varchar(128),
    VWFAct varchar(128),
    RIPA varchar(128),
    FVIII varchar(128),
    VWFCB varchar(128),
    VWFPP varchar(128),
    BloodType varchar(16),
    age varchar(16),
    gender varchar(16),
    BS varchar(128),
    Reference varchar(128),
    Comments varchar(128)
);

create table if not exists `user` (
    id int unsigned auto_increment primary key ,
    email varchar(32),
    password varchar(64)
);