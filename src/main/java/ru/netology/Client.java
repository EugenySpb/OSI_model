package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String HOST = "localhost";
    private static final int PORT = 8880;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String city = in.readLine();
            System.out.println(city);

            Scanner sc = new Scanner(System.in);
            String newCity = sc.nextLine();
            out.println(newCity);

            city = in.readLine();
            System.out.println(city);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}