package com.petrock;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTesting {

    PetRock rock = new PetRock("Rocky Test");

    @Test
    public void initRockTest(){
        assertEquals(5, rock.getEnergy());
        assertEquals(3, rock.getHunger());
        assertEquals(2, rock.getBoredom());
        assertEquals("Happy", rock.getMood());
    }

    @Test
    public void feedRockTest(){
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.feed();
        assertEquals(firstEnergy, rock.getEnergy() + 1);
        assertEquals(firstHunger, rock.getHunger() - 1);
        assertEquals(firstBoredom, rock.getBoredom() + 2);
    }
    
    @Test
    public void playWithRockTest(){
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.play();
        assertEquals(firstEnergy, rock.getEnergy() + 2);
        assertEquals(firstHunger, rock.getHunger() + 2);
        assertEquals(firstBoredom, rock.getBoredom() - 2);
    }
    
    @Test
    public void polishTest(){
        int firstEnergy = rock.getEnergy();
        int firstHunger = rock.getHunger();
        int firstBoredom = rock.getBoredom();
        rock.polish();
        assertEquals(firstEnergy, rock.getEnergy() + 1);
        assertEquals(firstHunger, rock.getHunger());
        assertEquals(firstBoredom, rock.getBoredom());
    }
}
