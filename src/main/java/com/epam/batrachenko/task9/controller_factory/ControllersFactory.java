package com.epam.batrachenko.task9.controller_factory;

import com.epam.batrachenko.task9.commands.CommandContainer;
import com.epam.batrachenko.task9.service.server.ServerService;

import java.io.IOException;
import java.net.Socket;

public interface ControllersFactory {
    ServerService createService(Socket socket, CommandContainer commandContainer) throws IOException;
}
