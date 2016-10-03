package cajero;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Miki
 */
public class Cajero extends JFrame {

    ///-----------------------Seccion de Variables -----------------------\\\\
    int numero = 0;
    Usuario user;
    JTextField CuadroTexto, CuadroTexto1, CuadroTexto2, CuadroTexto3;
    JPanel panelPrincipal, panelNumeros, panelOperaciones, panelTextos;

    public Cajero(Usuario user) {
        ///-----------------------Seccion de Ventana -----------------------\\\\
        super();
        setSize(600, 400);
        setTitle("Cajero Automatico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.user = user;
        ///-----------------------Seccion de Ventana -----------------------\\\\

        ///-----------------------Seccion de paneles -----------------------\\\\
        JPanel panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        CuadroDeTexto Texto0 = new CuadroDeTexto(false);
        this.CuadroTexto = Texto0.RegresarPantalla();
        this.CuadroTexto.setText("Cuenta de: " + user.getNombre());

        CuadroDeTexto Texto1 = new CuadroDeTexto(false);
        this.CuadroTexto1 = Texto1.RegresarPantalla();
        this.CuadroTexto1.setText("Saldo: " + user.getSaldo());

        CuadroDeTexto Texto2 = new CuadroDeTexto(false);
        this.CuadroTexto2 = Texto2.RegresarPantalla();
        this.CuadroTexto2.setText("Operacion $");

        CuadroDeTexto Texto3 = new CuadroDeTexto(true);
        this.CuadroTexto3 = Texto3.RegresarPantalla();
        this.CuadroTexto3.setText("0");
        this.CuadroTexto3.requestFocusInWindow();

        panelOperaciones = new JPanel();
        nuevoBotonOperacion("Depositar");
        nuevoBotonOperacion("Retirar");
        nuevoBotonOperacion("Regresar");

        panelTextos = new JPanel();
        panelTextos.add(CuadroTexto);
        panelTextos.add(CuadroTexto1);
        panelTextos.add(CuadroTexto2);
        panelTextos.add(CuadroTexto3);

        panelPrincipal.add("South", panelOperaciones);
        panelPrincipal.add("Center", panelTextos);
        ///-----------------------Seccion de paneles -----------------------\\\\
    }
///-----------------------Seccion de Agregar Botones al panel -----------------------\\\\

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton Botoncito = (JButton) evt.getSource();
                operacionPulsado(Botoncito.getText());
            }
        });
        panelOperaciones.add(btn);
    }
///-----------------------Indica accion de cada boton -----------------------\\\\

    private void operacionPulsado(String tecla) {
        CuadroTexto2.setText("Cargando...");
        try {
            numero = Integer.parseInt(this.CuadroTexto3.getText());
        } catch (Exception e) {
            CuadroTexto2.setText("Ingresa un numero");
        }
        boolean condicion = false;
        switch (tecla) {
            case "Depositar":
                int donar;
                donar = JOptionPane.YES_NO_OPTION;
                donar = JOptionPane.showConfirmDialog(null, "Desea donar a Becalos $1 peso?", "Donar", donar);
                switch (donar) {
                    case JOptionPane.NO_OPTION:
                        condicion = validar();
                        if (condicion) {
                            user.setSaldo(this.user.getSaldo() + numero);
                            CuadroTexto1.setText("Saldo: " + this.user.getSaldo());
                            CuadroTexto2.setText("Deposito Completado");
                        } else {
                            CuadroTexto2.setText("!ERROR¡");
                            JOptionPane.showMessageDialog(null, "¡INGRESA UN NUMERO VALIDO!");
                        }
                        CuadroTexto3.setText("0");                        
                        break;
                    case JOptionPane.YES_OPTION:
                        condicion = validar();
                        if (condicion) {
                            user.setSaldo(this.user.getSaldo() + numero-1);
                            CuadroTexto1.setText("Saldo: " + this.user.getSaldo());
                            CuadroTexto2.setText("Deposito Completado");
                        } else {
                            CuadroTexto2.setText("!ERROR¡");
                            JOptionPane.showMessageDialog(null, "¡INGRESA UN NUMERO VALIDO!");
                        }
                        CuadroTexto3.setText("0");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        CuadroTexto3.setText("0");
                        break;
                    default:
                        break;
                }

                break;
            case ("Retirar"):
                if (this.user.getSaldo() >= numero) {

                    int Confirmacion;
                    Confirmacion = JOptionPane.YES_NO_OPTION;
                    condicion = validar();
                    if (condicion) {
                        Confirmacion = JOptionPane.showConfirmDialog(null, "Vas a Retirar $" + numero + " pesos?", "Confirmacion", Confirmacion);
                        switch (Confirmacion) {
                            case JOptionPane.NO_OPTION:
                                CuadroTexto2.setText("Operacion Anulada");
                                break;
                            case JOptionPane.YES_OPTION:
                                int SaldoOriginal = this.user.getSaldo();
                                user.setSaldo(SaldoOriginal - numero);
                                CuadroTexto2.setText("Retiro Completado");
                                CuadroTexto1.setText("Saldo: " + this.user.getSaldo());
                                break;
                            case JOptionPane.CLOSED_OPTION:
                                CuadroTexto2.setText("Cancelada");
                                break;
                            default:
                                break;
                        }
                    } else {
                        CuadroTexto2.setText("ingresa un numero");
                    }

                    CuadroTexto3.setText("0");

                } else {
                    CuadroTexto2.setText("Saldo Insuficiente");
                    CuadroTexto3.setText("0");
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
///-----------------------Validacion de los campos -----------------------\\\\

    private boolean validar() {
        if (numero <= 0) {
            numero = 0;
            CuadroTexto2.setText("Numero invalido");
            return false;
        } else {
            return true;
        }
    }
}
