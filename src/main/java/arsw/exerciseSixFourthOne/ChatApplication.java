package arsw.exerciseSixFourthOne;

import arsw.exerciseSixFourthOne.client.ChatClient;
import arsw.exerciseSixFourthOne.client.ChatClientImpl;
import arsw.exerciseSixFourthOne.server.ChatServer;
import arsw.exerciseSixFourthOne.server.ChatServerImpl;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatApplication {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingresa la ip del servidor");
            String ip = sc.nextLine();
            System.out.println("Ingresa el socket que deseas usar");
            int socket = Integer.parseInt(sc.nextLine());
            ChatServer chatServer = new ChatServerImpl(ip, socket, "chatServer");
            ChatClient[] clients = {new ChatClientImpl(), new ChatClientImpl()};
            for(ChatClient c: clients){
                chatServer.newClient(c);
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
