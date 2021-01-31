package com.company.items.armor;

import com.company.items.SlotType;

public class Leather extends Armor {
    private static ArmorType armorType = ArmorType.Leather;

    public Leather(String name, int level, SlotType slotType) {
        super(slotType, name, level, 20, 3, 1, 0, 8, 1, 2, 0, armorType);
    }
}