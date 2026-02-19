package arsw.exerciseSixFourthOne.client;


import arsw.exerciseSixFourthOne.server.ChatServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author dnielben
 */
public class ChatClientImpl {
    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
                                String nombreServicio) {
        try {
            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            ChatServer echoServer = (ChatServer) registry.lookup(nombreServicio);
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            echoServer.sendMessage(sc.nextLine());
        } catch (Exception e) {
            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        ChatClientImpl ec = new ChatClientImpl();
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");
    }
}
