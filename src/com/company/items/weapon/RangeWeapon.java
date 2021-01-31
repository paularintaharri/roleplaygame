package com.company.items.weapon;

import com.company.items.SlotType;

public class RangeWeapon extends Weapon{
    private static WeaponType weaponType = WeaponType.Range;

    public RangeWeapon(String name, int level, SlotType slotType) {
        super(name, level, 5, 3, 2, weaponType, slotType);
    }
}