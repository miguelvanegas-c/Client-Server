package arsw.exerciseFiveTwoOne;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import  java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeClient {
    private static boolean running = true;
    private static String date;
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            String received = "";
            while(running) {

                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                try {
                    socket.receive(packet);
                    received = new String(packet.getData(), 0, packet.getLength());
                } catch (SocketTimeoutException ignored) {

                }

                System.out.println("Date: " + received);
                date = received;
                Thread.sleep(5000);
            }
        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// Correciones, primero las excepciones se manejan de igual forma y todas tienen su propio catch, por lo tanto, es posible reducirlas a un solo caso
// Uso de try with resoources