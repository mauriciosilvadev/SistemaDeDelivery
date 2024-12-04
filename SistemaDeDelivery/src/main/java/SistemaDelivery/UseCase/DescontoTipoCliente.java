/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.UseCase;

import SistemaDelivery.Enums.TipoCupom;
import SistemaDelivery.Interfaces.IDescontoTaxaEntrega;
import SistemaDelivery.Models.CupomDescontoEntrega;
import SistemaDelivery.Models.Item;
import SistemaDelivery.Models.Pedido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morrice
 */
public class DescontoTipoCliente implements IDescontoTaxaEntrega{
    
    private final Map<String, Double> descontosTipoCliente;

    public DescontoTipoCliente() {
        this.descontosTipoCliente = new HashMap<>();
        
        this.descontosTipoCliente.put("Ouro", 0.3);
        this.descontosTipoCliente.put("Prata", 0.2);
        this.descontosTipoCliente.put("Bronze", 0.1);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        return new CupomDescontoEntrega("Desconto por tipo de cliente", descontosTipoCliente.get(pedido.getCliente().getTipo()), TipoCupom.POR_CLIENTE);
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
}
