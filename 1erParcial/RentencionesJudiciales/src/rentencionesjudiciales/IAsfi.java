/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rentencionesjudiciales;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface IAsfi extends Remote {
    ArrayList<Cuenta>ConsultarCuentas (String ci, String nombres, String apellidos) throws RemoteException ; 
    Boolean RetenerMonto(Cuenta cuenta,double monto,String glosa) throws RemoteException;

    
}
