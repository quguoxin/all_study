
-- ��1���п���Ϣ��
create table bankcard(
bankcardNo varchar(19) primary key not null,
userid number(10) not null,
tradePassword varchar(6) not null,
currencyTypeId number(10) not null,
balance number(20,2) not null,
openMoney number(20,2) not null,
openDate timestamp not null,
isloss number(1) default 0 not null,
savingID number(11) not null,
availBalance number(20,2) default 20000 not null
);
comment on table bankcard is '���п���Ϣ��';
comment on column bankcard.bankcardNo is '19λ���ţ�����';
comment on column bankcard.userid is '�û���ţ������û���Ϣ��';
comment on column bankcard.tradePassword is '6λ���ֽ������룬MD5����';
comment on column bankcard.currencyTypeId is '�������ͣ����û������ͱ�';
comment on column bankcard.balance is '���';
comment on column bankcard.openMoney is '�����������һԪ';
comment on column bankcard.openDate is '�������ڣ���ʽYYYY-MM-DD HH:mm:ss';
comment on column bankcard.isloss is '�Ƿ��ʧ����ʧ1δ��ʧ0��Ĭ��0';
comment on column bankcard.savingID is '�������';
comment on column bankcard.availBalance is 'ÿ�����ƿ�ȡ��Ĭ��20000';
alter table bankcard add constraint ck_openMoney check (openMoney>=1);
alter table bankcard add constraint bank_user_fk foreign key(userid) references userinfo (userid);
alter table bankcard add constraint bank_curr_fk foreign key(currencytypeid) references currencytype (currencytypeid);
alter table bankcard add constraint bank_depo_fk foreign key(savingid) references deposit (savingid);
select * from bankcard
insert into bankcard values
  ('6217001111111111111', 2, '123456', 1, 100000, 100000, systimestamp, 0, 1, 20000);
insert into bankcard values
  ('6217002222222222222', 3, '654321', 1, 100000, 100000, systimestamp, 0, 1, 20000);

-- ��2�������ͱ�
create table currencytype( 
currencyTypeId number(10) primary key not null,
currencyTypeName varchar(20) 
);
comment on table currencytype is'�������ͱ�';
comment on column currencytype.currencytypeid is '�������ͣ�����';
comment on column currencytype.currencytypename is '�����������ƣ��磺����ң���Ԫ';
insert into currencytype  values (1, '�����');
insert into currencytype  values (2, '��Ԫ');
select * from currencytype
    
-- ��3 ������ͱ�
create table deposit(
savingID number(11) primary key not null,
savingName varchar(20) not null,
descrip varchar(50)
);
comment on table deposit is '������ͱ�';
comment on column deposit.savingid is '������ͱ��';
comment on column deposit.savingName is '�����������';
comment on column deposit.descrip is '�����������';
select * from deposit
insert into deposit (savingid, savingname, descrip)  values (1, '����', '����ʱȡ');
insert into deposit (savingid, savingname, descrip)  values (2, '����', '������ʱȡ');



-- ��4 ������Ϣ��
create table tradeinfo(
tradeno varchar(50) primary key  not null,
tradeDate timestamp not null,
tradeType number(11) not null,
tradeCardId varchar(19) not null,
acceptCardid varchar(19),
tradeMoney number(20,2) not null,
currencyTypeId number(11) not null,
tradeDirection number(11),
remark varchar(200)
);
comment on table tradeinfo is '������Ϣ��';
comment on column tradeinfo.tradeno is '������ˮ��tryyyyMMddhhmmss+6λ�����';
comment on column tradeinfo.tradeDate is '��������';
comment on column tradeinfo.tradeType is '�������ͣ�1��2ȡ�3ת�ˣ�4����';
comment on column tradeinfo.tradeCardId is '����';
comment on column tradeinfo.acceptCardid is '�Է��˺ţ�ת��ʱʹ�ã������������Ϳ�Ϊ��';
comment on column tradeinfo.tradeMoney is '���׽��';
comment on column tradeinfo.currencyTypeId is '���ױ���';
comment on column tradeinfo.tradeDirection is '���׷���-1����1����';
comment on column tradeinfo.remark is '��ע';
alter table tradeinfo add constraint tra_tra_fk foreign key(tradecardid) references bankcard (bankcardno);
alter table tradeinfo add constraint tra_acc_fk foreign key(acceptcardid) references bankcard (bankcardno);
alter table tradeinfo add constraint tra_cur_fk foreign key(currencytypeid) references currencytype (currencytypeid);
select * from tradeinfo

