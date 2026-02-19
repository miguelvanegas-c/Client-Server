package arsw.exerciseSixFourthOne.client;


import arsw.exerciseSixFourthOne.server.ChatServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author dnielben
 */
public class ChatClientImpl implements ChatClient{
    private boolean running = true;
    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
                                String nombreServicio) throws RemoteException {
        try (Scanner sc = new Scanner(System.in)){
            while(running) {
                Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
                ChatServer chatServer = (ChatServer) registry.lookup(nombreServicio);
                String message = sc.nextLine();
                chatServer.sendMessage(sc.nextLine(), this);
                if(message.equals("end")) running = false;
            }
        } catch (Exception e) {
            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }

    public void getMessage(String message) throws RemoteException {

    }
}
