/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro;

import com.sofka.juegocarro.caller.CarrilCaller;
import com.sofka.juegocarro.caller.CarroCaller;
import com.sofka.juegocarro.caller.ConductorCaller;
import com.sofka.juegocarro.caller.Conector;
import com.sofka.juegocarro.caller.PistaCaller;
import com.sofka.juegocarro.caller.PodioCaller;
import com.sofka.juegocarro.entity.ConductorEntity;
import com.sofka.juegocarro.entity.PistaEntity;
import com.sofka.juegocarro.entity.PodioEntity;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cealb
 */
public class JuegoMain {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        PistaCaller pista = new PistaCaller();
        PistaEntity pistaDTO = new PistaEntity();
        List<ConductorEntity> listacondutores = new ArrayList<>();
        List<PodioEntity> podioList = new ArrayList<>();

        pistaDTO = pista.confirarCarrera();   
        
        listacondutores = pista.configuracionPilotos(pistaDTO);
        
        podioList = pista.carrera(listacondutores, pistaDTO);
        
        //llmar los insertar
        pista.insertardatos(pistaDTO, listacondutores, podioList);
        
        
        pista.mostrarPodio(pistaDTO);
    }
       
    
   
   
}
