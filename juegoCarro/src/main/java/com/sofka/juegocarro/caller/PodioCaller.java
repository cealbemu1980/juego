/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro.caller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author cealb
 */
public class PodioCaller {
    Conector cc = new Conector();    
    Connection conn = cc.getConexion();
    Scanner entrada = new Scanner(System.in);
    
    public void insertarDatos() {

        System.out.println("Podio");
        int ganadorunovalor = 1;
        int ganadordosvalor = 1;
        int ganadortresvalor = 1;
        try {
            String SQL = "INSERT INTO podio (puestouno, puestodos, puestotres) values (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, ganadorunovalor);
            pst.setInt(2, ganadordosvalor);
            pst.setInt(3, ganadortresvalor);
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     public void consultarDatos(){
        System.out.println("Consulta de Podio");
        String SQL = "SELECT * FROM podio";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Identificador de podio: "+rs.getString("idpodio"));
                System.out.println("Ganador uno: "+rs.getString("puestouno"));
                System.out.println("Ganador dos: "+rs.getString("puestodos"));
                System.out.println("Ganador tres: "+rs.getString("puestotres"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
