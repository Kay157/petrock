package com.petrock;

import java.util.Scanner;

public class PetRockController {
    private PetRock rock;
    private PetRockView view;
    
    public PetRockController(PetRock rock, PetRockView view) {
        this.rock = rock;
        this.view = view;
    }
    
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Feed the Rock");
            System.out.println("2. Play with the Rock");
            System.out.println("3. Polish the Rock");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> rock.feed();
                case 2 -> rock.play();
                case 3 -> rock.polish();
                case 4 -> {
                    rock.saveToFile();
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            view.displayStatus(rock);
        }
    }
}
