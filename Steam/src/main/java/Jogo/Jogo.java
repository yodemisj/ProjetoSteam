/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jogo;

import Empresa.Desenvolvedor;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Jogo {
    private String nome;
    private String edicao;
    private String classificacao;
    private String genero;
    private String sinopse;
    private BigDecimal preco;
    private ArrayList<Legenda> legendas;
    private ArrayList<Linguagem> linguagens;
    private Desenvolvedor desenvolvedor;

    public Jogo() {
        desenvolvedor = new Desenvolvedor();
    }

    public Jogo(String nome, String edicao, String classificacao, String genero, String sinopse, BigDecimal preco, Desenvolvedor desenvolvedor) {
        this.nome = nome;
        this.edicao = edicao;
        this.classificacao = classificacao;
        this.genero = genero;
        this.sinopse = sinopse;
        this.preco = preco;
        this.desenvolvedor = desenvolvedor;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ArrayList<Legenda> getLegendas() {
        return legendas;
    }

    public void setLegendas(ArrayList<Legenda> legendas) {
        this.legendas = legendas;
    }

    public ArrayList<Linguagem> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(ArrayList<Linguagem> linguagens) {
        this.linguagens = linguagens;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    @Override
    public String toString() {
        return "Jogo{" + "nome=" + nome + ", edicao=" + edicao + ", classificacao=" + classificacao + ", genero=" + genero + ", sinopse=" + sinopse + ", preco=" + preco + ", legendas=" + legendas + ", linguagens=" + linguagens + ", desenvolvedor=" + desenvolvedor + '}';
    }
}
