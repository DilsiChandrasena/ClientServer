mvn -f ./tcp-client/pom.xml clean install
java -cp ./tcp-client/target/tcp-client-1.0-SNAPSHOT.jar com.tcp.client.Client