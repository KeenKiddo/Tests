1. База данных MySql, схема UserDB, username - root, password - root.
1.1. Выполнить sql-запрос в файле CreateTables.sql
2. Top250Downloader - приложения для выгрузки данных с кинопоиска
2.1. Запуск - java -jar Top250Downloader.jar
3. MoviesServlet - сервлет для выборки данных по дате
3.1. Положить MoviesServlet.war в <tomcatDir>/webapps
3.2. Запуск - http://localhost:8080/MoviesServlet/listRating.jsp