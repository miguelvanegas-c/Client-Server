package arsw.exerciseSixFourthOne.client;


import arsw.exerciseSixFourthOne.server.ChatServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author dnielben
 */
public class ChatClientImpl implements ChatClient{
    private boolean running = true;
    private String username;
    
    public ChatClientImpl(String username) {
        this.username = username;
    }
    
    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
                                String nombreServicio) throws RemoteException {
        try {
            // Exportar el cliente como objeto remoto para recibir callbacks
            ChatClient clientStub = (ChatClient) UnicastRemoteObject.exportObject(this, 0);
            
            // Conectar al servidor
            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            ChatServer chatServer = (ChatServer) registry.lookup(nombreServicio);
            
            // Registrar el cliente en el servidor
            chatServer.newClient(clientStub);
            System.out.println("Conectado al chat como: " + username);
            System.out.println("Escribe 'end' para salir del chat");
            
            // Leer mensajes del usuario
            Scanner sc = new Scanner(System.in);
            while(running) {
                String message = sc.nextLine();
                if(message.equals("end")) {
                    running = false;
                    System.out.println("Desconectando del chat...");
                    break;
                }
                // Enviar mensaje al servidor con formato: [username]: mensaje
                chatServer.sendMessage(username + ": " + message, clientStub);
            }
            sc.close();
        } catch (Exception e) {
            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }

    public void getMessage(String message) throws RemoteException {
        System.out.println(message);
    }
}