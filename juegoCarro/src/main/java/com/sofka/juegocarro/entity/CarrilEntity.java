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
public class CarrilEntity {
    private int idcarril;
    private String nomcarril;
    private int distrecorrida;
    private PistaEntity pista;

    /**
     * @return the idcarril
     */
    public int getIdcarril() {
        return idcarril;
    }

    /**
     * @param idcarril the idcarril to set
     */
    public void setIdcarril(int idcarril) {
        this.idcarril = idcarril;
    }

    /**
     * @return the nomcarril
     */
    public String getNomcarril() {
        return nomcarril;
    }

    /**
     * @param nomcarril the nomcarril to set
     */
    public void setNomcarril(String nomcarril) {
        this.nomcarril = nomcarril;
    }

    /**
     * @return the distrecorrida
     */
    public int getDistrecorrida() {
        return distrecorrida;
    }

    /**
     * @param distrecorrida the distrecorrida to set
     */
    public void setDistrecorrida(int distrecorrida) {
        this.distrecorrida = distrecorrida;
    }

    /**
     * @return the pista
     */
    public PistaEntity getPista() {
        return pista;
    }

    /**
     * @param pista the pista to set
     */
    public void setPista(PistaEntity pista) {
        this.pista = pista;
    }
    
    
}
