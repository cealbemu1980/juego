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
public class ConductorCaller {
    Conector cc = new Conector();    
    Connection conn = cc.getConexion();
    Scanner entrada = new Scanner(System.in);
    
    public void insertarDatos() {

        System.out.println("Dele un nombre al conductor");
        String nomconductorvalor = entrada.next();
        int idcarrovalor = 1;
        try {
            String SQL = "INSERT INTO conductor (nomconductor, idcarro) values (?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, nomconductorvalor);
            pst.setInt(2, idcarrovalor);
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void consultarDatos(){
        System.out.println("Consulta de Conductor");
        String SQL = "SELECT * FROM conductor";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Identificador de conductor: "+rs.getString("idconductor"));
                System.out.println("Nombre del conductor: "+rs.getString("nomconductor"));
                System.out.println("Identificador de carro: "+rs.getString("idcarro"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
