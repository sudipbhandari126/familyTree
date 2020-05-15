package com.sudip.familytree.operations;

import com.sudip.familytree.exceptions.CommandNotFoundException;

public class CommandFactory {
    public static Command getCommand(String[] args) throws CommandNotFoundException {
        if (args[0].equals("ADD_CHILD")) {
            return new AddChildCommand(args[1], args[2], args[3]);
        } else if (args[0].equals("GET_RELATIONSHIP")) {
            return new GetRelationshipCommand(args[1], args[2]);
        } else throw new CommandNotFoundException("No such command");
    }
}
