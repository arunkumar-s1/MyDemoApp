/* creating vehicle table */
create table vehicle(v_id int primary key,v_name varchar(10),wheels int,seats int,number_plate varchar(28));

/* creating auto increment id for vehicle */
CREATE SEQUENCE seq_person
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

/*inserting values to vechicle */
insert into vehicle values(seq_person.nextval,'Audi',4,10,'TN-05 AA');
select * from vehicle

/* creating advertisement table */
create table advertisement(name varchar(10),id int primary key,kilometer varchar(10),user_posted varchar(10))

/*inserting values to advertisement */
insert into advertisement values('Audi',4,'55km','This is a Car');