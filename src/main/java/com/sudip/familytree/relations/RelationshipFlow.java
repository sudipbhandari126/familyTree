package com.sudip.familytree.relations;

import java.util.HashMap;
import java.util.Map;

public class RelationshipFlow {
    private Map<String, RelationShip> relationShipMap;

    public RelationshipFlow() {
        relationShipMap = new HashMap<>();
        relationShipMap.put("father", new FatherRelationShip());
        relationShipMap.put("mother", new MotherRelationShip());
        relationShipMap.put("sister", new SisterRelationship());
        relationShipMap.put("brother", new BrotherRelationship());
        relationShipMap.put("Maternal-Aunt", new MaternalAuntRelationship());
        relationShipMap.put("son", new SonRelationShip());
        relationShipMap.put("daughter", new DaughterRelationShip());
        relationShipMap.put("Paternal-Uncle", new PaternalUncleRelationship());
        relationShipMap.put("Paternal-Aunt", new PaternalAuntRelationship());
        relationShipMap.put("Maternal-Uncle", new MaternalUncleRelationship());
        relationShipMap.put("Brother-In-Law", new BrotherInLawRelationship());
        relationShipMap.put("Sister-In-Law", new SisterInLawRelationship());
        relationShipMap.put("Siblings", new SiblingsRelationShip());

    }

    public Map<String, RelationShip> getRelationShipMap() {
        return relationShipMap;
    }
}
