FWA
##Веб приложение использующее Java Servlet API стек.
Web application prototype using Java Servlet API stack. The application will automate the booking business process of a movie theater later on.

ex00
An MVP application to partially implement registration and authentication mechanisms. The eb application should provide HTML registration and authentication pages in response to /signIn and /signUp URL requests, respectively.

ex01
Expanding the functionality of our application by providing an authorization mechanism.

ex02
Implementation of the profile page as a JSP file. Information about the date / time / IP address of all user authentications as a list shall also be displayed on this page.
Приложение позволяет регистрироваться новым пользователям, проходить аутентификацию существующим, загружать фотографии и видеть историю логинов пользователя. C помощью servlets, filters, listeners, repositories, services.

Servlet container: Apache Tomcat 9.0.63
Model Builder: Apache Maven
Данные для конфигурации базы данных храняться в application.properties

Для запуска приложения требуется запустить сначала класс Main. Main создаст схему и две таблицы: fwa.users и fwa.sessions. После этого можно поднимать сервер и все будет работать корректно.

Для тестирования аутентификации можно воспользоваться уже зарегистрированным пользователем со следующими данными:
Email: z.isupov@gmail.com
Password: pleaseHireMe

Веб-приложение предоставляет HTML-страницы регистрации и аутентификации в ответ на URL-запросы /signIn и /signUp.
Все данные передаются сервлету SignUp в запросе POST с использованием HTML-тега form. Информация хранится в базе данных, а пароль шифруется с использованием алгоритма BCrypt.

Когда запрос POST отправляется сервлету SignIn с адресом электронной почты и паролем, выполняется проверка, существует ли соответствующий пользователь в базе данных, а также правильность его пароля. В случае успешной проверки должен быть сгенерирован объект HttpSession с пользовательским атрибутом.

В случае неудачной аутентификации пользователь перенаправляется обратно на страницу входа. Spring context доступен для всех сервлетов через ServletContextListener.

Данные для подключения к базе доступны в application.properties.
Доступ к странице профиля только для аутентифицированных пользователей.
В целях безопасности создан Filter, который может обрабатывать запросы на /profile. Этот фильтр будет проверять наличие атрибута в текущем сеансе. Если атрибут найден, должен быть предоставлен доступ к запрошенному ресурсу (/profile в нашем случае).
Страницы для URL-адресов /signUp и /signIn могут быть получены для несанкционированных запросов. Если атрибут присутствует, пользователь будет перенаправлен на страницу /profile.
Также в случае несанкционированного запроса страницы, требующей атрибута, вернется статус 403 (FORBIDDEN).

Реализована страница профиля в виде файла JSP. На странице отображаются следующие текущие данные пользователя:

Имя
Фамилия
email

Информация о дате/времени/IP-адресе всех аутентификаций пользователей в виде списка. На странице есть функция загрузки «аватара» пользователя.
3. Program requirements:
maven
java 8
postgres (see properties)
2. Run program:
   mvn tomcat7:run