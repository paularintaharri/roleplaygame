package com.company.factories;

import com.company.items.SlotType;
import com.company.items.weapon.*;

public class WeaponFactory {

    public Weapon getWeapon(String name, int level, SlotType slotType, WeaponType weaponType) {
        if(weaponType == WeaponType.Magic) {
            return new MagicWeapon(name, level, slotType);
        }
        if(weaponType == WeaponType.Melee) {
            return new MeleeWeapon(name, level, slotType);
        }
        if(weaponType == WeaponType.Range) {
            return new RangeWeapon(name, level, slotType);
        } else {
            return null;
        }
    }
}


