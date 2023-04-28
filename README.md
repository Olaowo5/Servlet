# Servlet

An assigement from Algonquin College CST 8233
This assignment combines the use of the DAO pattern with servlet.
The purpose of this project is to process a web client’s request to assign a course to a tutor.
The project will create a form a page asking the user to enter login credentials for a database
And inforamtion of a tutor, and their course.
It will then naviagete to another page with results from the information gotten on the form =================================================================================================================
  
  
Project Description

• You are given a tutoring database with the following tables with suitable data:
o course
o experience
o grade
o session
o student
o studentcourse
o turot
o tutorcourse
• The main outcome of the project is to assign a course to a tutor if the tutor is qualified.
• The project is to create a webpage that will accept the user id and password for the database, first name and lastname of the tutor and the coursecode of the course to be assigned
• The webpage will launch the servlet that will utilise the DAO implementation to validate the data, to assign the course to the turtor, and to obtain the required data.
• If the validation fails, then the servlet will return a suitable error message as a response to the servlet request.
• If the validation succeeds, then the servlet will return a table of all the tutors who are assigned to the course, including the one just got added.
• A person qualifies to tutor the course if that person is a tutor and had completed the course with the grade of “A-“, “A” or “A+”

Deliverables required
• Your application must be implement the following as Java packages:
o businesslayer
o dataaccesslayer (including an class to encapsulate the "data source")
o transferobjects
o viewlayer
• Your application must:
o use MySQL - SQL scripts provided with this assignment
o implement the DAO pattern
o create a servlet:
 that uses the DAO implementation and
 produces the required output for the given servlet request
o provide a Web page to launch the servlet
o initial Web page must prompt the end-user to enter the userid and password to authenticate to the MySQL database, the first name and lastname of the tutor, and the coursecode of the course to be assigned
o The servlet will produce the HTML output as the response to the servlet request. This will be either a suitable error message if the validation failed or a table of all the tutors who are assigned to the course, including the one just got added.
o You must follow Java coding conventions, rules of the DAO design pattern &
