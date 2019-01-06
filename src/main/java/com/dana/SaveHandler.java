package com.dana;

import com.dana.entities.Gender;
import com.dana.entities.Ranger;
import javafx.util.Pair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    public static final Logger logger = Logger.getLogger(App.class.getName());

    private static final String[] ATTRIBUTE_ARRAY = {"charisma", "intelligence", "speed", "strength", "awareness", "luck", "coordination"};
    private static final  String[] SKILL_ARRAY = {"weaponSmith", "toasterRepair", "spotLie", "sniperRifle", "smg", "shotgun",
            "safecrack", "rifle", "pickLock", "perception", "outdoorsman", "mechanicalRepair", "manipulate", "leadership",
            "intimidate", "handgun", "fieldMedic", "energyWeapons", "doctor", "demolitions", "computerTech", "combatShooting",
            "calvinBackerSkill", "bruteForce", "brawling", "bluntWeapons", "bladedWeapons", "barter", "animalWhisperer", "alarmDisarm",
            "atWeapons"};

    String content;
    List<String> personsInString;
    List<Ranger> persons;
    int currentWorkingIndex;


    public SaveHandler() {

    }

    String testThis() {
        Ranger thisRanger = persons.get(0);
        String toTest =  thisRanger.gender.toString();
        return toTest;
    }

    void init() throws Exception {

        personsInString = findPersonStrings();
        persons = collectPersons();
        currentWorkingIndex = 0;
    }

    void openFile(Path file) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        content = new String(Files.readAllBytes(file), charset);
        logger.info("File " + file.toString() + " opened.");
    }

    private List<String> findPersonStrings() throws Exception {
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
            logger.info("Person " + i + " added to the list of Ranger objects.");
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

        for (int i = 0; i < ATTRIBUTE_ARRAY.length; i++) {
            Pair<String, Integer> workingPair = findKeyValuePair(ATTRIBUTE_ARRAY[i], properties);
            newAttributes.put(workingPair.getKey(), workingPair.getValue());
        }
        newPerson.attributes = newAttributes;

        //skills
        Map<String, Integer> newSkills = new HashMap<>();
        properties = findParticularProperty("skillXps", personInString);

        for (int i = 0; i < SKILL_ARRAY.length; i++) {
            Pair<String, Integer> workingPair = findKeyValuePair(SKILL_ARRAY[i], properties);
            newSkills.put(workingPair.getKey(), workingPair.getValue());
        }
        newPerson.skills = newSkills;





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
