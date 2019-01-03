package com.dana.entities;

import java.util.HashMap;
import java.util.Map;

public class Ranger {

    String name;
    String portraitName; //nebo radeji URI? Path?
    Gender gender;
    String religion;
    String smokes;
    String ethnicity;
    String biography;
    int skinColor;
    int age;
    int level;
    int exp;
    int currentHp;
    int size;
    int numberOfKills;
    int damageDone;
    int availAttrPoints;
    int availSkillPoints;
    int availTraitPoints;
    Item[] equipment;
    Item[] inventory;
    Map<String, Integer> attributes;
    Map<String, Integer> skills;
    Map<String, Integer> traits;

    public Ranger() {
        attributes = new HashMap<>();
        attributes.put("charisma", 0);
        attributes.put("intelligence", 0);
        attributes.put("speed", 0);
        attributes.put("strength", 0);
        attributes.put("awareness", 0);
        attributes.put("luck", 0);
        attributes.put("coordination", 0);

        skills = new HashMap<>();
        skills.put("weaponSmith", 0);
        skills.put("toasterRepair", 0);
        skills.put("spotLie", 0); //smart ass?
        skills.put("sniperRifle", 0);
        skills.put("smg", 0);
        skills.put("shotgun", 0);
        skills.put("safecrack", 0);
        skills.put("rifle", 0);
        skills.put("pickLock", 0);
        skills.put("perception", 0);
        skills.put("outdoorsman", 0);
        skills.put("mechanicalRepair", 0);
        skills.put("manipulate", 0);//kiss ass?
        skills.put("leadership", 0);
        skills.put("intimidate", 0);
        skills.put("handgun", 0);
        skills.put("fieldMedic", 0);
        skills.put("energyWeapons", 0);
        skills.put("doctor", 0);
        skills.put("demolitions", 0);
        skills.put("computerTech", 0);
        skills.put("combatShooting", 0);
        skills.put("calvinBackerskill", 0);
        skills.put("bruteForce", 0);
        skills.put("brawling", 0);
        skills.put("bluntWeapons", 0);
        skills.put("bladedWeapons", 0);
        skills.put("barter", 0);
        skills.put("animalWhisperer", 0);
        skills.put("alarmDisarm", 0);
        skills.put("atWeapons", 0);
    }

}

enum Gender {
    MALE,
    FEMALE
}
