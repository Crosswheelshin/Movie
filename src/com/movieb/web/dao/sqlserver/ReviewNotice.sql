SELECT * FROM moviebdb;
SELECT * FROM REVIEW_NOTICE;
INSERT INTO REVIEW_NOTICE(
	CODE,
	TITLE,
	CONTENT,
	WRITER,
	REGDATE,
	MOVIE_TITLE,
	HIT)
VALUES(
	'4',
	'�ʷϹ�����ı�(��������)',
	'��̾�����������',
	'kttank3',
	'2016-10-26',
	'�ʷϹ����',
	'2'
	)
	
	SELECT * FROM REVIEW_NOTICE;
	

UPDATE SET


select top 1 * from REVIEW_NOTICE
		where code> cast('1'as int)
		order by regdate desc