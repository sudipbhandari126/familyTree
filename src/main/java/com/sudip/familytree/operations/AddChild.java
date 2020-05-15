package com.sudip.familytree.operations;


import com.sudip.familytree.service.FamilyService;

class AddChildCommand implements Command {
    private String motherName;
    private String childName;
    private String childGender;

    public AddChildCommand(String motherName, String childName, String childGender) {
        this.motherName = motherName;
        this.childGender = childGender;
        this.childName = childName;
    }


    @Override
    public void execute(FamilyService familyService) {
        System.out.println(familyService.addChild(motherName, childName, childGender));
    }
}

