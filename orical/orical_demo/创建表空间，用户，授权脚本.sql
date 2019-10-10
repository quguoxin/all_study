create tablespace demo
datafile 'D:\app\Administrator\oradata\orcl\demo.dbf'
size 100M;

create user quguoxin
identified by 1234
default tablespace demo;

grant connect,resource,create table to quguoxin
