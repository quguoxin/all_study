DROP TABLE examstudent;
CREATE TABLE  IF NOT EXISTS examstudent(
FlowId INT AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
`Type` INT COMMENT '四级/六级',
IdCard VARCHAR(18) UNIQUE COMMENT '身份证号码',
ExamCard VARCHAR(15) UNIQUE COMMENT '准考证号码',
StudentName VARCHAR(20) COMMENT '学生姓名',
Location VARCHAR(20) COMMENT '区域',
Grade INT COMMENT '成绩'
)COMMENT '英语等级考试表' ENGINE = INNODB CHARSET =utf8;

INSERT INTO `examstudent` (`Type`,`IdCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) 
VALUES (4,'412824195263214584','200523164754000','张锋','郑州',85),
(4,'222224195263214584','200523164754001','孙鹏','大连',56),
(6,'342824195263214584','200523164754002','刘明','沈阳',72),
(6,'100824195263214584','200523164754003','赵虎','哈尔滨',95),
(4,'454524195263214584','200523164754004','杨丽','北京',64),
(4,'854524195263214584','200523164754005','王小红','太原',60);

INSERT INTO `examstudent` (`Type`,`IdCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) 
VALUES ()

SELECT * FROM `examstudent` WHERE `IdCard`=
SELECT * FROM `examstudent` WHERE `ExamCard`=
