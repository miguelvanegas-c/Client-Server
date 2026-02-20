package arsw.exerciseSixFourthOne.client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatClientApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Chat Client RMI ===");
        System.out.print("Ingresa tu nombre de usuario: ");
        String username = sc.nextLine();
        
        System.out.print("Ingresa la IP del servidor (ej: localhost): ");
        String ip = sc.nextLine();
        
        System.out.print("Ingresa el puerto RMI registry (ej: 1099): ");
        int puerto = Integer.parseInt(sc.nextLine());
        
        // Crear y ejecutar cliente
        ChatClientImpl client = new ChatClientImpl(username);
        try {
            client.ejecutaServicio(ip, puerto, "chatServer");
        } catch (RemoteException e) {
            System.err.println("Error al conectar con el servidor:");
            e.printStackTrace();
        }
        
        sc.close();
    }
}