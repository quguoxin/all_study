-- �γ̱�
create table   subject(
subjectid  number (4) primary key ,
subjectname nvarchar2(20) not null , 
classhour number(4) default'0' not null,
gradeid number(4) not null  
);
comment on column subject.subjectid is '��Ŀ���,��ʶ��';
comment on column subject.subjectname is '��Ŀ����';
comment on column subject.classhour is 'ѧʱ';
comment on column subject.gradeid is'�����꼶';
alter table subject add constraint sub_gra_fk foreign key (gradeid) references grade (gradeId);
insert into subject
  (subjectid, subjectname, classhour, gradeid)
values
  (1, '�������', 40, 1);
insert into subject
  (subjectid, subjectname, classhour, gradeid)
values
  (2, 'HTML����', 60, 1);


-- �ɼ���
drop table result;
create table  result(
ID  number(4) primary key ,
studentno  NVarchar2(50) not null ,
subjectid number(4) not null  ,
studentresult number(4) default'0' not null ,
examdate date not null 
);
comment on column result.id is '��ʶ�� ����';
comment on column result.studentno is 'ѧ��';
comment on column result.subjectid is '������Ŀ';
comment on column result.studentresult is '����';
comment on column result.examdate is '��������';
create sequence seq_id;
alter table result add constraint res_stu_fk foreign key(studentno) references student (studentno);
alter table result add constraint res_sub_fk foreign key(subjectid) references subject (subjectid);




-- �꼶��
create table  grade(
gradeID number(4) primary key ,
gradename nvarchar2(50) not null 
);
comment on column grade.gradeID is '��ʶ�� �꼶���';
comment on column grade.gradename is '�꼶��';
insert into grade (gradeid, gradename) values (1, '��һ');
insert into grade (gradeid, gradename) values (2, '���');
insert into grade (gradeid, gradename) values (3, '����');




-- ѧ����
create table  student(
studentno  NVarchar2(50) not null primary key,
loginpwd   NVarchar2(20)  default'123456' not null  ,
studentname  nvarchar2(50) not null ,
sex nvarchar2(50) not null ,
gradeID number(4)  not null ,
phone nvarchar2(255) not null ,
adress nvarchar2(255) default'ѧ������',
borndate date,
email NVarchar2(50)
);
comment on column student.studentno is 'ѧ��,����';
comment on column student.loginpwd  is '����';
comment on column student.studentname is '����';
comment on column student.sex is '�Ա�';
comment on column student.gradeID is '�����꼶';
comment on column student.phone is '��ϵ�绰';
comment on column student.adress is '��ס��ַ';
comment on column student.borndate is '��������';
comment on column student.email is '�����ʼ�';
alter table student add constraint stu_gra_fk foreign key(gradeID) references grade (gradeID);
