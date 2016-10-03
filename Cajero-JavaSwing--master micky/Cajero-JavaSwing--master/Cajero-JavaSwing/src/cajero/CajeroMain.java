package cajero;

import javax.swing.UIManager;

/**
 *
 * @author Miki 
 */
public class CajeroMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        MenuInicial MenuInicial = new MenuInicial();
        MenuInicial.setVisible(true);
    }
}


