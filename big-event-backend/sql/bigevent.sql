-- 创建数据库
drop database if exists `big_event`;
create database `big_event`;

use `big_event`;

 -- 用户表
drop table if exists `user`; 

create table `user`(
  user_id             int unsigned        primary key auto_increment              comment '用户id',
  username            varchar(30)         not null unique                         comment '用户名',
  password            varchar(32)         not null                                comment '密码',
  nickname            varchar(30)                                                 comment '昵称',
  email               varchar(30)         unique                                  comment '邮箱',
  user_pic            varchar(200)                                                comment '头像',
  created_time        datetime            not null default now()                   comment '创建时间',
  updated_time        datetime            not null default now() on update now()   comment '更新时间'
) auto_increment = 1, comment = '用户表';

insert into `user` (username, password, nickname, email, user_pic)
values
    ('john_doe', 'password123', 'John Doe', 'john@example.com', 'path/to/avatar1.jpg'),
    ('jane_smith', 'password456', 'Jane Smith', 'jane@example.com', 'path/to/avatar2.jpg'),
    ('alice_wang', 'password789', 'Alice Wang', 'alice@example.com', 'path/to/avatar3.jpg'),
    ('bob_lee', 'password012', 'Bob Lee', 'bob@example.com', 'path/to/avatar4.jpg'),
    ('charlie_liu', 'password345', 'Charlie Liu', 'charlie@example.com', 'path/to/avatar5.jpg');


-- 文档分类表
drop table if exists `article_cate`;

create table `article_cate`(
  id        int unsigned        primary key auto_increment      comment '文章分类id',
  cat_name  varchar(30)         not null unique                 comment '文章分类名称',
  cat_alias  varchar(30)        not null unique                 comment '文章分类别名',
  created_user int unsigned     not null                  comment '创建人id, 外键',
  created_time datetime         not null default now()           comment '创建时间',
  updated_time datetime         not null default now() on update now() comment '更新时间'
) auto_increment = 1, comment = '文章分类表' ;

insert into `article_cate` (cat_name, cat_alias, created_user)
values
    ('科技', 'tech', 1),
    ('体育', 'sports', 2),
    ('财经', 'finance', 3),
    ('娱乐', 'entertainment', 4),
    ('教育', 'education', 5);