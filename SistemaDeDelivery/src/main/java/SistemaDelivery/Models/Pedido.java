/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Morrice
 */
public class Pedido {
    private double taxaEntrega;
    private Cliente cliente;
    private final List<Item> itens = new ArrayList<>();
    private final List<CupomDescontoEntrega> cuponsAplicados = new ArrayList<>();
    private final Map<String, Double> codigosDeDescontoManuais;
    private LocalDateTime dataPedido;
    private String codigoDeCupom;
    private Integer codigoPedido;
    
    
    public Pedido(Cliente cliente, double taxaEntrega, LocalDateTime dataPedido) {
        if (taxaEntrega < 0  || dataPedido == null  || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }
        
        this.cliente = cliente;
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        
        this.codigosDeDescontoManuais = new HashMap<>();
        
        this.codigosDeDescontoManuais.put("DESC10", 0.1);
        this.codigosDeDescontoManuais.put("DESC20", 0.2);
        this.codigosDeDescontoManuais.put("DESC30", 0.3);
        
        Random random = new Random();
        this.codigoPedido = random.nextInt(100000000);
    }
    
    public Integer getCodigoPedido() {
        return codigoPedido;
    }
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public void setCodigoDeCupom(String codigo) {
        this.codigoDeCupom = codigo;
    }
    
    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }
    
    public Map<String, Double> getCodigosDeDescontoManuais() {
        return codigosDeDescontoManuais;
    }
    
    public void adicionarCupom(CupomDescontoEntrega cupom) {
        cuponsAplicados.add(cupom);
    }
    
    public List<CupomDescontoEntrega> getCuponsAplicados() {
        return cuponsAplicados;
    }
    
    public double getValorPedido() {
        double valorTotal = 0;
        
        for (Item item: itens) {
            valorTotal += item.getValorTotal();
        }
        
        return valorTotal + taxaEntrega;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
    
    public double getTaxaEntrega() {
        return taxaEntrega;
    }
    
    public double getDescontoConcedido() {
        double totalDesconto = 0;
        
        for (CupomDescontoEntrega cupom: cuponsAplicados) {
            totalDesconto += cupom.getValorDesconto();
        }
        
        return totalDesconto;
    }
    
    public void setTaxaEntrega(double novaTaxa) {
        this.taxaEntrega = novaTaxa;
    }
    
    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", cliente=" + cliente.getNome() + ", itens=" + itens + ", desconto concedido: " + getDescontoConcedido() * 100 + "%, cupons aplicados: " + cuponsAplicados + '}';
    }
}
