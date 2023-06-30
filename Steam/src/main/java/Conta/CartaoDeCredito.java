/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conta;

import java.util.Date;

/**
 *
 * @author gabriel
 */

public class CartaoDeCredito {
    private Integer numero;
    private String bandeira;
    private Date dataVencimento;
    private String nomeCartao;

    public CartaoDeCredito() {

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    @Override
    public String toString() {
        return "CartaoDeCredito{" + "numero=" + numero + ", bandeira=" + bandeira + ", dataVencimento=" + dataVencimento + ", nomeCartao=" + nomeCartao + '}';
    }
}
