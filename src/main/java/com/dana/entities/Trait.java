package com.dana.entities;

import java.util.HashMap;
import java.util.Map;

public class Trait {

    public static Map<String, Trait> TRAIT_MAP = initTraitMap();
    public static int TRAITS_COUNT = TRAIT_MAP.size();

    private String displayName;
    private String xmlName;
    private boolean isQuirk;  //otherwise is Perk
    private int value;  //should be 0 or 1(?)
    private String effect;
    private String drawback;
    private int index;

    //todo add Predicate as a field indicating whether there are prerequisites for the trait

    public String getDisplayName() {
        return displayName;
    }


    public String getXmlName() {
        return xmlName;
    }

    public boolean getIsQuirk() {
        return isQuirk;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String getEffect() {
        return effect;
    }

    public String getDrawback() {
        return drawback;
    }

    private static Map<String, Trait>  initTraitMap() {
        Map<String, Trait> newMap = new HashMap<>();

        Trait trait = new Trait();
        trait.displayName = "Animal Husbandry";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "Bonuses from Animal Whispered followers are twice as good";
        trait.drawback = "???";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Ascetic";
        trait.xmlName = "Trait_Ascetic";
        trait.isQuirk = true;
        trait.effect = "+5 skill points, +1 Attribute point";
        trait.drawback = "Cannot use trinkets";
        trait.index = 2;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Asshole";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "Hard Ass always succeeds";
        trait.drawback = "Cannot use Kiss Ass or Smart Ass";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Brittle Bones";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+2 base action points";
        trait.drawback = "-50% base combat speed";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Delayed Gratification";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+1 skill point per level past level 10";
        trait.drawback = "-1 skill point per level before level 11";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Disparnumerophobia";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+1 to all Attributes on even-numbered levels";
        trait.drawback = "-1 to all Attributes on odd-numbered levels";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Fainting Goat";
        trait.xmlName = "Trait_FaintingGoat";
        trait.isQuirk = true;
        trait.effect = "35% chance to dodge a Critical Hit enemy attack by fainting";
        trait.drawback = "Fainting pushes the character back in the combat order.";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Heavy Handed";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+15% base damage on all close combat attacks";
        trait.drawback = "-50% base critical chance";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Manic Depressive";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "Attributes change randomly by +1/-1 every 10-15 minutes.";
        trait.drawback = "Attributes change randomly by +1/-1 every 10-15 minutes.";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Mysophobic";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+25% healing item effectiveness";
        trait.drawback = "Cannot use healing items on self";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Opportunist";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+25% damage against targets with less than 30% health remaining";
        trait.drawback = "-25% damage against targets with 30% or more health remaining.";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Psychopath";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+4% bonus Chance to Hit and +2% bonus Critical Chance per successful attack, misses reset the counter";
        trait.drawback = "-10% base Chance to Hit, -5% base Critical Chance";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Raised in the Circus";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+5% Evasion";
        trait.drawback = "No leadership bonuses can be received";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Repressed Rage";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "Double damage and +25% Critical Chance for 1 turn after receiving a critical hit";
        trait.drawback = "Cannot deal normal Critical Hits";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Thick-Skinned";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+2 base armor";
        trait.drawback = "-30% base Combat Speed";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Twitchy";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+20% base Combat Speed";
        trait.drawback = "-10% base Chance to Hit";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Two-Pump Chump";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+2 Action Points and +25% Chance to Hit for the first 2 combat turns";
        trait.drawback = "-1 Action Points and -15% Chance to Hit for each turn after the first 2 combat turns";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Unlucky";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "Chance for a lightning to strike and shock a random target in combat";
        trait.drawback = "Chance for a lightning to strike and shock a random target in combat";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Way of the Squeezins";
        trait.xmlName = "";
        trait.isQuirk = true;
        trait.effect = "+2 Action Points and +25% Damage when drunk on Snake Squeezins";
        trait.drawback = "-100% Critical Chance and -0.6 Combat Speed when sober";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Adrenaline Rush";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Affable";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Applied Force";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Armor Maintenance";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Atomize";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Bandit";
        trait.xmlName = "Trait_Bandit";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Battering Fire";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Big Game Hunter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Bloodthirsty";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Bomberman";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Bullet-Ridden";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Camel";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Careful Hunter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Charge!";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Confident Shooter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Cyber Scrounger";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Deadeye";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Deconstructing";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Desperado";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Devastating Fire";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Dowsing";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Enrage";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Expert Physician";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Explorer";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Fast Reload";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Focused Shooter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Free-For-All";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Full Metal Jacket";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.xmlName = "Trait_HollowPoint";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Ghost";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Glancing Strike (Bladed)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Glancing Strike (Blunt)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Glancing Strike (Brawling";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Gunner";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Gunslinger";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Handyman";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Hardened";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.xmlName = "Trait_ThickSkin";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Healthy";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Hit the Deck!";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Hoarder";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Improvised Explosives";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Infuriate";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Intimidating";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Junk Diver";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Know-it-All";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Limber";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Long Arm";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Loose Change";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Master Hunter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Master Thief";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Melee Shooting";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Obliterator";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "On the Mend";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Opportune Strike (Bladed)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Opportune Strike (Blunt)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Opportune Strike (Brawling)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Overcharge";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Overclocker";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Overload";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Overwhelming Fire";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Pawner";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Powder Packer";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Precise Hunter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Quick Reflexes";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Radiant Personality";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Reinforced Plating";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Roboticist";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Rush 'N Attack";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Samurai";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Scout";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Self Defense";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Shoulder the Load";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Silver-Tongued";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Slayer";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Smooth Operator";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Solar Powered";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Staggering Force";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Stimpaks";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Strategic Strike (Bladed)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Strategic Strike (Blunt)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Strategic Strike (Brawling)";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Stunning Force";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Tactical Positioning";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.xmlName = "Trait_TacticalPositioning";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);
        
        trait = new Trait();
        trait.displayName = "Taunt";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Tinkerer";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Toaster Expert";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Tormentor";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Trained Physician";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Turtle";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Watchman";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Weathered";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Whack-a-Mole";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "World Traveler";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Zen Shooter";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        trait = new Trait();
        trait.displayName = "Zeroed";
        //trait.index = 1;
        newMap.put(trait.xmlName, trait);

        return newMap;
    }

}
