package com.epam.batrachenko.task9.service.server;

import com.epam.batrachenko.task9.tcp_command.TcpCommandContainer;
import com.epam.batrachenko.task9.util.parsers.TcpRequestParser;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class TCPServerService extends ServerService {
    private static final Logger log = LoggerFactory.getLogger(TCPServerService.class);

    public TCPServerService(Socket socket) throws IOException {
        super(socket);
        start();
    }

    @Override
    public void run() {
        String request;
        try {
            request = input.readLine();
            if (request == null) {
                return;
            }
            TcpRequestParser parser = new TcpRequestParser();
            output.write(new TcpCommandContainer().getCommandByName(parser.parseNameCommandFromRequest(request)).execute(request));
            output.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
