/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.minecraft.dao;

import com.game.minecraft.abstractClasses.AbstractDAO;
import com.game.minecraft.beans.Company;
import com.game.sicraft.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author zouhairhajji
 */
public class CompanyDAO extends AbstractDAO<Company, Integer> {

    public static String field_idCompany = "idCompany";
    public static String field_dateCreation = "dateCreation";
    public static String field_isPublic = "isPublic";
    public static String field_name = "name";

    public CompanyDAO(Database database, Logger logger) throws SQLException {
        super("sicraft_company", database, logger);
    }

    @Override
    public void createTable() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS `" + tableName + "` ("
                + "  `" + field_idCompany + "`    int(11)      PRIMARY KEY   AUTO_INCREMENT,"
                + "  `" + field_dateCreation + "` datetime     NOT NULL,"
                + "  `" + field_isPublic + "`     bit(1)       NOT NULL,"
                + "  `" + field_name + "`         varchar(255) NOT NULL"
                + ");";
        this.database.getConnection().createStatement().executeUpdate(query);
        this.logger.info("[CREATE TABLE " + tableName + "]");
    }

    
    @Override
    public List<Company> findAll(String[] fields, String ... wheres) throws SQLException {
        String query = this.generateSelect(fields, wheres);
        ResultSet resultSet = this.database.getConnection().createStatement().executeQuery(query);
        List<Company> companies = new LinkedList<Company>();
        while(resultSet.next()){
            
        }
        this.logger.info("[QUERY : ] " + query);
        return null;
    }

    @Override
    public Company findById(Integer id) {
        return null;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    public Company persist(Company object) {
        return null;
    }

    @Override
    public Company update(Company object) {
        return null;
    }

}
