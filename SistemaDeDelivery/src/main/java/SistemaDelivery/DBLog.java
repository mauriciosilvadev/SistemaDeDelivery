/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery;

import SistemaDelivery.DB.Database;
import SistemaDelivery.Interfaces.ILog;
import SistemaDelivery.Models.Pedido;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Morrice
 */
public class DBLog implements ILog {

    @Override
    public void escrever(Pedido pedido) {
        Connection con = Database.getInstance().getConnection();

        try {
            Statement ste = con.createStatement();

            ste.executeUpdate("drop table if exists pedido_logs");
            ste.executeUpdate("create table pedido_logs (usuario string, data string, hora string, codigo_pedido int, cliente string)");
            ste.executeUpdate("insert into pedido_logs values('" + 
                    pedido.getCliente().getNome() + "', '" + 
                    pedido.getDataPedido().toLocalDate().toString() + "', '" +
                    pedido.getDataPedido().toLocalTime().toString() + "', '" +
                    pedido.getCodigoPedido() + "', '" +
                    pedido.getCliente().getNome() + "')");
            
            con.close();
        } catch (SQLException e) {
            System.out.println("Houve ao escrever dados no banco: " + e.getMessage());
        }
    }
}
