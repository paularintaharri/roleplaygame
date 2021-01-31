package com.company.items.armor;

import com.company.items.Item;
import com.company.items.ItemType;
import com.company.items.SlotType;

public abstract class Armor implements Item {

    private SlotType slotType;
    private ArmorType armorType;
    private ItemType itemType = ItemType.Armor;
    private String name;
    private int level;

    private int baseBonusHealth = 0;
    private int baseBonusDexterity = 0;
    private int baseBonusStrength = 0;
    private int baseBonusIntelligence = 0;

    private int upBonusHealth = 0;
    private int upBonusDexterity = 0;
    private int upBonusStrength = 0;
    private int upBonusIntelligence = 0;

    public Armor(SlotType slotType, String name, int level, int baseBonusHealth, int baseBonusDexterity, int baseBonusStrength, int baseBonusIntelligence, int upBonusHealth, int upBonusStrength, int upBonusDexterity, int upBonusIntelligence, ArmorType armorType) {
        this.slotType = slotType;
        this.name = name;
        this.level = level;
        this.baseBonusHealth = baseBonusHealth;
        this.baseBonusDexterity = baseBonusDexterity;
        this.baseBonusStrength = baseBonusStrength;
        this.baseBonusIntelligence = baseBonusIntelligence;
        this.upBonusHealth = upBonusHealth;
        this.upBonusDexterity = upBonusDexterity;
        this.upBonusStrength = upBonusStrength;
        this.upBonusIntelligence = upBonusIntelligence;
        this.armorType = armorType;
    }

    public ArmorType getArmorType() { return armorType; }
    @Override
    public int getLevel() { return level; }

    @Override
    public String getName() { return name; }

    @Override
    public ItemType getItemType() { return itemType; }

    @Override
    public SlotType getSlotType() { return slotType; }

    public int getBaseBonusHealth() {
        return baseBonusHealth + (level*upBonusHealth);
    }
    public int getBaseBonusDexterity() {
        return baseBonusDexterity + (level*upBonusDexterity);
    }
    public int getBaseBonusStrength() { return baseBonusStrength + (level*upBonusStrength); }
    public int getBaseBonusIntelligence() { return baseBonusIntelligence + (level*upBonusIntelligence); }

    //print item bonus stats
    public String stats() {
        String stats = "";
        if (getBaseBonusHealth() != 0){
            stats = stats + "Bonus HP: "+getBaseBonusHealth()+"\n";
        }
        if (getBaseBonusDexterity() != 0){
            stats = stats + "Bonus Dex: "+getBaseBonusDexterity()+"\n";
        }
        if (getBaseBonusStrength()!= 0){
            stats = stats + "Bonus Str: "+getBaseBonusStrength()+"\n";
        }
        if(getBaseBonusIntelligence()!= 0){
            stats = stats + "Bonus Int: "+getBaseBonusIntelligence()+"\n";
        }
        return stats;
    }

    @Override
    public String toString(){
        return "Item stats for: " + getName() + "\n"+
                "Armor type: " + getArmorType() + "\n"+
                "Slot: " + getSlotType() + "\n"+
                "Armor level: " + getLevel() + "\n"+
                stats();
    }
}