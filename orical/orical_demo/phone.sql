CREATE  TABLE phone (
id  number(4)  PRIMARY KEY ,
model varchar2(50) UNIQUE NOT NULL  ,
price number(4)  NOT NULL ,
dayPrice   number(4) NOT NULL  ,
store  number(4)  NOT NULL 
);

comment on table phone is '手机租赁表';
comment on column phone.id is '编号（自增，主键）';
comment on column phone.model is '型号（手机型号不可相同）';
comment on column phone.price is '手机价格';
comment on column phone.dayprice is '日租价格';
comment on column phone.store is '库存';

alter table phone add constraint ck_price check (price>0);
alter table phone add constraint ck_dayprice check (dayprice>100);
alter table phone add constraint ck_store check (store>0 and store<1000);


