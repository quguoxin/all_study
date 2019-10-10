/*
Navicat MySQL Data Transfer

Source Server         : localhost_wampserver
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mystudentdb

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-08-17 00:43:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tblcourse
-- ----------------------------
DROP TABLE IF EXISTS `tblcourse`;
CREATE TABLE `tblcourse` (
  `CourseId` VARCHAR(3) NOT NULL,
  `CourseName` VARCHAR(20) NOT NULL,
  `TeaId` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`CourseId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblcourse
-- ----------------------------
INSERT INTO `tblcourse` VALUES ('001', '企业管理', '002');
INSERT INTO `tblcourse` VALUES ('002', '马克思', '008');
INSERT INTO `tblcourse` VALUES ('003', 'UML', '006');
INSERT INTO `tblcourse` VALUES ('004', '数据库', '007');
INSERT INTO `tblcourse` VALUES ('005', '逻辑电路', '006');
INSERT INTO `tblcourse` VALUES ('006', '英语', '003');
INSERT INTO `tblcourse` VALUES ('007', '电子电路', '005');
INSERT INTO `tblcourse` VALUES ('008', '毛泽东思想概论', '004');
INSERT INTO `tblcourse` VALUES ('009', '西方哲学史', '012');
INSERT INTO `tblcourse` VALUES ('010', '线性代数', '017');
INSERT INTO `tblcourse` VALUES ('011', '计算机基础', '013');
INSERT INTO `tblcourse` VALUES ('012', 'AUTO CAD制图', '015');
INSERT INTO `tblcourse` VALUES ('013', '平面设计', '011');
INSERT INTO `tblcourse` VALUES ('014', 'Flash动漫', '001');
INSERT INTO `tblcourse` VALUES ('015', 'Java开发', '009');
INSERT INTO `tblcourse` VALUES ('016', 'C#基础', '002');
INSERT INTO `tblcourse` VALUES ('017', 'Oracl数据库原理', '010');

-- ----------------------------
-- Table structure for tblscore
-- ----------------------------
DROP TABLE IF EXISTS `tblscore`;
CREATE TABLE `tblscore` (
  `StuId` VARCHAR(5) NOT NULL,
  `CourseId` VARCHAR(3) NOT NULL,
  `Score` FLOAT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblscore
-- ----------------------------
INSERT INTO `tblscore` VALUES ('1001', '003', '90');
INSERT INTO `tblscore` VALUES ('1001', '002', '87');
INSERT INTO `tblscore` VALUES ('1001', '001', '96');
INSERT INTO `tblscore` VALUES ('1001', '010', '85');
INSERT INTO `tblscore` VALUES ('1002', '003', '70');
INSERT INTO `tblscore` VALUES ('1002', '002', '87');
INSERT INTO `tblscore` VALUES ('1002', '001', '42');
INSERT INTO `tblscore` VALUES ('1002', '010', '65');
INSERT INTO `tblscore` VALUES ('1003', '006', '78');
INSERT INTO `tblscore` VALUES ('1003', '003', '70');
INSERT INTO `tblscore` VALUES ('1003', '005', '70');
INSERT INTO `tblscore` VALUES ('1003', '001', '32');
INSERT INTO `tblscore` VALUES ('1003', '010', '85');
INSERT INTO `tblscore` VALUES ('1003', '011', '21');
INSERT INTO `tblscore` VALUES ('1004', '007', '90');
INSERT INTO `tblscore` VALUES ('1004', '002', '87');
INSERT INTO `tblscore` VALUES ('1005', '001', '23');
INSERT INTO `tblscore` VALUES ('1006', '015', '85');
INSERT INTO `tblscore` VALUES ('1006', '006', '46');
INSERT INTO `tblscore` VALUES ('1006', '003', '59');
INSERT INTO `tblscore` VALUES ('1006', '004', '70');
INSERT INTO `tblscore` VALUES ('1006', '001', '99');
INSERT INTO `tblscore` VALUES ('1007', '011', '85');
INSERT INTO `tblscore` VALUES ('1007', '006', '84');
INSERT INTO `tblscore` VALUES ('1007', '003', '72');
INSERT INTO `tblscore` VALUES ('1007', '002', '87');
INSERT INTO `tblscore` VALUES ('1008', '001', '94');
INSERT INTO `tblscore` VALUES ('1008', '012', '85');
INSERT INTO `tblscore` VALUES ('1008', '006', '32');
INSERT INTO `tblscore` VALUES ('1009', '003', '90');
INSERT INTO `tblscore` VALUES ('1009', '002', '82');
INSERT INTO `tblscore` VALUES ('1009', '001', '96');
INSERT INTO `tblscore` VALUES ('1009', '010', '82');
INSERT INTO `tblscore` VALUES ('1009', '008', '92');
INSERT INTO `tblscore` VALUES ('1010', '003', '90');
INSERT INTO `tblscore` VALUES ('1010', '002', '87');
INSERT INTO `tblscore` VALUES ('1010', '001', '96');
INSERT INTO `tblscore` VALUES ('1011', '009', '24');
INSERT INTO `tblscore` VALUES ('1011', '009', '25');
INSERT INTO `tblscore` VALUES ('1012', '003', '30');
INSERT INTO `tblscore` VALUES ('1013', '002', '37');
INSERT INTO `tblscore` VALUES ('1013', '001', '16');
INSERT INTO `tblscore` VALUES ('1013', '007', '55');
INSERT INTO `tblscore` VALUES ('1013', '006', '42');
INSERT INTO `tblscore` VALUES ('1013', '012', '34');
INSERT INTO `tblscore` VALUES ('1000', '004', '16');
INSERT INTO `tblscore` VALUES ('1002', '004', '55');
INSERT INTO `tblscore` VALUES ('1004', '004', '42');
INSERT INTO `tblscore` VALUES ('1008', '004', '34');
INSERT INTO `tblscore` VALUES ('1013', '016', '86');
INSERT INTO `tblscore` VALUES ('1013', '016', '44');
INSERT INTO `tblscore` VALUES ('1000', '014', '75');
INSERT INTO `tblscore` VALUES ('1002', '016', '100');
INSERT INTO `tblscore` VALUES ('1004', '001', '83');
INSERT INTO `tblscore` VALUES ('1008', '013', '97');

-- ----------------------------
-- Table structure for tblstudent
-- ----------------------------
DROP TABLE IF EXISTS `tblstudent`;
CREATE TABLE `tblstudent` (
  `StuId` VARCHAR(5) NOT NULL,
  `StuName` VARCHAR(10) NOT NULL,
  `StuAge` INT(11) DEFAULT NULL,
  `StuSex` CHAR(1) NOT NULL,
  PRIMARY KEY (`StuId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblstudent
-- ----------------------------
INSERT INTO `tblstudent` VALUES ('1000', '张无忌', '18', '男');
INSERT INTO `tblstudent` VALUES ('1001', '周芷若', '19', '女');
INSERT INTO `tblstudent` VALUES ('1002', '杨过', '19', '男');
INSERT INTO `tblstudent` VALUES ('1003', '赵敏', '18', '女');
INSERT INTO `tblstudent` VALUES ('1004', '小龙女', '17', '女');
INSERT INTO `tblstudent` VALUES ('1005', '张三丰', '18', '男');
INSERT INTO `tblstudent` VALUES ('1006', '令狐冲', '19', '男');
INSERT INTO `tblstudent` VALUES ('1007', '任盈盈', '20', '女');
INSERT INTO `tblstudent` VALUES ('1008', '岳灵珊', '19', '女');
INSERT INTO `tblstudent` VALUES ('1009', '韦小宝', '18', '男');
INSERT INTO `tblstudent` VALUES ('1010', '康敏', '17', '女');
INSERT INTO `tblstudent` VALUES ('1011', '萧峰', '19', '男');
INSERT INTO `tblstudent` VALUES ('1012', '黄蓉', '18', '女');
INSERT INTO `tblstudent` VALUES ('1013', '郭靖', '19', '男');
INSERT INTO `tblstudent` VALUES ('1014', '周伯通', '19', '男');
INSERT INTO `tblstudent` VALUES ('1015', '瑛姑', '20', '女');
INSERT INTO `tblstudent` VALUES ('1016', '李秋水', '21', '女');
INSERT INTO `tblstudent` VALUES ('1017', '黄药师', '18', '男');
INSERT INTO `tblstudent` VALUES ('1018', '李莫愁', '18', '女');
INSERT INTO `tblstudent` VALUES ('1019', '冯默风', '17', '男');
INSERT INTO `tblstudent` VALUES ('1020', '王重阳', '17', '男');
INSERT INTO `tblstudent` VALUES ('1021', '郭襄', '18', '女');

-- ----------------------------
-- Table structure for tblteacher
-- ----------------------------
DROP TABLE IF EXISTS `tblteacher`;
CREATE TABLE `tblteacher` (
  `TeaId` VARCHAR(3) NOT NULL,
  `TeaName` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`TeaId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblteacher
-- ----------------------------
INSERT INTO `tblteacher` VALUES ('001', '姚明');
INSERT INTO `tblteacher` VALUES ('002', '叶平');
INSERT INTO `tblteacher` VALUES ('003', '叶开');
INSERT INTO `tblteacher` VALUES ('004', '孟星魂');
INSERT INTO `tblteacher` VALUES ('005', '独孤求败');
INSERT INTO `tblteacher` VALUES ('006', '裘千仞');
INSERT INTO `tblteacher` VALUES ('007', '裘千尺');
INSERT INTO `tblteacher` VALUES ('008', '赵志敬');
INSERT INTO `tblteacher` VALUES ('009', '阿紫');
INSERT INTO `tblteacher` VALUES ('010', '郭芙蓉');
INSERT INTO `tblteacher` VALUES ('011', '佟湘玉');
INSERT INTO `tblteacher` VALUES ('012', '白展堂');
INSERT INTO `tblteacher` VALUES ('013', '吕轻侯');
INSERT INTO `tblteacher` VALUES ('014', '李大嘴');
INSERT INTO `tblteacher` VALUES ('015', '花无缺');
INSERT INTO `tblteacher` VALUES ('016', '金不换');
INSERT INTO `tblteacher` VALUES ('017', '乔丹');

-- 1.查询“001”课程比“002”课程成绩高的所有学生的学号
SELECT a.`StuId` '学号',a.`CourseId` '001课程',b.`CourseId` '002课程' 
FROM `tblscore` a,`tblscore` b 
WHERE a.`StuId`=b.`StuId` 
AND a.`CourseId`='001' 
AND b.`CourseId`='002' 
AND a.`Score` >b.`Score`;

SELECT a.`StuId` '学号',a.`CourseId` '001课程',b.`CourseId` '002课程' 
  FROM (SELECT * FROM `tblscore` WHERE `CourseId`='001') a,
       (SELECT * FROM `tblscore` WHERE `CourseId`='002') b
  WHERE a.`StuId`=b.`StuId` AND a.`Score`>b.`Score`;



-- 2.查询平均成绩大于60分的同学的学号和平均成绩
SELECT sco.`StuId` '学号', AVG(sco.`Score`) '平均成绩' 
  FROM `tblscore` sco 
  GROUP BY(sco.`StuId`) 
  HAVING AVG(sco.`Score`)>60; 
 


-- 3.查询平均成绩大于85的所有学生的学号、姓名和平均成绩
SELECT sco.`StuId` '学号',stu.`StuName` '姓名',AVG(sco.`Score`) '平均成绩' 
  FROM `tblscore` sco,`tblstudent` stu 
  WHERE sco.`StuId`=stu.`StuId` 
  GROUP BY(sco.`StuId`) 
  HAVING AVG(sco.`Score`)>85;
  
  

-- 4.查询所有同学的学号、姓名、选课数、总成绩
SELECT sco.`StuId` '学号',stu.`StuName` '姓名',COUNT(sco.`CourseId`) '选课数',SUM(sco.`Score`) '总分' 
  FROM `tblstudent`stu,`tblscore` sco
  WHERE stu.`StuId`=sco.`StuId` 
  GROUP BY(sco.`StuId`);
  
  

-- 5.查询姓“李”的老师的个数
SELECT COUNT(`TeaName`) '姓李的个数' 
 FROM `tblteacher` 
 WHERE `TeaName` LIKE '李%';
 
 

-- 6.查询没学过“叶平”老师课的同学的学号、姓名
SELECT `StuId` '学号',`StuName` '姓名' 
  FROM `tblstudent`                  
  WHERE `StuId` NOT IN (SELECT DISTINCT sco.`StuId` 
                        FROM `tblcourse` cou,`tblscore` sco ,`tblstudent` stu,`tblteacher` tea
                        WHERE sco.`StuId`=stu.`StuId` AND sco.`CourseId`=cou.`CourseId` AND cou.`TeaId`=tea.`TeaId` 
                        AND tea.`TeaName`='叶平');
                        
                        

-- 7.查询学过“001”并且也学过编号“002”课程的同学的学号、姓名
SELECT  stu.`StuId` '学号',stu.`StuName` '姓名' FROM `tblscore` sco1,`tblscore` sco2,`tblstudent` stu
WHERE stu.`StuId`=sco1.`StuId` 
AND sco1.`StuId`=sco2.`StuId` 
AND sco1.`CourseId`='001' 
AND sco2.`CourseId`='002';

SELECT stu.`StuId` '学号',stu.`StuName` '姓名' 
  FROM `tblstudent` stu,
       (SELECT `StuId` FROM `tblscore` WHERE `CourseId`='001') a,
       (SELECT `StuId` FROM `tblscore` WHERE `CourseId`='002') b
  WHERE a.`StuId`=b.`StuId` AND a.`StuId`=stu.`StuId`;
  
  
  
-- !!!!!!!!8.查询学过“叶平”老师所教的所有课的同学的学号、姓名
SELECT  stu.`StuId` '学号',stu.`StuName` '姓名'  
FROM `tblcourse` cou,`tblscore` sco ,`tblstudent` stu,`tblteacher` tea  
WHERE sco.`StuId`=stu.`StuId` AND sco.`CourseId`=cou.`CourseId` AND cou.`TeaId`=tea.`TeaId` AND tea.`TeaName`='叶平'
GROUP BY (stu.`StuId`)
HAVING  COUNT(sco.`CourseId`)>=(SELECT COUNT(`CourseId`) 
                                FROM `tblcourse` a,`tblteacher` b 
                                WHERE a.`TeaId`=b.`TeaId` AND b.`TeaName`='叶平'); 



-- 9.查询课程编号“002”的成绩比课程编号“001”课程低的所有同学的学号、姓名 参考第一题
SELECT a.`StuId` '学号',stu.`StuName` '姓名' 
FROM `tblscore` a,`tblscore` b ,`tblstudent` stu 
WHERE a.`StuId`=b.`StuId` AND stu.`StuId`=a.`StuId` AND a.`CourseId`='001' AND b.`CourseId`='002' 
AND a.`Score` >b.`Score`;



-- 10.查询所有课程成绩小于60分的同学的学号、姓名
  -- 不算弃考的
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'  
FROM `tblstudent` stu,(SELECT `StuId`  -- 全是< 60 的学生
                      FROM `tblscore` 
                      GROUP BY `StuId` 
                      HAVING `StuId` NOT IN (SELECT `StuId`  -- 只要有一个学科>60 的学生
                                             FROM `tblscore` 
                                             WHERE `Score`>60 
                                             GROUP BY `StuId`)
                      ) a
WHERE stu.`StuId`= a.`StuId`; 

  --  算弃考的 
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'  
FROM `tblstudent` stu
WHERE stu.`StuId` NOT IN (SELECT DISTINCT `StuId`  -- 只要有一个学科>60 的学生
                          FROM `tblscore` 
                          WHERE `Score`>60 
                          ); 
 


-- !!!!!!11.查询没有学全所有课的同学的学号、姓名
  -- >>>> 不算没选课的同学
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'  -- 这里不包括没选课的学生
FROM `tblstudent` stu,(SELECT `StuId`   -- 每个学生所选课数不等于所有学科数的学生  
                       FROM `tblscore`
                       GROUP BY `StuId`
                       HAVING COUNT(`CourseId`)!=(SELECT COUNT(`CourseId`) -- 所有学科数
                                                  FROM `tblcourse`)
                      ) a 
WHERE stu.`StuId`= a.`stuId`;
 -- >>>>算没选课的学生
 SELECT `StuId` '学号',`StuName` '姓名' 
 FROM `tblstudent` 
 WHERE `StuId` NOT IN (SELECT `StuId`   -- 每个学生所选课数等于所有学科数的学生  
                       FROM `tblscore`
                       GROUP BY `StuId`
                       HAVING COUNT(`CourseId`)=(SELECT COUNT(`CourseId`) -- 所有学科数
                                                 FROM `tblcourse`)
                      );
 


-- 12.查询至少有一门课与学号为“1001”的同学所学相同的同学的学号和姓名
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'
FROM `tblstudent` stu,(SELECT `StuId`
                       FROM `tblscore`   -- 得到学了1001 其中的课程的同学 并去除掉1001
                       WHERE `CourseId` IN(SELECT `CourseId`
                                            FROM `tblscore`   -- 得到1001学的课程
                                            WHERE `StuId`='1001') 
                       GROUP BY `StuId`
                       HAVING `StuId` !='1001') a
WHERE stu.`StuId`=a.`StuId`;

                                          
-- 13.查询至少学过学号为“1001”同学所有课程的其他同学学号和姓名
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'
FROM `tblstudent` stu,(SELECT *  
                       FROM `tblscore`  
                       WHERE `CourseId` IN(SELECT `CourseId`
                                           FROM `tblscore`   -- 得到1001学的课程
                                            WHERE `StuId`='1001')
                       GROUP BY `StuId` 
                       HAVING COUNT(`Score`)=(SELECT COUNT(`CourseId`)
                                              FROM `tblscore`
                                              WHERE `StuId`='1001')
                      ) a
WHERE stu.`StuId`=a.`StuId` AND stu.`StuId`!='1001';



-- 14.查询和“1002”号的同学学习的课程完全相同的其他同学学号和姓名
SELECT stu.`StuId` '学号',stu.`StuName` '姓名'
  FROM `tblstudent` stu,
      (SELECT *            -- 表a是至少学过学号为“1002”同学所有课程的人
       FROM `tblscore`  
       WHERE `CourseId` IN(SELECT `CourseId`
                           FROM `tblscore`   
                           WHERE `StuId`='1002')
       GROUP BY `StuId` 
       HAVING COUNT(`Score`)=(SELECT COUNT(`CourseId`)
                              FROM `tblscore`
                              WHERE `StuId`='1002')
       ) a,
       (SELECT *            --  表b是学生所有选课数和1002相等的人
       FROM`tblscore` 
       GROUP BY `StuId` 
       HAVING COUNT(`CourseId`)=(SELECT COUNT(`CourseId`)
                                 FROM `tblscore`
                                 WHERE `StuId`='1002')
       ) b
WHERE stu.`StuId`=a.`StuId` AND b.`StuId`=a.`StuId` AND stu.`StuId`!='1002'; -- 综合表a表b就能得出完全一样的人



-- 15.按平均成绩从高到低显示所有学生的“数据库”、“企业管理”、“英语”三门的课程成绩
SELECT b.`StuId`,a.m '平均分',cou.`CourseName`,b.`Score` 
FROM  (SELECT `StuId`,AVG(`Score`) m FROM `tblscore` GROUP BY `StuId`) a,
      (SELECT *
       FROM `tblscore` 
       WHERE `CourseId` IN(SELECT `CourseId` 
                           FROM `tblcourse` 
                           WHERE `CourseName` IN('数据库','企业管理','英语'))
       ) b ,
       `tblcourse` cou
WHERE a.`StuId`=b.`StuId` AND b.`CourseId`=cou.`CourseId`  
ORDER BY a.m DESC;   



-- 16.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
SELECT a.`CourseId` '课程ID',a.max1 '最高分',b.min1 '最低分'
FROM   (SELECT `CourseId`, MAX(`Score`) max1    -- 最高分表
        FROM `tblscore`
        GROUP BY `CourseId` 
        ) a ,
        (SELECT `CourseId`, MIN(`Score`) min1   --  最低分表
        FROM `tblscore`
        GROUP BY `CourseId`) b
WHERE a.`CourseId`=b.`CourseId`;         
        


-- 17.按各科平均成绩从低到高和及格率的百分数从高到低顺序 (百分数后如何格式化为两位小数??)
SELECT m.`CourseId`,m.avg1 '平均成绩',n.ab '及格率'
FROM  (SELECT `CourseId`,FORMAT(AVG(`Score`),2) avg1  --  平均成绩表
       FROM `tblscore`
       GROUP BY `CourseId`
      ) m,
      (SELECT a.`CourseId`,FORMAT(a1/b1 ,2)  ab  --  及格率表
       FROM  (SELECT sco.`CourseId`,COUNT(sco.`Score`) a1 FROM `tblscore` sco  WHERE sco.`Score`>=60 GROUP BY sco.`CourseId`) a,
             (SELECT sco1.`CourseId`,COUNT(sco1.`Score`) b1 FROM `tblscore` sco1 GROUP BY sco1.`CourseId`) b
       WHERE a.`CourseId`=b.`CourseId` 
       ) n
WHERE m.`CourseId`=n.`CourseId` 
ORDER BY m.avg1 ASC, n.ab DESC;      
 -- ===========简便方法================简便方法==================简便方法==============简便方法=============
 
CREATE VIEW view_a AS  -- 视图1  相当于封装了一个表
  SELECT `CourseId`,FORMAT(AVG(`Score`),2) avg1, COUNT(`Score`) a FROM `tblscore` GROUP BY `CourseId`;
  
CREATE VIEW view_b AS  -- 视图2
  SELECT `CourseId`,COUNT(`Score`) b FROM `tblscore` WHERE `Score`>=60  GROUP BY `CourseId`;

SELECT m.`CourseId` '课程ID', m.avg1 '平均分', FORMAT(n.b*100/m.a,0)  '及格率%'  FROM view_a m,view_b n WHERE m.`CourseId`=n.`CourseId` 
ORDER BY m.avg1 ASC,  n.b/m.a DESC;  


