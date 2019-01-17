package com.dana.entities;

import javafx.util.Pair;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranger {

    private final static Map<Integer, Double> SPEEDMAP = initSpeedMap();
    private final static Map<Integer, Pair<Integer, String>> LEVELMAP = initLevelMap();
    private final static Map<Integer, Integer> CONMAP = initConMap();

    public String name;
    public Path portrait; //nebo radeji URI? Path?
    public Gender gender;
    public String religion;
    public String smokes;
    public String ethnicity;
    public String biography;
    public int skinColor;
    public int age;
    public int level;
    public int exp;
    public int currentHp;
    public int size;
    public int numberOfKills;
    public int damageDone;
    public int availAttrPoints;
    public int availSkillPoints;
    public int availTraitPoints;
    public Item[] equipment;
    public Item[] inventory;
    public Map<String, Integer> attributes;
    public Map<String, Skill> skills;
    public List<Trait> quirks;
    public List<Trait> traits;
    public boolean isCNPC;
    public int luckyHp;

    private static Map<Integer, Double> initSpeedMap() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 1.6);
        map.put(2, 1.776);
        map.put(3, 1.952);
        map.put(4, 2.128);
        map.put(5, 2.304);
        map.put(6, 2.48);
        map.put(7, 2.565);
        map.put(8, 2.832);
        map.put(9, 3.008);
        map.put(10, 3.2);

        return map;
    }

    private static Map<Integer, Pair<Integer, String>> initLevelMap() {
        Map<Integer, Pair<Integer, String>> map = new HashMap<>();
        map.put(1, new Pair<>(0, "Private First Class"));
        map.put(2, new Pair<>(300, "Private First Class"));
        map.put(3, new Pair<>(700, "Specialist"));
        map.put(4, new Pair<>(1200, "Senior Specialist"));
        map.put(5, new Pair<>(1800, "Corporal"));
        map.put(6, new Pair<>(2500, "Lance Corporal"));
        map.put(7, new Pair<>(3400, "Command Corporal"));
        map.put(8, new Pair<>(4300, "Grenadier"));
        map.put(9, new Pair<>(5400, "Fire Grenadier"));
        map.put(10, new Pair<>(6600, "Grenadier Major"));
        map.put(11, new Pair<>(7900, "Master Grenadier"));
        map.put(12, new Pair<>(9300, "Sergeant"));
        map.put(13, new Pair<>(10800, "Sergeant"));
        map.put(14, new Pair<>(12400, "Technical Sergeant"));
        map.put(15, new Pair<>(14100, "Technical Sergeant"));
        map.put(16, new Pair<>(16000, "Sergeant Major"));
        map.put(17, new Pair<>(18000, "Sergeant Major"));
        map.put(18, new Pair<>(20000, "Master Sergeant"));
        map.put(19, new Pair<>(22200, "Master Sergeant"));
        map.put(20, new Pair<>(24500, "Sergeant Argent"));
        map.put(21, new Pair<>(27000, "Sergeant Argent"));
        map.put(22, new Pair<>(29500, "Cadet"));
        map.put(23, new Pair<>(32100, "Cadet"));
        map.put(24, new Pair<>(34800, "Cadet Specialist"));
        map.put(25, new Pair<>(37700, "Cadet Specialist"));
        map.put(26, new Pair<>(40700, "Combat Cadet"));
        map.put(27, new Pair<>(43800, "Combat Cadet"));
        map.put(28, new Pair<>(47000, "Combat Cadet"));
        map.put(29, new Pair<>(50300, "Lieutenant"));
        map.put(30, new Pair<>(53700, "Lieutenant"));
        map.put(31, new Pair<>(57200, "Lieutenant"));
        map.put(32, new Pair<>(60800, "Lieutenant"));
        map.put(33, new Pair<>(64500, "Lieutenant"));
        map.put(34, new Pair<>(68200, "Lieutenant"));
        map.put(35, new Pair<>(72000, "Lieutenant"));
        map.put(36, new Pair<>(75900, "Lieutenant"));
        map.put(37, new Pair<>(79900, "Lieutenant"));
        map.put(38, new Pair<>(84000, "Lieutenant"));
        map.put(39, new Pair<>(88200, "Lieutenant"));
        map.put(40, new Pair<>(92500, "Lieutenant"));
        map.put(41, new Pair<>(96900, "Lieutenant"));
        map.put(42, new Pair<>(101400, "Lieutenant"));
        map.put(43, new Pair<>(106000, "Lieutenant"));
        map.put(44, new Pair<>(110700, "Lieutenant"));
        map.put(45, new Pair<>(115500, "Lieutenant"));
        map.put(46, new Pair<>(120400, "Lieutenant"));
        map.put(47, new Pair<>(125400, "Lieutenant"));
        map.put(48, new Pair<>(130500, "Lieutenant"));
        map.put(49, new Pair<>(135700, "Lieutenant"));
        map.put(50, new Pair<>(141000, "Lieutenant"));

        return map;
    }

    private static Map<Integer, Integer> initConMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 7);
        map.put(2, 8);
        map.put(3, 8);
        map.put(4, 9);
        map.put(5, 9);
        map.put(6, 10);
        map.put(7, 10);
        map.put(8, 11);
        map.put(9, 11);
        map.put(10, 12);

        return map;
    }



    public Ranger() {
        skills = new HashMap<>();

        for (String skillXmlName : Skill.SKILL_MAP.keySet()) {
            Skill templateSkill = Skill.SKILL_MAP.get(skillXmlName);
            Skill newSkill = new Skill(templateSkill.getDisplayName(), templateSkill.getXmlName(), templateSkill.getGroup());
            newSkill.setValue(0);
            skills.put(skillXmlName, newSkill);
        }

    }

    /*----------------------derived stats-----------------*/

    public int getAP() {
        int result = 3;
        result += attributes.get("coordination")/2;
        result += ( attributes.get("strength") + attributes.get("intelligence") + attributes.get("speed") ) / 4;

        return result;
    }

    public String getRank() {
        Pair<Integer, String> levelInfo = LEVELMAP.get(this.level);
        return levelInfo.getValue();
    }

    public String getCombatSpeed() {
        int speed = attributes.get("speed");
        return SPEEDMAP.get(speed).toString();
    }

    public String getCon() {
        int strength = attributes.get("strength");
        int base = 26 +  strength * 3;
        int levelInc = CONMAP.get(strength);

        return Integer.toString(base + levelInc * level + luckyHp);
    }

    public String getInitiative() {
        int awareness = attributes.get("awareness");
        int speed = attributes.get("speed");
        int value = awareness + (speed / 2 ) + 5;
        return Integer.toString(value);
    }

    public String getEvasion() {
        int awareness = attributes.get("awareness");
        int luck = attributes.get("luck");
        int speed = attributes.get("speed");
        Integer value = awareness/2 + luck/2 + speed;
        return value.toString() + " %";
    }



    /*-------------------various getters----------------------*/

    public String getCurrentHp() {
        return Integer.toString(currentHp);
    }

    public String getAttributeValue(String attribute) {
        int value = attributes.get(attribute);
        return Integer.toString(value);
    }

    public String getExpToNextLevel() {
        Pair<Integer, String> levelInfo = LEVELMAP.get(this.level);
        return levelInfo.getKey().toString();
    }

    public Skill getSkill(String skill) {
        return skills.get(skill);
    }

    public void setSkillValue(String skill, int value) {
        Skill replacementSkill = skills.get(skill);
        replacementSkill.setValue(value);
        skills.replace(skill, replacementSkill);
    }
}