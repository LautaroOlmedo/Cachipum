/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cachipumpp;
import Controller.CachipumController;
import Model.Rules;
import View.CachipumView;

/**
 *
 * @author lautaro
 */
public class CachipumPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CachipumView view = new CachipumView();
        Rules model = new Rules();
        CachipumController controller = new CachipumController(view, model);
    }
    
}
