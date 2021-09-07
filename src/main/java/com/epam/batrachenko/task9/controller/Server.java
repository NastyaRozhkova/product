package com.epam.batrachenko.task9.controller;

import com.epam.batrachenko.task9.commands.CommandContainer;
import com.epam.batrachenko.task9.controller_factory.ControllersFactory;
import com.epam.batrachenko.task9.util.Constants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server extends Thread {
    private static final Logger log = LoggerFactory.getLogger(Server.class);
    private final Integer port;
    private final ControllersFactory factory;
    private final CommandContainer commandContainer;

    public Server(Integer port, ControllersFactory factory, CommandContainer commandContainer) {
        this.port = port;
        this.factory = factory;
        this.commandContainer = commandContainer;
        start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.debug("Server started!");
            ExecutorService exe = Executors.newFixedThreadPool(Constants.LIMIT_REQUEST);
            while (!Thread.currentThread().isInterrupted()) {
                try (Socket socket = serverSocket.accept()) {
                    log.debug("Client connected!");
                    Future<?> future = exe.submit(factory.createService(socket, commandContainer));
                    future.get();
                    log.debug("Client disconnected!");
                }
            }
        } catch (IOException | InterruptedException | ExecutionException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
