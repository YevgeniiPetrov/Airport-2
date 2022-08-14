drop database if exists airport_employee;

create database airport_employee;

use airport_employee;

drop table if exists user;

create table user (
	id int auto_increment not null,
	email varchar(255) unique not null,
	first_name varchar(50) not null,
	last_name varchar(100) not null,
    password varchar(100) not null,
    role varchar(20) not null default 'USER',
	removed boolean,
	primary key(id)
);

drop table if exists post;

create table post (
	id int auto_increment not null,
	title varchar(32) unique not null,
	salary int not null,
	removed boolean,
	primary key(id)
);

drop table if exists employee;

create table employee (
	id int auto_increment not null,
	first_name varchar(32) not null,
	last_name varchar(32) not null,
	birth_date date not null,
	post_id int not null,
	removed boolean,
	primary key(id),
	foreign key(post_id) references post(id)
		on update cascade
		on delete restrict
);

insert into user
	(email, first_name, last_name, password)
values
	('yevgenii.petrov@mail.com', 'Yevgenii', 'Petrov', '$2a$12$E4NmY899OUrlaiY6CaGiyeqkRbqRsLP3E0cz25oKulHOrfFY9Ykui'),
    ('yevhen.petrov@mail.com', 'Yevgen', 'Petrov', '$2a$12$FJ3Gkds47ewwXA2CLGlXGOu63GN7YfcDoDsBQ4/vvSXSUOdyDjBOm');

insert into post
	(title, salary)
values
	('Pilot', 10000),
	('Commander', 15000),
	('Flight attendant', 5000),
	('Flight engineer', 8000),
	('Escort agent', 4000),
	('Aviation security specialist', 7000),
	('Technician', 5000),
	('Adjuster', 5000),
	('Equipment engineer', 6000),
	('Maintenance manager', 5000),
	('Cleaner', 2000),
	('Clinical Specialist', 5000),
	('Traffic controller', 7000),
	('Registration agent', 4000),
	('Airline manager', 6000),
	('Passport control specialist', 5000),
	('IT specialist', 7000),
	('Customs officer', 7000);

insert into employee
	(first_name, last_name, birth_date, post_id)
