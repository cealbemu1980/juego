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
public class CarroCaller {
    Conector cc = new Conector();    
    Connection conn = cc.getConexion();
    Scanner entrada = new Scanner(System.in);
    
    public void insertarDatos() {

        System.out.println("Dele un nombre al carro");
        String nomcarrovalor = entrada.next();
        int numganadorvalor = 1;
        int idcarrilvalor = 1;
        try {
            String SQL = "INSERT INTO carro (nomcarro, numganador, idcarril) values (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, nomcarrovalor);
            pst.setInt(2, numganadorvalor);
            pst.setInt(3, idcarrilvalor);
            pst.execute();
            System.out.println("Registro Exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void consultarDatos(){
        System.out.println("Consulta de Carro");
        String SQL = "SELECT * FROM carro";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Identificador de carro: "+rs.getString("idcarro"));
                System.out.println("Nombre del carro: "+rs.getString("nomcarro"));
                System.out.println("Numero Ganador: "+rs.getString("numganador"));
                System.out.println("Identificador de carril: "+rs.getString("idcarril"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
