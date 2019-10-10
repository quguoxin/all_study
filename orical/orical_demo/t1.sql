drop table grade;
create table grade(
gradeid  number(4) primary key,
gradename nvarchar2(50)  not null
);
comment on column grade.gradeid is '年级编号';
comment on column grade.gradename is '年级名称';
create sequence seq_grade;
insert into grade (gradeid,gradename) values (seq_grade.nextval,'大一');
insert into grade (gradeid,gradename) values (seq_grade.nextval,'大二');
select * from grade ;

