package org.gb.ventas;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by gustavo on 25/11/14.
 */
@Stateless
public class AdministradorVentas {

    public String holaAdminVentas(){
        return "Hola administrador de ventas";
    }

}
