/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro.caller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author cealb
 */
public class Conector {
    private static final String URL = "jdbc:mysql://localhost:33065/juego";
    private static final String USSERNAME = "root";
    private static final String passware = "";
    private static final String drive = "com.mysql.jdbc.Driver";

    public Connection getConexion(){
        Connection conn = null;
        try{
            Class.forName(drive);
            conn = (Connection) DriverManager.getConnection(URL, USSERNAME, passware);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    
}
