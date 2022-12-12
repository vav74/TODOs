package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("{ \"type\": \"ADD\", \"task\": \"Пить коньяк\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Доить корову\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Штамповать детали\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Организовать ритуал\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Изготовить макет\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Почистить картофель\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Написать книгу\" }");
        list.add("{ \"type\": \"ADD\", \"task\": \"Встретится с министром\" }");
        list.add("{ \"type\": \"REMOVE\", \"task\": \"Штамповать детали\" }");
        list.add("{ \"type\": \"REMOVE\", \"task\": \"Изготовить макет\" }");
        list.add("{ \"type\": \"RESTORE\" }");
        list.add("{ \"type\": \"RESTORE\" }");
        list.add("{ \"type\": \"RESTORE\" }");
        list.add("{ \"type\": \"RESTORE\" }");

        String host = "localhost";
        int port = 8989;
        for (String cmd : list) {
            try (Socket clientSocket = new Socket(host, port);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                out.println(cmd);
                System.out.println(in.readLine());
            }
        }
    }
}