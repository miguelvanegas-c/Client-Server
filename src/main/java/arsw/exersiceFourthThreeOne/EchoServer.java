package arsw.exersiceFourthThreeOne;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) {

        int port = 35000;
        System.out.println("Servidor iniciado en puerto " + port);

        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true)
        ) {

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                int num = Integer.parseInt(inputLine);
                int result = num*num;
                System.out.println("Mensaje: " + result);

                if (inputLine.equalsIgnoreCase("bye")) {
                    out.println("Respuesta: Bye.");
                    break;
                }

                out.println("Respuesta: " + result);
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}

// Se mejoró la version antigua, haciendo el uso de herramientas como el try with resources, para que todos los elementos
// que están en el parenthesis de try se cierren automáticamente cuando se salga de try.
// Se usó scanner en vez de bufferRead, más legible y facil de usar.
// Esto se uso para todos los ejercicios relacionados con esto para hacerlo con un codigo mas limpio.