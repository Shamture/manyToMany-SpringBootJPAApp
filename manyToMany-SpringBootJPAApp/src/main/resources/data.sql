INSERT INTO student (id,  name) VALUES
	(1, 'TOM'),
	(2,  'DIK'),
	(3, 'HARRY'),
	(4, 'JOSE'),
	(5,  'JANET');

INSERT INTO subject (id, name) VALUES 
	(1, 'Comp103'),
	(2, 'Comp203');
	
INSERT INTO student_subject (student_id, subject_id) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(3, 2);
