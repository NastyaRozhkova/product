package com.epam.batrachenko.task9.service.server;

import com.epam.batrachenko.task9.commands.Command;
import com.epam.batrachenko.task9.commands.CommandContainer;
import com.epam.batrachenko.task9.util.Constants;
import com.epam.batrachenko.task9.util.JSONPrinter;
import com.epam.batrachenko.task9.util.Parser;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerService extends ServerService {
    private static final Logger log = LoggerFactory.getLogger(HttpServerService.class);

    public HttpServerService(Socket socket, CommandContainer commandContainer) throws IOException {
        super(socket, commandContainer);
    }

    @Override
    public void run() {
        try {
            String line = input.readLine();
            if (line == null || !line.startsWith("GET")) {
                return;
            }
            String commandName = Parser.parseFromRequest(Constants.HTTP_GET_COMMAND, 2, line);
            Command command = commandContainer.getCommandByName(commandName);
            new JSONPrinter().printInJson(output, command.execute(line));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
