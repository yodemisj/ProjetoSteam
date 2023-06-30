/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conta;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ContaPrincipal extends Conta{
    
    private ArrayList<SubConta> subContas;
    private CartaoDeCredito cartaoDeCredito;
    private Usuario usuario;
    
    public ContaPrincipal() {
        cartaoDeCredito = new CartaoDeCredito();
        subContas = new ArrayList<>();
        usuario = new Usuario();
    }

    public ArrayList<SubConta> getSubContas() {
        return subContas;
    }

    public void setSubContas(ArrayList<SubConta> subContas) {
        this.subContas = subContas;
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "ContaPrincipal{" + "subContas=" + subContas + ", cartaoDeCredito=" + cartaoDeCredito + ", usuario=" + usuario + '}';
    }
}
