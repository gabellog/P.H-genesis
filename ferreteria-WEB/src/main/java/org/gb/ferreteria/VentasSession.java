package org.gb.ferreteria;

import org.gb.ventas.VentasModel;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by gustavo on 26/11/14.
 */
@Named
@SessionScoped
public class VentasSession implements Serializable{

    int count = 0;

    @EJB
    VentasModel ventasModel;


    public int getVentasModelCount(){
        return ventasModel.getNumeroLlamados();
    }

    public int getCount(){
        return count++;
    }

    public void eliminarStateful(){
        ventasModel.destruir();
    }
}
