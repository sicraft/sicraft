/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.minecraft.beans;

import java.sql.Date;

/**
 *
 * @author zouhairhajji
 */
public class Company {
    
    private int idCompant;
    private String name;
    private boolean isDefault;
    private Date dateCreation;

    public Company() {
    }

    public Company(int idCompant, String name, boolean isDefault, Date dateCreation) {
        this.idCompant = idCompant;
        this.name = name;
        this.isDefault = isDefault;
        this.dateCreation = dateCreation;
    }
    
    
    
}
