drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment comment '自增主键id',
   user_name            varchar(20) comment '用户名',
   age                  int comment '年龄',
   sex                  tinyint default 1 comment '性别 1:男 2:女',
   birthday             date comment '生日',
   score                decimal(5,2) comment '成绩 0-150',
   create_time          datetime,
   primary key (id)
);

alter table t_user comment '用户表';
