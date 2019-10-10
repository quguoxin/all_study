-- 建立一个数据库 
CREATE DATABASE demooo;

-- 建立科目表
DROP TABLE `subject`;
CREATE TABLE IF NOT EXISTS `subject`(
subjectno INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '科目编号',
subjectname VARCHAR(50) NOT NULL COMMENT '科目名称',
classshour INT NOT NULL DEFAULT '0' COMMENT '课时数',
gradeid INT NOT NULL COMMENT '年级编号'
)COMMENT '科目表' ENGINE=INNODB CHARSET=utf8;

-- 建立年级表
DROP TABLE grade;
CREATE TABLE IF NOT EXISTS grade(
gradeid INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '年级编号',
gradename VARCHAR(50) NOT NULL COMMENT '年级名称'
)COMMENT '年级表' ENGINE=INNODB CHARSET=utf8;

-- 建立成绩表
DROP TABLE result;
CREATE TABLE IF NOT EXISTS result(
rid INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '成绩单编号',
stuid INT NOT NULL COMMENT '学生编号',
subjectno INT NOT NULL COMMENT '科目编号',
score INT NOT NULL DEFAULT '0' COMMENT '学生成绩'
)COMMENT '考试成绩表' ENGINE=INNODB CHARSET=utf8;

-- 建立学生表
DROP TABLE student;
CREATE TABLE IF NOT EXISTS student(
stuid INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '学生编号',
stuname VARCHAR(50) NOT NULL DEFAULT '无名' COMMENT '学生姓名',
sex VARCHAR(50) NOT NULL DEFAULT '男' COMMENT '性别' ,
gradeid INT NOT NULL COMMENT '年级编号'
)COMMENT='学生表' ENGINE=INNODB CHARSET=utf8 ;

-- 建立充值信息表
CREATE TABLE IF NOT EXISTS pilechargeinfo(
pileId VARCHAR(32) NOT NULL COMMENT '充电桩id',
gunId INT(4) NOT NULL COMMENT '充电枪id',
userId INT(8) NOT NULL COMMENT '正在充电的用户id',
outPower DECIMAL(10,1) DEFAULT '0.0' COMMENT '输出能量',
cumulativeTime INT(11) DEFAULT '0' COMMENT '累计充电时间 WORD 单位：1Min/bit',
chargeMoney DECIMAL(10,2) DEFAULT '0.00' COMMENT '充电金额',
electricityState INT(11) DEFAULT '0' COMMENT '核电状态 SOC 有效值范围：0~100（表示0%~100%）',
orderSerialNumber VARCHAR(50) COMMENT '充电订单号',
startTime BIGINT(20) DEFAULT '0' COMMENT '充电开始时间',
PRIMARY KEY(pileId,gunId)
)COMMENT '充值信息表' ENGINE=INNODB CHARSET=utf8;
select * from product where product_type='虾' order by salesVolume DESC limit 0,3
select count(1) as totalCount from shopping
select * from shopping


/*
a.增加grade表数据4条,从大一到大四
b.为student表增加2名学生信息(小明，小黑),且一名是大一学生，一名是大三学生
c.为subject表增加3门学科的信息，其中一门大学语文(大一课程)，一门微积分(大二课程)，一门单片机(大四课程)
d.为result表增加开始成绩,小黑的大学语文成绩90，小黑的微积分成绩100,小黑的单片机成绩59
e.修改名称为小黑学生将性别改为女,将单片机课程的课时数改为300
d.删除成绩小于59分的考试成绩
*/
INSERT INTO grade(gradename) VALUES('大一'),('大二'),('大三'),('大四');
INSERT INTO student(stuname,gradeid) VALUES('小明',1),('小黑',3);
INSERT INTO `subject`(subjectname,classshour,gradeid) VALUES('大学语文',222,1),('微积分',120,2),('单片机',230,4);
INSERT INTO result(stuid,subjectno,score) VALUES(2,1,90),(2,2,100),(2,3,59);
UPDATE student SET sex='女' WHERE stuname='小黑';
UPDATE `subject` SET classshour=300 WHERE subjectname='单片机';
DELETE  FROM result WHERE score<59;

-- 小黑所进行的考试科目编号
SELECT subjectno FROM result r WHERE r.`stuid`=(SELECT stuid FROM student s WHERE s.`stuname`='小黑');

-- 查询大一的所有学生及其年级及其学科及其成绩
SELECT stu.`stuname`,g.`gradename`,sub.`subjectname`,r.`score` 
FROM `grade` g,`student` stu,`subject` sub,`result` r 
WHERE stu.`stuid`=r.`stuid` 
AND r.`subjectno`=sub.`subjectno` 
AND stu.`gradeid`=g.`gradeid`
AND g.`gradename`='大一';

-- 查询成绩在60-80之间的学生及其年级
SELECT stu.`stuname`,g.`gradename` 
FROM `grade` g,`student` stu,`subject` sub,`result` r 
WHERE stu.`stuid`=r.`stuid` 
AND r.`subjectno`=sub.`subjectno` 
AND stu.`gradeid`=g.`gradeid`
AND r.`score`>60 AND r.`score`<80;

-- 查询成绩小于60的学生及考试科目
SELECT stu.`stuname`,sub.`subjectname` 
FROM `grade` g,`student` stu,`subject` sub,`result` r 
WHERE stu.`stuid`=r.`stuid` 
AND r.`subjectno`=sub.`subjectno` 
AND stu.`gradeid`=g.`gradeid`
AND r.`score`<60;