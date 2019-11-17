package com.bast.magiworld;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void createStats() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(mage.force + mage.agilite + mage.intelligence == mage.niveau);
        Mage magetest = new Mage("Mage", "Koin", 25,100, 50, 0, 0, "Bdf", "Heal");
        assertTrue(mage.force + mage.agilite + mage.intelligence != mage.niveau);

    }

    @Test
    public void testCarac() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(mage.vie == 5* mage.niveau);
        Mage bloup = new Mage("Mage", "Koin", 25,0, 25, 0, 0, "Bdf", "Heal");
        assertTrue(bloup.vie == 0);
        Mage test = new Mage("Mage", "Koin", 25,-100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(test.getVie() < 0);
        Mage magetest = new Mage("Mage", "Koin", 25,(int)(1000*Math.random()), 25, 0, 0, "Bdf", "Heal");
        assertTrue(magetest.vie != 5*magetest.niveau);
    }

    @Test
    public void chooseClass() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(mage.name.equals("Mage"));
        Mage magetest = new Mage("", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(magetest.name.equals(""));
        Mage mag = new Mage("Guerrier", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(!mag.name.equals("Mage"));
    }
}