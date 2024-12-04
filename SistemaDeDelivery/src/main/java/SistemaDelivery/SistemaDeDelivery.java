/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package SistemaDelivery;

import SistemaDelivery.Models.Cliente;
import SistemaDelivery.Models.Item;
import SistemaDelivery.Models.Pedido;
import SistemaDelivery.Services.PedidoService;
import java.time.LocalDateTime;

/**
 *
 * @author Morrice
 */
public class SistemaDeDelivery {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Mauricio", "Ouro", 1, "Rua marechal floriano", "Centro", "Alegre");
        Item item1 = new Item("Maca", 2, 100, "Alimentação");
        Item item2 = new Item("Banana", 1, 2, "Alimentação");

        Pedido pedido = new Pedido(cliente, 10, LocalDateTime.now());

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        pedido.setCodigoDeCupom("DESC30");

        // Log com SQLite
        PedidoService calculadora = new PedidoService(new DBLog());

        // Log com XML
        // PedidoService calculadora = new PedidoService(new XMLLog());
        
        // Log com JSON
        // PedidoService calculadora = new PedidoService(new JSONLog());
        
        calculadora.calcularDesconto(pedido);

        System.out.println(pedido.toString());
    }
}
