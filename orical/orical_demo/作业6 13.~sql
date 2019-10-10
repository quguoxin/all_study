-------------------------------t1---------------------------------------------
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

-----------------------------------t2-------------------------------------------
drop table userinfo;
create table userinfo(
"Uid" number(9) primary key,
uname varchar(30),
upass varchar2(30)
);
comment on table userinfo is '用户信息表';
comment on column userinfo.uid is '用户id';-- Uid有问题，此条不运行
comment on column userinfo.uname is '用户姓名';
comment on column userinfo.upass is '用户密码';
begin
  for i in 1 .. 100 loop
    insert into userinfo
    values
      (to_char(ceil(dbms_random.value(0, 999999999)), '000000009'), -- 编号9位
       DBMS_RANDOM.STRING('l', 5), -- 用户名5位随机小写字母
       DBMS_RANDOM.STRING('x', 8)); -- 密码大写+数字随机8位
  end loop;
end;
select * from userinfo;

----------------------------------t3------------------------------------
create table temp_user(
username varchar(30),
userage number
);
comment on table temp_user is '用户信息表';
comment on column temp_user.username is '用户姓名';
comment on column temp_user.userage is '用户年龄';
-- 插入数据
begin
  for i in 1 .. 50 loop
    insert into temp_user
    values
      (DBMS_RANDOM.STRING('l', 5), -- 用户名5位随机小写字母
      ceil(dbms_random.value(0, 99))); -- 年龄
  end loop;
end;

select * from temp_user;

-- 查询>25岁的
declare
  --声明游标类型
  type ref_cur_user is ref cursor return temp_user%rowtype;
  --定义变量
  v_my ref_cur_user;
  --定义一个可以接收数据的变量
  v_obj temp_user%rowtype;
begin
  --打开游标
  open v_my for
    select t.username, t.userage from temp_user t where t.userage > 25;
  -- 循环提取
  loop
    fetch v_my
      into v_obj;
  
    -- 循环退出条件
    if v_my%found then
      dbms_output.put_line('姓名：' || v_obj.USERNAME || '，年龄：' ||
                           v_obj.USERAGE);
    else
      exit;
    end if;
  end loop;
  close v_my;
end;

-----------------------------------t4-----------------------------------------
-- 银行卡：621700开头+13位随机数字,产生20张卡号，打印在控制台
begin
  for i in 1 .. 20 loop
    dbms_output.put_line('621700'||to_char(ceil(dbms_random.value(0, 9999999999999)),'0000000000009'));
  end loop;
end;

-----------------------------------t5-----------------------------
--对emp表中job='CLERK'的信息打印至控制台
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
-----------------------------------t6---------------------------------
--实现使用游标从sales表中读取销售额大于2000，且小于4000，且6月份的销售记录
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
-----------------------------------t7---------------------------------------
/*综合练习：
使用plsql编写语句块完成转账功能，
声明一个转账卡号变量初始为621700 0000443140952,转账金额变量初始值为10000，
接收转账卡号为621700 0000085434276,执行转账时需要对卡号进行验证是否在数据中存在，
不存在在控制台打印卡号不存在，存在则执行转账功能*/

create table bank(
cardno nvarchar2(30),
balance number
);
comment on table bank is '用户信息表';
comment on column bank.cardno is '卡号';
comment on column bank.balance is '余额';
insert into bank (cardno, balance) values ('6217000000443140952', 10000);
insert into bank (cardno, balance) values ('6217000000085434276', 10000);

-- select * from bank;


declare
  cardno1 nvarchar2(30) := '6217000000443140952'; -- 卡1
  cardno2 nvarchar2(30) := '6217000000085434276'; -- 卡2
  money   number := 1000; -- 转账金额
  number1 number := 0;
  cursor cur_bank is
    select *
      from bank
     where bank.cardno = cardno1  -- 查询出转账的两张卡号
        or bank.cardno = cardno2;
  v_no      nvarchar2(30);
  v_balance number;
begin
-- 开事物
--start transaction;
  for obj in cur_bank loop
    number1 := number1 + 1; -- 利用循环判断有几条数据
  end loop;
  
  if number1 = 2 then   -- 只有存在且只存在两条时才会进行转账操作否则转账失败
    update bank
       set balance = bank.balance - money
     where bank.cardno = cardno1;
    update bank
       set balance = bank.balance + money
     where bank.cardno = cardno2;
    dbms_output.put_line('转账成功！请查询！');
  else                  --  其中一张或者两张卡号不存在
    dbms_output.put_line('卡号不存在！');
  end if;
  commit;   -- 提交事物
  Exception when others then
  rollback; -- 事物回滚
end;

-- select * from bank;




















