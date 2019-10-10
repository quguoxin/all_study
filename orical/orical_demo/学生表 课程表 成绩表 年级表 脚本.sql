-- 课程表
create table   subject(
subjectid  number (4) primary key ,
subjectname nvarchar2(20) not null , 
classhour number(4) default'0' not null,
gradeid number(4) not null  
);
comment on column subject.subjectid is '科目编号,标识列';
comment on column subject.subjectname is '科目名称';
comment on column subject.classhour is '学时';
comment on column subject.gradeid is'所属年级';
alter table subject add constraint sub_gra_fk foreign key (gradeid) references grade (gradeId);
insert into subject
  (subjectid, subjectname, classhour, gradeid)
values
  (1, '软件测试', 40, 1);
insert into subject
  (subjectid, subjectname, classhour, gradeid)
values
  (2, 'HTML技术', 60, 1);


-- 成绩表
drop table result;
create table  result(
ID  number(4) primary key ,
studentno  NVarchar2(50) not null ,
subjectid number(4) not null  ,
studentresult number(4) default'0' not null ,
examdate date not null 
);
comment on column result.id is '标识列 自增';
comment on column result.studentno is '学号';
comment on column result.subjectid is '所考科目';
comment on column result.studentresult is '分数';
comment on column result.examdate is '考试日期';
create sequence seq_id;
alter table result add constraint res_stu_fk foreign key(studentno) references student (studentno);
alter table result add constraint res_sub_fk foreign key(subjectid) references subject (subjectid);




-- 年级表
create table  grade(
gradeID number(4) primary key ,
gradename nvarchar2(50) not null 
);
comment on column grade.gradeID is '标识列 年级编号';
comment on column grade.gradename is '年级名';
insert into grade (gradeid, gradename) values (1, '大一');
insert into grade (gradeid, gradename) values (2, '大二');
insert into grade (gradeid, gradename) values (3, '大三');




-- 学生表
create table  student(
studentno  NVarchar2(50) not null primary key,
loginpwd   NVarchar2(20)  default'123456' not null  ,
studentname  nvarchar2(50) not null ,
sex nvarchar2(50) not null ,
gradeID number(4)  not null ,
phone nvarchar2(255) not null ,
adress nvarchar2(255) default'学生宿舍',
borndate date,
email NVarchar2(50)
);
comment on column student.studentno is '学号,主键';
comment on column student.loginpwd  is '密码';
comment on column student.studentname is '姓名';
comment on column student.sex is '性别';
comment on column student.gradeID is '所在年级';
comment on column student.phone is '联系电话';
comment on column student.adress is '现住地址';
comment on column student.borndate is '出生日期';
comment on column student.email is '电子邮件';
alter table student add constraint stu_gra_fk foreign key(gradeID) references grade (gradeID);
