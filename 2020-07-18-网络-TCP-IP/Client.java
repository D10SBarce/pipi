import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        // 1.
        try (Socket socket = new Socket("49.233.172.121", 715)) {
            s.nextLine();
        }
    }
}