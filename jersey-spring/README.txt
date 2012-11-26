

javax.servlet 3.0
spring controller 3.0

Root Context : /test

Jetty

mvn clean install
mvn jetty:run

Tomcat

mvn clean install
mvn tomcat7:deploy   # or mvn tomcat7:deploy -Dtomcat.deploy.url=localhost:9080
