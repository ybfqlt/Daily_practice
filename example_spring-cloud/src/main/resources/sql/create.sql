drop database if exists cloudDB02;

create database cloudDB02 character set UTF8;

use cloudDB02;

create table dept
(
    deptno bigint not null primary key auto_increment,
    dname varchar(60),
    db_source varchar(60)
);

insert into dept(dname,db_source) values ('开发部',database()), ('人事部',database()),('财务部',database());


create database cloudDB03 character set UTF8;

use cloudDB03;

create table dept
(
    deptno bigint not null primary key auto_increment,
    dname varchar(60),
    db_source varchar(60)
);

insert into dept(dname,db_source) values ('开发部',database()), ('人事部',database()),('财务部',database());