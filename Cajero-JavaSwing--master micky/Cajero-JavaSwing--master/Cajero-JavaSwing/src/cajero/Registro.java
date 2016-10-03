package cajero;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Miki
 */
public class Registro extends JFrame {

    JPanel panelPrincipal, panelBotones, panelCuadritos, panelCuadritos2, PanelRegistro;
    JTextField usuario, pass;
    JTextField usuarioR, passR;

    public Registro() {
        super();
        setSize(500, 400);
        setTitle("Registro");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ///-------------------Seccion de Paneles-----------------------\\\\
        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        panelBotones = new JPanel();

        panelCuadritos = new JPanel();
        panelCuadritos.setLayout(new BoxLayout(panelCuadritos, BoxLayout.Y_AXIS));
        panelCuadritos2 = new JPanel();
        panelCuadritos2.setLayout(new BorderLayout());

        PanelRegistro = new JPanel();
        PanelRegistro.setLayout(new BorderLayout());
        ///-------------------Seccion de Cuadros De Texto-----------------------\\\\
        CuadroDeTexto UserText = new CuadroDeTexto(true);
        usuario = UserText.RegresarPantalla();
        usuario.setText("Nombre de Usuario");

        CuadroDeTexto in1 = new CuadroDeTexto(false);
        usuarioR = in1.RegresarPantalla();
        CuadroDeTexto in2 = new CuadroDeTexto(false);
        passR = in2.RegresarPantalla();

        CuadroDeTexto PassText= new CuadroDeTexto(true);
        pass = PassText.RegresarPantalla();
        pass.setText("Contraseña");
        passR.setText("Ingresa una contraseña:");
        usuario.setText("Mike");
        usuarioR.setText("Ingresa tu nombre:");
        ///-------------------Añadir Elementos-----------------------\\\\
        nuevoBotonOperacion("Registrar");
        nuevoBotonOperacion("Regresar");
        panelCuadritos.add(this.usuarioR);
        panelCuadritos.add(this.usuario);
        panelCuadritos.add(this.passR);
        panelCuadritos.add(this.pass);

        panelPrincipal.add("North", panelCuadritos);
        panelPrincipal.add("Center", panelBotones);

    }
///-------------------Genera Botones----------------------\\\\
    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton Botoncito = (JButton) evt.getSource();
                operacionPulsado(Botoncito.getText());
            }
        });
        panelBotones.add(btn);
    }
///-------------------Genera Acciones a los Botones----------------------\\\\
    private void operacionPulsado(String tecla) {
        int num = 0;
        switch (tecla) {
            case "Registrar":
                boolean condicion = Validacion();
                if(condicion){
                    JOptionPane.showMessageDialog(null, "¡Todo Bien¡");
                    Usuario user = new Usuario();
                    user.setNombre(usuario.getText());
                    user.setPass(pass.getText());
                    Cajero c = new Cajero(user);
                    c.setVisible(condicion);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "¡Porfavor, valida los datos!");
                }
                break;
            case "Regresar":
                MenuInicial m = new MenuInicial();
                m.setVisible(true);
                this.dispose();
                break;
            default:
                break;
        }
    }
///-------------------Valida los campos----------------------\\\\
    private boolean Validacion() {
        if (pass.getText().equals("")||usuario.getText().equals("")) {
            return false;
        } else return true;        
    }
}
