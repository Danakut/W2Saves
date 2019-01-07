package com.dana;

import com.dana.Exceptions.KeyNotFoundException;
import com.dana.Exceptions.PropertyNotAssembledException;
import com.dana.Exceptions.ValueNotFoundException;
import com.dana.entities.Gender;
import com.dana.entities.Ranger;
import com.dana.entities.Trait;
import javafx.util.Pair;

import javax.print.DocFlavor;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    public static final Logger logger = Logger.getLogger(App.class.getName());

    private static String[] ATTRIBUTE_ARRAY = {"charisma", "intelligence", "speed", "strength", "awareness", "luck", "coordination"};
    private static String[] SKILL_ARRAY = {"weaponSmith", "toasterRepair", "spotLie", "sniperRifle", "smg", "shotgun",
            "safecrack", "rifle", "pickLock", "perception", "outdoorsman", "mechanicalRepair", "manipulate", "leadership",
            "intimidate", "handgun", "fieldMedic", "energyWeapons", "doctor", "demolitions", "computerTech", "combatShooting",
            "calvinBackerSkill", "bruteForce", "brawling", "bluntWeapons", "bladedWeapons", "barter", "animalWhisperer", "alarmDisarm",
            "atWeapons"};

    private static Trait[] TRAIT_ARRAY = initTraitArray();


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

    private static Trait[] initTraitArray() {
        Trait[] array = new Trait[112];

        array[0].setDisplayName("Animal Husbandry");
        array[0].setXmlName("");
        array[0].setIsQuirk(true);
        array[0].setEffect("Bonuses from Animal Whispered followers are twice as good");
        array[0].setDrawback("???");

        array[1].setDisplayName("Ascetic");
        array[1].setXmlName("Trait_Ascetic");
        array[1].setIsQuirk(true);
        array[1].setEffect("+5 skill points, +1 Attribute point");
        array[1].setDrawback("Cannot use trinkets");

        array[2].setDisplayName("Asshole");
        array[2].setXmlName("");
        array[2].setIsQuirk(true);
        array[2].setEffect("Hard Ass always succeeds");
        array[2].setDrawback("Cannot use Kiss Ass or Smart Ass");

        array[3].setDisplayName("Brittle Bones");
        array[3].setXmlName("");
        array[3].setIsQuirk(true);
        array[3].setEffect("+2 base action points");
        array[3].setDrawback("-50% base combat speed");

        array[4].setDisplayName("Delayed Gratification");
        array[4].setXmlName("");
        array[4].setIsQuirk(true);
        array[4].setEffect("+1 skill point per level past level 10");
        array[4].setDrawback("-1 skill point per level before level 11");

        array[5].setDisplayName("Disparnumerophobia");
        array[5].setXmlName("");
        array[5].setIsQuirk(true);
        array[5].setEffect("+1 to all Attributes on even-numbered levels");
        array[5].setDrawback("-1 to all Attributes on odd-numbered levels");

        array[6].setDisplayName("Fainting Goat");
        array[6].setXmlName("Trait_FaintingGoat");
        array[6].setIsQuirk(true);
        array[6].setEffect("35% chance to dodge a Critical Hit enemy attack by fainting");
        array[6].setDrawback("Fainting pushes the character back in the combat order.");

        array[7].setDisplayName("Heavy Handed");
        array[7].setXmlName("");
        array[7].setIsQuirk(true);
        array[7].setEffect("+15% base damage on all close combat attacks");
        array[7].setDrawback("-50% base critical chance");

        array[8].setDisplayName("Manic Depressive");
        array[8].setXmlName("");
        array[8].setIsQuirk(true);
        array[8].setEffect("Attributes change randomly by +1/-1 every 10-15 minutes.");
        array[8].setDrawback("Attributes change randomly by +1/-1 every 10-15 minutes.");

        array[9].setDisplayName("Mysophobic");
        array[9].setXmlName("");
        array[9].setIsQuirk(true);
        array[9].setEffect("+25% healing item effectiveness");
        array[9].setDrawback("Cannot use healing items on self");

        array[10].setDisplayName("Opportunist");
        array[10].setXmlName("");
        array[10].setIsQuirk(true);
        array[10].setEffect("+25% damage against targets with less than 30% health remaining");
        array[10].setDrawback("-25% damage against targets with 30% or more health remaining.");

        array[11].setDisplayName("Psychopath");
        array[11].setXmlName("");
        array[11].setIsQuirk(true);
        array[11].setEffect("+4% bonus Chance to Hit and +2% bonus Critical Chance per successful attack, misses reset the counter");
        array[11].setDrawback("-10% base Chance to Hit\n" +
                "-5% base Critical Chance");

        array[12].setDisplayName("Raised in the Circus");
        array[12].setXmlName("");
        array[12].setIsQuirk(true);
        array[12].setEffect("+5% Evasion");
        array[12].setDrawback("No leadership bonuses can be received");

        array[13].setDisplayName("Repressed Rage");
        array[13].setXmlName("");
        array[13].setIsQuirk(true);
        array[13].setEffect("Double damage and +25% Critical Chance for 1 turn after receiving a critical hit");
        array[13].setDrawback("Cannot deal normal Critical Hits");

        array[14].setDisplayName("Thick-Skinned");
        array[14].setXmlName("");
        array[14].setIsQuirk(true);
        array[14].setEffect("+2 base armor");
        array[14].setDrawback("-30% base Combat Speed");

        array[15].setDisplayName("Twitchy");
        array[15].setXmlName("");
        array[15].setIsQuirk(true);
        array[15].setEffect("+20% base Combat Speed");
        array[15].setDrawback("-10% base Chance to Hit");

        array[16].setDisplayName("Two-Pump Chump");
        array[16].setXmlName("");
        array[16].setIsQuirk(true);
        array[16].setEffect("+2 Action Points and +25% Chance to Hit for the first 2 combat turns");
        array[16].setDrawback("-1 Action Points and -15% Chance to Hit for each turn after the first 2 combat turns");

        array[17].setDisplayName("Unlucky");
        array[17].setXmlName("");
        array[17].setIsQuirk(true);
        array[17].setEffect("Chance for a lightning to strike and shock a random target in combat");
        array[17].setDrawback("Chance for a lightning to strike and shock a random target in combat");

        array[18].setDisplayName("Way of the Squeezins");
        array[18].setXmlName("");
        array[18].setIsQuirk(true);
        array[18].setEffect("+2 Action Points and +25% Damage when drunk on Snake Squeezins");
        array[18].setDrawback("-100% Critical Chance and -0.6 Combat Speed when sober");

        array[19].setDisplayName("Adrenaline Rush");
        array[20].setDisplayName("Affable");
        array[21].setDisplayName("Applied Force");
        array[22].setDisplayName("Armor Maintenance");
        array[23].setDisplayName("Atomize");

        array[24].setDisplayName("Bandit");
        array[24].setXmlName("Trait_Bandit");

        array[25].setDisplayName("Battering Fire");
        array[26].setDisplayName("Big Game Hunter");
        array[27].setDisplayName("Bloodthirsty");
        array[28].setDisplayName("Bomberman");
        array[29].setDisplayName("Bullet-Ridden");
        array[30].setDisplayName("Camel");
        array[31].setDisplayName("Careful Hunter");
        array[32].setDisplayName("Charge!");
        array[33].setDisplayName("Confident Shooter");
        array[34].setDisplayName("Cyber Scrounger");
        array[35].setDisplayName("Deadeye");
        array[36].setDisplayName("Deconstructing");
        array[37].setDisplayName("Desperado");
        array[38].setDisplayName("Devastating Fire");
        array[39].setDisplayName("Dowsing");
        array[40].setDisplayName("Enrage");
        array[41].setDisplayName("Expert Physician");
        array[42].setDisplayName("Explorer");
        array[43].setDisplayName("Fast Reload");
        array[44].setDisplayName("Focused Shooter");
        array[45].setDisplayName("Free-For-All");

        array[46].setDisplayName("Full Metal Jacket");
        array[46].setXmlName("Trait_HollowPoint");

        array[47].setDisplayName("Ghost");
        array[48].setDisplayName("Glancing Strike (Bladed)");
        array[49].setDisplayName("Glancing Strike (Blunt)");
        array[50].setDisplayName("Glancing Strike (Brawling");
        array[51].setDisplayName("Gunner");
        array[52].setDisplayName("Gunslinger");
        array[53].setDisplayName("Handyman");

        array[54].setDisplayName("Hardened");
        array[54].setXmlName("Trait_ThickSkin");

        array[55].setDisplayName("Healthy");
        array[56].setDisplayName("Hit the Deck!");
        array[57].setDisplayName("Hoarder");
        array[58].setDisplayName("Improvised Explosives");
        array[59].setDisplayName("Infuriate");
        array[60].setDisplayName("Intimidating");
        array[61].setDisplayName("Junk Diver");
        array[62].setDisplayName("Know-it-All");
        array[63].setDisplayName("Limber");
        array[64].setDisplayName("Long Arm");
        array[65].setDisplayName("Loose Change");
        array[66].setDisplayName("Master Hunter");
        array[67].setDisplayName("Master Thief");
        array[68].setDisplayName("Melee Shooting");
        array[69].setDisplayName("Obliterator");
        array[70].setDisplayName("On the Mend");
        array[71].setDisplayName("Opportune Strike (Bladed)");
        array[72].setDisplayName("Opportune Strike (Blunt)");
        array[73].setDisplayName("Opportune Strike (Brawling)");
        array[74].setDisplayName("Overcharge");
        array[75].setDisplayName("Overclocker");
        array[76].setDisplayName("Overload");
        array[77].setDisplayName("Overwhelming Fire");
        array[78].setDisplayName("Pawner");
        array[79].setDisplayName("Powder Packer");
        array[80].setDisplayName("Precise Hunter");
        array[80].setDisplayName("Quick Reflexes");
        array[81].setDisplayName("Radiant Personality");
        array[82].setDisplayName("Reinforced Plating");
        array[83].setDisplayName("Roboticist");
        array[84].setDisplayName("Rush 'N Attack");
        array[85].setDisplayName("Samurai");
        array[86].setDisplayName("Scout");
        array[87].setDisplayName("Self Defense");
        array[88].setDisplayName("Shoulder the Load");
        array[89].setDisplayName("Silver-Tongued");
        array[90].setDisplayName("Slayer");
        array[91].setDisplayName("Smooth Operator");
        array[92].setDisplayName("Solar Powered");
        array[93].setDisplayName("Staggering Force");
        array[94].setDisplayName("Stimpaks");
        array[95].setDisplayName("Strategic Strike (Bladed)");
        array[96].setDisplayName("Strategic Strike (Blunt)");
        array[97].setDisplayName("Strategic Strike (Brawling)");
        array[98].setDisplayName("Stunning Force");

        array[99].setDisplayName("Tactical Positioning");
        array[99].setXmlName("Trait_TacticalPositioning");

        array[100].setDisplayName("Taunt");
        array[101].setDisplayName("Tinkerer");
        array[102].setDisplayName("Toaster Expert");
        array[103].setDisplayName("Tormentor");
        array[104].setDisplayName("Trained Physician");
        array[105].setDisplayName("Turtle");
        array[106].setDisplayName("Watchman");
        array[107].setDisplayName("Weathered");
        array[108].setDisplayName("Whack-a-Mole");
        array[109].setDisplayName("World Traveler");
        array[110].setDisplayName("Zen Shooter");
        array[111].setDisplayName("Zeroed");


        return array;
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
            Ranger ranger = null;
            try {
                ranger = processPerson(personsInString.get(i));

                logger.info("Person " + i + " added to the list of Ranger objects.");
            } catch (PropertyNotAssembledException e) {
                logger.info("Person " + i + " could not be processed. Moving on.");
            }

            list.add(ranger);
        }

        return list;
    }

    private Ranger processPerson(String personInString) throws PropertyNotAssembledException {
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
            Pair<String, Integer> workingPair = null;
            try {
                workingPair = findKeyValuePair(ATTRIBUTE_ARRAY[i], properties);
            } catch (Exception ex) {
                throw new PropertyNotAssembledException("Processing person \"" + newPerson.name + "\" failed at Attributes", ex);
            }
            newAttributes.put(workingPair.getKey(), workingPair.getValue());
        }

        newPerson.attributes = newAttributes;
        newAttributes = null;

        //skills
        Map<String, Integer> newSkills = new HashMap<>();
        properties = findParticularProperty("skillXps", personInString);

        for (int i = 0; i < SKILL_ARRAY.length; i++) {
            Pair<String, Integer> workingPair = null;
            try {
                workingPair = findKeyValuePair(SKILL_ARRAY[i], properties);
            } catch (Exception ex) {
                throw new PropertyNotAssembledException("Processing person \"" + newPerson.name + "\" failed at Skills", ex);
            }
            newSkills.put(workingPair.getKey(), workingPair.getValue());
        }

        newPerson.skills = newSkills;
        newSkills = null;

        //traits
        List<Trait> newTraits = new ArrayList<>();
        properties = findParticularProperty("traits", personInString);
        if (!properties.equals("")) {

            Trait trait = new Trait();




            for (int i = 0; i < SKILL_ARRAY.length; i++) {
                Pair<String, Integer> workingPair = null;
                try {
                    workingPair = findKeyValuePair(SKILL_ARRAY[i], properties);
                } catch (KeyNotFoundException e) {
                    e.printStackTrace();
                } catch (ValueNotFoundException e) {
                    e.printStackTrace();
                }
                newSkills.put(workingPair.getKey(), workingPair.getValue());
            }
            newPerson.traits = newTraits;
        }

        return newPerson;
    }

    private String findParticularProperty(String patternString, String personInString) {

        //TODO pridat exceptions pro zpracovani
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

    private Pair<String, Integer> findKeyValuePair(String keyString, String stringToSearch) throws KeyNotFoundException, ValueNotFoundException {
        Pattern keyPattern = Pattern.compile(keyString);
        Matcher keyMatch = keyPattern.matcher(stringToSearch);
        int searchFrom = -1;
        if (keyMatch.find()) {
            searchFrom = keyMatch.end();
        } else {
            throw new KeyNotFoundException("Key \"" + keyString + "\" expected; no such key found.");
        }

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





}
