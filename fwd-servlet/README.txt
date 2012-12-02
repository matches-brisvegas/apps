
Simple forwarding servlet that modifies the HTTP headers on the way through.

JETTY only - servlet cannot be dropped into another app server (tomcat tested).

Root Context : /proxy

Servlet base contexts:
/facebook
/facebook-graph
/wotif

Jetty

mvn clean install
mvn jetty:run
