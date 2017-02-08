import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 45858000w on 08/02/17.
 */
public class HiloPeticion extends Thread{

    private Socket newSocket;

    public HiloPeticion() {
    }

    public HiloPeticion(Socket newSocket) {
        this.newSocket = newSocket;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = newSocket.getInputStream();

            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[50];
            is.read(mensaje);

            System.out.println("Mensaje recibido : "+ new String (mensaje));

            System.out.println("Cerrando el socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
