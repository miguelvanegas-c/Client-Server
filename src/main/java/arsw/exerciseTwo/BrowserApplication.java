package arsw.exerciseTwo;


import java.io.*;
import java.net.URL;

public class BrowserApplication {
    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine;
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resultado.html"))) {
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                    bufferedWriter.write(inputLine);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    // Tecnologias viejas como URL, google redirige directamente la peticion a https, pero realmente
    // la petició es https.
}