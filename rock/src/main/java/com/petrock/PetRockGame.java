package com.petrock;



public class PetRockGame {
    public static void main(String[] args) { 
        PetRockView view = new PetRockView();
        PetRockController controller = new PetRockController(view);
        controller.startGame();
    }
    
 
}
