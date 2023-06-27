/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empresa;

import Sede.Sede;
import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Empresa {
    private String nome;
    private String presidente;
    private String fundador;
    private Date dataFundacao;
    private String webSite;
    
    private Sede sede;
    
    
    public Empresa() {
        sede = new Sede();
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + ", presidente=" + presidente + ", fundador=" + fundador + ", dataFundacao=" + dataFundacao + ", webSite=" + webSite + '}';
    }
}
