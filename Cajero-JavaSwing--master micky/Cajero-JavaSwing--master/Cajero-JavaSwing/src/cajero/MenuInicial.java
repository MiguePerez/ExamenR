package cajero;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Miki
 */
public class MenuInicial extends JFrame {

    JPanel panelPrincipal, Botton;
    JTextField BancoTitulo;

    public MenuInicial() {
        super();
        setSize(600, 150);
        setTitle("Cajero Automatico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        CuadroDeTexto BancoTituloG= new CuadroDeTexto(false);
        BancoTitulo = BancoTituloG.RegresarPantalla();
        BancoTitulo.setText("El Banco de Mike");
        Botton = new JPanel();
        
        nuevoBotonOperacion("Registrarse");
        panelPrincipal.add("North", Botton);
        panelPrincipal.add("Center", BancoTitulo);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        Botton.add(btn);
    }

    private void operacionPulsado(String tecla) {
       if (tecla.equals("Registrarse")) {
           Registro Reg = new Registro();
           Reg.setVisible(true);
           this.dispose();
        }
    }
}
