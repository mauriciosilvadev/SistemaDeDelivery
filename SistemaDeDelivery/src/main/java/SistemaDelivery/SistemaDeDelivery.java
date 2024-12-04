/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SistemaDelivery;

import SistemaDelivery.Models.Cliente;
import SistemaDelivery.Models.Item;
import SistemaDelivery.Models.Pedido;
import SistemaDelivery.Services.CalculadoraDescontoService;
import java.time.LocalDate;

/**
 *
 * @author Morrice
 */
public class SistemaDeDelivery {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Mauricio", "Ouro", 1, "Rua marechal floriano", "Centro", "Alegre");
        Item item1 = new Item("Maca", 2, 100, "Alimentação");        
        Item item2 = new Item("Banana", 1, 2, "Alimentação");
        // Item item3 = new Item("Banana", 1, 2, "Educação");
        // Item item4 = new Item("Banana", 1, 2, "Educação");
        // Item item5 = new Item("Banana", 1, 2, "Educação");

        
        Pedido pedido = new Pedido(cliente, 10, LocalDate.MIN);
        
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        // pedido.adicionarItem(item3);
        // pedido.adicionarItem(item4);
        // pedido.adicionarItem(item5);
        
        pedido.setCodigoDeCupom("DESC30");
        
        CalculadoraDescontoService calculadora = new CalculadoraDescontoService();
        
        calculadora.calcularDesconto(pedido);
        
        System.out.println(pedido.toString());
        
        System.out.println(pedido.getDescontoConcedido());
    }
}
