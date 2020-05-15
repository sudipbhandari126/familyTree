
package com.sudip.familytree;

import com.sudip.familytree.exceptions.CommandNotFoundException;
import com.sudip.familytree.operations.FileProcessor;

import java.io.IOException;

public class FamilyTreeApplication {

    public static void main(String[] args) {
        meetTheFamily(args);
    }

    private static void meetTheFamily(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        if (args.length == 0) {
            System.out.println("Please give a valid input file containing commands");
            System.exit(-1);
        }
        String fileName = args[0];
        try {
            fileProcessor.process(fileName);
        } catch (IOException e) {
            //log
            e.printStackTrace();
        } catch (CommandNotFoundException e) {
            //log
            e.printStackTrace();
        }
    }


}
