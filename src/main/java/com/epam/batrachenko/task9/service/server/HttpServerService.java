package com.epam.batrachenko.task9.service.server;

import com.epam.batrachenko.task9.http_command.HttpCommand;
import com.epam.batrachenko.task9.http_command.HttpCommandContainer;
import com.epam.batrachenko.task9.util.JSONPrinter;
import com.epam.batrachenko.task9.util.parsers.HttpRequestParser;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerService extends ServerService {
    private static final Logger log = LoggerFactory.getLogger(HttpServerService.class);

    public HttpServerService(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        try {
            String line = input.readLine();
            if (line == null || !line.startsWith("GET")) {
                return;
            }
            String commandName = new HttpRequestParser().parseNameCommandFromRequest(line);
            HttpCommand command = new HttpCommandContainer().getCommandByName(commandName);
            new JSONPrinter().printInJson(output, command.execute(line));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
