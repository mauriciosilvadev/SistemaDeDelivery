/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Morrice
 */
public class Database {

    private Connection connection = null;

    private static Database INSTANCE;

    private Database() throws SQLException {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        } catch (SQLException e) {
            System.out.println("Houve um erro ao estabelecer a conexão com o banco: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() {
        try {
            if (INSTANCE == null) {
                INSTANCE = new Database();
            }
        } catch (SQLException e) {
            System.out.println("Houve ao criar a instância: " + e.getMessage());
        }
        
        return INSTANCE;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Houve um erro ao fechar a conexão com o banco: " + e.getMessage());
        }
    }
}
