
-- 表1银行卡信息表
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
comment on table bankcard is '银行卡信息表';
comment on column bankcard.bankcardNo is '19位卡号，主键';
comment on column bankcard.userid is '用户编号，引用用户信息表';
comment on column bankcard.tradePassword is '6位数字交易密码，MD5加密';
comment on column bankcard.currencyTypeId is '货币类型，引用货币类型表';
comment on column bankcard.balance is '余额';
comment on column bankcard.openMoney is '开户金额至少一元';
comment on column bankcard.openDate is '开户日期，格式YYYY-MM-DD HH:mm:ss';
comment on column bankcard.isloss is '是否挂失，挂失1未挂失0，默认0';
comment on column bankcard.savingID is '存款类型';
comment on column bankcard.availBalance is '每日限制可取金额，默认20000';
alter table bankcard add constraint ck_openMoney check (openMoney>=1);
alter table bankcard add constraint bank_user_fk foreign key(userid) references userinfo (userid);
alter table bankcard add constraint bank_curr_fk foreign key(currencytypeid) references currencytype (currencytypeid);
alter table bankcard add constraint bank_depo_fk foreign key(savingid) references deposit (savingid);
select * from bankcard
insert into bankcard values
  ('6217001111111111111', 2, '123456', 1, 100000, 100000, systimestamp, 0, 1, 20000);
insert into bankcard values
  ('6217002222222222222', 3, '654321', 1, 100000, 100000, systimestamp, 0, 1, 20000);

-- 表2货币类型表
create table currencytype( 
currencyTypeId number(10) primary key not null,
currencyTypeName varchar(20) 
);
comment on table currencytype is'货币类型表';
comment on column currencytype.currencytypeid is '货币类型，主键';
comment on column currencytype.currencytypename is '货币类型名称，如：人民币，美元';
insert into currencytype  values (1, '人民币');
insert into currencytype  values (2, '美元');
select * from currencytype
    
-- 表3 存款类型表
create table deposit(
savingID number(11) primary key not null,
savingName varchar(20) not null,
descrip varchar(50)
);
comment on table deposit is '存款类型表';
comment on column deposit.savingid is '存款类型编号';
comment on column deposit.savingName is '存款类型名称';
comment on column deposit.descrip is '存款类型描述';
select * from deposit
insert into deposit (savingid, savingname, descrip)  values (1, '活期', '可随时取');
insert into deposit (savingid, savingname, descrip)  values (2, '死期', '不可随时取');



-- 表4 交易信息表
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
comment on table tradeinfo is '交易信息表';
comment on column tradeinfo.tradeno is '交易流水：tryyyyMMddhhmmss+6位随机数';
comment on column tradeinfo.tradeDate is '交易日期';
comment on column tradeinfo.tradeType is '交易类型：1存款，2取款，3转账，4收入';
comment on column tradeinfo.tradeCardId is '卡号';
comment on column tradeinfo.acceptCardid is '对方账号，转账时使用，其他交易类型可为空';
comment on column tradeinfo.tradeMoney is '交易金额';
comment on column tradeinfo.currencyTypeId is '交易币种';
comment on column tradeinfo.tradeDirection is '交易方向：-1出账1入账';
comment on column tradeinfo.remark is '备注';
alter table tradeinfo add constraint tra_tra_fk foreign key(tradecardid) references bankcard (bankcardno);
alter table tradeinfo add constraint tra_acc_fk foreign key(acceptcardid) references bankcard (bankcardno);
alter table tradeinfo add constraint tra_cur_fk foreign key(currencytypeid) references currencytype (currencytypeid);
select * from tradeinfo

-- 表5用户信息表
create table userinfo(
userid number(10) primary key  not null,
username varchar(50) ,
sex number(1),
phone varchar(11) unique,
idCard varchar(18) unique,
address varchar(100) 
);
comment on table userinfo is '用户信息表';
comment on column userinfo.userid is '用户编号，主键';
comment on column userinfo.username is '姓名';
comment on column userinfo.sex is '性别：1男0女';
comment on column userinfo.phone is '手机号码，唯一';
comment on column userinfo.idCard is '身份证，唯一';
comment on column userinfo.address is '住址';
create sequence seq_userinfo;
select * from userinfo
insert into userinfo values
  (seq_userinfo.nextval, 'aaa', 1, '15090814407', '421002199212054511', '湖北荆州');
