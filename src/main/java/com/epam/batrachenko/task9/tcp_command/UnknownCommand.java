package com.epam.batrachenko.task9.tcp_command;

public class UnknownCommand extends TcpCommand {
    @Override
    public String execute(String request) {
        return "Unknown command";
    }
}
