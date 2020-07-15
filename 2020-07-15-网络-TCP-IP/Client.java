import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("49.233.172.121", 715)) {
            scanner.nextLine();
        }
    }
}