package tp;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
        	  Socket clientSocket = serverSocket.accept();
          

      
            System.out.println("Client connect�.");

            // Flux pour communiquer avec le client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            //  ici c'est la demande l'email
            output.println("Entrez votre email :");
            String email = input.readLine();

            //  ici c'est la demander  passwor
            output.println("Entrez votre mot de passe :");
            String password = input.readLine();

            // R�pondre au client
            output.println("Merci, " + email + ". Vous �tes connect� !");
            System.out.println("Client connect� avec l'email : " + email);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}