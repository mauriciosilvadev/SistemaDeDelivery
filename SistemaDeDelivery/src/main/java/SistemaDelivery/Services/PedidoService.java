/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.Services;

import SistemaDelivery.UseCase.DescontoPorBairro;
import SistemaDelivery.UseCase.DescontoTipoCliente;
import SistemaDelivery.UseCase.DescontoTipoItem;
import SistemaDelivery.UseCase.DescontoValorPedido;
import SistemaDelivery.Enums.TipoCupom;
import SistemaDelivery.Interfaces.IDescontoTaxaEntrega;
import SistemaDelivery.Interfaces.ILog;
import SistemaDelivery.Models.CupomDescontoEntrega;
import SistemaDelivery.Models.Item;
import SistemaDelivery.Models.Pedido;
import java.util.List;

/**
 *
 * @author Morrice
 */
public class PedidoService {

    private final List<IDescontoTaxaEntrega> metodosDeDesconto;

    private final ILog log;

    public PedidoService(ILog log) {
        this.metodosDeDesconto = List.of(
                new DescontoPorBairro(),
                new DescontoTipoCliente(),
                new DescontoTipoItem(),
                new DescontoValorPedido()
        );

        this.log = log;
    }

    public void calcularDesconto(Pedido pedido) {
        if (pedido.getCodigosDeDescontoManuais().containsKey(pedido.getCodigoDeCupom())) {

            pedido.adicionarCupom(new CupomDescontoEntrega("Cupom " + pedido.getCodigoDeCupom(), pedido.getCodigosDeDescontoManuais().get(pedido.getCodigoDeCupom()), TipoCupom.MANUAL));
        }

        for (IDescontoTaxaEntrega metodo : metodosDeDesconto) {
            if (metodo.seAplica(pedido)) {
                CupomDescontoEntrega cupom = metodo.calcularDesconto(pedido);
                pedido.adicionarCupom(cupom);
            }
        }

        this.aplicaDesconto(pedido);
    }

    private void aplicaDesconto(Pedido pedido) {
        if (pedido.getDescontoConcedido() >= 1) {
            pedido.setTaxaEntrega(0);
        } else {
            pedido.setTaxaEntrega(pedido.getTaxaEntrega() - (pedido.getTaxaEntrega() * pedido.getDescontoConcedido()));
        }

        this.calcularValorTotal(pedido);
    }

    private void calcularValorTotal(Pedido pedido) {
        double valorTotal = 0;

        for (Item item : pedido.getItens()) {
            valorTotal += item.getValorTotal();
        }

        pedido.setValorTotal(valorTotal + pedido.getTaxaEntrega());

        log.escrever(pedido);
    }
}
