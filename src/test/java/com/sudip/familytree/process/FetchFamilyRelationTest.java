package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;
import org.junit.Before;
import org.junit.Test;


public class FetchFamilyRelationTest {
    Person kingShan,queenAnga,Chit,Amba,Ish,Vich,Lika;

    @Before
    public void loadTestData(){
        kingShan = new Person("king shan", Gender.MALE);
        queenAnga = new Person("queen anga",Gender.FEMALE);
        kingShan.setWife(queenAnga);
        queenAnga.setHusband(kingShan);
    }


    @Test
    public void areCouples(){
        assert(kingShan.getWife().equals(queenAnga));
        assert(queenAnga.getHusband().equals(kingShan));
    }



}