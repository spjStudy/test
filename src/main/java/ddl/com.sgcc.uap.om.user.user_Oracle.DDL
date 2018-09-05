
    drop table TBL_USER cascade constraints;

    create table TBL_USER (
        USERID varchar2(20 char) not null,
        ID varchar2(50 char) not null,
        USERNAME varchar2(50 char),
        PW varchar2(20 char),
        AGE varchar2(50 char),
        GENDER varchar2(255 char),
        PHONE varchar2(20 char),
        EMAIL varchar2(50 char),
        CREATEDTIME varchar2(50 char),
        primary key (USERID)
    );

    comment on table TBL_USER is
        '用户信息表';

    comment on column TBL_USER.USERID is
        '用户编号';

    comment on column TBL_USER.ID is
        '用户表id主键';

    comment on column TBL_USER.USERNAME is
        '用户昵称';

    comment on column TBL_USER.PW is
        '密码';

    comment on column TBL_USER.AGE is
        '年龄';

    comment on column TBL_USER.GENDER is
        '性别';

    comment on column TBL_USER.PHONE is
        '电话';

    comment on column TBL_USER.EMAIL is
        '邮箱';

    comment on column TBL_USER.CREATEDTIME is
        '创建时间';
