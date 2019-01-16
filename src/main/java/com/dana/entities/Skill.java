package com.dana.entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Skill {

    public static final Map<String, Skill> SKILL_MAP = initSkillMap();
    public static final int SKILLS_COUNT = SKILL_MAP.size();

    private String displayName;
    private String xmlName;
    private String group;
    private int value;

    private static Map<String, Skill> initSkillMap() {

        Map<String, Skill> newMap = new HashMap<>();

        /*------------Combat skills----------------*/

        Skill skill = new Skill();
        skill.displayName = "Assault Rifles";
        skill.xmlName = "rifle";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Bladed Weapons";
        skill.xmlName = "bladedWeapons";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Blunt Weapons";
        skill.xmlName = "bluntWeapons";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Brawling";
        skill.xmlName = "brawling";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Energy Weapons";
        skill.xmlName = "energyWeapons";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Handguns";
        skill.xmlName = "handgun";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Heavy Weapons";
        skill.xmlName = "atWeapons";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Shotguns";
        skill.xmlName = "shotgun";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Sniper Rifles";
        skill.xmlName = "sniperRifle";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Submachine Guns";
        skill.xmlName = "smg";
        skill.group = "combat";
        newMap.put(skill.xmlName, skill);

        /*-----------------knowledge skills----------------*/

        skill = new Skill();
        skill.displayName = "Alarm Disarming";
        skill.xmlName = "alarmDisarm";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Computer Science";
        skill.xmlName = "computerTech";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Demolitions";
        skill.xmlName = "demolitions";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Field Medic";
        skill.xmlName = "";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Lockpicking";
        skill.xmlName = "pickLock";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Mechanical Repair";
        skill.xmlName = "mechanicalRepair";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Safecracking";
        skill.xmlName = "";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Surgeon";
        skill.xmlName = "doctor";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Toaster Repair";
        skill.xmlName = "toasterRepair";
        skill.group = "knowledge";
        newMap.put(skill.xmlName, skill);

        /*-----------General skills--------------------*/

        skill = new Skill();
        skill.displayName = "Animal Whisperer";
        skill.xmlName = "animalWhisperer";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Brute Force";
        skill.xmlName = "bruteForce";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Barter";
        skill.xmlName = "barter";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Hard Ass";
        skill.xmlName = "intimidate";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Kiss Ass";
        skill.xmlName = "manipulate";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Leadership";
        skill.xmlName = "leadership";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Outdoorsman";
        skill.xmlName = "outdoorsman";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Perception";
        skill.xmlName = "perception";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Smart Ass";
        skill.xmlName = "spotLie";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        skill = new Skill();
        skill.displayName = "Weaponsmithing";
        skill.xmlName = "weaponSmith";
        skill.group = "general";
        newMap.put(skill.xmlName, skill);

        /*---------------------Special skills-------------*/

        skill = new Skill();
        skill.displayName = "Combat Shooting";
        skill.xmlName = "combatShooting";
        skill.group = "special";
        newMap.put(skill.xmlName, skill);

        //Kickstarter backer skill
        skill = new Skill();
        skill.displayName = "Southwestern Folklore";
        skill.xmlName = "calvinBackerSkill";
        skill.group = "special";
        newMap.put(skill.xmlName, skill);

        return newMap;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public String getGroup() {
        return group;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
