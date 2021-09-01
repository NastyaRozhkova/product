package com.epam.batrachenko.task9.service.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerService extends Thread {
    protected BufferedReader input;
    protected BufferedWriter output;

    public ServerService(Socket socket) throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
}
