/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/27 20:49:25                           */
/*==============================================================*/


drop table if exists remind;

/*==============================================================*/
/* Table: remind                                                */
/*==============================================================*/
create table remind
(
   remind_id            int(64) not null auto_increment,
   sender_id            char(28),
   receiver_id          char(28),
   sender_name          varchar(16),
   time                 datetime,
   title                char(10),
   self_remind          int,
   state                int,
   primary key (remind_id)
);

