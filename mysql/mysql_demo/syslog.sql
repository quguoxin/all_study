CREATE TABLE syslog  (
 id INT(11) AUTO_INCREMENT PRIMARY KEY COMMENT '日志编号',
 title VARCHAR(50) COMMENT '标题',
 content VARCHAR(500) COMMENT '日志内容',
 createtime DATETIME COMMENT '创建时间',
 `name` VARCHAR(50)  COMMENT '创建者'
)ENGINE = MYISAM CHARSET=utf8 COMMENT='系统操作日志表';
ALTER TABLE `syslog` ADD FULLTEXT fulltext_syslog_name(`name`);