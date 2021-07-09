/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.juegocarro.entity;

/**
 *
 * @author cealb
 */
public class CarroEntity {
    private int idcarro;
    private String nomcarro;
    private int numganador;
    private CarrilEntity carril;

    /**
     * @return the idcarro
     */
    public int getIdcarro() {
        return idcarro;
    }

    /**
     * @param idcarro the idcarro to set
     */
    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }

    /**
     * @return the nomcarro
     */
    public String getNomcarro() {
        return nomcarro;
    }

    /**
     * @param nomcarro the nomcarro to set
     */
    public void setNomcarro(String nomcarro) {
        this.nomcarro = nomcarro;
    }

    /**
     * @return the nomganador
     */
    public int getNomganador() {
        return numganador;
    }

    /**
     * @param nomganador the nomganador to set
     */
    public void setNomganador(int nomganador) {
        this.numganador = nomganador;
    }

    /**
     * @return the carril
     */
    public CarrilEntity getCarril() {
        return carril;
    }

    /**
     * @param carril the carril to set
     */
    public void setCarril(CarrilEntity carril) {
        this.carril = carril;
    }
    
    
}
