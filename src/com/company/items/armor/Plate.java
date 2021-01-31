package com.company.items.armor;

import com.company.items.SlotType;

public class Plate extends Armor {
    private static ArmorType armorType = ArmorType.Plate;

    public Plate(String name, int level, SlotType slotType) {
        super(slotType, name, level, 30, 1, 3, 0, 12, 2, 1, 0, armorType);
    }
}