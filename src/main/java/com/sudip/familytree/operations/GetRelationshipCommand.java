package com.sudip.familytree.operations;

import com.sudip.familytree.service.PersonService;

public class GetRelationshipCommand implements Command {
    private String personName;
    private String relationshipName;

    public GetRelationshipCommand(String personName, String relationshipName) {
        this.personName = personName;
        this.relationshipName = relationshipName;
    }

    @Override
    public void execute(PersonService personService) {
        System.out.println(personService.findByRelation(personName, relationshipName));
    }
}
