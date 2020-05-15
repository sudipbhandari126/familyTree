package com.sudip.familytree.operations;

import com.sudip.familytree.service.FamilyService;

public class GetRelationshipCommand implements Command {
    private String personName;
    private String relationshipName;

    public GetRelationshipCommand(String personName, String relationshipName) {
        this.personName = personName;
        this.relationshipName = relationshipName;
    }

    @Override
    public void execute(FamilyService familyService) {
        System.out.println(familyService.findByRelation(personName, relationshipName));
    }
}
