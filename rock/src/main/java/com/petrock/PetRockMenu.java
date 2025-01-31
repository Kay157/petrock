package com.petrock;

import java.util.*;


public class PetRockMenu 
{
    public static void main(String[] args) 
    {
        
            Scanner scanner = new Scanner(System.in);
            PetRock rock = PetRock.loadFromFile();
            if (rock == null) 
            {
                System.out.print("Enter a name for your pet rock: ");
                String name = scanner.nextLine();
                rock = new PetRock(name);
                rock.saveToFile();
            }
            
            while (true) 
            {
                System.out.println("Choose an action:");
                System.out.println("1. Feed the Rock");
                System.out.println("2. Play with the Rock");
                System.out.println("3. Polish the Rock");
                System.out.println("4. Check the Rock’s Status");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1 -> rock.feed();
                    case 2 -> rock.play();
                    case 3 -> rock.polish();
                    case 4 -> rock.checkStatus();
                    case 5 -> {
                        rock.saveToFile();
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        


        }






        }