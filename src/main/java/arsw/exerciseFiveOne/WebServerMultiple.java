package arsw.exerciseFiveOne;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class WebServerMultiple {

    public static void main(String[] args) {

        System.out.println("Servidor iniciado en puerto 35000...");

        try (ServerSocket serverSocket = new ServerSocket(35000)) {

            // Solo un cliente (como tú pediste)
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 OutputStream out = clientSocket.getOutputStream()) {

                System.out.println("Cliente conectado");

                while (true) {

                    String requestLine = in.readLine();
                    if (requestLine == null) break;

                    System.out.println("Request: " + requestLine);
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("Received: " + line);
                        if (!in.ready()) {
                            break;
                        }
                    }

                    String filePath = requestLine.split(" ")[1];

                    if (filePath.equals("/")) {
                        filePath = "/index.html";
                    }

                    String projectRoot = System.getProperty("user.dir");
                    File file = new File(projectRoot + "/www" + filePath);

                    if (file.exists() && !file.isDirectory()) {

                        byte[] fileData = Files.readAllBytes(file.toPath());
                        String contentType = getContentType(filePath);

                        String header =
                                "HTTP/1.1 200 OK\r\n" +
                                        "Content-Type: " + contentType + "\r\n" +
                                        "Content-Length: " + fileData.length + "\r\n" +
                                        "Connection: keep-alive\r\n" +
                                        "\r\n";

                        out.write(header.getBytes());
                        out.write(fileData);
                        out.flush();

                    } else {
                        String notFound = "<html><body><h1>404 Not Found</h1></body></html>";
                        String header =
                                "HTTP/1.1 404 Not Found\r\n" +
                                        "Content-Type: text/html\r\n" +
                                        "Content-Length: " + notFound.length() + "\r\n" +
                                        "\r\n";

                        out.write(header.getBytes());
                        out.write(notFound.getBytes());
                        out.flush();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getContentType(String filePath) {
        if (filePath.endsWith(".html") || filePath.endsWith(".htm")) {
            return "text/html";
        } else if (filePath.endsWith(".png")) {
            return "image/png";
        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filePath.endsWith(".css")) {
            return "text/css";
        } else {
            return "application/octet-stream";
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

