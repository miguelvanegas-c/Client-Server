package arsw.exerciseFourthThreeTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerFun {

    public static void main(String[] args) {

        int port = 35001;
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
            String function = "fun:sin";
            while ((inputLine = in.readLine()) != null) {
                double result = makeOperation(inputLine, function);
                if (inputLine.equalsIgnoreCase("bye")) {
                    out.println("Respuesta: Bye.");
                    break;
                }

                out.println("Respuesta: " + result);

            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
    private static double makeOperation(String inputLine,String function) {
        int num = 0;
        try {
            num = Integer.parseInt(inputLine);
        } catch (NumberFormatException e) {
            function = chooseOperation(inputLine, function);
        }
        return switch (function) {
            case "fun:sin" -> Math.sin(num);
            case "fun:cos" -> Math.cos(num);
            case "fun:tan" -> Math.tan(num);
            default -> 0;
        };
    }

    private static String chooseOperation(String inputLine,String function) {
        if (inputLine.equals("fun:sin") || inputLine.equals("fun:cos") || inputLine.equals("fun:tan")) {
            return inputLine;
        }
        return function;
    }
}

