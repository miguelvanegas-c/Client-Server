package arsw.exerciseOne;

import java.net.MalformedURLException;
import java.net.URL;

public class URLInformation {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https:www.google.com");
        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getFile());
        System.out.println(url.getRef());

    }
    //Ejercicio sencillo.
}