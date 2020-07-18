public class Server {
    public static void main(String[] args) {
        // 1.
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            // 2.
            try (Socket socket = serverSocket.accept()) {
                // 3.
            }
        }
    }
}