package com.anli;


import com.anli.Service.Command;
import com.anli.Service.impl.AddCommand;
import com.anli.Service.impl.DivideCommand;
import com.anli.Service.impl.MultiCommand;
import com.anli.Service.impl.SubtractCommand;

import java.util.Stack;

public class Calculator {

    Stack<Command> redoCommand = new Stack<>();
    Stack<Command> undoCommand = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        undoCommand.push(command);

        if (!redoCommand.empty()) {
            redoCommand.clear();
        }

    }

    public void undo() {
        if (!undoCommand.empty()) {
            Command command = undoCommand.pop();
            command.undo();
            redoCommand.push(command);
        }
    }

    public void redo() {
        if (!redoCommand.isEmpty()) {
            Command command = redoCommand.pop();
            command.redo();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calculator commandManager = new Calculator();
        commandManager.executeCommand(new AddCommand("6", "8"));
        commandManager.executeCommand(new MultiCommand("10", "2"));
        commandManager.executeCommand(new DivideCommand("12", "2"));
        commandManager.executeCommand(new SubtractCommand("-10", "2"));
        commandManager.undo();
        commandManager.undo();
        commandManager.redo();
        commandManager.redo();
    }

}