--1.sql语句块

/*编写PL/SQL块实现如下功能：
获取当前时间的月份。
如果是1到3之间则显示”一季度日子过得悠闲”
如果是4到6之间则显示“二季度日子过得忙碌”
如果是7到9之间则显示“三季度日子过得麻木”
如果是10到12之间则显示”四季度日子过得奔放”*/
declare
  V_month number(4) := extract(MONTH from sysdate);
begin
  if V_month <= 3 and v_month >= 1 then
    dbms_output.put_line('一季度日子过得悠闲');
  elsif V_month <= 6 and v_month >= 4 then
    dbms_output.put_line('二季度日子过得忙碌');
  elsif V_month <= 9 and v_month >= 7 then
    dbms_output.put_line('三季度日子过得麻木');
  elsif V_month <= 12 and v_month >= 10 then
    dbms_output.put_line('四季度日子过得奔放');
  end if;
end;

-- 2.循环

-- for循环 产生19位数的银行卡号
begin
  for i in 1 .. 20 loop
    dbms_output.put_line('621700'||to_char(ceil(dbms_random.value(0, 9999999999999)),'0000000000009'));
  end loop;
end;

/*begin
  for i in 1 .. 20 loop
    dbms_output.put_line('621700'||ceil(dbms_random.value(1000000000000, 9999999999999)));
  end loop;
end;*/


--3.游标



-- 表emp中工作为clerk的人的信息
declare
  cursor cur_emp2 is
    select emp.empno  as 工号,
           emp.ename  as 姓名,
           emp.job    as 工作,
           emp.deptno as 部门编号
      from emp
     where emp.job = 'clerk';
  v_empno  number;
  v_ename  varchar2(50);
  v_job    varchar2(50);
  v_depton number;
begin
  for obj in cur_emp2 loop
    dbms_output.put_line('工号：' || obj.工号 || '，姓名：' || obj.姓名 || '，工作：' ||
                         obj.工作 || '，部门编号：' || obj.部门编号);
  end loop;
end;

/*declare
  cursor cur_emp2 is
    select *
      from emp
     where emp.job = 'clerk';
  v_empno  number;
  v_ename  varchar2(50);
  v_job    varchar2(50);
  v_depton number;
begin
  for obj in cur_emp2 loop
    dbms_output.put_line('工号：' || obj.EMPNO || '，姓名：' || obj.ENAME || '，工作：' ||
                         obj.JOB || '，部门编号：' || obj.DEPTNO);
  end loop;
end;*/



-- sals表中输出六月份业绩在2000-4000之间的信息
declare
  cursor cur_sals2 is
    select *
      from sals
     where sals.sell >= 2000
       and sals.sell <= 4000
       and substrb(sals.no, 6, 1) = 6;
  v_no   varchar2(50);
  v_sell number;
begin
  for obj in cur_sals2 loop
    dbms_output.put_line('日期：' || obj.NO || '，销售额：' || obj.SELL);
  end loop;
end;

--引用游标（自定义引用） 不能用for循环提取
declare
  --自定义声明游标类型
  type ref_cur_sals is ref cursor return sals%rowtype;
  --使用该游标类型定义一个变量
  v_my ref_cur_sals;
  --定义一个可以接收数据的变量
  v_obj sals%rowtype;
begin
  --打开游标
  open v_my for
    select *
      from sals
     where sals.sell >= 2000
       and sals.sell <= 4000
       and substrb(sals.no, 6, 1) = 6;
  -- 循环提取
  loop
    fetch v_my
      into v_obj;
    dbms_output.put_line('日期：' || v_obj.NO || '，销售额：' || v_obj.SELL);
    -- 循环退出条件
    if v_my%notfound then
      exit;
    end if;
  end loop;
  close v_my;
end;


