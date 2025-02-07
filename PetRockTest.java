/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.petrock;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rober
 */
public class PetRockTest {
    
    public PetRockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }/**
     * Test of feed method, of class PetRock.
     */
    
    @Test
    public void testInit() {
        System.out.println("init test");
        PetRock rock = new PetRock("Rocky Test");
        assertEquals(5, rock.getEnergy());
        assertEquals(3, rock.getHunger());
        assertEquals(2, rock.getBoredom());
        assertEquals("Happy", rock.getMood());
    }
    
    @Test
    public void testAdvance() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("advance turn test");
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.advanceTurn();
        int seed = rock.seed;
        if (seed == 1) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 1);
            assertEquals(firstBoredom, rock.getBoredom() + 1);
        }
        else if (seed == 2) {
            assertEquals(firstEnergy, rock.getEnergy() - 2);
            assertEquals(firstHunger, rock.getHunger() - 1);
            assertEquals(firstBoredom, rock.getBoredom() - 1);
        }
        else if (seed == 3) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 1);
            assertEquals(firstBoredom, rock.getBoredom() - 3);
        }
        else if (seed == 4) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 3);
            assertEquals(firstBoredom, rock.getBoredom() - 1);
        }
        else {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 1);
            assertEquals(firstBoredom, rock.getBoredom() - 1);
        }
    }
    
    @Test
    public void testRandom() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("random event test");
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.randomEvent();
        int seed = rock.seed;
        if (seed == 1) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom() + 2);
        }
        else if (seed == 2) {
            assertEquals(firstEnergy, rock.getEnergy() - 2);
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else if (seed == 3) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom() - 2);
        }
        else if (seed == 4) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom());
        }
    }
    
    @Test
    public void testFeed() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("feed test");
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.feed();
        int seed = rock.seed;
        if (seed == 1) {
            assertEquals(firstEnergy, rock.getEnergy() + 1);
            assertEquals(firstHunger, rock.getHunger() + 1);
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else if (seed == 2) {
            assertEquals(firstEnergy, rock.getEnergy() - 1);
            assertEquals(firstHunger, rock.getHunger() + 1);
            assertEquals(firstBoredom, rock.getBoredom() - 2);
        }
        else if (seed == 3) {
            assertEquals(firstEnergy, rock.getEnergy() + 1);
            assertEquals(firstHunger, rock.getHunger() + 1);
            assertEquals(firstBoredom, rock.getBoredom() - 4);
        }
        else if (seed == 4) {
            assertEquals(firstEnergy, rock.getEnergy() + 1);
            assertEquals(firstHunger, rock.getHunger() - 1);
            assertEquals(firstBoredom, rock.getBoredom() - 2);
        }
        else {
            assertEquals(firstEnergy, rock.getEnergy() + 1);
            assertEquals(firstHunger, rock.getHunger() + 1);
            assertEquals(firstBoredom, rock.getBoredom() - 2);
        }
    }

    /**
     * Test of play method, of class PetRock.
     */
    @Test
    public void testPlay() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("play test");
        rock.boredom = 6;
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.play();
        int seed = rock.seed;
        if (seed == 1) {
            assertEquals(firstEnergy, rock.getEnergy() + 2);
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom() + 4);
        }
        else if (seed == 2) {
            assertEquals(firstEnergy, rock.getEnergy());
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom() + 2);
        }
        else if (seed == 3) {
            assertEquals(firstEnergy, rock.getEnergy() + 2);
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else if (seed == 4) {
            assertEquals(firstEnergy, rock.getEnergy() + 2);
            assertEquals(firstHunger, rock.getHunger() - 4);
            assertEquals(firstBoredom, rock.getBoredom() + 2);
        }
        else {
            assertEquals(firstEnergy, rock.getEnergy() + 2);
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom() + 2);
        }
    }

    /**
     * Test of polish method, of class PetRock.
     */
    @Test
    public void testPolish() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("polish test");
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.polish();
        int seed = rock.seed;
        if (seed == 1) {
            assertEquals(firstEnergy, rock.getEnergy() - 1);
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom() + 2);
        }
        else if (seed == 2) {
            assertEquals(firstEnergy, rock.getEnergy() - 3);
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else if (seed == 3) {
            assertEquals(firstEnergy, rock.getEnergy() - 1);
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom() - 2);
        }
        else if (seed == 4) {
            assertEquals(firstEnergy, rock.getEnergy() - 1);
            assertEquals(firstHunger, rock.getHunger() - 2);
            assertEquals(firstBoredom, rock.getBoredom());
        }
        else {
            assertEquals(firstEnergy, rock.getEnergy() - 1);
            assertEquals(firstHunger, rock.getHunger());
            assertEquals(firstBoredom, rock.getBoredom());
        }
    }

    /**
     * Test of checkStatus method, of class PetRock.
     */
    @Test
    public void testCheckStatus() {
        PetRock rock = new PetRock("Rocky Test");
        System.out.println("check status test");
    }

    /**
     * Test of getHunger method, of class PetRock.
     */
    @Test
    public void testGetHunger() {
        System.out.println("get hunger test");
        PetRock rock = new PetRock("Rocky Test");
        assertEquals(rock.hunger, rock.getHunger());
    }

    /**
     * Test of getBoredom method, of class PetRock.
     */
    @Test
    public void testGetBoredom() {
        System.out.println("get boredom test");
        PetRock rock = new PetRock("Rocky Test");
        assertEquals(rock.boredom, rock.getBoredom());
    }

    /**
     * Test of getEnergy method, of class PetRock.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("get energy test");
        PetRock rock = new PetRock("Rocky Test");
        assertEquals(rock.energy, rock.getEnergy());
    }

    /**
     * Test of getMood method, of class PetRock.
     */
    @Test
    public void testGetMood() {
        System.out.println("get mood test");
        PetRock rock = new PetRock("Rocky Test");
        assertEquals(rock.mood, rock.getMood());
    }

    
}
