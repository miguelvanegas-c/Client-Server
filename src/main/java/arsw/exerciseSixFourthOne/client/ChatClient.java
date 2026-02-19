package arsw.exerciseSixFourthOne.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote {
    void getMessage(String message) throws RemoteException;
    void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
                         String nombreServicio) throws RemoteException;
}
