CREATE TABLE cdto( --ĳ���� �Է� �޼ҵ� �Է� ���� ���� �ʿ� 
  mid NVARCHAR2(20) PRIMARY KEY,
  balance NUMBER, --��������
  property NUMBER,
  happy NUMBER UNIQUE, --storetbl�� ����
  health NUMBER
);

commit;

select * from cdto;
drop table cdto;
update cdto SET happy = happy + 5 where mid = '�ؼ�';
SELECT * FROM storetbl;
--select sown from storetbl where sid = '������';