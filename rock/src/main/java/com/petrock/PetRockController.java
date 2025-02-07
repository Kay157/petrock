package com.petrock;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class PetRockController {
    private PetRock rock;
    private PetRockView view;
    
    public PetRockController(PetRockView view) {
        this.rock = rock;
        this.view = view;
    }
    
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        PetRock rock;
        
        File file = new File("rock.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                rock = gson.fromJson(reader, PetRock.class);
            } catch (Exception e) {
                rock = createNewRock(scanner);
            }
        } else {
            rock = createNewRock(scanner);
        }
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
                    scanner.close();
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            view.displayStatus(rock);
        }
  
    }
    private static PetRock createNewRock(Scanner scanner) {
        System.out.print("Enter a name for your pet rock: ");
        String name = scanner.nextLine();
        return new PetRock(name);
    }



}
