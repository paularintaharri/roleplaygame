package com.company;

import com.company.factories.ArmorFactory;
import com.company.factories.HeroFactory;
import com.company.factories.WeaponFactory;
import com.company.heroes.*;
import com.company.items.armor.*;
import com.company.items.weapon.*;

import static com.company.items.SlotType.*;

public class Main {

    public static void main(String[] args) {

        ArmorFactory armorFactory = new ArmorFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        HeroFactory heroFactory = new HeroFactory();
        Action action = new Action();

        //Create characters
        Hero warrior = heroFactory.getHero("First Warrior", HeroType.Warrior);
        Hero ranger = heroFactory.getHero("First Ranger", HeroType.Ranger);
        Hero mage = heroFactory.getHero("First Mage", HeroType.Mage);

        //Print character stats
        System.out.println(warrior.toString());
        System.out.println(ranger.toString());
        System.out.println(mage.toString());

        //Add XP for character
        warrior.addExp(200);
        ranger.addExp(260);
        mage.addExp(225);

        System.out.println(warrior.toString());
        System.out.println(ranger.toString());
        System.out.println(mage.toString());

        //Create Weapons
        Weapon rangeWeapon = weaponFactory.getWeapon("Rocket Launcher",10, Weapon, WeaponType.Range);
        System.out.println(rangeWeapon.toString());
        Weapon meleeWeapon = weaponFactory.getWeapon("Golden Sword",5, Weapon, WeaponType.Melee);
        System.out.println(meleeWeapon.toString());
        Weapon magicWeapon = weaponFactory.getWeapon("Magic Rain", 5, Weapon, WeaponType.Magic);
        System.out.println(magicWeapon.toString());

        //Create Armors
        Armor cloth1 = armorFactory.getArmor("Magical Scarf", 7, Head, ArmorType.Cloth);
        System.out.println(cloth1.toString());
        Armor leather1 = armorFactory.getArmor("Strong Leather Helmet", 1, Legs, ArmorType.Leather);
        System.out.println(leather1.toString());
        Armor leather2 = armorFactory.getArmor("Chunky Leather Armor", 5, Legs, ArmorType.Leather);
        System.out.println(leather2.toString());
        Armor plate1 = armorFactory.getArmor("Silver Plate", 5, Body, ArmorType.Plate);
        System.out.println(plate1.toString());

        //Equip weapons
        action.equipItem(warrior, meleeWeapon);
        action.equipItem(mage, magicWeapon);
        action.equipItem(ranger, rangeWeapon);

        //Equip armors
        action.equipItem(warrior, leather2);
        action.equipItem(warrior, plate1);
        action.removeItem(warrior, leather2);

        action.equipItem(mage, leather1);
        action.equipItem(mage, cloth1);
        action.equipItem(mage, leather2);

        System.out.println(warrior.toString());
        System.out.println(ranger.toString());
        System.out.println(mage.toString());

        //Get all equipped items
        mage.getEquippedItems();
        warrior.getEquippedItems();
        ranger.getEquippedItems();

        //Hero attacking
        action.attack(warrior, meleeWeapon);
        action.attack(mage, magicWeapon);
        action.attack(ranger, rangeWeapon);

    }
}
