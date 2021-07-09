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
public class PodioEntity {
    private int idpodio;
    private ConductorEntity conductor;
    private Integer puesto;
    
    
    
    

    /**
     * @return the idpodio
     */
    public int getIdpodio() {
        return idpodio;
    }

    /**
     * @param idpodio the idpodio to set
     */
    public void setIdpodio(int idpodio) {
        this.idpodio = idpodio;
    }

    /**
     * @return the conductor
     */
    public ConductorEntity getConductor() {
        return conductor;
    }

    /**
     * @param conductor the conductor to set
     */
    public void setConductor(ConductorEntity conductor) {
        this.conductor = conductor;
    }

    /**
     * @return the puesto
     */
    public Integer getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    
    
}
