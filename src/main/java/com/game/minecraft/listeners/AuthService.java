/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.minecraft.listeners;

import com.game.minecraft.dao.CompanyDAO;
import com.game.sicraft.database.Database;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.bukkit.event.Listener;

/**
 *
 * @author zouhairhajji
 */
public class AuthService implements Listener{
    
    private Database db;
    private CompanyDAO companyDAO;
    private Logger logger;

    
    public AuthService(Database db, Logger logger) throws SQLException {
        this.db = db;
        this.logger = logger;
        this.companyDAO = new CompanyDAO(db, logger);
        
        
        this.companyDAO.findAll(new String[]{CompanyDAO.field_idCompany, CompanyDAO.field_dateCreation}, CompanyDAO.field_idCompany + "=" + 1);
    }
    
    
    
}
