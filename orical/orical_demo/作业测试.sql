-- ȡǮ  ��Ǯ
declare
msg varchar2(300) ;
begin
 pkg_atm.pro_cunqukuan ('6217001111111111111',1,30000,msg);
 dbms_output.put_line(msg);
end;
-- ��ѯ
declare
money number ;
begin
 money := pkg_atm.fun_getmoney('6217001111111111111');
 dbms_output.put_line(money);
end;
-- ת��
begin
 pkg_atm.pro_transf('6217001111111111111','6217002222222222222',40000);
end;
-- ����
begin
 pkg_atm.pro_opencard('kkk',1,'15090817890','����','421002199212057890','123456');
end;
-- ��ӡ������Ϣ��
begin
 pkg_atm.pro_record('6217001111111111111',1,10);
end;
