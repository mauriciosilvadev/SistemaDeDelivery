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
public class DescontoValorPedido implements IDescontoTaxaEntrega{
    
    private final double VALOR_DESCONTO = 0.15;

    public DescontoValorPedido() {
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        return new CupomDescontoEntrega("Desconto por valor do pedido", VALOR_DESCONTO, TipoCupom.POR_VALOR_DO_PEDIDO);
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > 2000;
    }
}
