package com.company.items.armor;

import com.company.items.SlotType;

public class Cloth extends Armor {
    private static ArmorType armorType = ArmorType.Cloth;

    public Cloth(String name, int level, SlotType slotType) {
        super(slotType, name, level, 10, 1, 0, 3, 5, 0, 1, 2, armorType);
    }
}
