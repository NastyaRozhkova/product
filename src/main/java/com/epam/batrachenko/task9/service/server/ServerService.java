package com.epam.batrachenko.task9.service.server;

import com.epam.batrachenko.task9.commands.CommandContainer;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public abstract class ServerService implements Runnable {
    protected BufferedReader input;
    protected BufferedWriter output;
    protected CommandContainer commandContainer;
    
    protected ServerService(Socket socket, CommandContainer commandContainer) throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.commandContainer = commandContainer;
    }
}
