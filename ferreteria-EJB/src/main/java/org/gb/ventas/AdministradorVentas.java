package org.gb.ventas;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by gustavo on 25/11/14.
 */
@Stateless
@Remote
public class AdministradorVentas {

    public String holaAdminVentas(){
        return "Hola administrador de ventas";
    }

}
