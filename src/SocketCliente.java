import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 45858000w on 01/02/17.
 */
public class SocketCliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la IP");
        System.out.println("172.31.numClase.NumPC");
        String ip=sc.nextLine();

        for (int i = 0; i < 64512; i++) {

            try {
               // System.out.println("Creamos un cliente (creando socket)");

                //Socket de TCP
                Socket cliente = new Socket();
                //Socket de UDP
               // DatagramSocket udp = new DatagramSocket();

                //System.out.println("Estableciendo conexion");

                //localhost = 127.0.0.1
                InetSocketAddress addres = new InetSocketAddress(ip, i);

                cliente.connect(addres);

                InputStream is = cliente.getInputStream();
                OutputStream os = cliente.getOutputStream();

                //System.out.println("Enviando Mensaje");

                String mensaje = "Mi primer mensaje que navega";
                os.write(mensaje.getBytes());

                //System.out.println("Mensaje enviado");

                System.out.println("El puerto "+i+" esta abierto");

                //System.out.println("Cerrando el socket del cliente");

                cliente.close();

                //System.out.println("Terminado");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
