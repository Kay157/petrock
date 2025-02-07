package com.petrock;

public class PetRockView {
    
    public void displayStatus(PetRock rock) {
        System.out.println("\n" + rock.getName() + "'s Status:");
        System.out.println("Mood: " + rock.getMood());
        System.out.println("Hunger: " + rock.getHunger());
        System.out.println("Boredom: " + rock.getBoredom());
        System.out.println("Energy: " + rock.getEnergy() + "\n");
    }
}
