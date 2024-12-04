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
public class DescontoTipoItem implements IDescontoTaxaEntrega{
    
    private final Map<String, Double> descontosPorTipoItem;

    public DescontoTipoItem() {
        this.descontosPorTipoItem = new HashMap<>();
        
        this.descontosPorTipoItem.put("Alimentação", 0.05);
        this.descontosPorTipoItem.put("Educação", 0.2);
        this.descontosPorTipoItem.put("Lazer", 0.15);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        double totalDesconto = 0;
        
        for(Item item: pedido.getItens()) {
            Double desconto = descontosPorTipoItem.get(item.getTipo());
            
            if (desconto != null) {
                totalDesconto += desconto;
            }
        }
        
        return new CupomDescontoEntrega("Desconto por tipo de item", totalDesconto, TipoCupom.POR_TIPO_DE_ITEM);
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for(CupomDescontoEntrega cupom: pedido.getCuponsAplicados()) {
            if (cupom.getTipoCupom() == TipoCupom.MANUAL || cupom.getTipoCupom() == TipoCupom.POR_CLIENTE) {
                return false;
            }
        }
        
        for(Item item: pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo())) {
                return true;
            }
        }
        
        return false;
    }
}
