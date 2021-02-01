package com.company.heroes;

import com.company.items.Item;
import com.company.items.ItemType;
import com.company.items.SlotType;
import com.company.items.armor.Armor;
import com.company.items.weapon.Weapon;
import com.company.items.weapon.WeaponType;

import java.util.HashMap;

public class Action {

    //add item to hero
    public void equipItem(Hero hero, Item item){
        SlotType slotType = item.getSlotType();
        HashMap<SlotType, Weapon> equippedWeapon = hero.getWeaponHasMap();
        HashMap<SlotType, Armor> equippedArmor = hero.getArmorHasMap();

        if (item.getLevel() < hero.getLevel()) {
            if (item.getItemType() == ItemType.Weapon) { //if item is weapon
                if (equippedWeapon.containsKey(slotType)) { //if weapon is already equipped
                    System.out.println(slotType + " slot is already taken");
                } else { //if slot is free, add weapon
                    hero.addItem(item, slotType, item.getItemType());
                }
            } else { //if armor slot is taken
                if (equippedArmor.containsKey(slotType)) {
                    System.out.println(slotType + " slot is already taken");
                } else { //if slot is free add armor
                    hero.addItem(item, slotType, item.getItemType());
                    addArmorBonusStats(hero, (Armor) item, slotType, true);
                }
            }
        } else { //if hero level is too low for equipping the item
            System.out.println("Your level is too low for equipping the item: " + item.getName());
        }
    }

    //calculates hero stats when armor is equipped
    public void addArmorBonusStats(Hero hero, Armor armor, SlotType slotType, boolean add ){
        double slotBonus;
        if (slotType == SlotType.Body){
            slotBonus = 1;
        } else if (slotType == SlotType.Head){
            slotBonus = 0.8;
        } else {
            slotBonus = 0.6;
        }
        hero.setItemBonusHealth((int) Math.floor(armor.getBaseBonusHealth() * slotBonus));
        hero.setItemBonusStrength((int) Math.floor(armor.getBaseBonusStrength() * slotBonus));
        hero.setItemBonusDexterity((int) Math.floor(armor.getBaseBonusDexterity() * slotBonus));
        hero.setItemBonusIntelligence((int) Math.floor(armor.getBaseBonusIntelligence() * slotBonus));

        if (add) { //add armor stats
            hero.setBaseHealth(hero.getBaseHealth() + hero.getItemBonusHealth());
            hero.setBaseStrength(hero.getBaseStrength() + hero.getItemBonusStrength());
            hero.setBaseDexterity(hero.getBaseDexterity() + hero.getItemBonusDexterity() );
            hero.setBaseIntelligence(hero.getBaseIntelligence() + hero.getItemBonusIntelligence());
        }else { //remove armor stats
            hero.setBaseHealth(hero.getBaseHealth() - hero.getItemBonusHealth());
            hero.setBaseStrength(hero.getBaseStrength() - hero.getItemBonusStrength());
            hero.setBaseDexterity(hero.getBaseDexterity() - hero.getItemBonusDexterity());
            hero.setBaseIntelligence(hero.getBaseIntelligence() - hero.getItemBonusIntelligence());
        }
    }

    //remove item from hero
    public void removeItem(Hero hero, Item item){
        SlotType slotType = item.getSlotType();
        if(item.getItemType() == ItemType.Weapon){
            hero.removeWeapon(slotType);
        } else {
            hero.removeArmor(slotType);
            addArmorBonusStats(hero, (Armor) item, slotType, false);
        }
    }

    //damage when attacking
    public void attack(Hero hero, Weapon weapon) {
        if (!hero.equippedWeapon.isEmpty()) {
            int damage = 0;
            if (weapon.getWeaponType() == WeaponType.Melee) {
                damage = (int) Math.floor(weapon.getBaseDamage() + (hero.getBaseStrength() * weapon.getDamageIncrease()));
            } else if (weapon.getWeaponType() == WeaponType.Range) {
                damage = (int) Math.floor(weapon.getBaseDamage() + (hero.getBaseDexterity() * weapon.getDamageIncrease()));
            } else if (weapon.getWeaponType() == WeaponType.Magic) {
                damage = (int) Math.floor(weapon.getBaseDamage() + (hero.getBaseIntelligence() * weapon.getDamageIncrease()));
            }
            System.out.println(hero.getHeroName() + " is attacking for " + damage + " damage");
        } else {
            System.out.println("No weapons equipped");
        }
    }
}