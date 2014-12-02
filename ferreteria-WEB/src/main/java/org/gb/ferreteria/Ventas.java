package org.gb.ferreteria;

import org.gb.ventas.AdministradorVentas;
import org.gb.ventas.VentasModel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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

    @Resource
    SessionContext sessionContext;


    @GET
    @Produces("text/html")
    public String doGet(){
        return "<h1>" +
                "<br> stateless--"+ administradorVentas.holaAdminVentas() + "</br>" +
                "<br> global " + (numeroDeLlamados++) + "</br>" +
                "</h1>";
    }


    @GET
    @Path("/stateful")
    @Produces("text/html")
    public String stateful(@Context HttpServletRequest httpServletRequest){
        Object o = httpServletRequest.getSession().getAttribute("statefulBean");
        VentasModel ventasModel = o == null ? null : (VentasModel) o;
        if(ventasModel == null){
            try {
                InitialContext initialContext = new InitialContext();
                ventasModel = (VentasModel) initialContext.lookup("java:global/ferreteria-EAR-0.1/ferreteria-EJB-0.1/VentasModel!org.gb.ventas.VentasModel");
                httpServletRequest.getSession().setAttribute("statefulBean",ventasModel);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return numeroDeLlamados + "   " + ventasModel.getNumeroLlamados();

    }

    @GET
    @Path("/eliminar")
    @Produces("text/html")
    public String eliminar(){
        //ventasModel.destruir();
        return "Eliminado ";
    }


    @GET
    @Path("/crearmensaje")
    @Produces("text/html")
    public String crearMensaje(){
        administradorVentas.crearMensaje();
        return "Creando mensaje";
    }



}
