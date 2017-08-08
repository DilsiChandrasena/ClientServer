mvn -f ./tcp-server/pom.xml clean install
java -cp ./tcp-server/target/tcp-server-1.0-SNAPSHOT.jar com.tcp.server.Server
