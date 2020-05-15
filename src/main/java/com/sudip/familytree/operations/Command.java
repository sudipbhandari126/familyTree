package com.sudip.familytree.operations;

import com.sudip.familytree.service.FamilyService;

public interface Command {
    void execute(FamilyService familyService);
}
