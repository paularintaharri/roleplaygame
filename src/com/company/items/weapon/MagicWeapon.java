package com.company.items.weapon;

import com.company.items.SlotType;

public class MagicWeapon extends Weapon{
    private static WeaponType weaponType = WeaponType.Magic;

    public MagicWeapon(String name, int level, SlotType slotType) {
        super(name, level, 25, 2, 3, weaponType, slotType);
    }
}