-- ��5�û���Ϣ��
create table userinfo(
userid number(10) primary key  not null,
username varchar(50) ,
sex number(1),
phone varchar(11) unique,
idCard varchar(18) unique,
address varchar(100) 
);
comment on table userinfo is '�û���Ϣ��';
comment on column userinfo.userid is '�û���ţ�����';
comment on column userinfo.username is '����';
comment on column userinfo.sex is '�Ա�1��0Ů';
comment on column userinfo.phone is '�ֻ����룬Ψһ';
comment on column userinfo.idCard is '���֤��Ψһ';
comment on column userinfo.address is 'סַ';
create sequence seq_userinfo;
select * from userinfo
insert into userinfo values
  (seq_userinfo.nextval, 'aaa', 1, '15090814407', '421002199212054511', '��������');
insert into userinfo values
  (seq_userinfo.nextval, 'bbb', 0, '15090814408', '421002199212054512', '��������');


---------------------------------��ͷ----------------------------------------------
create or replace package pkg_atm as
  --����һ�����/ȡ��õĹ���
 procedure pro_cunqukuan(cid in varchar2,xuan varchar2,money in number,msg out varchar2);
  --����һ�����ݿ��Ų�ѯ����
  function fun_getmoney(cid  varchar2) return number;
  --����һ��ת�˹���
  procedure pro_transf(c_from varchar2,c_to varchar2,c_money varchar2);
  --����һ����������(�����û���Ϣ���Ϳ���Ϣ)
  procedure pro_opencard(c_name varchar2,c_sex number,c_phone varchar2,c_address varchar2,c_idcard  varchar2,tradepwd  varchar2);
  --����һ����ӡ��¼����
  procedure pro_record(cid  varchar2,pageNo  number, pageSize  number);
end pkg_atm;

----------------------------------����-------------------------------------------

