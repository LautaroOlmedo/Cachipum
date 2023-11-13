/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;

/**
 *
 * @author lautaro
 */
public class Rules {
    
    
    
    public String getValue(){
         Random random = new Random();
        int result = random.nextInt(3);
        
        switch (result) {
            case 0:
                return "tijera";
            case 1:
                return "papel";
            default:
                /*return "Error in model"*/
                return "piedra";
        }    
    }
    
    public boolean win(int score){
        return score == 3;
    }
    
}
