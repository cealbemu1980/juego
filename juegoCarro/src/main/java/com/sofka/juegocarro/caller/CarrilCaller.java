/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro.caller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author cealb
 */
public class CarrilCaller {

    Conector cc = new Conector();    
    Connection conn = cc.getConexion();
    Scanner entrada = new Scanner(System.in);
    
    public void insertarDatos() {

        System.out.println("Dele un nombre al carril");
        String nomcarrilvalor = entrada.next();
        int distarecorridavalor = 2;
        int idpistavalor = 1;
        try {
            String SQL = "INSERT INTO carril (nomcarril, distarecorrida, idpista) values (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, nomcarrilvalor);
            pst.setInt(2, distarecorridavalor);
            pst.setInt(3, idpistavalor);
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void consultarDatos(){
        System.out.println("Consulta de Carril");
        String SQL = "SELECT * FROM carril";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Identificador de carril: "+rs.getString("idcarril"));
                System.out.println("Nombre del carril: "+rs.getString("nomcarril"));
                System.out.println("Distancia de carril en Kilometros: "+rs.getString("distarecorrida"));
                System.out.println("Identificador de pista: "+rs.getString("idpista"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
