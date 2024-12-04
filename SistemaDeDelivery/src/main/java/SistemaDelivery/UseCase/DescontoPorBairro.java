/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.UseCase;

import SistemaDelivery.Enums.TipoCupom;
import SistemaDelivery.Interfaces.IDescontoTaxaEntrega;
import SistemaDelivery.Models.CupomDescontoEntrega;
import SistemaDelivery.Models.Pedido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morrice
 */
public class DescontoPorBairro implements IDescontoTaxaEntrega{
    
    private final Map<String, Double> descontosPorBairro;
    
    public DescontoPorBairro() {
        this.descontosPorBairro = new HashMap<>();
        
        this.descontosPorBairro.put("Centro", 0.2);
        this.descontosPorBairro.put("Bela Vista", 0.3);
        this.descontosPorBairro.put("Cidade Maravilhosa", 0.15);
        
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        return new CupomDescontoEntrega("Desconto por bairro", descontosPorBairro.get(pedido.getCliente().getBairro()), TipoCupom.POR_BAIRRO);
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosPorBairro.containsKey(pedido.getCliente().getBairro());
    }
}
