/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.minecraft.abstractClasses;

import com.game.sicraft.database.Database;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author zouhairhajji
 * T represente la classe concerné
 * R represente le type d'ID
 */
public abstract class AbstractDAO <T, R extends Number>{
    
    protected Database database;
    protected Logger logger;
    public String tableName;
    
    public AbstractDAO(String tableName, Database database, Logger logger) throws SQLException {
        this.database = database;
        this.logger = logger;
        this.tableName = tableName;
        this.createTable();
    }
    
    
    
    
    
    
    public abstract void createTable() throws SQLException;
    public abstract List<T> findAll(String[] fields, String ... wheres) throws SQLException;
    public abstract T findById(R id) throws SQLException;
    public abstract boolean removeById(R id) throws SQLException;
    public abstract T persist(T object) throws SQLException;
    public abstract T update(T object) throws SQLException;
    
    
    
    
    protected String generateSelect(String[] fields, String ... wheres){
        String _select = "";
        String _where = "";
        String query = "";
        if (fields.length > 0) {
            for (String field : fields) {
                _select += field += ", ";
            }
            _select = _select.substring(0, _select.length()-2);
        }
        if (wheres.length > 0) {
            for (String where : wheres) {
                _where += where += " AND";
            }
            _where = _where.substring(0, _where.length()-4);
        }
        return "SELECT " +  ( (_select.trim().equalsIgnoreCase("")) ? "*" : _select) + " FROM " + tableName + ( (_where.trim().equalsIgnoreCase("")) ? "" : " WHERE "+ _where ) ;
        
    }
}
