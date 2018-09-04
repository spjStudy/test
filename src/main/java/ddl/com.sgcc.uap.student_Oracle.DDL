
    drop table STUDENT cascade constraints;

    create table STUDENT (
        SNO varchar2(255 char) not null,
        SNAME varchar2(255 char) not null,
        SSEX varchar2(255 char) not null,
        SBIRTHDAY varchar2(255 char),
        STUDENTCLASS varchar2(255 char),
        primary key (SNO)
    );

    comment on table STUDENT is
        'Student';

    comment on column STUDENT.SNO is
        'SNO';

    comment on column STUDENT.SNAME is
        'SNAME';

    comment on column STUDENT.SSEX is
        'SSEX';

    comment on column STUDENT.SBIRTHDAY is
        'SBIRTHDAY';

    comment on column STUDENT.STUDENTCLASS is
        'STUDENTCLASS';
