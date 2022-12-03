-- 供应商表
CREATE TABLE t_supplier(
                           id INT PRIMARY KEY AUTO_INCREMENT COMMENT "供应商主键id",
                           supplier_name VARCHAR(255) NOT NULL UNIQUE COMMENT "供应商名称",
                           supplier_profile VARCHAR(255) DEFAULT NULL COMMENT "供应商简介",
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 产品表
CREATE TABLE t_product(
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT "产品主键id",
                          product_name VARCHAR(255) NOT NULL COMMENT "产品名称",
                          product_profile VARCHAR(255) DEFAULT NULL COMMENT "产品简介",
                          product_picture VARCHAR(255) DEFAULT NULL COMMENT "产品图片",
                          product_classify VARCHAR(255) NOT NULL COMMENT "产品大类，关联大类id",
                          product_type VARCHAR(255) NOT NULL COMMENT "产品小类",
                          product_value BIGINT DEFAULT 0 COMMENT "产品数量",
                          product_price DECIMAL DEFAULT 0.0 COMMENT "产品价格",
                          product_units VARCHAR(10) DEFAULT "个" COMMENT "产品数量单位",
                          product_warn INT DEFAULT 20 COMMENT "产品警告值",
                          product_status VARCHAR(10) DEFAULT "正常" COMMENT "产品状态",
                          product_supplier VARCHAR(10) DEFAULT NULL COMMENT "产品供应商",
                          product_operator VARCHAR(200) NOT NULL COMMENT "操作人",
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          create_time DATETIME DEFAULT NULL COMMENT '出库时间',
);

-- 产品种(大)类
CREATE TABLE t_classify(
                           id INT PRIMARY KEY AUTO_INCREMENT COMMENT "产品大类主键id",
                           classify_name VARCHAR(255) NOT NULL COMMENT "产品大类名称",
                           classify_operator VARCHAR(200) NOT NULL COMMENT "操作人",
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 产品种(小)类
CREATE TABLE t_type(
                       id INT PRIMARY KEY AUTO_INCREMENT COMMENT "产品大类主键id",
                       type_name VARCHAR(255) NOT NULL COMMENT "产品大类名称",
                       type_operator VARCHAR(200) NOT NULL COMMENT "操作人",
                       create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                       update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 出库记录
create table delivery(
                         id INT PRIMARY KEY AUTO_INCREMENT COMMENT '出库记录主键',
                         product_name varchar(200) not null COMMENT '出库产品名',
                         delivery_number BIGINT not null COMMENT '出库数量',
                         delivery_user varchar(50) not null  COMMENT '出库操作人',
                         delivery_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '出库时间'
);

-- 入库记录
create table storage(
                        id INT PRIMARY KEY AUTO_INCREMENT COMMENT '入库记录主键',
                        product_name varchar(200) not null COMMENT '入库产品名',
                        storage_number BIGINT not null COMMENT '入库数量',
                        storage_user varchar(50) not null  COMMENT '入库操作人',
                        storage_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间'
);

-- 用户表
CREATE TABLE t_user(
                       id INT PRIMARY KEY AUTO_INCREMENT COMMENT "用户主键id",
                       user_name VARCHAR (50) NOT NULL COMMENT "用户姓名",
                       user_id VARCHAR(20) NOT NULL UNIQUE COMMENT "登录用户名",
                       user_password VARCHAR(255) NOT NULL COMMENT "登录用户密码",
                       user_permission INT DEFAULT 0 COMMENT "用户权限",
                       user_status VARCHAR(10) DEFAULT "正常" COMMENT "用户状态",
                       create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                       update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 权限表，关联用户权限
CREATE TABLE t_permission(
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT "权限id主键",
                             permission_name VARCHAR(10) DEFAULT "员工" COMMENT '用户等级',
                             create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 用户token
-- CREATE TABLE t_token(
-- 
-- );

-- 用户操作记录，触发器实现
-- CREATE TABLE t_log(
-- id INT PRIMARY KEY AUTO_INCREMENT COMMENT "日志记录id主键",
-- log_control_name VARCHAR(10） COMMENT "操作名称",
-- log_control_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '操作记录时间'
-- );

-- 用户登录日志记录,触发器实现
-- CREATE TABLE t_login(
-- id INT PRIMARY KEY AUTO_INCREMENT COMMENT "日志记录id主键",
-- login_name VARCHAR(10） COMMENT "登录用户",
-- login_status VARCHAR(10） COMMENT "登录状态",
-- login_control_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '登录记录时间'
-- );
