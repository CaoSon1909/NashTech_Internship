CREATE DATABASE assignment_nashtech;

USE assignment_nashtech;

CREATE TABLE tblDepartment(
	depID int primary key not null,
	depName nvarchar(50) not null,
	depAddress text
);

CREATE TABLE tblEmployee(
	empID uniqueidentifier primary key not null,
	empName nvarchar(50) not null,
	empAddress text,
	empSalary decimal(18,0),
	empSex char(1) not null,
	empBirthdate datetime not null,
	depID int foreign key references tblDepartment(depID) not null,
);

