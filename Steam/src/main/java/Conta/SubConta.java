/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conta;

/**
 *
 * @author gabriel
 */
public class SubConta extends Conta{
    private boolean acessaConteudoImproprio;
    private boolean compraConteudoImproprio;
    private boolean acessaJogos;
    private boolean compraJogos;

    public SubConta() {
    }

    public boolean isAcessaConteudoImproprio() {
        return acessaConteudoImproprio;
    }

    public void setAcessaConteudoImproprio(boolean acessaConteudoImproprio) {
        this.acessaConteudoImproprio = acessaConteudoImproprio;
    }

    public boolean isCompraConteudoImproprio() {
        return compraConteudoImproprio;
    }

    public void setCompraConteudoImproprio(boolean compraConteudoImproprio) {
        this.compraConteudoImproprio = compraConteudoImproprio;
    }

    public boolean isAcessaJogos() {
        return acessaJogos;
    }

    public void setAcessaJogos(boolean acessaJogos) {
        this.acessaJogos = acessaJogos;
    }

    public boolean isCompraJogos() {
        return compraJogos;
    }

    public void setCompraJogos(boolean compraJogos) {
        this.compraJogos = compraJogos;
    }

    @Override
    public String toString() {
        return "SubConta{" + "acessaConteudoImproprio=" + acessaConteudoImproprio + ", compraConteudoImproprio=" + compraConteudoImproprio + ", acessaJogos=" + acessaJogos + ", compraJogos=" + compraJogos + '}';
    }
}
