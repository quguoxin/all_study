drop table sals
create table sals(
no varchar2(50) primary key,
sell number(4)
);

comment on column sals.no is '流水号，格式：YYYYMMDD';
comment on column sals.sell is '销售额';

insert into sals (no, sell) values ('20000101', 1000);
insert into sals (no, sell) values ('20000102', 5000);
insert into sals (no, sell) values ('20000103', 4000);
insert into sals (no, sell) values ('20000104', 8000);
insert into sals (no, sell) values ('20000201', 1200);
insert into sals (no, sell) values ('20000301', 800);
insert into sals (no, sell) values ('20000401', 6780);
insert into sals (no, sell) values ('20000605', 3000);
insert into sals (no, sell) values ('20000607', 2300);
insert into sals (no, sell) values ('20000609', 3200);
insert into sals (no, sell) values ('20000611', 3800);
select * from sals

select 
substrb(s.no,6,1) 月份,
sum(decode(substrb(s.no,7,2),'01',s.sell,0)) d1,
sum(decode(substrb(s.no,7,2),'02',s.sell,0)) d2,
sum(decode(substrb(s.no,7,2),'03',s.sell,0)) d3,
sum(decode(substrb(s.no,7,2),'04',s.sell,0)) d4,
sum(decode(substrb(s.no,7,2),'05',s.sell,0)) d5,
sum(decode(substrb(s.no,7,2),'06',s.sell,0)) d6,
sum(decode(substrb(s.no,7,2),'07',s.sell,0)) d7
from sals s
group by substrb(s.no,6,1);

create table subject1(
subjectname  varchar(50) primary key,
calsshours number(4)
);
insert into subject1 (subjectname, calsshours) values ('软件测试', 40);
insert into subject1 (subjectname, calsshours) values ('java', 100);
insert into subject1 (subjectname, calsshours) values ('php', 120);
insert into subject1 (subjectname, calsshours) values ('oracle', 60);
insert into subject1 (subjectname, calsshours) values ('计算机基础', 80);

select * from subject1;
select 
sum(decode(s.subjectname,'软件测试',s.calsshours,0)) test,
sum(decode(s.subjectname,'java',s.calsshours,0)) java,
sum(decode(s.subjectname,'php',s.calsshours,0)) php,
sum(decode(s.subjectname,'oracle',s.calsshours,0)) oracle,
sum(decode(s.subjectname,'计算机基础',s.calsshours,0)) basic
from subject1 s;




