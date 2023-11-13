
package Controller;

import Model.Rules;
import View.CachipumView;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author lautaro
 */
public class CachipumController implements ActionListener{
    public CachipumController(CachipumView view, Rules model){
        this.model = model;
        this.view = view;
        this.view.setVisible(true);
        this.view.startButton.addActionListener(this);
        this.view.resetButton.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.view.startButton)){
            if(endGame == false){
                 String roundResultOne = this.model.getValue();
            String roundResultTwo = this.model.getValue();
            
            setImagesFirstPlayer(roundResultOne);
            setImagesSeccondPlayer(roundResultTwo);
            
            switch (combinations(roundResultOne, roundResultTwo)) {
                case 2:
                    scoreOne();
                    break;
                case 1:
                    scoreTwo(roundResult);
                    break;
                default:
                    break;
            }
            }else{
                
                System.exit(0);
            }
           
            
        }else if(e.getSource().equals(this.view.resetButton)){
            resetGame();
        }
    }
    
    private int combinations(String roundResultOne, String roundResultTwo){
        if(roundResultOne.equals(roundResultTwo)){
            return 0;
        }else if(roundResultOne.equals("piedra") && roundResultTwo.equals("tijera")){
            return 1;
        }else if(roundResultOne.equals("papel") && roundResultTwo.equals("piedra")){
            return 1;
        }else if(roundResultOne.equals("tijera") && roundResultTwo.equals("papel")){
            return 1;
            
        }else if(roundResultOne.equals("tijera") && roundResultTwo.equals("piedra")){
            return 2;
        }else if(roundResultOne.equals("piedra") && roundResultTwo.equals("papel")){
            return 2;
        }else{
            return 2;
        }
    }
    
    private void setImagesFirstPlayer(String value){
        switch (value) {
            case "piedra":
                this.view.jLabel1.setIcon(rockIcon);
                break;
            case "papel":
                this.view.jLabel1.setIcon(papelIcon);
                break;
            default:
                this.view.jLabel1.setIcon(shearsIcon);
                break;
        }
    }
    
    private void setImagesSeccondPlayer(String value){
        switch (value) {
            case "piedra":
                this.view.jLabel2.setIcon(rockIcon);
                break;
            case "papel":
                this.view.jLabel2.setIcon(papelIcon);
                break;
            default:
                this.view.jLabel2.setIcon(shearsIcon);
                break;
        }
    }
    
    private void resetGame(){
        this.view.jLabel1.setIcon(initialIcon);
        this.view.jLabel2.setIcon(initialIcon);
        this.view.scoreOne.setText("0");
        this.view.scoreTwo.setText("0");
        endGame = false;
        this.view.startButton.setText("START");
    }
    
    private void scoreOne(){
        actualScore = parseInt(this.view.scoreOne.getText());
        actualScore ++;
        this.view.scoreOne.setText(String.valueOf(actualScore));
        if(this.model.win(actualScore)){
            this.view.scoreOne.setText("player one won");
            this.view.scoreTwo.setText("player one won");
            endGame = true;
            this.view.startButton.setText("EXIT");
        }
      
        
    }
    
    private void scoreTwo(int actualScore){
        actualScore = parseInt(this.view.scoreTwo.getText());
        actualScore ++;
        this.view.scoreTwo.setText(String.valueOf(actualScore));
        if(this.model.win(actualScore)){
            this.view.scoreOne.setText("player two won");
            this.view.scoreTwo.setText("player two won");
             endGame = true;
             this.view.startButton.setText("EXIT");
        }
    }
    
    
    
    
    
    private CachipumView view;
    private Rules model;
    private int roundResult, actualScore;
    private boolean endGame = false;
            
         
    // ---------- ---------- ---------- ---------- ----------
    
    String initialImage = "/home/lautaro/NetBeansProjects/CachipumPP/src/View/icons/ppt.png";
    ImageIcon initialIcon = new ImageIcon(initialImage);
  
    String rockImage = "/home/lautaro/NetBeansProjects/CachipumPP/src/View/icons/piedra.png";
    ImageIcon rockIcon = new ImageIcon(rockImage);
    
     String papelImage = "/home/lautaro/NetBeansProjects/CachipumPP/src/View/icons/papel.png";
    ImageIcon papelIcon = new ImageIcon(papelImage);
    
    String shearsImage = "/home/lautaro/NetBeansProjects/CachipumPP/src/View/icons/tijera.png";
    ImageIcon shearsIcon = new ImageIcon(shearsImage);
}
