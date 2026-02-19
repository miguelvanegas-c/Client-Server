package arsw.exerciseSixFourthOne.server;

import arsw.exerciseSixFourthOne.client.ChatClientImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class ChatServerImpl implements ChatServer {
    private ChatClientImpl chatClientOne;
    private ChatClientImpl chatClientTwo;

    public ChatServerImpl(String ip, int puertoRMIregistry, String nombreDePublicacion) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            ChatServer stub = (ChatServer) UnicastRemoteObject.exportObject(this, 0);


            Registry registry = LocateRegistry.createRegistry(puertoRMIregistry);

            registry.rebind(nombreDePublicacion, stub);

            System.out.println("Echo server ready...");
        } catch (Exception e) {
            System.err.println("Echo server exception:");
            e.printStackTrace();
        }
    }



    public void newClient(String cadena) throws RemoteException {

    }

    public void sendMessage(String mensaje) throws RemoteException {

    }
}

// Se quita getSecurityManager debido a que esta deprecado y no es necesario para la prueba en un entorno local.
