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

-- 文章表
drop table if exists `article`;

create table `article` (
  id                  int unsigned        primary key auto_increment      comment '文章id',
  cat_id              int unsigned        not null                        comment '文章分类id, 外键',
  created_user        int unsigned        not null                        comment '创建人id, 外键',
  article_status      int unsigned        not null                        comment '文章状态, 0:草稿, 1:已发布',
  article_title       varchar(100)        not null                        comment '文章标题',
  article_content     text                not null                        comment '文章内容',
  article_cover       varchar(200)                                        comment '文章封面',
  created_time        datetime            not null default now()                    comment '创建时间, 文章发表时间',
  updated_time        datetime            not null default now() on update now()    comment '更新时间'
) auto_increment = 1, comment = '文章表' ;

insert into `article` (cat_id, created_user, article_status, article_title, article_content, article_cover)
values
    (1, 1, 1, '科技前沿', '科技前沿内容', 'path/to/cover1.jpg'),
    (2, 2, 1, '体育新闻', '体育新闻内容', 'path/to/cover2.jpg'),
    (3, 3, 1, '财经分析', '财经分析内容', 'path/to/cover3.jpg'),
    (4, 4, 1, '娱乐新闻', '娱乐新闻内容', 'path/to/cover4.jpg');

    
