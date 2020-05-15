package com.sudip.familytree.operations;

import com.sudip.familytree.exceptions.CommandNotFoundException;
import org.junit.Test;

public class CommandFactoryTest {

    @Test
    public void getCommandForGetRelationShipTestIsSuccess() throws CommandNotFoundException {
        Command command = CommandFactory.getCommand(new String[]{"GET_RELATIONSHIP", "Ram", "Paternal-Uncle"});
        assert command instanceof GetRelationshipCommand;
    }



    @Test(expected = CommandNotFoundException.class)
    public void getCommandForInvalidRelationShipTestThrowsError() throws CommandNotFoundException {
        Command command = CommandFactory.getCommand(new String[]{"BUILD_RELATIONSHIP", "Ram", "Paternal-Uncle"});
        assert command instanceof GetRelationshipCommand;
    }


    @Test
    public void getCommandForAddChildTestIsSuccess() throws CommandNotFoundException {
        Command command = CommandFactory.getCommand(new String[]{"ADD_CHILD", "Sita", "Luv","Male"});
        assert command instanceof AddChildCommand;
    }

}