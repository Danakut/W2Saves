package com.dana.entities;

public class Trait {

    private String displayName;
    private String xmlName;
    private boolean isQuirk;  //otherwise is Perk
    private int value;  //should be 0 or 1(?)
    private String effect;
    private String drawback;

    public Trait() {
        displayName = "";
        xmlName = "";
        isQuirk = false;
        value = 0;
        effect = "";
        drawback = "";
    }

    //todo add Predicate as a field indicating whether there are prerequisites for the trait

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public boolean getIsQuirk() {
        return isQuirk;
    }

    public void setIsQuirk(boolean isQuirk) {
        this.isQuirk = isQuirk;
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

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getDrawback() {
        return drawback;
    }

    public void setDrawback(String drawback) {
        this.drawback = drawback;
    }
}