insert into userinfo values
  (seq_userinfo.nextval, 'bbb', 0, '15090814408', '421002199212054512', '湖北荆州');


---------------------------------包头----------------------------------------------
create or replace package pkg_atm as
  --声明一个存款/取款共用的过程
 procedure pro_cunqukuan(cid in varchar2,xuan varchar2,money in number,msg out varchar2);
  --声明一个根据卡号查询方法
  function fun_getmoney(cid  varchar2) return number;
  --声明一个转账过程
  procedure pro_transf(c_from varchar2,c_to varchar2,c_money varchar2);
  --声明一个开户过程(创建用户信息，和卡信息)
  procedure pro_opencard(c_name varchar2,c_sex number,c_phone varchar2,c_address varchar2,c_idcard  varchar2,tradepwd  varchar2);
  --声明一个打印记录过程
  procedure pro_record(cid  varchar2,pageNo  number, pageSize  number);
end pkg_atm;

----------------------------------包体-------------------------------------------

create or replace package body pkg_atm as

  ---------------------声明一个存款/取款共用的过程----------------------------------
  procedure pro_cunqukuan(cid   in varchar2,
                          xuan  varchar2,
                          money in number,
                          msg   out varchar2) as
    v_blance number; -- 操作卡号的余额
    v_num    number; -- 查询的数目
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
        -- 存
        update bankcard
           set balance = bankcard.balance + money
         where bankcard.bankcardno = cid;
        -- 记录
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
      
        msg := '存款成功，已经成功为' || cid || '存入金额：' || money;
      elsif xuan = 2 then
        -- 取
        if v_blance >= money then
          --判断余额
          update bankcard
             set balance = bankcard.balance - money
           where bankcard.bankcardno = cid;
          -- 记录
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
          msg := '取款成功，已经成功从' || cid || '取出金额：' || money;
        else
          -- 余额不足
          msg := '存款不够！';
        end if;
      else
        -- xuan输入错误
        msg := '您的存取操作有误，请输入对应的操作编号！';
      end if;
    else
      -- 卡号不存在
      msg := '您输入的卡号不存在';
    end if;
    commit; -- 提交事物
    Exception when others then
    dbms_output.put_line('操作故障！');
    rollback; -- 事物回滚
  end;

  ----------------------声明一个根据卡号查询方法----------------------------------
  function fun_getmoney(cid varchar2) return number as
    v_blance number; -- 操作卡号的余额
    v_num    number; -- 查询的数目
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
      dbms_output.put_line('卡号不存在！');
      return 0;
    end if;
  end;
  -- --- ------------------------声明一个转账过程-----------------------------------
  procedure pro_transf(c_from varchar2, c_to varchar2, c_money varchar2) as
    v_blance number; -- 操作卡号的余额
    v_num1   number; -- 查询的数目
    v_num2   number; -- 查询的数目
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
      -- 只有存在且只存在两条时才会进行转账操作否则转账失败
      if v_blance > c_money then
        -- 判断余额
        update bankcard
           set balance = bankcard.balance - c_money
         where bankcard.bankcardno = c_from;
        update bankcard
           set balance = bankcard.balance + c_money
         where bankcard.bankcardno = c_to;
        --记录
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
        dbms_output.put_line('转账成功！请查询！');
      else
        dbms_output.put_line('余额不足！');
      end if;
    else
      --  其中一张或者两张卡号不存在
      dbms_output.put_line('卡号不存在！');
    end if;
    commit; -- 提交事物
    Exception when others then
     dbms_output.put_line('操作故障！');
    rollback; -- 事物回滚
  end;

  ------------声明一个开户过程(创建用户信息，和卡信息)------------------------------
  procedure pro_opencard(c_name    varchar2,
                         c_sex     number,
                         c_phone   varchar2,
                         c_address varchar2,
                         c_idcard  varchar2,
                         tradepwd  varchar2) as
    c_userinfo number := seq_userinfo.nextval;
  begin
    -- 个人信息
    insert into userinfo
      (userid, username, sex, phone, idcard, address)
    values
      (c_userinfo, c_name, c_sex, c_phone, c_idcard, c_address);
  
    -- 银行卡
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
    dbms_output.put_line('开户成功。请自行查询！');
  /*commit; -- 提交事物
    Exception when others then
    dbms_output.put_line('操作故障！');
    rollback; -- 事物回滚*/
  end;
  -----------------------------声明一个打印记录过程---------------------------------
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

















