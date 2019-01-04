package com.dana;

import com.dana.entities.Gender;
import com.dana.entities.Ranger;
import javafx.util.Pair;
import sun.text.resources.es.FormatData_es_EC;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    String content;
    List<String> personsInString;
    List<Ranger> persons;
    int currentWorkingIndex;

    public SaveHandler() {

    }

    String testThis() {
        Ranger thisRanger = persons.get(0);
//        String toTest = persons.get(0).name;
        String toTest =  thisRanger.gender.toString();
        return toTest;
    }

    void init() throws Exception {

        personsInString = findPersons();
        persons = collectPersons();
        currentWorkingIndex = 0;
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

    private List<Ranger> collectPersons() {
        List<Ranger> list = new ArrayList<>();

        for (int i = 0; i < personsInString.size(); i++) {
            Ranger ranger = processPerson(personsInString.get(i));
            list.add(ranger);
        }

        return list;
    }

    private Ranger processPerson(String personInString) {
        Ranger newPerson = new Ranger();
        String workingString;
        currentWorkingIndex = 0;

        //name
        workingString = findParticularProperty("displayName", personInString);
        workingString = workingString.substring(3, workingString.length() - 3);
        newPerson.name = workingString;

        //portrait
        workingString = findParticularProperty("portraitName", personInString);
        newPerson.portraitName = workingString;

        //gender
        workingString = findParticularProperty("gender", personInString);
        if (workingString.equals("1")) {
            newPerson.gender = Gender.MALE;
        } else if (workingString.equals("2")) {
            newPerson.gender = Gender.FEMALE;
        } else {
            newPerson.gender = Gender.UNKNOWN;
        }

        //religion
        workingString = findParticularProperty("religion", personInString);
        newPerson.religion = workingString;

        //smokes
        workingString = findParticularProperty("smokes", personInString);
        newPerson.smokes = workingString;

        //ethnicity
        workingString = findParticularProperty("ethnicity", personInString);
        newPerson.ethnicity = workingString;

        //biography
        workingString = findParticularProperty("biography", personInString);
        newPerson.biography = workingString;

        //skin color
        workingString = findParticularProperty("skinColor", personInString);
        newPerson.skinColor = Integer.parseInt(workingString);

        //age
        workingString = findParticularProperty("age", personInString);
        newPerson.age = Integer.parseInt(workingString);

        //level
        workingString = findParticularProperty("level", personInString);
        newPerson.level = Integer.parseInt(workingString);

        //xp
        workingString = findParticularProperty("xp", personInString);
        newPerson.exp = Integer.parseInt(workingString);

        //current HP
        workingString = findParticularProperty("curHp", personInString);
        newPerson.currentHp = Integer.parseInt(workingString);

        //size
        workingString = findParticularProperty("size", personInString);
        newPerson.size = Integer.parseInt(workingString);

        //kills
        workingString = findParticularProperty("noOfKills", personInString);
        newPerson.numberOfKills = Integer.parseInt(workingString);

        //damage done
        workingString = findParticularProperty("damageDone", personInString);
        newPerson.damageDone = Integer.parseInt(workingString);

        //available attribute points
        workingString = findParticularProperty("availableAttributePoints", personInString);
        newPerson.availAttrPoints = Integer.parseInt(workingString);

        //available skill points
        workingString = findParticularProperty("availableSkillPoints", personInString);
        newPerson.availSkillPoints = Integer.parseInt(workingString);

        //available perk points
        workingString = findParticularProperty("availableTraitPoints", personInString);
        newPerson.availTraitPoints = Integer.parseInt(workingString);

        //attributes
        Map<String, Integer> newAttributes = new HashMap<>();

        String properties = findParticularProperty("attributes", personInString);
        Pair<String, Integer> workingPair = findKeyValuePair("charisma", properties);
//        newAttributes.put("charisma", 0);
//        newAttributes.put("intelligence", 0);
//        newAttributes.put("speed", 0);
//        newAttributes.put("strength", 0);
//        newAttributes.put("awareness", 0);
//        newAttributes.put("luck", 0);
//        newAttributes.put("coordination", 0);




        return newPerson;

    }

    private String findParticularProperty(String patternString, String personInString) {
        int startIndex;
        int endIndex;
        String resultString;

        Pattern patternStart = Pattern.compile("<" + patternString + ">");
        Matcher matcherStart = patternStart.matcher(personInString);
        matcherStart.region(currentWorkingIndex, personInString.length());
        matcherStart.find();
        startIndex = matcherStart.end();

        Pattern patternEnd = Pattern.compile("</" + patternString + ">");
        Matcher matcherEnd = patternEnd.matcher(personInString);
        matcherEnd.find();
        endIndex = matcherEnd.start();

        currentWorkingIndex = matcherEnd.end();
        resultString = personInString.substring(startIndex, endIndex).trim();
        return resultString;
    }

    private Pair<String, Integer> findKeyValuePair(String keyString, String stringToSearch) {
        Pattern keyPattern = Pattern.compile(keyString);
        Matcher keyMatch = keyPattern.matcher(stringToSearch);
        keyMatch.find();
        int searchFrom = keyMatch.end();

        Pattern valuePattern = Pattern.compile("\\d+");
        Matcher valueMatch = valuePattern.matcher(stringToSearch);
        valueMatch.region(searchFrom, stringToSearch.length());
        valueMatch.find();
        String valueString = valueMatch.group();

        return new Pair<>(keyString, Integer.valueOf(valueString));
    }





}
