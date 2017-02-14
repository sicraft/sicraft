/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import com.game.minecraft.listeners.AuthService;
import com.game.sicraft.database.Database;
import com.game.sicraft.database.mysql.MySQL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author zouhairhajji
 */
public class OnLoad extends JavaPlugin {

    private Logger logger;
    private List<Listener> listeners;
    private Database db;

    @Override
    public void onEnable() {
        this.logger = Bukkit.getServer().getLogger();

        try {
            this.listeners = new LinkedList<Listener>();
            this.db = new MySQL("localhost", "3306", "sicraft", "root", "");
            this.db.openConnection();
            this.listeners.add(new AuthService(this.db, this.logger));
            
        } catch (Exception ex) {
            this.logger.warning("Error Loading Listener : " + ex.getMessage());
        }

        for (Listener listener : this.listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, this);
            this.logger.info("Add Listener : " + listener.getClass());
        }
    }

}
