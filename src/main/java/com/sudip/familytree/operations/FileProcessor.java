package com.sudip.familytree.operations;

import com.sudip.familytree.exceptions.CommandNotFoundException;
import com.sudip.familytree.service.FamilyService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileProcessor {

    public void process(String fileName) throws IOException, CommandNotFoundException {
        FamilyService familyService = new FamilyService();
        familyService.loadFamilyTree();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String currentLine = null;
            while ((currentLine = bufferedReader.readLine()) != null) {
                Command command = CommandFactory.getCommand(currentLine.split(" "));
                command.execute(familyService);
            }
        } catch (IOException e) {
            //log
            throw e;
        } catch (CommandNotFoundException e) {
            //log
            throw e;
        } finally {
            if (Objects.nonNull(bufferedReader))
                bufferedReader.close();
        }
    }
}
