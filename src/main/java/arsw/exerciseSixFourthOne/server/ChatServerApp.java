package arsw.exerciseSixFourthOne.server;

import java.util.Scanner;

public class ChatServerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Chat Server RMI ===");
        System.out.print("Ingresa la IP del servidor (ej: localhost): ");
        String ip = sc.nextLine();
        
        System.out.print("Ingresa el puerto RMI registry (ej: 1099): ");
        int puerto = Integer.parseInt(sc.nextLine());
        
        // Iniciar el servidor
        new ChatServerImpl(ip, puerto, "chatServer");
        
        System.out.println("\nServidor de chat iniciado. Presiona Ctrl+C para detener.");
        
        // Mantener el servidor corriendo
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.println("Servidor detenido.");
        }
        
        sc.close();
    }
}