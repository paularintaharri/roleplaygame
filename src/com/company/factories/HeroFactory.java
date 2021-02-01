package com.company.factories;

import com.company.heroes.*;

public class HeroFactory {

    public Hero getHero(String name, HeroType heroType) {
        if(heroType == HeroType.Mage) {
            return new Mage(name);
        }
        if(heroType == HeroType.Ranger) {
            return new Ranger(name);
        }
        if(heroType == HeroType.Warrior) {
            return new Warrior(name);
        } else {
            return null;
        }
    }
}
