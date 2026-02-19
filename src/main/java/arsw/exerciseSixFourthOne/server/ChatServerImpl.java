package arsw.exerciseSixFourthOne.server;

import arsw.exerciseSixFourthOne.client.ChatClient;
import arsw.exerciseSixFourthOne.client.ChatClientImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatServerImpl implements ChatServer {
    private final Set<ChatClient> clients = new HashSet<>();

    public ChatServerImpl(String ip, int puertoRMIregistry, String nombreDePublicacion) {
        try {
            System.setProperty("java.rmi.server.hostname", ip);

            ChatServer stub = (ChatServer) UnicastRemoteObject.exportObject(this, 0);


            Registry registry = LocateRegistry.createRegistry(puertoRMIregistry);

            registry.rebind(nombreDePublicacion, stub);

            System.out.println("Echo server ready...");
        } catch (Exception e) {
            System.err.println("Echo server exception:");
            e.printStackTrace();
        }
    }



    public void newClient(ChatClient client) throws RemoteException {
        clients.add(client);
    }

    public void sendMessage(String message, ChatClient client) throws RemoteException {
        for(ChatClient c: clients){
            if(!c.equals(client)){
               c.getMessage(message);
            }
        }
    }
}

// Se quita getSecurityManager debido a que esta deprecado y no es necesario para la prueba en un entorno local.
