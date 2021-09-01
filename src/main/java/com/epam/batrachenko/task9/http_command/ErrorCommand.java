package com.epam.batrachenko.task9.http_command;

public class ErrorCommand extends HttpCommand{
    @Override
    public String execute(String request) {
        return "Error";
    }
}
