package arsw.exerciseFourthFourth;

import java.net.*;
import java.io.*;
public class WebServer {
    public static void main(String[] args) throws IOException {

        try(
                ServerSocket serverSocket = new ServerSocket(35000);

        ) {
            try(
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()))
            ){
                System.out.println("Listo para recibir ...");
                String inputLine, outputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    if (!in.ready()) {
                        break;
                    }
                }
                outputLine = "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n"
                        + "</head>"
                        + "<body>"
                        + "My Web Site"
                        + "</body>"
                        + "</html>" + inputLine;

                String response =
                        "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length: " + outputLine.length() + "\r\n" +
                                "\r\n" +   // ← ESTA línea vacía separa headers del HTML
                                outputLine;
                out.println(response);
            }catch (IOException e) {

                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }

        }catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

    }
}

//String response =
//        "HTTP/1.1 200 OK\r\n" +
//                "Content-Type: text/html\r\n" +
//                "Content-Length: " + outputLine.length() + "\r\n" +
//                "\r\n" +   // ← ESTA línea vacía separa headers del HTML
//                outputLine;
//
// Fue necesario, porque antes los browsers eran más permisivos y hoy en día se exigen minimos en el encabezado, por lo tanto,
// se tuvo que agregar los siguientes campos.
// En busca de un codigo un poco más limpio se usaron try with resources para manejar de mejor forma el cierre
// de algunos objetos.
