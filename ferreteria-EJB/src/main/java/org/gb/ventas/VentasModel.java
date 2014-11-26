package org.gb.ventas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by gustavo on 26/11/14.
 */
@Stateful
@StatefulTimeout(value = 60,unit = TimeUnit.SECONDS)
public class VentasModel implements Serializable{

    private int numeroDeLlamados = 0;

    public int getNumeroLlamados(){
        return numeroDeLlamados ++;
    }

    @Remove
    public void destruir(){
        System.out.println("Mori");
    }


    @PostConstruct
    public void  init(){
        System.out.println("PostConstruct");
    }

    @PostActivate
    public void postActivate(){
        System.out.println("postActivate");

    }

    @PrePassivate
    public void prePasivate(){
        System.out.println("prePasivate");

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");

    }

}
