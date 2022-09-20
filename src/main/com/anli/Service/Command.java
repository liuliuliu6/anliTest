package com.anli.Service;

public interface Command {
    String execute();

    String redo();

    String undo();

}
