package com.anli.Service;

public interface Command {
    void execute();

    void redo();

    void undo();
}
