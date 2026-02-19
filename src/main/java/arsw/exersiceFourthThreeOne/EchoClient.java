package arsw.exersiceFourthThreeOne;

import java.io.*;
import java.net.*;
public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 35000)) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader console = new BufferedReader(
                    new InputStreamReader(System.in));

            String line;
            while ((line = console.readLine()) != null) {
                out.write(line);
                out.newLine();
                out.flush();
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
    }

}

