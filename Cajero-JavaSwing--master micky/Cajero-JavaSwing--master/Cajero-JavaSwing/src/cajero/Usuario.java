package cajero;

/**
 *
 * @author Rod
 */
public class Usuario {

    private String nombre;
    private String pass;
    private int saldo;

    public Usuario() {
    }

    public Usuario(String nombre, String pass, int saldo) {       
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    public String getPass() {
        return pass;
    }

    public void setPass(String Pass) {
        this.pass = Pass;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
