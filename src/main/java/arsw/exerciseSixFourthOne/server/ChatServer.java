package arsw.exerciseSixFourthOne.server;


import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ChatServer extends Remote {
    void newClient(String cadena) throws RemoteException;
    void sendMessage(String mensaje) throws RemoteException;
}
