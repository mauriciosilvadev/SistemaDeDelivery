/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.Models;

import SistemaDelivery.Enums.TipoCupom;

/**
 *
 * @author Morrice
 */
    public class CupomDescontoEntrega {
        private String nomeMetodo;
        private double valorDesconto;
        private TipoCupom tipoCupom;

        public CupomDescontoEntrega(String nomeMetodo, double valorDesconto, TipoCupom tipoCupom) {
            this.nomeMetodo = nomeMetodo;
            this.valorDesconto = valorDesconto;
            this.tipoCupom = tipoCupom;
        } 

        public double getValorDesconto() {
            return this.valorDesconto;
        }

        public String getNomeMetodo() {
            return this.nomeMetodo;
        }
        
        public TipoCupom getTipoCupom() {
            return tipoCupom;
        }

        @Override
        public String toString() {
            return "Cupom: " + nomeMetodo + ", Desconto: " + valorDesconto * 100 + "%";
        }
    }
