package com.dana;

import com.dana.Exceptions.KeyNotFoundException;
import com.dana.Exceptions.PropertyNotAssembledException;
import com.dana.Exceptions.ValueNotFoundException;
import com.dana.entities.Gender;
import com.dana.entities.Ranger;
import com.dana.entities.Skill;
import com.dana.entities.Trait;
import javafx.util.Pair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    private static final Logger appLogger = Logger.getGlobal();
    private static final Handler appHandler = new ConsoleHandler();
    private Level reportLevel = Level.INFO;

    private static final String[] ATTRIBUTE_ARRAY = {"charisma", "intelligence", "speed", "strength", "awareness", "luck", "coordination"};

    String content;
    List<String> personsInString;
    List<Ranger> persons;
    int currentWorkingIndex;


    public SaveHandler() {
        appHandler.setLevel(reportLevel);

        appLogger.addHandler(appHandler );
        appLogger.setLevel(reportLevel);
        appLogger.setUseParentHandlers(false);
    }

    String testThis() {
        Ranger thisRanger = persons.get(0);
        String toTest =  thisRanger.gender.toString();
        return toTest;
    }

    void init() throws Exception {

        personsInString = findPersonStrings();
        persons = collectPersons();
        int test = 1;
    }

    void openFile(Path file) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        content = new String(Files.readAllBytes(file), charset);
        appLogger.info("File " + file.toString() + " opened.");

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

    //processes list "personsInString" into a list of Ranger objects
    private List<Ranger> collectPersons() {
        List<Ranger> list = new ArrayList<>();

        for (int i = 0; i < personsInString.size(); i++) {
            Ranger ranger = null;
            try {
                ranger = processPerson(personsInString.get(i));

                appLogger.info("Person " + i + " added to the list of Ranger objects.");
            } catch (PropertyNotAssembledException e) {
                appLogger.info("Person " + i + " could not be processed. Moving on.");
            }

            list.add(ranger);
        }

        return list;
    }

    public int getRangerCount() {
        return persons.size();
    }

    public Ranger getRanger(int listIndex) {
        return persons.get(listIndex);
    }

    //processes a string detailing one person into a Ranger object
    private Ranger processPerson(String personInString) throws PropertyNotAssembledException {
        Ranger newPerson = new Ranger();
        String workingString;
        currentWorkingIndex = 0;

        //name
        workingString = findParticularProperty("displayName", personInString);
        workingString = workingString.substring(3, workingString.length() - 3);
        newPerson.name = workingString;
        appLogger.fine(newPerson.name + ": name processed.");

        //portrait
        workingString = findParticularProperty("portraitName", personInString);
        newPerson.portraitName = workingString;
        appLogger.fine(newPerson.name + ": portrait processed.");

        //gender
        workingString = findParticularProperty("gender", personInString);
        if (workingString.equals("1")) {
            newPerson.gender = Gender.MALE;
        } else if (workingString.equals("2")) {
            newPerson.gender = Gender.FEMALE;
        } else {
            newPerson.gender = Gender.UNKNOWN;
        }
        appLogger.fine(newPerson.name + ": gender processed.");

        //religion
        workingString = findParticularProperty("religion", personInString);
        newPerson.religion = workingString;
        appLogger.fine(newPerson.name + ": religion processed.");

        //smokes
        workingString = findParticularProperty("smokes", personInString);
        newPerson.smokes = workingString;
        appLogger.fine(newPerson.name + ": smokes processed.");

        //ethnicity
        workingString = findParticularProperty("ethnicity", personInString);
        newPerson.ethnicity = workingString;
        appLogger.fine(newPerson.name + ": ethnicity processed.");

        //biography
        workingString = findParticularProperty("biography", personInString);
        newPerson.biography = workingString;
        appLogger.fine(newPerson.name + ": biography processed.");

        //skin color
        workingString = findParticularProperty("skinColor", personInString);
        newPerson.skinColor = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": skin color processed.");

        //age
        workingString = findParticularProperty("age", personInString);
        newPerson.age = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": age processed.");

        //level
        workingString = findParticularProperty("level", personInString);
        newPerson.level = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": level processed.");

        //xp
        workingString = findParticularProperty("xp", personInString);
        newPerson.exp = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": exp processed.");

        //current HP
        workingString = findParticularProperty("curHp", personInString);
        newPerson.currentHp = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": currentHitpoints processed.");

        //size
        workingString = findParticularProperty("size", personInString);
        newPerson.size = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": size processed.");

        //kills
        workingString = findParticularProperty("noOfKills", personInString);
        newPerson.numberOfKills = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": number of kills processed.");

        //damage done
        workingString = findParticularProperty("damageDone", personInString);
        newPerson.damageDone = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": damage done processed.");


        //available attribute points
        workingString = findParticularProperty("availableAttributePoints", personInString);
        newPerson.availAttrPoints = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": available attr points processed.");

        //available skill points
        workingString = findParticularProperty("availableSkillPoints", personInString);
        newPerson.availSkillPoints = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": available skill points processed.");

        //available perk points
        workingString = findParticularProperty("availableTraitPoints", personInString);
        newPerson.availTraitPoints = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": available trait points processed.");

        //Ranger or Follower?
        workingString = findParticularProperty("isCNPC", personInString);
        newPerson.isCNPC = Boolean.parseBoolean(workingString);
        appLogger.fine(newPerson.name + ": CNPC processed.");

        //lucky hitpoints
        workingString = findParticularProperty("luckyHitpoints", personInString);
        newPerson.luckyHp = Integer.parseInt(workingString);
        appLogger.fine(newPerson.name + ": lucky hitpoints processed.");

        //attributes
        Map<String, Integer> newAttributes = new HashMap<>();
        String properties = findParticularProperty("attributes", personInString);

        for (int i = 0; i < ATTRIBUTE_ARRAY.length; i++) {
            Pair<String, Integer> workingPair = null;
            try {
                workingPair = findKeyValuePair(ATTRIBUTE_ARRAY[i], properties);
            } catch (Exception ex) {
                throw new PropertyNotAssembledException("Processing person \"" + newPerson.name + "\" failed at Attributes", ex);
            }
            newAttributes.put(workingPair.getKey(), workingPair.getValue());
        }

        newPerson.attributes = newAttributes;
        appLogger.fine(newPerson.name + ": attributes processed.");

        //skills
        properties = findParticularProperty("skillXps", personInString);
        Pair<String, Integer> skillPair = null;

        for (String skillXmlName : Skill.SKILL_MAP.keySet()) {
            try {
                skillPair  = findKeyValuePair(skillXmlName, properties);
            } catch (Exception ex) {
                throw new PropertyNotAssembledException("Processing person \"" + newPerson.name + "\" failed at Skills", ex);
            }
            if (skillPair.getValue() > 0) {
                newPerson.setSkillValue(skillPair.getKey(), skillPair.getValue());
                appLogger.finer(newPerson.name + ": skill " + skillPair.getKey() + ", value " + skillPair.getValue());
            }
        }
        appLogger.fine(newPerson.name + ": skills processed.");

        //traits
        properties = findParticularProperty("traits", personInString);
        List<Trait> newTraits = new ArrayList<>();

        if (!properties.equals("")) {
            List<Pair<String, Integer>> traitPairs = findTraitPairs(properties);

            for (Pair<String, Integer> traitPair : traitPairs) {
                Trait newTrait = Trait.TRAIT_MAP.get(traitPair.getKey());
                if (newTrait != null) {
                    newTrait.setValue(traitPair.getValue());
                    newTraits.add(newTrait);
                } else throw new PropertyNotAssembledException
                        ("Processing person \"" + newPerson.name + "\" failed at Traits: " + traitPair.getKey() );
            }
        }

        newPerson.traits = newTraits;
        appLogger.fine(newPerson.name + ": traits processed.");

        return newPerson;
    }

    private String findParticularProperty(String patternString, String personInString) {

        //find the (end of the) opening tag (search from the index where we're currently at)
        Pattern patternStart = Pattern.compile("<" + patternString + ">");
        Matcher matcherStart = patternStart.matcher(personInString);
        matcherStart.region(currentWorkingIndex, personInString.length());
        matcherStart.find();
        int startIndex = matcherStart.end();

        //find the (beginning of the) closing tag ( --||-- )
        Pattern patternEnd = Pattern.compile("</" + patternString + ">");
        Matcher matcherEnd = patternEnd.matcher(personInString);
        matcherEnd.region(currentWorkingIndex, personInString.length());
        matcherEnd.find();
        int endIndex = matcherEnd.start();

        //set the point we're currently add after the closing tag of our current search
        currentWorkingIndex = matcherEnd.end();

        String resultString = personInString.substring(startIndex, endIndex).trim();
        return resultString;
    }

    //this method receives only a part of a person string and therefore doesn't work with currentWorkingIndex. All "keys" within this partial string
    //are unique (unlike tags that are looked for in findParticularProperty), so no starting index is needed.
    private Pair<String, Integer> findKeyValuePair(String keyString, String stringToSearch) throws KeyNotFoundException, ValueNotFoundException {

        //look for a particular attribute/skill name (not tag)
        Pattern keyPattern = Pattern.compile(keyString);
        Matcher keyMatch = keyPattern.matcher(stringToSearch);
        int searchFrom = -1;
        if (keyMatch.find()) {
            searchFrom = keyMatch.end();
        } else {
            throw new KeyNotFoundException("Key \"" + keyString + "\" expected; no such key found.");
        }

        //look for the corresponding value (first number after the name)
        Pattern valuePattern = Pattern.compile("\\d+");
        Matcher valueMatch = valuePattern.matcher(stringToSearch);
        valueMatch.region(searchFrom, stringToSearch.length());
        String valueString = null;
        if (valueMatch.find()) {
            valueString = valueMatch.group();
        } else {
            throw new ValueNotFoundException("A value for key \"" + keyString + "\" expected; no value found.");
        }

        return new Pair<>(keyString, Integer.valueOf(valueString));
    }

    //for finding trait pairs, a different method than findKeyValuePair() is needed (KV walks through an array where every key is present).
    //With traits, only a handful from the big (<100 entries) array will be present - no need to search for corresponding values for each of them.
    private List<Pair<String, Integer>> findTraitPairs(String stringToSearch) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        int pairIndex = 0;
        Pattern patternStart = Pattern.compile("<key>");
        Matcher matcherStart = patternStart.matcher(stringToSearch);
        Pattern patternEnd = Pattern.compile("</key>");
        Matcher matcherEnd = patternEnd.matcher(stringToSearch);
        Pattern valuePattern = Pattern.compile("\\d+");
        Matcher valueMatch = valuePattern.matcher(stringToSearch);
        Pattern patternEndPair = Pattern.compile("</pair>");
        Matcher matcherEndPair = patternEndPair.matcher(stringToSearch);

        do {
            //find a <key> tag
            matcherStart.region(pairIndex, stringToSearch.length());
            matcherStart.find();
            int startIndex = matcherStart.end();

            //TODO prenest napad z tohohle radku i do ostatnich mist? (.region(startIndex...)
            //find a </key> tag
            matcherEnd.region(startIndex, stringToSearch.length());
            matcherEnd.find();
            int endIndex = matcherEnd.start();

            //record the String between the tags above
            String resultString = stringToSearch.substring(startIndex, endIndex);

            //record corresponding value - first number after </key>
            valueMatch.region(endIndex, stringToSearch.length());
            valueMatch.find();
            int value = Integer.valueOf(valueMatch.group());

            //search for </pair> and mark the starting index for the next pair search
            matcherEndPair.region(valueMatch.end(), stringToSearch.length());
            matcherEndPair.find();
            pairIndex = matcherEndPair.end();

            //add the pair to the list of trait xml names and their values
            list.add(new Pair<String, Integer>(resultString, value));

        } while (!(pairIndex == stringToSearch.length()));

        return list;
    }





}
