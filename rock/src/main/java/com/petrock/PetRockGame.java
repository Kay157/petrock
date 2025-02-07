package com.petrock;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class PetRockGame {
    public static void main(String[] args) {
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
        
        PetRockView view = new PetRockView();
        PetRockController controller = new PetRockController(rock, view);
        controller.startGame();
    }
    
    private static PetRock createNewRock(Scanner scanner) {
        System.out.print("Enter a name for your pet rock: ");
        String name = scanner.nextLine();
        return new PetRock(name);
    }
}
