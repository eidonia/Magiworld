package com.bast.magiworld;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void createStats() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertEquals(mage.force + mage.agilite + mage.intelligence, mage.niveau);
        Mage magetest = new Mage("Mage", "Koin", 25,100, 50, 15, 0, "Bdf", "Heal");
        assertNotEquals((magetest.force + magetest.agilite + magetest.intelligence), magetest.niveau);

    }

    @Test
    public void testCarac() {
        Mage mage = new Mage("Mage", "Koin", 25,125, 25, 0, 0, "Bdf", "Heal");
        assertEquals(mage.vie, 5* mage.niveau);
        Mage bloup = new Mage("Mage", "Koin", 25,0, 25, 0, 0, "Bdf", "Heal");
        assertEquals(bloup.vie, 0);
        Mage test = new Mage("Mage", "Koin", 25,-100, 25, 0, 0, "Bdf", "Heal");
        assertTrue(test.getVie() < 0);
        Mage magetest = new Mage("Mage", "Koin", 25,(int)(1000*Math.random()), 25, 0, 0, "Bdf", "Heal");
        assertNotEquals(magetest.vie, 5*magetest.niveau);
    }

    @Test
    public void chooseClass() {
        Mage mage = new Mage("Mage", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertEquals(mage.name, "Mage");
        Mage magetest = new Mage("", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertEquals(magetest.name, "");
        Mage mag = new Mage("Guerrier", "Koin", 25,100, 25, 0, 0, "Bdf", "Heal");
        assertNotEquals(mag.name, "Mage");
    }
}