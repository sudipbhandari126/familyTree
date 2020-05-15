package com.sudip.familytree.operations;

import com.sudip.familytree.service.PersonService;

public interface Command {
    void execute(PersonService personService);
}
