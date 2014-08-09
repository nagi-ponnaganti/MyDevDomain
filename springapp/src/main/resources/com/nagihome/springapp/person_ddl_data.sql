
drop table nagihome.person;

create table nagihome.person (
	person_id integer auto_increment primary key,
	person_first_name varchar(20) not null,
	person_last_name varchar(20) not null,
	person_age integer not null
);

insert into nagihome.person(person_first_name,  person_last_name, person_age) values("Nagi", "Ponnaganti", "28");

select * from nagihome.person

commit