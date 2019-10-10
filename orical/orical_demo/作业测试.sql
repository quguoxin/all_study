-- 取钱  存钱
declare
msg varchar2(300) ;
begin
 pkg_atm.pro_cunqukuan ('6217001111111111111',1,30000,msg);
 dbms_output.put_line(msg);
end;
-- 查询
declare
money number ;
begin
 money := pkg_atm.fun_getmoney('6217001111111111111');
 dbms_output.put_line(money);
end;
-- 转账
begin
 pkg_atm.pro_transf('6217001111111111111','6217002222222222222',40000);
end;
-- 开户
begin
 pkg_atm.pro_opencard('kkk',1,'15090817890','湖北','421002199212057890','123456');
end;
-- 打印交易信息表
begin
 pkg_atm.pro_record('6217001111111111111',1,10);
end;
