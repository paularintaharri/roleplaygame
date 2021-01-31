package com.company.items;

public interface Item {
    ItemType getItemType();
    int getLevel();
    String getName();
    SlotType getSlotType();
}
