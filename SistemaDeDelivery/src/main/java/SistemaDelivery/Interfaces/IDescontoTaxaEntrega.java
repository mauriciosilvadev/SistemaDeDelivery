/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SistemaDelivery.Interfaces;

import SistemaDelivery.Models.CupomDescontoEntrega;
import SistemaDelivery.Models.Pedido;

/**
 *
 * @author Morrice
 */
public interface IDescontoTaxaEntrega {
    public CupomDescontoEntrega calcularDesconto(Pedido pedido);
    
    public boolean seAplica(Pedido pedido);
}
