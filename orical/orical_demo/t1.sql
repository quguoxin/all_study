drop table grade;
create table grade(
gradeid  number(4) primary key,
gradename nvarchar2(50)  not null
);
comment on column grade.gradeid is '�꼶���';
comment on column grade.gradename is '�꼶����';
create sequence seq_grade;
insert into grade (gradeid,gradename) values (seq_grade.nextval,'��һ');
insert into grade (gradeid,gradename) values (seq_grade.nextval,'���');
select * from grade ;

