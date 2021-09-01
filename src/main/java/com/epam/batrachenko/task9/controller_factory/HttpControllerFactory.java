package com.epam.batrachenko.task9.controller_factory;

import com.epam.batrachenko.task9.service.server.HttpServerService;
import com.epam.batrachenko.task9.service.server.ServerService;

import java.io.IOException;
import java.net.Socket;

public class HttpControllerFactory implements ControllersFactory{
    @Override
    public ServerService createService(Socket socket) throws IOException {
        return new HttpServerService(socket);
    }
}
