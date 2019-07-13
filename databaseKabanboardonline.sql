CREATE database KanbanBoardOnline;

use KanbanBoardOnline;

CREATE TABLE `users` (
  `username` varchar(255) primary key,
  `pass` varchar(255) NOT NULL
);
create table repository(
	id int PRIMARY key AUTO_INCREMENT,
	name NVARCHAR(100),
	username varchar(255) ,
	CONSTRAINT idtao foreign key (username) references users(username)
);

CREATE TABLE resgroup(
id int PRIMARY KEY AUTO_INCREMENT,
username varchar(255) ,
CONSTRAINT idtaoa foreign key (username) references users(username),
idR int ,
CONSTRAIrepositoryresgroupNT idtaob foreign key (idR) references Repository(id)
); 

create TABLE item(repositoryresgroup
id int primary key AUTO_INCREMENT,
idR int ,
CONSTRAINT idtaoab foreign key (idR) references Repository(id),
state NVARCHAR(10) default "Backlog",
content NVARCHAR(255)
);