values
	('Tobe', 'Rawdall', '1977-11-24', 8),
	('Hobie', 'Jonah', '1973-01-15', 14),
	('Bethena', 'Kornes', '1971-09-30', 13),
	('Titus', 'Phaup', '1983-01-03', 11),
	('Bayard', 'Sicely', '1988-09-03', 11),
	('Mariel', 'Saxby', '1978-10-14', 8),
	('Brittany', 'Dayne', '1974-08-19', 9),
	('Clayborn', 'Axel', '1971-07-29', 11),
	('Francoise', 'Esterbrook', '1977-05-19', 5),
	('Dame', 'Bushen', '1991-09-23', 9),
	('Wendel', 'Jolin', '1988-09-06', 4),
	('Alexia', 'Sturgis', '1992-01-18', 5),
	('Bentley', 'Chettle', '1977-11-05', 3),
	('Humphrey', 'Idenden', '2003-11-20', 18),
	('Danie', 'Bugg', '1985-10-07', 2),
	('Harriett', 'Hunnam', '1985-02-19', 18),
	('Carl', 'Lovatt', '1994-10-15', 11),
	('Lazar', 'Taberner', '1998-08-01', 14),
	('Cort', 'Beddows', '1994-03-08', 17),
	('Care', 'De la Yglesia', '1997-02-12', 11),
	('Cati', 'Elix', '1989-10-02', 6),
	('Sibley', 'Emtage', '1977-01-10', 16),
	('Pam', 'Roots', '1979-11-26', 18),
	('Kelila', 'Heinsh', '1980-07-29', 6),
	('Kenn', 'Boyett', '1970-07-13', 5),
	('Huntington', 'Stripling', '1973-08-02', 9),
	('Valene', 'Ivanyushin', '1996-11-05', 15),
	('Nan', 'Tennick', '1980-08-07', 2),
	('Calhoun', 'Cannell', '1991-04-13', 9),
	('Odell', 'Enoch', '1997-03-24', 6),
	('Chelsey', 'Archbell', '1985-08-24', 3),
	('Lorettalorna', 'Itzchaki', '1982-04-04', 8),
	('Fred', 'McIndrew', '1991-11-28', 6),
	('Janith', 'McIlherran', '1986-11-13', 14),
	('Esmaria', 'Sheppey', '1988-07-26', 18),
	('Christophe', 'Swiggs', '1987-07-11', 2),
	('Gregoor', 'Surr', '1980-01-23', 5),
	('Jacky', 'McErlaine', '1970-03-23', 9),
	('Chuck', 'Olenin', '1981-04-20', 11),
	('Early', 'Thickens', '1984-10-29', 18),
	('Hildy', 'Moxson', '1983-12-05', 7),
	('Esteban', 'Aveyard', '1972-04-13', 11),
	('Torrence', 'Easterfield', '1979-10-20', 11),
	('Harlene', 'Noone', '1975-10-24', 9),
	('Christa', 'Clubb', '2001-11-29', 7),
	('Rolph', 'Booley', '1976-11-12', 15),
	('Sandie', 'Goodier', '1993-07-09', 9),
	('Cybil', 'Gaiger', '1997-12-20', 10),
	('Callida', 'Daubney', '1978-10-18', 11),
	('Archibaldo', 'Lancley', '1990-08-15', 8),
	('Kristen', 'Wicklin', '1991-09-17', 2),
	('Crissy', 'Debrett', '1971-08-01', 18),
	('Connie', 'Allred', '1987-05-25', 4),
	('Stillman', 'Hadigate', '1999-08-20', 3),
	('Jessie', 'Gerkens', '1988-01-27', 13),
	('Jaquith', 'Slee', '2003-07-08', 18),
	('Dahlia', 'Valentim', '1973-09-09', 17),
	('Caroline', 'Orrin', '1993-02-09', 3),
	('Nannie', 'Rudsdell', '1993-05-14', 1),
	('Jocelyne', 'Nicholls', '1981-07-22', 8),
	('Moira', 'Tarte', '1976-07-10', 6),
	('Brian', 'Farrants', '1996-02-24', 8),
	('Lilas', 'Rowbotham', '1991-11-16', 15),
	('Tommie', 'Lancley', '1981-08-08', 2),
	('Westbrook', 'Lars', '1996-03-14', 17),
	('Herman', 'Stonard', '1983-10-29', 17),
	('Jayme', 'McGettigan', '1979-05-30', 6),
	('Tore', 'Kemmett', '1976-10-08', 3),
	('Hector', 'Bushnell', '1997-01-04', 2),
	('Sandy', 'Whittington', '1998-08-31', 12),
	('Liana', 'Sibthorpe', '1986-01-08', 18),
	('Babbie', 'Nigh', '1995-05-18', 3),
	('Coleman', 'Carnduff', '1988-05-27', 16),
	('Erika', 'Coen', '1979-01-19', 6),
	('Eddie', 'Tribble', '1972-04-02', 1),
	('Parsifal', 'Hrihorovich', '2003-10-03', 14),
	('Carroll', 'Portwaine', '1979-12-02', 16),
	('Shell', 'Raffon', '2003-07-03', 17),
	('Demetre', 'Licciardiello', '1994-03-11', 16),
	('Waverley', 'Pendrigh', '1974-03-29', 8),
	('Miquela', 'Hischke', '1999-05-01', 18),
	('Stanford', 'Pfeiffer', '1997-03-07', 7),
	('Ashien', 'Vasey', '1996-07-11', 2),
	('Heath', 'Carley', '1977-12-05', 11),
	('Florenza', 'Lyver', '1993-04-13', 1),
	('Worth', 'Stears', '1972-07-08', 14),
	('Merrie', 'Bittlestone', '2003-11-30', 4),
	('Wileen', 'Leyson', '1981-11-29', 4),
	('Bridget', 'Lamblot', '2000-10-21', 16),
	('Evan', 'Crummy', '1989-09-06', 17),
	('Michal', 'Callaby', '1998-01-16', 2),
	('Leonie', 'Cordero', '1988-03-10', 18),
	('Kit', 'MacDermand', '1989-05-10', 3),
	('Alic', 'Jeynes', '1984-11-23', 18),
	('Roddie', 'D''Errico', '1972-01-02', 10),
	('Gerick', 'Claypole', '1985-08-26', 1),
	('Oralia', 'Gynni', '1994-08-06', 4),
	('Alair', 'Filippone', '1985-03-15', 2),
	('Norby', 'Pien', '1979-02-23', 7),
	('Oliver', 'Guerreiro', '1972-02-25', 2),
	('Issie', 'Lowater', '2001-03-02', 3),
	('Ella', 'Beven', '1982-04-10', 13),
	('Simon', 'Brennand', '1986-03-12', 5),
	('Sean', 'West-Frimley', '1981-03-24', 13),
	('Boote', 'Chipperfield', '1992-02-28', 1),
	('Alaric', 'Ferrieri', '1979-08-14', 5),
	('Marcela', 'Mandrey', '1977-07-01', 18),
	('Rhodie', 'Denacamp', '1995-09-26', 7),
	('Bernita', 'Birtle', '1995-08-08', 13),
	('Cathlene', 'Olivie', '2003-06-08', 11),
	('Lia', 'Eastham', '1981-05-09', 4),
	('Wang', 'Karolewski', '1985-07-10', 7),
	('Murvyn', 'Byham', '2000-10-12', 15),
	('Westbrook', 'Dracksford', '2000-10-04', 10),
	('Alidia', 'Haliday', '1972-09-13', 14),
	('Valdemar', 'Lydiard', '1990-06-21', 10),
	('Torin', 'Penas', '1971-10-19', 2),
	('Gustavus', 'Myner', '1971-10-28', 17),
	('Emmalee', 'Edgeley', '1990-10-31', 1),
	('Bastien', 'Ubanks', '2003-03-10', 3),
	('Willie', 'Vankov', '2002-02-27', 10),
	('Kendell', 'Glide', '1973-09-25', 10),
	('Crista', 'Dorkens', '1975-11-12', 1),
	('Karolina', 'Heinert', '1980-05-25', 5),
	('Clem', 'Sigart', '1987-06-24', 4),
	('Murdock', 'Edgcombe', '1992-09-29', 1),
	('Salvador', 'Worssam', '1974-04-23', 5),
	('Hestia', 'Jinda', '1982-01-03', 14),
	('Henrieta', 'Sandercock', '1996-05-02', 4),
	('Bartolemo', 'Harnott', '1991-04-15', 11),
	('Jelene', 'Adelberg', '2002-10-15', 9),
	('Tremayne', 'L'' Estrange', '1997-11-19', 10),
	('Dalli', 'Arnfield', '2000-09-17', 11),
	('Marya', 'Trench', '1981-04-13', 13),
	('Arlinda', 'Yorath', '1992-07-13', 4),
	('Branden', 'Drews', '1989-02-28', 13),
	('Kimbell', 'Saggs', '1970-12-09', 12),
	('Leonid', 'Tidd', '1977-07-25', 18),
	('Chaddie', 'Elsey', '1981-01-10', 4),
	('Micaela', 'Falls', '1999-07-20', 11),
	('Jackson', 'Nickols', '1985-07-09', 10),
	('Tamas', 'Dingivan', '1971-06-16', 5),
	('Rora', 'McGavigan', '1974-01-01', 12),
	('Teodora', 'Boffey', '2002-08-18', 8),
	('Abram', 'Howard - Gater', '2000-01-14', 11),
	('Gwenny', 'Redier', '2000-09-02', 11),
	('Chelsea', 'Borne', '2001-09-10', 5),
	('Feliza', 'Sygroves', '1975-04-04', 3),
	('Deirdre', 'Darree', '1979-07-26', 16),
	('Lambert', 'Brabon', '1990-06-05', 1),
	('Jonell', 'Arnald', '1980-07-27', 18),
	('Patti', 'Tottle', '1988-05-23', 13),
	('Latisha', 'Tizzard', '1999-07-19', 11),
	('Hilary', 'Swainston', '1986-05-17', 9),
	('Ethan', 'Cardow', '1992-03-15', 13),
	('Freedman', 'Kinnard', '2003-08-22', 17),
	('Alicia', 'Blaxland', '1993-05-31', 15),
	('Susanna', 'Housaman', '1994-07-19', 10),
	('Eleanora', 'Scowcroft', '1972-11-20', 8),
	('Terrijo', 'Lock', '2001-01-29', 16),
	('Rinaldo', 'Baythorp', '1980-03-24', 6),
	('Monroe', 'Davidou', '1989-06-04', 12),
	('Rowena', 'Wickerson', '2003-12-18', 14),
	('Wynny', 'Mosedale', '2000-04-03', 13),
	('Thurston', 'Primrose', '1976-07-12', 3),
	('Alasdair', 'Pickavant', '1988-04-25', 15),
	('Orella', 'Creeboe', '1971-03-22', 12),
	('Tobiah', 'Strapp', '1977-01-01', 10),
	('Harriott', 'Natte', '2003-03-17', 14),
	('Jeanelle', 'Sotheby', '1996-12-06', 16),
	('Kayla', 'Pegden', '1999-03-01', 13),
	('Xylia', 'Fairey', '2003-02-04', 8),
	('Kevan', 'Glazebrook', '1974-07-11', 9),
	('Hiram', 'Verrick', '1987-02-24', 11),
	('Hoyt', 'McAndrew', '2002-02-21', 3),
	('Kyle', 'Poat', '1981-11-10', 18),
	('Ira', 'Frome', '1971-05-03', 7),
	('Naoma', 'Cestard', '1974-10-31', 6),
	('Craggy', 'Mowett', '1987-11-27', 1),
	('Robin', 'Knott', '1982-06-23', 11),
	('Malina', 'Orht', '1976-08-20', 18),
	('Ardath', 'Clarkson', '1994-10-18', 7),
	('Susi', 'Enocksson', '2003-01-18', 9),
	('Sylvester', 'Ryves', '1986-05-19', 13),
	('Barbie', 'Latliff', '1981-05-08', 8),
	('Alanson', 'O''Lennane', '1997-05-16', 6),
	('Melinde', 'Thoresby', '1983-06-28', 2),
	('Consuela', 'Byforth', '1978-05-18', 10),
	('Amos', 'Chene', '1983-06-27', 7),
	('Hernando', 'Longrigg', '1998-11-08', 5),
	('Salomone', 'Ginie', '1982-11-04', 7),
	('Robbert', 'Du Plantier', '1979-10-01', 15),
	('Denice', 'Pink', '1988-05-01', 9),
	('Clari', 'Andrat', '1986-07-31', 9),
	('Iolanthe', 'Allam', '1988-03-25', 15),
	('Almeria', 'Galliford', '1982-08-23', 10),
	('Cristabel', 'Horwell', '1971-04-14', 1),
	('Rodolph', 'Cade', '1990-07-12', 7),
	('Luce', 'Deny', '1994-04-03', 4),
	('Rea', 'Hildrew', '1993-10-01', 5);