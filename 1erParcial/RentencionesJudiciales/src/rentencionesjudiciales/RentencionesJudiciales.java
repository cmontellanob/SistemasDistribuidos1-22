/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rentencionesjudiciales;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class RentencionesJudiciales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IAsfi asfi;

            Scanner sc = new Scanner(System.in);
            System.out.print("introduzca ci");
            String ci = sc.next();
            System.out.print("introduzca nombre");
            String nombre = sc.next();
            System.out.print("introduzca apellidos");
            String apellidos = sc.next();

            asfi = (IAsfi) Naming.lookup("rmi://localhost/asfi"); // instanciar un objeto remoto 

            ArrayList<Cuenta> cuentas = asfi.ConsultarCuentas(ci, nombre, apellidos);
            int i = 1;
            if (cuentas.size() > 0) {
                for (Cuenta cuenta : cuentas) {
                    System.out.print(i + ".-");
                    System.out.println(cuenta);
                    i++;
                }
                System.out.println("Elija la opcion de la cuenta que quiere retener");
                int op = sc.nextInt();
                if (cuentas.size() > 0) {
                    System.out.println("Que monto va a retener?");
                    double monto = sc.nextDouble();
                    System.out.println("Cual es el motivo de la retencion?");
                    String glosa = sc.next();

                    if (asfi.RetenerMonto(cuentas.get(op - 1), monto, glosa)) {
                        System.out.println("transacción con éxito");
                    } else {
                        System.out.println("no se pudo realizar la retención");
                    }
                }
            }

        } catch (NotBoundException ex) {
            Logger.getLogger(RentencionesJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RentencionesJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RentencionesJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
