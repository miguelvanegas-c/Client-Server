package arsw.exerciseSixFourthOne.server;

import arsw.exerciseSixFourthOne.client.ChatClient;
import arsw.exerciseSixFourthOne.client.ChatClientImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatServerImpl implements ChatServer {
    // Usar sincronización para thread-safety con múltiples clientes
    private final Set<ChatClient> clients = Collections.synchronizedSet(new HashSet<>());

    public ChatServerImpl(String ip, int puertoRMIregistry, String nombreDePublicacion) {
        try {
            System.setProperty("java.rmi.server.hostname", ip);

            ChatServer stub = (ChatServer) UnicastRemoteObject.exportObject(this, 0);

            Registry registry = LocateRegistry.createRegistry(puertoRMIregistry);

            registry.rebind(nombreDePublicacion, stub);

            System.out.println("Chat server ready on port " + puertoRMIregistry + "...");
            System.out.println("Server IP: " + ip);
        } catch (Exception e) {
            System.err.println("Chat server exception:");
            e.printStackTrace();
        }
    }

    public void newClient(ChatClient client) throws RemoteException {
        clients.add(client);
        System.out.println("New client connected. Total clients: " + clients.size());
        
        // Notificar a todos los demás clientes que hay un nuevo usuario
        broadcastSystemMessage(">>> Un nuevo usuario se ha unido al chat");
    }

    public void sendMessage(String message, ChatClient client) throws RemoteException {
        System.out.println("Broadcasting message: " + message);
        
        // Enviar el mensaje a todos los clientes excepto al emisor
        synchronized(clients) {
            for(ChatClient c: clients){
                if(!c.equals(client)){
                    try {
                        c.getMessage(message);
                    } catch (RemoteException e) {
                        System.err.println("Error sending message to client, removing from list");
                        clients.remove(c);
                    }
                }
            }
        }
    }
    
    private void broadcastSystemMessage(String message) throws RemoteException {
        synchronized(clients) {
            for(ChatClient c: clients){
                try {
                    c.getMessage(message);
                } catch (RemoteException e) {
                    System.err.println("Error sending system message to client");
                }
            }
        }
    }
}

// Se quita getSecurityManager debido a que esta deprecado y no es necesario para la prueba en un entorno local.