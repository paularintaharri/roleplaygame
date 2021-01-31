package com.company.items.weapon;

import com.company.items.SlotType;

public class MeleeWeapon extends Weapon{
    private static WeaponType weaponType = WeaponType.Melee;

    public MeleeWeapon(String name, int level, SlotType slotType) {
        super(name, level, 15, 2, 1.5, weaponType, slotType);
    }
}