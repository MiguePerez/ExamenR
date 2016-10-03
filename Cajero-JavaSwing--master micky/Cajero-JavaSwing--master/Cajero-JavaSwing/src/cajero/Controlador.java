package cajero;

/**
 *
 * @author Miki
 */
public class Controlador {
    Usuario user;
    String Operacion;
    int SaldoFinal =0;
    ///-----------------------Ejecuta las operaciones -----------------------\\\\
    public Controlador(Usuario user) {
        this.user = user;
    }    
    public Controlador(String Operacion, int Cantidad) {
        this.Operacion = Operacion;
        if(Operacion.equals("Depositar")){
             SaldoFinal=user.getSaldo() + Cantidad;
            user.setSaldo(SaldoFinal);
        }else if(Operacion.equals("Retirar")){
            SaldoFinal=user.getSaldo() - Cantidad;
            user.setSaldo(SaldoFinal);
        }
    }
}
