CREATE TABLE cdto( --캐릭터 입력 메소드 입력 순서 수정 필요 
  mid NVARCHAR2(20) PRIMARY KEY,
  balance NUMBER, --문제없음
  property NUMBER,
  happy NUMBER UNIQUE, --storetbl이 참조
  health NUMBER
);

commit;

select * from cdto;
drop table cdto;
update cdto SET happy = happy + 5 where mid = '준서';
SELECT * FROM storetbl;
--select sown from storetbl where sid = '포레나';
