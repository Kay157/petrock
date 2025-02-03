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


}
