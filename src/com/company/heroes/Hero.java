package com.company.heroes;

import com.company.items.Item;
import com.company.items.ItemType;
import com.company.items.SlotType;
import com.company.items.armor.Armor;
import com.company.items.weapon.Weapon;

import java.util.HashMap;

public abstract class Hero {

    //beginner stats
    private int baseHealth ;
    private int baseStrength;
    private int baseDexterity;
    private int baseIntelligence;

    //stats when level increases
    private int upHealth;
    private int upStrength;
    private int upDexterity;
    private int upIntelligence;

    //stats when item equipped
    private int itemBonusHealth;
    private int itemBonusStrength;
    private int itemBonusDexterity;
    private int itemBonusIntelligence;

    private int level = 1;
    private int currentExp = 0;
    private int nextLevelExpReg = 100;
    private String heroName;

    HashMap<SlotType, Armor> equippedArmor  = new HashMap<>();
    HashMap<SlotType, Weapon> equippedWeapon  = new HashMap<>();

    //Constructor for Hero
    protected Hero(String heroName, int baseHealth, int baseStrength, int baseDexterity, int baseIntelligence, int upHealth, int upStrength, int upDexterity, int upIntelligence) {
        this.heroName = heroName;
        this.baseHealth = baseHealth;
        this.baseStrength = baseStrength;
        this.baseDexterity = baseDexterity;
        this.baseIntelligence = baseIntelligence;
        this.upHealth = upHealth;
        this.upStrength = upStrength;
        this.upDexterity = upDexterity;
        this.upIntelligence = upIntelligence;
    }

    //Getters ans Setters
    public int getBaseHealth() {return baseHealth;}
    public int getBaseStrength() {return baseStrength;}
    public int getBaseDexterity() {return baseDexterity; }
    public int getBaseIntelligence() {return baseIntelligence; }
    public int getItemBonusHealth() { return itemBonusHealth; }
    public int getItemBonusStrength() { return itemBonusStrength; }
    public int getItemBonusDexterity() { return itemBonusDexterity; }
    public int getItemBonusIntelligence() { return itemBonusIntelligence; }

    public String getHeroName() {return heroName; }
    public HashMap<SlotType,Armor> getArmorHasMap(){ return equippedArmor; }
    public HashMap<SlotType,Weapon> getWeaponHasMap(){ return equippedWeapon; }

    public void setBaseHealth(int newBaseHealth) {this.baseHealth = newBaseHealth;}
    public void setBaseStrength(int newBaseStrength) {this.baseStrength = newBaseStrength; }
    public void setBaseDexterity(int newBaseDexterity) {this.baseDexterity = newBaseDexterity; }
    public void setBaseIntelligence(int newBaseIntelligence) {this.baseIntelligence = newBaseIntelligence; }
    public void setItemBonusHealth(int itemBonusHealth) { this.itemBonusHealth = itemBonusHealth; }
    public void setItemBonusStrength(int itemBonusStrength) { this.itemBonusStrength = itemBonusStrength; }
    public void setItemBonusDexterity(int itemBonusDexterity) { this.itemBonusDexterity = itemBonusDexterity; }
    public void setItemBonusIntelligence(int itemBonusIntelligence) { this.itemBonusIntelligence = itemBonusIntelligence; }

    public int getLevel() {return level; }
    public void setLevel(int level) {this.level = level; }

    //increases hero level and scales other stats
    public void increaseHeroExp(){
        setLevel(level + 1);
        nextLevelExpReg = (int)(nextLevelExpReg * 1.1);
        setBaseHealth(getBaseHealth() + upHealth);
        setBaseStrength(getBaseStrength() + upStrength);
        setBaseDexterity(getBaseDexterity() + upDexterity);
        setBaseIntelligence(getBaseIntelligence() + upIntelligence);
        checkExp();
    }

    //check if added xp increases level
    public void checkExp(){
        if (currentExp >= nextLevelExpReg){
            increaseHeroExp();
        }else{
            System.out.println("Added xp for " + getHeroName() + ". Current level: " + level);
        }
    }

    //add xp to hero
    public void addExp(int expAmount){
        currentExp = currentExp + expAmount;
        checkExp();
    }

    //add item to hashmap
    public void addItem(Item item, SlotType slotType, ItemType itemType){
        if(itemType == ItemType.Weapon){
            equippedWeapon.put(slotType, (Weapon) item);
        }else{
            equippedArmor.put(slotType,(Armor) item);
        }
    }

    // remove weapon form hashmap
    public void removeWeapon(SlotType slotType){
        equippedWeapon.remove(slotType);
    }
    // remove armor from hashmap
    public void removeArmor(SlotType slotType){
        equippedArmor.remove(slotType);
    }

    //get all com.company.items what hero has equipped
    public void getEquippedItems() {
        if (!equippedWeapon.isEmpty()) {
            System.out.println(getHeroName() + " has following weapon equipped: ");
            equippedWeapon.entrySet().forEach(entry -> {
                System.out.println(entry.getValue());
            });
        } else {
            System.out.println("No weapons equipped");
        }
        if (!equippedArmor.isEmpty()) {
            System.out.println("Armors equipped: ");
            equippedArmor.entrySet().forEach(entry -> {
                System.out.println(entry.getValue());
            });
        }else {
            System.out.println("No armors equipped\n");
        }
    }

    @Override
    public String toString(){
        return "\n"+
                this.getClass().getSimpleName()+" details:"+"\n"+
                "HP: "+getBaseHealth()+"\n"+
                "Str: "+getBaseStrength()+"\n"+
                "Dex: "+getBaseDexterity()+"\n"+
                "Int: "+getBaseIntelligence()+"\n"+
                "Lvl: "+ level+"\n"+
                "Current xp: "+ currentExp+"\n"+
                "XP to next: "+(nextLevelExpReg-currentExp)+
                "\n";
    }
}