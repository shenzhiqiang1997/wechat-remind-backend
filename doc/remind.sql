/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/27 20:49:25                           */
/*==============================================================*/

CREATE DATABASE remind;
drop table if exists remind;
drop table if exists formid;

/*==============================================================*/
/* Table: remind                                                */
/*==============================================================*/
create table remind
(
   remind_id            bigint not null auto_increment,
   sender_id            char(28),
   receiver_id          char(28),
   name          varchar(16),
   time                 datetime,
   title                char(10),
   content              varchar(50),
   self_remind          int,
   state                int,
   primary key (remind_id)
);

create table formid (
  formid char(32) not null primary key,
  openid char(28),
  date datetime
);

