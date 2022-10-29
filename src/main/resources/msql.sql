DROP TABLE
    IF
    EXISTS feedback;
DROP TABLE
    IF
    EXISTS orders;
DROP TABLE
    IF
    EXISTS student;
DROP TABLE
    IF
    EXISTS admin;
DROP TABLE
    IF
    EXISTS worker;-- 学生表
CREATE TABLE student (
                         `id` INT PRIMARY KEY auto_increment COMMENT '学生id',
                         `sno` VARCHAR ( 200 ) NOT NULL UNIQUE COMMENT '学生学号',-- 外键约束关联学生学号
                         `username` VARCHAR ( 200 ) UNIQUE DEFAULT NULL COMMENT '用户名',
                         `password` VARCHAR ( 200 ) NOT NULL COMMENT '密码',
                         `name` VARCHAR ( 20 ) NOT NULL COMMENT '学生姓名',
                         `tel` VARCHAR ( 30 ) NOT NULL UNIQUE COMMENT '学生手机号',
                         `avatar` VARCHAR ( 255 ) DEFAULT NULL COMMENT '头像',
                         `add` VARCHAR ( 255 ) NOT NULL COMMENT '学生住址',
                         `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);-- 管理员表
CREATE TABLE admin (
                       `id` INT PRIMARY KEY auto_increment COMMENT '管理员id',
                       `username` VARCHAR ( 200 ) UNIQUE NOT NULL COMMENT '管理员用户名',
                       `password` VARCHAR ( 200 ) NOT NULL COMMENT '密码',
                       `name` VARCHAR ( 30 ) NOT NULL COMMENT '管理员姓名',
                       `tel` VARCHAR ( 20 ) NOT NULL UNIQUE COMMENT '管理员手机号',
                       `avatar` VARCHAR ( 255 ) DEFAULT NULL COMMENT '头像',
                       `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                       `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);-- 维修师傅表
CREATE TABLE worker (
                        `id` INT PRIMARY KEY auto_increment COMMENT '维修师傅id',
                        `mno` VARCHAR ( 200 ) NOT NULL UNIQUE COMMENT '维修师傅工号',-- 外键约束
                        `username` VARCHAR ( 200 ) UNIQUE NOT NULL COMMENT '用户名',
                        `password` VARCHAR ( 200 ) NOT NULL COMMENT '密码',
                        `name` VARCHAR ( 30 ) NOT NULL COMMENT '维修师傅姓名',
                        `tel` VARCHAR ( 20 ) NOT NULL UNIQUE COMMENT '维修师傅手机号',
                        `avatar` VARCHAR ( 255 ) DEFAULT NULL COMMENT '头像',
                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);-- 维修工单表
CREATE TABLE orders (
                        `id` INT PRIMARY KEY auto_increment COMMENT '工单id号',
                        `mno` VARCHAR ( 200 ) COMMENT '维修师傅工号',-- 外键约束关联师傅工号
                        `sno` VARCHAR ( 200 ) COMMENT '学生学号',-- 外键约束关联学生学号
                        `variety` VARCHAR ( 20 ) COMMENT '报修种类',-- variety
                        `picture` VARCHAR ( 255 ) COMMENT '问题图片',
                        `detail` VARCHAR ( 200 ) COMMENT '问题描述',
                        `status` VARCHAR ( 20 ) DEFAULT '0' COMMENT '工单状态',
                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime ON UPDATE CURRENT_TIMESTAMP  NULL COMMENT '接单时间',
                        `finish_time` datetime DEFAULT NULL COMMENT '完成时间',-- 外键约束 -- 关联学生
                        CONSTRAINT repair_table_stu_fk0 FOREIGN KEY ( `sno` ) REFERENCES student ( `sno` ) ON UPDATE CASCADE ON DELETE CASCADE,
                        CONSTRAINT repair_table_mas_fk0 FOREIGN KEY ( `mno` ) REFERENCES worker ( `mno` ) ON UPDATE CASCADE ON DELETE CASCADE
);-- 用户行为记录
-- create table repair_user_rule(
-- id,
--
-- );
-- 用户反馈信息表
CREATE TABLE feedback (
                          `id` INT PRIMARY KEY auto_increment COMMENT '反馈信息id',
                          `feedback` text NOT NULL COMMENT '反馈填写文本',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '反馈创建时间',
                          `fsno` VARCHAR ( 200 ) NOT NULL COMMENT '关联学生学号',-- 外键约束
                          CONSTRAINT feedback_stu_fk0 FOREIGN KEY ( `fsno` ) REFERENCES student ( `sno` ) ON UPDATE CASCADE ON DELETE CASCADE
);-- 插入数据
-- 学生
INSERT INTO student ( `sno`, `name`, `tel`, `add`, `password`, `username` )
VALUES
    ( 200001, "李洋洋", "1001011", "西苑12栋111", "testabc", "testabc" ),(
    200002,
    "李大",
    "1001111",
    "西苑12栋222",
    "testabcd",
    "testabcd"
),(
        200003,
        "李海洋",
        "1001211",
        "西苑12栋333",
        "testabcde",
        "testabcde"
    ),(
        200004,
        "李汪洋",
        "1001311",
        "西苑12栋444",
        "testabcdef",
        "testabcdef"
    );-- 管理员
INSERT INTO admin ( `username`, `password`, `name`, `tel` )
VALUES
    ( "ninja", "ninja", "ninja", "123456" ),(
    "admin",
    "admin",
    "admin",
    "1234567"
);-- 维修师傅
INSERT INTO worker ( `mno`, `username`, `password`, `name`, `tel` )
VALUES
    ( 100001, "ninja", "ninjia", "ninja", "123456" ),(
    100002,
    "admin",
    "admin",
    "admin",
    "1234567"
);-- 工单
INSERT INTO orders ( `mno`, `sno`, `variety`, `picture`, `detail` )
VALUES
    ( 100001, 200001, "宿舍ap坏了", "假装有图", "网线短接，造成广播风暴" ),(
    100001,
    200002,
    "宿舍ap坏了",
    "假装有图",
    "网线短接，造成广播风暴"
),(
        100002,
        200001,
        "宿舍ap坏了",
        "假装有图",
        "网线短接，造成广播风暴"
    );-- 学生反馈
INSERT INTO feedback ( `feedback`, `fsno` )
VALUES
    ( "测试内容", 200001 ),(
    "测试内容",
    200001
),(
        "测试内容",
        200001
    );-- 功能模块
-- 学生功能
-- 登录
SELECT
    s.id,
    s.NAME,
    s.ADD,
    s.tel
FROM
    student s
WHERE
        s.sno = 200001
  AND s.`password` = 'testabc';-- 创建工单
INSERT INTO -- 查询所有工单
    SELECT
    s.id,
	s.NAME,
	s.ADD,
	s.tel,
	s.sno,
	o.mno,
	o.tpye,
	o.STATUS,
	o.detail,
	o.create_time,
	o.finish_time,
	o.update_time,
	o.pictur
FROM
    student s,
    orders o
WHERE
    o.sno = s.sno
  AND s.sno = 200001;-- insert into repair_table VALUE()
SELECT
    *
FROM
    worker;
SELECT
    *
FROM
    orders;
-- 师傅
-- 全部已完成的
SELECT
    w.id,
    w.NAME,
    w.tel,
    w.mno,
    o.id,
    o.mno,
    o.tpye,
    o.STATUS,
    o.detail,
    o.create_time,
    o.finish_time,
    o.update_time,
    o.pictur
FROM
    worker w,
    orders o
WHERE
        o.mno = w.mno
-- 	AND w.mno = 100002
  AND o.`status` = '2';
-- 全部待处理
SELECT
    w.id,
    w.NAME,
    w.tel,
    w.mno,
    o.mno,
    o.tpye,
    o.STATUS,
    o.detail,
    o.create_time,
    o.finish_time,
    o.update_time,
    o.pictur
FROM
    worker w,
    orders o
WHERE
        o.mno = w.mno
-- 	AND w.mno = 100002
  AND o.`status` = '0';
-- 管理员功能

-- 查询全部师傅

select * from worker;

-- 登录
SELECT
    a.username,
    a.`name`,
    a.tel,
    a.id
FROM
    admin a
WHERE
        a.username = 'admin'
  AND a.password= 'adminn';


-- 查询已完成
SELECT
    w.id,
    w.NAME,
    w.tel,
    w.mno,
    o.id,
    o.mno,
    o.tpye,
    o.STATUS,
    o.detail,
    o.create_time,
    o.finish_time,
    o.update_time,
    o.pictur
FROM
    worker w,
    orders o
WHERE
        o.mno = w.mno
-- 	AND w.mno = 100002
  AND o.`status` = '2';

select *
from orders where  `status`='2'

-- 	查询待分配
SELECT
    w.id,
    w.NAME,
    w.tel,
    w.mno,
    o.id,
    o.mno,
    o.tpye,
    o.STATUS,
    o.detail,
    o.create_time,
    o.finish_time,
    o.update_time,
    o.pictur
FROM
    worker w,
    orders o
WHERE
        o.mno = w.mno
-- 	AND w.mno = 100002
  AND o.`status` = '0';

-- UPDATE
-- 拓展
-- 查询学生建议
SELECT
    s.NAME "学生姓名",
    f.feedback "反馈内容/留言"
FROM
    student s,
    feedback f
WHERE
        s.sno = f.fsno;

-- 	删表数据
SELECT * from orders
delete from orders where id=11





-- 反馈查询
SELECT f.feedback,f.create_time from feedback f WHERE fsno=200001;



	