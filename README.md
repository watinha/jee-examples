JEE - Code-examples
===================
This is a source code repository
for storing Java Enterprise Edition
source code examples.

Feel free to download them. In order to
run these source codes you will need
to satisfy the .jar dependencies (putting
dependencies such as servlet-api,
mojarra-jsf, jdbc drivers, open-jpa,
among others).

The sample codes also provide a Makefile
with a rule which compile the source codes,
generate a .war file and attempts to
run the Jetty-runner servlet container
(this specific rule name is webserver).
In order to make use of this Makefile
rule you also need to correctly place
the jetty-runner jar file inside the
example directory.

The examples comprise:
* Servlets (with GET/POST parameters, Cookies, Sessions, Filters)
* JavaServer Pages
* JSP Standard Tag Library and Expression Language
* Model-View-Controllers based on Servlets/JSP/RequestDispatchers
* JDBC and Java Persistence API
* Java Server Faces
