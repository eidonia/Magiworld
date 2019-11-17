package com.bast.magiworld.test;

import com.bast.magiworld.Mage;
import com.bast.magiworld.Personnage;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombatActivityTest {

    @Test
    public void testPointDeVie() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(mage.getVie()>0);
        Mage test = new Mage("Mage", "Koin", 25,0, 25, 0, 0, "Bdf", "Heal");
        assertTrue(test.getVie() == 0);
        Mage magetest = new Mage("Mage", "Koin", 25,-100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(magetest.getVie() < 0);
    }



}