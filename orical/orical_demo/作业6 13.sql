-------------------------------t1---------------------------------------------
/*��дPL/SQL��ʵ�����¹��ܣ�
��ȡ��ǰʱ����·ݡ�
�����1��3֮������ʾ��һ�������ӹ������С�
�����4��6֮������ʾ�����������ӹ���æµ��
�����7��9֮������ʾ�����������ӹ�����ľ��
�����10��12֮������ʾ���ļ������ӹ��ñ��š�*/
declare
  V_month number(4) := extract(MONTH from sysdate);
begin
  if V_month <= 3 and v_month >= 1 then
    dbms_output.put_line('һ�������ӹ�������');
  elsif V_month <= 6 and v_month >= 4 then
    dbms_output.put_line('���������ӹ���æµ');
  elsif V_month <= 9 and v_month >= 7 then
    dbms_output.put_line('���������ӹ�����ľ');
  elsif V_month <= 12 and v_month >= 10 then
    dbms_output.put_line('�ļ������ӹ��ñ���');
  end if;
end;

-----------------------------------t2-------------------------------------------
drop table userinfo;
create table userinfo(
"Uid" number(9) primary key,
uname varchar(30),
upass varchar2(30)
);
comment on table userinfo is '�û���Ϣ��';
comment on column userinfo.uid is '�û�id';-- Uid�����⣬����������
comment on column userinfo.uname is '�û�����';
comment on column userinfo.upass is '�û�����';
begin
  for i in 1 .. 100 loop
    insert into userinfo
    values
      (to_char(ceil(dbms_random.value(0, 999999999)), '000000009'), -- ���9λ
       DBMS_RANDOM.STRING('l', 5), -- �û���5λ���Сд��ĸ
       DBMS_RANDOM.STRING('x', 8)); -- �����д+�������8λ
  end loop;
end;
select * from userinfo;

----------------------------------t3------------------------------------
create table temp_user(
username varchar(30),
userage number
);
comment on table temp_user is '�û���Ϣ��';
comment on column temp_user.username is '�û�����';
comment on column temp_user.userage is '�û�����';
-- ��������
begin
  for i in 1 .. 50 loop
    insert into temp_user
    values
      (DBMS_RANDOM.STRING('l', 5), -- �û���5λ���Сд��ĸ
      ceil(dbms_random.value(0, 99))); -- ����
  end loop;
end;

select * from temp_user;

-- ��ѯ>25���
declare
  --�����α�����
  type ref_cur_user is ref cursor return temp_user%rowtype;
  --�������
  v_my ref_cur_user;
  --����һ�����Խ������ݵı���
  v_obj temp_user%rowtype;
begin
  --���α�
  open v_my for
    select t.username, t.userage from temp_user t where t.userage > 25;
  -- ѭ����ȡ
  loop
    fetch v_my
      into v_obj;
  
    -- ѭ���˳�����
    if v_my%found then
      dbms_output.put_line('������' || v_obj.USERNAME || '�����䣺' ||
                           v_obj.USERAGE);
    else
      exit;
    end if;
  end loop;
  close v_my;
end;

-----------------------------------t4-----------------------------------------
-- ���п���621700��ͷ+13λ�������,����20�ſ��ţ���ӡ�ڿ���̨
begin
  for i in 1 .. 20 loop
    dbms_output.put_line('621700'||to_char(ceil(dbms_random.value(0, 9999999999999)),'0000000000009'));
  end loop;
end;

-----------------------------------t5-----------------------------
--��emp����job='CLERK'����Ϣ��ӡ������̨
declare
  cursor cur_emp2 is
    select emp.empno  as ����,
           emp.ename  as ����,
           emp.job    as ����,
           emp.deptno as ���ű��
      from emp
     where emp.job = 'clerk';
  v_empno  number;
  v_ename  varchar2(50);
  v_job    varchar2(50);
  v_depton number;
begin
  for obj in cur_emp2 loop
    dbms_output.put_line('���ţ�' || obj.���� || '��������' || obj.���� || '��������' ||
                         obj.���� || '�����ű�ţ�' || obj.���ű��);
  end loop;
end;
-----------------------------------t6---------------------------------
--ʵ��ʹ���α��sales���ж�ȡ���۶����2000����С��4000����6�·ݵ����ۼ�¼
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
    dbms_output.put_line('���ڣ�' || obj.NO || '�����۶' || obj.SELL);
  end loop;
end;
-----------------------------------t7---------------------------------------
/*�ۺ���ϰ��
ʹ��plsql��д�������ת�˹��ܣ�
����һ��ת�˿��ű�����ʼΪ621700 0000443140952,ת�˽�������ʼֵΪ10000��
����ת�˿���Ϊ621700 0000085434276,ִ��ת��ʱ��Ҫ�Կ��Ž�����֤�Ƿ��������д��ڣ�
�������ڿ���̨��ӡ���Ų����ڣ�������ִ��ת�˹���*/

create table bank(
cardno nvarchar2(30),
balance number
);
comment on table bank is '�û���Ϣ��';
comment on column bank.cardno is '����';
comment on column bank.balance is '���';
insert into bank (cardno, balance) values ('6217000000443140952', 10000);
insert into bank (cardno, balance) values ('6217000000085434276', 10000);

-- select * from bank;


declare
  cardno1 nvarchar2(30) := '6217000000443140952'; -- ��1
  cardno2 nvarchar2(30) := '6217000000085434276'; -- ��2
  money   number := 1000; -- ת�˽��
  number1 number := 0;
  cursor cur_bank is
    select *
      from bank
     where bank.cardno = cardno1  -- ��ѯ��ת�˵����ſ���
        or bank.cardno = cardno2;
  v_no      nvarchar2(30);
  v_balance number;
begin
-- ������
--start transaction;
  for obj in cur_bank loop
    number1 := number1 + 1; -- ����ѭ���ж��м�������
  end loop;
  
  if number1 = 2 then   -- ֻ�д�����ֻ��������ʱ�Ż����ת�˲�������ת��ʧ��
    update bank
       set balance = bank.balance - money
     where bank.cardno = cardno1;
    update bank
       set balance = bank.balance + money
     where bank.cardno = cardno2;
    dbms_output.put_line('ת�˳ɹ������ѯ��');
  else                  --  ����һ�Ż������ſ��Ų�����
    dbms_output.put_line('���Ų����ڣ�');
  end if;
  commit;   -- �ύ����
  Exception when others then
  rollback; -- ����ع�
end;

-- select * from bank;




















