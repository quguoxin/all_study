---------------------------------------过程-----------------------------------------------
create or replace procedure pro_emp(pro_job in varchar2   ) is
  v_empno  number(4);
  v_ename  varchar2(50);
  v_job    varchar2(50);
  v_depton number(4);
  cursor cur_emp2 is
    select emp.empno  as 工号,
           emp.ename  as 姓名,
           emp.job    as 工作,
           emp.deptno as 部门编号
      from emp
     where emp.job = pro_job;
begin
  for obj in cur_emp2 loop
    dbms_output.put_line('工号：' || obj.工号 || '，姓名：' || obj.姓名 || '，工作：' ||
                         obj.工作 || '，部门编号：' || obj.部门编号);
  end loop;
end;

-- 调用
begin
  -- Call the procedure
  pro_emp('clerk');
end;

--------------------------------------函数-----------------------------------------------
--对银行转账进行子程序函数封装  并调用
create or replace function fun_bank(fromcard nvarchar2,
                                    tocard   nvarchar2,
                                    money    number) return number as
  v_num   number(4);
  number1 number := 0;
  cursor cur_bank is
    select *
      from bank
     where bank.cardno = fromcard -- 查询出转账的两张卡号
        or bank.cardno = tocard;
  v_no      nvarchar2(30);
  v_balance number;
begin
  -- 开事物
  --start transaction;
  for obj in cur_bank loop
    number1 := number1 + 1; -- 利用循环判断有几条数据
  end loop;

  if number1 = 2 then
    -- 只有存在且只存在两条时才会进行转账操作否则转账失败
    update bank
       set balance = bank.balance - money
     where bank.cardno = fromcard;
    update bank
       set balance = bank.balance + money
     where bank.cardno = tocard;
    v_num := 1;
    return v_num;
  else
    --  其中一张或者两张卡号不存在
    v_num := 0;
    return v_num;
  end if;
  commit; -- 提交事物
  Exception when others then
  rollback; -- 事物回滚
end;

-- 调用
begin
  dbms_output.put_line(fun_bank(fromcard => '6217000000443140952',
                                tocard   => '6217000000085434276',
                                money    => 1000));
  commit;
end;


-----------------------------------/*包*/------------------------------------------------
-- 包头
create or replace package pkg_qgx as
-- 函数
function fun_bank(fromcard nvarchar2,
                                    tocard   nvarchar2,
                                    money    number) return number ;
-- 过程                                    
procedure pro_emp(pro_job in varchar2   );
end;

--包体
create or replace package body pkg_qgx as

  -- 实现函数
  function fun_bank(fromcard nvarchar2, tocard nvarchar2, money number)
    return number as
    v_num   number(4);
    number1 number := 0;
    cursor cur_bank is
      select *
        from bank
       where bank.cardno = fromcard -- 查询出转账的两张卡号
          or bank.cardno = tocard;
    v_no      nvarchar2(30);
    v_balance number;
  begin
    -- 开事物
    --start transaction;
    for obj in cur_bank loop
      number1 := number1 + 1; -- 利用循环判断有几条数据
    end loop;
  
    if number1 = 2 then
      -- 只有存在且只存在两条时才会进行转账操作否则转账失败
      update bank
         set balance = bank.balance - money
       where bank.cardno = fromcard;
      update bank
         set balance = bank.balance + money
       where bank.cardno = tocard;
      v_num := 1;
      return v_num;
    else
      --  其中一张或者两张卡号不存在
      v_num := 0;
      return v_num;
    end if;
    commit; -- 提交事物
  Exception
    when others then
      rollback; -- 事物回滚
  end;
  

  -- 实现过程
  procedure pro_emp(pro_job in varchar2) as
    v_empno  number(4);
    v_ename  varchar2(50);
    v_job    varchar2(50);
    v_depton number(4);
    cursor cur_emp2 is
      select emp.empno  as 工号,
             emp.ename  as 姓名,
             emp.job    as 工作,
             emp.deptno as 部门编号
        from emp
       where emp.job = pro_job;
  begin
    for obj in cur_emp2 loop
      dbms_output.put_line('工号：' || obj.工号 || '，姓名：' || obj.姓名 || '，工作：' ||
                           obj.工作 || '，部门编号：' || obj.部门编号);
    end loop;
  end;

end pkg_qgx;

-- 调用
begin 
 pkg_qgx.pro_emp('clerk');
 dbms_output.put_line(pkg_qgx.fun_bank('6217000000443140952','6217000000085434276',1000));                               
end;
