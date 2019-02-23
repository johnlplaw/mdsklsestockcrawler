create database MDSKLSE;
use MDSKLSE;

drop table KLSE;

create table KLSE (

thedate date,
comp_name char(100),
comp_code char(50),
open char(10),
low char(10),
high char(10),
lastDone char(10),
chg char(10),
chgPercent char(10),
vol char(10),
buy char(30),
sell char(30),
crawl_Timestamp timestamp
);


select * from klse;

Coding test:
select STR_TO_DATE('22 Feb 2019', '%d %M %y')
SHOW VARIABLES LIKE "%version%";
