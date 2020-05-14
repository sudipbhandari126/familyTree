
package com.sudip.familytree;

import com.sudip.familytree.service.PersonService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        personService.loadFamilyTree();

        String fileName = args[0];

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(eachLine->{
                String[] parse = eachLine.split(" ");
                if (parse[0].equals("ADD_CHILD")){
                    System.out.println(personService.addChild(parse[1], parse[2], parse[3]));
                }
                else if (parse[0].equals("GET_RELATIONSHIP"))
                {
                    System.out.println(personService.findByRelation(parse[1], parse[2]));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
