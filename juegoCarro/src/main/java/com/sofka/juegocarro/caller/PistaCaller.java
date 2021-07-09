/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro.caller;

import com.sofka.juegocarro.entity.ConductorEntity;
import com.sofka.juegocarro.entity.PistaEntity;
import com.sofka.juegocarro.entity.PodioEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cealb
 */
public class PistaCaller {
    Conector cc = new Conector();    
    Connection conn = cc.getConexion();
    Scanner entrada = new Scanner(System.in);
    Random aleatorio = new Random();

    public void insertarDatos() {
        PistaEntity pista = new PistaEntity();
        System.out.println("Dele un nombre a la pista");
        String nompistavalor;
        nompistavalor = entrada.next();
        System.out.println("Dele una distancia de recorrido a la pista maximo 5 kilometros");
        int distanciavalor;
        distanciavalor = entrada.nextInt();
        try {
            String SQL = "INSERT INTO pista (nompista, distancia) values (?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, nompistavalor);
            pst.setInt(2, distanciavalor);
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void consultarDatos(){
        System.out.println("Consulta de Pista");
        String SQL = "SELECT * FROM pista";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Identificador de pista: "+rs.getString("idpista"));
                System.out.println("Nombre de la pista: "+rs.getString("nompista"));
                System.out.println("Distancia de la pista en Kilometros: "+rs.getString("distancia"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * metodo utilizado pra consultar el podio
     * @param pista 
     */
    public void mostrarPodio(PistaEntity pista){
        ///consulta en la base de datos para revisar el podio
    }
    
    /**
     * Metodo para iniciar juego
     * @return PistaEntity
     */
     public PistaEntity confirarCarrera() {
        PistaEntity pista = new PistaEntity();
        
        System.out.println("Configuración de juego");
        System.out.println("Ingrese número de pista:");
        pista.setIdpista(Integer.parseInt(entrada.nextLine()));

        System.out.println("Ingrese kilometraje de la pista:");
        pista.setDistancia(Integer.parseInt(entrada.nextLine()));
        
        System.out.println("Ingrese número de carriles de la pista:");
        pista.setNumerocarriles(Integer.parseInt(entrada.nextLine()));
        
        return pista;
    }
     
     /**
      * Configuración de conductores y asignación de carriles
      * @param pista
      * @return 
      */
     public List<ConductorEntity> configuracionPilotos(PistaEntity pista){
         List<ConductorEntity> listacondutores = new ArrayList<>();
         int carriles = 1;
         
         System.out.println("Configuración de ingreso de conductores");
         while (carriles <= pista.getNumerocarriles()){
            ConductorEntity conductor = new ConductorEntity();

            System.out.println("Ingrese nombre conductor:");
            conductor.setNomconductor(entrada.nextLine());
            
            System.out.println("Ingrese número carro:");
            conductor.setNumerocarro(Integer.parseInt(entrada.nextLine()));
            
            //Asignación de carriles
            conductor.setNumerocarril(carriles);
            conductor.setAvance(0);
            
            listacondutores.add(conductor);
            
            carriles = carriles + 1;
         }
         return listacondutores;
     }
     
     /**
      * 
      * Metodo de carreras
      */
    public List<PodioEntity> carrera(List<ConductorEntity> listaConductores, PistaEntity pista){
        List<PodioEntity> podioList = new ArrayList<>();
        int puesto = 1;
      
        while (puesto <= 3){
            for (ConductorEntity conductor: listaConductores) {                
                if (conductor.getAvance() < pista.getDistancia()){
                    System.out.println("Presiones enter para recorrer distancia del jugador - " + conductor.getNomconductor() + ": ");
                    int newdistancia = (aleatorio.nextInt(7-1+1)+1) * 100; //Tire el dado
                    conductor.setAvance(newdistancia + conductor.getAvance());

                    if (conductor.getAvance() >= pista.getDistancia()){
                        PodioEntity podio = new PodioEntity();
                        podio.setConductor(conductor);
                        podio.setPuesto(puesto);
                        podioList.add(podio);
                        puesto = puesto + 1;
                    }
                }
            }
        }
        return podioList;
    }
    
     public void insertardatos(PistaEntity pista, List<ConductorEntity> listaConductores, List<PodioEntity> listaPodio){
         //insert de pista
         try {
            String SQL = "INSERT INTO pista (distancia, numerocarril) values (?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, pista.getDistancia());
            pst.setInt(2, pista.getNumerocarriles());
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         for (ConductorEntity conductor: listaConductores) {  
             //insert de conductor
                try {
               String SQL = "INSERT INTO conductor (nomconductor, numerocarro, numerocarril, avance) values (?,?,?,?)";
               PreparedStatement pst = conn.prepareStatement(SQL);
               pst.setString(1, conductor.getNomconductor());
               pst.setInt(2, conductor.getNumerocarro());
               pst.setInt(3, conductor.getNumerocarril());
               pst.setInt(4, conductor.getAvance());
               pst.execute();
               System.out.println("Registro Exitoso");
           } catch (Exception e) {
               e.printStackTrace();
           }
         }
         
         for (PodioEntity podio: listaPodio) {  
              //insert de podio
              try {
            String SQL = "INSERT INTO podio (conductor, puesto) values (?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, podio.getConductor().getIdconductor());
            pst.setInt(2, podio.getPuesto());
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
         }
         
     }
    
}
