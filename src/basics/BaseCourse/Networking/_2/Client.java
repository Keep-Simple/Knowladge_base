package basics.BaseCourse.Networking._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 5000)) {

            clientSocket.setSoTimeout(5000); // setting waiting response time, and catching exception if hasn't responded

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed : ");
                echoString = scanner.nextLine();

                output.println(echoString);
                if (!echoString.equals("exit")) {
                    response = input.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("Socket timed out");
        } catch (IOException e) {
            System.out.println("Client Error : " + e.getMessage());
        }
    }
}
