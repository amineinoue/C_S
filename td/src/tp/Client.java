package tp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connecté au serveur.");

            //  communiquer avec le serveur
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

            Scanner userInput = new Scanner(System.in);

            // Lire les messages du serveur et  les réondre a c'est message 
            System.out.println(serverInput.readLine()); 
            String email = userInput.nextLine();
            serverOutput.println(email);

            System.out.println(serverInput.readLine());
            String password = userInput.nextLine();
            serverOutput.println(password);

            System.out.println(serverInput.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
