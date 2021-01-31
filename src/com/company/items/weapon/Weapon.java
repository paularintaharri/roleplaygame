package com.company.items.weapon;

import com.company.items.Item;
import com.company.items.ItemType;
import com.company.items.SlotType;

public class Weapon implements Item {

    private SlotType slotType;
    private WeaponType weaponType;
    private ItemType itemType = ItemType.Weapon;

    private int baseDamage = 0;
    private int scaling = 0;
    private String name;
    private int level;
    private double damageIncrease;

    public Weapon(String name, int level, int baseDamage, int scaling, double damageIncrease, WeaponType weaponType, SlotType slotType) {
        this.name = name;
        this.level = level;
        this.baseDamage = baseDamage;
        this.scaling = scaling;
        this.damageIncrease = damageIncrease;
        this.weaponType = weaponType;
        this.slotType = slotType;
    }

    public WeaponType getWeaponType() { return weaponType; }

    @Override
    public int getLevel() { return level; }

    @Override
    public String getName() { return name; }

    @Override
    public ItemType getItemType() { return itemType; }

    @Override
    public SlotType getSlotType() { return slotType; }

    public int getBaseDamage() {
        return baseDamage+(getScaling()*getLevel());
    }
    public int getScaling() { return scaling; }
    public double getDamageIncrease() { return damageIncrease; }

    public void setSlotType(SlotType slotType) { this.slotType = slotType; }
    public void setName(String name) { this.name = name; }
    public void setLevel(int level) { this.level = level; }

    @Override
    public String toString(){
        return "Item stats for: " + getName()+"\n"+
                "Weapon type: "+getWeaponType()+"\n"+
                "Weapon level: "+getLevel()+"\n"+
                "Damage: "+getBaseDamage()+"\n";
    }
}