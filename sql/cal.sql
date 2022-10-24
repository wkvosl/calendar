 -- 아직 모르겠지만, Table  ' ' doesn't exist라고 에러남.. 
 -- 테이블이 없다는 뜻임... 그래서 ui로 테이블 만듦;
 
 
 -- 이거 안하면 에러1049, schema?? 처음엔 그냥 만들어졌는데
create database homepage1;

create table homepage1.cal(
-- utf8mb4인 경우  191 x 4 = 764 bytes

memo_id int primary key auto_increment,
memo_date varchar(100), 
memo_title varchar(100),
memo_write varchar(191)

 -- 회원id foreign key

);


commit;
select * from homepage1.cal;
drop table homepage1.cal;