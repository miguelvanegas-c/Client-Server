package arsw.exerciseSixFourthOne.server;


import arsw.exerciseSixFourthOne.client.ChatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ChatServer extends Remote {
    void newClient(ChatClient client) throws RemoteException;
    void sendMessage(String message, ChatClient client) throws RemoteException;
}
