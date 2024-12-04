/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.Models;

/**
 *
 * @author Morrice
 */
public class Cliente {
    private String nome;
    private String tipo;
    private double fidelidade;
    private String logradouro;
    private String cidade;
    private String bairro;
    
    public Cliente(String nome, String tipo, double fidelidade, String logradouro, String bairro, String cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nome + "\n" +
                "Tipo: " + tipo + "\n" +
                "Fidelidade: " + fidelidade + "\n" +
                "Endereço: " + logradouro + ", " + bairro + ", " + cidade;
    }
}
