import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static int MIN_SIZE = 2;
    public static int MAX_SIZE = 4;
    public static int QUEUE_SIZE = 2;
    static Socket socket;
    static ServerSocket serverSocket;
    static ExecutorService executorService;
    private static int port = 4444;


    public Server(int poolSize, int port) {
        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue(QUEUE_SIZE);
        executorService = new ThreadPoolExecutor(MIN_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, queue);
    }

    public static void main(String[] args) {
        Server server = new Server(MAX_SIZE, port);
        try {
            server.startServer();
        } catch (IOException e) {
            System.out.println("Server is stopped");
            e.printStackTrace();
        }
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Listening to the client......");


        for (;;) {
            socket = serverSocket.accept();
            System.out.println("Client is connected to server");
            executorService.execute(new ThreadHandler(socket));
        }

    }
}
