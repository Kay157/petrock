package com.petrock;


import junit.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

class PetRock {
    private String name;
    private String mood;
    private int hunger;
    private int boredom;
    private int energy;
    private boolean canFeed = true;
    private boolean canPlay = true;
    private int zeroEnergyTurns = 0;
    
    public PetRock(String name) {
        this.name = name;
        this.hunger = 3;
        this.boredom = 2;
        this.energy = 5;
        updateMood();
    }
    
    public void feed() {
        if (!canFeed) {
            System.out.println("You must wait before feeding again!");
            return;
        }
        if (energy > 0) {
            hunger = Math.max(0, hunger - 2);
            boredom = Math.min(10, boredom + 1);
            energy--;
            canFeed = false;
            canPlay = true;
            advanceTurn();
        } else {
            System.out.println(name + " is too tired to eat!");
        }
    }
    
    public void play() {
        if (!canPlay) {
            System.out.println("You must wait before playing again!");
            return;
        }
        if (energy >= 2) {
            boredom = Math.max(0, boredom - 3);
            hunger = Math.min(10, hunger + 1);
            energy -= 2;
            canPlay = false;
            canFeed = true;
            advanceTurn();
        } else {
            System.out.println(name + " is too tired to play!");
        }
    }
    
    public void polish() {
        hunger = Math.max(0, hunger - 1);
        boredom = Math.max(0, boredom - 1);
        energy = Math.min(10, energy + 1);
        mood = "Happy";
        canFeed = true;
        canPlay = true;
        advanceTurn();
    }
    
    public void checkStatus() {
        System.out.println("\n" + name + "'s Status:");
        System.out.println("Mood: " + mood);
        System.out.println("Hunger: " + hunger);
        System.out.println("Boredom: " + boredom);
        System.out.println("Energy: " + energy + "\n");
    }
    
    private void updateMood() {
        if (energy <= 2) {
            mood = "Tired";
        } else if (hunger < 4 && boredom < 4 && energy > 3) {
            mood = "Happy";
        } else if (hunger > 7 || boredom > 7 || energy <= 3) {
            mood = "Sad";
        } else {
            mood = "Bored";
        }
    }
    
    private void advanceTurn() {
        hunger = Math.min(10, hunger + 1);
        boredom = Math.min(10, boredom + 1);
        if (energy == 0) {
            zeroEnergyTurns++;
        } else {
            zeroEnergyTurns = 0;
        }
        if (zeroEnergyTurns >= 3 || hunger == 10 || boredom == 10) {
            System.out.println(name + " has rolled away in protest! Game over.");
            System.exit(0);
        }
        randomEvent();
        updateMood();
        saveToFile();
    }
    
    private void randomEvent() {
        Random rand = new Random();
        int event = rand.nextInt(10);
        if (event == 1) {
            System.out.println("Your rock found a shiny pebble! It's happier now!");
            boredom = Math.max(0, boredom - 2);
        } else if (event == 2) {
            System.out.println("Your rock got some extra sleep! Energy restored!");
            energy = Math.min(10, energy + 2);
        } else if (event == 3) {
            System.out.println("Your rock is scared by a sudden noise! Boredom increased!");
            boredom = Math.min(10, boredom + 2);
        } else if (event == 4) {
            System.out.println("Your rock is grumpy today. Hunger increased!");
            hunger = Math.min(10, hunger + 2);
        }
    }
    
    public void saveToFile() {
        try (Writer writer = new FileWriter("rock.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static PetRock loadFromFile() {
        try (Reader reader = new FileReader("rock.json")) {
            Gson gson = new Gson();
            return gson.fromJson(reader, PetRock.class);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

