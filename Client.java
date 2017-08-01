import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 4444);


        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number: " );
        dataOutputStream.writeInt(scanner.nextInt());
        System.out.println("Server is responsed with multipication: " +dataInputStream.readInt()*10);
    }
}
