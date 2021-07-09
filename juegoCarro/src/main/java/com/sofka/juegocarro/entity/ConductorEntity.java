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
public class ConductorEntity {
    private int idconductor;
    private String nomconductor;
    private Integer numerocarro;
    private Integer numerocarril;
    private Integer avance;

    /**
     * @return the idconductor
     */
    public int getIdconductor() {
        return idconductor;
    }

    /**
     * @param idconductor the idconductor to set
     */
    public void setIdconductor(int idconductor) {
        this.idconductor = idconductor;
    }

    /**
     * @return the nomconductor
     */
    public String getNomconductor() {
        return nomconductor;
    }

    /**
     * @param nomconductor the nomconductor to set
     */
    public void setNomconductor(String nomconductor) {
        this.nomconductor = nomconductor;
    }

    /**
     * @return the numerocarro
     */
    public Integer getNumerocarro() {
        return numerocarro;
    }

    /**
     * @param numerocarro the numerocarro to set
     */
    public void setNumerocarro(Integer numerocarro) {
        this.numerocarro = numerocarro;
    }

    /**
     * @return the numerocarril
     */
    public Integer getNumerocarril() {
        return numerocarril;
    }

    /**
     * @param numerocarril the numerocarril to set
     */
    public void setNumerocarril(Integer numerocarril) {
        this.numerocarril = numerocarril;
    }

    /**
     * @return the avance
     */
    public Integer getAvance() {
        return avance;
    }

    /**
     * @param avance the avance to set
     */
    public void setAvance(Integer avance) {
        this.avance = avance;
    }
    
    
    
}
