package com.epam.batrachenko.task9.client;

import com.epam.batrachenko.task7.reflection.InputOutputData;
import com.epam.batrachenko.task9.util.Constants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", Constants.TCP_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            InputOutputData inputOutputData = new InputOutputData();
            log.debug("Client start");
            out.write(inputOutputData.getInput(Constants.INPUT_COMMAND) + "\n");
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
