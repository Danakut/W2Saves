package com.dana;

import com.dana.entities.Ranger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    String content;
    List<String> personsInString;
    List<Ranger> persons;

    public SaveHandler() {

    }

    String testThis() {
        Ranger thisRanger = persons.get(0);
//        String toTest = persons.get(0).name;
        String toTest =  thisRanger.name;
        return toTest;
    }

    void init() throws Exception {

        personsInString = findPersons();
        persons = collectPersons();
    }

    void openFile(Path file) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        content = new String(Files.readAllBytes(file), charset);
    }





    private List<String> findPersons() throws Exception {
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("<pc>");
        Matcher matcher = pattern.matcher(content);
        int startIndex;
        int endIndex;
        if (matcher.find()) {
            startIndex = matcher.start();
        } else {
            throw new Exception("No personsInString found in the savefile.");
        }

        //splits the main string into lesser Strings containing just one person each
        while (matcher.find()) {
            endIndex = matcher.start();
            String newPerson = content.substring(startIndex, endIndex);
            list.add(newPerson);
            startIndex = endIndex;
        }

        //the last person
        String newPerson = content.substring(startIndex);
        list.add(newPerson);
        return list;
    }

    private Ranger processPerson(String personInString) {
        Ranger newPerson = new Ranger();
        int startIndex;
        int endIndex;
        String resultString;
        int resultInt;

        //name
        Pattern patternStart = Pattern.compile("<displayName>");
        Matcher matcherStart = patternStart.matcher(personInString);
        matcherStart.find();
        startIndex = matcherStart.end();

        Pattern patternEnd = Pattern.compile("</displayName>");
        Matcher matcherEnd = patternEnd.matcher(personInString);
        matcherEnd.find();
        endIndex = matcherEnd.start();

        resultString = personInString.substring(startIndex, endIndex).trim();
        resultString = resultString.substring(3, resultString.length() - 3);

        newPerson.name = resultString;
        return newPerson;
    }

    private List<Ranger> collectPersons() {
        List<Ranger> list = new ArrayList<>();

        for (int i = 0; i < personsInString.size(); i++) {
            Ranger ranger = processPerson(personsInString.get(i));
            list.add(ranger);
        }

        return list;
    }



}
