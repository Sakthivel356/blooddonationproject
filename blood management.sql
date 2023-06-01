create database  blood_managent;

create table donor_details(donor_id int primary key,donor_name varchar(20)unique,donor_age int ,
gender_id int,
donor_contact long,donor_weight int ,address_id int);create database blood_management;
select * from donor_details;
delete  from donor_details where  donor_id=0;