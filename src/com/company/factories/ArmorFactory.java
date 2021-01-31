package com.company.factories;

import com.company.items.SlotType;
import com.company.items.armor.*;

public class ArmorFactory {

    public Armor getArmor(String name, int level, SlotType slotType, ArmorType armorType) {
        if(armorType == ArmorType.Leather) {
            return new Leather(name, level, slotType);
        }
        if(armorType == ArmorType.Plate) {
            return new Plate(name, level, slotType);
        }
        if(armorType == ArmorType.Cloth) {
            return new Cloth(name, level, slotType);
        } else {
            return null;
        }
    }
}
