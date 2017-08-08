#Simple TCP server

This project contain a simple TCP server which is capable of handling multiple concurrent clients. The maximum number of clients serviceable at a given time.
After the maximum number of clients is reached, if requests are received still, then client request will be queued for a period of time until a thread in the tread pool are executed.
If maximum number of clients are reached to queue also, the other requests will be rejected.


##How to run

1. First should run the "Server.sh"
2. Then run the "Client.sh"

execute,
***shell
./Server.sh
./Client.sh
***