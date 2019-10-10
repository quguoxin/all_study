-- 建表
create table emp(
empno number(4) primary key,
ename varchar2(50),
job varchar2(50),
deptno number(4)
);

-- 备注
comment on column emp.empno is '工号';
comment on column emp.ename is '姓名';
comment on column emp.job is '岗位';
comment on column emp.deptno is '部门编号';

-- 插入数据
insert into emp (empno, ename, job, deptno) values (7369, 'smith', 'clerk', 20);
insert into emp (empno, ename, job, deptno) values (7499, 'allen', 'salesman', 30);
insert into emp (empno, ename, job, deptno) values (7521, 'ward', 'salesman', 30);
insert into emp (empno, ename, job, deptno) values (7566, 'jones', 'manager', 20);
insert into emp (empno, ename, job, deptno) values (7654, 'martin', 'salesman', 30);
insert into emp (empno, ename, job, deptno) values (7698, 'black', 'manager', 30);
insert into emp (empno, ename, job, deptno) values (7782, 'clark', 'manager', 10);
insert into emp (empno, ename, job, deptno) values (7788, 'scott', 'analyst', 20);
insert into emp (empno, ename, job, deptno) values (7839, 'king', 'president', 10);
insert into emp (empno, ename, job, deptno) values (7844, 'turner', 'salesman', 30);
insert into emp (empno, ename, job, deptno) values (7876, 'adams', 'clerk', 20);
insert into emp (empno, ename, job, deptno) values (7900, 'james', 'clerk', 30);
insert into emp (empno, ename, job, deptno) values (7902, 'ford', 'analyst', 20);
insert into emp (empno, ename, job, deptno) values (7934, 'miller', 'clerk', 10);

-- 预览
select * from emp;

-- 行转列。。
select 
emp.job,
sum(decode(emp.deptno,10,1,0)) "10(DEPTNO)",
sum(decode(emp.deptno,20,1,0)) "20(DEPTNO)",
sum(decode(emp.deptno,30,1,0)) "30(DEPTNO)",
sum(decode(emp.deptno,40,1,0)) "40(DEPTNO)"
from emp
group by emp.job;
