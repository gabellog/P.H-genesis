package org.gb.ferreteria;

import org.gb.ventas.AdministradorVentas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by gustavo on 26/11/14.
 */
@Path(value = "ventas")
@Stateless
public class Ventas implements Serializable {

    public int numeroDeLlamados = 0;

    @EJB
    private AdministradorVentas administradorVentas;

    @Inject
    private VentasSession ventasSession;


    @GET
    @Produces("text/html")
    public String doGet(){
        return "<h1>" +
                "<br> stateless--"+ administradorVentas.holaAdminVentas() + "</br>" +
                "<br> stateful--" + ventasSession.getVentasModelCount() + "</br>" +
                "<br> session --" + ventasSession.getCount() + "</br>" +
                "<br> global " + (numeroDeLlamados++) + "</br>" +
                "</h1>";
    }

    @GET
    @Path("/eliminar")
    @Produces("text/html")
    public String eliminar(){
        //ventasModel.destruir();
        return "Eliminado ";
    }



}
