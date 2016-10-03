package cajero;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *Cuadros de Texto
 * @author Miki
 */

    ///-------------------Genera los JTexFields (Cuadros de texto)-----------------------\\\\
public class CuadroDeTexto {
private final JTextField pantalla;
    public CuadroDeTexto(boolean b) {
        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Courier New", Font.BOLD, 20));
        pantalla.setHorizontalAlignment(JTextField.CENTER);
        pantalla.setEditable(b);
    }
    
    public JTextField RegresarPantalla(){
        return pantalla;
    }
}