create or replace package body pkg_atm as

  ---------------------����һ�����/ȡ��õĹ���----------------------------------
  procedure pro_cunqukuan(cid   in varchar2,
                          xuan  varchar2,
                          money in number,
                          msg   out varchar2) as
    v_blance number; -- �������ŵ����
    v_num    number; -- ��ѯ����Ŀ
  begin
    select count(b.bankcardno)
      into v_num
      from bankcard b
     where b.bankcardno = cid;
    if v_num = 1 then
      select b.balance
      into v_blance
      from bankcard b
     where b.bankcardno = cid;
      if xuan = 1 then
        -- ��
        update bankcard
           set balance = bankcard.balance + money
         where bankcard.bankcardno = cid;
        -- ��¼
        insert into tradeinfo
          (tradeno,
           tradedate,
           tradetype,
           tradecardid,
           acceptcardid,
           trademoney,
           currencytypeid,
           tradedirection,
           remark)
        values
          (to_char(sysdate, 'yyyyMMddhh24miss') ||
           LTRIM(to_char(ceil(dbms_random.value(0, 999999)), '000009'),
                 ' '),
           systimestamp,
           1,
           cid,
           null,
           money,
           1,
           1,
           null);
      
        msg := '���ɹ����Ѿ��ɹ�Ϊ' || cid || '�����' || money;
      elsif xuan = 2 then
        -- ȡ
        if v_blance >= money then
          --�ж����
          update bankcard
             set balance = bankcard.balance - money
           where bankcard.bankcardno = cid;
          -- ��¼
          insert into tradeinfo
            (tradeno,
             tradedate,
             tradetype,
             tradecardid,
             acceptcardid,
             trademoney,
             currencytypeid,
             tradedirection,
             remark)
          values
            (to_char(sysdate, 'yyyyMMddhh24miss') ||
             LTRIM(to_char(ceil(dbms_random.value(0, 999999)), '000009'),
                   ' '),
             systimestamp,
             2,
             cid,
             null,
             money,
             1,
             -1,
             null);
          msg := 'ȡ��ɹ����Ѿ��ɹ���' || cid || 'ȡ����' || money;
        else
          -- ����
          msg := '������';
        end if;
      else
        -- xuan�������
        msg := '���Ĵ�ȡ���������������Ӧ�Ĳ�����ţ�';
      end if;
    else
      -- ���Ų�����
      msg := '������Ŀ��Ų�����';
    end if;
    commit; -- �ύ����
    Exception when others then
    dbms_output.put_line('�������ϣ�');
    rollback; -- ����ع�
  end;

  ----------------------����һ�����ݿ��Ų�ѯ����----------------------------------
  function fun_getmoney(cid varchar2) return number as
    v_blance number; -- �������ŵ����
    v_num    number; -- ��ѯ����Ŀ
  begin
    select b.balance
      into v_blance
      from bankcard b
     where b.bankcardno = cid;
    select count(b.bankcardno)
      into v_num
      from bankcard b
     where b.bankcardno = cid;
    if v_num = 1 then
      return v_blance;
    else
      dbms_output.put_line('���Ų����ڣ�');
      return 0;
    end if;
  end;
  -- --- ------------------------����һ��ת�˹���-----------------------------------
  procedure pro_transf(c_from varchar2, c_to varchar2, c_money varchar2) as
    v_blance number; -- �������ŵ����
    v_num1   number; -- ��ѯ����Ŀ
    v_num2   number; -- ��ѯ����Ŀ
  begin
    
    select count(b.bankcardno)
      into v_num1
      from bankcard b
     where b.bankcardno = c_from;
    select count(b.bankcardno)
      into v_num2
      from bankcard b
     where b.bankcardno = c_to;
  
    if v_num1 = 1 and v_num2 = 1 then
    select b.balance
      into v_blance
      from bankcard b
     where b.bankcardno = c_from;
      -- ֻ�д�����ֻ��������ʱ�Ż����ת�˲�������ת��ʧ��
      if v_blance > c_money then
        -- �ж����
        update bankcard
           set balance = bankcard.balance - c_money
         where bankcard.bankcardno = c_from;
        update bankcard
           set balance = bankcard.balance + c_money
         where bankcard.bankcardno = c_to;
        --��¼
        insert into tradeinfo
          (tradeno,
           tradedate,
           tradetype,
           tradecardid,
           acceptcardid,
           trademoney,
           currencytypeid,
           tradedirection,
           remark)
        values
          (to_char(sysdate, 'yyyyMMddhh24miss') ||
           LTRIM(to_char(ceil(dbms_random.value(0, 999999)), '000009'),
                 ' '),
           systimestamp,
           3,
           c_from,
           c_to,
           c_money,
           1,
           -1,
           null);
      
        insert into tradeinfo
          (tradeno,
           tradedate,
           tradetype,
           tradecardid,
           acceptcardid,
           trademoney,
           currencytypeid,
           tradedirection,
           remark)
        values
          (to_char(sysdate, 'yyyyMMddhh24miss') ||
           LTRIM(to_char(ceil(dbms_random.value(0, 999999)), '000009'),
                 ' '),
           systimestamp,
           3,
           c_to,
           c_from,
           c_money,
           1,
           1,
           null);
        dbms_output.put_line('ת�˳ɹ������ѯ��');
      else
        dbms_output.put_line('���㣡');
      end if;
    else
      --  ����һ�Ż������ſ��Ų�����
      dbms_output.put_line('���Ų����ڣ�');
    end if;
    commit; -- �ύ����
    Exception when others then
     dbms_output.put_line('�������ϣ�');
    rollback; -- ����ع�
  end;

  ------------����һ����������(�����û���Ϣ���Ϳ���Ϣ)------------------------------
  procedure pro_opencard(c_name    varchar2,
                         c_sex     number,
                         c_phone   varchar2,
                         c_address varchar2,
                         c_idcard  varchar2,
                         tradepwd  varchar2) as
    c_userinfo number := seq_userinfo.nextval;
  begin
    -- ������Ϣ
    insert into userinfo
      (userid, username, sex, phone, idcard, address)
    values
      (c_userinfo, c_name, c_sex, c_phone, c_idcard, c_address);
  
    -- ���п�
    insert into bankcard
      (bankcardno,
       userid,
       tradepassword,
       currencytypeid,
       balance,
       openmoney,
       opendate,
       isloss,
       savingid,
       availbalance)
    values
      ('621700' || LTRIM(to_char(ceil(dbms_random.value(0, 9999999999999)),
                                 '0000000000009'),
                         ' '),
       c_userinfo,
       ceil(dbms_random.value(100000, 999999)),
       1,
       1,
       1,
       sysdate,
       0,
       1,
       20000);
    dbms_output.put_line('�����ɹ��������в�ѯ��');
  /*commit; -- �ύ����
    Exception when others then
    dbms_output.put_line('�������ϣ�');
    rollback; -- ����ع�*/
  end;
  -----------------------------����һ����ӡ��¼����---------------------------------
  procedure pro_record(cid varchar2, pageNo number, pageSize number) as
    cursor cur_tradeinfo is 
    select b.* from 
      (select rownum ra,a.* from 
        (select t.* from tradeinfo t where t.tradecardid =cid order by t.tradedate desc
        )a where rownum <=pageNo*pageSize
      )b where b.ra>(pageNo-1)*pageSize;
       
       
  begin    
      for obj in cur_tradeinfo loop
          dbms_output.put_line('+-'||obj.tradeno||'-|-'||obj.tradedate||'-|-'||obj.tradecardid||'-|-'||obj.trademoney||'-|-'||obj.tradetype||'-+');
      end loop;
  
  end;
end pkg_atm;

















