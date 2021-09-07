package com.epam.batrachenko.task9.service.server;

import com.epam.batrachenko.task9.commands.CommandContainer;
import com.epam.batrachenko.task9.util.Constants;
import com.epam.batrachenko.task9.util.Parser;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class TCPServerService extends ServerService {
    private static final Logger log = LoggerFactory.getLogger(TCPServerService.class);

    public TCPServerService(Socket socket, CommandContainer commandContainer) throws IOException {
        super(socket, commandContainer);
    }

    @Override
    public void run() {
        String request;
        try {
            request = input.readLine();
            if (request == null) {
                return;
            }
            output.write(commandContainer
                    .getCommandByName(Parser.parseFromRequest(Constants.TCP_GET_COMMAND, 1, request))
                    .execute(request));
            output.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
