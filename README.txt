FWA
ex00

1. Description
Web application prototype with Java Servlet API stack.
It provides HTML registration and authentication pages in response to /signIn and /signUp URL requests.
When registering (/signUp), a user specifies the following data:
• first name
• last name
• phone number
• password
• email
The information is stored in a database, while the password is encrypted
using BCrypt algorithm.

When authenticating (/signIn), a user specifies the following data:
• email
• password

All data go to SignUp servlet in a POST request using <form> HTML tag.
When a POST request is sent to SignIn servlet with an email and a password,
a check is performed if a corresponding user exists in the database, as well
as their password is correct.
If the check is successful, an HttpSession object with user attribute will be generated
(attribute’s value is an object containing current user data). The user will be redirected
to a blank profile page. In case of a failed authentication, user will be redirected
back to the login page.

2. Program requirements:
Java 8
Model Builder: Maven Wrapper (mvnw executable)
Web server: Apache Tomcat 9.0.69
Database: Postgres
Data for DB configuration: application.properties

2. Run program:
"./server_setup"
