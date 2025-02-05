 package com.petrock;

public class RockObserver implements ObserverInterface 

{
    @Override
    public void update(PetRock rock) 
    {
        // update 
        rock.checkStatus();
    }


}
