package com.epam.batrachenko.task9.controller_factory;

import com.epam.batrachenko.task9.service.server.ServerService;
import com.epam.batrachenko.task9.service.server.TCPServerService;

import java.io.IOException;
import java.net.Socket;

public class TcpControllerFactory implements ControllersFactory {
    @Override
    public ServerService createService(Socket socket) throws IOException {
        return new TCPServerService(socket);
    }
}
