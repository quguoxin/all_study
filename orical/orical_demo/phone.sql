CREATE  TABLE phone (
id  number(4)  PRIMARY KEY ,
model varchar2(50) UNIQUE NOT NULL  ,
price number(4)  NOT NULL ,
dayPrice   number(4) NOT NULL  ,
store  number(4)  NOT NULL 
);

comment on table phone is '�ֻ����ޱ�';
comment on column phone.id is '��ţ�������������';
comment on column phone.model is '�ͺţ��ֻ��ͺŲ�����ͬ��';
comment on column phone.price is '�ֻ��۸�';
comment on column phone.dayprice is '����۸�';
comment on column phone.store is '���';

alter table phone add constraint ck_price check (price>0);
alter table phone add constraint ck_dayprice check (dayprice>100);
alter table phone add constraint ck_store check (store>0 and store<1000);


